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
    private static final int iJK = ((l.aO(TbadkCoreApplication.getInst()) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds44) * 2)) - (l.h(TbadkCoreApplication.getInst(), d.e.tbds10) * 2)) / 3;
    private View.OnClickListener bNt;
    private VoiceManager eYS;
    private ImageView guf;
    private VoiceData.VoiceModel guj;
    private TextView iJF;
    private RelativeLayout iJG;
    private AudioAnimationView iJH;
    private int iJI;
    private float iJJ;
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
        this.iJI = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.iJI = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.iJF != null) {
            this.iJF.setTextSize(0, l.h(getContext(), i));
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
        this.iJG = (RelativeLayout) findViewById(d.g.voice_image_content);
        this.iJG.setOnClickListener(this);
        this.guf = (ImageView) findViewById(d.g.playingImg);
        this.iJF = (TextView) findViewById(d.g.playTime);
        this.iJH = (AudioAnimationView) findViewById(d.g.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cfy();
    }

    private void cfy() {
        this.iJH.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.guj = voiceModel;
        if (this.guj != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                ut(this.guj.elapse);
                return;
            }
            uu(this.guj.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.iJI = (int) this.iJF.getPaint().measureText(formatVoiceTime);
            this.iJJ = this.iJI + l.h(TbadkCoreApplication.getInst(), d.e.tbds58);
            this.iJH.setCertainColumnCount(getAudioVoiceColumnCount());
            this.iJH.ra();
            this.iJG.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.iJJ, getPaddingBottom());
            this.iJF.setText(formatVoiceTime);
        }
    }

    public void ut(int i) {
        String formatVoiceTime;
        if (this.guj != null && this.iJF != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.guj.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.guj.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.guj.duration);
            }
            String a = k.a(this.iJF.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.iJF.setText(formatVoiceTime);
            }
        }
    }

    public void uu(int i) {
        this.iJH.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            qc(true);
            this.iJH.setVisibility(0);
            this.iJH.start();
            return;
        }
        this.iJH.ra();
        this.iJH.setVisibility(4);
        qc(false);
        if (i == 1) {
            if (this.guj != null) {
                this.iJF.setText(VoiceManager.formatVoiceTime(this.guj.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.guj != null) {
                this.iJF.setText(VoiceManager.formatVoiceTime(this.guj.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.guj != null && view == this.iJG) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bNt != null) {
                this.bNt.onClick(this);
            }
            TiebaStatic.log(this.guj.from);
        }
    }

    public void bop() {
        VoiceManager voiceManager;
        if (this.guj != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void qc(boolean z) {
        if (this.guf != null) {
            if (z) {
                al.c(this.guf, d.f.icon_common_voice_pause);
            } else {
                al.c(this.guf, d.f.icon_common_voice_play);
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
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.atu();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.att() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.agn();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.att();
            setVoiceModel(voiceModel);
            cfy();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.guj != voiceModel) {
                uu(1);
            } else {
                uu(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bt(int i) {
        if (!cfA()) {
            uu(1);
            return;
        }
        ut(i);
        if (this.guj != null) {
            this.guj.elapse = i;
        }
    }

    private boolean cfA() {
        if (this.guj == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.guj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.guj;
    }

    public void bxW() {
        cfy();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.guj);
        }
        if ((i.aK(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.guj);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void rg() {
    }

    public void reset() {
        this.guj = null;
        setTag(null);
        uu(1);
    }

    public void cfB() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.iJH.getLayoutParams();
        layoutParams.width = -2;
        this.iJH.setLayoutParams(layoutParams);
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
            d = iJK * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = iJK * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = iJK * 0.6d * 2.0d;
        } else {
            d = iJK * 2;
        }
        if (d < l.h(TbadkCoreApplication.getInst(), d.e.tbds216)) {
            d = l.h(TbadkCoreApplication.getInst(), d.e.tbds216);
        }
        double h = (d - this.iJJ) - l.h(TbadkCoreApplication.getInst(), d.e.tbds75);
        if (h > 0.0d) {
            return (int) h;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bNt = onClickListener;
    }
}
