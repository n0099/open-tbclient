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
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener adX;
    private VoiceManager bQb;
    private ProgressBar coW;
    private ImageView dnQ;
    private VoiceData.VoiceModel dnU;
    private TextView fxP;
    private RelativeLayout fxR;
    private AudioAnimationView fxS;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fxT) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PLAY_TYPE[] valuesCustom() {
            PLAY_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            PLAY_TYPE[] play_typeArr = new PLAY_TYPE[length];
            System.arraycopy(valuesCustom, 0, play_typeArr, 0, length);
            return play_typeArr;
        }
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.fxP != null) {
            this.fxP.setTextSize(0, k.e(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        P(context);
        setOnClickListener(this);
    }

    public void P(Context context) {
        LayoutInflater.from(context).inflate(r.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.fxR = (RelativeLayout) findViewById(r.g.voice_image_content);
        this.fxR.setOnClickListener(this);
        this.dnQ = (ImageView) findViewById(r.g.playingImg);
        this.fxP = (TextView) findViewById(r.g.playTime);
        this.fxP.setPadding(k.e(getContext(), r.e.ds6), 0 - k.e(getContext(), r.e.ds6), 0, 0);
        this.fxS = (AudioAnimationView) findViewById(r.g.audioAnimationView);
        this.coW = (ProgressBar) findViewById(r.g.progress);
        if (this.coW != null) {
            this.coW.setVisibility(4);
        }
        this.mContext = context;
        bkT();
    }

    private void bkT() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        av.k(this.fxR, r.f.btn_audio_frame_n);
        av.c(this.fxP, r.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bkW();
            this.dnQ.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fxS.onChangeSkinType(skinType);
    }

    private void bkW() {
        if (this.dnQ != null) {
            if (bkV()) {
                av.c(this.dnQ, r.f.icon_voice_stop);
            } else {
                av.c(this.dnQ, r.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dnU = voiceModel;
        if (this.dnU != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                md(this.dnU.elapse);
                return;
            }
            me(this.dnU.voice_status.intValue());
            this.fxS.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fxS.bqM();
            this.fxP.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void md(int i) {
        String formatVoiceTime;
        if (this.dnU != null && this.fxP != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dnU.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dnU.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dnU.duration);
            }
            String a = j.a(this.fxP.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fxP.setText(formatVoiceTime);
            }
        }
    }

    public void me(int i) {
        this.fxS.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.coW.setVisibility(4);
            kP(true);
            this.fxS.start();
            return;
        }
        this.fxS.bqM();
        kP(false);
        if (i == 1) {
            if (this.dnU != null) {
                this.fxP.setText(VoiceManager.formatVoiceTime(this.dnU.duration));
            }
            this.coW.setVisibility(4);
        } else if (i == 2) {
            if (this.dnU != null) {
                this.fxP.setText(VoiceManager.formatVoiceTime(this.dnU.duration));
            }
            this.coW.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dnU != null && view == this.fxR) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.adX != null) {
                this.adX.onClick(this);
            }
            TiebaStatic.log(this.dnU.from);
        }
    }

    private void kP(boolean z) {
        if (this.dnQ != null) {
            if (z) {
                av.c(this.dnQ, r.f.icon_voice_stop);
            } else {
                av.c(this.dnQ, r.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bQb = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bQb;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.IT();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.IS() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.G(voiceModel);
            }
            this.play_type = zVar.IS();
            setVoiceModel(voiceModel);
            bkT();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dnU != voiceModel) {
                me(1);
            } else {
                me(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bkV()) {
            me(1);
            return;
        }
        md(i);
        if (this.dnU != null) {
            this.dnU.elapse = i;
        }
    }

    private boolean bkV() {
        if (this.dnU == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dnU);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dnU;
    }

    public void aCk() {
        bkT();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dnU);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dnU);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lD() {
    }

    public void reset() {
        this.dnU = null;
        setTag(null);
        me(1);
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
        this.adX = onClickListener;
    }
}
