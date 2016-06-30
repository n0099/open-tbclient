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
    private View.OnClickListener aat;
    private VoiceManager bBm;
    private ImageView cXO;
    private VoiceData.VoiceModel cXS;
    private ProgressBar cbl;
    private TextView fak;
    private RelativeLayout fam;
    private AudioAnimationView fan;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fao) with 'values()' method */
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
        if (this.fak != null) {
            this.fak.setTextSize(0, k.c(getContext(), i));
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
        this.fam = (RelativeLayout) findViewById(u.g.voice_image_content);
        this.fam.setOnClickListener(this);
        this.cXO = (ImageView) findViewById(u.g.playingImg);
        this.fak = (TextView) findViewById(u.g.playTime);
        this.fak.setPadding(k.c(getContext(), u.e.ds6), 0 - k.c(getContext(), u.e.ds6), 0, 0);
        this.fan = (AudioAnimationView) findViewById(u.g.audioAnimationView);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
        if (this.cbl != null) {
            this.cbl.setVisibility(4);
        }
        this.mContext = context;
        bdo();
    }

    private void bdo() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        av.k(this.fam, u.f.btn_audio_frame_n);
        av.c(this.fak, u.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bds();
            this.cXO.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fan.onChangeSkinType(skinType);
    }

    private void bds() {
        if (this.cXO != null) {
            if (bdq()) {
                av.c(this.cXO, u.f.icon_voice_stop);
            } else {
                av.c(this.cXO, u.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.cXS = voiceModel;
        if (this.cXS != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lm(this.cXS.elapse);
                return;
            }
            ln(this.cXS.voice_status.intValue());
            this.fan.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fan.bjm();
            this.fak.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lm(int i) {
        String formatVoiceTime;
        if (this.cXS != null && this.fak != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.cXS.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cXS.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cXS.duration);
            }
            String a = j.a(this.fak.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fak.setText(formatVoiceTime);
            }
        }
    }

    public void ln(int i) {
        this.fan.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.cbl.setVisibility(4);
            km(true);
            this.fan.start();
            return;
        }
        this.fan.bjm();
        km(false);
        if (i == 1) {
            if (this.cXS != null) {
                this.fak.setText(VoiceManager.formatVoiceTime(this.cXS.duration));
            }
            this.cbl.setVisibility(4);
        } else if (i == 2) {
            if (this.cXS != null) {
                this.fak.setText(VoiceManager.formatVoiceTime(this.cXS.duration));
            }
            this.cbl.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cXS != null && view == this.fam) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aat != null) {
                this.aat.onClick(this);
            }
            TiebaStatic.log(this.cXS.from);
        }
    }

    private void km(boolean z) {
        if (this.cXO != null) {
            if (z) {
                av.c(this.cXO, u.f.icon_voice_stop);
            } else {
                av.c(this.cXO, u.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bBm = voiceManager;
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
        return this.bBm;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.Hw();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.Hv() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.D(voiceModel);
            }
            this.play_type = zVar.Hv();
            setVoiceModel(voiceModel);
            bdo();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.cXS != voiceModel) {
                ln(1);
            } else {
                ln(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aC(int i) {
        if (!bdq()) {
            ln(1);
            return;
        }
        lm(i);
        if (this.cXS != null) {
            this.cXS.elapse = i;
        }
    }

    private boolean bdq() {
        if (this.cXS == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.cXS);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.cXS;
    }

    public void bdr() {
        bdo();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.cXS);
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.cXS);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kM() {
    }

    public void reset() {
        this.cXS = null;
        setTag(null);
        ln(1);
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
        this.aat = onClickListener;
    }
}
