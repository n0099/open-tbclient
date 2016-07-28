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
import com.baidu.tieba.u;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener abc;
    private VoiceManager bEE;
    private ProgressBar cdm;
    private ImageView daL;
    private VoiceData.VoiceModel daP;
    private TextView fno;
    private RelativeLayout fnq;
    private AudioAnimationView fnr;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fns) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.fno != null) {
            this.fno.setTextSize(0, k.c(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        F(context);
        setOnClickListener(this);
    }

    public void F(Context context) {
        LayoutInflater.from(context).inflate(u.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.fnq = (RelativeLayout) findViewById(u.g.voice_image_content);
        this.fnq.setOnClickListener(this);
        this.daL = (ImageView) findViewById(u.g.playingImg);
        this.fno = (TextView) findViewById(u.g.playTime);
        this.fno.setPadding(k.c(getContext(), u.e.ds6), 0 - k.c(getContext(), u.e.ds6), 0, 0);
        this.fnr = (AudioAnimationView) findViewById(u.g.audioAnimationView);
        this.cdm = (ProgressBar) findViewById(u.g.progress);
        if (this.cdm != null) {
            this.cdm.setVisibility(4);
        }
        this.mContext = context;
        bgG();
    }

    private void bgG() {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        av.k(this.fnq, u.f.btn_audio_frame_n);
        av.c(this.fno, u.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bgK();
            this.daL.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fnr.onChangeSkinType(skinType);
    }

    private void bgK() {
        if (this.daL != null) {
            if (bgI()) {
                av.c(this.daL, u.f.icon_voice_stop);
            } else {
                av.c(this.daL, u.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.daP = voiceModel;
        if (this.daP != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ls(this.daP.elapse);
                return;
            }
            lt(this.daP.voice_status.intValue());
            this.fnr.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fnr.bmz();
            this.fno.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ls(int i) {
        String formatVoiceTime;
        if (this.daP != null && this.fno != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.daP.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.daP.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.daP.duration);
            }
            String a = j.a(this.fno.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fno.setText(formatVoiceTime);
            }
        }
    }

    public void lt(int i) {
        this.fnr.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.cdm.setVisibility(4);
            kA(true);
            this.fnr.start();
            return;
        }
        this.fnr.bmz();
        kA(false);
        if (i == 1) {
            if (this.daP != null) {
                this.fno.setText(VoiceManager.formatVoiceTime(this.daP.duration));
            }
            this.cdm.setVisibility(4);
        } else if (i == 2) {
            if (this.daP != null) {
                this.fno.setText(VoiceManager.formatVoiceTime(this.daP.duration));
            }
            this.cdm.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.daP != null && view == this.fnq) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.abc != null) {
                this.abc.onClick(this);
            }
            TiebaStatic.log(this.daP.from);
        }
    }

    private void kA(boolean z) {
        if (this.daL != null) {
            if (z) {
                av.c(this.daL, u.f.icon_voice_stop);
            } else {
                av.c(this.daL, u.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bEE = voiceManager;
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
        return this.bEE;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.Hu();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.Ht() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.G(voiceModel);
            }
            this.play_type = zVar.Ht();
            setVoiceModel(voiceModel);
            bgG();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.daP != voiceModel) {
                lt(1);
            } else {
                lt(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aF(int i) {
        if (!bgI()) {
            lt(1);
            return;
        }
        ls(i);
        if (this.daP != null) {
            this.daP.elapse = i;
        }
    }

    private boolean bgI() {
        if (this.daP == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.daP);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.daP;
    }

    public void bgJ() {
        bgG();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.daP);
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.daP);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kI() {
    }

    public void reset() {
        this.daP = null;
        setTag(null);
        lt(1);
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
        this.abc = onClickListener;
    }
}
