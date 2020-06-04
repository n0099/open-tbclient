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
    private static final int lpR = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener ags;
    private VoiceManager hns;
    private ImageView iLV;
    private VoiceData.VoiceModel iLZ;
    private TextView lpM;
    private RelativeLayout lpN;
    private AudioAnimationView lpO;
    private int lpP;
    private float lpQ;
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
        this.lpP = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.lpP = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.lpM != null) {
            this.lpM.setTextSize(0, l.getDimens(getContext(), i));
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
        this.lpN = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.lpN.setOnClickListener(this);
        this.iLV = (ImageView) findViewById(R.id.playingImg);
        this.lpM = (TextView) findViewById(R.id.playTime);
        this.lpO = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        deX();
    }

    private void deX() {
        this.lpO.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.iLZ = voiceModel;
        if (this.iLZ != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                yj(this.iLZ.elapse);
                return;
            }
            yk(this.iLZ.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.lpP = (int) this.lpM.getPaint().measureText(formatVoiceTime);
            this.lpQ = this.lpP + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.lpO.setCertainColumnCount(getAudioVoiceColumnCount());
            this.lpO.qA();
            this.lpN.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.lpQ, getPaddingBottom());
            this.lpM.setText(formatVoiceTime);
        }
    }

    public void yj(int i) {
        String formatVoiceTime;
        if (this.iLZ != null && this.lpM != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.iLZ.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.iLZ.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.iLZ.duration);
            }
            String charSequence2String = k.charSequence2String(this.lpM.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.lpM.setText(formatVoiceTime);
            }
        }
    }

    public void yk(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            ux(true);
            this.lpO.setVisibility(0);
            this.lpO.start();
            return;
        }
        this.lpO.setCertainColumnCount(getAudioVoiceColumnCount());
        this.lpO.qA();
        this.lpO.setVisibility(4);
        ux(false);
        if (i == 1) {
            if (this.iLZ != null) {
                this.lpM.setText(VoiceManager.formatVoiceTime(this.iLZ.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.iLZ != null) {
                this.lpM.setText(VoiceManager.formatVoiceTime(this.iLZ.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iLZ != null && view == this.lpN) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ags != null) {
                this.ags.onClick(this);
            }
            TiebaStatic.log(this.iLZ.from);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        if (this.lpN != null) {
            this.lpN.setOnClickListener(onClickListener);
        }
    }

    public void cfI() {
        VoiceManager voiceManager;
        if (this.iLZ != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void ux(boolean z) {
        if (this.iLV != null) {
            if (z) {
                am.setImageResource(this.iLV, R.drawable.icon_common_voice_pause);
            } else {
                am.setImageResource(this.iLV, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hns = voiceManager;
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
        return this.hns;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.bjq();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.bjp() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aq(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.bjp();
            setVoiceModel(voiceModel);
            deX();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.iLZ != voiceModel) {
                yk(1);
            } else {
                yk(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aT(int i) {
        if (!deZ()) {
            yk(1);
            return;
        }
        yj(i);
        if (this.iLZ != null) {
            this.iLZ.elapse = i;
        }
    }

    private boolean deZ() {
        if (this.iLZ == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.iLZ);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.iLZ;
    }

    public void crv() {
        deX();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.iLZ);
        }
        if ((i.G(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.G(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.iLZ);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qF() {
    }

    public void reset() {
        this.iLZ = null;
        setTag(null);
        yk(1);
    }

    public void dfa() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.lpO.getLayoutParams();
        layoutParams.width = -2;
        this.lpO.setLayoutParams(layoutParams);
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
            d = lpR * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = lpR * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = lpR * 0.6d * 2.0d;
        } else {
            d = lpR * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.lpQ) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.ags = onClickListener;
    }
}
