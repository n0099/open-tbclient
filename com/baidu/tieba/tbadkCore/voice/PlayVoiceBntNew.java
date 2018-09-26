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
    private View.OnClickListener avZ;
    private VoiceManager dsk;
    private ImageView eKC;
    private VoiceData.VoiceModel eKG;
    private TextView gYR;
    private RelativeLayout gYS;
    private AudioAnimationView gYT;
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
        if (this.gYR != null) {
            this.gYR.setTextSize(0, l.h(getContext(), i));
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
        this.gYS = (RelativeLayout) findViewById(e.g.voice_image_content);
        this.gYS.setOnClickListener(this);
        this.eKC = (ImageView) findViewById(e.g.playingImg);
        this.gYR = (TextView) findViewById(e.g.playTime);
        this.gYR.setPadding(l.h(getContext(), e.C0141e.ds8), 0 - l.h(getContext(), e.C0141e.ds6), 0, 0);
        this.gYT = (AudioAnimationView) findViewById(e.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bzU();
    }

    private void bzU() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.gYS, e.f.btn_audio_frame_n);
        al.c(this.gYR, e.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bzX();
            this.eKC.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gYT.onChangeSkinType(skinType);
    }

    private void bzX() {
        if (this.eKC != null) {
            if (bzW()) {
                al.c(this.eKC, e.f.icon_voice_stop);
            } else {
                al.c(this.eKC, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eKG = voiceModel;
        if (this.eKG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                pk(this.eKG.elapse);
                return;
            }
            pl(this.eKG.voice_status.intValue());
            this.gYT.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gYT.pP();
            this.gYR.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void pk(int i) {
        String formatVoiceTime;
        if (this.eKG != null && this.gYR != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eKG.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKG.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKG.duration);
            }
            String a = k.a(this.gYR.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gYR.setText(formatVoiceTime);
            }
        }
    }

    public void pl(int i) {
        this.gYT.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mU(true);
            this.gYT.start();
            return;
        }
        this.gYT.pP();
        mU(false);
        if (i == 1) {
            if (this.eKG != null) {
                this.gYR.setText(VoiceManager.formatVoiceTime(this.eKG.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eKG != null) {
                this.gYR.setText(VoiceManager.formatVoiceTime(this.eKG.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eKG != null && view == this.gYS) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.avZ != null) {
                this.avZ.onClick(this);
            }
            TiebaStatic.log(this.eKG.from);
        }
    }

    public void aHP() {
        VoiceManager voiceManager;
        if (this.eKG != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mU(boolean z) {
        if (this.eKC != null) {
            if (z) {
                al.c(this.eKC, e.f.icon_voice_stop);
            } else {
                al.c(this.eKC, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dsk = voiceManager;
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
        return this.dsk;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.PM();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.PL() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Dp();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.I(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.PL();
            setVoiceModel(voiceModel);
            bzU();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eKG != voiceModel) {
                pl(1);
            } else {
                pl(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (!bzW()) {
            pl(1);
            return;
        }
        pk(i);
        if (this.eKG != null) {
            this.eKG.elapse = i;
        }
    }

    private boolean bzW() {
        if (this.eKG == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eKG);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eKG;
    }

    public void aRD() {
        bzU();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eKG);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eKG);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pV() {
    }

    public void reset() {
        this.eKG = null;
        setTag(null);
        pl(1);
    }

    public void bzY() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gYT.getLayoutParams();
        layoutParams.width = -2;
        this.gYT.setLayoutParams(layoutParams);
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
        this.avZ = onClickListener;
    }
}
