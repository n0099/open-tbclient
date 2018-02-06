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
    private View.OnClickListener aZN;
    private VoiceManager dEw;
    private ImageView eOD;
    private VoiceData.VoiceModel eOH;
    private TextView heb;
    private RelativeLayout hed;
    private AudioAnimationView hee;
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
        if (this.heb != null) {
            this.heb.setTextSize(0, l.t(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        av(context);
        setOnClickListener(this);
    }

    public void av(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.hed = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.hed.setOnClickListener(this);
        this.eOD = (ImageView) findViewById(d.g.playingImg);
        this.heb = (TextView) findViewById(d.g.playTime);
        this.heb.setPadding(l.t(getContext(), d.e.ds8), 0 - l.t(getContext(), d.e.ds6), 0, 0);
        this.hee = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxX();
    }

    private void bxX() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.s(this.hed, d.f.btn_audio_frame_n);
        aj.e(this.heb, d.C0140d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bya();
            this.eOD.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hee.onChangeSkinType(skinType);
    }

    private void bya() {
        if (this.eOD != null) {
            if (bxZ()) {
                aj.c(this.eOD, d.f.icon_voice_stop);
            } else {
                aj.c(this.eOD, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eOH = voiceModel;
        if (this.eOH != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qF(this.eOH.elapse);
                return;
            }
            qG(this.eOH.voice_status.intValue());
            this.hee.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hee.tn();
            this.heb.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qF(int i) {
        String formatVoiceTime;
        if (this.eOH != null && this.heb != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eOH.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eOH.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eOH.duration);
            }
            String a = k.a(this.heb.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.heb.setText(formatVoiceTime);
            }
        }
    }

    public void qG(int i) {
        this.hee.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mN(true);
            this.hee.start();
            return;
        }
        this.hee.tn();
        mN(false);
        if (i == 1) {
            if (this.eOH != null) {
                this.heb.setText(VoiceManager.formatVoiceTime(this.eOH.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eOH != null) {
                this.heb.setText(VoiceManager.formatVoiceTime(this.eOH.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eOH != null && view == this.hed) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aZN != null) {
                this.aZN.onClick(this);
            }
            TiebaStatic.log(this.eOH.from);
        }
    }

    public void aEa() {
        VoiceManager voiceManager;
        if (this.eOH != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mN(boolean z) {
        if (this.eOD != null) {
            if (z) {
                aj.c(this.eOD, d.f.icon_voice_stop);
            } else {
                aj.c(this.eOD, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEw = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dEw;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Se();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Sd() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.FJ();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Sd();
            setVoiceModel(voiceModel);
            bxX();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eOH != voiceModel) {
                qG(1);
            } else {
                qG(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (!bxZ()) {
            qG(1);
            return;
        }
        qF(i);
        if (this.eOH != null) {
            this.eOH.elapse = i;
        }
    }

    private boolean bxZ() {
        if (this.eOH == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eOH);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eOH;
    }

    public void aNR() {
        bxX();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eOH);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eOH);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.eOH = null;
        setTag(null);
        qG(1);
    }

    public void byb() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hee.getLayoutParams();
        layoutParams.width = -2;
        this.hee.setLayoutParams(layoutParams);
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
        this.aZN = onClickListener;
    }
}
