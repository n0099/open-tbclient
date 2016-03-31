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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.x;
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar aQj;
    private View.OnClickListener aeD;
    private VoiceManager bja;
    private ImageView crC;
    private VoiceData.VoiceModel crG;
    private TextView esl;
    private RelativeLayout esn;
    private AudioAnimationView eso;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (esp) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        G(context);
        setOnClickListener(this);
    }

    public void G(Context context) {
        LayoutInflater.from(context).inflate(t.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.esn = (RelativeLayout) findViewById(t.g.voice_image_content);
        this.esn.setOnClickListener(this);
        this.crC = (ImageView) findViewById(t.g.playingImg);
        this.esl = (TextView) findViewById(t.g.playTime);
        this.esl.setPadding(k.c(getContext(), t.e.ds6), 0 - k.c(getContext(), t.e.ds6), 0, 0);
        this.eso = (AudioAnimationView) findViewById(t.g.audioAnimationView);
        this.aQj = (ProgressBar) findViewById(t.g.progress);
        if (this.aQj != null) {
            this.aQj.setVisibility(4);
        }
        this.mContext = context;
        aUz();
    }

    private void aUz() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        at.k(this.esn, t.f.btn_audio_frame_n);
        at.b(this.esl, t.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            aUD();
            this.crC.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.eso.onChangeSkinType(skinType);
    }

    private void aUD() {
        if (this.crC != null) {
            if (aUB()) {
                at.c(this.crC, t.f.icon_voice_stop);
            } else {
                at.c(this.crC, t.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.crG = voiceModel;
        if (this.crG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                kg(this.crG.elapse);
                return;
            }
            kh(this.crG.voice_status.intValue());
            this.eso.setCertainColumnCount(getAudioVoiceColumnCount());
            this.eso.aYB();
            this.esl.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void kg(int i) {
        String formatVoiceTime;
        if (this.crG != null && this.esl != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.crG.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.crG.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.crG.duration);
            }
            String a = j.a(this.esl.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.esl.setText(formatVoiceTime);
            }
        }
    }

    public void kh(int i) {
        if (i == 3) {
            this.aQj.setVisibility(4);
            iM(true);
            this.eso.start();
            return;
        }
        this.eso.aYB();
        iM(false);
        if (i == 1) {
            if (this.crG != null) {
                this.esl.setText(VoiceManager.formatVoiceTime(this.crG.duration));
            }
            this.aQj.setVisibility(4);
        } else if (i == 2) {
            if (this.crG != null) {
                this.esl.setText(VoiceManager.formatVoiceTime(this.crG.duration));
            }
            this.aQj.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.crG != null && view == this.esn) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aeD != null) {
                this.aeD.onClick(this);
            }
            TiebaStatic.log(this.crG.from);
        }
    }

    private void iM(boolean z) {
        if (this.crC != null) {
            if (z) {
                at.c(this.crC, t.f.icon_voice_stop);
            } else {
                at.c(this.crC, t.f.icon_voice_paly);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bja = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bja;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof x)) {
            x xVar = (x) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) xVar.Jd();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (xVar.Jc() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = xVar.getMd5();
                voiceModel.duration = xVar.getDuration();
                xVar.D(voiceModel);
            }
            this.play_type = xVar.Jc();
            setVoiceModel(voiceModel);
            aUz();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.crG != voiceModel) {
                kh(1);
            } else {
                kh(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (!aUB()) {
            kh(1);
            return;
        }
        kg(i);
        if (this.crG != null) {
            this.crG.elapse = i;
        }
    }

    private boolean aUB() {
        if (this.crG == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.crG);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.l(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.crG;
    }

    public void aUC() {
        aUz();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.crG);
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.crG);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ow() {
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
        this.aeD = onClickListener;
    }
}
