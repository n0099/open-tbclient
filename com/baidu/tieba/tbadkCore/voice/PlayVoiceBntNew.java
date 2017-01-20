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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.r;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener acY;
    private VoiceManager bFE;
    private ProgressBar bkd;
    private ImageView dfI;
    private VoiceData.VoiceModel dfM;
    private TextView fsI;
    private RelativeLayout fsK;
    private AudioAnimationView fsL;
    private Context mContext;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY;

        /* JADX DEBUG: Replace access to removed values field (fsM) with 'values()' method */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.n.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.fsI != null) {
            this.fsI.setTextSize(0, k.e(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        N(context);
        setOnClickListener(this);
    }

    public void N(Context context) {
        LayoutInflater.from(context).inflate(r.j.play_voice_bnt_new, (ViewGroup) this, true);
        this.fsK = (RelativeLayout) findViewById(r.h.voice_image_content);
        this.fsK.setOnClickListener(this);
        this.dfI = (ImageView) findViewById(r.h.playingImg);
        this.fsI = (TextView) findViewById(r.h.playTime);
        this.fsI.setPadding(k.e(getContext(), r.f.ds6), 0 - k.e(getContext(), r.f.ds6), 0, 0);
        this.fsL = (AudioAnimationView) findViewById(r.h.audioAnimationView);
        this.bkd = (ProgressBar) findViewById(r.h.progress);
        if (this.bkd != null) {
            this.bkd.setVisibility(4);
        }
        this.mContext = context;
        biO();
    }

    private void biO() {
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        ap.j(this.fsK, r.g.btn_audio_frame_n);
        ap.c(this.fsI, r.e.cp_cont_f, 1);
        if (this.play_type == 0) {
            biR();
            this.dfI.setPadding(k.dip2px(getContext(), 12.0f), 0, 0, 0);
        }
        this.fsL.onChangeSkinType(skinType);
    }

    private void biR() {
        if (this.dfI != null) {
            if (biQ()) {
                ap.c(this.dfI, r.g.icon_voice_stop);
            } else {
                ap.c(this.dfI, r.g.icon_voice_play);
            }
        }
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.dfM = voiceModel;
        if (this.dfM != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                mi(this.dfM.elapse);
                return;
            }
            mj(this.dfM.voice_status.intValue());
            this.fsL.setCertainColumnCount(getAudioVoiceColumnCount());
            this.fsL.blL();
            this.fsI.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void mi(int i) {
        String formatVoiceTime;
        if (this.dfM != null && this.fsI != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.dfM.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dfM.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.dfM.duration);
            }
            String a = j.a(this.fsI.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.fsI.setText(formatVoiceTime);
            }
        }
    }

    public void mj(int i) {
        this.fsL.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.bkd.setVisibility(4);
            ll(true);
            this.fsL.start();
            return;
        }
        this.fsL.blL();
        ll(false);
        if (i == 1) {
            if (this.dfM != null) {
                this.fsI.setText(VoiceManager.formatVoiceTime(this.dfM.duration));
            }
            this.bkd.setVisibility(4);
        } else if (i == 2) {
            if (this.dfM != null) {
                this.fsI.setText(VoiceManager.formatVoiceTime(this.dfM.duration));
            }
            this.bkd.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dfM != null && view == this.fsK) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_PALY_VOICE_BTN_CLICKED));
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.acY != null) {
                this.acY.onClick(this);
            }
            TiebaStatic.log(this.dfM.from);
        }
    }

    private void ll(boolean z) {
        if (this.dfI != null) {
            if (z) {
                ap.c(this.dfI, r.g.icon_voice_stop);
            } else {
                ap.c(this.dfI, r.g.icon_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.bFE = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((com.baidu.adp.base.k.C(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.bFE;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.Ii();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.Ih() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.getMd5();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.G(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.Ih();
            setVoiceModel(voiceModel);
            biO();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.dfM != voiceModel) {
                mj(1);
            } else {
                mj(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void aS(int i) {
        if (!biQ()) {
            mj(1);
            return;
        }
        mi(i);
        if (this.dfM != null) {
            this.dfM.elapse = i;
        }
    }

    private boolean biQ() {
        if (this.dfM == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.dfM);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        k.m(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.dfM;
    }

    public void ayK() {
        biO();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.dfM);
        }
        if ((com.baidu.adp.base.k.C(getContext()) instanceof g) && (tbPageContext = (TbPageContext) com.baidu.adp.base.k.C(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.dfM);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void ly() {
    }

    public void reset() {
        this.dfM = null;
        setTag(null);
        mj(1);
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
        this.acY = onClickListener;
    }
}
