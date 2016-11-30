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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aev;
    private VoiceManager bRV;
    private AnimationDrawable cXf;
    private ProgressBar cub;
    private VoiceData.VoiceModel dtD;
    private ImageView dtz;
    private TextView fFp;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fFq) with 'values()' method */
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
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bA(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bA(int i, int i2) {
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
        this.dtz = (ImageView) findViewById(r.g.playingImg);
        this.fFp = (TextView) findViewById(r.g.playTime);
        this.cub = (ProgressBar) findViewById(r.g.progress);
        if (this.cub != null) {
            this.cub.setVisibility(4);
        }
        this.mContext = context;
        bnj();
        setContentDescription(TbadkCoreApplication.m9getInst().getString(r.j.editor_record));
    }

    private void bnj() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            at.k(this, r.f.but_thread_voice_selector);
            if (this.fFp != null) {
                this.fFp.setTextSize(0, this.mContext.getResources().getDimension(r.e.ds36));
                this.fFp.setTextColor(i);
            }
            if (this.dtz != null) {
                at.c(this.dtz, r.a.voice_btn_play_anim);
            }
            this.dtz.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            at.k(this, r.f.but_thread_voice_reply_selector);
            if (this.fFp != null) {
                this.fFp.setTextSize(0, this.mContext.getResources().getDimension(r.e.ds28));
                this.fFp.setTextColor(i2);
            }
            if (this.dtz != null) {
                at.c(this.dtz, r.a.voice_btn_play_anim);
            }
            this.dtz.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dtz.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dtD = voiceModel;
        if (this.dtD != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ml(this.dtD.elapse);
                return;
            }
            mm(this.dtD.voice_status.intValue());
            this.fFp.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ml(int i) {
        String formatVoiceTime;
        if (this.dtD != null && this.fFp != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dtD.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dtD.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dtD.duration);
            }
            String a = j.a(this.fFp.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fFp.setText(formatVoiceTime);
            }
        }
    }

    public void mm(int i) {
        if (i == 3) {
            if (this.dtz != null) {
                this.dtz.setVisibility(0);
            }
            this.cub.setVisibility(4);
            azc();
            return;
        }
        azd();
        if (i == 1) {
            if (this.dtz != null) {
                this.dtz.setVisibility(0);
            }
            if (this.dtD != null) {
                this.fFp.setText(VoiceManager.formatVoiceTime(this.dtD.duration));
            }
            this.cub.setVisibility(4);
        } else if (i == 2) {
            if (this.dtD != null) {
                this.fFp.setText(VoiceManager.formatVoiceTime(this.dtD.duration));
            }
            this.cub.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dtD != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aev != null) {
                this.aev.onClick(view);
            }
            TiebaStatic.log(this.dtD.from);
        }
    }

    private void bnk() {
        int i;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        }
        if (this.dtz != null) {
            this.dtz.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m9getInst().getSkinType();
        if (this.dtz != null) {
            if (this.play_type == 0) {
                at.c(this.dtz, r.f.icon_thread_voice_reply_curve_three);
            } else {
                at.c(this.dtz, r.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void azc() {
        if (this.cXf != null) {
            this.cXf.stop();
        }
        bnk();
        this.cXf = (AnimationDrawable) this.dtz.getDrawable();
        this.cXf.start();
    }

    public void azd() {
        Drawable drawable = this.dtz.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cXf = (AnimationDrawable) drawable;
        }
        if (this.cXf != null) {
            this.cXf.stop();
        }
        this.cXf = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bRV = voiceManager;
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
        return this.bRV;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.IW();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.IV() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.G(voiceModel);
            }
            this.play_type = zVar.IV();
            setVoiceModel(voiceModel);
            bnj();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dtD != voiceModel) {
                mm(1);
            } else {
                mm(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bnl()) {
            mm(1);
            return;
        }
        if (this.cXf == null) {
            mm(this.dtD.voice_status.intValue());
        }
        ml(i);
        if (this.dtD != null) {
            this.dtD.elapse = i;
        }
    }

    private boolean bnl() {
        if (this.dtD == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dtD);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dtD;
    }

    public void aEg() {
        bnj();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dtD);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dtD);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    public void reset() {
        this.dtD = null;
        setTag(null);
        mm(1);
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
        this.aev = onClickListener;
    }
}
