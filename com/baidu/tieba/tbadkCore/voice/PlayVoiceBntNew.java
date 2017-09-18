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
    private View.OnClickListener ajF;
    private VoiceManager cpV;
    private VoiceData.VoiceModel dJC;
    private ImageView dJy;
    private TextView gmj;
    private RelativeLayout gml;
    private AudioAnimationView gmm;
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
        if (this.gmj != null) {
            this.gmj.setTextSize(0, k.f(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        aj(context);
        setOnClickListener(this);
    }

    public void aj(Context context) {
        LayoutInflater.from(context).inflate(d.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.gml = (RelativeLayout) findViewById(d.h.voice_image_content);
        this.gml.setOnClickListener(this);
        this.dJy = (ImageView) findViewById(d.h.playingImg);
        this.gmj = (TextView) findViewById(d.h.playTime);
        this.gmj.setPadding(k.f(getContext(), d.f.ds6), 0 - k.f(getContext(), d.f.ds6), 0, 0);
        this.gmm = (AudioAnimationView) findViewById(d.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        btA();
    }

    private void btA() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.gml, d.g.btn_audio_frame_n);
        aj.c(this.gmj, d.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            btD();
            this.dJy.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.gmm.onChangeSkinType(skinType);
    }

    private void btD() {
        if (this.dJy != null) {
            if (btC()) {
                aj.c(this.dJy, d.g.icon_voice_stop);
            } else {
                aj.c(this.dJy, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dJC = voiceModel;
        if (this.dJC != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nk(this.dJC.elapse);
                return;
            }
            nl(this.dJC.voice_status.intValue());
            this.gmm.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gmm.bwE();
            this.gmj.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nk(int i) {
        String formatVoiceTime;
        if (this.dJC != null && this.gmj != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dJC.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dJC.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dJC.duration);
            }
            String a = j.a(this.gmj.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gmj.setText(formatVoiceTime);
            }
        }
    }

    public void nl(int i) {
        this.gmm.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mL(true);
            this.gmm.start();
            return;
        }
        this.gmm.bwE();
        mL(false);
        if (i == 1) {
            if (this.dJC != null) {
                this.gmj.setText(VoiceManager.formatVoiceTime(this.dJC.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dJC != null) {
                this.gmj.setText(VoiceManager.formatVoiceTime(this.dJC.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dJC != null && view == this.gml) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajF != null) {
                this.ajF.onClick(this);
            }
            TiebaStatic.log(this.dJC.from);
        }
    }

    private void mL(boolean z) {
        if (this.dJy != null) {
            if (z) {
                aj.c(this.dJy, d.g.icon_voice_stop);
            } else {
                aj.c(this.dJy, d.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cpV = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.cpV;
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
            btA();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dJC != voiceModel) {
                nl(1);
            } else {
                nl(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aO(int i) {
        if (!btC()) {
            nl(1);
            return;
        }
        nk(i);
        if (this.dJC != null) {
            this.dJC.elapse = i;
        }
    }

    private boolean btC() {
        if (this.dJC == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dJC);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dJC;
    }

    public void bhC() {
        btA();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dJC);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dJC);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lR() {
    }

    public void reset() {
        this.dJC = null;
        setTag(null);
        nl(1);
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
        this.ajF = onClickListener;
    }
}
