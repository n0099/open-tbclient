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
    private AnimationDrawable aHZ;
    private View.OnClickListener ajN;
    private VoiceManager cHl;
    private ImageView dWp;
    private VoiceData.VoiceModel dWt;
    private TextView gFf;
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bZ(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bZ(int i, int i2) {
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
        this.dWp = (ImageView) findViewById(d.g.playingImg);
        this.gFf = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxY();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.j.msglist_voice));
    }

    private void bxY() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aj.j(this, d.f.but_thread_voice_selector);
            if (this.gFf != null) {
                this.gFf.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.gFf.setTextColor(i);
            }
            if (this.dWp != null) {
                aj.c(this.dWp, d.a.voice_btn_play_anim);
            }
            this.dWp.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aj.j(this, d.f.but_thread_voice_reply_selector);
            if (this.gFf != null) {
                this.gFf.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.gFf.setTextColor(i2);
            }
            if (this.dWp != null) {
                aj.c(this.dWp, d.a.voice_btn_play_anim);
            }
            this.dWp.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dWp.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dWt = voiceModel;
        if (this.dWt != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nS(this.dWt.elapse);
                return;
            }
            nT(this.dWt.voice_status.intValue());
            this.gFf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nS(int i) {
        String formatVoiceTime;
        if (this.dWt != null && this.gFf != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dWt.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dWt.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dWt.duration);
            }
            String a = k.a(this.gFf.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gFf.setText(formatVoiceTime);
            }
        }
    }

    public void nT(int i) {
        if (i == 3) {
            if (this.dWp != null) {
                this.dWp.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aDE();
            return;
        }
        aDF();
        if (i == 1) {
            if (this.dWp != null) {
                this.dWp.setVisibility(0);
            }
            if (this.dWt != null) {
                this.gFf.setText(VoiceManager.formatVoiceTime(this.dWt.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dWt != null) {
                this.gFf.setText(VoiceManager.formatVoiceTime(this.dWt.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dWt != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajN != null) {
                this.ajN.onClick(view);
            }
            TiebaStatic.log(this.dWt.from);
        }
    }

    private void bxZ() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.dWp != null) {
            this.dWp.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.dWp != null) {
            if (this.play_type == 0) {
                aj.c(this.dWp, d.f.icon_thread_voice_reply_curve_three);
            } else {
                aj.c(this.dWp, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aDE() {
        if (this.aHZ != null) {
            this.aHZ.stop();
        }
        bxZ();
        this.aHZ = (AnimationDrawable) this.dWp.getDrawable();
        this.aHZ.start();
    }

    public void aDF() {
        Drawable drawable = this.dWp.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aHZ = (AnimationDrawable) drawable;
        }
        if (this.aHZ != null) {
            this.aHZ.stop();
        }
        this.aHZ = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cHl = voiceManager;
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
        return this.cHl;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Kl();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Kk() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xV();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Kk();
            setVoiceModel(voiceModel);
            bxY();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dWt != voiceModel) {
                nT(1);
            } else {
                nT(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (!bya()) {
            nT(1);
            return;
        }
        if (this.aHZ == null) {
            nT(this.dWt.voice_status.intValue());
        }
        nS(i);
        if (this.dWt != null) {
            this.dWt.elapse = i;
        }
    }

    private boolean bya() {
        if (this.dWt == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dWt);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dWt;
    }

    public void bmf() {
        bxY();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dWt);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dWt);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lQ() {
    }

    public void reset() {
        this.dWt = null;
        setTag(null);
        nT(1);
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
