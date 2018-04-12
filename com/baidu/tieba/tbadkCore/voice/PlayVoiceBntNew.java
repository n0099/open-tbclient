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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener alg;
    private VoiceManager cXj;
    private ImageView ejn;
    private VoiceData.VoiceModel ejr;
    private TextView gzE;
    private RelativeLayout gzF;
    private AudioAnimationView gzG;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.m.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.m.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.gzE != null) {
            this.gzE.setTextSize(0, l.e(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        am(context);
        setOnClickListener(this);
    }

    public void am(Context context) {
        LayoutInflater.from(context).inflate(d.i.play_voice_bnt_new, (ViewGroup) this, true);
        this.gzF = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gzF.setOnClickListener(this);
        this.ejn = (ImageView) findViewById(d.g.playingImg);
        this.gzE = (TextView) findViewById(d.g.playTime);
        this.gzE.setPadding(l.e(getContext(), d.e.ds8), 0 - l.e(getContext(), d.e.ds6), 0, 0);
        this.gzG = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        btb();
    }

    private void btb() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ak.i(this.gzF, d.f.btn_audio_frame_n);
        ak.c(this.gzE, d.C0126d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bte();
            this.ejn.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gzG.onChangeSkinType(skinType);
    }

    private void bte() {
        if (this.ejn != null) {
            if (btd()) {
                ak.c(this.ejn, d.f.icon_voice_stop);
            } else {
                ak.c(this.ejn, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.ejr = voiceModel;
        if (this.ejr != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ob(this.ejr.elapse);
                return;
            }
            oc(this.ejr.voice_status.intValue());
            this.gzG.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gzG.lT();
            this.gzE.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ob(int i) {
        String formatVoiceTime;
        if (this.ejr != null && this.gzE != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.ejr.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ejr.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ejr.duration);
            }
            String a = k.a(this.gzE.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gzE.setText(formatVoiceTime);
            }
        }
    }

    public void oc(int i) {
        this.gzG.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mu(true);
            this.gzG.start();
            return;
        }
        this.gzG.lT();
        mu(false);
        if (i == 1) {
            if (this.ejr != null) {
                this.gzE.setText(VoiceManager.formatVoiceTime(this.ejr.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ejr != null) {
                this.gzE.setText(VoiceManager.formatVoiceTime(this.ejr.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.ejr != null && view2 == this.gzF) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.alg != null) {
                this.alg.onClick(this);
            }
            TiebaStatic.log(this.ejr.from);
        }
    }

    public void aza() {
        VoiceManager voiceManager;
        if (this.ejr != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mu(boolean z) {
        if (this.ejn != null) {
            if (z) {
                ak.c(this.ejn, d.f.icon_voice_stop);
            } else {
                ak.c(this.ejn, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cXj = voiceManager;
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
        return this.cXj;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.KE();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.KD() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.yw();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.KD();
            setVoiceModel(voiceModel);
            btb();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.ejr != voiceModel) {
                oc(1);
            } else {
                oc(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aX(int i) {
        if (!btd()) {
            oc(1);
            return;
        }
        ob(i);
        if (this.ejr != null) {
            this.ejr.elapse = i;
        }
    }

    private boolean btd() {
        if (this.ejr == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.ejr);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ejr;
    }

    public void aIT() {
        btb();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.ejr);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.ejr);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lZ() {
    }

    public void reset() {
        this.ejr = null;
        setTag(null);
        oc(1);
    }

    public void btf() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzG.getLayoutParams();
        layoutParams.width = -2;
        this.gzG.setLayoutParams(layoutParams);
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
        this.alg = onClickListener;
    }
}
