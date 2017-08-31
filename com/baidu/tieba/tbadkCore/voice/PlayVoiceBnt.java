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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
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
    private AnimationDrawable aHn;
    private View.OnClickListener ajG;
    private VoiceManager cpd;
    private ImageView dID;
    private VoiceData.VoiceModel dIH;
    private TextView glp;
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
            iArr[0] = (int) getContext().getResources().getDimension(d.f.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(d.f.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(d.f.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(d.f.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        ai(context);
        setOnClickListener(this);
    }

    public void ai(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt, (ViewGroup) this, true);
        this.dID = (ImageView) findViewById(d.h.playingImg);
        this.glp = (TextView) findViewById(d.h.playTime);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        btp();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.l.editor_record));
    }

    private void btp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.j(this, d.g.but_thread_voice_selector);
            if (this.glp != null) {
                this.glp.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds36));
                this.glp.setTextColor(i);
            }
            if (this.dID != null) {
                aj.c(this.dID, d.a.voice_btn_play_anim);
            }
            this.dID.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.j(this, d.g.but_thread_voice_reply_selector);
            if (this.glp != null) {
                this.glp.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds28));
                this.glp.setTextColor(i2);
            }
            if (this.dID != null) {
                aj.c(this.dID, d.a.voice_btn_play_anim);
            }
            this.dID.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dID.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dIH = voiceModel;
        if (this.dIH != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ni(this.dIH.elapse);
                return;
            }
            nj(this.dIH.voice_status.intValue());
            this.glp.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ni(int i) {
        String formatVoiceTime;
        if (this.dIH != null && this.glp != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dIH.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dIH.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dIH.duration);
            }
            String a = j.a(this.glp.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.glp.setText(formatVoiceTime);
            }
        }
    }

    public void nj(int i) {
        if (i == 3) {
            if (this.dID != null) {
                this.dID.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aAF();
            return;
        }
        aAG();
        if (i == 1) {
            if (this.dID != null) {
                this.dID.setVisibility(0);
            }
            if (this.dIH != null) {
                this.glp.setText(VoiceManager.formatVoiceTime(this.dIH.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dIH != null) {
                this.glp.setText(VoiceManager.formatVoiceTime(this.dIH.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dIH != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajG != null) {
                this.ajG.onClick(view);
            }
            TiebaStatic.log(this.dIH.from);
        }
    }

    private void btq() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.dID != null) {
            this.dID.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.dID != null) {
            if (this.play_type == 0) {
                aj.c(this.dID, d.g.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.dID, d.g.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aAF() {
        if (this.aHn != null) {
            this.aHn.stop();
        }
        btq();
        this.aHn = (AnimationDrawable) this.dID.getDrawable();
        this.aHn.start();
    }

    public void aAG() {
        Drawable drawable = this.dID.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aHn = (AnimationDrawable) drawable;
        }
        if (this.aHn != null) {
            this.aHn.stop();
        }
        this.aHn = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cpd = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.X(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.X(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.cpd;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Jp();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Jo() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.ym();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.F(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Jo();
            setVoiceModel(voiceModel);
            btp();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dIH != voiceModel) {
                nj(1);
            } else {
                nj(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (!btr()) {
            nj(1);
            return;
        }
        if (this.aHn == null) {
            nj(this.dIH.voice_status.intValue());
        }
        ni(i);
        if (this.dIH != null) {
            this.dIH.elapse = i;
        }
    }

    private boolean btr() {
        if (this.dIH == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dIH);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dIH;
    }

    public void bhr() {
        btp();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dIH);
        }
        if ((i.X(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.X(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dIH);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lR() {
    }

    public void reset() {
        this.dIH = null;
        setTag(null);
        nj(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int ad = k.ad(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (ad * 0.3f);
                return (((i - 10) * (((int) (ad * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (ad * 0.45f);
        }
        int i3 = (int) (ad * 0.18f);
        int i4 = (int) (ad * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajG = onClickListener;
    }
}
