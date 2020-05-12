package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int kWa = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener afV;
    private VoiceManager gYv;
    private ImageView iwC;
    private VoiceData.VoiceModel iwG;
    private TextView kVV;
    private RelativeLayout kVW;
    private AudioAnimationView kVX;
    private int kVY;
    private float kVZ;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.kVY = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.kVY = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.kVV != null) {
            this.kVV.setTextSize(0, l.getDimens(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        J(context);
        setOnClickListener(this);
    }

    public void J(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.kVW = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.kVW.setOnClickListener(this);
        this.iwC = (ImageView) findViewById(R.id.playingImg);
        this.kVV = (TextView) findViewById(R.id.playTime);
        this.kVX = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cXu();
    }

    private void cXu() {
        this.kVX.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.iwG = voiceModel;
        if (this.iwG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                xB(this.iwG.elapse);
                return;
            }
            xC(this.iwG.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.kVY = (int) this.kVV.getPaint().measureText(formatVoiceTime);
            this.kVZ = this.kVY + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.kVX.setCertainColumnCount(getAudioVoiceColumnCount());
            this.kVX.qu();
            this.kVW.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.kVZ, getPaddingBottom());
            this.kVV.setText(formatVoiceTime);
        }
    }

    public void xB(int i) {
        String formatVoiceTime;
        if (this.iwG != null && this.kVV != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.iwG.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.iwG.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.iwG.duration);
            }
            String charSequence2String = k.charSequence2String(this.kVV.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.kVV.setText(formatVoiceTime);
            }
        }
    }

    public void xC(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            tZ(true);
            this.kVX.setVisibility(0);
            this.kVX.start();
            return;
        }
        this.kVX.setCertainColumnCount(getAudioVoiceColumnCount());
        this.kVX.qu();
        this.kVX.setVisibility(4);
        tZ(false);
        if (i == 1) {
            if (this.iwG != null) {
                this.kVV.setText(VoiceManager.formatVoiceTime(this.iwG.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.iwG != null) {
                this.kVV.setText(VoiceManager.formatVoiceTime(this.iwG.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iwG != null && view == this.kVW) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.afV != null) {
                this.afV.onClick(this);
            }
            TiebaStatic.log(this.iwG.from);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.kVW != null) {
            this.kVW.setOnClickListener(onClickListener);
        }
    }

    public void bZe() {
        VoiceManager voiceManager;
        if (this.iwG != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void tZ(boolean z) {
        if (this.iwC != null) {
            if (z) {
                am.setImageResource(this.iwC, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.iwC, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.gYv = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.gYv;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bdd();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bdc() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.am(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bdc();
            setVoiceModel(voiceModel);
            cXu();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.iwG != voiceModel) {
                xC(1);
            } else {
                xC(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!cXw()) {
            xC(1);
            return;
        }
        xB(i);
        if (this.iwG != null) {
            this.iwG.elapse = i;
        }
    }

    private boolean cXw() {
        if (this.iwG == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.iwG);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.iwG;
    }

    public void ckN() {
        cXu();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.iwG);
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.iwG);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qz() {
    }

    public void reset() {
        this.iwG = null;
        setTag(null);
        xC(1);
    }

    public void cXx() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kVX.getLayoutParams();
        layoutParams.width = -2;
        this.kVX.setLayoutParams(layoutParams);
    }

    private int getAudioVoiceColumnCount() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return 0;
        }
        return f(voiceModel) / 10;
    }

    private int f(VoiceData.VoiceModel voiceModel) {
        double d;
        if (voiceModel.duration < 10) {
            d = kWa * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = kWa * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = kWa * 0.6d * 2.0d;
        } else {
            d = kWa * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.kVZ) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.afV = onClickListener;
    }
}
