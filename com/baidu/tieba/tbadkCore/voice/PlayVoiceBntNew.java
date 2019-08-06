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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.c;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int jjM = ((l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener bWq;
    private VoiceManager fun;
    private ImageView gSk;
    private VoiceData.VoiceModel gSo;
    private TextView jjH;
    private RelativeLayout jjI;
    private AudioAnimationView jjJ;
    private int jjK;
    private float jjL;
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
        this.jjK = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.jjK = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.jjH != null) {
            this.jjH.setTextSize(0, l.g(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        ao(context);
        setOnClickListener(this);
    }

    public void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.jjI = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.jjI.setOnClickListener(this);
        this.gSk = (ImageView) findViewById(R.id.playingImg);
        this.jjH = (TextView) findViewById(R.id.playTime);
        this.jjJ = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cqS();
    }

    private void cqS() {
        this.jjJ.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gSo = voiceModel;
        if (this.gSo != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                vZ(this.gSo.elapse);
                return;
            }
            wa(this.gSo.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.jjK = (int) this.jjH.getPaint().measureText(formatVoiceTime);
            this.jjL = this.jjK + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.jjJ.setCertainColumnCount(getAudioVoiceColumnCount());
            this.jjJ.qr();
            this.jjI.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.jjL, getPaddingBottom());
            this.jjH.setText(formatVoiceTime);
        }
    }

    public void vZ(int i) {
        String formatVoiceTime;
        if (this.gSo != null && this.jjH != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gSo.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gSo.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gSo.duration);
            }
            String a = k.a(this.jjH.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.jjH.setText(formatVoiceTime);
            }
        }
    }

    public void wa(int i) {
        this.jjJ.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            ri(true);
            this.jjJ.setVisibility(0);
            this.jjJ.start();
            return;
        }
        this.jjJ.qr();
        this.jjJ.setVisibility(4);
        ri(false);
        if (i == 1) {
            if (this.gSo != null) {
                this.jjH.setText(VoiceManager.formatVoiceTime(this.gSo.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gSo != null) {
                this.jjH.setText(VoiceManager.formatVoiceTime(this.gSo.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gSo != null && view == this.jjI) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bWq != null) {
                this.bWq.onClick(this);
            }
            TiebaStatic.log(this.gSo.from);
        }
    }

    public void bwz() {
        VoiceManager voiceManager;
        if (this.gSo != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void ri(boolean z) {
        if (this.gSk != null) {
            if (z) {
                am.c(this.gSk, (int) R.drawable.icon_common_voice_pause);
            } else {
                am.c(this.gSk, (int) R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.fun = voiceManager;
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
        return this.fun;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.azK();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.azJ() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.amq();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.azJ();
            setVoiceModel(voiceModel);
            cqS();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gSo != voiceModel) {
                wa(1);
            } else {
                wa(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (!cqU()) {
            wa(1);
            return;
        }
        vZ(i);
        if (this.gSo != null) {
            this.gSo.elapse = i;
        }
    }

    private boolean cqU() {
        if (this.gSo == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gSo);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gSo;
    }

    public void bIz() {
        cqS();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gSo);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gSo);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qx() {
    }

    public void reset() {
        this.gSo = null;
        setTag(null);
        wa(1);
    }

    public void cqV() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jjJ.getLayoutParams();
        layoutParams.width = -2;
        this.jjJ.setLayoutParams(layoutParams);
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
            d = jjM * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = jjM * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = jjM * 0.6d * 2.0d;
        } else {
            d = jjM * 2;
        }
        if (d < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double g = (d - this.jjL) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (g > 0.0d) {
            return (int) g;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWq = onClickListener;
    }
}
