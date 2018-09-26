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
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private AnimationDrawable aVo;
    private View.OnClickListener avZ;
    private VoiceManager dsk;
    private ImageView eKC;
    private VoiceData.VoiceModel eKG;
    private TextView gYR;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(e.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bP(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bP(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(e.C0141e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0141e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(e.C0141e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0141e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(e.h.play_voice_bnt, (ViewGroup) this, true);
        this.eKC = (ImageView) findViewById(e.g.playingImg);
        this.gYR = (TextView) findViewById(e.g.playTime);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bzU();
        setContentDescription(TbadkCoreApplication.getInst().getString(e.j.msglist_voice));
    }

    private void bzU() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.i(this, e.f.but_thread_voice_selector);
            if (this.gYR != null) {
                this.gYR.setTextSize(0, this.mContext.getResources().getDimension(e.C0141e.ds36));
                this.gYR.setTextColor(i);
            }
            if (this.eKC != null) {
                al.c(this.eKC, e.a.voice_btn_play_anim);
            }
            this.eKC.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            al.i(this, e.f.but_thread_voice_reply_selector);
            if (this.gYR != null) {
                this.gYR.setTextSize(0, this.mContext.getResources().getDimension(e.C0141e.ds28));
                this.gYR.setTextColor(i2);
            }
            if (this.eKC != null) {
                al.c(this.eKC, e.a.voice_btn_play_anim);
            }
            this.eKC.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.eKC.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eKG = voiceModel;
        if (this.eKG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                pk(this.eKG.elapse);
                return;
            }
            pl(this.eKG.voice_status.intValue());
            this.gYR.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void pk(int i) {
        String formatVoiceTime;
        if (this.eKG != null && this.gYR != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eKG.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKG.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKG.duration);
            }
            String a = k.a(this.gYR.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gYR.setText(formatVoiceTime);
            }
        }
    }

    public void pl(int i) {
        if (i == 3) {
            if (this.eKC != null) {
                this.eKC.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aQc();
            return;
        }
        aQd();
        if (i == 1) {
            if (this.eKC != null) {
                this.eKC.setVisibility(0);
            }
            if (this.eKG != null) {
                this.gYR.setText(VoiceManager.formatVoiceTime(this.eKG.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eKG != null) {
                this.gYR.setText(VoiceManager.formatVoiceTime(this.eKG.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eKG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.avZ != null) {
                this.avZ.onClick(view);
            }
            TiebaStatic.log(this.eKG.from);
        }
    }

    private void bzV() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        }
        if (this.eKC != null) {
            this.eKC.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.eKC != null) {
            if (this.play_type == 0) {
                al.c(this.eKC, e.f.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.eKC, e.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aQc() {
        if (this.aVo != null) {
            this.aVo.stop();
        }
        bzV();
        this.aVo = (AnimationDrawable) this.eKC.getDrawable();
        this.aVo.start();
    }

    public void aQd() {
        Drawable drawable = this.eKC.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aVo = (AnimationDrawable) drawable;
        }
        if (this.aVo != null) {
            this.aVo.stop();
        }
        this.aVo = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dsk = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dsk;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.PM();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.PL() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Dp();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.I(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.PL();
            setVoiceModel(voiceModel);
            bzU();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eKG != voiceModel) {
                pl(1);
            } else {
                pl(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (!bzW()) {
            pl(1);
            return;
        }
        if (this.aVo == null) {
            pl(this.eKG.voice_status.intValue());
        }
        pk(i);
        if (this.eKG != null) {
            this.eKG.elapse = i;
        }
    }

    private boolean bzW() {
        if (this.eKG == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eKG);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eKG;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eKG);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eKG);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pV() {
    }

    public void reset() {
        this.eKG = null;
        setTag(null);
        pl(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int aO = l.aO(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (aO * 0.3f);
                return (((i - 10) * (((int) (aO * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (aO * 0.45f);
        }
        int i3 = (int) (aO * 0.18f);
        int i4 = (int) (aO * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.avZ = onClickListener;
    }
}
