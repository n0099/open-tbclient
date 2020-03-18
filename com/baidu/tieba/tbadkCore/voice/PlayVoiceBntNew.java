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
    private static final int klQ = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener Ni;
    private VoiceManager gpi;
    private ImageView hMG;
    private VoiceData.VoiceModel hMK;
    private TextView klL;
    private RelativeLayout klM;
    private AudioAnimationView klN;
    private int klO;
    private float klP;
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
        this.klO = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.klO = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.klL != null) {
            this.klL.setTextSize(0, l.getDimens(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        af(context);
        setOnClickListener(this);
    }

    public void af(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.klM = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.klM.setOnClickListener(this);
        this.hMG = (ImageView) findViewById(R.id.playingImg);
        this.klL = (TextView) findViewById(R.id.playTime);
        this.klN = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cMA();
    }

    private void cMA() {
        this.klN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.hMK = voiceModel;
        if (this.hMK != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                xd(this.hMK.elapse);
                return;
            }
            xe(this.hMK.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.klO = (int) this.klL.getPaint().measureText(formatVoiceTime);
            this.klP = this.klO + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.klN.setCertainColumnCount(getAudioVoiceColumnCount());
            this.klN.lS();
            this.klM.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.klP, getPaddingBottom());
            this.klL.setText(formatVoiceTime);
        }
    }

    public void xd(int i) {
        String formatVoiceTime;
        if (this.hMK != null && this.klL != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.hMK.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hMK.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hMK.duration);
            }
            String charSequence2String = k.charSequence2String(this.klL.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.klL.setText(formatVoiceTime);
            }
        }
    }

    public void xe(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            sX(true);
            this.klN.setVisibility(0);
            this.klN.start();
            return;
        }
        this.klN.setCertainColumnCount(getAudioVoiceColumnCount());
        this.klN.lS();
        this.klN.setVisibility(4);
        sX(false);
        if (i == 1) {
            if (this.hMK != null) {
                this.klL.setText(VoiceManager.formatVoiceTime(this.hMK.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.hMK != null) {
                this.klL.setText(VoiceManager.formatVoiceTime(this.hMK.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hMK != null && view == this.klM) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.Ni != null) {
                this.Ni.onClick(this);
            }
            TiebaStatic.log(this.hMK.from);
        }
    }

    public void ae(View.OnClickListener onClickListener) {
        if (this.klM != null) {
            this.klM.setOnClickListener(onClickListener);
        }
    }

    public void bOE() {
        VoiceManager voiceManager;
        if (this.hMK != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void sX(boolean z) {
        if (this.hMG != null) {
            if (z) {
                am.setImageResource(this.hMG, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.hMG, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.gpi = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.gpi;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.aUV();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.aUU() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.al(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.aUU();
            setVoiceModel(voiceModel);
            cMA();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.hMK != voiceModel) {
                xe(1);
            } else {
                xe(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aG(int i) {
        if (!cMB()) {
            xe(1);
            return;
        }
        xd(i);
        if (this.hMK != null) {
            this.hMK.elapse = i;
        }
    }

    private boolean cMB() {
        if (this.hMK == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.hMK);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.hMK;
    }

    public void can() {
        cMA();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.hMK);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.hMK);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lX() {
    }

    public void reset() {
        this.hMK = null;
        setTag(null);
        xe(1);
    }

    public void cMC() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.klN.getLayoutParams();
        layoutParams.width = -2;
        this.klN.setLayoutParams(layoutParams);
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
            d = klQ * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = klQ * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = klQ * 0.6d * 2.0d;
        } else {
            d = klQ * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.klP) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Ni = onClickListener;
    }
}
