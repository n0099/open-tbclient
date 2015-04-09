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
import com.baidu.tbadk.core.k;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.i;
import com.baidu.tbadk.core.voice.j;
import com.baidu.tieba.aa;
import com.baidu.tieba.p;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, i {
    private ImageView boF;
    private VoiceData.VoiceModel boJ;
    private TextView cqc;
    private AnimationDrawable cqd;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (cqe) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, aa.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(ak(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int ak(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(t.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(t.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(t.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(t.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void init(Context context) {
        R(context);
        setOnClickListener(this);
    }

    public void R(Context context) {
        com.baidu.adp.lib.g.b.hH().a(context, w.play_voice_bnt, this, true);
        this.boF = (ImageView) findViewById(v.playingImg);
        this.cqc = (TextView) findViewById(v.playTime);
        this.mProgress = (ProgressBar) findViewById(v.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        anL();
    }

    private void anL() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ba.i(this, u.but_thread_voice_selector);
            if (this.cqc != null) {
                this.cqc.setTextSize(0, this.mContext.getResources().getDimension(t.voice_play_bnt_text_size_0));
                this.cqc.setTextColor(i);
            }
            if (this.boF != null) {
                ba.c(this.boF, p.voice_btn_play_anim);
            }
            this.boF.setPadding(n.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ba.i(this, u.but_thread_voice_reply_selector);
            if (this.cqc != null) {
                this.cqc.setTextSize(0, this.mContext.getResources().getDimension(t.voice_play_bnt_text_size_1));
                this.cqc.setTextColor(i2);
            }
            if (this.boF != null) {
                ba.c(this.boF, p.voice_btn_play_anim);
            }
            this.boF.setPadding(n.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.boF.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.boJ = voiceModel;
        if (this.boJ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                gs(this.boJ.elapse);
                return;
            }
            gt(this.boJ.voice_status.intValue());
            this.cqc.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void gs(int i) {
        String formatVoiceTime;
        if (this.boJ != null && this.cqc != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.boJ.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.boJ.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.boJ.duration);
            }
            String a = m.a(this.cqc.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.cqc.setText(formatVoiceTime);
            }
        }
    }

    public void gt(int i) {
        if (i == 3) {
            if (this.boF != null) {
                this.boF.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            TW();
            return;
        }
        TX();
        if (i == 1) {
            if (this.boF != null) {
                this.boF.setVisibility(0);
            }
            if (this.boJ != null) {
                this.cqc.setText(VoiceManager.formatVoiceTime(this.boJ.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.boJ != null) {
                this.cqc.setText(VoiceManager.formatVoiceTime(this.boJ.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.boJ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            k.A(getContext(), this.boJ.from);
        }
    }

    private void anM() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? p.voice_btn_play_anim : p.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? p.voice_btn_play_anim : p.voice_btn_play_anim_1;
        }
        if (this.boF != null) {
            this.boF.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.boF != null) {
            if (this.play_type == 0) {
                ba.c(this.boF, u.icon_thread_voice_reply_curve_three);
            } else {
                ba.c(this.boF, u.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void TW() {
        if (this.cqd != null) {
            this.cqd.stop();
        }
        anM();
        this.cqd = (AnimationDrawable) this.boF.getDrawable();
        this.cqd.start();
    }

    public void TX() {
        Drawable drawable = this.boF.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cqd = (AnimationDrawable) drawable;
        }
        if (this.cqd != null) {
            this.cqd.stop();
        }
        this.cqd = null;
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
        if (obj != null && (obj instanceof com.baidu.tbadk.widget.richText.u)) {
            com.baidu.tbadk.widget.richText.u uVar = (com.baidu.tbadk.widget.richText.u) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) uVar.DX();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (uVar.DW() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = uVar.ux();
                voiceModel.duration = uVar.getDuration();
                uVar.B(voiceModel);
            }
            this.play_type = uVar.DW();
            setVoiceModel(voiceModel);
            anL();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.boJ != voiceModel) {
                gt(1);
            } else {
                gt(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void aI(int i) {
        if (!anN()) {
            gt(1);
            return;
        }
        if (this.cqd == null) {
            gt(this.boJ.voice_status.intValue());
        }
        gs(i);
        if (this.boJ != null) {
            this.boJ.elapse = i;
        }
    }

    private boolean anN() {
        if (this.boJ == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.boJ);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void onShowErr(int i, String str) {
        n.t(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.i
    public VoiceData.VoiceModel getVoiceModel() {
        return this.boJ;
    }

    public void acc() {
        anL();
    }

    @Override // com.baidu.tbadk.core.voice.i
    public i getRealView() {
        Context context = getContext();
        if (context instanceof j) {
            return ((j) context).getRealView(this.boJ);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.i
    public void og() {
    }

    public void reset() {
        this.boJ = null;
        setTag(null);
        gt(1);
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
