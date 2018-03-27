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
    private View.OnClickListener aZD;
    private VoiceManager dEn;
    private VoiceData.VoiceModel dYQ;
    private ImageView eOH;
    private TextView hek;
    private RelativeLayout hem;
    private AudioAnimationView hen;
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
        if (this.hek != null) {
            this.hek.setTextSize(0, l.t(getContext(), i));
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
        this.hem = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.hem.setOnClickListener(this);
        this.eOH = (ImageView) findViewById(d.g.playingImg);
        this.hek = (TextView) findViewById(d.g.playTime);
        this.hek.setPadding(l.t(getContext(), d.e.ds8), 0 - l.t(getContext(), d.e.ds6), 0, 0);
        this.hen = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        byb();
    }

    private void byb() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.s(this.hem, d.f.btn_audio_frame_n);
        aj.e(this.hek, d.C0141d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bye();
            this.eOH.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hen.onChangeSkinType(skinType);
    }

    private void bye() {
        if (this.eOH != null) {
            if (byd()) {
                aj.c(this.eOH, d.f.icon_voice_stop);
            } else {
                aj.c(this.eOH, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dYQ = voiceModel;
        if (this.dYQ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qG(this.dYQ.elapse);
                return;
            }
            of(this.dYQ.voice_status.intValue());
            this.hen.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hen.tn();
            this.hek.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qG(int i) {
        String formatVoiceTime;
        if (this.dYQ != null && this.hek != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dYQ.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dYQ.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dYQ.duration);
            }
            String a = k.a(this.hek.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hek.setText(formatVoiceTime);
            }
        }
    }

    public void of(int i) {
        this.hen.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mS(true);
            this.hen.start();
            return;
        }
        this.hen.tn();
        mS(false);
        if (i == 1) {
            if (this.dYQ != null) {
                this.hek.setText(VoiceManager.formatVoiceTime(this.dYQ.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dYQ != null) {
                this.hek.setText(VoiceManager.formatVoiceTime(this.dYQ.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dYQ != null && view == this.hem) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aZD != null) {
                this.aZD.onClick(this);
            }
            TiebaStatic.log(this.dYQ.from);
        }
    }

    public void aEa() {
        VoiceManager voiceManager;
        if (this.dYQ != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mS(boolean z) {
        if (this.eOH != null) {
            if (z) {
                aj.c(this.eOH, d.f.icon_voice_stop);
            } else {
                aj.c(this.eOH, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEn = voiceManager;
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
        return this.dEn;
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
            byb();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dYQ != voiceModel) {
                of(1);
            } else {
                of(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (!byd()) {
            of(1);
            return;
        }
        qG(i);
        if (this.dYQ != null) {
            this.dYQ.elapse = i;
        }
    }

    private boolean byd() {
        if (this.dYQ == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dYQ);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dYQ;
    }

    public void aNR() {
        byb();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dYQ);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dYQ);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.dYQ = null;
        setTag(null);
        of(1);
    }

    public void byf() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hen.getLayoutParams();
        layoutParams.width = -2;
        this.hen.setLayoutParams(layoutParams);
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
        this.aZD = onClickListener;
    }
}
