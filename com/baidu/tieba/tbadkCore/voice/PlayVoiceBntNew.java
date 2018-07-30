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
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener atE;
    private VoiceManager dmp;
    private ImageView eDq;
    private VoiceData.VoiceModel eDu;
    private TextView gRf;
    private RelativeLayout gRg;
    private AudioAnimationView gRh;
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
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.gRf != null) {
            this.gRf.setTextSize(0, l.f(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        aq(context);
        setOnClickListener(this);
    }

    public void aq(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.gRg = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gRg.setOnClickListener(this);
        this.eDq = (ImageView) findViewById(d.g.playingImg);
        this.gRf = (TextView) findViewById(d.g.playTime);
        this.gRf.setPadding(l.f(getContext(), d.e.ds8), 0 - l.f(getContext(), d.e.ds6), 0, 0);
        this.gRh = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxl();
    }

    private void bxl() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.i(this.gRg, d.f.btn_audio_frame_n);
        am.c(this.gRf, d.C0140d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bxo();
            this.eDq.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gRh.onChangeSkinType(skinType);
    }

    private void bxo() {
        if (this.eDq != null) {
            if (bxn()) {
                am.c(this.eDq, d.f.icon_voice_stop);
            } else {
                am.c(this.eDq, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eDu = voiceModel;
        if (this.eDu != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                oG(this.eDu.elapse);
                return;
            }
            oH(this.eDu.voice_status.intValue());
            this.gRh.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gRh.oM();
            this.gRf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void oG(int i) {
        String formatVoiceTime;
        if (this.eDu != null && this.gRf != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eDu.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eDu.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eDu.duration);
            }
            String a = k.a(this.gRf.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gRf.setText(formatVoiceTime);
            }
        }
    }

    public void oH(int i) {
        this.gRh.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mx(true);
            this.gRh.start();
            return;
        }
        this.gRh.oM();
        mx(false);
        if (i == 1) {
            if (this.eDu != null) {
                this.gRf.setText(VoiceManager.formatVoiceTime(this.eDu.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eDu != null) {
                this.gRf.setText(VoiceManager.formatVoiceTime(this.eDu.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eDu != null && view == this.gRg) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.atE != null) {
                this.atE.onClick(this);
            }
            TiebaStatic.log(this.eDu.from);
        }
    }

    public void aFD() {
        VoiceManager voiceManager;
        if (this.eDu != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mx(boolean z) {
        if (this.eDq != null) {
            if (z) {
                am.c(this.eDq, d.f.icon_voice_stop);
            } else {
                am.c(this.eDq, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dmp = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dmp;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ou();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Ot() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Cf();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.H(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Ot();
            setVoiceModel(voiceModel);
            bxl();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eDu != voiceModel) {
                oH(1);
            } else {
                oH(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ba(int i) {
        if (!bxn()) {
            oH(1);
            return;
        }
        oG(i);
        if (this.eDu != null) {
            this.eDu.elapse = i;
        }
    }

    private boolean bxn() {
        if (this.eDu == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eDu);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eDu;
    }

    public void aPt() {
        bxl();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eDu);
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eDu);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oS() {
    }

    public void reset() {
        this.eDu = null;
        setTag(null);
        oH(1);
    }

    public void bxp() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRh.getLayoutParams();
        layoutParams.width = -2;
        this.gRh.setLayoutParams(layoutParams);
    }

    private int getAudioVoiceColumnCount() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return 0;
        }
        int i = voiceModel.duration;
        if (i <= 20) {
            return 8;
        }
        if (i <= 60) {
            return 14;
        }
        return 22;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.atE = onClickListener;
    }
}
