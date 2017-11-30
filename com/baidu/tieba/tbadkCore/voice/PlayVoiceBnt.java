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
    private AnimationDrawable aHS;
    private View.OnClickListener ajN;
    private VoiceManager cGZ;
    private ImageView dVg;
    private VoiceData.VoiceModel dVk;
    private TextView gCr;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bY(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bY(int i, int i2) {
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
        ai(context);
        setOnClickListener(this);
    }

    public void ai(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt, (ViewGroup) this, true);
        this.dVg = (ImageView) findViewById(d.g.playingImg);
        this.gCr = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxr();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.j.msglist_voice));
    }

    private void bxr() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.j(this, d.f.but_thread_voice_selector);
            if (this.gCr != null) {
                this.gCr.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.gCr.setTextColor(i);
            }
            if (this.dVg != null) {
                aj.c(this.dVg, d.a.voice_btn_play_anim);
            }
            this.dVg.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.j(this, d.f.but_thread_voice_reply_selector);
            if (this.gCr != null) {
                this.gCr.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.gCr.setTextColor(i2);
            }
            if (this.dVg != null) {
                aj.c(this.dVg, d.a.voice_btn_play_anim);
            }
            this.dVg.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dVg.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dVk = voiceModel;
        if (this.dVk != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nL(this.dVk.elapse);
                return;
            }
            nM(this.dVk.voice_status.intValue());
            this.gCr.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nL(int i) {
        String formatVoiceTime;
        if (this.dVk != null && this.gCr != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dVk.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dVk.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dVk.duration);
            }
            String a = k.a(this.gCr.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gCr.setText(formatVoiceTime);
            }
        }
    }

    public void nM(int i) {
        if (i == 3) {
            if (this.dVg != null) {
                this.dVg.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aDv();
            return;
        }
        aDw();
        if (i == 1) {
            if (this.dVg != null) {
                this.dVg.setVisibility(0);
            }
            if (this.dVk != null) {
                this.gCr.setText(VoiceManager.formatVoiceTime(this.dVk.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dVk != null) {
                this.gCr.setText(VoiceManager.formatVoiceTime(this.dVk.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dVk != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajN != null) {
                this.ajN.onClick(view);
            }
            TiebaStatic.log(this.dVk.from);
        }
    }

    private void bxs() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.dVg != null) {
            this.dVg.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.dVg != null) {
            if (this.play_type == 0) {
                aj.c(this.dVg, d.f.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.dVg, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aDv() {
        if (this.aHS != null) {
            this.aHS.stop();
        }
        bxs();
        this.aHS = (AnimationDrawable) this.dVg.getDrawable();
        this.aHS.start();
    }

    public void aDw() {
        Drawable drawable = this.dVg.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aHS = (AnimationDrawable) drawable;
        }
        if (this.aHS != null) {
            this.aHS.stop();
        }
        this.aHS = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cGZ = voiceManager;
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
        return this.cGZ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Kk();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Kj() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xU();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Kj();
            setVoiceModel(voiceModel);
            bxr();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dVk != voiceModel) {
                nM(1);
            } else {
                nM(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bxt()) {
            nM(1);
            return;
        }
        if (this.aHS == null) {
            nM(this.dVk.voice_status.intValue());
        }
        nL(i);
        if (this.dVk != null) {
            this.dVk.elapse = i;
        }
    }

    private boolean bxt() {
        if (this.dVk == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dVk);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dVk;
    }

    public void blz() {
        bxr();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dVk);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dVk);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void reset() {
        this.dVk = null;
        setTag(null);
        nM(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int ac = l.ac(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (ac * 0.3f);
                return (((i - 10) * (((int) (ac * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (ac * 0.45f);
        }
        int i3 = (int) (ac * 0.18f);
        int i4 = (int) (ac * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajN = onClickListener;
    }
}
