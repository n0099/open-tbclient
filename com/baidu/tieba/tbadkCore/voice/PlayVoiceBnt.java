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
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aiC;
    private VoiceManager bMC;
    private AnimationDrawable cKI;
    private VoiceData.VoiceModel dgC;
    private ImageView dgy;
    private TextView fyP;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fyQ) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bs(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bs(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(w.f.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(w.f.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(w.f.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(w.f.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        ak(context);
        setOnClickListener(this);
    }

    public void ak(Context context) {
        LayoutInflater.from(context).inflate(w.j.play_voice_bnt, (ViewGroup) this, true);
        this.dgy = (ImageView) findViewById(w.h.playingImg);
        this.fyP = (TextView) findViewById(w.h.playTime);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bjp();
        setContentDescription(TbadkCoreApplication.m9getInst().getString(w.l.editor_record));
    }

    private void bjp() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aq.j(this, w.g.but_thread_voice_selector);
            if (this.fyP != null) {
                this.fyP.setTextSize(0, this.mContext.getResources().getDimension(w.f.ds36));
                this.fyP.setTextColor(i);
            }
            if (this.dgy != null) {
                aq.c(this.dgy, w.a.voice_btn_play_anim);
            }
            this.dgy.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aq.j(this, w.g.but_thread_voice_reply_selector);
            if (this.fyP != null) {
                this.fyP.setTextSize(0, this.mContext.getResources().getDimension(w.f.ds28));
                this.fyP.setTextColor(i2);
            }
            if (this.dgy != null) {
                aq.c(this.dgy, w.a.voice_btn_play_anim);
            }
            this.dgy.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dgy.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dgC = voiceModel;
        if (this.dgC != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lZ(this.dgC.elapse);
                return;
            }
            ma(this.dgC.voice_status.intValue());
            this.fyP.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lZ(int i) {
        String formatVoiceTime;
        if (this.dgC != null && this.fyP != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dgC.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dgC.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dgC.duration);
            }
            String a = j.a(this.fyP.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fyP.setText(formatVoiceTime);
            }
        }
    }

    public void ma(int i) {
        if (i == 3) {
            if (this.dgy != null) {
                this.dgy.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            atV();
            return;
        }
        atW();
        if (i == 1) {
            if (this.dgy != null) {
                this.dgy.setVisibility(0);
            }
            if (this.dgC != null) {
                this.fyP.setText(VoiceManager.formatVoiceTime(this.dgC.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dgC != null) {
                this.fyP.setText(VoiceManager.formatVoiceTime(this.dgC.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dgC != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiC != null) {
                this.aiC.onClick(view);
            }
            TiebaStatic.log(this.dgC.from);
        }
    }

    private void bjq() {
        int i;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? w.a.voice_btn_play_anim : w.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? w.a.voice_btn_play_anim : w.a.voice_btn_play_anim_1;
        }
        if (this.dgy != null) {
            this.dgy.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m9getInst().getSkinType();
        if (this.dgy != null) {
            if (this.play_type == 0) {
                aq.c(this.dgy, w.g.icon_thread_voice_reply_curve_three);
            } else {
                aq.c(this.dgy, w.g.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void atV() {
        if (this.cKI != null) {
            this.cKI.stop();
        }
        bjq();
        this.cKI = (AnimationDrawable) this.dgy.getDrawable();
        this.cKI.start();
    }

    public void atW() {
        Drawable drawable = this.dgy.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cKI = (AnimationDrawable) drawable;
        }
        if (this.cKI != null) {
            this.cKI.stop();
        }
        this.cKI = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bMC = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.k.Z(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bMC;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Jh();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Jg() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Jg();
            setVoiceModel(voiceModel);
            bjp();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dgC != voiceModel) {
                ma(1);
            } else {
                ma(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (!bjr()) {
            ma(1);
            return;
        }
        if (this.cKI == null) {
            ma(this.dgC.voice_status.intValue());
        }
        lZ(i);
        if (this.dgC != null) {
            this.dgC.elapse = i;
        }
    }

    private boolean bjr() {
        if (this.dgC == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dgC);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dgC;
    }

    public void bac() {
        bjp();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dgC);
        }
        if ((com.baidu.adp.base.k.Z(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dgC);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void mw() {
    }

    public void reset() {
        this.dgC = null;
        setTag(null);
        ma(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int af = k.af(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (af * 0.3f);
                return (((i - 10) * (((int) (af * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (af * 0.45f);
        }
        int i3 = (int) (af * 0.18f);
        int i4 = (int) (af * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }
}
