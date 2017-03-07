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
    private View.OnClickListener aio;
    private VoiceManager bMM;
    private ProgressBar bqO;
    private ImageView dhZ;
    private VoiceData.VoiceModel did;
    private TextView fxf;
    private RelativeLayout fxh;
    private AudioAnimationView fxi;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fxj) with 'values()' method */
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
        if (this.fxf != null) {
            this.fxf.setTextSize(0, k.g(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        al(context);
        setOnClickListener(this);
    }

    public void al(Context context) {
        LayoutInflater.from(context).inflate(w.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.fxh = (RelativeLayout) findViewById(w.h.voice_image_content);
        this.fxh.setOnClickListener(this);
        this.dhZ = (ImageView) findViewById(w.h.playingImg);
        this.fxf = (TextView) findViewById(w.h.playTime);
        this.fxf.setPadding(k.g(getContext(), w.f.ds6), 0 - k.g(getContext(), w.f.ds6), 0, 0);
        this.fxi = (AudioAnimationView) findViewById(w.h.audioAnimationView);
        this.bqO = (ProgressBar) findViewById(w.h.progress);
        if (this.bqO != null) {
            this.bqO.setVisibility(4);
        }
        this.mContext = context;
        biE();
    }

    private void biE() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        aq.j(this.fxh, w.g.btn_audio_frame_n);
        aq.c(this.fxf, w.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            biH();
            this.dhZ.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fxi.onChangeSkinType(skinType);
    }

    private void biH() {
        if (this.dhZ != null) {
            if (biG()) {
                aq.c(this.dhZ, w.g.icon_voice_stop);
            } else {
                aq.c(this.dhZ, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.did = voiceModel;
        if (this.did != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                lY(this.did.elapse);
                return;
            }
            lZ(this.did.voice_status.intValue());
            this.fxi.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fxi.blA();
            this.fxf.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void lY(int i) {
        String formatVoiceTime;
        if (this.did != null && this.fxf != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.did.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.did.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.did.duration);
            }
            String a = j.a(this.fxf.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fxf.setText(formatVoiceTime);
            }
        }
    }

    public void lZ(int i) {
        this.fxi.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.bqO.setVisibility(4);
            lk(true);
            this.fxi.start();
            return;
        }
        this.fxi.blA();
        lk(false);
        if (i == 1) {
            if (this.did != null) {
                this.fxf.setText(VoiceManager.formatVoiceTime(this.did.duration));
            }
            this.bqO.setVisibility(4);
        } else if (i == 2) {
            if (this.did != null) {
                this.fxf.setText(VoiceManager.formatVoiceTime(this.did.duration));
            }
            this.bqO.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.did != null && view == this.fxh) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aio != null) {
                this.aio.onClick(this);
            }
            TiebaStatic.log(this.did.from);
        }
    }

    private void lk(boolean z) {
        if (this.dhZ != null) {
            if (z) {
                aq.c(this.dhZ, w.g.icon_voice_stop);
            } else {
                aq.c(this.dhZ, w.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bMM = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.k.aa(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.aa(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bMM;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.II();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.IH() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.IH();
            setVoiceModel(voiceModel);
            biE();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.did != voiceModel) {
                lZ(1);
            } else {
                lZ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!biG()) {
            lZ(1);
            return;
        }
        lY(i);
        if (this.did != null) {
            this.did.elapse = i;
        }
    }

    private boolean biG() {
        if (this.did == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.did);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.G(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.did;
    }

    public void ayg() {
        biE();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.did);
        }
        if ((com.baidu.adp.base.k.aa(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.aa(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.did);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ms() {
    }

    public void reset() {
        this.did = null;
        setTag(null);
        lZ(1);
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
        this.aio = onClickListener;
    }
}
