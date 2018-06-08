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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener ato;
    private VoiceManager dhB;
    private ImageView evI;
    private VoiceData.VoiceModel evM;
    private TextView gMf;
    private RelativeLayout gMg;
    private AudioAnimationView gMh;
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
        if (this.gMf != null) {
            this.gMf.setTextSize(0, l.e(getContext(), i));
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
        this.gMg = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.gMg.setOnClickListener(this);
        this.evI = (ImageView) findViewById(d.g.playingImg);
        this.gMf = (TextView) findViewById(d.g.playTime);
        this.gMf.setPadding(l.e(getContext(), d.e.ds8), 0 - l.e(getContext(), d.e.ds6), 0, 0);
        this.gMh = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bye();
    }

    private void bye() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.i(this.gMg, d.f.btn_audio_frame_n);
        al.c(this.gMf, d.C0141d.cp_cont_f, 1);
        if (this.play_type == 0) {
            byh();
            this.evI.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        this.gMh.onChangeSkinType(skinType);
    }

    private void byh() {
        if (this.evI != null) {
            if (byg()) {
                al.c(this.evI, d.f.icon_voice_stop);
            } else {
                al.c(this.evI, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.evM = voiceModel;
        if (this.evM != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ol(this.evM.elapse);
                return;
            }
            om(this.evM.voice_status.intValue());
            this.gMh.setCertainColumnCount(getAudioVoiceColumnCount());
            this.gMh.oJ();
            this.gMf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ol(int i) {
        String formatVoiceTime;
        if (this.evM != null && this.gMf != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.evM.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.evM.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.evM.duration);
            }
            String a = k.a(this.gMf.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.gMf.setText(formatVoiceTime);
            }
        }
    }

    public void om(int i) {
        this.gMh.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            mB(true);
            this.gMh.start();
            return;
        }
        this.gMh.oJ();
        mB(false);
        if (i == 1) {
            if (this.evM != null) {
                this.gMf.setText(VoiceManager.formatVoiceTime(this.evM.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.evM != null) {
                this.gMf.setText(VoiceManager.formatVoiceTime(this.evM.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.evM != null && view == this.gMg) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ato != null) {
                this.ato.onClick(this);
            }
            TiebaStatic.log(this.evM.from);
        }
    }

    public void aDT() {
        VoiceManager voiceManager;
        if (this.evM != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void mB(boolean z) {
        if (this.evI != null) {
            if (z) {
                al.c(this.evI, d.f.icon_voice_stop);
            } else {
                al.c(this.evI, d.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dhB = voiceManager;
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
        return this.dhB;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ob();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Oa() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.BV();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.H(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Oa();
            setVoiceModel(voiceModel);
            bye();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.evM != voiceModel) {
                om(1);
            } else {
                om(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aZ(int i) {
        if (!byg()) {
            om(1);
            return;
        }
        ol(i);
        if (this.evM != null) {
            this.evM.elapse = i;
        }
    }

    private boolean byg() {
        if (this.evM == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.evM);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.showLongToast(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.evM;
    }

    public void aNN() {
        bye();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.evM);
        }
        if ((i.ad(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ad(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.evM);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void oP() {
    }

    public void reset() {
        this.evM = null;
        setTag(null);
        om(1);
    }

    public void byi() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gMh.getLayoutParams();
        layoutParams.width = -2;
        this.gMh.setLayoutParams(layoutParams);
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
        this.ato = onClickListener;
    }
}
