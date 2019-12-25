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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener Mz;
    private VoiceManager giZ;
    private ImageView hFq;
    private VoiceData.VoiceModel hFu;
    private AnimationDrawable hkb;
    private TextView kfr;
    private Context mContext;
    private ProgressBar mProgress;
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
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cL(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cL(int i, int i2) {
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
        af(context);
        setOnClickListener(this);
    }

    public void af(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.hFq = (ImageView) findViewById(R.id.playingImg);
        this.kfr = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cJC();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void cJC() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            am.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
            if (this.kfr != null) {
                this.kfr.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.kfr.setTextColor(i);
            }
            if (this.hFq != null) {
                am.setImageResource(this.hFq, R.anim.voice_btn_play_anim);
            }
            this.hFq.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            am.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
            if (this.kfr != null) {
                this.kfr.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.kfr.setTextColor(i2);
            }
            if (this.hFq != null) {
                am.setImageResource(this.hFq, R.anim.voice_btn_play_anim);
            }
            this.hFq.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.hFq.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.hFu = voiceModel;
        if (this.hFu != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                wK(this.hFu.elapse);
                return;
            }
            wL(this.hFu.voice_status.intValue());
            this.kfr.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void wK(int i) {
        String formatVoiceTime;
        if (this.hFu != null && this.kfr != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.hFu.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hFu.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hFu.duration);
            }
            String charSequence2String = k.charSequence2String(this.kfr.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.kfr.setText(formatVoiceTime);
            }
        }
    }

    public void wL(int i) {
        if (i == 3) {
            if (this.hFq != null) {
                this.hFq.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bVK();
            return;
        }
        bVL();
        if (i == 1) {
            if (this.hFq != null) {
                this.hFq.setVisibility(0);
            }
            if (this.hFu != null) {
                this.kfr.setText(VoiceManager.formatVoiceTime(this.hFu.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.hFu != null) {
                this.kfr.setText(VoiceManager.formatVoiceTime(this.hFu.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hFu != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.Mz != null) {
                this.Mz.onClick(view);
            }
            TiebaStatic.log(this.hFu.from);
        }
    }

    private void resetAnimation() {
        int i = R.anim.voice_btn_play_anim;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            if (skinType == 1) {
                i = R.anim.voice_btn_play_anim_1;
            }
        } else if (skinType == 1) {
            i = R.anim.voice_btn_play_anim_1;
        }
        if (this.hFq != null) {
            this.hFq.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.hFq != null) {
            if (this.play_type == 0) {
                am.setImageResource(this.hFq, R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                am.setImageResource(this.hFq, R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void bVK() {
        if (this.hkb != null) {
            this.hkb.stop();
        }
        resetAnimation();
        this.hkb = (AnimationDrawable) this.hFq.getDrawable();
        this.hkb.start();
    }

    public void bVL() {
        Drawable drawable = this.hFq.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.hkb = (AnimationDrawable) drawable;
        }
        if (this.hkb != null) {
            this.hkb.stop();
        }
        this.hkb = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.giZ = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.giZ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.aSd();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.aSc() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aj(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.aSc();
            setVoiceModel(voiceModel);
            cJC();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.hFu != voiceModel) {
                wL(1);
            } else {
                wL(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aD(int i) {
        if (!cJD()) {
            wL(1);
            return;
        }
        if (this.hkb == null) {
            wL(this.hFu.voice_status.intValue());
        }
        wK(i);
        if (this.hFu != null) {
            this.hFu.elapse = i;
        }
    }

    private boolean cJD() {
        if (this.hFu == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.hFu);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.hFu;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.hFu);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.hFu);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lI() {
    }

    public void reset() {
        this.hFu = null;
        setTag(null);
        wL(1);
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
        this.Mz = onClickListener;
    }
}
