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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener adX;
    private VoiceManager bQb;
    private AnimationDrawable cRE;
    private ProgressBar coW;
    private ImageView dnQ;
    private VoiceData.VoiceModel dnU;
    private TextView fxP;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fxQ) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bv(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bv(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(r.e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(r.e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(r.e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(r.e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        P(context);
        setOnClickListener(this);
    }

    public void P(Context context) {
        LayoutInflater.from(context).inflate(r.h.play_voice_bnt, (ViewGroup) this, true);
        this.dnQ = (ImageView) findViewById(r.g.playingImg);
        this.fxP = (TextView) findViewById(r.g.playTime);
        this.coW = (ProgressBar) findViewById(r.g.progress);
        if (this.coW != null) {
            this.coW.setVisibility(4);
        }
        this.mContext = context;
        bkT();
        setContentDescription(TbadkCoreApplication.m9getInst().getString(r.j.editor_record));
    }

    private void bkT() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            av.k(this, r.f.but_thread_voice_selector);
            if (this.fxP != null) {
                this.fxP.setTextSize(0, this.mContext.getResources().getDimension(r.e.ds36));
                this.fxP.setTextColor(i);
            }
            if (this.dnQ != null) {
                av.c(this.dnQ, r.a.voice_btn_play_anim);
            }
            this.dnQ.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            av.k(this, r.f.but_thread_voice_reply_selector);
            if (this.fxP != null) {
                this.fxP.setTextSize(0, this.mContext.getResources().getDimension(r.e.ds28));
                this.fxP.setTextColor(i2);
            }
            if (this.dnQ != null) {
                av.c(this.dnQ, r.a.voice_btn_play_anim);
            }
            this.dnQ.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dnQ.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dnU = voiceModel;
        if (this.dnU != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                md(this.dnU.elapse);
                return;
            }
            me(this.dnU.voice_status.intValue());
            this.fxP.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void md(int i) {
        String formatVoiceTime;
        if (this.dnU != null && this.fxP != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dnU.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dnU.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dnU.duration);
            }
            String a = j.a(this.fxP.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fxP.setText(formatVoiceTime);
            }
        }
    }

    public void me(int i) {
        if (i == 3) {
            if (this.dnQ != null) {
                this.dnQ.setVisibility(0);
            }
            this.coW.setVisibility(4);
            axf();
            return;
        }
        axg();
        if (i == 1) {
            if (this.dnQ != null) {
                this.dnQ.setVisibility(0);
            }
            if (this.dnU != null) {
                this.fxP.setText(VoiceManager.formatVoiceTime(this.dnU.duration));
            }
            this.coW.setVisibility(4);
        } else if (i == 2) {
            if (this.dnU != null) {
                this.fxP.setText(VoiceManager.formatVoiceTime(this.dnU.duration));
            }
            this.coW.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dnU != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.adX != null) {
                this.adX.onClick(view);
            }
            TiebaStatic.log(this.dnU.from);
        }
    }

    private void bkU() {
        int i;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        }
        if (this.dnQ != null) {
            this.dnQ.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m9getInst().getSkinType();
        if (this.dnQ != null) {
            if (this.play_type == 0) {
                av.c(this.dnQ, r.f.icon_thread_voice_reply_curve_three);
            } else {
                av.c(this.dnQ, r.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void axf() {
        if (this.cRE != null) {
            this.cRE.stop();
        }
        bkU();
        this.cRE = (AnimationDrawable) this.dnQ.getDrawable();
        this.cRE.start();
    }

    public void axg() {
        Drawable drawable = this.dnQ.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cRE = (AnimationDrawable) drawable;
        }
        if (this.cRE != null) {
            this.cRE.stop();
        }
        this.cRE = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bQb = voiceManager;
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
        return this.bQb;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.IT();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.IS() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.G(voiceModel);
            }
            this.play_type = zVar.IS();
            setVoiceModel(voiceModel);
            bkT();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dnU != voiceModel) {
                me(1);
            } else {
                me(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bkV()) {
            me(1);
            return;
        }
        if (this.cRE == null) {
            me(this.dnU.voice_status.intValue());
        }
        md(i);
        if (this.dnU != null) {
            this.dnU.elapse = i;
        }
    }

    private boolean bkV() {
        if (this.dnU == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dnU);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dnU;
    }

    public void aCk() {
        bkT();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dnU);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dnU);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lD() {
    }

    public void reset() {
        this.dnU = null;
        setTag(null);
        me(1);
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
        this.adX = onClickListener;
    }
}
