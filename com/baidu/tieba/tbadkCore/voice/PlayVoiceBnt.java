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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.m;
import com.baidu.tbadk.core.voice.o;
import com.baidu.tieba.ab;
import com.baidu.tieba.q;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, m {
    private TextView bYR;
    private AnimationDrawable bYS;
    private ImageView bpt;
    private VoiceData.VoiceModel bpx;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (bYT) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ab.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(af(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int af(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(u.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(u.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(u.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(u.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void init(Context context) {
        aA(context);
        setOnClickListener(this);
    }

    public void aA(Context context) {
        com.baidu.adp.lib.g.b.ek().a(context, x.play_voice_bnt, this, true);
        this.bpt = (ImageView) findViewById(w.playingImg);
        this.bYR = (TextView) findViewById(w.playTime);
        this.mProgress = (ProgressBar) findViewById(w.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        ahS();
    }

    private void ahS() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ax.i(this, v.but_thread_voice_selector);
            if (this.bYR != null) {
                this.bYR.setTextSize(0, this.mContext.getResources().getDimension(u.voice_play_bnt_text_size_0));
                this.bYR.setTextColor(i);
            }
            if (this.bpt != null) {
                ax.c(this.bpt, q.voice_btn_play_anim);
            }
            this.bpt.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ax.i(this, v.but_thread_voice_reply_selector);
            if (this.bYR != null) {
                this.bYR.setTextSize(0, this.mContext.getResources().getDimension(u.voice_play_bnt_text_size_1));
                this.bYR.setTextColor(i2);
            }
            if (this.bpt != null) {
                ax.c(this.bpt, q.voice_btn_play_anim);
            }
            this.bpt.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.bpt.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.bpx = voiceModel;
        if (this.bpx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                gA(this.bpx.elapse);
                return;
            }
            gB(this.bpx.voice_status.intValue());
            this.bYR.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void gA(int i) {
        String formatVoiceTime;
        if (this.bpx != null && this.bYR != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.bpx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bpx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bpx.duration);
            }
            String a = k.a(this.bYR.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.bYR.setText(formatVoiceTime);
            }
        }
    }

    public void gB(int i) {
        if (i == 3) {
            if (this.bpt != null) {
                this.bpt.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            Ts();
            return;
        }
        Tt();
        if (i == 1) {
            if (this.bpt != null) {
                this.bpt.setVisibility(0);
            }
            if (this.bpx != null) {
                this.bYR.setText(VoiceManager.formatVoiceTime(this.bpx.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bpx != null) {
                this.bYR.setText(VoiceManager.formatVoiceTime(this.bpx.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bpx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            i.B(getContext(), this.bpx.from);
        }
    }

    private void ahT() {
        int i;
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? q.voice_btn_play_anim : q.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? q.voice_btn_play_anim : q.voice_btn_play_anim_1;
        }
        if (this.bpt != null) {
            this.bpt.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (this.bpt != null) {
            if (this.play_type == 0) {
                ax.c(this.bpt, v.icon_thread_voice_reply_curve_three);
            } else {
                ax.c(this.bpt, v.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void Ts() {
        if (this.bYS != null) {
            this.bYS.stop();
        }
        ahT();
        this.bYS = (AnimationDrawable) this.bpt.getDrawable();
        this.bYS.start();
    }

    public void Tt() {
        Drawable drawable = this.bpt.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.bYS = (AnimationDrawable) drawable;
        }
        if (this.bYS != null) {
            this.bYS.stop();
        }
        this.bYS = null;
        stopAnimation();
    }

    public VoiceManager getVoiceManager() {
        Context context = getContext();
        if (context instanceof o) {
            return ((o) context).getVoiceManager();
        }
        return null;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof com.baidu.tbadk.widget.richText.u)) {
            com.baidu.tbadk.widget.richText.u uVar = (com.baidu.tbadk.widget.richText.u) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) uVar.Ag();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (uVar.Af() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = uVar.ru();
                voiceModel.duration = uVar.getDuration();
                uVar.z(voiceModel);
            }
            this.play_type = uVar.Af();
            setVoiceModel(voiceModel);
            ahS();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.bpx != voiceModel) {
                gB(1);
            } else {
                gB(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void cn(int i) {
        if (!ahU()) {
            gB(1);
            return;
        }
        if (this.bYS == null) {
            gB(this.bpx.voice_status.intValue());
        }
        gA(i);
        if (this.bpx != null) {
            this.bpx.elapse = i;
        }
    }

    private boolean ahU() {
        if (this.bpx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.bpx);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        l.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bpx;
    }

    public void Zf() {
        ahS();
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        Context context = getContext();
        if (context instanceof o) {
            return ((o) context).getRealView(this.bpx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qI() {
    }

    public void reset() {
        this.bpx = null;
        setTag(null);
        gB(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int M = l.M(getContext());
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
