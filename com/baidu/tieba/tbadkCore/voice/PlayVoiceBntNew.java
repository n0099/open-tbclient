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
    private ImageView eSl;
    private VoiceData.VoiceModel eSp;
    private TextView hgj;
    private RelativeLayout hgk;
    private AudioAnimationView hgl;
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
        if (this.hgj != null) {
            this.hgj.setTextSize(0, l.h(getContext(), i));
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
        this.hgk = (RelativeLayout) findViewById(e.g.voice_image_content);
        this.hgk.setOnClickListener(this);
        this.eSl = (ImageView) findViewById(e.g.playingImg);
        this.hgj = (TextView) findViewById(e.g.playTime);
        this.hgj.setPadding(l.h(getContext(), e.C0175e.ds8), 0 - l.h(getContext(), e.C0175e.ds6), 0, 0);
        this.hgl = (AudioAnimationView) findViewById(e.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bDi();
    }

    private void bDi() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.hgk, e.f.btn_audio_frame_n);
        al.c(this.hgj, e.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bDl();
            this.eSl.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hgl.onChangeSkinType(skinType);
    }

    private void bDl() {
        if (this.eSl != null) {
            if (bDk()) {
                al.c(this.eSl, e.f.icon_voice_stop);
            } else {
                al.c(this.eSl, e.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eSp = voiceModel;
        if (this.eSp != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                pI(this.eSp.elapse);
                return;
            }
            pJ(this.eSp.voice_status.intValue());
            this.hgl.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hgl.pW();
            this.hgj.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void pI(int i) {
        String formatVoiceTime;
        if (this.eSp != null && this.hgj != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eSp.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eSp.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eSp.duration);
            }
            String a = k.a(this.hgj.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hgj.setText(formatVoiceTime);
            }
        }
    }

    public void pJ(int i) {
        this.hgl.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            nl(true);
            this.hgl.start();
            return;
        }
        this.hgl.pW();
        nl(false);
        if (i == 1) {
            if (this.eSp != null) {
                this.hgj.setText(VoiceManager.formatVoiceTime(this.eSp.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eSp != null) {
                this.hgj.setText(VoiceManager.formatVoiceTime(this.eSp.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eSp != null && view == this.hgk) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aAK != null) {
                this.aAK.onClick(this);
            }
            TiebaStatic.log(this.eSp.from);
        }
    }

    public void aLh() {
        VoiceManager voiceManager;
        if (this.eSp != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void nl(boolean z) {
        if (this.eSl != null) {
            if (z) {
                al.c(this.eSl, e.f.icon_voice_stop);
            } else {
                al.c(this.eSl, e.f.icon_voice_play);
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
            if (this.eSp != voiceModel) {
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
        if (this.eSp != null) {
            this.eSp.elapse = i;
        }
    }

    private boolean bDk() {
        if (this.eSp == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eSp);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eSp;
    }

    public void aUR() {
        bDi();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eSp);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eSp);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qc() {
    }

    public void reset() {
        this.eSp = null;
        setTag(null);
        pJ(1);
    }

    public void bDm() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hgl.getLayoutParams();
        layoutParams.width = -2;
        this.hgl.setLayoutParams(layoutParams);
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
