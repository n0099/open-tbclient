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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int msr = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener aiW;
    private VoiceManager hZU;
    private ImageView jJb;
    private VoiceData.VoiceModel jJf;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView msm;
    private RelativeLayout msn;
    private AudioAnimationView mso;
    private int msp;
    private float msq;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.msp = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.msp = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.msm != null) {
            this.msm.setTextSize(0, l.getDimens(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        M(context);
        setOnClickListener(this);
    }

    public void M(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.msn = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.msn.setOnClickListener(this);
        this.jJb = (ImageView) findViewById(R.id.playingImg);
        this.msm = (TextView) findViewById(R.id.playTime);
        this.mso = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dBM();
    }

    private void dBM() {
        this.mso.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jJf = voiceModel;
        if (this.jJf != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                Cm(this.jJf.elapse);
                return;
            }
            Cn(this.jJf.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.msp = (int) this.msm.getPaint().measureText(formatVoiceTime);
            this.msq = this.msp + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.mso.setCertainColumnCount(getAudioVoiceColumnCount());
            this.mso.sy();
            this.msn.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.msq, getPaddingBottom());
            this.msm.setText(formatVoiceTime);
        }
    }

    public void Cm(int i) {
        String formatVoiceTime;
        if (this.jJf != null && this.msm != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jJf.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jJf.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jJf.duration);
            }
            String charSequence2String = k.charSequence2String(this.msm.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.msm.setText(formatVoiceTime);
            }
        }
    }

    public void Cn(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            wq(true);
            this.mso.setVisibility(0);
            this.mso.start();
            return;
        }
        this.mso.setCertainColumnCount(getAudioVoiceColumnCount());
        this.mso.sy();
        this.mso.setVisibility(4);
        wq(false);
        if (i == 1) {
            if (this.jJf != null) {
                this.msm.setText(VoiceManager.formatVoiceTime(this.jJf.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jJf != null) {
                this.msm.setText(VoiceManager.formatVoiceTime(this.jJf.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jJf != null && view == this.msn) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiW != null) {
                this.aiW.onClick(this);
            }
            TiebaStatic.log(this.jJf.from);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        if (this.msn != null) {
            this.msn.setOnClickListener(onClickListener);
        }
    }

    public void cAY() {
        VoiceManager voiceManager;
        if (this.jJf != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void wq(boolean z) {
        if (this.jJb != null) {
            if (z) {
                ap.setImageResource(this.jJb, R.drawable.icon_common_voice_pause);
            } else {
                ap.setImageResource(this.jJb, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hZU = voiceManager;
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
        return this.hZU;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bzI();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bzH() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.au(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bzH();
            setVoiceModel(voiceModel);
            dBM();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jJf != voiceModel) {
                Cn(1);
            } else {
                Cn(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (!dBO()) {
            Cn(1);
            return;
        }
        Cm(i);
        if (this.jJf != null) {
            this.jJf.elapse = i;
        }
    }

    private boolean dBO() {
        if (this.jJf == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jJf);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jJf;
    }

    public void changeSkin() {
        dBM();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jJf);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jJf);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void reset() {
        this.jJf = null;
        setTag(null);
        Cn(1);
    }

    public void bQr() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mso.getLayoutParams();
        layoutParams.width = -2;
        this.mso.setLayoutParams(layoutParams);
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
            d = msr * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = msr * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = msr * 0.6d * 2.0d;
        } else {
            d = msr * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.msq) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiW = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.msn;
    }

    public TextView getPlayTime() {
        return this.msm;
    }

    public ImageView getImgStatus() {
        return this.jJb;
    }
}
