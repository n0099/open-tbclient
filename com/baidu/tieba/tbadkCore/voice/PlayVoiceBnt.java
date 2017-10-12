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
    private AnimationDrawable aGL;
    private View.OnClickListener ajh;
    private VoiceManager cqs;
    private ImageView dFN;
    private VoiceData.VoiceModel dFR;
    private TextView gjU;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bW(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bW(int i, int i2) {
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
        aj(context);
        setOnClickListener(this);
    }

    public void aj(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt, (ViewGroup) this, true);
        this.dFN = (ImageView) findViewById(d.h.playingImg);
        this.gjU = (TextView) findViewById(d.h.playTime);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bsy();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.l.editor_record));
    }

    private void bsy() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.j(this, d.g.but_thread_voice_selector);
            if (this.gjU != null) {
                this.gjU.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds36));
                this.gjU.setTextColor(i);
            }
            if (this.dFN != null) {
                aj.c(this.dFN, d.a.voice_btn_play_anim);
            }
            this.dFN.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.j(this, d.g.but_thread_voice_reply_selector);
            if (this.gjU != null) {
                this.gjU.setTextSize(0, this.mContext.getResources().getDimension(d.f.ds28));
                this.gjU.setTextColor(i2);
            }
            if (this.dFN != null) {
                aj.c(this.dFN, d.a.voice_btn_play_anim);
            }
            this.dFN.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dFN.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dFR = voiceModel;
        if (this.dFR != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ng(this.dFR.elapse);
                return;
            }
            nh(this.dFR.voice_status.intValue());
            this.gjU.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ng(int i) {
        String formatVoiceTime;
        if (this.dFR != null && this.gjU != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dFR.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dFR.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dFR.duration);
            }
            String a = k.a(this.gjU.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gjU.setText(formatVoiceTime);
            }
        }
    }

    public void nh(int i) {
        if (i == 3) {
            if (this.dFN != null) {
                this.dFN.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            azB();
            return;
        }
        azC();
        if (i == 1) {
            if (this.dFN != null) {
                this.dFN.setVisibility(0);
            }
            if (this.dFR != null) {
                this.gjU.setText(VoiceManager.formatVoiceTime(this.dFR.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dFR != null) {
                this.gjU.setText(VoiceManager.formatVoiceTime(this.dFR.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dFR != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajh != null) {
                this.ajh.onClick(view);
            }
            TiebaStatic.log(this.dFR.from);
        }
    }

    private void bsz() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.dFN != null) {
            this.dFN.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.dFN != null) {
            if (this.play_type == 0) {
                aj.c(this.dFN, d.g.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.dFN, d.g.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void azB() {
        if (this.aGL != null) {
            this.aGL.stop();
        }
        bsz();
        this.aGL = (AnimationDrawable) this.dFN.getDrawable();
        this.aGL.start();
    }

    public void azC() {
        Drawable drawable = this.dFN.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aGL = (AnimationDrawable) drawable;
        }
        if (this.aGL != null) {
            this.aGL.stop();
        }
        this.aGL = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cqs = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.cqs;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Jy();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Jx() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xL();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Jx();
            setVoiceModel(voiceModel);
            bsy();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dFR != voiceModel) {
                nh(1);
            } else {
                nh(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bsA()) {
            nh(1);
            return;
        }
        if (this.aGL == null) {
            nh(this.dFR.voice_status.intValue());
        }
        ng(i);
        if (this.dFR != null) {
            this.dFR.elapse = i;
        }
    }

    private boolean bsA() {
        if (this.dFR == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dFR);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dFR;
    }

    public void bgh() {
        bsy();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dFR);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dFR);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lT() {
    }

    public void reset() {
        this.dFR = null;
        setTag(null);
        nh(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int ad = l.ad(getContext());
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
        this.ajh = onClickListener;
    }
}
