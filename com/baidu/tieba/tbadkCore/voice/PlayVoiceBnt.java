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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener ahn;
    private VoiceManager hFy;
    private AnimationDrawable iNT;
    private ImageView jls;
    private VoiceData.VoiceModel jlw;
    private TextView lQL;
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
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(dg(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int dg(int i, int i2) {
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
        K(context);
        setOnClickListener(this);
    }

    public void K(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.jls = (ImageView) findViewById(R.id.playingImg);
        this.lQL = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dms();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void dms() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ao.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
            if (this.lQL != null) {
                this.lQL.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.lQL.setTextColor(i);
            }
            if (this.jls != null) {
                ao.setImageResource(this.jls, R.anim.voice_btn_play_anim);
            }
            this.jls.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ao.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
            if (this.lQL != null) {
                this.lQL.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.lQL.setTextColor(i2);
            }
            if (this.jls != null) {
                ao.setImageResource(this.jls, R.anim.voice_btn_play_anim);
            }
            this.jls.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.jls.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jlw = voiceModel;
        if (this.jlw != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                zs(this.jlw.elapse);
                return;
            }
            zt(this.jlw.voice_status.intValue());
            this.lQL.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void zs(int i) {
        String formatVoiceTime;
        if (this.jlw != null && this.lQL != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jlw.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jlw.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jlw.duration);
            }
            String charSequence2String = k.charSequence2String(this.lQL.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.lQL.setText(formatVoiceTime);
            }
        }
    }

    public void zt(int i) {
        if (i == 3) {
            if (this.jls != null) {
                this.jls.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            cxN();
            return;
        }
        cxO();
        if (i == 1) {
            if (this.jls != null) {
                this.jls.setVisibility(0);
            }
            if (this.jlw != null) {
                this.lQL.setText(VoiceManager.formatVoiceTime(this.jlw.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jlw != null) {
                this.lQL.setText(VoiceManager.formatVoiceTime(this.jlw.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jlw != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ahn != null) {
                this.ahn.onClick(view);
            }
            TiebaStatic.log(this.jlw.from);
        }
    }

    private void dmt() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        }
        if (this.jls != null) {
            this.jls.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.jls != null) {
            if (this.play_type == 0) {
                ao.setImageResource(this.jls, R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                ao.setImageResource(this.jls, R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void cxN() {
        if (this.iNT != null) {
            this.iNT.stop();
        }
        dmt();
        this.iNT = (AnimationDrawable) this.jls.getDrawable();
        this.iNT.start();
    }

    public void cxO() {
        Drawable drawable = this.jls.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.iNT = (AnimationDrawable) drawable;
        }
        if (this.iNT != null) {
            this.iNT.stop();
        }
        this.iNT = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hFy = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.hFy;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bpK();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bpJ() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ar(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bpJ();
            setVoiceModel(voiceModel);
            dms();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jlw != voiceModel) {
                zt(1);
            } else {
                zt(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aY(int i) {
        if (!dmu()) {
            zt(1);
            return;
        }
        if (this.iNT == null) {
            zt(this.jlw.voice_status.intValue());
        }
        zs(i);
        if (this.jlw != null) {
            this.jlw.elapse = i;
        }
    }

    private boolean dmu() {
        if (this.jlw == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jlw);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jlw;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jlw);
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jlw);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qC() {
    }

    public void reset() {
        this.jlw = null;
        setTag(null);
        zt(1);
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
        this.ahn = onClickListener;
    }
}
