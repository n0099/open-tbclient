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
    private View.OnClickListener aio;
    private VoiceManager bMM;
    private ProgressBar bqO;
    private AnimationDrawable cMj;
    private ImageView dhZ;
    private VoiceData.VoiceModel did;
    private TextView fxf;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fxg) with 'values()' method */
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
            iArr[0] = (int) getContext().getResources().getDimension(w.f.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(w.f.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(w.f.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(w.f.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        al(context);
        setOnClickListener(this);
    }

    public void al(Context context) {
        LayoutInflater.from(context).inflate(w.j.play_voice_bnt, (ViewGroup) this, true);
        this.dhZ = (ImageView) findViewById(w.h.playingImg);
        this.fxf = (TextView) findViewById(w.h.playTime);
        this.bqO = (ProgressBar) findViewById(w.h.progress);
        if (this.bqO != null) {
            this.bqO.setVisibility(4);
        }
        this.mContext = context;
        biE();
        setContentDescription(TbadkCoreApplication.m9getInst().getString(w.l.editor_record));
    }

    private void biE() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            aq.j(this, w.g.but_thread_voice_selector);
            if (this.fxf != null) {
                this.fxf.setTextSize(0, this.mContext.getResources().getDimension(w.f.ds36));
                this.fxf.setTextColor(i);
            }
            if (this.dhZ != null) {
                aq.c(this.dhZ, w.a.voice_btn_play_anim);
            }
            this.dhZ.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            aq.j(this, w.g.but_thread_voice_reply_selector);
            if (this.fxf != null) {
                this.fxf.setTextSize(0, this.mContext.getResources().getDimension(w.f.ds28));
                this.fxf.setTextColor(i2);
            }
            if (this.dhZ != null) {
                aq.c(this.dhZ, w.a.voice_btn_play_anim);
            }
            this.dhZ.setPadding(k.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.dhZ.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.did = voiceModel;
        if (this.did != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lY(this.did.elapse);
                return;
            }
            lZ(this.did.voice_status.intValue());
            this.fxf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lY(int i) {
        String formatVoiceTime;
        if (this.did != null && this.fxf != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.did.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.did.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.did.duration);
            }
            String a = j.a(this.fxf.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fxf.setText(formatVoiceTime);
            }
        }
    }

    public void lZ(int i) {
        if (i == 3) {
            if (this.dhZ != null) {
                this.dhZ.setVisibility(0);
            }
            this.bqO.setVisibility(4);
            auc();
            return;
        }
        aud();
        if (i == 1) {
            if (this.dhZ != null) {
                this.dhZ.setVisibility(0);
            }
            if (this.did != null) {
                this.fxf.setText(VoiceManager.formatVoiceTime(this.did.duration));
            }
            this.bqO.setVisibility(4);
        } else if (i == 2) {
            if (this.did != null) {
                this.fxf.setText(VoiceManager.formatVoiceTime(this.did.duration));
            }
            this.bqO.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.did != null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aio != null) {
                this.aio.onClick(view);
            }
            TiebaStatic.log(this.did.from);
        }
    }

    private void biF() {
        int i;
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? w.a.voice_btn_play_anim : w.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? w.a.voice_btn_play_anim : w.a.voice_btn_play_anim_1;
        }
        if (this.dhZ != null) {
            this.dhZ.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.m9getInst().getSkinType();
        if (this.dhZ != null) {
            if (this.play_type == 0) {
                aq.c(this.dhZ, w.g.icon_thread_voice_reply_curve_three);
            } else {
                aq.c(this.dhZ, w.g.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void auc() {
        if (this.cMj != null) {
            this.cMj.stop();
        }
        biF();
        this.cMj = (AnimationDrawable) this.dhZ.getDrawable();
        this.cMj.start();
    }

    public void aud() {
        Drawable drawable = this.dhZ.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.cMj = (AnimationDrawable) drawable;
        }
        if (this.cMj != null) {
            this.cMj.stop();
        }
        this.cMj = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bMM = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.k.aa(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.aa(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bMM;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.II();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.IH() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.IH();
            setVoiceModel(voiceModel);
            biE();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.did != voiceModel) {
                lZ(1);
            } else {
                lZ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!biG()) {
            lZ(1);
            return;
        }
        if (this.cMj == null) {
            lZ(this.did.voice_status.intValue());
        }
        lY(i);
        if (this.did != null) {
            this.did.elapse = i;
        }
    }

    private boolean biG() {
        if (this.did == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.did);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.G(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.did;
    }

    public void ayg() {
        biE();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.did);
        }
        if ((com.baidu.adp.base.k.aa(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.aa(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.did);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ms() {
    }

    public void reset() {
        this.did = null;
        setTag(null);
        lZ(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int ag = k.ag(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (ag * 0.3f);
                return (((i - 10) * (((int) (ag * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (ag * 0.45f);
        }
        int i3 = (int) (ag * 0.18f);
        int i4 = (int) (ag * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aio = onClickListener;
    }
}
