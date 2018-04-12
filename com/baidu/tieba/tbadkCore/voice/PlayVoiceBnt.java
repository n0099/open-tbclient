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
    private AnimationDrawable aIC;
    private View.OnClickListener alg;
    private VoiceManager cXj;
    private ImageView ejn;
    private VoiceData.VoiceModel ejr;
    private TextView gzE;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bM(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bM(int i, int i2) {
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
        this.ejn = (ImageView) findViewById(d.g.playingImg);
        this.gzE = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        btb();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.k.msglist_voice));
    }

    private void btb() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ak.i(this, d.f.but_thread_voice_selector);
            if (this.gzE != null) {
                this.gzE.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.gzE.setTextColor(i);
            }
            if (this.ejn != null) {
                ak.c(this.ejn, d.a.voice_btn_play_anim);
            }
            this.ejn.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ak.i(this, d.f.but_thread_voice_reply_selector);
            if (this.gzE != null) {
                this.gzE.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.gzE.setTextColor(i2);
            }
            if (this.ejn != null) {
                ak.c(this.ejn, d.a.voice_btn_play_anim);
            }
            this.ejn.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.ejn.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.ejr = voiceModel;
        if (this.ejr != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ob(this.ejr.elapse);
                return;
            }
            oc(this.ejr.voice_status.intValue());
            this.gzE.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ob(int i) {
        String formatVoiceTime;
        if (this.ejr != null && this.gzE != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.ejr.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ejr.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ejr.duration);
            }
            String a = k.a(this.gzE.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gzE.setText(formatVoiceTime);
            }
        }
    }

    public void oc(int i) {
        if (i == 3) {
            if (this.ejn != null) {
                this.ejn.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aHr();
            return;
        }
        aHs();
        if (i == 1) {
            if (this.ejn != null) {
                this.ejn.setVisibility(0);
            }
            if (this.ejr != null) {
                this.gzE.setText(VoiceManager.formatVoiceTime(this.ejr.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ejr != null) {
                this.gzE.setText(VoiceManager.formatVoiceTime(this.ejr.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.ejr != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.alg != null) {
                this.alg.onClick(view2);
            }
            TiebaStatic.log(this.ejr.from);
        }
    }

    private void btc() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.ejn != null) {
            this.ejn.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.ejn != null) {
            if (this.play_type == 0) {
                ak.c(this.ejn, d.f.icon_thread_voice_reply_curve_three);
            } else {
                ak.c(this.ejn, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aHr() {
        if (this.aIC != null) {
            this.aIC.stop();
        }
        btc();
        this.aIC = (AnimationDrawable) this.ejn.getDrawable();
        this.aIC.start();
    }

    public void aHs() {
        Drawable drawable = this.ejn.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aIC = (AnimationDrawable) drawable;
        }
        if (this.aIC != null) {
            this.aIC.stop();
        }
        this.aIC = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cXj = voiceManager;
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
        return this.cXj;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.KE();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.KD() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.yw();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.KD();
            setVoiceModel(voiceModel);
            btb();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.ejr != voiceModel) {
                oc(1);
            } else {
                oc(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aX(int i) {
        if (!btd()) {
            oc(1);
            return;
        }
        if (this.aIC == null) {
            oc(this.ejr.voice_status.intValue());
        }
        ob(i);
        if (this.ejr != null) {
            this.ejr.elapse = i;
        }
    }

    private boolean btd() {
        if (this.ejr == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.ejr);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ejr;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.ejr);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.ejr);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lZ() {
    }

    public void reset() {
        this.ejr = null;
        setTag(null);
        oc(1);
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
