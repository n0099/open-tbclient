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
    private View.OnClickListener aYd;
    private AnimationDrawable bwf;
    private VoiceManager dBC;
    private ImageView eKo;
    private VoiceData.VoiceModel eKs;
    private TextView hbN;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cP(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cP(int i, int i2) {
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
        this.eKo = (ImageView) findViewById(d.g.playingImg);
        this.hbN = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bwN();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.j.msglist_voice));
    }

    private void bwN() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.s(this, d.f.but_thread_voice_selector);
            if (this.hbN != null) {
                this.hbN.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.hbN.setTextColor(i);
            }
            if (this.eKo != null) {
                aj.c(this.eKo, d.a.voice_btn_play_anim);
            }
            this.eKo.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.s(this, d.f.but_thread_voice_reply_selector);
            if (this.hbN != null) {
                this.hbN.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.hbN.setTextColor(i2);
            }
            if (this.eKo != null) {
                aj.c(this.eKo, d.a.voice_btn_play_anim);
            }
            this.eKo.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.eKo.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eKs = voiceModel;
        if (this.eKs != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qD(this.eKs.elapse);
                return;
            }
            qE(this.eKs.voice_status.intValue());
            this.hbN.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qD(int i) {
        String formatVoiceTime;
        if (this.eKs != null && this.hbN != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eKs.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKs.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eKs.duration);
            }
            String a = k.a(this.hbN.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hbN.setText(formatVoiceTime);
            }
        }
    }

    public void qE(int i) {
        if (i == 3) {
            if (this.eKo != null) {
                this.eKo.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aKP();
            return;
        }
        aKQ();
        if (i == 1) {
            if (this.eKo != null) {
                this.eKo.setVisibility(0);
            }
            if (this.eKs != null) {
                this.hbN.setText(VoiceManager.formatVoiceTime(this.eKs.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eKs != null) {
                this.hbN.setText(VoiceManager.formatVoiceTime(this.eKs.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eKs != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aYd != null) {
                this.aYd.onClick(view);
            }
            TiebaStatic.log(this.eKs.from);
        }
    }

    private void bwO() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.eKo != null) {
            this.eKo.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.eKo != null) {
            if (this.play_type == 0) {
                aj.c(this.eKo, d.f.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.eKo, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aKP() {
        if (this.bwf != null) {
            this.bwf.stop();
        }
        bwO();
        this.bwf = (AnimationDrawable) this.eKo.getDrawable();
        this.bwf.start();
    }

    public void aKQ() {
        Drawable drawable = this.eKo.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.bwf = (AnimationDrawable) drawable;
        }
        if (this.bwf != null) {
            this.bwf.stop();
        }
        this.bwf = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dBC = voiceManager;
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
        return this.dBC;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.RA();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Rz() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Fn();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Rz();
            setVoiceModel(voiceModel);
            bwN();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eKs != voiceModel) {
                qE(1);
            } else {
                qE(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (!bwP()) {
            qE(1);
            return;
        }
        if (this.bwf == null) {
            qE(this.eKs.voice_status.intValue());
        }
        qD(i);
        if (this.eKs != null) {
            this.eKs.elapse = i;
        }
    }

    private boolean bwP() {
        if (this.eKs == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eKs);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eKs;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eKs);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eKs);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tu() {
    }

    public void reset() {
        this.eKs = null;
        setTag(null);
        qE(1);
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
        this.aYd = onClickListener;
    }
}
