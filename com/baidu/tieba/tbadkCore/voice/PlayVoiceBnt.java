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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.v;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private AnimationDrawable bFx;
    private VoiceData.VoiceModel bYB;
    private ImageView bYx;
    private int dBO;
    private TextView dBP;
    private Context mContext;
    private ProgressBar mProgress;
    private VoiceManager mVoiceManager;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (dBQ) with 'values()' method */
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
        this.dBO = 0;
        this.dBO = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dBO = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.k.Voice_play_type);
        this.dBO = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(aN(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int aN(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.dBO == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(n.d.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(n.d.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(n.d.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(n.d.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void init(Context context) {
        P(context);
        setOnClickListener(this);
    }

    public void P(Context context) {
        LayoutInflater.from(context).inflate(n.g.play_voice_bnt, (ViewGroup) this, true);
        this.bYx = (ImageView) findViewById(n.f.playingImg);
        this.dBP = (TextView) findViewById(n.f.playTime);
        this.mProgress = (ProgressBar) findViewById(n.f.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        aEg();
    }

    private void aEg() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.dBO == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            as.i(this, n.e.but_thread_voice_selector);
            if (this.dBP != null) {
                this.dBP.setTextSize(0, this.mContext.getResources().getDimension(n.d.voice_play_bnt_text_size_0));
                this.dBP.setTextColor(i);
            }
            if (this.bYx != null) {
                as.c(this.bYx, n.a.voice_btn_play_anim);
            }
            this.bYx.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            as.i(this, n.e.but_thread_voice_reply_selector);
            if (this.dBP != null) {
                this.dBP.setTextSize(0, this.mContext.getResources().getDimension(n.d.voice_play_bnt_text_size_1));
                this.dBP.setTextColor(i2);
            }
            if (this.bYx != null) {
                as.c(this.bYx, n.a.voice_btn_play_anim);
            }
            this.bYx.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.bYx.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.bYB = voiceModel;
        if (this.bYB != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                iE(this.bYB.elapse);
                return;
            }
            iF(this.bYB.voice_status.intValue());
            this.dBP.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void iE(int i) {
        String formatVoiceTime;
        if (this.bYB != null && this.dBP != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.bYB.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bYB.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bYB.duration);
            }
            String a = j.a(this.dBP.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.dBP.setText(formatVoiceTime);
            }
        }
    }

    public void iF(int i) {
        if (i == 3) {
            if (this.bYx != null) {
                this.bYx.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aaZ();
            return;
        }
        aba();
        if (i == 1) {
            if (this.bYx != null) {
                this.bYx.setVisibility(0);
            }
            if (this.bYB != null) {
                this.dBP.setText(VoiceManager.formatVoiceTime(this.bYB.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bYB != null) {
                this.dBP.setText(VoiceManager.formatVoiceTime(this.bYB.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bYB != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            TiebaStatic.log(this.bYB.from);
        }
    }

    private void aEh() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.dBO == 0) {
            i = skinType != 1 ? n.a.voice_btn_play_anim : n.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? n.a.voice_btn_play_anim : n.a.voice_btn_play_anim_1;
        }
        if (this.bYx != null) {
            this.bYx.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bYx != null) {
            if (this.dBO == 0) {
                as.c(this.bYx, n.e.icon_thread_voice_reply_curve_three);
            } else {
                as.c(this.bYx, n.e.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aaZ() {
        if (this.bFx != null) {
            this.bFx.stop();
        }
        aEh();
        this.bFx = (AnimationDrawable) this.bYx.getDrawable();
        this.bFx.start();
    }

    public void aba() {
        Drawable drawable = this.bYx.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.bFx = (AnimationDrawable) drawable;
        }
        if (this.bFx != null) {
            this.bFx.stop();
        }
        this.bFx = null;
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
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) vVar.Gt();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (vVar.Gs() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = vVar.xb();
                voiceModel.duration = vVar.getDuration();
                vVar.C(voiceModel);
            }
            this.dBO = vVar.Gs();
            setVoiceModel(voiceModel);
            aEg();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.bYB != voiceModel) {
                iF(1);
            } else {
                iF(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aJ(int i) {
        if (!aEi()) {
            iF(1);
            return;
        }
        if (this.bFx == null) {
            iF(this.bYB.voice_status.intValue());
        }
        iE(i);
        if (this.bYB != null) {
            this.bYB.elapse = i;
        }
    }

    private boolean aEi() {
        if (this.bYB == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.bYB);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bYB;
    }

    public void aEj() {
        aEg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getRealView(this.bYB);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getRealView(this.bYB);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oK() {
    }

    public void reset() {
        this.bYB = null;
        setTag(null);
        iF(1);
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
