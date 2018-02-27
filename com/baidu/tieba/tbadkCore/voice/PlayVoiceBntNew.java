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
    private View.OnClickListener aZB;
    private VoiceManager dEk;
    private ImageView eOr;
    private VoiceData.VoiceModel eOv;
    private TextView hdM;
    private RelativeLayout hdO;
    private AudioAnimationView hdP;
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
        if (this.hdM != null) {
            this.hdM.setTextSize(0, l.t(getContext(), i));
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
        this.hdO = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.hdO.setOnClickListener(this);
        this.eOr = (ImageView) findViewById(d.g.playingImg);
        this.hdM = (TextView) findViewById(d.g.playTime);
        this.hdM.setPadding(l.t(getContext(), d.e.ds8), 0 - l.t(getContext(), d.e.ds6), 0, 0);
        this.hdP = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxW();
    }

    private void bxW() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.s(this.hdO, d.f.btn_audio_frame_n);
        aj.e(this.hdM, d.C0141d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bxZ();
            this.eOr.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hdP.onChangeSkinType(skinType);
    }

    private void bxZ() {
        if (this.eOr != null) {
            if (bxY()) {
                aj.c(this.eOr, d.f.icon_voice_stop);
            } else {
                aj.c(this.eOr, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eOv = voiceModel;
        if (this.eOv != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qF(this.eOv.elapse);
                return;
            }
            qG(this.eOv.voice_status.intValue());
            this.hdP.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hdP.tn();
            this.hdM.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qF(int i) {
        String formatVoiceTime;
        if (this.eOv != null && this.hdM != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eOv.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eOv.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eOv.duration);
            }
            String a = k.a(this.hdM.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hdM.setText(formatVoiceTime);
            }
        }
    }

    public void qG(int i) {
        this.hdP.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mN(true);
            this.hdP.start();
            return;
        }
        this.hdP.tn();
        mN(false);
        if (i == 1) {
            if (this.eOv != null) {
                this.hdM.setText(VoiceManager.formatVoiceTime(this.eOv.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eOv != null) {
                this.hdM.setText(VoiceManager.formatVoiceTime(this.eOv.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eOv != null && view == this.hdO) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aZB != null) {
                this.aZB.onClick(this);
            }
            TiebaStatic.log(this.eOv.from);
        }
    }

    public void aDZ() {
        VoiceManager voiceManager;
        if (this.eOv != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mN(boolean z) {
        if (this.eOr != null) {
            if (z) {
                aj.c(this.eOr, d.f.icon_voice_stop);
            } else {
                aj.c(this.eOr, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEk = voiceManager;
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
        return this.dEk;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Sd();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Sc() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.FI();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Sc();
            setVoiceModel(voiceModel);
            bxW();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eOv != voiceModel) {
                qG(1);
            } else {
                qG(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (!bxY()) {
            qG(1);
            return;
        }
        qF(i);
        if (this.eOv != null) {
            this.eOv.elapse = i;
        }
    }

    private boolean bxY() {
        if (this.eOv == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eOv);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eOv;
    }

    public void aNQ() {
        bxW();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eOv);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eOv);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.eOv = null;
        setTag(null);
        qG(1);
    }

    public void bya() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hdP.getLayoutParams();
        layoutParams.width = -2;
        this.hdP.setLayoutParams(layoutParams);
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
        this.aZB = onClickListener;
    }
}
