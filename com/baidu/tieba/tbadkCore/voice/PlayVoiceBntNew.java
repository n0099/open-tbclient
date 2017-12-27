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
    private View.OnClickListener aXW;
    private VoiceManager dwG;
    private ImageView eIt;
    private VoiceData.VoiceModel eIx;
    private TextView hlS;
    private RelativeLayout hlU;
    private AudioAnimationView hlV;
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
        if (this.hlS != null) {
            this.hlS.setTextSize(0, l.s(getContext(), i));
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
        this.hlU = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.hlU.setOnClickListener(this);
        this.eIt = (ImageView) findViewById(d.g.playingImg);
        this.hlS = (TextView) findViewById(d.g.playTime);
        this.hlS.setPadding(l.s(getContext(), d.e.ds8), 0 - l.s(getContext(), d.e.ds6), 0, 0);
        this.hlV = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bDo();
    }

    private void bDo() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.s(this.hlU, d.f.btn_audio_frame_n);
        aj.e(this.hlS, d.C0108d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bDr();
            this.eIt.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hlV.onChangeSkinType(skinType);
    }

    private void bDr() {
        if (this.eIt != null) {
            if (bDq()) {
                aj.c(this.eIt, d.f.icon_voice_stop);
            } else {
                aj.c(this.eIt, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eIx = voiceModel;
        if (this.eIx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qK(this.eIx.elapse);
                return;
            }
            qL(this.eIx.voice_status.intValue());
            this.hlV.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hlV.tn();
            this.hlS.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qK(int i) {
        String formatVoiceTime;
        if (this.eIx != null && this.hlS != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eIx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eIx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eIx.duration);
            }
            String a = k.a(this.hlS.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hlS.setText(formatVoiceTime);
            }
        }
    }

    public void qL(int i) {
        this.hlV.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nB(true);
            this.hlV.start();
            return;
        }
        this.hlV.tn();
        nB(false);
        if (i == 1) {
            if (this.eIx != null) {
                this.hlS.setText(VoiceManager.formatVoiceTime(this.eIx.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eIx != null) {
                this.hlS.setText(VoiceManager.formatVoiceTime(this.eIx.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eIx != null && view == this.hlU) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aXW != null) {
                this.aXW.onClick(this);
            }
            TiebaStatic.log(this.eIx.from);
        }
    }

    public void aCw() {
        VoiceManager voiceManager;
        if (this.eIx != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void nB(boolean z) {
        if (this.eIt != null) {
            if (z) {
                aj.c(this.eIt, d.f.icon_voice_stop);
            } else {
                aj.c(this.eIt, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dwG = voiceManager;
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
        return this.dwG;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.RK();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.RJ() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Fu();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.RJ();
            setVoiceModel(voiceModel);
            bDo();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eIx != voiceModel) {
                qL(1);
            } else {
                qL(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (!bDq()) {
            qL(1);
            return;
        }
        qK(i);
        if (this.eIx != null) {
            this.eIx.elapse = i;
        }
    }

    private boolean bDq() {
        if (this.eIx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eIx);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eIx;
    }

    public void btM() {
        bDo();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eIx);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eIx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.eIx = null;
        setTag(null);
        qL(1);
    }

    public void bDs() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hlV.getLayoutParams();
        layoutParams.width = -2;
        this.hlV.setLayoutParams(layoutParams);
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
        this.aXW = onClickListener;
    }
}
