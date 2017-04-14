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
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aiC;
    private VoiceManager bMC;
    private VoiceData.VoiceModel dgC;
    private ImageView dgy;
    private TextView fyP;
    private RelativeLayout fyR;
    private AudioAnimationView fyS;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fyT) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.fyP != null) {
            this.fyP.setTextSize(0, k.g(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        ak(context);
        setOnClickListener(this);
    }

    public void ak(Context context) {
        LayoutInflater.from(context).inflate(w.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.fyR = (RelativeLayout) findViewById(w.h.voice_image_content);
        this.fyR.setOnClickListener(this);
        this.dgy = (ImageView) findViewById(w.h.playingImg);
        this.fyP = (TextView) findViewById(w.h.playTime);
        this.fyP.setPadding(k.g(getContext(), w.f.ds6), 0 - k.g(getContext(), w.f.ds6), 0, 0);
        this.fyS = (AudioAnimationView) findViewById(w.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bjp();
    }

    private void bjp() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        aq.j(this.fyR, w.g.btn_audio_frame_n);
        aq.c(this.fyP, w.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            bjs();
            this.dgy.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fyS.onChangeSkinType(skinType);
    }

    private void bjs() {
        if (this.dgy != null) {
            if (bjr()) {
                aq.c(this.dgy, w.g.icon_voice_stop);
            } else {
                aq.c(this.dgy, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dgC = voiceModel;
        if (this.dgC != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lZ(this.dgC.elapse);
                return;
            }
            ma(this.dgC.voice_status.intValue());
            this.fyS.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fyS.bmk();
            this.fyP.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lZ(int i) {
        String formatVoiceTime;
        if (this.dgC != null && this.fyP != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dgC.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dgC.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dgC.duration);
            }
            String a = j.a(this.fyP.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fyP.setText(formatVoiceTime);
            }
        }
    }

    public void ma(int i) {
        this.fyS.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            ln(true);
            this.fyS.start();
            return;
        }
        this.fyS.bmk();
        ln(false);
        if (i == 1) {
            if (this.dgC != null) {
                this.fyP.setText(VoiceManager.formatVoiceTime(this.dgC.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dgC != null) {
                this.fyP.setText(VoiceManager.formatVoiceTime(this.dgC.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dgC != null && view == this.fyR) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiC != null) {
                this.aiC.onClick(this);
            }
            TiebaStatic.log(this.dgC.from);
        }
    }

    private void ln(boolean z) {
        if (this.dgy != null) {
            if (z) {
                aq.c(this.dgy, w.g.icon_voice_stop);
            } else {
                aq.c(this.dgy, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bMC = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.k.Z(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bMC;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Jh();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Jg() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Jg();
            setVoiceModel(voiceModel);
            bjp();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dgC != voiceModel) {
                ma(1);
            } else {
                ma(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (!bjr()) {
            ma(1);
            return;
        }
        lZ(i);
        if (this.dgC != null) {
            this.dgC.elapse = i;
        }
    }

    private boolean bjr() {
        if (this.dgC == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dgC);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dgC;
    }

    public void bac() {
        bjp();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dgC);
        }
        if ((com.baidu.adp.base.k.Z(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dgC);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void mw() {
    }

    public void reset() {
        this.dgC = null;
        setTag(null);
        ma(1);
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
        this.aiC = onClickListener;
    }
}
