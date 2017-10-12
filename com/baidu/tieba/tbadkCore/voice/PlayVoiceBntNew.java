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
    private View.OnClickListener ajh;
    private VoiceManager cqs;
    private ImageView dFN;
    private VoiceData.VoiceModel dFR;
    private TextView gjU;
    private RelativeLayout gjW;
    private AudioAnimationView gjX;
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
        if (this.gjU != null) {
            this.gjU.setTextSize(0, l.f(getContext(), i));
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
        this.gjW = (RelativeLayout) findViewById(d.h.voice_image_content);
        this.gjW.setOnClickListener(this);
        this.dFN = (ImageView) findViewById(d.h.playingImg);
        this.gjU = (TextView) findViewById(d.h.playTime);
        this.gjU.setPadding(l.f(getContext(), d.f.ds8), 0 - l.f(getContext(), d.f.ds6), 0, 0);
        this.gjX = (AudioAnimationView) findViewById(d.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bsy();
    }

    private void bsy() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.gjW, d.g.btn_audio_frame_n);
        aj.c(this.gjU, d.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            bsB();
            this.dFN.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gjX.onChangeSkinType(skinType);
    }

    private void bsB() {
        if (this.dFN != null) {
            if (bsA()) {
                aj.c(this.dFN, d.g.icon_voice_stop);
            } else {
                aj.c(this.dFN, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dFR = voiceModel;
        if (this.dFR != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ng(this.dFR.elapse);
                return;
            }
            nh(this.dFR.voice_status.intValue());
            this.gjX.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gjX.bxV();
            this.gjU.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ng(int i) {
        String formatVoiceTime;
        if (this.dFR != null && this.gjU != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dFR.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dFR.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dFR.duration);
            }
            String a = k.a(this.gjU.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gjU.setText(formatVoiceTime);
            }
        }
    }

    public void nh(int i) {
        this.gjX.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mF(true);
            this.gjX.start();
            return;
        }
        this.gjX.bxV();
        mF(false);
        if (i == 1) {
            if (this.dFR != null) {
                this.gjU.setText(VoiceManager.formatVoiceTime(this.dFR.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dFR != null) {
                this.gjU.setText(VoiceManager.formatVoiceTime(this.dFR.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dFR != null && view == this.gjW) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajh != null) {
                this.ajh.onClick(this);
            }
            TiebaStatic.log(this.dFR.from);
        }
    }

    private void mF(boolean z) {
        if (this.dFN != null) {
            if (z) {
                aj.c(this.dFN, d.g.icon_voice_stop);
            } else {
                aj.c(this.dFN, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cqs = voiceManager;
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
        return this.cqs;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Jy();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Jx() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xL();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Jx();
            setVoiceModel(voiceModel);
            bsy();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dFR != voiceModel) {
                nh(1);
            } else {
                nh(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bsA()) {
            nh(1);
            return;
        }
        ng(i);
        if (this.dFR != null) {
            this.dFR.elapse = i;
        }
    }

    private boolean bsA() {
        if (this.dFR == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dFR);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dFR;
    }

    public void bgh() {
        bsy();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dFR);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dFR);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    public void reset() {
        this.dFR = null;
        setTag(null);
        nh(1);
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
        this.ajh = onClickListener;
    }
}
