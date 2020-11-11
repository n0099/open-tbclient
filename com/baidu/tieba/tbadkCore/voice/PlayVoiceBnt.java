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
    private View.OnClickListener ajp;
    private VoiceManager iHo;
    private AnimationDrawable jSY;
    private ImageView kqu;
    private VoiceData.VoiceModel kqy;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView naA;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(dw(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int dw(int i, int i2) {
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
        this.kqu = (ImageView) findViewById(R.id.playingImg);
        this.naA = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dLi();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void dLi() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
            if (this.naA != null) {
                this.naA.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.naA.setTextColor(i);
            }
            if (this.kqu != null) {
                ap.setImageResource(this.kqu, R.anim.voice_btn_play_anim);
            }
            this.kqu.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
            if (this.naA != null) {
                this.naA.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.naA.setTextColor(i2);
            }
            if (this.kqu != null) {
                ap.setImageResource(this.kqu, R.anim.voice_btn_play_anim);
            }
            this.kqu.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.kqu.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kqy = voiceModel;
        if (this.kqy != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                Dy(this.kqy.elapse);
                return;
            }
            Dz(this.kqy.voice_status.intValue());
            this.naA.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void Dy(int i) {
        String formatVoiceTime;
        if (this.kqy != null && this.naA != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kqy.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kqy.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kqy.duration);
            }
            String charSequence2String = k.charSequence2String(this.naA.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.naA.setText(formatVoiceTime);
            }
        }
    }

    public void Dz(int i) {
        if (i == 3) {
            if (this.kqu != null) {
                this.kqu.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            cVB();
            return;
        }
        cVC();
        if (i == 1) {
            if (this.kqu != null) {
                this.kqu.setVisibility(0);
            }
            if (this.kqy != null) {
                this.naA.setText(VoiceManager.formatVoiceTime(this.kqy.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kqy != null) {
                this.naA.setText(VoiceManager.formatVoiceTime(this.kqy.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kqy != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajp != null) {
                this.ajp.onClick(view);
            }
            TiebaStatic.log(this.kqy.from);
        }
    }

    private void dLj() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        }
        if (this.kqu != null) {
            this.kqu.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.kqu != null) {
            if (this.play_type == 0) {
                ap.setImageResource(this.kqu, R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                ap.setImageResource(this.kqu, R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void cVB() {
        if (this.jSY != null) {
            this.jSY.stop();
        }
        dLj();
        this.jSY = (AnimationDrawable) this.kqu.getDrawable();
        this.jSY.start();
    }

    public void cVC() {
        Drawable drawable = this.kqu.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.jSY = (AnimationDrawable) drawable;
        }
        if (this.jSY != null) {
            this.jSY.stop();
        }
        this.jSY = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.iHo = voiceManager;
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
        return this.iHo;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bGK();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bGJ() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ax(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bGJ();
            setVoiceModel(voiceModel);
            dLi();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kqy != voiceModel) {
                Dz(1);
            } else {
                Dz(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (!dLk()) {
            Dz(1);
            return;
        }
        if (this.jSY == null) {
            Dz(this.kqy.voice_status.intValue());
        }
        Dy(i);
        if (this.kqy != null) {
            this.kqy.elapse = i;
        }
    }

    private boolean dLk() {
        if (this.kqy == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kqy);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kqy;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kqy);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kqy);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void reset() {
        this.kqy = null;
        setTag(null);
        Dz(1);
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
        this.ajp = onClickListener;
    }
}
