package com.baidu.tieba.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.i;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.m;
import com.baidu.tbadk.core.voice.o;
import com.baidu.tieba.aa;
import com.baidu.tieba.p;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, m {
    private TextView bRF;
    private AnimationDrawable bRG;
    private ImageView bjQ;
    private VoiceData.VoiceModel bjU;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (bRH) with 'values()' method */
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(Y(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int Y(int i, int i2) {
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
        al(context);
        setOnClickListener(this);
    }

    public void al(Context context) {
        com.baidu.adp.lib.g.b.ek().a(context, w.play_voice_bnt, this, true);
        this.bjQ = (ImageView) findViewById(v.playingImg);
        this.bRF = (TextView) findViewById(v.playTime);
        this.mProgress = (ProgressBar) findViewById(v.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        aeS();
    }

    private void aeS() {
        int skinType = TbadkApplication.m251getInst().getSkinType();
        int i = skinType != 1 ? p.voice_btn_play_anim : p.voice_btn_play_anim_1;
        if (this.play_type == 0) {
            int i2 = skinType != 1 ? -13553101 : -6574132;
            aw.h(this, u.but_thread_voice_selector);
            if (this.bRF != null) {
                this.bRF.setTextSize(0, this.mContext.getResources().getDimension(t.voice_play_bnt_text_size_0));
                this.bRF.setTextColor(i2);
            }
            this.bjQ.setImageResource(i);
            this.bjQ.setPadding(com.baidu.adp.lib.util.m.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i3 = skinType != 1 ? -16777216 : -8682095;
            aw.h(this, u.but_thread_voice_reply_selector);
            if (this.bRF != null) {
                this.bRF.setTextSize(0, this.mContext.getResources().getDimension(t.voice_play_bnt_text_size_1));
                this.bRF.setTextColor(i3);
            }
            this.bjQ.setImageResource(i);
            this.bjQ.setPadding(com.baidu.adp.lib.util.m.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.bjQ.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.bjU = voiceModel;
        if (this.bjU != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                gn(this.bjU.elapse);
                return;
            }
            go(this.bjU.voice_status.intValue());
            this.bRF.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void gn(int i) {
        String formatVoiceTime;
        if (this.bjU != null && this.bRF != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.bjU.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bjU.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.bjU.duration);
            }
            String a = l.a(this.bRF.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.bRF.setText(formatVoiceTime);
            }
        }
    }

    public void go(int i) {
        if (i == 3) {
            if (this.bjQ != null) {
                this.bjQ.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            RX();
            return;
        }
        RY();
        if (i == 1) {
            if (this.bjQ != null) {
                this.bjQ.setVisibility(0);
            }
            if (this.bjU != null) {
                this.bRF.setText(VoiceManager.formatVoiceTime(this.bjU.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.bjU != null) {
                this.bRF.setText(VoiceManager.formatVoiceTime(this.bjU.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.bjU != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            i.l(getContext(), this.bjU.from);
        }
    }

    private void aeT() {
        int i;
        int skinType = TbadkApplication.m251getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? p.voice_btn_play_anim : p.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? p.voice_btn_play_anim : p.voice_btn_play_anim_1;
        }
        if (this.bjQ != null) {
            this.bjQ.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkApplication.m251getInst().getSkinType();
        if (this.bjQ != null) {
            if (this.play_type == 0) {
                aw.c(this.bjQ, u.icon_thread_voice_reply_curve_three);
            } else {
                aw.c(this.bjQ, u.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void RX() {
        if (this.bRG != null) {
            this.bRG.stop();
        }
        aeT();
        this.bRG = (AnimationDrawable) this.bjQ.getDrawable();
        this.bRG.start();
    }

    public void RY() {
        Drawable drawable = this.bjQ.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.bRG = (AnimationDrawable) drawable;
        }
        if (this.bRG != null) {
            this.bRG.stop();
        }
        this.bRG = null;
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
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) uVar.vY();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (uVar.vX() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = uVar.ou();
                voiceModel.duration = uVar.getDuration();
                uVar.s(voiceModel);
            }
            this.play_type = uVar.vX();
            setVoiceModel(voiceModel);
            aeS();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void a(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.bjU != voiceModel) {
                go(1);
            } else {
                go(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void bP(int i) {
        if (!aeU()) {
            go(1);
            return;
        }
        if (this.bRG == null) {
            go(this.bjU.voice_status.intValue());
        }
        gn(i);
        if (this.bjU != null) {
            this.bjU.elapse = i;
        }
    }

    private boolean aeU() {
        if (this.bjU == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.bjU);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void onShowErr(int i, String str) {
        com.baidu.adp.lib.util.m.g(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.m
    public VoiceData.VoiceModel getVoiceModel() {
        return this.bjU;
    }

    public void YI() {
        aeS();
    }

    @Override // com.baidu.tbadk.core.voice.m
    public m getRealView() {
        Context context = getContext();
        if (context instanceof o) {
            return ((o) context).b(this.bjU);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.m
    public void nH() {
    }

    public void reset() {
        this.bjU = null;
        setTag(null);
        go(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int n = com.baidu.adp.lib.util.m.n(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (n * 0.3f);
                return (((i - 10) * (((int) (n * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (n * 0.45f);
        }
        int i3 = (int) (n * 0.18f);
        int i4 = (int) (n * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }
}
