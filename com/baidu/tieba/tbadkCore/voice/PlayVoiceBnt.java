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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener bWq;
    private AnimationDrawable fBl;
    private VoiceManager fun;
    private ImageView gSk;
    private VoiceData.VoiceModel gSo;
    private TextView jjH;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cD(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cD(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        ao(context);
        setOnClickListener(this);
    }

    public void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.gSk = (ImageView) findViewById(R.id.playingImg);
        this.jjH = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cqS();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void cqS() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            am.k(this, R.drawable.but_thread_voice_selector);
            if (this.jjH != null) {
                this.jjH.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.jjH.setTextColor(i);
            }
            if (this.gSk != null) {
                am.c(this.gSk, (int) R.anim.voice_btn_play_anim);
            }
            this.gSk.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            am.k(this, R.drawable.but_thread_voice_reply_selector);
            if (this.jjH != null) {
                this.jjH.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.jjH.setTextColor(i2);
            }
            if (this.gSk != null) {
                am.c(this.gSk, (int) R.anim.voice_btn_play_anim);
            }
            this.gSk.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.gSk.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gSo = voiceModel;
        if (this.gSo != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                vZ(this.gSo.elapse);
                return;
            }
            wa(this.gSo.voice_status.intValue());
            this.jjH.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void vZ(int i) {
        String formatVoiceTime;
        if (this.gSo != null && this.jjH != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gSo.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gSo.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gSo.duration);
            }
            String a = k.a(this.jjH.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.jjH.setText(formatVoiceTime);
            }
        }
    }

    public void wa(int i) {
        if (i == 3) {
            if (this.gSk != null) {
                this.gSk.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bHb();
            return;
        }
        bHc();
        if (i == 1) {
            if (this.gSk != null) {
                this.gSk.setVisibility(0);
            }
            if (this.gSo != null) {
                this.jjH.setText(VoiceManager.formatVoiceTime(this.gSo.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gSo != null) {
                this.jjH.setText(VoiceManager.formatVoiceTime(this.gSo.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gSo != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bWq != null) {
                this.bWq.onClick(view);
            }
            TiebaStatic.log(this.gSo.from);
        }
    }

    private void cqT() {
        int i = R.anim.voice_btn_play_anim;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            if (skinType == 1) {
                i = R.anim.voice_btn_play_anim_1;
            }
        } else if (skinType == 1) {
            i = R.anim.voice_btn_play_anim_1;
        }
        if (this.gSk != null) {
            this.gSk.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.gSk != null) {
            if (this.play_type == 0) {
                am.c(this.gSk, (int) R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                am.c(this.gSk, (int) R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void bHb() {
        if (this.fBl != null) {
            this.fBl.stop();
        }
        cqT();
        this.fBl = (AnimationDrawable) this.gSk.getDrawable();
        this.fBl.start();
    }

    public void bHc() {
        Drawable drawable = this.gSk.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.fBl = (AnimationDrawable) drawable;
        }
        if (this.fBl != null) {
            this.fBl.stop();
        }
        this.fBl = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.fun = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.fun;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.azK();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.azJ() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.amq();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.azJ();
            setVoiceModel(voiceModel);
            cqS();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gSo != voiceModel) {
                wa(1);
            } else {
                wa(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (!cqU()) {
            wa(1);
            return;
        }
        if (this.fBl == null) {
            wa(this.gSo.voice_status.intValue());
        }
        vZ(i);
        if (this.gSo != null) {
            this.gSo.elapse = i;
        }
    }

    private boolean cqU() {
        if (this.gSo == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gSo);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gSo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gSo);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gSo);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qx() {
    }

    public void reset() {
        this.gSo = null;
        setTag(null);
        wa(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int af = l.af(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (af * 0.3f);
                return (((i - 10) * (((int) (af * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (af * 0.45f);
        }
        int i3 = (int) (af * 0.18f);
        int i4 = (int) (af * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWq = onClickListener;
    }
}
