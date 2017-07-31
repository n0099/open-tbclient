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
    private View.OnClickListener akk;
    private VoiceManager ciW;
    private ImageView dAc;
    private VoiceData.VoiceModel dAg;
    private TextView gkV;
    private RelativeLayout gkX;
    private AudioAnimationView gkY;
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
        if (this.gkV != null) {
            this.gkV.setTextSize(0, k.g(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        al(context);
        setOnClickListener(this);
    }

    public void al(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.gkX = (RelativeLayout) findViewById(d.h.voice_image_content);
        this.gkX.setOnClickListener(this);
        this.dAc = (ImageView) findViewById(d.h.playingImg);
        this.gkV = (TextView) findViewById(d.h.playTime);
        this.gkV.setPadding(k.g(getContext(), d.f.ds6), 0 - k.g(getContext(), d.f.ds6), 0, 0);
        this.gkY = (AudioAnimationView) findViewById(d.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        btz();
    }

    private void btz() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ai.j(this.gkX, d.g.btn_audio_frame_n);
        ai.c(this.gkV, d.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            btC();
            this.dAc.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.gkY.onChangeSkinType(skinType);
    }

    private void btC() {
        if (this.dAc != null) {
            if (btB()) {
                ai.c(this.dAc, d.g.icon_voice_stop);
            } else {
                ai.c(this.dAc, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dAg = voiceModel;
        if (this.dAg != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mF(this.dAg.elapse);
                return;
            }
            mG(this.dAg.voice_status.intValue());
            this.gkY.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gkY.bwC();
            this.gkV.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mF(int i) {
        String formatVoiceTime;
        if (this.dAg != null && this.gkV != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dAg.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dAg.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dAg.duration);
            }
            String a = j.a(this.gkV.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gkV.setText(formatVoiceTime);
            }
        }
    }

    public void mG(int i) {
        this.gkY.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mB(true);
            this.gkY.start();
            return;
        }
        this.gkY.bwC();
        mB(false);
        if (i == 1) {
            if (this.dAg != null) {
                this.gkV.setText(VoiceManager.formatVoiceTime(this.dAg.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dAg != null) {
                this.gkV.setText(VoiceManager.formatVoiceTime(this.dAg.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dAg != null && view == this.gkX) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.akk != null) {
                this.akk.onClick(this);
            }
            TiebaStatic.log(this.dAg.from);
        }
    }

    private void mB(boolean z) {
        if (this.dAc != null) {
            if (z) {
                ai.c(this.dAc, d.g.icon_voice_stop);
            } else {
                ai.c(this.dAc, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.ciW = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.aa(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.aa(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.ciW;
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
            btz();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dAg != voiceModel) {
                mG(1);
            } else {
                mG(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aQ(int i) {
        if (!btB()) {
            mG(1);
            return;
        }
        mF(i);
        if (this.dAg != null) {
            this.dAg.elapse = i;
        }
    }

    private boolean btB() {
        if (this.dAg == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dAg);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dAg;
    }

    public void bhR() {
        btz();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dAg);
        }
        if ((i.aa(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.aa(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dAg);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ma() {
    }

    public void reset() {
        this.dAg = null;
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
        this.akk = onClickListener;
    }
}
