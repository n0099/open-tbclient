package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
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
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
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
    private View.OnClickListener aAK;
    private AnimationDrawable aZN;
    private VoiceManager dAm;
    private ImageView eSm;
    private VoiceData.VoiceModel eSq;
    private TextView hgk;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bS(i, getBtnWidth()), AiAppsFileUtils.GB), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], AiAppsFileUtils.GB));
    }

    private int bS(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(e.C0175e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0175e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(e.C0175e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0175e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(e.h.play_voice_bnt, (ViewGroup) this, true);
        this.eSm = (ImageView) findViewById(e.g.playingImg);
        this.hgk = (TextView) findViewById(e.g.playTime);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bDi();
        setContentDescription(TbadkCoreApplication.getInst().getString(e.j.msglist_voice));
    }

    private void bDi() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.i(this, e.f.but_thread_voice_selector);
            if (this.hgk != null) {
                this.hgk.setTextSize(0, this.mContext.getResources().getDimension(e.C0175e.ds36));
                this.hgk.setTextColor(i);
            }
            if (this.eSm != null) {
                al.c(this.eSm, e.a.voice_btn_play_anim);
            }
            this.eSm.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? -16777216 : -8682095;
            al.i(this, e.f.but_thread_voice_reply_selector);
            if (this.hgk != null) {
                this.hgk.setTextSize(0, this.mContext.getResources().getDimension(e.C0175e.ds28));
                this.hgk.setTextColor(i2);
            }
            if (this.eSm != null) {
                al.c(this.eSm, e.a.voice_btn_play_anim);
            }
            this.eSm.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.eSm.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eSq = voiceModel;
        if (this.eSq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                pI(this.eSq.elapse);
                return;
            }
            pJ(this.eSq.voice_status.intValue());
            this.hgk.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void pI(int i) {
        String formatVoiceTime;
        if (this.eSq != null && this.hgk != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eSq.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eSq.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eSq.duration);
            }
            String a = k.a(this.hgk.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hgk.setText(formatVoiceTime);
            }
        }
    }

    public void pJ(int i) {
        if (i == 3) {
            if (this.eSm != null) {
                this.eSm.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aTq();
            return;
        }
        aTr();
        if (i == 1) {
            if (this.eSm != null) {
                this.eSm.setVisibility(0);
            }
            if (this.eSq != null) {
                this.hgk.setText(VoiceManager.formatVoiceTime(this.eSq.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eSq != null) {
                this.hgk.setText(VoiceManager.formatVoiceTime(this.eSq.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eSq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aAK != null) {
                this.aAK.onClick(view);
            }
            TiebaStatic.log(this.eSq.from);
        }
    }

    private void bDj() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        }
        if (this.eSm != null) {
            this.eSm.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.eSm != null) {
            if (this.play_type == 0) {
                al.c(this.eSm, e.f.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.eSm, e.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aTq() {
        if (this.aZN != null) {
            this.aZN.stop();
        }
        bDj();
        this.aZN = (AnimationDrawable) this.eSm.getDrawable();
        this.aZN.start();
    }

    public void aTr() {
        Drawable drawable = this.eSm.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aZN = (AnimationDrawable) drawable;
        }
        if (this.aZN != null) {
            this.aZN.stop();
        }
        this.aZN = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dAm = voiceManager;
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
        return this.dAm;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.RH();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.RG() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Fq();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.RG();
            setVoiceModel(voiceModel);
            bDi();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eSq != voiceModel) {
                pJ(1);
            } else {
                pJ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (!bDk()) {
            pJ(1);
            return;
        }
        if (this.aZN == null) {
            pJ(this.eSq.voice_status.intValue());
        }
        pI(i);
        if (this.eSq != null) {
            this.eSq.elapse = i;
        }
    }

    private boolean bDk() {
        if (this.eSq == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eSq);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eSq;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eSq);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eSq);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qc() {
    }

    public void reset() {
        this.eSq = null;
        setTag(null);
        pJ(1);
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
        this.aAK = onClickListener;
    }
}
