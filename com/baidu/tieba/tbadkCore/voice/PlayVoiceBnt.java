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
    private View.OnClickListener aXW;
    private AnimationDrawable bvN;
    private VoiceManager dwG;
    private ImageView eIt;
    private VoiceData.VoiceModel eIx;
    private TextView hlS;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cW(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cW(int i, int i2) {
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
        this.eIt = (ImageView) findViewById(d.g.playingImg);
        this.hlS = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bDo();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.j.msglist_voice));
    }

    private void bDo() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.s(this, d.f.but_thread_voice_selector);
            if (this.hlS != null) {
                this.hlS.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.hlS.setTextColor(i);
            }
            if (this.eIt != null) {
                aj.c(this.eIt, d.a.voice_btn_play_anim);
            }
            this.eIt.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.s(this, d.f.but_thread_voice_reply_selector);
            if (this.hlS != null) {
                this.hlS.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.hlS.setTextColor(i2);
            }
            if (this.eIt != null) {
                aj.c(this.eIt, d.a.voice_btn_play_anim);
            }
            this.eIt.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.eIt.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eIx = voiceModel;
        if (this.eIx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qK(this.eIx.elapse);
                return;
            }
            qL(this.eIx.voice_status.intValue());
            this.hlS.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qK(int i) {
        String formatVoiceTime;
        if (this.eIx != null && this.hlS != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eIx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eIx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eIx.duration);
            }
            String a = k.a(this.hlS.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hlS.setText(formatVoiceTime);
            }
        }
    }

    public void qL(int i) {
        if (i == 3) {
            if (this.eIt != null) {
                this.eIt.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aKF();
            return;
        }
        aKG();
        if (i == 1) {
            if (this.eIt != null) {
                this.eIt.setVisibility(0);
            }
            if (this.eIx != null) {
                this.hlS.setText(VoiceManager.formatVoiceTime(this.eIx.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eIx != null) {
                this.hlS.setText(VoiceManager.formatVoiceTime(this.eIx.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eIx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aXW != null) {
                this.aXW.onClick(view);
            }
            TiebaStatic.log(this.eIx.from);
        }
    }

    private void bDp() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.eIt != null) {
            this.eIt.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.eIt != null) {
            if (this.play_type == 0) {
                aj.c(this.eIt, d.f.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.eIt, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aKF() {
        if (this.bvN != null) {
            this.bvN.stop();
        }
        bDp();
        this.bvN = (AnimationDrawable) this.eIt.getDrawable();
        this.bvN.start();
    }

    public void aKG() {
        Drawable drawable = this.eIt.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.bvN = (AnimationDrawable) drawable;
        }
        if (this.bvN != null) {
            this.bvN.stop();
        }
        this.bvN = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dwG = voiceManager;
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
        return this.dwG;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.RK();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.RJ() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Fu();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.RJ();
            setVoiceModel(voiceModel);
            bDo();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eIx != voiceModel) {
                qL(1);
            } else {
                qL(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (!bDq()) {
            qL(1);
            return;
        }
        if (this.bvN == null) {
            qL(this.eIx.voice_status.intValue());
        }
        qK(i);
        if (this.eIx != null) {
            this.eIx.elapse = i;
        }
    }

    private boolean bDq() {
        if (this.eIx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eIx);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eIx;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eIx);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eIx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.eIx = null;
        setTag(null);
        qL(1);
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
        this.aXW = onClickListener;
    }
}
