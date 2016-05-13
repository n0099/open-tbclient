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
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aac;
    private ProgressBar bDI;
    private VoiceManager beZ;
    private VoiceData.VoiceModel csD;
    private ImageView csz;
    private TextView evu;
    private RelativeLayout evw;
    private AudioAnimationView evx;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (evy) with 'values()' method */
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

    public void setPlayTimeTextView(int i) {
        if (this.evu != null) {
            this.evu.setTextSize(0, k.c(getContext(), i));
        }
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
        this.evw = (RelativeLayout) findViewById(t.g.voice_image_content);
        this.evw.setOnClickListener(this);
        this.csz = (ImageView) findViewById(t.g.playingImg);
        this.evu = (TextView) findViewById(t.g.playTime);
        this.evu.setPadding(k.c(getContext(), t.e.ds6), 0 - k.c(getContext(), t.e.ds6), 0, 0);
        this.evx = (AudioAnimationView) findViewById(t.g.audioAnimationView);
        this.bDI = (ProgressBar) findViewById(t.g.progress);
        if (this.bDI != null) {
            this.bDI.setVisibility(4);
        }
        this.mContext = context;
        aVa();
    }

    private void aVa() {
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        at.k(this.evw, t.f.btn_audio_frame_n);
        at.c(this.evu, t.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            aVe();
            this.csz.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.evx.onChangeSkinType(skinType);
    }

    private void aVe() {
        if (this.csz != null) {
            if (aVc()) {
                at.c(this.csz, t.f.icon_voice_stop);
            } else {
                at.c(this.csz, t.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.csD = voiceModel;
        if (this.csD != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                jK(this.csD.elapse);
                return;
            }
            jL(this.csD.voice_status.intValue());
            this.evx.setCertainColumnCount(getAudioVoiceColumnCount());
            this.evx.baZ();
            this.evu.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void jK(int i) {
        String formatVoiceTime;
        if (this.csD != null && this.evu != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.csD.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.csD.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.csD.duration);
            }
            String a = j.a(this.evu.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.evu.setText(formatVoiceTime);
            }
        }
    }

    public void jL(int i) {
        if (i == 3) {
            this.bDI.setVisibility(4);
            jB(true);
            this.evx.start();
            return;
        }
        this.evx.setCertainColumnCount(getAudioVoiceColumnCount());
        this.evx.baZ();
        jB(false);
        if (i == 1) {
            if (this.csD != null) {
                this.evu.setText(VoiceManager.formatVoiceTime(this.csD.duration));
            }
            this.bDI.setVisibility(4);
        } else if (i == 2) {
            if (this.csD != null) {
                this.evu.setText(VoiceManager.formatVoiceTime(this.csD.duration));
            }
            this.bDI.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.csD != null && view == this.evw) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aac != null) {
                this.aac.onClick(this);
            }
            TiebaStatic.log(this.csD.from);
        }
    }

    private void jB(boolean z) {
        if (this.csz != null) {
            if (z) {
                at.c(this.csz, t.f.icon_voice_stop);
            } else {
                at.c(this.csz, t.f.icon_voice_paly);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.beZ = voiceManager;
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
        return this.beZ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.Hv();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.Hu() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.D(voiceModel);
            }
            this.play_type = zVar.Hu();
            setVoiceModel(voiceModel);
            aVa();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.csD != voiceModel) {
                jL(1);
            } else {
                jL(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aB(int i) {
        if (!aVc()) {
            jL(1);
            return;
        }
        jK(i);
        if (this.csD != null) {
            this.csD.elapse = i;
        }
    }

    private boolean aVc() {
        if (this.csD == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.csD);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.l(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.csD;
    }

    public void aVd() {
        aVa();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.csD);
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.csD);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kJ() {
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
        this.aac = onClickListener;
    }
}
