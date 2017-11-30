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
    private VoiceManager cGZ;
    private ImageView dVg;
    private VoiceData.VoiceModel dVk;
    private TextView gCr;
    private RelativeLayout gCt;
    private AudioAnimationView gCu;
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
        if (this.gCr != null) {
            this.gCr.setTextSize(0, l.f(getContext(), i));
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
        this.gCt = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gCt.setOnClickListener(this);
        this.dVg = (ImageView) findViewById(d.g.playingImg);
        this.gCr = (TextView) findViewById(d.g.playTime);
        this.gCr.setPadding(l.f(getContext(), d.e.ds8), 0 - l.f(getContext(), d.e.ds6), 0, 0);
        this.gCu = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxr();
    }

    private void bxr() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.gCt, d.f.btn_audio_frame_n);
        aj.c(this.gCr, d.C0082d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bxu();
            this.dVg.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gCu.onChangeSkinType(skinType);
    }

    private void bxu() {
        if (this.dVg != null) {
            if (bxt()) {
                aj.c(this.dVg, d.f.icon_voice_stop);
            } else {
                aj.c(this.dVg, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dVk = voiceModel;
        if (this.dVk != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nL(this.dVk.elapse);
                return;
            }
            nM(this.dVk.voice_status.intValue());
            this.gCu.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gCu.lK();
            this.gCr.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nL(int i) {
        String formatVoiceTime;
        if (this.dVk != null && this.gCr != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dVk.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dVk.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dVk.duration);
            }
            String a = k.a(this.gCr.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gCr.setText(formatVoiceTime);
            }
        }
    }

    public void nM(int i) {
        this.gCu.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nf(true);
            this.gCu.start();
            return;
        }
        this.gCu.lK();
        nf(false);
        if (i == 1) {
            if (this.dVk != null) {
                this.gCr.setText(VoiceManager.formatVoiceTime(this.dVk.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dVk != null) {
                this.gCr.setText(VoiceManager.formatVoiceTime(this.dVk.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dVk != null && view == this.gCt) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajN != null) {
                this.ajN.onClick(this);
            }
            TiebaStatic.log(this.dVk.from);
        }
    }

    private void nf(boolean z) {
        if (this.dVg != null) {
            if (z) {
                aj.c(this.dVg, d.f.icon_voice_stop);
            } else {
                aj.c(this.dVg, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cGZ = voiceManager;
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
        return this.cGZ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Kk();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Kj() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xU();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Kj();
            setVoiceModel(voiceModel);
            bxr();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dVk != voiceModel) {
                nM(1);
            } else {
                nM(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bxt()) {
            nM(1);
            return;
        }
        nL(i);
        if (this.dVk != null) {
            this.dVk.elapse = i;
        }
    }

    private boolean bxt() {
        if (this.dVk == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dVk);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dVk;
    }

    public void blz() {
        bxr();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dVk);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dVk);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void reset() {
        this.dVk = null;
        setTag(null);
        nM(1);
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
