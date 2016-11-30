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
import com.baidu.adp.base.h;
import com.baidu.adp.base.l;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.z;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aev;
    private VoiceManager bRV;
    private ProgressBar cub;
    private VoiceData.VoiceModel dtD;
    private ImageView dtz;
    private TextView fFp;
    private RelativeLayout fFr;
    private AudioAnimationView fFs;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fFt) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.fFp != null) {
            this.fFp.setTextSize(0, k.e(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        P(context);
        setOnClickListener(this);
    }

    public void P(Context context) {
        LayoutInflater.from(context).inflate(r.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.fFr = (RelativeLayout) findViewById(r.g.voice_image_content);
        this.fFr.setOnClickListener(this);
        this.dtz = (ImageView) findViewById(r.g.playingImg);
        this.fFp = (TextView) findViewById(r.g.playTime);
        this.fFp.setPadding(k.e(getContext(), r.e.ds6), 0 - k.e(getContext(), r.e.ds6), 0, 0);
        this.fFs = (AudioAnimationView) findViewById(r.g.audioAnimationView);
        this.cub = (ProgressBar) findViewById(r.g.progress);
        if (this.cub != null) {
            this.cub.setVisibility(4);
        }
        this.mContext = context;
        bnj();
    }

    private void bnj() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        at.k(this.fFr, r.f.btn_audio_frame_n);
        at.c(this.fFp, r.d.cp_cont_f, 1);
        if (this.play_type == 0) {
            bnm();
            this.dtz.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fFs.onChangeSkinType(skinType);
    }

    private void bnm() {
        if (this.dtz != null) {
            if (bnl()) {
                at.c(this.dtz, r.f.icon_voice_stop);
            } else {
                at.c(this.dtz, r.f.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dtD = voiceModel;
        if (this.dtD != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ml(this.dtD.elapse);
                return;
            }
            mm(this.dtD.voice_status.intValue());
            this.fFs.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fFs.btg();
            this.fFp.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void ml(int i) {
        String formatVoiceTime;
        if (this.dtD != null && this.fFp != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dtD.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dtD.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dtD.duration);
            }
            String a = j.a(this.fFp.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fFp.setText(formatVoiceTime);
            }
        }
    }

    public void mm(int i) {
        this.fFs.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.cub.setVisibility(4);
            lo(true);
            this.fFs.start();
            return;
        }
        this.fFs.btg();
        lo(false);
        if (i == 1) {
            if (this.dtD != null) {
                this.fFp.setText(VoiceManager.formatVoiceTime(this.dtD.duration));
            }
            this.cub.setVisibility(4);
        } else if (i == 2) {
            if (this.dtD != null) {
                this.fFp.setText(VoiceManager.formatVoiceTime(this.dtD.duration));
            }
            this.cub.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dtD != null && view == this.fFr) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aev != null) {
                this.aev.onClick(this);
            }
            TiebaStatic.log(this.dtD.from);
        }
    }

    private void lo(boolean z) {
        if (this.dtz != null) {
            if (z) {
                at.c(this.dtz, r.f.icon_voice_stop);
            } else {
                at.c(this.dtz, r.f.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bRV = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bRV;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof z)) {
            z zVar = (z) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) zVar.IW();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (zVar.IV() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = zVar.getMd5();
                voiceModel.duration = zVar.getDuration();
                zVar.G(voiceModel);
            }
            this.play_type = zVar.IV();
            setVoiceModel(voiceModel);
            bnj();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dtD != voiceModel) {
                mm(1);
            } else {
                mm(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!bnl()) {
            mm(1);
            return;
        }
        ml(i);
        if (this.dtD != null) {
            this.dtD.elapse = i;
        }
    }

    private boolean bnl() {
        if (this.dtD == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dtD);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dtD;
    }

    public void aEg() {
        bnj();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dtD);
        }
        if ((l.C(getContext()) instanceof h) && (tbPageContext = (TbPageContext) l.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dtD);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void lG() {
    }

    public void reset() {
        this.dtD = null;
        setTag(null);
        mm(1);
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
        this.aev = onClickListener;
    }
}
