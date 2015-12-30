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
    private View.OnClickListener aeG;
    private AnimationDrawable bJe;
    private VoiceData.VoiceModel ccB;
    private ImageView ccx;
    private TextView dJr;
    private Context mContext;
    private ProgressBar mProgress;
    private VoiceManager mVoiceManager;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (dJs) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, n.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bc(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bc(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(n.e.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(n.e.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(n.e.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(n.e.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void init(Context context) {
        P(context);
        setOnClickListener(this);
    }

    public void P(Context context) {
        LayoutInflater.from(context).inflate(n.h.play_voice_bnt, (ViewGroup) this, true);
        this.ccx = (ImageView) findViewById(n.g.playingImg);
        this.dJr = (TextView) findViewById(n.g.playTime);
        this.mProgress = (ProgressBar) findViewById(n.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        aGu();
    }

    private void aGu() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            as.i(this, n.f.but_thread_voice_selector);
            if (this.dJr != null) {
                this.dJr.setTextSize(0, this.mContext.getResources().getDimension(n.e.voice_play_bnt_text_size_0));
                this.dJr.setTextColor(i);
            }
            if (this.ccx != null) {
                as.c(this.ccx, n.a.voice_btn_play_anim);
            }
            this.ccx.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            as.i(this, n.f.but_thread_voice_reply_selector);
            if (this.dJr != null) {
                this.dJr.setTextSize(0, this.mContext.getResources().getDimension(n.e.voice_play_bnt_text_size_1));
                this.dJr.setTextColor(i2);
            }
            if (this.ccx != null) {
                as.c(this.ccx, n.a.voice_btn_play_anim);
            }
            this.ccx.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.ccx.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.ccB = voiceModel;
        if (this.ccB != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                jd(this.ccB.elapse);
                return;
            }
            je(this.ccB.voice_status.intValue());
            this.dJr.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void jd(int i) {
        String formatVoiceTime;
        if (this.ccB != null && this.dJr != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.ccB.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ccB.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ccB.duration);
            }
            String a = j.a(this.dJr.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.dJr.setText(formatVoiceTime);
            }
        }
    }

    public void je(int i) {
        if (i == 3) {
            if (this.ccx != null) {
                this.ccx.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aci();
            return;
        }
        acj();
        if (i == 1) {
            if (this.ccx != null) {
                this.ccx.setVisibility(0);
            }
            if (this.ccB != null) {
                this.dJr.setText(VoiceManager.formatVoiceTime(this.ccB.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ccB != null) {
                this.dJr.setText(VoiceManager.formatVoiceTime(this.ccB.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ccB != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aeG != null) {
                this.aeG.onClick(view);
            }
            TiebaStatic.log(this.ccB.from);
        }
    }

    private void aGv() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? n.a.voice_btn_play_anim : n.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? n.a.voice_btn_play_anim : n.a.voice_btn_play_anim_1;
        }
        if (this.ccx != null) {
            this.ccx.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.ccx != null) {
            if (this.play_type == 0) {
                as.c(this.ccx, n.f.icon_thread_voice_reply_curve_three);
            } else {
                as.c(this.ccx, n.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aci() {
        if (this.bJe != null) {
            this.bJe.stop();
        }
        aGv();
        this.bJe = (AnimationDrawable) this.ccx.getDrawable();
        this.bJe.start();
    }

    public void acj() {
        Drawable drawable = this.ccx.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.bJe = (AnimationDrawable) drawable;
        }
        if (this.bJe != null) {
            this.bJe.stop();
        }
        this.bJe = null;
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
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) vVar.Gi();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (vVar.Gh() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = vVar.wK();
                voiceModel.duration = vVar.getDuration();
                vVar.C(voiceModel);
            }
            this.play_type = vVar.Gh();
            setVoiceModel(voiceModel);
            aGu();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.ccB != voiceModel) {
                je(1);
            } else {
                je(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aC(int i) {
        if (!aGw()) {
            je(1);
            return;
        }
        if (this.bJe == null) {
            je(this.ccB.voice_status.intValue());
        }
        jd(i);
        if (this.ccB != null) {
            this.ccB.elapse = i;
        }
    }

    private boolean aGw() {
        if (this.ccB == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.ccB);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ccB;
    }

    public void aGx() {
        aGu();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getRealView(this.ccB);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getRealView(this.ccB);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oi() {
    }

    public void reset() {
        this.ccB = null;
        setTag(null);
        je(1);
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

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aeG = onClickListener;
    }
}
