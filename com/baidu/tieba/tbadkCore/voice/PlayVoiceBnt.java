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
import com.baidu.adp.base.e;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aiA;
    private VoiceManager hSO;
    private ImageView jAt;
    private VoiceData.VoiceModel jAx;
    private AnimationDrawable jcS;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView miy;
    private int play_type;

    /* loaded from: classes2.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(m43do(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    /* renamed from: do  reason: not valid java name */
    private int m43do(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = {0, 0};
        if (this.play_type == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        M(context);
        setOnClickListener(this);
    }

    public void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.jAt = (ImageView) findViewById(R.id.playingImg);
        this.miy = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dxO();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void dxO() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
            if (this.miy != null) {
                this.miy.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.miy.setTextColor(i);
            }
            if (this.jAt != null) {
                ap.setImageResource(this.jAt, R.anim.voice_btn_play_anim);
            }
            this.jAt.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            ap.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
            if (this.miy != null) {
                this.miy.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.miy.setTextColor(i2);
            }
            if (this.jAt != null) {
                ap.setImageResource(this.jAt, R.anim.voice_btn_play_anim);
            }
            this.jAt.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.jAt.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jAx = voiceModel;
        if (this.jAx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                BL(this.jAx.elapse);
                return;
            }
            BM(this.jAx.voice_status.intValue());
            this.miy.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void BL(int i) {
        String formatVoiceTime;
        if (this.jAx != null && this.miy != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jAx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jAx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jAx.duration);
            }
            String charSequence2String = k.charSequence2String(this.miy.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.miy.setText(formatVoiceTime);
            }
        }
    }

    public void BM(int i) {
        if (i == 3) {
            if (this.jAt != null) {
                this.jAt.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            cIE();
            return;
        }
        cIF();
        if (i == 1) {
            if (this.jAt != null) {
                this.jAt.setVisibility(0);
            }
            if (this.jAx != null) {
                this.miy.setText(VoiceManager.formatVoiceTime(this.jAx.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jAx != null) {
                this.miy.setText(VoiceManager.formatVoiceTime(this.jAx.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jAx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiA != null) {
                this.aiA.onClick(view);
            }
            TiebaStatic.log(this.jAx.from);
        }
    }

    private void dxP() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        }
        if (this.jAt != null) {
            this.jAt.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.jAt != null) {
            if (this.play_type == 0) {
                ap.setImageResource(this.jAt, R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                ap.setImageResource(this.jAt, R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void cIE() {
        if (this.jcS != null) {
            this.jcS.stop();
        }
        dxP();
        this.jcS = (AnimationDrawable) this.jAt.getDrawable();
        this.jcS.start();
    }

    public void cIF() {
        Drawable drawable = this.jAt.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.jcS = (AnimationDrawable) drawable;
        }
        if (this.jcS != null) {
            this.jcS.stop();
        }
        this.jcS = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hSO = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.hSO;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.byy();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.byx() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.at(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.byx();
            setVoiceModel(voiceModel);
            dxO();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jAx != voiceModel) {
                BM(1);
            } else {
                BM(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bb(int i) {
        if (!dxQ()) {
            BM(1);
            return;
        }
        if (this.jcS == null) {
            BM(this.jAx.voice_status.intValue());
        }
        BL(i);
        if (this.jAx != null) {
            this.jAx.elapse = i;
        }
    }

    private boolean dxQ() {
        if (this.jAx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jAx);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jAx;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jAx);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jAx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sb() {
    }

    public void reset() {
        this.jAx = null;
        setTag(null);
        BM(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int equipmentWidth = l.getEquipmentWidth(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (equipmentWidth * 0.3f);
                return (((i - 10) * (((int) (equipmentWidth * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (equipmentWidth * 0.45f);
        }
        int i3 = (int) (equipmentWidth * 0.18f);
        int i4 = (int) (equipmentWidth * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiA = onClickListener;
    }
}
