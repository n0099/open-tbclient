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
import com.baidu.tbadk.core.util.bc;
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
    private ImageView bqQ;
    private VoiceData.VoiceModel bqU;
    private TextView caJ;
    private AnimationDrawable caK;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (caL) with 'values()' method */
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ah(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int ah(int i, int i2) {
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
        aB(context);
        setOnClickListener(this);
    }

    public void aB(Context context) {
        com.baidu.adp.lib.g.b.ei().a(context, x.play_voice_bnt, this, true);
        this.bqQ = (ImageView) findViewById(w.playingImg);
        this.caJ = (TextView) findViewById(w.playTime);
        this.mProgress = (ProgressBar) findViewById(w.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        air();
    }

    private void air() {
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            bc.i(this, v.but_thread_voice_selector);
            if (this.caJ != null) {
                this.caJ.setTextSize(0, this.mContext.getResources().getDimension(u.voice_play_bnt_text_size_0));
                this.caJ.setTextColor(i);
            }
            if (this.bqQ != null) {
                bc.c(this.bqQ, q.voice_btn_play_anim);
            }
            this.bqQ.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            bc.i(this, v.but_thread_voice_reply_selector);
            if (this.caJ != null) {
                this.caJ.setTextSize(0, this.mContext.getResources().getDimension(u.voice_play_bnt_text_size_1));
                this.caJ.setTextColor(i2);
            }
            if (this.bqQ != null) {
                bc.c(this.bqQ, q.voice_btn_play_anim);
            }
            this.bqQ.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.bqQ.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.bqU = voiceModel;
        if (this.bqU != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                gJ(this.bqU.elapse);
                return;
            }
            gK(this.bqU.voice_status.intValue());
            this.caJ.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void gJ(int i) {
        String formatVoiceTime;
        if (this.bqU != null && this.caJ != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.bqU.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bqU.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bqU.duration);
            }
            String a = k.a(this.caJ.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.caJ.setText(formatVoiceTime);
            }
        }
    }

    public void gK(int i) {
        if (i == 3) {
            if (this.bqQ != null) {
                this.bqQ.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            TJ();
            return;
        }
        TK();
        if (i == 1) {
            if (this.bqQ != null) {
                this.bqQ.setVisibility(0);
            }
            if (this.bqU != null) {
                this.caJ.setText(VoiceManager.formatVoiceTime(this.bqU.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bqU != null) {
                this.caJ.setText(VoiceManager.formatVoiceTime(this.bqU.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bqU != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            i.A(getContext(), this.bqU.from);
        }
    }

    private void ais() {
        int i;
        int skinType = TbadkCoreApplication.m255getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? q.voice_btn_play_anim : q.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? q.voice_btn_play_anim : q.voice_btn_play_anim_1;
        }
        if (this.bqQ != null) {
            this.bqQ.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m255getInst().getSkinType();
        if (this.bqQ != null) {
            if (this.play_type == 0) {
                bc.c(this.bqQ, v.icon_thread_voice_reply_curve_three);
            } else {
                bc.c(this.bqQ, v.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void TJ() {
        if (this.caK != null) {
            this.caK.stop();
        }
        ais();
        this.caK = (AnimationDrawable) this.bqQ.getDrawable();
        this.caK.start();
    }

    public void TK() {
        Drawable drawable = this.bqQ.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.caK = (AnimationDrawable) drawable;
        }
        if (this.caK != null) {
            this.caK.stop();
        }
        this.caK = null;
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
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) uVar.Au();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (uVar.At() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = uVar.rA();
                voiceModel.duration = uVar.getDuration();
                uVar.z(voiceModel);
            }
            this.play_type = uVar.At();
            setVoiceModel(voiceModel);
            air();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.bqU != voiceModel) {
                gK(1);
            } else {
                gK(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void cu(int i) {
        if (!ait()) {
            gK(1);
            return;
        }
        if (this.caK == null) {
            gK(this.bqU.voice_status.intValue());
        }
        gJ(i);
        if (this.bqU != null) {
            this.bqU.elapse = i;
        }
    }

    private boolean ait() {
        if (this.bqU == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.bqU);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        l.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bqU;
    }

    public void ZF() {
        air();
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        Context context = getContext();
        if (context instanceof o) {
            return ((o) context).getRealView(this.bqU);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void qN() {
    }

    public void reset() {
        this.bqU = null;
        setTag(null);
        gK(1);
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
