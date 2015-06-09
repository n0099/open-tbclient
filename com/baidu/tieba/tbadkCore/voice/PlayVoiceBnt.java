package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.m;
import com.baidu.adp.lib.util.n;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.i;
import com.baidu.tbadk.core.voice.j;
import com.baidu.tbadk.widget.richText.u;
import com.baidu.tieba.k;
import com.baidu.tieba.o;
import com.baidu.tieba.p;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, i {
    private ImageView brm;
    private VoiceData.VoiceModel brq;
    private TextView cuh;
    private AnimationDrawable cui;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (cuj) with 'values()' method */
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
        this.play_type = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(al(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int al(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = new int[2];
        if (this.play_type == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(o.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(o.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(o.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(o.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void init(Context context) {
        R(context);
        setOnClickListener(this);
    }

    public void R(Context context) {
        com.baidu.adp.lib.g.b.hr().a(context, r.play_voice_bnt, this, true);
        this.brm = (ImageView) findViewById(q.playingImg);
        this.cuh = (TextView) findViewById(q.playTime);
        this.mProgress = (ProgressBar) findViewById(q.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        apE();
    }

    private void apE() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ay.i(this, p.but_thread_voice_selector);
            if (this.cuh != null) {
                this.cuh.setTextSize(0, this.mContext.getResources().getDimension(o.voice_play_bnt_text_size_0));
                this.cuh.setTextColor(i);
            }
            if (this.brm != null) {
                ay.c(this.brm, k.voice_btn_play_anim);
            }
            this.brm.setPadding(n.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ay.i(this, p.but_thread_voice_reply_selector);
            if (this.cuh != null) {
                this.cuh.setTextSize(0, this.mContext.getResources().getDimension(o.voice_play_bnt_text_size_1));
                this.cuh.setTextColor(i2);
            }
            if (this.brm != null) {
                ay.c(this.brm, k.voice_btn_play_anim);
            }
            this.brm.setPadding(n.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.brm.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.brq = voiceModel;
        if (this.brq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                gJ(this.brq.elapse);
                return;
            }
            gK(this.brq.voice_status.intValue());
            this.cuh.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void gJ(int i) {
        String formatVoiceTime;
        if (this.brq != null && this.cuh != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.brq.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.brq.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.brq.duration);
            }
            String a = m.a(this.cuh.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.cuh.setText(formatVoiceTime);
            }
        }
    }

    public void gK(int i) {
        if (i == 3) {
            if (this.brm != null) {
                this.brm.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            Vl();
            return;
        }
        Vm();
        if (i == 1) {
            if (this.brm != null) {
                this.brm.setVisibility(0);
            }
            if (this.brq != null) {
                this.cuh.setText(VoiceManager.formatVoiceTime(this.brq.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.brq != null) {
                this.cuh.setText(VoiceManager.formatVoiceTime(this.brq.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.brq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            com.baidu.tbadk.core.k.A(getContext(), this.brq.from);
        }
    }

    private void apF() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? k.voice_btn_play_anim : k.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? k.voice_btn_play_anim : k.voice_btn_play_anim_1;
        }
        if (this.brm != null) {
            this.brm.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.brm != null) {
            if (this.play_type == 0) {
                ay.c(this.brm, p.icon_thread_voice_reply_curve_three);
            } else {
                ay.c(this.brm, p.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void Vl() {
        if (this.cui != null) {
            this.cui.stop();
        }
        apF();
        this.cui = (AnimationDrawable) this.brm.getDrawable();
        this.cui.start();
    }

    public void Vm() {
        Drawable drawable = this.brm.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cui = (AnimationDrawable) drawable;
        }
        if (this.cui != null) {
            this.cui.stop();
        }
        this.cui = null;
        stopAnimation();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof j) {
            return ((j) context).getVoiceManager();
        }
        return null;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof u)) {
            u uVar = (u) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) uVar.EI();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (uVar.EH() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = uVar.vg();
                voiceModel.duration = uVar.getDuration();
                uVar.A(voiceModel);
            }
            this.play_type = uVar.EH();
            setVoiceModel(voiceModel);
            apE();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.brq != voiceModel) {
                gK(1);
            } else {
                gK(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aG(int i) {
        if (!apG()) {
            gK(1);
            return;
        }
        if (this.cui == null) {
            gK(this.brq.voice_status.intValue());
        }
        gJ(i);
        if (this.brq != null) {
            this.brq.elapse = i;
        }
    }

    private boolean apG() {
        if (this.brq == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.brq);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void onShowErr(int i, String str) {
        n.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.brq;
    }

    public void adB() {
        apE();
    }

    @Override // com.baidu.tbadk.core.voice.i
    public i getRealView() {
        Context context = getContext();
        if (context instanceof j) {
            return ((j) context).getRealView(this.brq);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void ow() {
    }

    public void reset() {
        this.brq = null;
        setTag(null);
        gK(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int M = n.M(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (M * 0.3f);
                return (((i - 10) * (((int) (M * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (M * 0.45f);
        }
        int i3 = (int) (M * 0.18f);
        int i4 = (int) (M * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }
}
