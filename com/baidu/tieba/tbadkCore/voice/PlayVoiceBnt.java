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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private AnimationDrawable aID;
    private View.OnClickListener alg;
    private VoiceManager cYn;
    private ImageView ekr;
    private VoiceData.VoiceModel ekv;
    private TextView gAE;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.m.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bL(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bL(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(d.e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(d.e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(d.e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(d.e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        am(context);
        setOnClickListener(this);
    }

    public void am(Context context) {
        LayoutInflater.from(context).inflate(d.i.play_voice_bnt, (ViewGroup) this, true);
        this.ekr = (ImageView) findViewById(d.g.playingImg);
        this.gAE = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bsZ();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.k.msglist_voice));
    }

    private void bsZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ak.i(this, d.f.but_thread_voice_selector);
            if (this.gAE != null) {
                this.gAE.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.gAE.setTextColor(i);
            }
            if (this.ekr != null) {
                ak.c(this.ekr, d.a.voice_btn_play_anim);
            }
            this.ekr.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ak.i(this, d.f.but_thread_voice_reply_selector);
            if (this.gAE != null) {
                this.gAE.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.gAE.setTextColor(i2);
            }
            if (this.ekr != null) {
                ak.c(this.ekr, d.a.voice_btn_play_anim);
            }
            this.ekr.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.ekr.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.ekv = voiceModel;
        if (this.ekv != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nZ(this.ekv.elapse);
                return;
            }
            oa(this.ekv.voice_status.intValue());
            this.gAE.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nZ(int i) {
        String formatVoiceTime;
        if (this.ekv != null && this.gAE != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.ekv.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ekv.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ekv.duration);
            }
            String a = k.a(this.gAE.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gAE.setText(formatVoiceTime);
            }
        }
    }

    public void oa(int i) {
        if (i == 3) {
            if (this.ekr != null) {
                this.ekr.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aHp();
            return;
        }
        aHq();
        if (i == 1) {
            if (this.ekr != null) {
                this.ekr.setVisibility(0);
            }
            if (this.ekv != null) {
                this.gAE.setText(VoiceManager.formatVoiceTime(this.ekv.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ekv != null) {
                this.gAE.setText(VoiceManager.formatVoiceTime(this.ekv.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.ekv != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.alg != null) {
                this.alg.onClick(view2);
            }
            TiebaStatic.log(this.ekv.from);
        }
    }

    private void bta() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.ekr != null) {
            this.ekr.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.ekr != null) {
            if (this.play_type == 0) {
                ak.c(this.ekr, d.f.icon_thread_voice_reply_curve_three);
            } else {
                ak.c(this.ekr, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aHp() {
        if (this.aID != null) {
            this.aID.stop();
        }
        bta();
        this.aID = (AnimationDrawable) this.ekr.getDrawable();
        this.aID.start();
    }

    public void aHq() {
        Drawable drawable = this.ekr.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aID = (AnimationDrawable) drawable;
        }
        if (this.aID != null) {
            this.aID.stop();
        }
        this.aID = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cYn = voiceManager;
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
        return this.cYn;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.KC();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.KB() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.yv();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.KB();
            setVoiceModel(voiceModel);
            bsZ();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.ekv != voiceModel) {
                oa(1);
            } else {
                oa(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aX(int i) {
        if (!btb()) {
            oa(1);
            return;
        }
        if (this.aID == null) {
            oa(this.ekv.voice_status.intValue());
        }
        nZ(i);
        if (this.ekv != null) {
            this.ekv.elapse = i;
        }
    }

    private boolean btb() {
        if (this.ekv == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.ekv);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ekv;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.ekv);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.ekv);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lY() {
    }

    public void reset() {
        this.ekv = null;
        setTag(null);
        oa(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int af = l.af(getContext());
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
        this.alg = onClickListener;
    }
}
