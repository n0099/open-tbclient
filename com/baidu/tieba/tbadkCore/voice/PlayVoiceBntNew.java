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
    private View.OnClickListener aBz;
    private VoiceManager dBD;
    private ImageView eTE;
    private VoiceData.VoiceModel eTI;
    private TextView hhI;
    private RelativeLayout hhJ;
    private AudioAnimationView hhK;
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
        if (this.hhI != null) {
            this.hhI.setTextSize(0, l.h(getContext(), i));
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
        this.hhJ = (RelativeLayout) findViewById(e.g.voice_image_content);
        this.hhJ.setOnClickListener(this);
        this.eTE = (ImageView) findViewById(e.g.playingImg);
        this.hhI = (TextView) findViewById(e.g.playTime);
        this.hhI.setPadding(l.h(getContext(), e.C0200e.ds8), 0 - l.h(getContext(), e.C0200e.ds6), 0, 0);
        this.hhK = (AudioAnimationView) findViewById(e.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bCD();
    }

    private void bCD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.hhJ, e.f.btn_audio_frame_n);
        al.c(this.hhI, e.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bCG();
            this.eTE.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hhK.onChangeSkinType(skinType);
    }

    private void bCG() {
        if (this.eTE != null) {
            if (bCF()) {
                al.c(this.eTE, e.f.icon_voice_stop);
            } else {
                al.c(this.eTE, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eTI = voiceModel;
        if (this.eTI != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qb(this.eTI.elapse);
                return;
            }
            qc(this.eTI.voice_status.intValue());
            this.hhK.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hhK.pU();
            this.hhI.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qb(int i) {
        String formatVoiceTime;
        if (this.eTI != null && this.hhI != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eTI.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eTI.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eTI.duration);
            }
            String a = k.a(this.hhI.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hhI.setText(formatVoiceTime);
            }
        }
    }

    public void qc(int i) {
        this.hhK.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nw(true);
            this.hhK.start();
            return;
        }
        this.hhK.pU();
        nw(false);
        if (i == 1) {
            if (this.eTI != null) {
                this.hhI.setText(VoiceManager.formatVoiceTime(this.eTI.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eTI != null) {
                this.hhI.setText(VoiceManager.formatVoiceTime(this.eTI.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eTI != null && view == this.hhJ) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aBz != null) {
                this.aBz.onClick(this);
            }
            TiebaStatic.log(this.eTI.from);
        }
    }

    public void aKF() {
        VoiceManager voiceManager;
        if (this.eTI != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void nw(boolean z) {
        if (this.eTE != null) {
            if (z) {
                al.c(this.eTE, e.f.icon_voice_stop);
            } else {
                al.c(this.eTE, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dBD = voiceManager;
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
        return this.dBD;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.RQ();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.RP() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.FC();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.RP();
            setVoiceModel(voiceModel);
            bCD();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eTI != voiceModel) {
                qc(1);
            } else {
                qc(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (!bCF()) {
            qc(1);
            return;
        }
        qb(i);
        if (this.eTI != null) {
            this.eTI.elapse = i;
        }
    }

    private boolean bCF() {
        if (this.eTI == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eTI);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eTI;
    }

    public void aUo() {
        bCD();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eTI);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eTI);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qa() {
    }

    public void reset() {
        this.eTI = null;
        setTag(null);
        qc(1);
    }

    public void bCH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hhK.getLayoutParams();
        layoutParams.width = -2;
        this.hhK.setLayoutParams(layoutParams);
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
        this.aBz = onClickListener;
    }
}
