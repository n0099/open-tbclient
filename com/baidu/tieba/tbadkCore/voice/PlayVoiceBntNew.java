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
    private View.OnClickListener aFa;
    private VoiceManager dKQ;
    private ImageView fdk;
    private VoiceData.VoiceModel fdo;
    private TextView hrO;
    private RelativeLayout hrP;
    private AudioAnimationView hrQ;
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
        if (this.hrO != null) {
            this.hrO.setTextSize(0, l.h(getContext(), i));
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
        this.hrP = (RelativeLayout) findViewById(e.g.voice_image_content);
        this.hrP.setOnClickListener(this);
        this.fdk = (ImageView) findViewById(e.g.playingImg);
        this.hrO = (TextView) findViewById(e.g.playTime);
        this.hrO.setPadding(l.h(getContext(), e.C0210e.ds8), 0 - l.h(getContext(), e.C0210e.ds6), 0, 0);
        this.hrQ = (AudioAnimationView) findViewById(e.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bFp();
    }

    private void bFp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.hrP, e.f.btn_audio_frame_n);
        al.c(this.hrO, e.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bFs();
            this.fdk.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hrQ.onChangeSkinType(skinType);
    }

    private void bFs() {
        if (this.fdk != null) {
            if (bFr()) {
                al.c(this.fdk, e.f.icon_voice_stop);
            } else {
                al.c(this.fdk, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.fdo = voiceModel;
        if (this.fdo != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qI(this.fdo.elapse);
                return;
            }
            qJ(this.fdo.voice_status.intValue());
            this.hrQ.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hrQ.pT();
            this.hrO.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qI(int i) {
        String formatVoiceTime;
        if (this.fdo != null && this.hrO != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.fdo.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fdo.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fdo.duration);
            }
            String a = k.a(this.hrO.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hrO.setText(formatVoiceTime);
            }
        }
    }

    public void qJ(int i) {
        this.hrQ.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nB(true);
            this.hrQ.start();
            return;
        }
        this.hrQ.pT();
        nB(false);
        if (i == 1) {
            if (this.fdo != null) {
                this.hrO.setText(VoiceManager.formatVoiceTime(this.fdo.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.fdo != null) {
                this.hrO.setText(VoiceManager.formatVoiceTime(this.fdo.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fdo != null && view == this.hrP) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aFa != null) {
                this.aFa.onClick(this);
            }
            TiebaStatic.log(this.fdo.from);
        }
    }

    public void aNk() {
        VoiceManager voiceManager;
        if (this.fdo != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void nB(boolean z) {
        if (this.fdk != null) {
            if (z) {
                al.c(this.fdk, e.f.icon_voice_stop);
            } else {
                al.c(this.fdk, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dKQ = voiceManager;
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
        return this.dKQ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.SY();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.SX() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.GH();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.SX();
            setVoiceModel(voiceModel);
            bFp();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.fdo != voiceModel) {
                qJ(1);
            } else {
                qJ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (!bFr()) {
            qJ(1);
            return;
        }
        qI(i);
        if (this.fdo != null) {
            this.fdo.elapse = i;
        }
    }

    private boolean bFr() {
        if (this.fdo == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.fdo);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.fdo;
    }

    public void aWT() {
        bFp();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.fdo);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.fdo);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pZ() {
    }

    public void reset() {
        this.fdo = null;
        setTag(null);
        qJ(1);
    }

    public void bFt() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hrQ.getLayoutParams();
        layoutParams.width = -2;
        this.hrQ.setLayoutParams(layoutParams);
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
        this.aFa = onClickListener;
    }
}
