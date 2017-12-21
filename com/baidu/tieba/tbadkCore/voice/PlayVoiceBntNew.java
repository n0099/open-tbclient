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
    private View.OnClickListener ajN;
    private VoiceManager cHl;
    private ImageView dWp;
    private VoiceData.VoiceModel dWt;
    private TextView gFf;
    private RelativeLayout gFh;
    private AudioAnimationView gFi;
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
        if (this.gFf != null) {
            this.gFf.setTextSize(0, l.f(getContext(), i));
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
        this.gFh = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gFh.setOnClickListener(this);
        this.dWp = (ImageView) findViewById(d.g.playingImg);
        this.gFf = (TextView) findViewById(d.g.playTime);
        this.gFf.setPadding(l.f(getContext(), d.e.ds8), 0 - l.f(getContext(), d.e.ds6), 0, 0);
        this.gFi = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxY();
    }

    private void bxY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.gFh, d.f.btn_audio_frame_n);
        aj.c(this.gFf, d.C0095d.cp_cont_f, 1);
        if (this.play_type == 0) {
            byb();
            this.dWp.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gFi.onChangeSkinType(skinType);
    }

    private void byb() {
        if (this.dWp != null) {
            if (bya()) {
                aj.c(this.dWp, d.f.icon_voice_stop);
            } else {
                aj.c(this.dWp, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dWt = voiceModel;
        if (this.dWt != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nS(this.dWt.elapse);
                return;
            }
            nT(this.dWt.voice_status.intValue());
            this.gFi.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gFi.lK();
            this.gFf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nS(int i) {
        String formatVoiceTime;
        if (this.dWt != null && this.gFf != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dWt.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dWt.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dWt.duration);
            }
            String a = k.a(this.gFf.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gFf.setText(formatVoiceTime);
            }
        }
    }

    public void nT(int i) {
        this.gFi.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nh(true);
            this.gFi.start();
            return;
        }
        this.gFi.lK();
        nh(false);
        if (i == 1) {
            if (this.dWt != null) {
                this.gFf.setText(VoiceManager.formatVoiceTime(this.dWt.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dWt != null) {
                this.gFf.setText(VoiceManager.formatVoiceTime(this.dWt.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dWt != null && view == this.gFh) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajN != null) {
                this.ajN.onClick(this);
            }
            TiebaStatic.log(this.dWt.from);
        }
    }

    private void nh(boolean z) {
        if (this.dWp != null) {
            if (z) {
                aj.c(this.dWp, d.f.icon_voice_stop);
            } else {
                aj.c(this.dWp, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cHl = voiceManager;
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
        return this.cHl;
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
            bxY();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dWt != voiceModel) {
                nT(1);
            } else {
                nT(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (!bya()) {
            nT(1);
            return;
        }
        nS(i);
        if (this.dWt != null) {
            this.dWt.elapse = i;
        }
    }

    private boolean bya() {
        if (this.dWt == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dWt);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dWt;
    }

    public void bmf() {
        bxY();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dWt);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dWt);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void reset() {
        this.dWt = null;
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
        this.ajN = onClickListener;
    }
}
