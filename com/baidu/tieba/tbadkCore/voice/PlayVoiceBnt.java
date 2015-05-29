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
    private ImageView brl;
    private VoiceData.VoiceModel brp;
    private TextView cug;
    private AnimationDrawable cuh;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (cui) with 'values()' method */
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
        this.brl = (ImageView) findViewById(q.playingImg);
        this.cug = (TextView) findViewById(q.playTime);
        this.mProgress = (ProgressBar) findViewById(q.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        apD();
    }

    private void apD() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ay.i(this, p.but_thread_voice_selector);
            if (this.cug != null) {
                this.cug.setTextSize(0, this.mContext.getResources().getDimension(o.voice_play_bnt_text_size_0));
                this.cug.setTextColor(i);
            }
            if (this.brl != null) {
                ay.c(this.brl, k.voice_btn_play_anim);
            }
            this.brl.setPadding(n.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ay.i(this, p.but_thread_voice_reply_selector);
            if (this.cug != null) {
                this.cug.setTextSize(0, this.mContext.getResources().getDimension(o.voice_play_bnt_text_size_1));
                this.cug.setTextColor(i2);
            }
            if (this.brl != null) {
                ay.c(this.brl, k.voice_btn_play_anim);
            }
            this.brl.setPadding(n.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.brl.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.brp = voiceModel;
        if (this.brp != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                gJ(this.brp.elapse);
                return;
            }
            gK(this.brp.voice_status.intValue());
            this.cug.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void gJ(int i) {
        String formatVoiceTime;
        if (this.brp != null && this.cug != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.brp.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.brp.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.brp.duration);
            }
            String a = m.a(this.cug.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.cug.setText(formatVoiceTime);
            }
        }
    }

    public void gK(int i) {
        if (i == 3) {
            if (this.brl != null) {
                this.brl.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            Vk();
            return;
        }
        Vl();
        if (i == 1) {
            if (this.brl != null) {
                this.brl.setVisibility(0);
            }
            if (this.brp != null) {
                this.cug.setText(VoiceManager.formatVoiceTime(this.brp.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.brp != null) {
                this.cug.setText(VoiceManager.formatVoiceTime(this.brp.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.brp != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            com.baidu.tbadk.core.k.A(getContext(), this.brp.from);
        }
    }

    private void apE() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? k.voice_btn_play_anim : k.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? k.voice_btn_play_anim : k.voice_btn_play_anim_1;
        }
        if (this.brl != null) {
            this.brl.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.brl != null) {
            if (this.play_type == 0) {
                ay.c(this.brl, p.icon_thread_voice_reply_curve_three);
            } else {
                ay.c(this.brl, p.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void Vk() {
        if (this.cuh != null) {
            this.cuh.stop();
        }
        apE();
        this.cuh = (AnimationDrawable) this.brl.getDrawable();
        this.cuh.start();
    }

    public void Vl() {
        Drawable drawable = this.brl.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cuh = (AnimationDrawable) drawable;
        }
        if (this.cuh != null) {
            this.cuh.stop();
        }
        this.cuh = null;
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
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) uVar.EH();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (uVar.EG() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = uVar.vg();
                voiceModel.duration = uVar.getDuration();
                uVar.A(voiceModel);
            }
            this.play_type = uVar.EG();
            setVoiceModel(voiceModel);
            apD();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.brp != voiceModel) {
                gK(1);
            } else {
                gK(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aG(int i) {
        if (!apF()) {
            gK(1);
            return;
        }
        if (this.cuh == null) {
            gK(this.brp.voice_status.intValue());
        }
        gJ(i);
        if (this.brp != null) {
            this.brp.elapse = i;
        }
    }

    private boolean apF() {
        if (this.brp == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.brp);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void onShowErr(int i, String str) {
        n.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.brp;
    }

    public void adA() {
        apD();
    }

    @Override // com.baidu.tbadk.core.voice.i
    public i getRealView() {
        Context context = getContext();
        if (context instanceof j) {
            return ((j) context).getRealView(this.brp);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void ow() {
    }

    public void reset() {
        this.brp = null;
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
