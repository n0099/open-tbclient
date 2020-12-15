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
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int npL = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener akt;
    private VoiceManager iSW;
    private ImageView kEC;
    private VoiceData.VoiceModel kEG;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView npG;
    private RelativeLayout npH;
    private AudioAnimationView npI;
    private int npJ;
    private float npK;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.npJ = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.npJ = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.npG != null) {
            this.npG.setTextSize(0, l.getDimens(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        N(context);
        setOnClickListener(this);
    }

    public void N(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.npH = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.npH.setOnClickListener(this);
        this.kEC = (ImageView) findViewById(R.id.playingImg);
        this.npG = (TextView) findViewById(R.id.playTime);
        this.npI = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bvs();
    }

    private void dQA() {
        this.npI.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kEG = voiceModel;
        if (this.kEG != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                EL(this.kEG.elapse);
                return;
            }
            EM(this.kEG.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.npJ = (int) this.npG.getPaint().measureText(formatVoiceTime);
            this.npK = this.npJ + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.npI.setCertainColumnCount(getAudioVoiceColumnCount());
            this.npI.sB();
            this.npH.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.npK, getPaddingBottom());
            this.npG.setText(formatVoiceTime);
        }
    }

    public void EL(int i) {
        String formatVoiceTime;
        if (this.kEG != null && this.npG != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kEG.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kEG.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kEG.duration);
            }
            String charSequence2String = k.charSequence2String(this.npG.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.npG.setText(formatVoiceTime);
            }
        }
    }

    public void EM(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            yj(true);
            this.npI.setVisibility(0);
            this.npI.start();
            return;
        }
        this.npI.setCertainColumnCount(getAudioVoiceColumnCount());
        this.npI.sB();
        this.npI.setVisibility(4);
        yj(false);
        if (i == 1) {
            if (this.kEG != null) {
                this.npG.setText(VoiceManager.formatVoiceTime(this.kEG.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kEG != null) {
                this.npG.setText(VoiceManager.formatVoiceTime(this.kEG.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kEG != null && view == this.npH) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.akt != null) {
                this.akt.onClick(this);
            }
            TiebaStatic.log(this.kEG.from);
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.npH != null) {
            this.npH.setOnClickListener(onClickListener);
        }
    }

    public void cPi() {
        VoiceManager voiceManager;
        if (this.kEG != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void yj(boolean z) {
        if (this.kEC != null) {
            if (z) {
                this.kEC.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_pause16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.kEC.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_play16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.iSW = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.J(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.J(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.iSW;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bJD();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bJC() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ax(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bJC();
            setVoiceModel(voiceModel);
            dQA();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kEG != voiceModel) {
                EM(1);
            } else {
                EM(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (!dQC()) {
            EM(1);
            return;
        }
        EL(i);
        if (this.kEG != null) {
            this.kEG.elapse = i;
        }
    }

    private boolean dQC() {
        if (this.kEG == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kEG);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kEG;
    }

    public void bvs() {
        dQA();
        ap.setViewTextColor(this.npG, R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.npH).pA(R.string.J_X05).pD(R.dimen.L_X03).pC(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kEG);
        }
        if ((i.J(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.J(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kEG);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void si() {
    }

    public void reset() {
        this.kEG = null;
        setTag(null);
        EM(1);
    }

    public void ccA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.npI.getLayoutParams();
        layoutParams.width = -2;
        this.npI.setLayoutParams(layoutParams);
    }

    private int getAudioVoiceColumnCount() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return 0;
        }
        return g(voiceModel) / 10;
    }

    private int g(VoiceData.VoiceModel voiceModel) {
        double d;
        if (voiceModel.duration < 10) {
            d = npL * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = npL * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = npL * 0.6d * 2.0d;
        } else {
            d = npL * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.npK) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akt = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.npH;
    }

    public TextView getPlayTime() {
        return this.npG;
    }

    public ImageView getImgStatus() {
        return this.kEC;
    }
}
