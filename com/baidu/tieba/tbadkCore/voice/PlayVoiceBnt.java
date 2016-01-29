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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.v;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private ProgressBar aNo;
    private View.OnClickListener afh;
    private AnimationDrawable bML;
    private VoiceManager ben;
    private ImageView cgX;
    private VoiceData.VoiceModel chb;
    private TextView dZv;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (dZw) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, t.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bf(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bf(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(t.e.voice_play_bnt_width_0);
            iArr[1] = (int) getContext().getResources().getDimension(t.e.voice_play_bnt_height_0);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(t.e.voice_play_bnt_width_1);
            iArr[1] = (int) getContext().getResources().getDimension(t.e.voice_play_bnt_height_1);
        }
        return iArr;
    }

    public void init(Context context) {
        P(context);
        setOnClickListener(this);
    }

    public void P(Context context) {
        LayoutInflater.from(context).inflate(t.h.play_voice_bnt, (ViewGroup) this, true);
        this.cgX = (ImageView) findViewById(t.g.playingImg);
        this.dZv = (TextView) findViewById(t.g.playTime);
        this.aNo = (ProgressBar) findViewById(t.g.progress);
        if (this.aNo != null) {
            this.aNo.setVisibility(4);
        }
        this.mContext = context;
        aNy();
    }

    private void aNy() {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ar.k(this, t.f.but_thread_voice_selector);
            if (this.dZv != null) {
                this.dZv.setTextSize(0, this.mContext.getResources().getDimension(t.e.voice_play_bnt_text_size_0));
                this.dZv.setTextColor(i);
            }
            if (this.cgX != null) {
                ar.c(this.cgX, t.a.voice_btn_play_anim);
            }
            this.cgX.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ar.k(this, t.f.but_thread_voice_reply_selector);
            if (this.dZv != null) {
                this.dZv.setTextSize(0, this.mContext.getResources().getDimension(t.e.voice_play_bnt_text_size_1));
                this.dZv.setTextColor(i2);
            }
            if (this.cgX != null) {
                ar.c(this.cgX, t.a.voice_btn_play_anim);
            }
            this.cgX.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.cgX.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.chb = voiceModel;
        if (this.chb != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                jA(this.chb.elapse);
                return;
            }
            jB(this.chb.voice_status.intValue());
            this.dZv.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void jA(int i) {
        String formatVoiceTime;
        if (this.chb != null && this.dZv != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.chb.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.chb.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.chb.duration);
            }
            String a = j.a(this.dZv.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.dZv.setText(formatVoiceTime);
            }
        }
    }

    public void jB(int i) {
        if (i == 3) {
            if (this.cgX != null) {
                this.cgX.setVisibility(0);
            }
            this.aNo.setVisibility(4);
            afq();
            return;
        }
        afr();
        if (i == 1) {
            if (this.cgX != null) {
                this.cgX.setVisibility(0);
            }
            if (this.chb != null) {
                this.dZv.setText(VoiceManager.formatVoiceTime(this.chb.duration));
            }
            this.aNo.setVisibility(4);
        } else if (i == 2) {
            if (this.chb != null) {
                this.dZv.setText(VoiceManager.formatVoiceTime(this.chb.duration));
            }
            this.aNo.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.chb != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.afh != null) {
                this.afh.onClick(view);
            }
            TiebaStatic.log(this.chb.from);
        }
    }

    private void aNz() {
        int i;
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? t.a.voice_btn_play_anim : t.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? t.a.voice_btn_play_anim : t.a.voice_btn_play_anim_1;
        }
        if (this.cgX != null) {
            this.cgX.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m411getInst().getSkinType();
        if (this.cgX != null) {
            if (this.play_type == 0) {
                ar.c(this.cgX, t.f.icon_thread_voice_reply_curve_three);
            } else {
                ar.c(this.cgX, t.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void afq() {
        if (this.bML != null) {
            this.bML.stop();
        }
        aNz();
        this.bML = (AnimationDrawable) this.cgX.getDrawable();
        this.bML.start();
    }

    public void afr() {
        Drawable drawable = this.cgX.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.bML = (AnimationDrawable) drawable;
        }
        if (this.bML != null) {
            this.bML.stop();
        }
        this.bML = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.ben = voiceManager;
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
        return this.ben;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof v)) {
            v vVar = (v) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) vVar.HH();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (vVar.HG() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = vVar.getMd5();
                voiceModel.duration = vVar.getDuration();
                vVar.C(voiceModel);
            }
            this.play_type = vVar.HG();
            setVoiceModel(voiceModel);
            aNy();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.chb != voiceModel) {
                jB(1);
            } else {
                jB(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        if (!aNA()) {
            jB(1);
            return;
        }
        if (this.bML == null) {
            jB(this.chb.voice_status.intValue());
        }
        jA(i);
        if (this.chb != null) {
            this.chb.elapse = i;
        }
    }

    private boolean aNA() {
        if (this.chb == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.chb);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.u(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.chb;
    }

    public void aNB() {
        aNy();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.chb);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.chb);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oD() {
    }

    public void reset() {
        this.chb = null;
        setTag(null);
        jB(1);
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
        this.afh = onClickListener;
    }
}
