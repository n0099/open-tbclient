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
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.e;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aAK;
    private VoiceManager dAm;
    private ImageView eSm;
    private VoiceData.VoiceModel eSq;
    private TextView hgk;
    private RelativeLayout hgl;
    private AudioAnimationView hgm;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(e.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.hgk != null) {
            this.hgk.setTextSize(0, l.h(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(e.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.hgl = (RelativeLayout) findViewById(e.g.voice_image_content);
        this.hgl.setOnClickListener(this);
        this.eSm = (ImageView) findViewById(e.g.playingImg);
        this.hgk = (TextView) findViewById(e.g.playTime);
        this.hgk.setPadding(l.h(getContext(), e.C0175e.ds8), 0 - l.h(getContext(), e.C0175e.ds6), 0, 0);
        this.hgm = (AudioAnimationView) findViewById(e.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bDi();
    }

    private void bDi() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.hgl, e.f.btn_audio_frame_n);
        al.c(this.hgk, e.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bDl();
            this.eSm.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hgm.onChangeSkinType(skinType);
    }

    private void bDl() {
        if (this.eSm != null) {
            if (bDk()) {
                al.c(this.eSm, e.f.icon_voice_stop);
            } else {
                al.c(this.eSm, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eSq = voiceModel;
        if (this.eSq != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                pI(this.eSq.elapse);
                return;
            }
            pJ(this.eSq.voice_status.intValue());
            this.hgm.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hgm.pW();
            this.hgk.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void pI(int i) {
        String formatVoiceTime;
        if (this.eSq != null && this.hgk != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eSq.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eSq.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eSq.duration);
            }
            String a = k.a(this.hgk.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hgk.setText(formatVoiceTime);
            }
        }
    }

    public void pJ(int i) {
        this.hgm.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nl(true);
            this.hgm.start();
            return;
        }
        this.hgm.pW();
        nl(false);
        if (i == 1) {
            if (this.eSq != null) {
                this.hgk.setText(VoiceManager.formatVoiceTime(this.eSq.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eSq != null) {
                this.hgk.setText(VoiceManager.formatVoiceTime(this.eSq.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eSq != null && view == this.hgl) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aAK != null) {
                this.aAK.onClick(this);
            }
            TiebaStatic.log(this.eSq.from);
        }
    }

    public void aLh() {
        VoiceManager voiceManager;
        if (this.eSq != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void nl(boolean z) {
        if (this.eSm != null) {
            if (z) {
                al.c(this.eSm, e.f.icon_voice_stop);
            } else {
                al.c(this.eSm, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dAm = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dAm;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.RH();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.RG() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Fq();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.RG();
            setVoiceModel(voiceModel);
            bDi();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eSq != voiceModel) {
                pJ(1);
            } else {
                pJ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bk(int i) {
        if (!bDk()) {
            pJ(1);
            return;
        }
        pI(i);
        if (this.eSq != null) {
            this.eSq.elapse = i;
        }
    }

    private boolean bDk() {
        if (this.eSq == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eSq);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eSq;
    }

    public void aUR() {
        bDi();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eSq);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eSq);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qc() {
    }

    public void reset() {
        this.eSq = null;
        setTag(null);
        pJ(1);
    }

    public void bDm() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgm.getLayoutParams();
        layoutParams.width = -2;
        this.hgm.setLayoutParams(layoutParams);
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
        this.aAK = onClickListener;
    }
}
