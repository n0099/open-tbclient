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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aiv;
    private VoiceManager cci;
    private ImageView dqj;
    private VoiceData.VoiceModel dqn;
    private TextView fPl;
    private RelativeLayout fPn;
    private AudioAnimationView fPo;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fPp) with 'values()' method */
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
        if (this.fPl != null) {
            this.fPl.setTextSize(0, k.g(getContext(), i));
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
        this.fPn = (RelativeLayout) findViewById(w.h.voice_image_content);
        this.fPn.setOnClickListener(this);
        this.dqj = (ImageView) findViewById(w.h.playingImg);
        this.fPl = (TextView) findViewById(w.h.playTime);
        this.fPl.setPadding(k.g(getContext(), w.f.ds6), 0 - k.g(getContext(), w.f.ds6), 0, 0);
        this.fPo = (AudioAnimationView) findViewById(w.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bnv();
    }

    private void bnv() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        as.j(this.fPn, w.g.btn_audio_frame_n);
        as.c(this.fPl, w.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            bny();
            this.dqj.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fPo.onChangeSkinType(skinType);
    }

    private void bny() {
        if (this.dqj != null) {
            if (bnx()) {
                as.c(this.dqj, w.g.icon_voice_stop);
            } else {
                as.c(this.dqj, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dqn = voiceModel;
        if (this.dqn != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mx(this.dqn.elapse);
                return;
            }
            my(this.dqn.voice_status.intValue());
            this.fPo.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fPo.bqz();
            this.fPl.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mx(int i) {
        String formatVoiceTime;
        if (this.dqn != null && this.fPl != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dqn.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dqn.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dqn.duration);
            }
            String a = j.a(this.fPl.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fPl.setText(formatVoiceTime);
            }
        }
    }

    public void my(int i) {
        this.fPo.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            lV(true);
            this.fPo.start();
            return;
        }
        this.fPo.bqz();
        lV(false);
        if (i == 1) {
            if (this.dqn != null) {
                this.fPl.setText(VoiceManager.formatVoiceTime(this.dqn.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dqn != null) {
                this.fPl.setText(VoiceManager.formatVoiceTime(this.dqn.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dqn != null && view == this.fPn) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiv != null) {
                this.aiv.onClick(this);
            }
            TiebaStatic.log(this.dqn.from);
        }
    }

    private void lV(boolean z) {
        if (this.dqj != null) {
            if (z) {
                as.c(this.dqj, w.g.icon_voice_stop);
            } else {
                as.c(this.dqj, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cci = voiceManager;
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
        return this.cci;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.IO();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.IN() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.IN();
            setVoiceModel(voiceModel);
            bnv();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dqn != voiceModel) {
                my(1);
            } else {
                my(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        if (!bnx()) {
            my(1);
            return;
        }
        mx(i);
        if (this.dqn != null) {
            this.dqn.elapse = i;
        }
    }

    private boolean bnx() {
        if (this.dqn == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dqn);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dqn;
    }

    public void bef() {
        bnv();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dqn);
        }
        if ((com.baidu.adp.base.k.Z(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dqn);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    public void reset() {
        this.dqn = null;
        setTag(null);
        my(1);
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
        this.aiv = onClickListener;
    }
}
