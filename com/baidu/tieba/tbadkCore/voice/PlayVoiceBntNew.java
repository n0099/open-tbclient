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
    private static final int nAy = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener ajT;
    private ImageView hgs;
    private VoiceManager jgg;
    private VoiceData.VoiceModel kNo;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView nAt;
    private RelativeLayout nAu;
    private AudioAnimationView nAv;
    private int nAw;
    private float nAx;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.nAw = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.nAw = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.nAt != null) {
            this.nAt.setTextSize(0, l.getDimens(getContext(), i));
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
        this.nAu = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.nAu.setOnClickListener(this);
        this.hgs = (ImageView) findViewById(R.id.playingImg);
        this.nAt = (TextView) findViewById(R.id.playTime);
        this.nAv = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        buo();
    }

    private void dOQ() {
        this.nAv.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kNo = voiceModel;
        if (this.kNo != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                Do(this.kNo.elapse);
                return;
            }
            Dp(this.kNo.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.nAw = (int) this.nAt.getPaint().measureText(formatVoiceTime);
            this.nAx = this.nAw + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.nAv.setCertainColumnCount(getAudioVoiceColumnCount());
            this.nAv.rZ();
            this.nAu.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.nAx, getPaddingBottom());
            this.nAt.setText(formatVoiceTime);
        }
    }

    public void Do(int i) {
        String formatVoiceTime;
        if (this.kNo != null && this.nAt != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kNo.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kNo.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kNo.duration);
            }
            String charSequence2String = k.charSequence2String(this.nAt.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.nAt.setText(formatVoiceTime);
            }
        }
    }

    public void Dp(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            yD(true);
            this.nAv.setVisibility(0);
            this.nAv.start();
            return;
        }
        this.nAv.setCertainColumnCount(getAudioVoiceColumnCount());
        this.nAv.rZ();
        this.nAv.setVisibility(4);
        yD(false);
        if (i == 1) {
            if (this.kNo != null) {
                this.nAt.setText(VoiceManager.formatVoiceTime(this.kNo.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kNo != null) {
                this.nAt.setText(VoiceManager.formatVoiceTime(this.kNo.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kNo != null && view == this.nAu) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajT != null) {
                this.ajT.onClick(this);
            }
            TiebaStatic.log(this.kNo.from);
        }
    }

    public void am(View.OnClickListener onClickListener) {
        if (this.nAu != null) {
            this.nAu.setOnClickListener(onClickListener);
        }
    }

    public void cQu() {
        VoiceManager voiceManager;
        if (this.kNo != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void yD(boolean z) {
        if (this.hgs != null) {
            if (z) {
                this.hgs.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_pause16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.hgs.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_play16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.jgg = voiceManager;
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
        return this.jgg;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bIx();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bIw() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.az(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bIw();
            setVoiceModel(voiceModel);
            dOQ();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kNo != voiceModel) {
                Dp(1);
            } else {
                Dp(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (!dOS()) {
            Dp(1);
            return;
        }
        Do(i);
        if (this.kNo != null) {
            this.kNo.elapse = i;
        }
    }

    private boolean dOS() {
        if (this.kNo == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kNo);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kNo;
    }

    public void buo() {
        dOQ();
        ap.setViewTextColor(this.nAt, R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.br(this.nAu).og(R.string.J_X05).ok(R.dimen.L_X03).oj(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kNo);
        }
        if ((j.K(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.K(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kNo);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rH() {
    }

    public void reset() {
        this.kNo = null;
        setTag(null);
        Dp(1);
    }

    public void ccu() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nAv.getLayoutParams();
        layoutParams.width = -2;
        this.nAv.setLayoutParams(layoutParams);
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
            d = nAy * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = nAy * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = nAy * 0.6d * 2.0d;
        } else {
            d = nAy * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.nAx) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajT = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.nAu;
    }

    public TextView getPlayTime() {
        return this.nAt;
    }

    public ImageView getImgStatus() {
        return this.hgs;
    }
}
