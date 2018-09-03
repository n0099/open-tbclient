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
import com.baidu.tieba.f;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener atF;
    private VoiceManager dmn;
    private ImageView eDm;
    private VoiceData.VoiceModel eDq;
    private TextView gRg;
    private RelativeLayout gRh;
    private AudioAnimationView gRi;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(f.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.gRg != null) {
            this.gRg.setTextSize(0, l.f(getContext(), i));
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
        LayoutInflater.from(context).inflate(f.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.gRh = (RelativeLayout) findViewById(f.g.voice_image_content);
        this.gRh.setOnClickListener(this);
        this.eDm = (ImageView) findViewById(f.g.playingImg);
        this.gRg = (TextView) findViewById(f.g.playTime);
        this.gRg.setPadding(l.f(getContext(), f.e.ds8), 0 - l.f(getContext(), f.e.ds6), 0, 0);
        this.gRi = (AudioAnimationView) findViewById(f.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(f.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bxm();
    }

    private void bxm() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.i(this.gRh, f.C0146f.btn_audio_frame_n);
        am.c(this.gRg, f.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bxp();
            this.eDm.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gRi.onChangeSkinType(skinType);
    }

    private void bxp() {
        if (this.eDm != null) {
            if (bxo()) {
                am.c(this.eDm, f.C0146f.icon_voice_stop);
            } else {
                am.c(this.eDm, f.C0146f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eDq = voiceModel;
        if (this.eDq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                oG(this.eDq.elapse);
                return;
            }
            oH(this.eDq.voice_status.intValue());
            this.gRi.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gRi.oJ();
            this.gRg.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void oG(int i) {
        String formatVoiceTime;
        if (this.eDq != null && this.gRg != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eDq.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eDq.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eDq.duration);
            }
            String a = k.a(this.gRg.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gRg.setText(formatVoiceTime);
            }
        }
    }

    public void oH(int i) {
        this.gRi.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mx(true);
            this.gRi.start();
            return;
        }
        this.gRi.oJ();
        mx(false);
        if (i == 1) {
            if (this.eDq != null) {
                this.gRg.setText(VoiceManager.formatVoiceTime(this.eDq.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eDq != null) {
                this.gRg.setText(VoiceManager.formatVoiceTime(this.eDq.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eDq != null && view == this.gRh) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.atF != null) {
                this.atF.onClick(this);
            }
            TiebaStatic.log(this.eDq.from);
        }
    }

    public void aFA() {
        VoiceManager voiceManager;
        if (this.eDq != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mx(boolean z) {
        if (this.eDm != null) {
            if (z) {
                am.c(this.eDm, f.C0146f.icon_voice_stop);
            } else {
                am.c(this.eDm, f.C0146f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dmn = voiceManager;
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
        return this.dmn;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ot();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Os() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Cc();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.H(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Os();
            setVoiceModel(voiceModel);
            bxm();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eDq != voiceModel) {
                oH(1);
            } else {
                oH(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ba(int i) {
        if (!bxo()) {
            oH(1);
            return;
        }
        oG(i);
        if (this.eDq != null) {
            this.eDq.elapse = i;
        }
    }

    private boolean bxo() {
        if (this.eDq == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eDq);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eDq;
    }

    public void aPq() {
        bxm();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eDq);
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eDq);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    public void reset() {
        this.eDq = null;
        setTag(null);
        oH(1);
    }

    public void bxq() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRi.getLayoutParams();
        layoutParams.width = -2;
        this.gRi.setLayoutParams(layoutParams);
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
        this.atF = onClickListener;
    }
}
