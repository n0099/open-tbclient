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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int nqO = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener ake;
    private VoiceManager jaA;
    private ImageView kFg;
    private VoiceData.VoiceModel kFk;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView nqJ;
    private RelativeLayout nqK;
    private AudioAnimationView nqL;
    private int nqM;
    private float nqN;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.nqM = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.nqM = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.nqJ != null) {
            this.nqJ.setTextSize(0, l.getDimens(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        O(context);
        setOnClickListener(this);
    }

    public void O(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.nqK = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.nqK.setOnClickListener(this);
        this.kFg = (ImageView) findViewById(R.id.playingImg);
        this.nqJ = (TextView) findViewById(R.id.playTime);
        this.nqL = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        btU();
    }

    private void dMF() {
        this.nqL.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kFk = voiceModel;
        if (this.kFk != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                CX(this.kFk.elapse);
                return;
            }
            CY(this.kFk.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.nqM = (int) this.nqJ.getPaint().measureText(formatVoiceTime);
            this.nqN = this.nqM + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.nqL.setCertainColumnCount(getAudioVoiceColumnCount());
            this.nqL.sc();
            this.nqK.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.nqN, getPaddingBottom());
            this.nqJ.setText(formatVoiceTime);
        }
    }

    public void CX(int i) {
        String formatVoiceTime;
        if (this.kFk != null && this.nqJ != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kFk.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kFk.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kFk.duration);
            }
            String charSequence2String = k.charSequence2String(this.nqJ.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.nqJ.setText(formatVoiceTime);
            }
        }
    }

    public void CY(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            yk(true);
            this.nqL.setVisibility(0);
            this.nqL.start();
            return;
        }
        this.nqL.setCertainColumnCount(getAudioVoiceColumnCount());
        this.nqL.sc();
        this.nqL.setVisibility(4);
        yk(false);
        if (i == 1) {
            if (this.kFk != null) {
                this.nqJ.setText(VoiceManager.formatVoiceTime(this.kFk.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kFk != null) {
                this.nqJ.setText(VoiceManager.formatVoiceTime(this.kFk.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kFk != null && view == this.nqK) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ake != null) {
                this.ake.onClick(this);
            }
            TiebaStatic.log(this.kFk.from);
        }
    }

    public void am(View.OnClickListener onClickListener) {
        if (this.nqK != null) {
            this.nqK.setOnClickListener(onClickListener);
        }
    }

    public void cOx() {
        VoiceManager voiceManager;
        if (this.kFk != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void yk(boolean z) {
        if (this.kFg != null) {
            if (z) {
                this.kFg.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_pause16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.kFg.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_play16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.jaA = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((j.K(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.K(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.jaA;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bIe();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bId() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.az(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bId();
            setVoiceModel(voiceModel);
            dMF();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kFk != voiceModel) {
                CY(1);
            } else {
                CY(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (!dMH()) {
            CY(1);
            return;
        }
        CX(i);
        if (this.kFk != null) {
            this.kFk.elapse = i;
        }
    }

    private boolean dMH() {
        if (this.kFk == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kFk);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kFk;
    }

    public void btU() {
        dMF();
        ao.setViewTextColor(this.nqJ, R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.nqK).od(R.string.J_X05).og(R.dimen.L_X03).of(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kFk);
        }
        if ((j.K(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.K(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kFk);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rJ() {
    }

    public void reset() {
        this.kFk = null;
        setTag(null);
        CY(1);
    }

    public void cbz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nqL.getLayoutParams();
        layoutParams.width = -2;
        this.nqL.setLayoutParams(layoutParams);
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
            d = nqO * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = nqO * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = nqO * 0.6d * 2.0d;
        } else {
            d = nqO * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.nqN) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ake = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.nqK;
    }

    public TextView getPlayTime() {
        return this.nqJ;
    }

    public ImageView getImgStatus() {
        return this.kFg;
    }
}
