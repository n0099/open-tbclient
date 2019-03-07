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
    private static final int iJJ = ((l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2)) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds10) * 2)) / 3;
    private View.OnClickListener bNt;
    private VoiceManager eYS;
    private ImageView gue;
    private VoiceData.VoiceModel gui;
    private TextView iJE;
    private RelativeLayout iJF;
    private AudioAnimationView iJG;
    private int iJH;
    private float iJI;
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
        this.iJH = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.iJH = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.iJE != null) {
            this.iJE.setTextSize(0, l.h(getContext(), i));
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
        this.iJF = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.iJF.setOnClickListener(this);
        this.gue = (ImageView) findViewById(d.g.playingImg);
        this.iJE = (TextView) findViewById(d.g.playTime);
        this.iJG = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cfx();
    }

    private void cfx() {
        this.iJG.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gui = voiceModel;
        if (this.gui != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ut(this.gui.elapse);
                return;
            }
            uu(this.gui.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.iJH = (int) this.iJE.getPaint().measureText(formatVoiceTime);
            this.iJI = this.iJH + l.h(TbadkCoreApplication.getInst(), d.e.tbds58);
            this.iJG.setCertainColumnCount(getAudioVoiceColumnCount());
            this.iJG.ra();
            this.iJF.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.iJI, getPaddingBottom());
            this.iJE.setText(formatVoiceTime);
        }
    }

    public void ut(int i) {
        String formatVoiceTime;
        if (this.gui != null && this.iJE != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gui.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gui.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gui.duration);
            }
            String a = k.a(this.iJE.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.iJE.setText(formatVoiceTime);
            }
        }
    }

    public void uu(int i) {
        this.iJG.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            qc(true);
            this.iJG.setVisibility(0);
            this.iJG.start();
            return;
        }
        this.iJG.ra();
        this.iJG.setVisibility(4);
        qc(false);
        if (i == 1) {
            if (this.gui != null) {
                this.iJE.setText(VoiceManager.formatVoiceTime(this.gui.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gui != null) {
                this.iJE.setText(VoiceManager.formatVoiceTime(this.gui.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gui != null && view == this.iJF) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bNt != null) {
                this.bNt.onClick(this);
            }
            TiebaStatic.log(this.gui.from);
        }
    }

    public void boo() {
        VoiceManager voiceManager;
        if (this.gui != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void qc(boolean z) {
        if (this.gue != null) {
            if (z) {
                al.c(this.gue, d.f.icon_common_voice_pause);
            } else {
                al.c(this.gue, d.f.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.eYS = voiceManager;
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
        return this.eYS;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.att();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.ats() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.agn();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.ats();
            setVoiceModel(voiceModel);
            cfx();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gui != voiceModel) {
                uu(1);
            } else {
                uu(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bt(int i) {
        if (!cfz()) {
            uu(1);
            return;
        }
        ut(i);
        if (this.gui != null) {
            this.gui.elapse = i;
        }
    }

    private boolean cfz() {
        if (this.gui == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gui);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gui;
    }

    public void bxV() {
        cfx();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gui);
        }
        if ((i.aK(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gui);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rg() {
    }

    public void reset() {
        this.gui = null;
        setTag(null);
        uu(1);
    }

    public void cfA() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJG.getLayoutParams();
        layoutParams.width = -2;
        this.iJG.setLayoutParams(layoutParams);
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
            d = iJJ * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = iJJ * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = iJJ * 0.6d * 2.0d;
        } else {
            d = iJJ * 2;
        }
        if (d < l.h(TbadkCoreApplication.getInst(), d.e.tbds216)) {
            d = l.h(TbadkCoreApplication.getInst(), d.e.tbds216);
        }
        double h = (d - this.iJI) - l.h(TbadkCoreApplication.getInst(), d.e.tbds75);
        if (h > 0.0d) {
            return (int) h;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
    }
}
