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
    private View.OnClickListener akt;
    private VoiceManager iSW;
    private ImageView kEC;
    private VoiceData.VoiceModel kEG;
    private AnimationDrawable kho;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView npG;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(dC(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int dC(int i, int i2) {
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
        N(context);
        setOnClickListener(this);
    }

    public void N(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.kEC = (ImageView) findViewById(R.id.playingImg);
        this.npG = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dQA();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void dQA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
            if (this.npG != null) {
                this.npG.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.npG.setTextColor(i);
            }
            if (this.kEC != null) {
                ap.setImageResource(this.kEC, R.anim.voice_btn_play_anim);
            }
            this.kEC.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
            if (this.npG != null) {
                this.npG.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.npG.setTextColor(i2);
            }
            if (this.kEC != null) {
                ap.setImageResource(this.kEC, R.anim.voice_btn_play_anim);
            }
            this.kEC.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.kEC.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kEG = voiceModel;
        if (this.kEG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                EL(this.kEG.elapse);
                return;
            }
            EM(this.kEG.voice_status.intValue());
            this.npG.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void EL(int i) {
        String formatVoiceTime;
        if (this.kEG != null && this.npG != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kEG.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kEG.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kEG.duration);
            }
            String charSequence2String = k.charSequence2String(this.npG.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.npG.setText(formatVoiceTime);
            }
        }
    }

    public void EM(int i) {
        if (i == 3) {
            if (this.kEC != null) {
                this.kEC.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            dau();
            return;
        }
        dav();
        if (i == 1) {
            if (this.kEC != null) {
                this.kEC.setVisibility(0);
            }
            if (this.kEG != null) {
                this.npG.setText(VoiceManager.formatVoiceTime(this.kEG.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kEG != null) {
                this.npG.setText(VoiceManager.formatVoiceTime(this.kEG.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kEG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.akt != null) {
                this.akt.onClick(view);
            }
            TiebaStatic.log(this.kEG.from);
        }
    }

    private void dQB() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        }
        if (this.kEC != null) {
            this.kEC.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.kEC != null) {
            if (this.play_type == 0) {
                ap.setImageResource(this.kEC, R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                ap.setImageResource(this.kEC, R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void dau() {
        if (this.kho != null) {
            this.kho.stop();
        }
        dQB();
        this.kho = (AnimationDrawable) this.kEC.getDrawable();
        this.kho.start();
    }

    public void dav() {
        Drawable drawable = this.kEC.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.kho = (AnimationDrawable) drawable;
        }
        if (this.kho != null) {
            this.kho.stop();
        }
        this.kho = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.iSW = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.J(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.J(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.iSW;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bJD();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bJC() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ax(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bJC();
            setVoiceModel(voiceModel);
            dQA();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kEG != voiceModel) {
                EM(1);
            } else {
                EM(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (!dQC()) {
            EM(1);
            return;
        }
        if (this.kho == null) {
            EM(this.kEG.voice_status.intValue());
        }
        EL(i);
        if (this.kEG != null) {
            this.kEG.elapse = i;
        }
    }

    private boolean dQC() {
        if (this.kEG == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kEG);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kEG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kEG);
        }
        if ((i.J(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.J(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kEG);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void si() {
    }

    public void reset() {
        this.kEG = null;
        setTag(null);
        EM(1);
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
        this.akt = onClickListener;
    }
}
