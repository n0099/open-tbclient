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
import com.baidu.adp.base.f;
import com.baidu.adp.base.j;
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
    private static final int nDd = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener alm;
    private ImageView hiq;
    private VoiceManager jie;
    private VoiceData.VoiceModel kPE;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView nCY;
    private RelativeLayout nCZ;
    private AudioAnimationView nDa;
    private int nDb;
    private float nDc;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.nDb = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.nDb = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.nCY != null) {
            this.nCY.setTextSize(0, l.getDimens(getContext(), i));
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
        this.nCZ = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.nCZ.setOnClickListener(this);
        this.hiq = (ImageView) findViewById(R.id.playingImg);
        this.nCY = (TextView) findViewById(R.id.playTime);
        this.nDa = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bur();
    }

    private void dPh() {
        this.nDa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kPE = voiceModel;
        if (this.kPE != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                Dr(this.kPE.elapse);
                return;
            }
            Ds(this.kPE.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.nDb = (int) this.nCY.getPaint().measureText(formatVoiceTime);
            this.nDc = this.nDb + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.nDa.setCertainColumnCount(getAudioVoiceColumnCount());
            this.nDa.rZ();
            this.nCZ.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.nDc, getPaddingBottom());
            this.nCY.setText(formatVoiceTime);
        }
    }

    public void Dr(int i) {
        String formatVoiceTime;
        if (this.kPE != null && this.nCY != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kPE.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kPE.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kPE.duration);
            }
            String charSequence2String = k.charSequence2String(this.nCY.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.nCY.setText(formatVoiceTime);
            }
        }
    }

    public void Ds(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            yC(true);
            this.nDa.setVisibility(0);
            this.nDa.start();
            return;
        }
        this.nDa.setCertainColumnCount(getAudioVoiceColumnCount());
        this.nDa.rZ();
        this.nDa.setVisibility(4);
        yC(false);
        if (i == 1) {
            if (this.kPE != null) {
                this.nCY.setText(VoiceManager.formatVoiceTime(this.kPE.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kPE != null) {
                this.nCY.setText(VoiceManager.formatVoiceTime(this.kPE.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kPE != null && view == this.nCZ) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.alm != null) {
                this.alm.onClick(this);
            }
            TiebaStatic.log(this.kPE.from);
        }
    }

    public void an(View.OnClickListener onClickListener) {
        if (this.nCZ != null) {
            this.nCZ.setOnClickListener(onClickListener);
        }
    }

    public void cQI() {
        VoiceManager voiceManager;
        if (this.kPE != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void yC(boolean z) {
        if (this.hiq != null) {
            if (z) {
                this.hiq.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_pause16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.hiq.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_play16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.jie = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((j.J(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.J(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.jie;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bIB();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bIA() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aB(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bIA();
            setVoiceModel(voiceModel);
            dPh();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kPE != voiceModel) {
                Ds(1);
            } else {
                Ds(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (!dPj()) {
            Ds(1);
            return;
        }
        Dr(i);
        if (this.kPE != null) {
            this.kPE.elapse = i;
        }
    }

    private boolean dPj() {
        if (this.kPE == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kPE);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kPE;
    }

    public void bur() {
        dPh();
        ap.setViewTextColor(this.nCY, R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.br(this.nCZ).oh(R.string.J_X05).ol(R.dimen.L_X03).ok(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kPE);
        }
        if ((j.J(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.J(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kPE);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rH() {
    }

    public void reset() {
        this.kPE = null;
        setTag(null);
        Ds(1);
    }

    public void ccH() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nDa.getLayoutParams();
        layoutParams.width = -2;
        this.nDa.setLayoutParams(layoutParams);
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
            d = nDd * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = nDd * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = nDd * 0.6d * 2.0d;
        } else {
            d = nDd * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.nDc) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.alm = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.nCZ;
    }

    public TextView getPlayTime() {
        return this.nCY;
    }

    public ImageView getImgStatus() {
        return this.hiq;
    }
}
