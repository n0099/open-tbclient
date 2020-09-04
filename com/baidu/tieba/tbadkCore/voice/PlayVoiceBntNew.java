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
    private static final int miS = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener aiC;
    private VoiceManager hSU;
    private VoiceData.VoiceModel jAD;
    private ImageView jAz;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView miN;
    private RelativeLayout miO;
    private AudioAnimationView miP;
    private int miQ;
    private float miR;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.miQ = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.miQ = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.miN != null) {
            this.miN.setTextSize(0, l.getDimens(getContext(), i));
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
        this.miO = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.miO.setOnClickListener(this);
        this.jAz = (ImageView) findViewById(R.id.playingImg);
        this.miN = (TextView) findViewById(R.id.playTime);
        this.miP = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dxT();
    }

    private void dxT() {
        this.miP.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jAD = voiceModel;
        if (this.jAD != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                BL(this.jAD.elapse);
                return;
            }
            BM(this.jAD.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.miQ = (int) this.miN.getPaint().measureText(formatVoiceTime);
            this.miR = this.miQ + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.miP.setCertainColumnCount(getAudioVoiceColumnCount());
            this.miP.st();
            this.miO.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.miR, getPaddingBottom());
            this.miN.setText(formatVoiceTime);
        }
    }

    public void BL(int i) {
        String formatVoiceTime;
        if (this.jAD != null && this.miN != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jAD.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jAD.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jAD.duration);
            }
            String charSequence2String = k.charSequence2String(this.miN.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.miN.setText(formatVoiceTime);
            }
        }
    }

    public void BM(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            wh(true);
            this.miP.setVisibility(0);
            this.miP.start();
            return;
        }
        this.miP.setCertainColumnCount(getAudioVoiceColumnCount());
        this.miP.st();
        this.miP.setVisibility(4);
        wh(false);
        if (i == 1) {
            if (this.jAD != null) {
                this.miN.setText(VoiceManager.formatVoiceTime(this.jAD.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jAD != null) {
                this.miN.setText(VoiceManager.formatVoiceTime(this.jAD.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jAD != null && view == this.miO) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiC != null) {
                this.aiC.onClick(this);
            }
            TiebaStatic.log(this.jAD.from);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        if (this.miO != null) {
            this.miO.setOnClickListener(onClickListener);
        }
    }

    public void cxq() {
        VoiceManager voiceManager;
        if (this.jAD != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void wh(boolean z) {
        if (this.jAz != null) {
            if (z) {
                ap.setImageResource(this.jAz, R.drawable.icon_common_voice_pause);
            } else {
                ap.setImageResource(this.jAz, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hSU = voiceManager;
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
        return this.hSU;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.byz();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.byy() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.at(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.byy();
            setVoiceModel(voiceModel);
            dxT();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jAD != voiceModel) {
                BM(1);
            } else {
                BM(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bb(int i) {
        if (!dxV()) {
            BM(1);
            return;
        }
        BL(i);
        if (this.jAD != null) {
            this.jAD.elapse = i;
        }
    }

    private boolean dxV() {
        if (this.jAD == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jAD);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jAD;
    }

    public void changeSkin() {
        dxT();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jAD);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jAD);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sb() {
    }

    public void reset() {
        this.jAD = null;
        setTag(null);
        BM(1);
    }

    public void bPf() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.miP.getLayoutParams();
        layoutParams.width = -2;
        this.miP.setLayoutParams(layoutParams);
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
            d = miS * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = miS * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = miS * 0.6d * 2.0d;
        } else {
            d = miS * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.miR) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiC = onClickListener;
    }
}
