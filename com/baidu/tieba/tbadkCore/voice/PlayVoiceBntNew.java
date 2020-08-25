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
/* loaded from: classes2.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int miD = ((l.getEquipmentWidth(TbadkCoreApplication.getInst()) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener aiA;
    private VoiceManager hSO;
    private ImageView jAt;
    private VoiceData.VoiceModel jAx;
    private Context mContext;
    private ProgressBar mProgress;
    private AudioAnimationView miA;
    private int miB;
    private float miC;
    private TextView miy;
    private RelativeLayout miz;
    private int play_type;

    /* loaded from: classes2.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBntNew(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.miB = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.miB = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(R.styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.miy != null) {
            this.miy.setTextSize(0, l.getDimens(getContext(), i));
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
        this.miz = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.miz.setOnClickListener(this);
        this.jAt = (ImageView) findViewById(R.id.playingImg);
        this.miy = (TextView) findViewById(R.id.playTime);
        this.miA = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        dxO();
    }

    private void dxO() {
        this.miA.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.jAx = voiceModel;
        if (this.jAx != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                BL(this.jAx.elapse);
                return;
            }
            BM(this.jAx.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.miB = (int) this.miy.getPaint().measureText(formatVoiceTime);
            this.miC = this.miB + l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.miA.setCertainColumnCount(getAudioVoiceColumnCount());
            this.miA.st();
            this.miz.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.miC, getPaddingBottom());
            this.miy.setText(formatVoiceTime);
        }
    }

    public void BL(int i) {
        String formatVoiceTime;
        if (this.jAx != null && this.miy != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.jAx.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jAx.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.jAx.duration);
            }
            String charSequence2String = k.charSequence2String(this.miy.getText(), null);
            if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
                this.miy.setText(formatVoiceTime);
            }
        }
    }

    public void BM(int i) {
        if (i == 3) {
            this.mProgress.setVisibility(4);
            wf(true);
            this.miA.setVisibility(0);
            this.miA.start();
            return;
        }
        this.miA.setCertainColumnCount(getAudioVoiceColumnCount());
        this.miA.st();
        this.miA.setVisibility(4);
        wf(false);
        if (i == 1) {
            if (this.jAx != null) {
                this.miy.setText(VoiceManager.formatVoiceTime(this.jAx.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.jAx != null) {
                this.miy.setText(VoiceManager.formatVoiceTime(this.jAx.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jAx != null && view == this.miz) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aiA != null) {
                this.aiA.onClick(this);
            }
            TiebaStatic.log(this.jAx.from);
        }
    }

    public void aj(View.OnClickListener onClickListener) {
        if (this.miz != null) {
            this.miz.setOnClickListener(onClickListener);
        }
    }

    public void cxp() {
        VoiceManager voiceManager;
        if (this.jAx != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void wf(boolean z) {
        if (this.jAt != null) {
            if (z) {
                ap.setImageResource(this.jAt, R.drawable.icon_common_voice_pause);
            } else {
                ap.setImageResource(this.jAt, R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.hSO = voiceManager;
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
        return this.hSO;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.byy();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.byx() == 0) {
                    voiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.at(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.byx();
            setVoiceModel(voiceModel);
            dxO();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.jAx != voiceModel) {
                BM(1);
            } else {
                BM(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bb(int i) {
        if (!dxQ()) {
            BM(1);
            return;
        }
        BL(i);
        if (this.jAx != null) {
            this.jAx.elapse = i;
        }
    }

    private boolean dxQ() {
        if (this.jAx == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.jAx);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.jAx;
    }

    public void changeSkin() {
        dxO();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).d(this.jAx);
        }
        if ((i.I(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.I(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).d(this.jAx);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void sb() {
    }

    public void reset() {
        this.jAx = null;
        setTag(null);
        BM(1);
    }

    public void bPe() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.miA.getLayoutParams();
        layoutParams.width = -2;
        this.miA.setLayoutParams(layoutParams);
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
            d = miD * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = miD * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = miD * 0.6d * 2.0d;
        } else {
            d = miD * 2;
        }
        if (d < l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double dimens = (d - this.miC) - l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (dimens > 0.0d) {
            return (int) dimens;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aiA = onClickListener;
    }
}
