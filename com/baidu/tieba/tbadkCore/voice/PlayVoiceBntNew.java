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
    private static final int iJo = ((l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2)) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds10) * 2)) / 3;
    private View.OnClickListener bNx;
    private VoiceManager eYE;
    private ImageView gtS;
    private VoiceData.VoiceModel gtW;
    private TextView iJj;
    private RelativeLayout iJk;
    private AudioAnimationView iJl;
    private int iJm;
    private float iJn;
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
        this.iJm = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.iJm = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.iJj != null) {
            this.iJj.setTextSize(0, l.h(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt_new, (ViewGroup) this, true);
        this.iJk = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.iJk.setOnClickListener(this);
        this.gtS = (ImageView) findViewById(d.g.playingImg);
        this.iJj = (TextView) findViewById(d.g.playTime);
        this.iJl = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cfw();
    }

    private void cfw() {
        this.iJl.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gtW = voiceModel;
        if (this.gtW != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                up(this.gtW.elapse);
                return;
            }
            uq(this.gtW.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.iJm = (int) this.iJj.getPaint().measureText(formatVoiceTime);
            this.iJn = this.iJm + l.h(TbadkCoreApplication.getInst(), d.e.tbds58);
            this.iJl.setCertainColumnCount(getAudioVoiceColumnCount());
            this.iJl.ra();
            this.iJk.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.iJn, getPaddingBottom());
            this.iJj.setText(formatVoiceTime);
        }
    }

    public void up(int i) {
        String formatVoiceTime;
        if (this.gtW != null && this.iJj != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gtW.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gtW.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gtW.duration);
            }
            String a = k.a(this.iJj.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.iJj.setText(formatVoiceTime);
            }
        }
    }

    public void uq(int i) {
        this.iJl.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            qc(true);
            this.iJl.setVisibility(0);
            this.iJl.start();
            return;
        }
        this.iJl.ra();
        this.iJl.setVisibility(4);
        qc(false);
        if (i == 1) {
            if (this.gtW != null) {
                this.iJj.setText(VoiceManager.formatVoiceTime(this.gtW.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gtW != null) {
                this.iJj.setText(VoiceManager.formatVoiceTime(this.gtW.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gtW != null && view == this.iJk) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bNx != null) {
                this.bNx.onClick(this);
            }
            TiebaStatic.log(this.gtW.from);
        }
    }

    public void bol() {
        VoiceManager voiceManager;
        if (this.gtW != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void qc(boolean z) {
        if (this.gtS != null) {
            if (z) {
                al.c(this.gtS, d.f.icon_common_voice_pause);
            } else {
                al.c(this.gtS, d.f.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.eYE = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.aK(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.eYE;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.atq();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.atp() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.agk();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ae(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.atp();
            setVoiceModel(voiceModel);
            cfw();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gtW != voiceModel) {
                uq(1);
            } else {
                uq(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bs(int i) {
        if (!cfy()) {
            uq(1);
            return;
        }
        up(i);
        if (this.gtW != null) {
            this.gtW.elapse = i;
        }
    }

    private boolean cfy() {
        if (this.gtW == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gtW);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gtW;
    }

    public void bxS() {
        cfw();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gtW);
        }
        if ((i.aK(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gtW);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rg() {
    }

    public void reset() {
        this.gtW = null;
        setTag(null);
        uq(1);
    }

    public void cfz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJl.getLayoutParams();
        layoutParams.width = -2;
        this.iJl.setLayoutParams(layoutParams);
    }

    private int getAudioVoiceColumnCount() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return 0;
        }
        return f(voiceModel) / 10;
    }

    private int f(VoiceData.VoiceModel voiceModel) {
        double d;
        if (voiceModel.duration < 10) {
            d = iJo * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = iJo * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = iJo * 0.6d * 2.0d;
        } else {
            d = iJo * 2;
        }
        if (d < l.h(TbadkCoreApplication.getInst(), d.e.tbds216)) {
            d = l.h(TbadkCoreApplication.getInst(), d.e.tbds216);
        }
        double h = (d - this.iJn) - l.h(TbadkCoreApplication.getInst(), d.e.tbds75);
        if (h > 0.0d) {
            return (int) h;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNx = onClickListener;
    }
}
