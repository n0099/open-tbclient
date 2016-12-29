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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.y;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener adO;
    private ProgressBar ban;
    private VoiceManager byf;
    private ImageView cYt;
    private VoiceData.VoiceModel cYx;
    private TextView fjw;
    private RelativeLayout fjy;
    private AudioAnimationView fjz;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fjA) with 'values()' method */
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
        if (this.fjw != null) {
            this.fjw.setTextSize(0, k.e(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        N(context);
        setOnClickListener(this);
    }

    public void N(Context context) {
        LayoutInflater.from(context).inflate(r.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.fjy = (RelativeLayout) findViewById(r.g.voice_image_content);
        this.fjy.setOnClickListener(this);
        this.cYt = (ImageView) findViewById(r.g.playingImg);
        this.fjw = (TextView) findViewById(r.g.playTime);
        this.fjw.setPadding(k.e(getContext(), r.e.ds6), 0 - k.e(getContext(), r.e.ds6), 0, 0);
        this.fjz = (AudioAnimationView) findViewById(r.g.audioAnimationView);
        this.ban = (ProgressBar) findViewById(r.g.progress);
        if (this.ban != null) {
            this.ban.setVisibility(4);
        }
        this.mContext = context;
        bhd();
    }

    private void bhd() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        ar.k(this.fjy, r.f.btn_audio_frame_n);
        ar.c(this.fjw, r.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bhg();
            this.cYt.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fjz.onChangeSkinType(skinType);
    }

    private void bhg() {
        if (this.cYt != null) {
            if (bhf()) {
                ar.c(this.cYt, r.f.icon_voice_stop);
            } else {
                ar.c(this.cYt, r.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.cYx = voiceModel;
        if (this.cYx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lv(this.cYx.elapse);
                return;
            }
            lw(this.cYx.voice_status.intValue());
            this.fjz.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fjz.bkg();
            this.fjw.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lv(int i) {
        String formatVoiceTime;
        if (this.cYx != null && this.fjw != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.cYx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cYx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cYx.duration);
            }
            String a = j.a(this.fjw.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fjw.setText(formatVoiceTime);
            }
        }
    }

    public void lw(int i) {
        this.fjz.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.ban.setVisibility(4);
            kZ(true);
            this.fjz.start();
            return;
        }
        this.fjz.bkg();
        kZ(false);
        if (i == 1) {
            if (this.cYx != null) {
                this.fjw.setText(VoiceManager.formatVoiceTime(this.cYx.duration));
            }
            this.ban.setVisibility(4);
        } else if (i == 2) {
            if (this.cYx != null) {
                this.fjw.setText(VoiceManager.formatVoiceTime(this.cYx.duration));
            }
            this.ban.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cYx != null && view == this.fjy) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.adO != null) {
                this.adO.onClick(this);
            }
            TiebaStatic.log(this.cYx.from);
        }
    }

    private void kZ(boolean z) {
        if (this.cYt != null) {
            if (z) {
                ar.c(this.cYt, r.f.icon_voice_stop);
            } else {
                ar.c(this.cYt, r.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.byf = voiceManager;
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
        return this.byf;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof y)) {
            y yVar = (y) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) yVar.Ir();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (yVar.Iq() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = yVar.getMd5();
                voiceModel.duration = yVar.getDuration();
                yVar.G(voiceModel);
            }
            this.play_type = yVar.Iq();
            setVoiceModel(voiceModel);
            bhd();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.cYx != voiceModel) {
                lw(1);
            } else {
                lw(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aT(int i) {
        if (!bhf()) {
            lw(1);
            return;
        }
        lv(i);
        if (this.cYx != null) {
            this.cYx.elapse = i;
        }
    }

    private boolean bhf() {
        if (this.cYx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.cYx);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.cYx;
    }

    public void axx() {
        bhd();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.cYx);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.cYx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    public void reset() {
        this.cYx = null;
        setTag(null);
        lw(1);
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
        this.adO = onClickListener;
    }
}
