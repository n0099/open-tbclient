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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aiW;
    private VoiceManager hZU;
    private ImageView jJb;
    private VoiceData.VoiceModel jJf;
    private AnimationDrawable jlE;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView msm;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ds(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int ds(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        M(context);
        setOnClickListener(this);
    }

    public void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.jJb = (ImageView) findViewById(R.id.playingImg);
        this.msm = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dBM();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void dBM() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
            if (this.msm != null) {
                this.msm.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.msm.setTextColor(i);
            }
            if (this.jJb != null) {
                ap.setImageResource(this.jJb, R.anim.voice_btn_play_anim);
            }
            this.jJb.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
            if (this.msm != null) {
                this.msm.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.msm.setTextColor(i2);
            }
            if (this.jJb != null) {
                ap.setImageResource(this.jJb, R.anim.voice_btn_play_anim);
            }
            this.jJb.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.jJb.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jJf = voiceModel;
        if (this.jJf != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                Cm(this.jJf.elapse);
                return;
            }
            Cn(this.jJf.voice_status.intValue());
            this.msm.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void Cm(int i) {
        String formatVoiceTime;
        if (this.jJf != null && this.msm != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jJf.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jJf.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jJf.duration);
            }
            String charSequence2String = k.charSequence2String(this.msm.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.msm.setText(formatVoiceTime);
            }
        }
    }

    public void Cn(int i) {
        if (i == 3) {
            if (this.jJb != null) {
                this.jJb.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            cMl();
            return;
        }
        cMm();
        if (i == 1) {
            if (this.jJb != null) {
                this.jJb.setVisibility(0);
            }
            if (this.jJf != null) {
                this.msm.setText(VoiceManager.formatVoiceTime(this.jJf.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jJf != null) {
                this.msm.setText(VoiceManager.formatVoiceTime(this.jJf.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jJf != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiW != null) {
                this.aiW.onClick(view);
            }
            TiebaStatic.log(this.jJf.from);
        }
    }

    private void dBN() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        }
        if (this.jJb != null) {
            this.jJb.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.jJb != null) {
            if (this.play_type == 0) {
                ap.setImageResource(this.jJb, R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                ap.setImageResource(this.jJb, R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void cMl() {
        if (this.jlE != null) {
            this.jlE.stop();
        }
        dBN();
        this.jlE = (AnimationDrawable) this.jJb.getDrawable();
        this.jlE.start();
    }

    public void cMm() {
        Drawable drawable = this.jJb.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.jlE = (AnimationDrawable) drawable;
        }
        if (this.jlE != null) {
            this.jlE.stop();
        }
        this.jlE = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hZU = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.hZU;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bzI();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bzH() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.au(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bzH();
            setVoiceModel(voiceModel);
            dBM();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jJf != voiceModel) {
                Cn(1);
            } else {
                Cn(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (!dBO()) {
            Cn(1);
            return;
        }
        if (this.jlE == null) {
            Cn(this.jJf.voice_status.intValue());
        }
        Cm(i);
        if (this.jJf != null) {
            this.jJf.elapse = i;
        }
    }

    private boolean dBO() {
        if (this.jJf == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jJf);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jJf;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jJf);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jJf);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void reset() {
        this.jJf = null;
        setTag(null);
        Cn(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (equipmentWidth * 0.3f);
                return (((i - 10) * (((int) (equipmentWidth * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (equipmentWidth * 0.45f);
        }
        int i3 = (int) (equipmentWidth * 0.18f);
        int i4 = (int) (equipmentWidth * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }
}
