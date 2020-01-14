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
    private static final int kje = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener MG;
    private VoiceManager gmi;
    private ImageView hIT;
    private VoiceData.VoiceModel hIX;
    private TextView kiZ;
    private RelativeLayout kja;
    private AudioAnimationView kjb;
    private int kjc;
    private float kjd;
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
        this.kjc = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.kjc = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.kiZ != null) {
            this.kiZ.setTextSize(0, l.getDimens(getContext(), i));
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
        this.kja = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.kja.setOnClickListener(this);
        this.hIT = (ImageView) findViewById(R.id.playingImg);
        this.kiZ = (TextView) findViewById(R.id.playTime);
        this.kjb = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cKI();
    }

    private void cKI() {
        this.kjb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.hIX = voiceModel;
        if (this.hIX != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                wP(this.hIX.elapse);
                return;
            }
            wQ(this.hIX.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.kjc = (int) this.kiZ.getPaint().measureText(formatVoiceTime);
            this.kjd = this.kjc + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.kjb.setCertainColumnCount(getAudioVoiceColumnCount());
            this.kjb.lD();
            this.kja.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.kjd, getPaddingBottom());
            this.kiZ.setText(formatVoiceTime);
        }
    }

    public void wP(int i) {
        String formatVoiceTime;
        if (this.hIX != null && this.kiZ != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.hIX.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hIX.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hIX.duration);
            }
            String charSequence2String = k.charSequence2String(this.kiZ.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.kiZ.setText(formatVoiceTime);
            }
        }
    }

    public void wQ(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            sN(true);
            this.kjb.setVisibility(0);
            this.kjb.start();
            return;
        }
        this.kjb.setCertainColumnCount(getAudioVoiceColumnCount());
        this.kjb.lD();
        this.kjb.setVisibility(4);
        sN(false);
        if (i == 1) {
            if (this.hIX != null) {
                this.kiZ.setText(VoiceManager.formatVoiceTime(this.hIX.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.hIX != null) {
                this.kiZ.setText(VoiceManager.formatVoiceTime(this.hIX.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hIX != null && view == this.kja) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.MG != null) {
                this.MG.onClick(this);
            }
            TiebaStatic.log(this.hIX.from);
        }
    }

    public void ae(View.OnClickListener onClickListener) {
        if (this.kja != null) {
            this.kja.setOnClickListener(onClickListener);
        }
    }

    public void bML() {
        VoiceManager voiceManager;
        if (this.hIX != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void sN(boolean z) {
        if (this.hIT != null) {
            if (z) {
                am.setImageResource(this.hIT, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.hIT, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.gmi = voiceManager;
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
        return this.gmi;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.aSx();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.aSw() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aj(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.aSw();
            setVoiceModel(voiceModel);
            cKI();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.hIX != voiceModel) {
                wQ(1);
            } else {
                wQ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aD(int i) {
        if (!cKJ()) {
            wQ(1);
            return;
        }
        wP(i);
        if (this.hIX != null) {
            this.hIX.elapse = i;
        }
    }

    private boolean cKJ() {
        if (this.hIX == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.hIX);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.hIX;
    }

    public void bFO() {
        cKI();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.hIX);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.hIX);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lI() {
    }

    public void reset() {
        this.hIX = null;
        setTag(null);
        wQ(1);
    }

    public void cKK() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kjb.getLayoutParams();
        layoutParams.width = -2;
        this.kjb.setLayoutParams(layoutParams);
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
            d = kje * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = kje * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = kje * 0.6d * 2.0d;
        } else {
            d = kje * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.kjd) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.MG = onClickListener;
    }
}
