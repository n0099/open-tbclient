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
    private View.OnClickListener ajr;
    private VoiceManager cxA;
    private ImageView dNn;
    private VoiceData.VoiceModel dNr;
    private TextView gsr;
    private RelativeLayout gst;
    private AudioAnimationView gsu;
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
        if (this.gsr != null) {
            this.gsr.setTextSize(0, l.f(getContext(), i));
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
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.gst = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gst.setOnClickListener(this);
        this.dNn = (ImageView) findViewById(d.g.playingImg);
        this.gsr = (TextView) findViewById(d.g.playTime);
        this.gsr.setPadding(l.f(getContext(), d.e.ds8), 0 - l.f(getContext(), d.e.ds6), 0, 0);
        this.gsu = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bvu();
    }

    private void bvu() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        aj.j(this.gst, d.f.btn_audio_frame_n);
        aj.c(this.gsr, d.C0080d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bvx();
            this.dNn.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gsu.onChangeSkinType(skinType);
    }

    private void bvx() {
        if (this.dNn != null) {
            if (bvw()) {
                aj.c(this.dNn, d.f.icon_voice_stop);
            } else {
                aj.c(this.dNn, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dNr = voiceModel;
        if (this.dNr != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                nw(this.dNr.elapse);
                return;
            }
            nx(this.dNr.voice_status.intValue());
            this.gsu.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gsu.bBg();
            this.gsr.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void nw(int i) {
        String formatVoiceTime;
        if (this.dNr != null && this.gsr != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dNr.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dNr.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dNr.duration);
            }
            String a = k.a(this.gsr.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gsr.setText(formatVoiceTime);
            }
        }
    }

    public void nx(int i) {
        this.gsu.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mA(true);
            this.gsu.start();
            return;
        }
        this.gsu.bBg();
        mA(false);
        if (i == 1) {
            if (this.dNr != null) {
                this.gsr.setText(VoiceManager.formatVoiceTime(this.dNr.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dNr != null) {
                this.gsr.setText(VoiceManager.formatVoiceTime(this.dNr.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dNr != null && view == this.gst) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ajr != null) {
                this.ajr.onClick(this);
            }
            TiebaStatic.log(this.dNr.from);
        }
    }

    private void mA(boolean z) {
        if (this.dNn != null) {
            if (z) {
                aj.c(this.dNn, d.f.icon_voice_stop);
            } else {
                aj.c(this.dNn, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.cxA = voiceManager;
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
        return this.cxA;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.JC();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.JB() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.xL();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.E(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.JB();
            setVoiceModel(voiceModel);
            bvu();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dNr != voiceModel) {
                nx(1);
            } else {
                nx(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aR(int i) {
        if (!bvw()) {
            nx(1);
            return;
        }
        nw(i);
        if (this.dNr != null) {
            this.dNr.elapse = i;
        }
    }

    private boolean bvw() {
        if (this.dNr == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dNr);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.F(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dNr;
    }

    public void bjo() {
        bvu();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dNr);
        }
        if ((i.Y(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.Y(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dNr);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lN() {
    }

    public void reset() {
        this.dNr = null;
        setTag(null);
        nx(1);
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
        this.ajr = onClickListener;
    }
}
