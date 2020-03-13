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
    private static final int kko = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener Nh;
    private VoiceManager goy;
    private ImageView hLg;
    private VoiceData.VoiceModel hLk;
    private TextView kkj;
    private RelativeLayout kkk;
    private AudioAnimationView kkl;
    private int kkm;
    private float kkn;
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
        this.kkm = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.kkm = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.kkj != null) {
            this.kkj.setTextSize(0, l.getDimens(getContext(), i));
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
        this.kkk = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.kkk.setOnClickListener(this);
        this.hLg = (ImageView) findViewById(R.id.playingImg);
        this.kkj = (TextView) findViewById(R.id.playTime);
        this.kkl = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cMg();
    }

    private void cMg() {
        this.kkl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.hLk = voiceModel;
        if (this.hLk != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                wV(this.hLk.elapse);
                return;
            }
            wW(this.hLk.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.kkm = (int) this.kkj.getPaint().measureText(formatVoiceTime);
            this.kkn = this.kkm + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.kkl.setCertainColumnCount(getAudioVoiceColumnCount());
            this.kkl.lS();
            this.kkk.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.kkn, getPaddingBottom());
            this.kkj.setText(formatVoiceTime);
        }
    }

    public void wV(int i) {
        String formatVoiceTime;
        if (this.hLk != null && this.kkj != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.hLk.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hLk.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.hLk.duration);
            }
            String charSequence2String = k.charSequence2String(this.kkj.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.kkj.setText(formatVoiceTime);
            }
        }
    }

    public void wW(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            sR(true);
            this.kkl.setVisibility(0);
            this.kkl.start();
            return;
        }
        this.kkl.setCertainColumnCount(getAudioVoiceColumnCount());
        this.kkl.lS();
        this.kkl.setVisibility(4);
        sR(false);
        if (i == 1) {
            if (this.hLk != null) {
                this.kkj.setText(VoiceManager.formatVoiceTime(this.hLk.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.hLk != null) {
                this.kkj.setText(VoiceManager.formatVoiceTime(this.hLk.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hLk != null && view == this.kkk) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.Nh != null) {
                this.Nh.onClick(this);
            }
            TiebaStatic.log(this.hLk.from);
        }
    }

    public void ae(View.OnClickListener onClickListener) {
        if (this.kkk != null) {
            this.kkk.setOnClickListener(onClickListener);
        }
    }

    public void bOq() {
        VoiceManager voiceManager;
        if (this.hLk != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void sR(boolean z) {
        if (this.hLg != null) {
            if (z) {
                am.setImageResource(this.hLg, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.hLg, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.goy = voiceManager;
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
        return this.goy;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.aUR();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.aUQ() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.al(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.aUQ();
            setVoiceModel(voiceModel);
            cMg();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.hLk != voiceModel) {
                wW(1);
            } else {
                wW(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aG(int i) {
        if (!cMh()) {
            wW(1);
            return;
        }
        wV(i);
        if (this.hLk != null) {
            this.hLk.elapse = i;
        }
    }

    private boolean cMh() {
        if (this.hLk == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.hLk);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.hLk;
    }

    public void bHt() {
        cMg();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.hLk);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.hLk);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lX() {
    }

    public void reset() {
        this.hLk = null;
        setTag(null);
        wW(1);
    }

    public void cMi() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.kkl.getLayoutParams();
        layoutParams.width = -2;
        this.kkl.setLayoutParams(layoutParams);
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
            d = kko * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = kko * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = kko * 0.6d * 2.0d;
        } else {
            d = kko * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.kkn) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.Nh = onClickListener;
    }
}
