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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aZD;
    private AnimationDrawable byf;
    private VoiceManager dEn;
    private VoiceData.VoiceModel dYQ;
    private ImageView eOH;
    private TextView hek;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cK(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cK(int i, int i2) {
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
        av(context);
        setOnClickListener(this);
    }

    public void av(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt, (ViewGroup) this, true);
        this.eOH = (ImageView) findViewById(d.g.playingImg);
        this.hek = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        byb();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.j.msglist_voice));
    }

    private void byb() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.s(this, d.f.but_thread_voice_selector);
            if (this.hek != null) {
                this.hek.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.hek.setTextColor(i);
            }
            if (this.eOH != null) {
                aj.c(this.eOH, d.a.voice_btn_play_anim);
            }
            this.eOH.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.s(this, d.f.but_thread_voice_reply_selector);
            if (this.hek != null) {
                this.hek.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.hek.setTextColor(i2);
            }
            if (this.eOH != null) {
                aj.c(this.eOH, d.a.voice_btn_play_anim);
            }
            this.eOH.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.eOH.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dYQ = voiceModel;
        if (this.dYQ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qG(this.dYQ.elapse);
                return;
            }
            of(this.dYQ.voice_status.intValue());
            this.hek.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qG(int i) {
        String formatVoiceTime;
        if (this.dYQ != null && this.hek != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dYQ.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dYQ.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dYQ.duration);
            }
            String a = k.a(this.hek.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hek.setText(formatVoiceTime);
            }
        }
    }

    public void of(int i) {
        if (i == 3) {
            if (this.eOH != null) {
                this.eOH.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aMr();
            return;
        }
        aMs();
        if (i == 1) {
            if (this.eOH != null) {
                this.eOH.setVisibility(0);
            }
            if (this.dYQ != null) {
                this.hek.setText(VoiceManager.formatVoiceTime(this.dYQ.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dYQ != null) {
                this.hek.setText(VoiceManager.formatVoiceTime(this.dYQ.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dYQ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aZD != null) {
                this.aZD.onClick(view);
            }
            TiebaStatic.log(this.dYQ.from);
        }
    }

    private void byc() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.eOH != null) {
            this.eOH.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.eOH != null) {
            if (this.play_type == 0) {
                aj.c(this.eOH, d.f.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.eOH, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aMr() {
        if (this.byf != null) {
            this.byf.stop();
        }
        byc();
        this.byf = (AnimationDrawable) this.eOH.getDrawable();
        this.byf.start();
    }

    public void aMs() {
        Drawable drawable = this.eOH.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.byf = (AnimationDrawable) drawable;
        }
        if (this.byf != null) {
            this.byf.stop();
        }
        this.byf = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEn = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dEn;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Se();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Sd() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.FJ();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Sd();
            setVoiceModel(voiceModel);
            byb();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dYQ != voiceModel) {
                of(1);
            } else {
                of(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (!byd()) {
            of(1);
            return;
        }
        if (this.byf == null) {
            of(this.dYQ.voice_status.intValue());
        }
        qG(i);
        if (this.dYQ != null) {
            this.dYQ.elapse = i;
        }
    }

    private boolean byd() {
        if (this.dYQ == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dYQ);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dYQ;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dYQ);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dYQ);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.dYQ = null;
        setTag(null);
        of(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int ao = l.ao(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (ao * 0.3f);
                return (((i - 10) * (((int) (ao * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (ao * 0.45f);
        }
        int i3 = (int) (ao * 0.18f);
        int i4 = (int) (ao * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aZD = onClickListener;
    }
}
