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
    private static final int nbG = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener aju;
    private VoiceManager iIc;
    private ImageView kre;
    private VoiceData.VoiceModel kri;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView nbB;
    private RelativeLayout nbC;
    private AudioAnimationView nbD;
    private int nbE;
    private float nbF;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.nbE = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.nbE = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.nbB != null) {
            this.nbB.setTextSize(0, l.getDimens(getContext(), i));
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
        this.nbC = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.nbC.setOnClickListener(this);
        this.kre = (ImageView) findViewById(R.id.playingImg);
        this.nbB = (TextView) findViewById(R.id.playTime);
        this.nbD = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        changeSkin();
    }

    private void dLh() {
        this.nbD.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kri = voiceModel;
        if (this.kri != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                DW(this.kri.elapse);
                return;
            }
            DX(this.kri.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.nbE = (int) this.nbB.getPaint().measureText(formatVoiceTime);
            this.nbF = this.nbE + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.nbD.setCertainColumnCount(getAudioVoiceColumnCount());
            this.nbD.sy();
            this.nbC.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.nbF, getPaddingBottom());
            this.nbB.setText(formatVoiceTime);
        }
    }

    public void DW(int i) {
        String formatVoiceTime;
        if (this.kri != null && this.nbB != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kri.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kri.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kri.duration);
            }
            String charSequence2String = k.charSequence2String(this.nbB.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.nbB.setText(formatVoiceTime);
            }
        }
    }

    public void DX(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            xE(true);
            this.nbD.setVisibility(0);
            this.nbD.start();
            return;
        }
        this.nbD.setCertainColumnCount(getAudioVoiceColumnCount());
        this.nbD.sy();
        this.nbD.setVisibility(4);
        xE(false);
        if (i == 1) {
            if (this.kri != null) {
                this.nbB.setText(VoiceManager.formatVoiceTime(this.kri.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kri != null) {
                this.nbB.setText(VoiceManager.formatVoiceTime(this.kri.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kri != null && view == this.nbC) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aju != null) {
                this.aju.onClick(this);
            }
            TiebaStatic.log(this.kri.from);
        }
    }

    public void ak(View.OnClickListener onClickListener) {
        if (this.nbC != null) {
            this.nbC.setOnClickListener(onClickListener);
        }
    }

    public void cJS() {
        VoiceManager voiceManager;
        if (this.kri != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void xE(boolean z) {
        if (this.kre != null) {
            if (z) {
                this.kre.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_pause16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            } else {
                this.kre.setImageDrawable(WebPManager.a(R.drawable.icon_pure_common_voice_play16, ap.getColor(R.color.CAM_X0302), WebPManager.ResourceStateType.NORMAL));
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.iIc = voiceManager;
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
        return this.iIc;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bGd();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bGc() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ax(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bGc();
            setVoiceModel(voiceModel);
            dLh();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kri != voiceModel) {
                DX(1);
            } else {
                DX(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (!dLj()) {
            DX(1);
            return;
        }
        DW(i);
        if (this.kri != null) {
            this.kri.elapse = i;
        }
    }

    private boolean dLj() {
        if (this.kri == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kri);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kri;
    }

    public void changeSkin() {
        dLh();
        ap.setViewTextColor(this.nbB, R.color.CAM_X0302);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.nbC).pb(R.string.J_X05).pd(R.dimen.L_X03).pc(R.color.CAM_X0302).setBackGroundColor(R.color.CAM_X0201);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kri);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kri);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void reset() {
        this.kri = null;
        setTag(null);
        DX(1);
    }

    public void bYE() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nbD.getLayoutParams();
        layoutParams.width = -2;
        this.nbD.setLayoutParams(layoutParams);
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
            d = nbG * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = nbG * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = nbG * 0.6d * 2.0d;
        } else {
            d = nbG * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.nbF) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aju = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.nbC;
    }

    public TextView getPlayTime() {
        return this.nbB;
    }

    public ImageView getImgStatus() {
        return this.kre;
    }
}
