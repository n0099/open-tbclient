package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
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
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aiR;
    private VoiceManager chP;
    private AnimationDrawable ddd;
    private ImageView dyL;
    private VoiceData.VoiceModel dyP;
    private TextView gjK;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBnt(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.n.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bA(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bA(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = {0, 0};
        if (this.play_type == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(d.f.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(d.f.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(d.f.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(d.f.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        ak(context);
        setOnClickListener(this);
    }

    public void ak(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt, (ViewGroup) this, true);
        this.dyL = (ImageView) findViewById(d.h.playingImg);
        this.gjK = (TextView) findViewById(d.h.playTime);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bts();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.l.editor_record));
    }

    private void bts() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ai.j(this, d.g.but_thread_voice_selector);
            if (this.gjK != null) {
                this.gjK.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds36));
                this.gjK.setTextColor(i);
            }
            if (this.dyL != null) {
                ai.c(this.dyL, d.a.voice_btn_play_anim);
            }
            this.dyL.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ai.j(this, d.g.but_thread_voice_reply_selector);
            if (this.gjK != null) {
                this.gjK.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds28));
                this.gjK.setTextColor(i2);
            }
            if (this.dyL != null) {
                ai.c(this.dyL, d.a.voice_btn_play_anim);
            }
            this.dyL.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dyL.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dyP = voiceModel;
        if (this.dyP != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mG(this.dyP.elapse);
                return;
            }
            mH(this.dyP.voice_status.intValue());
            this.gjK.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mG(int i) {
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

    public void mH(int i) {
        if (i == 3) {
            if (this.dyL != null) {
                this.dyL.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            ayd();
            return;
        }
        aye();
        if (i == 1) {
            if (this.dyL != null) {
                this.dyL.setVisibility(0);
            }
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
        if (this.dyP != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiR != null) {
                this.aiR.onClick(view);
            }
            TiebaStatic.log(this.dyP.from);
        }
    }

    private void btt() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.dyL != null) {
            this.dyL.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.dyL != null) {
            if (this.play_type == 0) {
                ai.c(this.dyL, d.g.icon_thread_voice_reply_curve_three);
            } else {
                ai.c(this.dyL, d.g.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void ayd() {
        if (this.ddd != null) {
            this.ddd.stop();
        }
        btt();
        this.ddd = (AnimationDrawable) this.dyL.getDrawable();
        this.ddd.start();
    }

    public void aye() {
        Drawable drawable = this.dyL.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.ddd = (AnimationDrawable) drawable;
        }
        if (this.ddd != null) {
            this.ddd.stop();
        }
        this.ddd = null;
        stopAnimation();
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
                mH(1);
            } else {
                mH(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (!btu()) {
            mH(1);
            return;
        }
        if (this.ddd == null) {
            mH(this.dyP.voice_status.intValue());
        }
        mG(i);
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
        mH(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int af = k.af(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (af * 0.3f);
                return (((i - 10) * (((int) (af * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (af * 0.45f);
        }
        int i3 = (int) (af * 0.18f);
        int i4 = (int) (af * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiR = onClickListener;
    }
}
