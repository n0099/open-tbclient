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
    private View.OnClickListener aZN;
    private AnimationDrawable byp;
    private VoiceManager dEw;
    private ImageView eOD;
    private VoiceData.VoiceModel eOH;
    private TextView heb;
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
        this.eOD = (ImageView) findViewById(d.g.playingImg);
        this.heb = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxX();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.j.msglist_voice));
    }

    private void bxX() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.s(this, d.f.but_thread_voice_selector);
            if (this.heb != null) {
                this.heb.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.heb.setTextColor(i);
            }
            if (this.eOD != null) {
                aj.c(this.eOD, d.a.voice_btn_play_anim);
            }
            this.eOD.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.s(this, d.f.but_thread_voice_reply_selector);
            if (this.heb != null) {
                this.heb.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.heb.setTextColor(i2);
            }
            if (this.eOD != null) {
                aj.c(this.eOD, d.a.voice_btn_play_anim);
            }
            this.eOD.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.eOD.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eOH = voiceModel;
        if (this.eOH != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qF(this.eOH.elapse);
                return;
            }
            qG(this.eOH.voice_status.intValue());
            this.heb.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qF(int i) {
        String formatVoiceTime;
        if (this.eOH != null && this.heb != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eOH.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eOH.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eOH.duration);
            }
            String a = k.a(this.heb.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.heb.setText(formatVoiceTime);
            }
        }
    }

    public void qG(int i) {
        if (i == 3) {
            if (this.eOD != null) {
                this.eOD.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aMr();
            return;
        }
        aMs();
        if (i == 1) {
            if (this.eOD != null) {
                this.eOD.setVisibility(0);
            }
            if (this.eOH != null) {
                this.heb.setText(VoiceManager.formatVoiceTime(this.eOH.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eOH != null) {
                this.heb.setText(VoiceManager.formatVoiceTime(this.eOH.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eOH != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aZN != null) {
                this.aZN.onClick(view);
            }
            TiebaStatic.log(this.eOH.from);
        }
    }

    private void bxY() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.eOD != null) {
            this.eOD.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.eOD != null) {
            if (this.play_type == 0) {
                aj.c(this.eOD, d.f.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.eOD, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aMr() {
        if (this.byp != null) {
            this.byp.stop();
        }
        bxY();
        this.byp = (AnimationDrawable) this.eOD.getDrawable();
        this.byp.start();
    }

    public void aMs() {
        Drawable drawable = this.eOD.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.byp = (AnimationDrawable) drawable;
        }
        if (this.byp != null) {
            this.byp.stop();
        }
        this.byp = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dEw = voiceManager;
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
        return this.dEw;
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
            bxX();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eOH != voiceModel) {
                qG(1);
            } else {
                qG(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dU(int i) {
        if (!bxZ()) {
            qG(1);
            return;
        }
        if (this.byp == null) {
            qG(this.eOH.voice_status.intValue());
        }
        qF(i);
        if (this.eOH != null) {
            this.eOH.elapse = i;
        }
    }

    private boolean bxZ() {
        if (this.eOH == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eOH);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eOH;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eOH);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eOH);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.eOH = null;
        setTag(null);
        qG(1);
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
        this.aZN = onClickListener;
    }
}
