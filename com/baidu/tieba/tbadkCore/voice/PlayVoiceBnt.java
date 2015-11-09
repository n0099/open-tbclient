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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.v;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private ImageView bJs;
    private VoiceData.VoiceModel bJw;
    private TextView ddA;
    private AnimationDrawable ddB;
    private int ddz;
    private Context mContext;
    private ProgressBar mProgress;
    private VoiceManager mVoiceManager;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (ddC) with 'values()' method */
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
        this.ddz = 0;
        this.ddz = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ddz = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, i.j.Voice_play_type);
        this.ddz = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(aL(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int aL(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.ddz == 0) {
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
        this.bJs = (ImageView) findViewById(i.f.playingImg);
        this.ddA = (TextView) findViewById(i.f.playTime);
        this.mProgress = (ProgressBar) findViewById(i.f.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        ayO();
    }

    private void ayO() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.ddz == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            an.i(this, i.e.but_thread_voice_selector);
            if (this.ddA != null) {
                this.ddA.setTextSize(0, this.mContext.getResources().getDimension(i.d.voice_play_bnt_text_size_0));
                this.ddA.setTextColor(i);
            }
            if (this.bJs != null) {
                an.c(this.bJs, i.a.voice_btn_play_anim);
            }
            this.bJs.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            an.i(this, i.e.but_thread_voice_reply_selector);
            if (this.ddA != null) {
                this.ddA.setTextSize(0, this.mContext.getResources().getDimension(i.d.voice_play_bnt_text_size_1));
                this.ddA.setTextColor(i2);
            }
            if (this.bJs != null) {
                an.c(this.bJs, i.a.voice_btn_play_anim);
            }
            this.bJs.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.bJs.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.bJw = voiceModel;
        if (this.bJw != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                hQ(this.bJw.elapse);
                return;
            }
            hR(this.bJw.voice_status.intValue());
            this.ddA.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void hQ(int i) {
        String formatVoiceTime;
        if (this.bJw != null && this.ddA != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.bJw.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bJw.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bJw.duration);
            }
            String a = j.a(this.ddA.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.ddA.setText(formatVoiceTime);
            }
        }
    }

    public void hR(int i) {
        if (i == 3) {
            if (this.bJs != null) {
                this.bJs.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            XT();
            return;
        }
        XU();
        if (i == 1) {
            if (this.bJs != null) {
                this.bJs.setVisibility(0);
            }
            if (this.bJw != null) {
                this.ddA.setText(VoiceManager.formatVoiceTime(this.bJw.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bJw != null) {
                this.ddA.setText(VoiceManager.formatVoiceTime(this.bJw.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bJw != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            TiebaStatic.log(this.bJw.from);
        }
    }

    private void ayP() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.ddz == 0) {
            i = skinType != 1 ? i.a.voice_btn_play_anim : i.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? i.a.voice_btn_play_anim : i.a.voice_btn_play_anim_1;
        }
        if (this.bJs != null) {
            this.bJs.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bJs != null) {
            if (this.ddz == 0) {
                an.c(this.bJs, i.e.icon_thread_voice_reply_curve_three);
            } else {
                an.c(this.bJs, i.e.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void XT() {
        if (this.ddB != null) {
            this.ddB.stop();
        }
        ayP();
        this.ddB = (AnimationDrawable) this.bJs.getDrawable();
        this.ddB.start();
    }

    public void XU() {
        Drawable drawable = this.bJs.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.ddB = (AnimationDrawable) drawable;
        }
        if (this.ddB != null) {
            this.ddB.stop();
        }
        this.ddB = null;
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
        if (obj != null && (obj instanceof v)) {
            v vVar = (v) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) vVar.Fo();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (vVar.Fn() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = vVar.wh();
                voiceModel.duration = vVar.getDuration();
                vVar.C(voiceModel);
            }
            this.ddz = vVar.Fn();
            setVoiceModel(voiceModel);
            ayO();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.bJw != voiceModel) {
                hR(1);
            } else {
                hR(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aI(int i) {
        if (!ayQ()) {
            hR(1);
            return;
        }
        if (this.ddB == null) {
            hR(this.bJw.voice_status.intValue());
        }
        hQ(i);
        if (this.bJw != null) {
            this.bJw.elapse = i;
        }
    }

    private boolean ayQ() {
        if (this.bJw == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.bJw);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bJw;
    }

    public void ayR() {
        ayO();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getRealView(this.bJw);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getRealView(this.bJw);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oE() {
    }

    public void reset() {
        this.bJw = null;
        setTag(null);
        hR(1);
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
