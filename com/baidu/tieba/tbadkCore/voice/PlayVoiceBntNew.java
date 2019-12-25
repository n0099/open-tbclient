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
    private static final int kfw = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener Mz;
    private VoiceManager giZ;
    private ImageView hFq;
    private VoiceData.VoiceModel hFu;
    private TextView kfr;
    private RelativeLayout kfs;
    private AudioAnimationView kft;
    private int kfu;
    private float kfv;
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
        this.kfu = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.kfu = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.kfr != null) {
            this.kfr.setTextSize(0, l.getDimens(getContext(), i));
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
        this.kfs = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.kfs.setOnClickListener(this);
        this.hFq = (ImageView) findViewById(R.id.playingImg);
        this.kfr = (TextView) findViewById(R.id.playTime);
        this.kft = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cJC();
    }

    private void cJC() {
        this.kft.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.hFu = voiceModel;
        if (this.hFu != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                wK(this.hFu.elapse);
                return;
            }
            wL(this.hFu.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.kfu = (int) this.kfr.getPaint().measureText(formatVoiceTime);
            this.kfv = this.kfu + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.kft.setCertainColumnCount(getAudioVoiceColumnCount());
            this.kft.lD();
            this.kfs.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.kfv, getPaddingBottom());
            this.kfr.setText(formatVoiceTime);
        }
    }

    public void wK(int i) {
        String formatVoiceTime;
        if (this.hFu != null && this.kfr != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.hFu.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hFu.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hFu.duration);
            }
            String charSequence2String = k.charSequence2String(this.kfr.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.kfr.setText(formatVoiceTime);
            }
        }
    }

    public void wL(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            sB(true);
            this.kft.setVisibility(0);
            this.kft.start();
            return;
        }
        this.kft.setCertainColumnCount(getAudioVoiceColumnCount());
        this.kft.lD();
        this.kft.setVisibility(4);
        sB(false);
        if (i == 1) {
            if (this.hFu != null) {
                this.kfr.setText(VoiceManager.formatVoiceTime(this.hFu.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.hFu != null) {
                this.kfr.setText(VoiceManager.formatVoiceTime(this.hFu.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hFu != null && view == this.kfs) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.Mz != null) {
                this.Mz.onClick(this);
            }
            TiebaStatic.log(this.hFu.from);
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.kfs != null) {
            this.kfs.setOnClickListener(onClickListener);
        }
    }

    public void bLD() {
        VoiceManager voiceManager;
        if (this.hFu != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void sB(boolean z) {
        if (this.hFq != null) {
            if (z) {
                am.setImageResource(this.hFq, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.hFq, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.giZ = voiceManager;
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
        return this.giZ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.aSd();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.aSc() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aj(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.aSc();
            setVoiceModel(voiceModel);
            cJC();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.hFu != voiceModel) {
                wL(1);
            } else {
                wL(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aD(int i) {
        if (!cJD()) {
            wL(1);
            return;
        }
        wK(i);
        if (this.hFu != null) {
            this.hFu.elapse = i;
        }
    }

    private boolean cJD() {
        if (this.hFu == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.hFu);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.hFu;
    }

    public void bEM() {
        cJC();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.hFu);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.hFu);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lI() {
    }

    public void reset() {
        this.hFu = null;
        setTag(null);
        wL(1);
    }

    public void cJE() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kft.getLayoutParams();
        layoutParams.width = -2;
        this.kft.setLayoutParams(layoutParams);
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
            d = kfw * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = kfw * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = kfw * 0.6d * 2.0d;
        } else {
            d = kfw * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.kfv) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Mz = onClickListener;
    }
}
