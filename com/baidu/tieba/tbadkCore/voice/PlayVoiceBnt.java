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
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private AnimationDrawable aRZ;
    private View.OnClickListener atF;
    private VoiceManager dmn;
    private ImageView eDm;
    private VoiceData.VoiceModel eDq;
    private TextView gRg;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(f.l.Voice_play_type_play_type, 0);
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
            iArr[0] = (int) getContext().getResources().getDimension(f.e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(f.e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(f.e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(f.e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        aq(context);
        setOnClickListener(this);
    }

    public void aq(Context context) {
        LayoutInflater.from(context).inflate(f.h.play_voice_bnt, (ViewGroup) this, true);
        this.eDm = (ImageView) findViewById(f.g.playingImg);
        this.gRg = (TextView) findViewById(f.g.playTime);
        this.mProgress = (ProgressBar) findViewById(f.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxm();
        setContentDescription(TbadkCoreApplication.getInst().getString(f.j.msglist_voice));
    }

    private void bxm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            am.i(this, f.C0146f.but_thread_voice_selector);
            if (this.gRg != null) {
                this.gRg.setTextSize(0, this.mContext.getResources().getDimension(f.e.ds36));
                this.gRg.setTextColor(i);
            }
            if (this.eDm != null) {
                am.c(this.eDm, f.a.voice_btn_play_anim);
            }
            this.eDm.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            am.i(this, f.C0146f.but_thread_voice_reply_selector);
            if (this.gRg != null) {
                this.gRg.setTextSize(0, this.mContext.getResources().getDimension(f.e.ds28));
                this.gRg.setTextColor(i2);
            }
            if (this.eDm != null) {
                am.c(this.eDm, f.a.voice_btn_play_anim);
            }
            this.eDm.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.eDm.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eDq = voiceModel;
        if (this.eDq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                oG(this.eDq.elapse);
                return;
            }
            oH(this.eDq.voice_status.intValue());
            this.gRg.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void oG(int i) {
        String formatVoiceTime;
        if (this.eDq != null && this.gRg != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eDq.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eDq.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eDq.duration);
            }
            String a = k.a(this.gRg.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gRg.setText(formatVoiceTime);
            }
        }
    }

    public void oH(int i) {
        if (i == 3) {
            if (this.eDm != null) {
                this.eDm.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aNN();
            return;
        }
        aNO();
        if (i == 1) {
            if (this.eDm != null) {
                this.eDm.setVisibility(0);
            }
            if (this.eDq != null) {
                this.gRg.setText(VoiceManager.formatVoiceTime(this.eDq.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eDq != null) {
                this.gRg.setText(VoiceManager.formatVoiceTime(this.eDq.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eDq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.atF != null) {
                this.atF.onClick(view);
            }
            TiebaStatic.log(this.eDq.from);
        }
    }

    private void bxn() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? f.a.voice_btn_play_anim : f.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? f.a.voice_btn_play_anim : f.a.voice_btn_play_anim_1;
        }
        if (this.eDm != null) {
            this.eDm.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.eDm != null) {
            if (this.play_type == 0) {
                am.c(this.eDm, f.C0146f.icon_thread_voice_reply_curve_three);
            } else {
                am.c(this.eDm, f.C0146f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aNN() {
        if (this.aRZ != null) {
            this.aRZ.stop();
        }
        bxn();
        this.aRZ = (AnimationDrawable) this.eDm.getDrawable();
        this.aRZ.start();
    }

    public void aNO() {
        Drawable drawable = this.eDm.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.aRZ = (AnimationDrawable) drawable;
        }
        if (this.aRZ != null) {
            this.aRZ.stop();
        }
        this.aRZ = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dmn = voiceManager;
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
        return this.dmn;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ot();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Os() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Cc();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.H(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Os();
            setVoiceModel(voiceModel);
            bxm();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eDq != voiceModel) {
                oH(1);
            } else {
                oH(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ba(int i) {
        if (!bxo()) {
            oH(1);
            return;
        }
        if (this.aRZ == null) {
            oH(this.eDq.voice_status.intValue());
        }
        oG(i);
        if (this.eDq != null) {
            this.eDq.elapse = i;
        }
    }

    private boolean bxo() {
        if (this.eDq == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eDq);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eDq;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eDq);
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eDq);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    public void reset() {
        this.eDq = null;
        setTag(null);
        oH(1);
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
        this.atF = onClickListener;
    }
}
