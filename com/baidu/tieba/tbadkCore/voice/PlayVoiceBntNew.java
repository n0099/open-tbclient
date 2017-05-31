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
import com.baidu.adp.base.g;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.view.AudioAnimationView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener ahN;
    private VoiceManager bTZ;
    private ImageView din;
    private VoiceData.VoiceModel dir;
    private TextView fFg;
    private RelativeLayout fFi;
    private AudioAnimationView fFj;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fFk) with 'values()' method */
        /* renamed from: values  reason: to resolve conflict with enum method */
        public static PLAY_TYPE[] valuesCustom() {
            PLAY_TYPE[] valuesCustom = values();
            int length = valuesCustom.length;
            PLAY_TYPE[] play_typeArr = new PLAY_TYPE[length];
            System.arraycopy(valuesCustom, 0, play_typeArr, 0, length);
            return play_typeArr;
        }
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, w.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.fFg != null) {
            this.fFg.setTextSize(0, k.g(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        ak(context);
        setOnClickListener(this);
    }

    public void ak(Context context) {
        LayoutInflater.from(context).inflate(w.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.fFi = (RelativeLayout) findViewById(w.h.voice_image_content);
        this.fFi.setOnClickListener(this);
        this.din = (ImageView) findViewById(w.h.playingImg);
        this.fFg = (TextView) findViewById(w.h.playTime);
        this.fFg.setPadding(k.g(getContext(), w.f.ds6), 0 - k.g(getContext(), w.f.ds6), 0, 0);
        this.fFj = (AudioAnimationView) findViewById(w.h.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(w.h.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bjh();
    }

    private void bjh() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        aq.j(this.fFi, w.g.btn_audio_frame_n);
        aq.c(this.fFg, w.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            bjk();
            this.din.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fFj.onChangeSkinType(skinType);
    }

    private void bjk() {
        if (this.din != null) {
            if (bjj()) {
                aq.c(this.din, w.g.icon_voice_stop);
            } else {
                aq.c(this.din, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dir = voiceModel;
        if (this.dir != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mm(this.dir.elapse);
                return;
            }
            mn(this.dir.voice_status.intValue());
            this.fFj.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fFj.bmp();
            this.fFg.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mm(int i) {
        String formatVoiceTime;
        if (this.dir != null && this.fFg != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dir.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dir.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dir.duration);
            }
            String a = j.a(this.fFg.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fFg.setText(formatVoiceTime);
            }
        }
    }

    public void mn(int i) {
        this.fFj.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            lw(true);
            this.fFj.start();
            return;
        }
        this.fFj.bmp();
        lw(false);
        if (i == 1) {
            if (this.dir != null) {
                this.fFg.setText(VoiceManager.formatVoiceTime(this.dir.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.dir != null) {
                this.fFg.setText(VoiceManager.formatVoiceTime(this.dir.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dir != null && view == this.fFi) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.ahN != null) {
                this.ahN.onClick(this);
            }
            TiebaStatic.log(this.dir.from);
        }
    }

    private void lw(boolean z) {
        if (this.din != null) {
            if (z) {
                aq.c(this.din, w.g.icon_voice_stop);
            } else {
                aq.c(this.din, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bTZ = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.k.Z(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bTZ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Iq();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Ip() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Ip();
            setVoiceModel(voiceModel);
            bjh();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dir != voiceModel) {
                mn(1);
            } else {
                mn(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aP(int i) {
        if (!bjj()) {
            mn(1);
            return;
        }
        mm(i);
        if (this.dir != null) {
            this.dir.elapse = i;
        }
    }

    private boolean bjj() {
        if (this.dir == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dir);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dir;
    }

    public void aZV() {
        bjh();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dir);
        }
        if ((com.baidu.adp.base.k.Z(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.Z(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dir);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lV() {
    }

    public void reset() {
        this.dir = null;
        setTag(null);
        mn(1);
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
        this.ahN = onClickListener;
    }
}
