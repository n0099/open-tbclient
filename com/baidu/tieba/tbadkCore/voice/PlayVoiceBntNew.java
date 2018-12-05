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
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aEZ;
    private VoiceManager dIc;
    private ImageView fat;
    private VoiceData.VoiceModel fax;
    private TextView hoC;
    private RelativeLayout hoD;
    private AudioAnimationView hoE;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(e.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.hoC != null) {
            this.hoC.setTextSize(0, l.h(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(e.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.hoD = (RelativeLayout) findViewById(e.g.voice_image_content);
        this.hoD.setOnClickListener(this);
        this.fat = (ImageView) findViewById(e.g.playingImg);
        this.hoC = (TextView) findViewById(e.g.playTime);
        this.hoC.setPadding(l.h(getContext(), e.C0210e.ds8), 0 - l.h(getContext(), e.C0210e.ds6), 0, 0);
        this.hoE = (AudioAnimationView) findViewById(e.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bEy();
    }

    private void bEy() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.hoD, e.f.btn_audio_frame_n);
        al.c(this.hoC, e.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bEB();
            this.fat.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hoE.onChangeSkinType(skinType);
    }

    private void bEB() {
        if (this.fat != null) {
            if (bEA()) {
                al.c(this.fat, e.f.icon_voice_stop);
            } else {
                al.c(this.fat, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.fax = voiceModel;
        if (this.fax != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qv(this.fax.elapse);
                return;
            }
            qw(this.fax.voice_status.intValue());
            this.hoE.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hoE.pT();
            this.hoC.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qv(int i) {
        String formatVoiceTime;
        if (this.fax != null && this.hoC != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.fax.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fax.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fax.duration);
            }
            String a = k.a(this.hoC.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hoC.setText(formatVoiceTime);
            }
        }
    }

    public void qw(int i) {
        this.hoE.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            ny(true);
            this.hoE.start();
            return;
        }
        this.hoE.pT();
        ny(false);
        if (i == 1) {
            if (this.fax != null) {
                this.hoC.setText(VoiceManager.formatVoiceTime(this.fax.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.fax != null) {
                this.hoC.setText(VoiceManager.formatVoiceTime(this.fax.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fax != null && view == this.hoD) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aEZ != null) {
                this.aEZ.onClick(this);
            }
            TiebaStatic.log(this.fax.from);
        }
    }

    public void aMx() {
        VoiceManager voiceManager;
        if (this.fax != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void ny(boolean z) {
        if (this.fat != null) {
            if (z) {
                al.c(this.fat, e.f.icon_voice_stop);
            } else {
                al.c(this.fat, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dIc = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dIc;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.SW();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.SV() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.GG();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.SV();
            setVoiceModel(voiceModel);
            bEy();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.fax != voiceModel) {
                qw(1);
            } else {
                qw(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (!bEA()) {
            qw(1);
            return;
        }
        qv(i);
        if (this.fax != null) {
            this.fax.elapse = i;
        }
    }

    private boolean bEA() {
        if (this.fax == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.fax);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.fax;
    }

    public void aWg() {
        bEy();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.fax);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.fax);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pZ() {
    }

    public void reset() {
        this.fax = null;
        setTag(null);
        qw(1);
    }

    public void bEC() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hoE.getLayoutParams();
        layoutParams.width = -2;
        this.hoE.setLayoutParams(layoutParams);
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
        this.aEZ = onClickListener;
    }
}
