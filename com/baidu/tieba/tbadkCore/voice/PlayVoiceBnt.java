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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener bVj;
    private VoiceManager foP;
    private AnimationDrawable fvB;
    private ImageView gLi;
    private VoiceData.VoiceModel gLm;
    private TextView jci;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cy(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cy(int i, int i2) {
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
        this.gLi = (ImageView) findViewById(R.id.playingImg);
        this.jci = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cnD();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void cnD() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.k(this, R.drawable.but_thread_voice_selector);
            if (this.jci != null) {
                this.jci.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.jci.setTextColor(i);
            }
            if (this.gLi != null) {
                al.c(this.gLi, (int) R.anim.voice_btn_play_anim);
            }
            this.gLi.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            al.k(this, R.drawable.but_thread_voice_reply_selector);
            if (this.jci != null) {
                this.jci.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.jci.setTextColor(i2);
            }
            if (this.gLi != null) {
                al.c(this.gLi, (int) R.anim.voice_btn_play_anim);
            }
            this.gLi.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.gLi.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gLm = voiceModel;
        if (this.gLm != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                vw(this.gLm.elapse);
                return;
            }
            vx(this.gLm.voice_status.intValue());
            this.jci.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void vw(int i) {
        String formatVoiceTime;
        if (this.gLm != null && this.jci != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gLm.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gLm.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gLm.duration);
            }
            String a = k.a(this.jci.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.jci.setText(formatVoiceTime);
            }
        }
    }

    public void vx(int i) {
        if (i == 3) {
            if (this.gLi != null) {
                this.gLi.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bEg();
            return;
        }
        bEh();
        if (i == 1) {
            if (this.gLi != null) {
                this.gLi.setVisibility(0);
            }
            if (this.gLm != null) {
                this.jci.setText(VoiceManager.formatVoiceTime(this.gLm.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gLm != null) {
                this.jci.setText(VoiceManager.formatVoiceTime(this.gLm.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gLm != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bVj != null) {
                this.bVj.onClick(view);
            }
            TiebaStatic.log(this.gLm.from);
        }
    }

    private void cnE() {
        int i = R.anim.voice_btn_play_anim;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            if (skinType == 1) {
                i = R.anim.voice_btn_play_anim_1;
            }
        } else if (skinType == 1) {
            i = R.anim.voice_btn_play_anim_1;
        }
        if (this.gLi != null) {
            this.gLi.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.gLi != null) {
            if (this.play_type == 0) {
                al.c(this.gLi, (int) R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.gLi, (int) R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void bEg() {
        if (this.fvB != null) {
            this.fvB.stop();
        }
        cnE();
        this.fvB = (AnimationDrawable) this.gLi.getDrawable();
        this.fvB.start();
    }

    public void bEh() {
        Drawable drawable = this.gLi.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.fvB = (AnimationDrawable) drawable;
        }
        if (this.fvB != null) {
            this.fvB.stop();
        }
        this.fvB = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.foP = voiceManager;
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
        return this.foP;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.ayw();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.ayv() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.alj();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.ayv();
            setVoiceModel(voiceModel);
            cnD();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gLm != voiceModel) {
                vx(1);
            } else {
                vx(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (!cnF()) {
            vx(1);
            return;
        }
        if (this.fvB == null) {
            vx(this.gLm.voice_status.intValue());
        }
        vw(i);
        if (this.gLm != null) {
            this.gLm.elapse = i;
        }
    }

    private boolean cnF() {
        if (this.gLm == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gLm);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gLm;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gLm);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gLm);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qb() {
    }

    public void reset() {
        this.gLm = null;
        setTag(null);
        vx(1);
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
        this.bVj = onClickListener;
    }
}
