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
    private VoiceManager cYn;
    private ImageView ekr;
    private VoiceData.VoiceModel ekv;
    private TextView gAE;
    private RelativeLayout gAF;
    private AudioAnimationView gAG;
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
        if (this.gAE != null) {
            this.gAE.setTextSize(0, l.e(getContext(), i));
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
        this.gAF = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gAF.setOnClickListener(this);
        this.ekr = (ImageView) findViewById(d.g.playingImg);
        this.gAE = (TextView) findViewById(d.g.playTime);
        this.gAE.setPadding(l.e(getContext(), d.e.ds8), 0 - l.e(getContext(), d.e.ds6), 0, 0);
        this.gAG = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bsZ();
    }

    private void bsZ() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ak.i(this.gAF, d.f.btn_audio_frame_n);
        ak.c(this.gAE, d.C0126d.cp_cont_f, 1);
        if (this.play_type == 0) {
            btc();
            this.ekr.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gAG.onChangeSkinType(skinType);
    }

    private void btc() {
        if (this.ekr != null) {
            if (btb()) {
                ak.c(this.ekr, d.f.icon_voice_stop);
            } else {
                ak.c(this.ekr, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.ekv = voiceModel;
        if (this.ekv != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nZ(this.ekv.elapse);
                return;
            }
            oa(this.ekv.voice_status.intValue());
            this.gAG.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gAG.lS();
            this.gAE.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nZ(int i) {
        String formatVoiceTime;
        if (this.ekv != null && this.gAE != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.ekv.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ekv.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ekv.duration);
            }
            String a = k.a(this.gAE.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gAE.setText(formatVoiceTime);
            }
        }
    }

    public void oa(int i) {
        this.gAG.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mv(true);
            this.gAG.start();
            return;
        }
        this.gAG.lS();
        mv(false);
        if (i == 1) {
            if (this.ekv != null) {
                this.gAE.setText(VoiceManager.formatVoiceTime(this.ekv.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ekv != null) {
                this.gAE.setText(VoiceManager.formatVoiceTime(this.ekv.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.ekv != null && view2 == this.gAF) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.alg != null) {
                this.alg.onClick(this);
            }
            TiebaStatic.log(this.ekv.from);
        }
    }

    public void ayY() {
        VoiceManager voiceManager;
        if (this.ekv != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mv(boolean z) {
        if (this.ekr != null) {
            if (z) {
                ak.c(this.ekr, d.f.icon_voice_stop);
            } else {
                ak.c(this.ekr, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cYn = voiceManager;
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
        return this.cYn;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.KC();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.KB() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.yv();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.KB();
            setVoiceModel(voiceModel);
            bsZ();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.ekv != voiceModel) {
                oa(1);
            } else {
                oa(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aX(int i) {
        if (!btb()) {
            oa(1);
            return;
        }
        nZ(i);
        if (this.ekv != null) {
            this.ekv.elapse = i;
        }
    }

    private boolean btb() {
        if (this.ekv == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.ekv);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ekv;
    }

    public void aIS() {
        bsZ();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.ekv);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.ekv);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lY() {
    }

    public void reset() {
        this.ekv = null;
        setTag(null);
        oa(1);
    }

    public void btd() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gAG.getLayoutParams();
        layoutParams.width = -2;
        this.gAG.setLayoutParams(layoutParams);
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
