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
    private View.OnClickListener aFD;
    private VoiceManager dLA;
    private ImageView fdY;
    private VoiceData.VoiceModel fec;
    private TextView hsX;
    private RelativeLayout hsY;
    private AudioAnimationView hsZ;
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
        if (this.hsX != null) {
            this.hsX.setTextSize(0, l.h(getContext(), i));
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
        this.hsY = (RelativeLayout) findViewById(e.g.voice_image_content);
        this.hsY.setOnClickListener(this);
        this.fdY = (ImageView) findViewById(e.g.playingImg);
        this.hsX = (TextView) findViewById(e.g.playTime);
        this.hsX.setPadding(l.h(getContext(), e.C0210e.ds8), 0 - l.h(getContext(), e.C0210e.ds6), 0, 0);
        this.hsZ = (AudioAnimationView) findViewById(e.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bFY();
    }

    private void bFY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.hsY, e.f.btn_audio_frame_n);
        al.c(this.hsX, e.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bGb();
            this.fdY.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hsZ.onChangeSkinType(skinType);
    }

    private void bGb() {
        if (this.fdY != null) {
            if (bGa()) {
                al.c(this.fdY, e.f.icon_voice_stop);
            } else {
                al.c(this.fdY, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.fec = voiceModel;
        if (this.fec != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qJ(this.fec.elapse);
                return;
            }
            qK(this.fec.voice_status.intValue());
            this.hsZ.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hsZ.pX();
            this.hsX.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qJ(int i) {
        String formatVoiceTime;
        if (this.fec != null && this.hsX != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.fec.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fec.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fec.duration);
            }
            String a = k.a(this.hsX.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hsX.setText(formatVoiceTime);
            }
        }
    }

    public void qK(int i) {
        this.hsZ.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nC(true);
            this.hsZ.start();
            return;
        }
        this.hsZ.pX();
        nC(false);
        if (i == 1) {
            if (this.fec != null) {
                this.hsX.setText(VoiceManager.formatVoiceTime(this.fec.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.fec != null) {
                this.hsX.setText(VoiceManager.formatVoiceTime(this.fec.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fec != null && view == this.hsY) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aFD != null) {
                this.aFD.onClick(this);
            }
            TiebaStatic.log(this.fec.from);
        }
    }

    public void aNK() {
        VoiceManager voiceManager;
        if (this.fec != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void nC(boolean z) {
        if (this.fdY != null) {
            if (z) {
                al.c(this.fdY, e.f.icon_voice_stop);
            } else {
                al.c(this.fdY, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dLA = voiceManager;
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
        return this.dLA;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Tu();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Tt() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.GU();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Tt();
            setVoiceModel(voiceModel);
            bFY();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.fec != voiceModel) {
                qK(1);
            } else {
                qK(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (!bGa()) {
            qK(1);
            return;
        }
        qJ(i);
        if (this.fec != null) {
            this.fec.elapse = i;
        }
    }

    private boolean bGa() {
        if (this.fec == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.fec);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.fec;
    }

    public void aXt() {
        bFY();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.fec);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.fec);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qd() {
    }

    public void reset() {
        this.fec = null;
        setTag(null);
        qK(1);
    }

    public void bGc() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hsZ.getLayoutParams();
        layoutParams.width = -2;
        this.hsZ.setLayoutParams(layoutParams);
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
        this.aFD = onClickListener;
    }
}
