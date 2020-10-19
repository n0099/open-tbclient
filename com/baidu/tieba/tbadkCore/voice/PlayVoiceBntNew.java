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
    private static final int mHX = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener ajo;
    private VoiceManager ioV;
    private ImageView jXY;
    private VoiceData.VoiceModel jYc;
    private Context mContext;
    private TextView mHS;
    private RelativeLayout mHT;
    private AudioAnimationView mHU;
    private int mHV;
    private float mHW;
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
        this.mHV = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.mHV = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.mHS != null) {
            this.mHS.setTextSize(0, l.getDimens(getContext(), i));
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
        this.mHT = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.mHT.setOnClickListener(this);
        this.jXY = (ImageView) findViewById(R.id.playingImg);
        this.mHS = (TextView) findViewById(R.id.playTime);
        this.mHU = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dFy();
    }

    private void dFy() {
        this.mHU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jYc = voiceModel;
        if (this.jYc != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                CS(this.jYc.elapse);
                return;
            }
            CT(this.jYc.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.mHV = (int) this.mHS.getPaint().measureText(formatVoiceTime);
            this.mHW = this.mHV + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.mHU.setCertainColumnCount(getAudioVoiceColumnCount());
            this.mHU.sy();
            this.mHT.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.mHW, getPaddingBottom());
            this.mHS.setText(formatVoiceTime);
        }
    }

    public void CS(int i) {
        String formatVoiceTime;
        if (this.jYc != null && this.mHS != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jYc.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jYc.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jYc.duration);
            }
            String charSequence2String = k.charSequence2String(this.mHS.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.mHS.setText(formatVoiceTime);
            }
        }
    }

    public void CT(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            wX(true);
            this.mHU.setVisibility(0);
            this.mHU.start();
            return;
        }
        this.mHU.setCertainColumnCount(getAudioVoiceColumnCount());
        this.mHU.sy();
        this.mHU.setVisibility(4);
        wX(false);
        if (i == 1) {
            if (this.jYc != null) {
                this.mHS.setText(VoiceManager.formatVoiceTime(this.jYc.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jYc != null) {
                this.mHS.setText(VoiceManager.formatVoiceTime(this.jYc.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jYc != null && view == this.mHT) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajo != null) {
                this.ajo.onClick(this);
            }
            TiebaStatic.log(this.jYc.from);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        if (this.mHT != null) {
            this.mHT.setOnClickListener(onClickListener);
        }
    }

    public void cEF() {
        VoiceManager voiceManager;
        if (this.jYc != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void wX(boolean z) {
        if (this.jXY != null) {
            if (z) {
                ap.setImageResource(this.jXY, R.drawable.icon_common_voice_pause);
            } else {
                ap.setImageResource(this.jXY, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.ioV = voiceManager;
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
        return this.ioV;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bCs();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bCr() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ax(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bCr();
            setVoiceModel(voiceModel);
            dFy();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jYc != voiceModel) {
                CT(1);
            } else {
                CT(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (!dFA()) {
            CT(1);
            return;
        }
        CS(i);
        if (this.jYc != null) {
            this.jYc.elapse = i;
        }
    }

    private boolean dFA() {
        if (this.jYc == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jYc);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jYc;
    }

    public void changeSkin() {
        dFy();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jYc);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jYc);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void reset() {
        this.jYc = null;
        setTag(null);
        CT(1);
    }

    public void bTK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mHU.getLayoutParams();
        layoutParams.width = -2;
        this.mHU.setLayoutParams(layoutParams);
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
            d = mHX * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = mHX * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = mHX * 0.6d * 2.0d;
        } else {
            d = mHX * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.mHW) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajo = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.mHT;
    }

    public TextView getPlayTime() {
        return this.mHS;
    }

    public ImageView getImgStatus() {
        return this.jXY;
    }
}
