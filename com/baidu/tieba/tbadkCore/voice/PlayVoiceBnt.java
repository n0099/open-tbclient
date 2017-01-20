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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener acY;
    private VoiceManager bFE;
    private ProgressBar bkd;
    private AnimationDrawable cJr;
    private ImageView dfI;
    private VoiceData.VoiceModel dfM;
    private TextView fsI;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fsJ) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bq(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int bq(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(r.f.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(r.f.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(r.f.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(r.f.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        N(context);
        setOnClickListener(this);
    }

    public void N(Context context) {
        LayoutInflater.from(context).inflate(r.j.play_voice_bnt, (ViewGroup) this, true);
        this.dfI = (ImageView) findViewById(r.h.playingImg);
        this.fsI = (TextView) findViewById(r.h.playTime);
        this.bkd = (ProgressBar) findViewById(r.h.progress);
        if (this.bkd != null) {
            this.bkd.setVisibility(4);
        }
        this.mContext = context;
        biO();
        setContentDescription(TbadkCoreApplication.m9getInst().getString(r.l.editor_record));
    }

    private void biO() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ap.j(this, r.g.but_thread_voice_selector);
            if (this.fsI != null) {
                this.fsI.setTextSize(0, this.mContext.getResources().getDimension(r.f.ds36));
                this.fsI.setTextColor(i);
            }
            if (this.dfI != null) {
                ap.c(this.dfI, r.a.voice_btn_play_anim);
            }
            this.dfI.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ap.j(this, r.g.but_thread_voice_reply_selector);
            if (this.fsI != null) {
                this.fsI.setTextSize(0, this.mContext.getResources().getDimension(r.f.ds28));
                this.fsI.setTextColor(i2);
            }
            if (this.dfI != null) {
                ap.c(this.dfI, r.a.voice_btn_play_anim);
            }
            this.dfI.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dfI.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dfM = voiceModel;
        if (this.dfM != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mi(this.dfM.elapse);
                return;
            }
            mj(this.dfM.voice_status.intValue());
            this.fsI.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mi(int i) {
        String formatVoiceTime;
        if (this.dfM != null && this.fsI != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dfM.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dfM.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dfM.duration);
            }
            String a = j.a(this.fsI.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fsI.setText(formatVoiceTime);
            }
        }
    }

    public void mj(int i) {
        if (i == 3) {
            if (this.dfI != null) {
                this.dfI.setVisibility(0);
            }
            this.bkd.setVisibility(4);
            auH();
            return;
        }
        auI();
        if (i == 1) {
            if (this.dfI != null) {
                this.dfI.setVisibility(0);
            }
            if (this.dfM != null) {
                this.fsI.setText(VoiceManager.formatVoiceTime(this.dfM.duration));
            }
            this.bkd.setVisibility(4);
        } else if (i == 2) {
            if (this.dfM != null) {
                this.fsI.setText(VoiceManager.formatVoiceTime(this.dfM.duration));
            }
            this.bkd.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dfM != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.acY != null) {
                this.acY.onClick(view);
            }
            TiebaStatic.log(this.dfM.from);
        }
    }

    private void biP() {
        int i;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? r.a.voice_btn_play_anim : r.a.voice_btn_play_anim_1;
        }
        if (this.dfI != null) {
            this.dfI.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m9getInst().getSkinType();
        if (this.dfI != null) {
            if (this.play_type == 0) {
                ap.c(this.dfI, r.g.icon_thread_voice_reply_curve_three);
            } else {
                ap.c(this.dfI, r.g.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void auH() {
        if (this.cJr != null) {
            this.cJr.stop();
        }
        biP();
        this.cJr = (AnimationDrawable) this.dfI.getDrawable();
        this.cJr.start();
    }

    public void auI() {
        Drawable drawable = this.dfI.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cJr = (AnimationDrawable) drawable;
        }
        if (this.cJr != null) {
            this.cJr.stop();
        }
        this.cJr = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bFE = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.k.C(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bFE;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ii();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Ih() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Ih();
            setVoiceModel(voiceModel);
            biO();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dfM != voiceModel) {
                mj(1);
            } else {
                mj(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!biQ()) {
            mj(1);
            return;
        }
        if (this.cJr == null) {
            mj(this.dfM.voice_status.intValue());
        }
        mi(i);
        if (this.dfM != null) {
            this.dfM.elapse = i;
        }
    }

    private boolean biQ() {
        if (this.dfM == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dfM);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dfM;
    }

    public void ayK() {
        biO();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dfM);
        }
        if ((com.baidu.adp.base.k.C(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dfM);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ly() {
    }

    public void reset() {
        this.dfM = null;
        setTag(null);
        mj(1);
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
        this.acY = onClickListener;
    }
}
