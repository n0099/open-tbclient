package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener ajK;
    private VoiceManager cHh;
    private ImageView dWl;
    private VoiceData.VoiceModel dWp;
    private TextView gFa;
    private RelativeLayout gFc;
    private AudioAnimationView gFd;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.gFa != null) {
            this.gFa.setTextSize(0, l.f(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        ai(context);
        setOnClickListener(this);
    }

    public void ai(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.gFc = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gFc.setOnClickListener(this);
        this.dWl = (ImageView) findViewById(d.g.playingImg);
        this.gFa = (TextView) findViewById(d.g.playTime);
        this.gFa.setPadding(l.f(getContext(), d.e.ds8), 0 - l.f(getContext(), d.e.ds6), 0, 0);
        this.gFd = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxX();
    }

    private void bxX() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.gFc, d.f.btn_audio_frame_n);
        aj.c(this.gFa, d.C0096d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bya();
            this.dWl.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gFd.onChangeSkinType(skinType);
    }

    private void bya() {
        if (this.dWl != null) {
            if (bxZ()) {
                aj.c(this.dWl, d.f.icon_voice_stop);
            } else {
                aj.c(this.dWl, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dWp = voiceModel;
        if (this.dWp != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nS(this.dWp.elapse);
                return;
            }
            nT(this.dWp.voice_status.intValue());
            this.gFd.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gFd.lK();
            this.gFa.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nS(int i) {
        String formatVoiceTime;
        if (this.dWp != null && this.gFa != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dWp.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dWp.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dWp.duration);
            }
            String a = k.a(this.gFa.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gFa.setText(formatVoiceTime);
            }
        }
    }

    public void nT(int i) {
        this.gFd.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nh(true);
            this.gFd.start();
            return;
        }
        this.gFd.lK();
        nh(false);
        if (i == 1) {
            if (this.dWp != null) {
                this.gFa.setText(VoiceManager.formatVoiceTime(this.dWp.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dWp != null) {
                this.gFa.setText(VoiceManager.formatVoiceTime(this.dWp.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dWp != null && view == this.gFc) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajK != null) {
                this.ajK.onClick(this);
            }
            TiebaStatic.log(this.dWp.from);
        }
    }

    private void nh(boolean z) {
        if (this.dWl != null) {
            if (z) {
                aj.c(this.dWl, d.f.icon_voice_stop);
            } else {
                aj.c(this.dWl, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cHh = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.cHh;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Kl();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Kk() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xV();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Kk();
            setVoiceModel(voiceModel);
            bxX();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dWp != voiceModel) {
                nT(1);
            } else {
                nT(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (!bxZ()) {
            nT(1);
            return;
        }
        nS(i);
        if (this.dWp != null) {
            this.dWp.elapse = i;
        }
    }

    private boolean bxZ() {
        if (this.dWp == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dWp);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dWp;
    }

    public void bme() {
        bxX();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dWp);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dWp);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void reset() {
        this.dWp = null;
        setTag(null);
        nT(1);
    }

    private int getAudioVoiceColumnCount() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return 0;
        }
        int i = voiceModel.duration;
        if (i <= 20) {
            return 8;
        }
        if (i <= 60) {
            return 14;
        }
        return 22;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajK = onClickListener;
    }
}
