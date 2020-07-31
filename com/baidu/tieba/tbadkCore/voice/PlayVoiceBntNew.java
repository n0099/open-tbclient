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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int lQQ = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener ahn;
    private VoiceManager hFy;
    private ImageView jls;
    private VoiceData.VoiceModel jlw;
    private TextView lQL;
    private RelativeLayout lQM;
    private AudioAnimationView lQN;
    private int lQO;
    private float lQP;
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
        this.lQO = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.lQO = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.lQL != null) {
            this.lQL.setTextSize(0, l.getDimens(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        K(context);
        setOnClickListener(this);
    }

    public void K(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.lQM = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.lQM.setOnClickListener(this);
        this.jls = (ImageView) findViewById(R.id.playingImg);
        this.lQL = (TextView) findViewById(R.id.playTime);
        this.lQN = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dms();
    }

    private void dms() {
        this.lQN.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jlw = voiceModel;
        if (this.jlw != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                zs(this.jlw.elapse);
                return;
            }
            zt(this.jlw.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.lQO = (int) this.lQL.getPaint().measureText(formatVoiceTime);
            this.lQP = this.lQO + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.lQN.setCertainColumnCount(getAudioVoiceColumnCount());
            this.lQN.qU();
            this.lQM.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.lQP, getPaddingBottom());
            this.lQL.setText(formatVoiceTime);
        }
    }

    public void zs(int i) {
        String formatVoiceTime;
        if (this.jlw != null && this.lQL != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jlw.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jlw.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jlw.duration);
            }
            String charSequence2String = k.charSequence2String(this.lQL.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.lQL.setText(formatVoiceTime);
            }
        }
    }

    public void zt(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            vq(true);
            this.lQN.setVisibility(0);
            this.lQN.start();
            return;
        }
        this.lQN.setCertainColumnCount(getAudioVoiceColumnCount());
        this.lQN.qU();
        this.lQN.setVisibility(4);
        vq(false);
        if (i == 1) {
            if (this.jlw != null) {
                this.lQL.setText(VoiceManager.formatVoiceTime(this.jlw.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jlw != null) {
                this.lQL.setText(VoiceManager.formatVoiceTime(this.jlw.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jlw != null && view == this.lQM) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ahn != null) {
                this.ahn.onClick(this);
            }
            TiebaStatic.log(this.jlw.from);
        }
    }

    public void ai(View.OnClickListener onClickListener) {
        if (this.lQM != null) {
            this.lQM.setOnClickListener(onClickListener);
        }
    }

    public void cmG() {
        VoiceManager voiceManager;
        if (this.jlw != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void vq(boolean z) {
        if (this.jls != null) {
            if (z) {
                ao.setImageResource(this.jls, R.drawable.icon_common_voice_pause);
            } else {
                ao.setImageResource(this.jls, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hFy = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.hFy;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bpK();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bpJ() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ar(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bpJ();
            setVoiceModel(voiceModel);
            dms();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jlw != voiceModel) {
                zt(1);
            } else {
                zt(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aY(int i) {
        if (!dmu()) {
            zt(1);
            return;
        }
        zs(i);
        if (this.jlw != null) {
            this.jlw.elapse = i;
        }
    }

    private boolean dmu() {
        if (this.jlw == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jlw);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jlw;
    }

    public void changeSkin() {
        dms();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jlw);
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jlw);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qC() {
    }

    public void reset() {
        this.jlw = null;
        setTag(null);
        zt(1);
    }

    public void bFz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lQN.getLayoutParams();
        layoutParams.width = -2;
        this.lQN.setLayoutParams(layoutParams);
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
            d = lQQ * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = lQQ * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = lQQ * 0.6d * 2.0d;
        } else {
            d = lQQ * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.lQP) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ahn = onClickListener;
    }
}
