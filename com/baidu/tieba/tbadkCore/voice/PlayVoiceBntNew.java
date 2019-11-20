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
    private static final int jlh = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener clw;
    private VoiceManager fuw;
    private ImageView gRm;
    private VoiceData.VoiceModel gRq;
    private TextView jlc;
    private RelativeLayout jld;
    private AudioAnimationView jle;
    private int jlf;
    private float jlg;
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
        this.jlf = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.jlf = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.jlc != null) {
            this.jlc.setTextSize(0, l.getDimens(getContext(), i));
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
        this.jld = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.jld.setOnClickListener(this);
        this.gRm = (ImageView) findViewById(R.id.playingImg);
        this.jlc = (TextView) findViewById(R.id.playTime);
        this.jle = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cpx();
    }

    private void cpx() {
        this.jle.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gRq = voiceModel;
        if (this.gRq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                uI(this.gRq.elapse);
                return;
            }
            uJ(this.gRq.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.jlf = (int) this.jlc.getPaint().measureText(formatVoiceTime);
            this.jlg = this.jlf + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.jle.setCertainColumnCount(getAudioVoiceColumnCount());
            this.jle.ll();
            this.jld.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.jlg, getPaddingBottom());
            this.jlc.setText(formatVoiceTime);
        }
    }

    public void uI(int i) {
        String formatVoiceTime;
        if (this.gRq != null && this.jlc != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gRq.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gRq.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gRq.duration);
            }
            String charSequence2String = k.charSequence2String(this.jlc.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.jlc.setText(formatVoiceTime);
            }
        }
    }

    public void uJ(int i) {
        this.jle.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            qU(true);
            this.jle.setVisibility(0);
            this.jle.start();
            return;
        }
        this.jle.ll();
        this.jle.setVisibility(4);
        qU(false);
        if (i == 1) {
            if (this.gRq != null) {
                this.jlc.setText(VoiceManager.formatVoiceTime(this.gRq.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gRq != null) {
                this.jlc.setText(VoiceManager.formatVoiceTime(this.gRq.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gRq != null && view == this.jld) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.clw != null) {
                this.clw.onClick(this);
            }
            TiebaStatic.log(this.gRq.from);
        }
    }

    public void bup() {
        VoiceManager voiceManager;
        if (this.gRq != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void qU(boolean z) {
        if (this.gRm != null) {
            if (z) {
                am.setImageResource(this.gRm, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.gRm, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.fuw = voiceManager;
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
        return this.fuw;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.aAd();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.aAc() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ac(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.aAc();
            setVoiceModel(voiceModel);
            cpx();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gRq != voiceModel) {
                uJ(1);
            } else {
                uJ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aA(int i) {
        if (!cpz()) {
            uJ(1);
            return;
        }
        uI(i);
        if (this.gRq != null) {
            this.gRq.elapse = i;
        }
    }

    private boolean cpz() {
        if (this.gRq == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gRq);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gRq;
    }

    public void bno() {
        cpx();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gRq);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gRq);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lr() {
    }

    public void reset() {
        this.gRq = null;
        setTag(null);
        uJ(1);
    }

    public void cpA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jle.getLayoutParams();
        layoutParams.width = -2;
        this.jle.setLayoutParams(layoutParams);
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
            d = jlh * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = jlh * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = jlh * 0.6d * 2.0d;
        } else {
            d = jlh * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.jlg) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.clw = onClickListener;
    }
}
