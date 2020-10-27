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
    private static final int mUI = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener ajp;
    private VoiceManager iBr;
    private VoiceData.VoiceModel kkC;
    private ImageView kky;
    private Context mContext;
    private ProgressBar mProgress;
    private TextView mUD;
    private RelativeLayout mUE;
    private AudioAnimationView mUF;
    private int mUG;
    private float mUH;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.mUG = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.mUG = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.mUD != null) {
            this.mUD.setTextSize(0, l.getDimens(getContext(), i));
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
        this.mUE = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.mUE.setOnClickListener(this);
        this.kky = (ImageView) findViewById(R.id.playingImg);
        this.mUD = (TextView) findViewById(R.id.playTime);
        this.mUF = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dIG();
    }

    private void dIG() {
        this.mUF.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.kkC = voiceModel;
        if (this.kkC != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                Dl(this.kkC.elapse);
                return;
            }
            Dm(this.kkC.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.mUG = (int) this.mUD.getPaint().measureText(formatVoiceTime);
            this.mUH = this.mUG + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.mUF.setCertainColumnCount(getAudioVoiceColumnCount());
            this.mUF.sy();
            this.mUE.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.mUH, getPaddingBottom());
            this.mUD.setText(formatVoiceTime);
        }
    }

    public void Dl(int i) {
        String formatVoiceTime;
        if (this.kkC != null && this.mUD != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.kkC.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kkC.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.kkC.duration);
            }
            String charSequence2String = k.charSequence2String(this.mUD.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.mUD.setText(formatVoiceTime);
            }
        }
    }

    public void Dm(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            xo(true);
            this.mUF.setVisibility(0);
            this.mUF.start();
            return;
        }
        this.mUF.setCertainColumnCount(getAudioVoiceColumnCount());
        this.mUF.sy();
        this.mUF.setVisibility(4);
        xo(false);
        if (i == 1) {
            if (this.kkC != null) {
                this.mUD.setText(VoiceManager.formatVoiceTime(this.kkC.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.kkC != null) {
                this.mUD.setText(VoiceManager.formatVoiceTime(this.kkC.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.kkC != null && view == this.mUE) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajp != null) {
                this.ajp.onClick(this);
            }
            TiebaStatic.log(this.kkC.from);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        if (this.mUE != null) {
            this.mUE.setOnClickListener(onClickListener);
        }
    }

    public void cHM() {
        VoiceManager voiceManager;
        if (this.kkC != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void xo(boolean z) {
        if (this.kky != null) {
            if (z) {
                ap.setImageResource(this.kky, R.drawable.icon_common_voice_pause);
            } else {
                ap.setImageResource(this.kky, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.iBr = voiceManager;
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
        return this.iBr;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bEl();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bEk() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ax(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bEk();
            setVoiceModel(voiceModel);
            dIG();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.kkC != voiceModel) {
                Dm(1);
            } else {
                Dm(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bf(int i) {
        if (!dII()) {
            Dm(1);
            return;
        }
        Dl(i);
        if (this.kkC != null) {
            this.kkC.elapse = i;
        }
    }

    private boolean dII() {
        if (this.kkC == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.kkC);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.kkC;
    }

    public void changeSkin() {
        dIG();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.kkC);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.kkC);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sg() {
    }

    public void reset() {
        this.kkC = null;
        setTag(null);
        Dm(1);
    }

    public void bWJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUF.getLayoutParams();
        layoutParams.width = -2;
        this.mUF.setLayoutParams(layoutParams);
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
            d = mUI * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = mUI * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = mUI * 0.6d * 2.0d;
        } else {
            d = mUI * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.mUH) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ajp = onClickListener;
    }

    public RelativeLayout getmVoiceImageContent() {
        return this.mUE;
    }

    public TextView getPlayTime() {
        return this.mUD;
    }

    public ImageView getImgStatus() {
        return this.kky;
    }
}
