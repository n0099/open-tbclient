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
    private View.OnClickListener akm;
    private VoiceManager cjK;
    private ImageView dBZ;
    private VoiceData.VoiceModel dCd;
    private AnimationDrawable dgu;
    private TextView gmN;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bJ(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bJ(int i, int i2) {
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
        al(context);
        setOnClickListener(this);
    }

    public void al(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt, (ViewGroup) this, true);
        this.dBZ = (ImageView) findViewById(d.h.playingImg);
        this.gmN = (TextView) findViewById(d.h.playTime);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bua();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.l.editor_record));
    }

    private void bua() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ai.j(this, d.g.but_thread_voice_selector);
            if (this.gmN != null) {
                this.gmN.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds36));
                this.gmN.setTextColor(i);
            }
            if (this.dBZ != null) {
                ai.c(this.dBZ, d.a.voice_btn_play_anim);
            }
            this.dBZ.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ai.j(this, d.g.but_thread_voice_reply_selector);
            if (this.gmN != null) {
                this.gmN.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds28));
                this.gmN.setTextColor(i2);
            }
            if (this.dBZ != null) {
                ai.c(this.dBZ, d.a.voice_btn_play_anim);
            }
            this.dBZ.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dBZ.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dCd = voiceModel;
        if (this.dCd != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mP(this.dCd.elapse);
                return;
            }
            mQ(this.dCd.voice_status.intValue());
            this.gmN.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mP(int i) {
        String formatVoiceTime;
        if (this.dCd != null && this.gmN != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dCd.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dCd.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dCd.duration);
            }
            String a = j.a(this.gmN.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gmN.setText(formatVoiceTime);
            }
        }
    }

    public void mQ(int i) {
        if (i == 3) {
            if (this.dBZ != null) {
                this.dBZ.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            ayQ();
            return;
        }
        ayR();
        if (i == 1) {
            if (this.dBZ != null) {
                this.dBZ.setVisibility(0);
            }
            if (this.dCd != null) {
                this.gmN.setText(VoiceManager.formatVoiceTime(this.dCd.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dCd != null) {
                this.gmN.setText(VoiceManager.formatVoiceTime(this.dCd.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dCd != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.akm != null) {
                this.akm.onClick(view);
            }
            TiebaStatic.log(this.dCd.from);
        }
    }

    private void bub() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.dBZ != null) {
            this.dBZ.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.dBZ != null) {
            if (this.play_type == 0) {
                ai.c(this.dBZ, d.g.icon_thread_voice_reply_curve_three);
            } else {
                ai.c(this.dBZ, d.g.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void ayQ() {
        if (this.dgu != null) {
            this.dgu.stop();
        }
        bub();
        this.dgu = (AnimationDrawable) this.dBZ.getDrawable();
        this.dgu.start();
    }

    public void ayR() {
        Drawable drawable = this.dBZ.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.dgu = (AnimationDrawable) drawable;
        }
        if (this.dgu != null) {
            this.dgu.stop();
        }
        this.dgu = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cjK = voiceManager;
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
        return this.cjK;
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
            bua();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dCd != voiceModel) {
                mQ(1);
            } else {
                mQ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aQ(int i) {
        if (!buc()) {
            mQ(1);
            return;
        }
        if (this.dgu == null) {
            mQ(this.dCd.voice_status.intValue());
        }
        mP(i);
        if (this.dCd != null) {
            this.dCd.elapse = i;
        }
    }

    private boolean buc() {
        if (this.dCd == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dCd);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dCd;
    }

    public void bis() {
        bua();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dCd);
        }
        if ((i.aa(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.aa(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dCd);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lZ() {
    }

    public void reset() {
        this.dCd = null;
        setTag(null);
        mQ(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int ag = k.ag(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (ag * 0.3f);
                return (((i - 10) * (((int) (ag * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (ag * 0.45f);
        }
        int i3 = (int) (ag * 0.18f);
        int i4 = (int) (ag * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akm = onClickListener;
    }
}
