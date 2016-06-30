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
    private View.OnClickListener aat;
    private VoiceManager bBm;
    private AnimationDrawable cCr;
    private ImageView cXO;
    private VoiceData.VoiceModel cXS;
    private ProgressBar cbl;
    private TextView fak;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fal) with 'values()' method */
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bl(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bl(int i, int i2) {
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
        this.cXO = (ImageView) findViewById(u.g.playingImg);
        this.fak = (TextView) findViewById(u.g.playTime);
        this.cbl = (ProgressBar) findViewById(u.g.progress);
        if (this.cbl != null) {
            this.cbl.setVisibility(4);
        }
        this.mContext = context;
        bdo();
        setContentDescription(TbadkCoreApplication.m9getInst().getString(u.j.editor_record));
    }

    private void bdo() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            av.k(this, u.f.but_thread_voice_selector);
            if (this.fak != null) {
                this.fak.setTextSize(0, this.mContext.getResources().getDimension(u.e.ds36));
                this.fak.setTextColor(i);
            }
            if (this.cXO != null) {
                av.c(this.cXO, u.a.voice_btn_play_anim);
            }
            this.cXO.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            av.k(this, u.f.but_thread_voice_reply_selector);
            if (this.fak != null) {
                this.fak.setTextSize(0, this.mContext.getResources().getDimension(u.e.ds28));
                this.fak.setTextColor(i2);
            }
            if (this.cXO != null) {
                av.c(this.cXO, u.a.voice_btn_play_anim);
            }
            this.cXO.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.cXO.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.cXS = voiceModel;
        if (this.cXS != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lm(this.cXS.elapse);
                return;
            }
            ln(this.cXS.voice_status.intValue());
            this.fak.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lm(int i) {
        String formatVoiceTime;
        if (this.cXS != null && this.fak != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.cXS.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cXS.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.cXS.duration);
            }
            String a = j.a(this.fak.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fak.setText(formatVoiceTime);
            }
        }
    }

    public void ln(int i) {
        if (i == 3) {
            if (this.cXO != null) {
                this.cXO.setVisibility(0);
            }
            this.cbl.setVisibility(4);
            arg();
            return;
        }
        arh();
        if (i == 1) {
            if (this.cXO != null) {
                this.cXO.setVisibility(0);
            }
            if (this.cXS != null) {
                this.fak.setText(VoiceManager.formatVoiceTime(this.cXS.duration));
            }
            this.cbl.setVisibility(4);
        } else if (i == 2) {
            if (this.cXS != null) {
                this.fak.setText(VoiceManager.formatVoiceTime(this.cXS.duration));
            }
            this.cbl.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.cXS != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aat != null) {
                this.aat.onClick(view);
            }
            TiebaStatic.log(this.cXS.from);
        }
    }

    private void bdp() {
        int i;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? u.a.voice_btn_play_anim : u.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? u.a.voice_btn_play_anim : u.a.voice_btn_play_anim_1;
        }
        if (this.cXO != null) {
            this.cXO.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m9getInst().getSkinType();
        if (this.cXO != null) {
            if (this.play_type == 0) {
                av.c(this.cXO, u.f.icon_thread_voice_reply_curve_three);
            } else {
                av.c(this.cXO, u.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void arg() {
        if (this.cCr != null) {
            this.cCr.stop();
        }
        bdp();
        this.cCr = (AnimationDrawable) this.cXO.getDrawable();
        this.cCr.start();
    }

    public void arh() {
        Drawable drawable = this.cXO.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cCr = (AnimationDrawable) drawable;
        }
        if (this.cCr != null) {
            this.cCr.stop();
        }
        this.cCr = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bBm = voiceManager;
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
        return this.bBm;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.Hw();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.Hv() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.D(voiceModel);
            }
            this.play_type = zVar.Hv();
            setVoiceModel(voiceModel);
            bdo();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.cXS != voiceModel) {
                ln(1);
            } else {
                ln(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aC(int i) {
        if (!bdq()) {
            ln(1);
            return;
        }
        if (this.cCr == null) {
            ln(this.cXS.voice_status.intValue());
        }
        lm(i);
        if (this.cXS != null) {
            this.cXS.elapse = i;
        }
    }

    private boolean bdq() {
        if (this.cXS == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.cXS);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.cXS;
    }

    public void bdr() {
        bdo();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.cXS);
        }
        if ((l.s(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.s(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.cXS);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void kM() {
    }

    public void reset() {
        this.cXS = null;
        setTag(null);
        ln(1);
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
        this.aat = onClickListener;
    }
}
