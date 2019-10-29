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
    private static final int jlY = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener cmo;
    private VoiceManager fvn;
    private ImageView gSd;
    private VoiceData.VoiceModel gSh;
    private TextView jlT;
    private RelativeLayout jlU;
    private AudioAnimationView jlV;
    private int jlW;
    private float jlX;
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
        this.jlW = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.jlW = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.jlT != null) {
            this.jlT.setTextSize(0, l.getDimens(getContext(), i));
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
        this.jlU = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.jlU.setOnClickListener(this);
        this.gSd = (ImageView) findViewById(R.id.playingImg);
        this.jlT = (TextView) findViewById(R.id.playTime);
        this.jlV = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cpz();
    }

    private void cpz() {
        this.jlV.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gSh = voiceModel;
        if (this.gSh != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                uJ(this.gSh.elapse);
                return;
            }
            uK(this.gSh.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.jlW = (int) this.jlT.getPaint().measureText(formatVoiceTime);
            this.jlX = this.jlW + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.jlV.setCertainColumnCount(getAudioVoiceColumnCount());
            this.jlV.ll();
            this.jlU.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.jlX, getPaddingBottom());
            this.jlT.setText(formatVoiceTime);
        }
    }

    public void uJ(int i) {
        String formatVoiceTime;
        if (this.gSh != null && this.jlT != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gSh.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gSh.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gSh.duration);
            }
            String charSequence2String = k.charSequence2String(this.jlT.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.jlT.setText(formatVoiceTime);
            }
        }
    }

    public void uK(int i) {
        this.jlV.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            qU(true);
            this.jlV.setVisibility(0);
            this.jlV.start();
            return;
        }
        this.jlV.ll();
        this.jlV.setVisibility(4);
        qU(false);
        if (i == 1) {
            if (this.gSh != null) {
                this.jlT.setText(VoiceManager.formatVoiceTime(this.gSh.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gSh != null) {
                this.jlT.setText(VoiceManager.formatVoiceTime(this.gSh.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gSh != null && view == this.jlU) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.cmo != null) {
                this.cmo.onClick(this);
            }
            TiebaStatic.log(this.gSh.from);
        }
    }

    public void bur() {
        VoiceManager voiceManager;
        if (this.gSh != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void qU(boolean z) {
        if (this.gSd != null) {
            if (z) {
                am.setImageResource(this.gSd, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.gSd, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.fvn = voiceManager;
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
        return this.fvn;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.aAf();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.aAe() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ac(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.aAe();
            setVoiceModel(voiceModel);
            cpz();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gSh != voiceModel) {
                uK(1);
            } else {
                uK(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aA(int i) {
        if (!cpB()) {
            uK(1);
            return;
        }
        uJ(i);
        if (this.gSh != null) {
            this.gSh.elapse = i;
        }
    }

    private boolean cpB() {
        if (this.gSh == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gSh);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gSh;
    }

    public void bnq() {
        cpz();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gSh);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gSh);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lr() {
    }

    public void reset() {
        this.gSh = null;
        setTag(null);
        uK(1);
    }

    public void cpC() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jlV.getLayoutParams();
        layoutParams.width = -2;
        this.jlV.setLayoutParams(layoutParams);
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
            d = jlY * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = jlY * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = jlY * 0.6d * 2.0d;
        } else {
            d = jlY * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.jlX) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.cmo = onClickListener;
    }
}
