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
    private View.OnClickListener aFC;
    private AnimationDrawable beN;
    private VoiceManager dLz;
    private ImageView fdX;
    private VoiceData.VoiceModel feb;
    private TextView hsW;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bV(i, getBtnWidth()), AiAppsFileUtils.GB), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], AiAppsFileUtils.GB));
    }

    private int bV(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(e.C0210e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0210e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(e.C0210e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0210e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(e.h.play_voice_bnt, (ViewGroup) this, true);
        this.fdX = (ImageView) findViewById(e.g.playingImg);
        this.hsW = (TextView) findViewById(e.g.playTime);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bFY();
        setContentDescription(TbadkCoreApplication.getInst().getString(e.j.msglist_voice));
    }

    private void bFY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.i(this, e.f.but_thread_voice_selector);
            if (this.hsW != null) {
                this.hsW.setTextSize(0, this.mContext.getResources().getDimension(e.C0210e.ds36));
                this.hsW.setTextColor(i);
            }
            if (this.fdX != null) {
                al.c(this.fdX, e.a.voice_btn_play_anim);
            }
            this.fdX.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? -16777216 : -8682095;
            al.i(this, e.f.but_thread_voice_reply_selector);
            if (this.hsW != null) {
                this.hsW.setTextSize(0, this.mContext.getResources().getDimension(e.C0210e.ds28));
                this.hsW.setTextColor(i2);
            }
            if (this.fdX != null) {
                al.c(this.fdX, e.a.voice_btn_play_anim);
            }
            this.fdX.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.fdX.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.feb = voiceModel;
        if (this.feb != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qJ(this.feb.elapse);
                return;
            }
            qK(this.feb.voice_status.intValue());
            this.hsW.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qJ(int i) {
        String formatVoiceTime;
        if (this.feb != null && this.hsW != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.feb.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.feb.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.feb.duration);
            }
            String a = k.a(this.hsW.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hsW.setText(formatVoiceTime);
            }
        }
    }

    public void qK(int i) {
        if (i == 3) {
            if (this.fdX != null) {
                this.fdX.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aVS();
            return;
        }
        aVT();
        if (i == 1) {
            if (this.fdX != null) {
                this.fdX.setVisibility(0);
            }
            if (this.feb != null) {
                this.hsW.setText(VoiceManager.formatVoiceTime(this.feb.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.feb != null) {
                this.hsW.setText(VoiceManager.formatVoiceTime(this.feb.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.feb != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aFC != null) {
                this.aFC.onClick(view);
            }
            TiebaStatic.log(this.feb.from);
        }
    }

    private void bFZ() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        }
        if (this.fdX != null) {
            this.fdX.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.fdX != null) {
            if (this.play_type == 0) {
                al.c(this.fdX, e.f.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.fdX, e.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aVS() {
        if (this.beN != null) {
            this.beN.stop();
        }
        bFZ();
        this.beN = (AnimationDrawable) this.fdX.getDrawable();
        this.beN.start();
    }

    public void aVT() {
        Drawable drawable = this.fdX.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.beN = (AnimationDrawable) drawable;
        }
        if (this.beN != null) {
            this.beN.stop();
        }
        this.beN = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dLz = voiceManager;
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
        return this.dLz;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Tu();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Tt() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.GU();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Tt();
            setVoiceModel(voiceModel);
            bFY();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.feb != voiceModel) {
                qK(1);
            } else {
                qK(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (!bGa()) {
            qK(1);
            return;
        }
        if (this.beN == null) {
            qK(this.feb.voice_status.intValue());
        }
        qJ(i);
        if (this.feb != null) {
            this.feb.elapse = i;
        }
    }

    private boolean bGa() {
        if (this.feb == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.feb);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.feb;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.feb);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.feb);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qd() {
    }

    public void reset() {
        this.feb = null;
        setTag(null);
        qK(1);
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
        this.aFC = onClickListener;
    }
}
