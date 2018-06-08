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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private AnimationDrawable aRe;
    private View.OnClickListener ato;
    private VoiceManager dhB;
    private ImageView evI;
    private VoiceData.VoiceModel evM;
    private TextView gMf;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.m.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bN(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bN(int i, int i2) {
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
        aq(context);
        setOnClickListener(this);
    }

    public void aq(Context context) {
        LayoutInflater.from(context).inflate(d.i.play_voice_bnt, (ViewGroup) this, true);
        this.evI = (ImageView) findViewById(d.g.playingImg);
        this.gMf = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bye();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.k.msglist_voice));
    }

    private void bye() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.i(this, d.f.but_thread_voice_selector);
            if (this.gMf != null) {
                this.gMf.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.gMf.setTextColor(i);
            }
            if (this.evI != null) {
                al.c(this.evI, d.a.voice_btn_play_anim);
            }
            this.evI.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            al.i(this, d.f.but_thread_voice_reply_selector);
            if (this.gMf != null) {
                this.gMf.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.gMf.setTextColor(i2);
            }
            if (this.evI != null) {
                al.c(this.evI, d.a.voice_btn_play_anim);
            }
            this.evI.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.evI.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.evM = voiceModel;
        if (this.evM != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ol(this.evM.elapse);
                return;
            }
            om(this.evM.voice_status.intValue());
            this.gMf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ol(int i) {
        String formatVoiceTime;
        if (this.evM != null && this.gMf != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.evM.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.evM.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.evM.duration);
            }
            String a = k.a(this.gMf.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gMf.setText(formatVoiceTime);
            }
        }
    }

    public void om(int i) {
        if (i == 3) {
            if (this.evI != null) {
                this.evI.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aMk();
            return;
        }
        aMl();
        if (i == 1) {
            if (this.evI != null) {
                this.evI.setVisibility(0);
            }
            if (this.evM != null) {
                this.gMf.setText(VoiceManager.formatVoiceTime(this.evM.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.evM != null) {
                this.gMf.setText(VoiceManager.formatVoiceTime(this.evM.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.evM != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ato != null) {
                this.ato.onClick(view);
            }
            TiebaStatic.log(this.evM.from);
        }
    }

    private void byf() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.evI != null) {
            this.evI.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.evI != null) {
            if (this.play_type == 0) {
                al.c(this.evI, d.f.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.evI, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aMk() {
        if (this.aRe != null) {
            this.aRe.stop();
        }
        byf();
        this.aRe = (AnimationDrawable) this.evI.getDrawable();
        this.aRe.start();
    }

    public void aMl() {
        Drawable drawable = this.evI.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aRe = (AnimationDrawable) drawable;
        }
        if (this.aRe != null) {
            this.aRe.stop();
        }
        this.aRe = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dhB = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dhB;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ob();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Oa() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.BV();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.H(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Oa();
            setVoiceModel(voiceModel);
            bye();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.evM != voiceModel) {
                om(1);
            } else {
                om(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aZ(int i) {
        if (!byg()) {
            om(1);
            return;
        }
        if (this.aRe == null) {
            om(this.evM.voice_status.intValue());
        }
        ol(i);
        if (this.evM != null) {
            this.evM.elapse = i;
        }
    }

    private boolean byg() {
        if (this.evM == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.evM);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.evM;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.evM);
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.evM);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    public void reset() {
        this.evM = null;
        setTag(null);
        om(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int ah = l.ah(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (ah * 0.3f);
                return (((i - 10) * (((int) (ah * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (ah * 0.45f);
        }
        int i3 = (int) (ah * 0.18f);
        int i4 = (int) (ah * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ato = onClickListener;
    }
}
