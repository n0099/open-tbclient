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
    private static final int nvu = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener akV;
    private VoiceManager jfh;
    private ImageView kJL;
    private VoiceData.VoiceModel kJP;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView nvp;
    private RelativeLayout nvq;
    private AudioAnimationView nvr;
    private int nvs;
    private float nvt;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.nvs = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.nvs = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.nvp != null) {
            this.nvp.setTextSize(0, l.getDimens(getContext(), i));
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
        this.nvq = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.nvq.setOnClickListener(this);
        this.kJL = (ImageView) findViewById(R.id.playingImg);
        this.nvp = (TextView) findViewById(R.id.playTime);
        this.nvr = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxO();
    }

    private void dQx() {
        this.nvr.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kJP = voiceModel;
        if (this.kJP != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ED(this.kJP.elapse);
                return;
            }
            EE(this.kJP.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.nvs = (int) this.nvp.getPaint().measureText(formatVoiceTime);
            this.nvt = this.nvs + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.nvr.setCertainColumnCount(getAudioVoiceColumnCount());
            this.nvr.sc();
            this.nvq.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.nvt, getPaddingBottom());
            this.nvp.setText(formatVoiceTime);
        }
    }

    public void ED(int i) {
        String formatVoiceTime;
        if (this.kJP != null && this.nvp != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kJP.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kJP.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kJP.duration);
            }
            String charSequence2String = k.charSequence2String(this.nvp.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.nvp.setText(formatVoiceTime);
            }
        }
    }

    public void EE(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            yo(true);
            this.nvr.setVisibility(0);
            this.nvr.start();
            return;
        }
        this.nvr.setCertainColumnCount(getAudioVoiceColumnCount());
        this.nvr.sc();
        this.nvr.setVisibility(4);
        yo(false);
        if (i == 1) {
            if (this.kJP != null) {
                this.nvp.setText(VoiceManager.formatVoiceTime(this.kJP.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kJP != null) {
                this.nvp.setText(VoiceManager.formatVoiceTime(this.kJP.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kJP != null && view == this.nvq) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.akV != null) {
                this.akV.onClick(this);
            }
            TiebaStatic.log(this.kJP.from);
        }
    }

    public void am(View.OnClickListener onClickListener) {
        if (this.nvq != null) {
            this.nvq.setOnClickListener(onClickListener);
        }
    }

    public void cSp() {
        VoiceManager voiceManager;
        if (this.kJP != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void yo(boolean z) {
        if (this.kJL != null) {
            if (z) {
                this.kJL.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_pause16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.kJL.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_play16, ao.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.jfh = voiceManager;
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
        return this.jfh;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bLW();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bLV() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.az(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bLV();
            setVoiceModel(voiceModel);
            dQx();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kJP != voiceModel) {
                EE(1);
            } else {
                EE(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bj(int i) {
        if (!dQz()) {
            EE(1);
            return;
        }
        ED(i);
        if (this.kJP != null) {
            this.kJP.elapse = i;
        }
    }

    private boolean dQz() {
        if (this.kJP == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kJP);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kJP;
    }

    public void bxO() {
        dQx();
        ao.setViewTextColor(this.nvp, R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.bv(this.nvq).pK(R.string.J_X05).pN(R.dimen.L_X03).pM(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kJP);
        }
        if ((j.K(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.K(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kJP);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rJ() {
    }

    public void reset() {
        this.kJP = null;
        setTag(null);
        EE(1);
    }

    public void cfr() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nvr.getLayoutParams();
        layoutParams.width = -2;
        this.nvr.setLayoutParams(layoutParams);
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
            d = nvu * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = nvu * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = nvu * 0.6d * 2.0d;
        } else {
            d = nvu * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.nvt) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.akV = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.nvq;
    }

    public TextView getPlayTime() {
        return this.nvp;
    }

    public ImageView getImgStatus() {
        return this.kJL;
    }
}
