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
    private static final int loI = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener ags;
    private VoiceManager hnh;
    private ImageView iLi;
    private VoiceData.VoiceModel iLm;
    private TextView loD;
    private RelativeLayout loE;
    private AudioAnimationView loF;
    private int loG;
    private float loH;
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
        this.loG = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.loG = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.loD != null) {
            this.loD.setTextSize(0, l.getDimens(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        K(context);
        setOnClickListener(this);
    }

    public void K(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.loE = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.loE.setOnClickListener(this);
        this.iLi = (ImageView) findViewById(R.id.playingImg);
        this.loD = (TextView) findViewById(R.id.playTime);
        this.loF = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        deI();
    }

    private void deI() {
        this.loF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.iLm = voiceModel;
        if (this.iLm != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                yh(this.iLm.elapse);
                return;
            }
            yi(this.iLm.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.loG = (int) this.loD.getPaint().measureText(formatVoiceTime);
            this.loH = this.loG + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.loF.setCertainColumnCount(getAudioVoiceColumnCount());
            this.loF.qA();
            this.loE.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.loH, getPaddingBottom());
            this.loD.setText(formatVoiceTime);
        }
    }

    public void yh(int i) {
        String formatVoiceTime;
        if (this.iLm != null && this.loD != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.iLm.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.iLm.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.iLm.duration);
            }
            String charSequence2String = k.charSequence2String(this.loD.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.loD.setText(formatVoiceTime);
            }
        }
    }

    public void yi(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            ux(true);
            this.loF.setVisibility(0);
            this.loF.start();
            return;
        }
        this.loF.setCertainColumnCount(getAudioVoiceColumnCount());
        this.loF.qA();
        this.loF.setVisibility(4);
        ux(false);
        if (i == 1) {
            if (this.iLm != null) {
                this.loD.setText(VoiceManager.formatVoiceTime(this.iLm.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.iLm != null) {
                this.loD.setText(VoiceManager.formatVoiceTime(this.iLm.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iLm != null && view == this.loE) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ags != null) {
                this.ags.onClick(this);
            }
            TiebaStatic.log(this.iLm.from);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.loE != null) {
            this.loE.setOnClickListener(onClickListener);
        }
    }

    public void cfz() {
        VoiceManager voiceManager;
        if (this.iLm != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void ux(boolean z) {
        if (this.iLi != null) {
            if (z) {
                am.setImageResource(this.iLi, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.iLi, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hnh = voiceManager;
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
        return this.hnh;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bjo();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bjn() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aq(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bjn();
            setVoiceModel(voiceModel);
            deI();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.iLm != voiceModel) {
                yi(1);
            } else {
                yi(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aT(int i) {
        if (!deK()) {
            yi(1);
            return;
        }
        yh(i);
        if (this.iLm != null) {
            this.iLm.elapse = i;
        }
    }

    private boolean deK() {
        if (this.iLm == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.iLm);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.iLm;
    }

    public void crm() {
        deI();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.iLm);
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.iLm);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qF() {
    }

    public void reset() {
        this.iLm = null;
        setTag(null);
        yi(1);
    }

    public void deL() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.loF.getLayoutParams();
        layoutParams.width = -2;
        this.loF.setLayoutParams(layoutParams);
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
            d = loI * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = loI * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = loI * 0.6d * 2.0d;
        } else {
            d = loI * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.loH) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }
}
