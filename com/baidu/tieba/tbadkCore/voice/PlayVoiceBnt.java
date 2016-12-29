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
import com.baidu.tbadk.widget.richText.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener adO;
    private ProgressBar ban;
    private VoiceManager byf;
    private AnimationDrawable cCn;
    private ImageView cYt;
    private VoiceData.VoiceModel cYx;
    private TextView fjw;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fjx) with 'values()' method */
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bp(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bp(int i, int i2) {
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
        N(context);
        setOnClickListener(this);
    }

    public void N(Context context) {
        LayoutInflater.from(context).inflate(r.h.play_voice_bnt, (ViewGroup) this, true);
        this.cYt = (ImageView) findViewById(r.g.playingImg);
        this.fjw = (TextView) findViewById(r.g.playTime);
        this.ban = (ProgressBar) findViewById(r.g.progress);
        if (this.ban != null) {
            this.ban.setVisibility(4);
        }
        this.mContext = context;
        bhd();
        setContentDescription(TbadkCoreApplication.m9getInst().getString(r.j.editor_record));
    }

    private void bhd() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ar.k(this, r.f.but_thread_voice_selector);
            if (this.fjw != null) {
                this.fjw.setTextSize(0, this.mContext.getResources().getDimension(r.e.ds36));
                this.fjw.setTextColor(i);
            }
            if (this.cYt != null) {
                ar.c(this.cYt, r.a.voice_btn_play_anim);
            }
            this.cYt.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ar.k(this, r.f.but_thread_voice_reply_selector);
            if (this.fjw != null) {
                this.fjw.setTextSize(0, this.mContext.getResources().getDimension(r.e.ds28));
                this.fjw.setTextColor(i2);
            }
            if (this.cYt != null) {
                ar.c(this.cYt, r.a.voice_btn_play_anim);
            }
            this.cYt.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.cYt.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.cYx = voiceModel;
        if (this.cYx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lv(this.cYx.elapse);
                return;
            }
            lw(this.cYx.voice_status.intValue());
            this.fjw.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lv(int i) {
        String formatVoiceTime;
        if (this.cYx != null && this.fjw != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.cYx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cYx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cYx.duration);
            }
            String a = j.a(this.fjw.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fjw.setText(formatVoiceTime);
            }
        }
    }

    public void lw(int i) {
        if (i == 3) {
            if (this.cYt != null) {
                this.cYt.setVisibility(0);
            }
            this.ban.setVisibility(4);
            atB();
            return;
        }
        atC();
        if (i == 1) {
            if (this.cYt != null) {
                this.cYt.setVisibility(0);
            }
            if (this.cYx != null) {
                this.fjw.setText(VoiceManager.formatVoiceTime(this.cYx.duration));
            }
            this.ban.setVisibility(4);
        } else if (i == 2) {
            if (this.cYx != null) {
                this.fjw.setText(VoiceManager.formatVoiceTime(this.cYx.duration));
            }
            this.ban.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cYx != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.adO != null) {
                this.adO.onClick(view);
            }
            TiebaStatic.log(this.cYx.from);
        }
    }

    private void bhe() {
        int i;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        }
        if (this.cYt != null) {
            this.cYt.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m9getInst().getSkinType();
        if (this.cYt != null) {
            if (this.play_type == 0) {
                ar.c(this.cYt, r.f.icon_thread_voice_reply_curve_three);
            } else {
                ar.c(this.cYt, r.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void atB() {
        if (this.cCn != null) {
            this.cCn.stop();
        }
        bhe();
        this.cCn = (AnimationDrawable) this.cYt.getDrawable();
        this.cCn.start();
    }

    public void atC() {
        Drawable drawable = this.cYt.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cCn = (AnimationDrawable) drawable;
        }
        if (this.cCn != null) {
            this.cCn.stop();
        }
        this.cCn = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.byf = voiceManager;
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
        return this.byf;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof y)) {
            y yVar = (y) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) yVar.Ir();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (yVar.Iq() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = yVar.getMd5();
                voiceModel.duration = yVar.getDuration();
                yVar.G(voiceModel);
            }
            this.play_type = yVar.Iq();
            setVoiceModel(voiceModel);
            bhd();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.cYx != voiceModel) {
                lw(1);
            } else {
                lw(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aT(int i) {
        if (!bhf()) {
            lw(1);
            return;
        }
        if (this.cCn == null) {
            lw(this.cYx.voice_status.intValue());
        }
        lv(i);
        if (this.cYx != null) {
            this.cYx.elapse = i;
        }
    }

    private boolean bhf() {
        if (this.cYx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.cYx);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.cYx;
    }

    public void axx() {
        bhd();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.cYx);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.cYx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    public void reset() {
        this.cYx = null;
        setTag(null);
        lw(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int I = k.I(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (I * 0.3f);
                return (((i - 10) * (((int) (I * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (I * 0.45f);
        }
        int i3 = (int) (I * 0.18f);
        int i4 = (int) (I * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.adO = onClickListener;
    }
}
