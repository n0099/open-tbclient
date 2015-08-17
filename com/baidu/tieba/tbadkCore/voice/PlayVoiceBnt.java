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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.r;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private ImageView bFa;
    private VoiceData.VoiceModel bFe;
    private int cKJ;
    private TextView cKK;
    private AnimationDrawable cKL;
    private Context mContext;
    private ProgressBar mProgress;
    private VoiceManager mVoiceManager;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (cKM) with 'values()' method */
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
        this.cKJ = 0;
        this.cKJ = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.cKJ = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.k.Voice_play_type);
        this.cKJ = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(aA(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int aA(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.cKJ == 0) {
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
        this.bFa = (ImageView) findViewById(i.f.playingImg);
        this.cKK = (TextView) findViewById(i.f.playTime);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        aqY();
    }

    private void aqY() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cKJ == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.i(this, i.e.but_thread_voice_selector);
            if (this.cKK != null) {
                this.cKK.setTextSize(0, this.mContext.getResources().getDimension(i.d.voice_play_bnt_text_size_0));
                this.cKK.setTextColor(i);
            }
            if (this.bFa != null) {
                al.c(this.bFa, i.a.voice_btn_play_anim);
            }
            this.bFa.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            al.i(this, i.e.but_thread_voice_reply_selector);
            if (this.cKK != null) {
                this.cKK.setTextSize(0, this.mContext.getResources().getDimension(i.d.voice_play_bnt_text_size_1));
                this.cKK.setTextColor(i2);
            }
            if (this.bFa != null) {
                al.c(this.bFa, i.a.voice_btn_play_anim);
            }
            this.bFa.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.bFa.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.bFe = voiceModel;
        if (this.bFe != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                hn(this.bFe.elapse);
                return;
            }
            ho(this.bFe.voice_status.intValue());
            this.cKK.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void hn(int i) {
        String formatVoiceTime;
        if (this.bFe != null && this.cKK != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.bFe.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bFe.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bFe.duration);
            }
            String a = j.a(this.cKK.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.cKK.setText(formatVoiceTime);
            }
        }
    }

    public void ho(int i) {
        if (i == 3) {
            if (this.bFa != null) {
                this.bFa.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            WS();
            return;
        }
        WT();
        if (i == 1) {
            if (this.bFa != null) {
                this.bFa.setVisibility(0);
            }
            if (this.bFe != null) {
                this.cKK.setText(VoiceManager.formatVoiceTime(this.bFe.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bFe != null) {
                this.cKK.setText(VoiceManager.formatVoiceTime(this.bFe.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bFe != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            TiebaStatic.log(this.bFe.from);
        }
    }

    private void aqZ() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cKJ == 0) {
            i = skinType != 1 ? i.a.voice_btn_play_anim : i.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? i.a.voice_btn_play_anim : i.a.voice_btn_play_anim_1;
        }
        if (this.bFa != null) {
            this.bFa.setImageResource(i);
        }
    }

    private void ES() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bFa != null) {
            if (this.cKJ == 0) {
                al.c(this.bFa, i.e.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.bFa, i.e.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void WS() {
        if (this.cKL != null) {
            this.cKL.stop();
        }
        aqZ();
        this.cKL = (AnimationDrawable) this.bFa.getDrawable();
        this.cKL.start();
    }

    public void WT() {
        Drawable drawable = this.bFa.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cKL = (AnimationDrawable) drawable;
        }
        if (this.cKL != null) {
            this.cKL.stop();
        }
        this.cKL = null;
        ES();
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
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) rVar.Fx();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (rVar.Fw() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = rVar.wo();
                voiceModel.duration = rVar.getDuration();
                rVar.B(voiceModel);
            }
            this.cKJ = rVar.Fw();
            setVoiceModel(voiceModel);
            aqY();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.bFe != voiceModel) {
                ho(1);
            } else {
                ho(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aI(int i) {
        if (!ara()) {
            ho(1);
            return;
        }
        if (this.cKL == null) {
            ho(this.bFe.voice_status.intValue());
        }
        hn(i);
        if (this.bFe != null) {
            this.bFe.elapse = i;
        }
    }

    private boolean ara() {
        if (this.bFe == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.bFe);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bFe;
    }

    public void arb() {
        aqY();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getRealView(this.bFe);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getRealView(this.bFe);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oF() {
    }

    public void reset() {
        this.bFe = null;
        setTag(null);
        ho(1);
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
