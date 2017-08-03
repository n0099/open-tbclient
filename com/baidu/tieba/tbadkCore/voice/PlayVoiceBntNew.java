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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aiR;
    private VoiceManager chP;
    private ImageView dyL;
    private VoiceData.VoiceModel dyP;
    private TextView gjK;
    private RelativeLayout gjM;
    private AudioAnimationView gjN;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.n.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.gjK != null) {
            this.gjK.setTextSize(0, k.g(getContext(), i));
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
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.gjM = (RelativeLayout) findViewById(d.h.voice_image_content);
        this.gjM.setOnClickListener(this);
        this.dyL = (ImageView) findViewById(d.h.playingImg);
        this.gjK = (TextView) findViewById(d.h.playTime);
        this.gjK.setPadding(k.g(getContext(), d.f.ds6), 0 - k.g(getContext(), d.f.ds6), 0, 0);
        this.gjN = (AudioAnimationView) findViewById(d.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bts();
    }

    private void bts() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ai.j(this.gjM, d.g.btn_audio_frame_n);
        ai.c(this.gjK, d.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            btv();
            this.dyL.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.gjN.onChangeSkinType(skinType);
    }

    private void btv() {
        if (this.dyL != null) {
            if (btu()) {
                ai.c(this.dyL, d.g.icon_voice_stop);
            } else {
                ai.c(this.dyL, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dyP = voiceModel;
        if (this.dyP != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mF(this.dyP.elapse);
                return;
            }
            mG(this.dyP.voice_status.intValue());
            this.gjN.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gjN.bwv();
            this.gjK.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mF(int i) {
        String formatVoiceTime;
        if (this.dyP != null && this.gjK != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dyP.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dyP.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dyP.duration);
            }
            String a = j.a(this.gjK.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gjK.setText(formatVoiceTime);
            }
        }
    }

    public void mG(int i) {
        this.gjN.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mB(true);
            this.gjN.start();
            return;
        }
        this.gjN.bwv();
        mB(false);
        if (i == 1) {
            if (this.dyP != null) {
                this.gjK.setText(VoiceManager.formatVoiceTime(this.dyP.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dyP != null) {
                this.gjK.setText(VoiceManager.formatVoiceTime(this.dyP.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dyP != null && view == this.gjM) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiR != null) {
                this.aiR.onClick(this);
            }
            TiebaStatic.log(this.dyP.from);
        }
    }

    private void mB(boolean z) {
        if (this.dyL != null) {
            if (z) {
                ai.c(this.dyL, d.g.icon_voice_stop);
            } else {
                ai.c(this.dyL, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.chP = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.Z(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.chP;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ja();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.IZ() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.IZ();
            setVoiceModel(voiceModel);
            bts();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dyP != voiceModel) {
                mG(1);
            } else {
                mG(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (!btu()) {
            mG(1);
            return;
        }
        mF(i);
        if (this.dyP != null) {
            this.dyP.elapse = i;
        }
    }

    private boolean btu() {
        if (this.dyP == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dyP);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dyP;
    }

    public void bhH() {
        bts();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dyP);
        }
        if ((i.Z(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dyP);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void reset() {
        this.dyP = null;
        setTag(null);
        mG(1);
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
        this.aiR = onClickListener;
    }
}
