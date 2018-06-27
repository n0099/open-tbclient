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
    private View.OnClickListener aua;
    private VoiceManager djz;
    private VoiceData.VoiceModel ezD;
    private ImageView ezz;
    private TextView gQh;
    private RelativeLayout gQi;
    private AudioAnimationView gQj;
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
        if (this.gQh != null) {
            this.gQh.setTextSize(0, l.e(getContext(), i));
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
        LayoutInflater.from(context).inflate(d.i.play_voice_bnt_new, (ViewGroup) this, true);
        this.gQi = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gQi.setOnClickListener(this);
        this.ezz = (ImageView) findViewById(d.g.playingImg);
        this.gQh = (TextView) findViewById(d.g.playTime);
        this.gQh.setPadding(l.e(getContext(), d.e.ds8), 0 - l.e(getContext(), d.e.ds6), 0, 0);
        this.gQj = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        byI();
    }

    private void byI() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.i(this.gQi, d.f.btn_audio_frame_n);
        am.c(this.gQh, d.C0142d.cp_cont_f, 1);
        if (this.play_type == 0) {
            byL();
            this.ezz.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gQj.onChangeSkinType(skinType);
    }

    private void byL() {
        if (this.ezz != null) {
            if (byK()) {
                am.c(this.ezz, d.f.icon_voice_stop);
            } else {
                am.c(this.ezz, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.ezD = voiceModel;
        if (this.ezD != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                os(this.ezD.elapse);
                return;
            }
            ot(this.ezD.voice_status.intValue());
            this.gQj.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gQj.oJ();
            this.gQh.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void os(int i) {
        String formatVoiceTime;
        if (this.ezD != null && this.gQh != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.ezD.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ezD.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.ezD.duration);
            }
            String a = k.a(this.gQh.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gQh.setText(formatVoiceTime);
            }
        }
    }

    public void ot(int i) {
        this.gQj.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mM(true);
            this.gQj.start();
            return;
        }
        this.gQj.oJ();
        mM(false);
        if (i == 1) {
            if (this.ezD != null) {
                this.gQh.setText(VoiceManager.formatVoiceTime(this.ezD.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.ezD != null) {
                this.gQh.setText(VoiceManager.formatVoiceTime(this.ezD.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ezD != null && view == this.gQi) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aua != null) {
                this.aua.onClick(this);
            }
            TiebaStatic.log(this.ezD.from);
        }
    }

    public void aED() {
        VoiceManager voiceManager;
        if (this.ezD != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mM(boolean z) {
        if (this.ezz != null) {
            if (z) {
                am.c(this.ezz, d.f.icon_voice_stop);
            } else {
                am.c(this.ezz, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.djz = voiceManager;
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
        return this.djz;
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
                voiceModel.voiceId = tbRichTextVoiceInfo.Cn();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.H(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Ot();
            setVoiceModel(voiceModel);
            byI();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.ezD != voiceModel) {
                ot(1);
            } else {
                ot(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aZ(int i) {
        if (!byK()) {
            ot(1);
            return;
        }
        os(i);
        if (this.ezD != null) {
            this.ezD.elapse = i;
        }
    }

    private boolean byK() {
        if (this.ezD == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.ezD);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.ezD;
    }

    public void aOt() {
        byI();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.ezD);
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.ezD);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    public void reset() {
        this.ezD = null;
        setTag(null);
        ot(1);
    }

    public void byM() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gQj.getLayoutParams();
        layoutParams.width = -2;
        this.gQj.setLayoutParams(layoutParams);
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
        this.aua = onClickListener;
    }
}
