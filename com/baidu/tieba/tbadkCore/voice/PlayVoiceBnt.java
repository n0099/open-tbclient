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
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener abc;
    private VoiceManager bEE;
    private AnimationDrawable cFg;
    private ProgressBar cdm;
    private ImageView daL;
    private VoiceData.VoiceModel daP;
    private TextView fno;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fnp) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bo(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bo(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(u.e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(u.e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(u.e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(u.e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        F(context);
        setOnClickListener(this);
    }

    public void F(Context context) {
        LayoutInflater.from(context).inflate(u.h.play_voice_bnt, (ViewGroup) this, true);
        this.daL = (ImageView) findViewById(u.g.playingImg);
        this.fno = (TextView) findViewById(u.g.playTime);
        this.cdm = (ProgressBar) findViewById(u.g.progress);
        if (this.cdm != null) {
            this.cdm.setVisibility(4);
        }
        this.mContext = context;
        bgG();
        setContentDescription(TbadkCoreApplication.m10getInst().getString(u.j.editor_record));
    }

    private void bgG() {
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            av.k(this, u.f.but_thread_voice_selector);
            if (this.fno != null) {
                this.fno.setTextSize(0, this.mContext.getResources().getDimension(u.e.ds36));
                this.fno.setTextColor(i);
            }
            if (this.daL != null) {
                av.c(this.daL, u.a.voice_btn_play_anim);
            }
            this.daL.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            av.k(this, u.f.but_thread_voice_reply_selector);
            if (this.fno != null) {
                this.fno.setTextSize(0, this.mContext.getResources().getDimension(u.e.ds28));
                this.fno.setTextColor(i2);
            }
            if (this.daL != null) {
                av.c(this.daL, u.a.voice_btn_play_anim);
            }
            this.daL.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.daL.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.daP = voiceModel;
        if (this.daP != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ls(this.daP.elapse);
                return;
            }
            lt(this.daP.voice_status.intValue());
            this.fno.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ls(int i) {
        String formatVoiceTime;
        if (this.daP != null && this.fno != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.daP.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.daP.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.daP.duration);
            }
            String a = j.a(this.fno.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fno.setText(formatVoiceTime);
            }
        }
    }

    public void lt(int i) {
        if (i == 3) {
            if (this.daL != null) {
                this.daL.setVisibility(0);
            }
            this.cdm.setVisibility(4);
            arS();
            return;
        }
        arT();
        if (i == 1) {
            if (this.daL != null) {
                this.daL.setVisibility(0);
            }
            if (this.daP != null) {
                this.fno.setText(VoiceManager.formatVoiceTime(this.daP.duration));
            }
            this.cdm.setVisibility(4);
        } else if (i == 2) {
            if (this.daP != null) {
                this.fno.setText(VoiceManager.formatVoiceTime(this.daP.duration));
            }
            this.cdm.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.daP != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.abc != null) {
                this.abc.onClick(view);
            }
            TiebaStatic.log(this.daP.from);
        }
    }

    private void bgH() {
        int i;
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? u.a.voice_btn_play_anim : u.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? u.a.voice_btn_play_anim : u.a.voice_btn_play_anim_1;
        }
        if (this.daL != null) {
            this.daL.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m10getInst().getSkinType();
        if (this.daL != null) {
            if (this.play_type == 0) {
                av.c(this.daL, u.f.icon_thread_voice_reply_curve_three);
            } else {
                av.c(this.daL, u.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void arS() {
        if (this.cFg != null) {
            this.cFg.stop();
        }
        bgH();
        this.cFg = (AnimationDrawable) this.daL.getDrawable();
        this.cFg.start();
    }

    public void arT() {
        Drawable drawable = this.daL.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cFg = (AnimationDrawable) drawable;
        }
        if (this.cFg != null) {
            this.cFg.stop();
        }
        this.cFg = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bEE = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bEE;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.Hu();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.Ht() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.G(voiceModel);
            }
            this.play_type = zVar.Ht();
            setVoiceModel(voiceModel);
            bgG();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.daP != voiceModel) {
                lt(1);
            } else {
                lt(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aF(int i) {
        if (!bgI()) {
            lt(1);
            return;
        }
        if (this.cFg == null) {
            lt(this.daP.voice_status.intValue());
        }
        ls(i);
        if (this.daP != null) {
            this.daP.elapse = i;
        }
    }

    private boolean bgI() {
        if (this.daP == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.daP);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.daP;
    }

    public void bgJ() {
        bgG();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.daP);
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.daP);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kI() {
    }

    public void reset() {
        this.daP = null;
        setTag(null);
        lt(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int A = k.A(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (A * 0.3f);
                return (((i - 10) * (((int) (A * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (A * 0.45f);
        }
        int i3 = (int) (A * 0.18f);
        int i4 = (int) (A * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.abc = onClickListener;
    }
}
