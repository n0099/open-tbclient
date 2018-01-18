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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aXV;
    private VoiceManager dBh;
    private ImageView eJT;
    private VoiceData.VoiceModel eJX;
    private TextView hbt;
    private RelativeLayout hbv;
    private AudioAnimationView hbw;
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
        if (this.hbt != null) {
            this.hbt.setTextSize(0, l.s(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        av(context);
        setOnClickListener(this);
    }

    public void av(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.hbv = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.hbv.setOnClickListener(this);
        this.eJT = (ImageView) findViewById(d.g.playingImg);
        this.hbt = (TextView) findViewById(d.g.playTime);
        this.hbt.setPadding(l.s(getContext(), d.e.ds8), 0 - l.s(getContext(), d.e.ds6), 0, 0);
        this.hbw = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bwL();
    }

    private void bwL() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.s(this.hbv, d.f.btn_audio_frame_n);
        aj.e(this.hbt, d.C0107d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bwO();
            this.eJT.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.hbw.onChangeSkinType(skinType);
    }

    private void bwO() {
        if (this.eJT != null) {
            if (bwN()) {
                aj.c(this.eJT, d.f.icon_voice_stop);
            } else {
                aj.c(this.eJT, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.eJX = voiceModel;
        if (this.eJX != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qD(this.eJX.elapse);
                return;
            }
            qE(this.eJX.voice_status.intValue());
            this.hbw.setCertainColumnCount(getAudioVoiceColumnCount());
            this.hbw.tn();
            this.hbt.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qD(int i) {
        String formatVoiceTime;
        if (this.eJX != null && this.hbt != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.eJX.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eJX.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.eJX.duration);
            }
            String a = k.a(this.hbt.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hbt.setText(formatVoiceTime);
            }
        }
    }

    public void qE(int i) {
        this.hbw.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mD(true);
            this.hbw.start();
            return;
        }
        this.hbw.tn();
        mD(false);
        if (i == 1) {
            if (this.eJX != null) {
                this.hbt.setText(VoiceManager.formatVoiceTime(this.eJX.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.eJX != null) {
                this.hbt.setText(VoiceManager.formatVoiceTime(this.eJX.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eJX != null && view == this.hbv) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aXV != null) {
                this.aXV.onClick(this);
            }
            TiebaStatic.log(this.eJX.from);
        }
    }

    public void aCB() {
        VoiceManager voiceManager;
        if (this.eJX != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mD(boolean z) {
        if (this.eJT != null) {
            if (z) {
                aj.c(this.eJT, d.f.icon_voice_stop);
            } else {
                aj.c(this.eJT, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dBh = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dBh;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ry();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Rx() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.Fl();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.aJ(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Rx();
            setVoiceModel(voiceModel);
            bwL();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.eJX != voiceModel) {
                qE(1);
            } else {
                qE(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void dT(int i) {
        if (!bwN()) {
            qE(1);
            return;
        }
        qD(i);
        if (this.eJX != null) {
            this.eJX.elapse = i;
        }
    }

    private boolean bwN() {
        if (this.eJX == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.eJX);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.J(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.eJX;
    }

    public void bnf() {
        bwL();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.eJX);
        }
        if ((i.ak(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ak(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.eJX);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void tt() {
    }

    public void reset() {
        this.eJX = null;
        setTag(null);
        qE(1);
    }

    public void bwP() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hbw.getLayoutParams();
        layoutParams.width = -2;
        this.hbw.setLayoutParams(layoutParams);
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
        this.aXV = onClickListener;
    }
}
