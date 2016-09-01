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
import com.baidu.tieba.t;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener adM;
    private VoiceManager bQi;
    private ProgressBar coz;
    private ImageView dmt;
    private VoiceData.VoiceModel dmx;
    private TextView fvi;
    private RelativeLayout fvk;
    private AudioAnimationView fvl;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fvm) with 'values()' method */
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
        if (this.fvi != null) {
            this.fvi.setTextSize(0, k.e(getContext(), i));
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
        LayoutInflater.from(context).inflate(t.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.fvk = (RelativeLayout) findViewById(t.g.voice_image_content);
        this.fvk.setOnClickListener(this);
        this.dmt = (ImageView) findViewById(t.g.playingImg);
        this.fvi = (TextView) findViewById(t.g.playTime);
        this.fvi.setPadding(k.e(getContext(), t.e.ds6), 0 - k.e(getContext(), t.e.ds6), 0, 0);
        this.fvl = (AudioAnimationView) findViewById(t.g.audioAnimationView);
        this.coz = (ProgressBar) findViewById(t.g.progress);
        if (this.coz != null) {
            this.coz.setVisibility(4);
        }
        this.mContext = context;
        bkh();
    }

    private void bkh() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        av.k(this.fvk, t.f.btn_audio_frame_n);
        av.c(this.fvi, t.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bkl();
            this.dmt.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fvl.onChangeSkinType(skinType);
    }

    private void bkl() {
        if (this.dmt != null) {
            if (bkj()) {
                av.c(this.dmt, t.f.icon_voice_stop);
            } else {
                av.c(this.dmt, t.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dmx = voiceModel;
        if (this.dmx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lV(this.dmx.elapse);
                return;
            }
            lW(this.dmx.voice_status.intValue());
            this.fvl.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fvl.bqi();
            this.fvi.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lV(int i) {
        String formatVoiceTime;
        if (this.dmx != null && this.fvi != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dmx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dmx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dmx.duration);
            }
            String a = j.a(this.fvi.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fvi.setText(formatVoiceTime);
            }
        }
    }

    public void lW(int i) {
        this.fvl.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.coz.setVisibility(4);
            kM(true);
            this.fvl.start();
            return;
        }
        this.fvl.bqi();
        kM(false);
        if (i == 1) {
            if (this.dmx != null) {
                this.fvi.setText(VoiceManager.formatVoiceTime(this.dmx.duration));
            }
            this.coz.setVisibility(4);
        } else if (i == 2) {
            if (this.dmx != null) {
                this.fvi.setText(VoiceManager.formatVoiceTime(this.dmx.duration));
            }
            this.coz.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dmx != null && view == this.fvk) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.adM != null) {
                this.adM.onClick(this);
            }
            TiebaStatic.log(this.dmx.from);
        }
    }

    private void kM(boolean z) {
        if (this.dmt != null) {
            if (z) {
                av.c(this.dmt, t.f.icon_voice_stop);
            } else {
                av.c(this.dmt, t.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bQi = voiceManager;
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
        return this.bQi;
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
            bkh();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dmx != voiceModel) {
                lW(1);
            } else {
                lW(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bkj()) {
            lW(1);
            return;
        }
        lV(i);
        if (this.dmx != null) {
            this.dmx.elapse = i;
        }
    }

    private boolean bkj() {
        if (this.dmx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dmx);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dmx;
    }

    public void bkk() {
        bkh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dmx);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dmx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lD() {
    }

    public void reset() {
        this.dmx = null;
        setTag(null);
        lW(1);
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
        this.adM = onClickListener;
    }
}
