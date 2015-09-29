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
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.r;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private ImageView bIM;
    private VoiceData.VoiceModel bIQ;
    private int daO;
    private TextView daP;
    private AnimationDrawable daQ;
    private Context mContext;
    private ProgressBar mProgress;
    private VoiceManager mVoiceManager;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (daR) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PLAY_TYPE[] valuesCustom() {
            PLAY_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            PLAY_TYPE[] play_typeArr = new PLAY_TYPE[length];
            System.arraycopy(valuesCustom, 0, play_typeArr, 0, length);
            return play_typeArr;
        }
    }

    public PlayVoiceBnt(Context context, PLAY_TYPE play_type) {
        super(context);
        this.daO = 0;
        this.daO = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.daO = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.Voice_play_type);
        this.daO = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(aI(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int aI(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.daO == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(i.d.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(i.d.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(i.d.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(i.d.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void init(Context context) {
        P(context);
        setOnClickListener(this);
    }

    public void P(Context context) {
        LayoutInflater.from(context).inflate(i.g.play_voice_bnt, (ViewGroup) this, true);
        this.bIM = (ImageView) findViewById(i.f.playingImg);
        this.daP = (TextView) findViewById(i.f.playTime);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        axz();
    }

    private void axz() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.daO == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            am.i(this, i.e.but_thread_voice_selector);
            if (this.daP != null) {
                this.daP.setTextSize(0, this.mContext.getResources().getDimension(i.d.voice_play_bnt_text_size_0));
                this.daP.setTextColor(i);
            }
            if (this.bIM != null) {
                am.c(this.bIM, i.a.voice_btn_play_anim);
            }
            this.bIM.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            am.i(this, i.e.but_thread_voice_reply_selector);
            if (this.daP != null) {
                this.daP.setTextSize(0, this.mContext.getResources().getDimension(i.d.voice_play_bnt_text_size_1));
                this.daP.setTextColor(i2);
            }
            if (this.bIM != null) {
                am.c(this.bIM, i.a.voice_btn_play_anim);
            }
            this.bIM.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.bIM.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.bIQ = voiceModel;
        if (this.bIQ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                hD(this.bIQ.elapse);
                return;
            }
            hE(this.bIQ.voice_status.intValue());
            this.daP.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void hD(int i) {
        String formatVoiceTime;
        if (this.bIQ != null && this.daP != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.bIQ.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bIQ.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bIQ.duration);
            }
            String a = j.a(this.daP.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.daP.setText(formatVoiceTime);
            }
        }
    }

    public void hE(int i) {
        if (i == 3) {
            if (this.bIM != null) {
                this.bIM.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            XC();
            return;
        }
        XD();
        if (i == 1) {
            if (this.bIM != null) {
                this.bIM.setVisibility(0);
            }
            if (this.bIQ != null) {
                this.daP.setText(VoiceManager.formatVoiceTime(this.bIQ.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bIQ != null) {
                this.daP.setText(VoiceManager.formatVoiceTime(this.bIQ.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bIQ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            TiebaStatic.log(this.bIQ.from);
        }
    }

    private void axA() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.daO == 0) {
            i = skinType != 1 ? i.a.voice_btn_play_anim : i.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? i.a.voice_btn_play_anim : i.a.voice_btn_play_anim_1;
        }
        if (this.bIM != null) {
            this.bIM.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bIM != null) {
            if (this.daO == 0) {
                am.c(this.bIM, i.e.icon_thread_voice_reply_curve_three);
            } else {
                am.c(this.bIM, i.e.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void XC() {
        if (this.daQ != null) {
            this.daQ.stop();
        }
        axA();
        this.daQ = (AnimationDrawable) this.bIM.getDrawable();
        this.daQ.start();
    }

    public void XD() {
        Drawable drawable = this.bIM.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.daQ = (AnimationDrawable) drawable;
        }
        if (this.daQ != null) {
            this.daQ.stop();
        }
        this.daQ = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.mVoiceManager = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.mVoiceManager;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof r)) {
            r rVar = (r) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) rVar.Fv();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (rVar.Fu() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = rVar.wf();
                voiceModel.duration = rVar.getDuration();
                rVar.C(voiceModel);
            }
            this.daO = rVar.Fu();
            setVoiceModel(voiceModel);
            axz();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.bIQ != voiceModel) {
                hE(1);
            } else {
                hE(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aI(int i) {
        if (!axB()) {
            hE(1);
            return;
        }
        if (this.daQ == null) {
            hE(this.bIQ.voice_status.intValue());
        }
        hD(i);
        if (this.bIQ != null) {
            this.bIQ.elapse = i;
        }
    }

    private boolean axB() {
        if (this.bIQ == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.bIQ);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bIQ;
    }

    public void axC() {
        axz();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getRealView(this.bIQ);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getRealView(this.bIQ);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oD() {
    }

    public void reset() {
        this.bIQ = null;
        setTag(null);
        hE(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int K = k.K(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (K * 0.3f);
                return (((i - 10) * (((int) (K * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (K * 0.45f);
        }
        int i3 = (int) (K * 0.18f);
        int i4 = (int) (K * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }
}
