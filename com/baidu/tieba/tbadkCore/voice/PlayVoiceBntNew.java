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
    private View.OnClickListener aiV;
    private VoiceManager cqg;
    private VoiceData.VoiceModel dFD;
    private ImageView dFz;
    private TextView gjG;
    private RelativeLayout gjI;
    private AudioAnimationView gjJ;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.n.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.gjG != null) {
            this.gjG.setTextSize(0, l.f(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        aj(context);
        setOnClickListener(this);
    }

    public void aj(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.gjI = (RelativeLayout) findViewById(d.h.voice_image_content);
        this.gjI.setOnClickListener(this);
        this.dFz = (ImageView) findViewById(d.h.playingImg);
        this.gjG = (TextView) findViewById(d.h.playTime);
        this.gjG.setPadding(l.f(getContext(), d.f.ds8), 0 - l.f(getContext(), d.f.ds6), 0, 0);
        this.gjJ = (AudioAnimationView) findViewById(d.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bsq();
    }

    private void bsq() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.gjI, d.g.btn_audio_frame_n);
        aj.c(this.gjG, d.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            bst();
            this.dFz.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gjJ.onChangeSkinType(skinType);
    }

    private void bst() {
        if (this.dFz != null) {
            if (bss()) {
                aj.c(this.dFz, d.g.icon_voice_stop);
            } else {
                aj.c(this.dFz, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dFD = voiceModel;
        if (this.dFD != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nf(this.dFD.elapse);
                return;
            }
            ng(this.dFD.voice_status.intValue());
            this.gjJ.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gjJ.bxN();
            this.gjG.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nf(int i) {
        String formatVoiceTime;
        if (this.dFD != null && this.gjG != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dFD.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dFD.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dFD.duration);
            }
            String a = k.a(this.gjG.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gjG.setText(formatVoiceTime);
            }
        }
    }

    public void ng(int i) {
        this.gjJ.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mE(true);
            this.gjJ.start();
            return;
        }
        this.gjJ.bxN();
        mE(false);
        if (i == 1) {
            if (this.dFD != null) {
                this.gjG.setText(VoiceManager.formatVoiceTime(this.dFD.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dFD != null) {
                this.gjG.setText(VoiceManager.formatVoiceTime(this.dFD.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dFD != null && view == this.gjI) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiV != null) {
                this.aiV.onClick(this);
            }
            TiebaStatic.log(this.dFD.from);
        }
    }

    private void mE(boolean z) {
        if (this.dFz != null) {
            if (z) {
                aj.c(this.dFz, d.g.icon_voice_stop);
            } else {
                aj.c(this.dFz, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cqg = voiceManager;
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
        return this.cqg;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Js();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Jr() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xE();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Jr();
            setVoiceModel(voiceModel);
            bsq();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dFD != voiceModel) {
                ng(1);
            } else {
                ng(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bss()) {
            ng(1);
            return;
        }
        nf(i);
        if (this.dFD != null) {
            this.dFD.elapse = i;
        }
    }

    private boolean bss() {
        if (this.dFD == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dFD);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dFD;
    }

    public void bgc() {
        bsq();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dFD);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dFD);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    public void reset() {
        this.dFD = null;
        setTag(null);
        ng(1);
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
        this.aiV = onClickListener;
    }
}
