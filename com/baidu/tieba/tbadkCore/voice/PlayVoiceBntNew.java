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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener ajG;
    private VoiceManager cpd;
    private ImageView dID;
    private VoiceData.VoiceModel dIH;
    private TextView glp;
    private RelativeLayout glr;
    private AudioAnimationView gls;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.n.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.glp != null) {
            this.glp.setTextSize(0, k.g(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        ai(context);
        setOnClickListener(this);
    }

    public void ai(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.glr = (RelativeLayout) findViewById(d.h.voice_image_content);
        this.glr.setOnClickListener(this);
        this.dID = (ImageView) findViewById(d.h.playingImg);
        this.glp = (TextView) findViewById(d.h.playTime);
        this.glp.setPadding(k.g(getContext(), d.f.ds6), 0 - k.g(getContext(), d.f.ds6), 0, 0);
        this.gls = (AudioAnimationView) findViewById(d.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        btp();
    }

    private void btp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.glr, d.g.btn_audio_frame_n);
        aj.c(this.glp, d.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            bts();
            this.dID.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.gls.onChangeSkinType(skinType);
    }

    private void bts() {
        if (this.dID != null) {
            if (btr()) {
                aj.c(this.dID, d.g.icon_voice_stop);
            } else {
                aj.c(this.dID, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dIH = voiceModel;
        if (this.dIH != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ni(this.dIH.elapse);
                return;
            }
            nj(this.dIH.voice_status.intValue());
            this.gls.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gls.bwt();
            this.glp.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ni(int i) {
        String formatVoiceTime;
        if (this.dIH != null && this.glp != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dIH.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dIH.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dIH.duration);
            }
            String a = j.a(this.glp.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.glp.setText(formatVoiceTime);
            }
        }
    }

    public void nj(int i) {
        this.gls.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mK(true);
            this.gls.start();
            return;
        }
        this.gls.bwt();
        mK(false);
        if (i == 1) {
            if (this.dIH != null) {
                this.glp.setText(VoiceManager.formatVoiceTime(this.dIH.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dIH != null) {
                this.glp.setText(VoiceManager.formatVoiceTime(this.dIH.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dIH != null && view == this.glr) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajG != null) {
                this.ajG.onClick(this);
            }
            TiebaStatic.log(this.dIH.from);
        }
    }

    private void mK(boolean z) {
        if (this.dID != null) {
            if (z) {
                aj.c(this.dID, d.g.icon_voice_stop);
            } else {
                aj.c(this.dID, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cpd = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.X(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.X(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.cpd;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Jp();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Jo() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.ym();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.F(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Jo();
            setVoiceModel(voiceModel);
            btp();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dIH != voiceModel) {
                nj(1);
            } else {
                nj(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (!btr()) {
            nj(1);
            return;
        }
        ni(i);
        if (this.dIH != null) {
            this.dIH.elapse = i;
        }
    }

    private boolean btr() {
        if (this.dIH == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dIH);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dIH;
    }

    public void bhr() {
        btp();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dIH);
        }
        if ((i.X(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.X(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dIH);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lR() {
    }

    public void reset() {
        this.dIH = null;
        setTag(null);
        nj(1);
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
        this.ajG = onClickListener;
    }
}
