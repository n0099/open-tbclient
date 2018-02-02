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
    private View.OnClickListener aYd;
    private VoiceManager dBC;
    private ImageView eKo;
    private VoiceData.VoiceModel eKs;
    private TextView hbN;
    private RelativeLayout hbP;
    private AudioAnimationView hbQ;
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
        if (this.hbN != null) {
            this.hbN.setTextSize(0, l.s(getContext(), i));
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
        this.hbP = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.hbP.setOnClickListener(this);
        this.eKo = (ImageView) findViewById(d.g.playingImg);
        this.hbN = (TextView) findViewById(d.g.playTime);
        this.hbN.setPadding(l.s(getContext(), d.e.ds8), 0 - l.s(getContext(), d.e.ds6), 0, 0);
        this.hbQ = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bwN();
    }

    private void bwN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.s(this.hbP, d.f.btn_audio_frame_n);
        aj.e(this.hbN, d.C0108d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bwQ();
            this.eKo.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hbQ.onChangeSkinType(skinType);
    }

    private void bwQ() {
        if (this.eKo != null) {
            if (bwP()) {
                aj.c(this.eKo, d.f.icon_voice_stop);
            } else {
                aj.c(this.eKo, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eKs = voiceModel;
        if (this.eKs != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qD(this.eKs.elapse);
                return;
            }
            qE(this.eKs.voice_status.intValue());
            this.hbQ.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hbQ.to();
            this.hbN.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qD(int i) {
        String formatVoiceTime;
        if (this.eKs != null && this.hbN != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eKs.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKs.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKs.duration);
            }
            String a = k.a(this.hbN.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hbN.setText(formatVoiceTime);
            }
        }
    }

    public void qE(int i) {
        this.hbQ.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mG(true);
            this.hbQ.start();
            return;
        }
        this.hbQ.to();
        mG(false);
        if (i == 1) {
            if (this.eKs != null) {
                this.hbN.setText(VoiceManager.formatVoiceTime(this.eKs.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eKs != null) {
                this.hbN.setText(VoiceManager.formatVoiceTime(this.eKs.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eKs != null && view == this.hbP) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aYd != null) {
                this.aYd.onClick(this);
            }
            TiebaStatic.log(this.eKs.from);
        }
    }

    public void aCG() {
        VoiceManager voiceManager;
        if (this.eKs != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mG(boolean z) {
        if (this.eKo != null) {
            if (z) {
                aj.c(this.eKo, d.f.icon_voice_stop);
            } else {
                aj.c(this.eKo, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dBC = voiceManager;
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
        return this.dBC;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.RA();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Rz() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Fn();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Rz();
            setVoiceModel(voiceModel);
            bwN();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eKs != voiceModel) {
                qE(1);
            } else {
                qE(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (!bwP()) {
            qE(1);
            return;
        }
        qD(i);
        if (this.eKs != null) {
            this.eKs.elapse = i;
        }
    }

    private boolean bwP() {
        if (this.eKs == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eKs);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eKs;
    }

    public void bng() {
        bwN();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eKs);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eKs);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tu() {
    }

    public void reset() {
        this.eKs = null;
        setTag(null);
        qE(1);
    }

    public void bwR() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hbQ.getLayoutParams();
        layoutParams.width = -2;
        this.hbQ.setLayoutParams(layoutParams);
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
        this.aYd = onClickListener;
    }
}
