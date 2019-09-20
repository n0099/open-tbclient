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
import com.baidu.tieba.R;
import com.baidu.tieba.d;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int jmh = ((l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener bXj;
    private VoiceManager fwa;
    private ImageView gUd;
    private VoiceData.VoiceModel gUh;
    private TextView jmc;
    private RelativeLayout jmd;
    private AudioAnimationView jme;
    private int jmf;
    private float jmg;
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
        this.jmf = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.jmf = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.jmc != null) {
            this.jmc.setTextSize(0, l.g(getContext(), i));
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void init(Context context) {
        ao(context);
        setOnClickListener(this);
    }

    public void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt_new, (ViewGroup) this, true);
        this.jmd = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.jmd.setOnClickListener(this);
        this.gUd = (ImageView) findViewById(R.id.playingImg);
        this.jmc = (TextView) findViewById(R.id.playTime);
        this.jme = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        crG();
    }

    private void crG() {
        this.jme.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gUh = voiceModel;
        if (this.gUh != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                wd(this.gUh.elapse);
                return;
            }
            we(this.gUh.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.jmf = (int) this.jmc.getPaint().measureText(formatVoiceTime);
            this.jmg = this.jmf + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.jme.setCertainColumnCount(getAudioVoiceColumnCount());
            this.jme.qs();
            this.jmd.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.jmg, getPaddingBottom());
            this.jmc.setText(formatVoiceTime);
        }
    }

    public void wd(int i) {
        String formatVoiceTime;
        if (this.gUh != null && this.jmc != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gUh.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gUh.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gUh.duration);
            }
            String a = k.a(this.jmc.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.jmc.setText(formatVoiceTime);
            }
        }
    }

    public void we(int i) {
        this.jme.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            rl(true);
            this.jme.setVisibility(0);
            this.jme.start();
            return;
        }
        this.jme.qs();
        this.jme.setVisibility(4);
        rl(false);
        if (i == 1) {
            if (this.gUh != null) {
                this.jmc.setText(VoiceManager.formatVoiceTime(this.gUh.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gUh != null) {
                this.jmc.setText(VoiceManager.formatVoiceTime(this.gUh.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gUh != null && view == this.jmd) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bXj != null) {
                this.bXj.onClick(this);
            }
            TiebaStatic.log(this.gUh.from);
        }
    }

    public void bxn() {
        VoiceManager voiceManager;
        if (this.gUh != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void rl(boolean z) {
        if (this.gUd != null) {
            if (z) {
                am.c(this.gUd, (int) R.drawable.icon_common_voice_pause);
            } else {
                am.c(this.gUd, (int) R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.fwa = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.fwa;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.azW();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.azV() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.amC();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.azV();
            setVoiceModel(voiceModel);
            crG();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gUh != voiceModel) {
                we(1);
            } else {
                we(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (!crI()) {
            we(1);
            return;
        }
        wd(i);
        if (this.gUh != null) {
            this.gUh.elapse = i;
        }
    }

    private boolean crI() {
        if (this.gUh == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gUh);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gUh;
    }

    public void bql() {
        crG();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gUh);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gUh);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qy() {
    }

    public void reset() {
        this.gUh = null;
        setTag(null);
        we(1);
    }

    public void crJ() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jme.getLayoutParams();
        layoutParams.width = -2;
        this.jme.setLayoutParams(layoutParams);
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
            d = jmh * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = jmh * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = jmh * 0.6d * 2.0d;
        } else {
            d = jmh * 2;
        }
        if (d < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double g = (d - this.jmg) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (g > 0.0d) {
            return (int) g;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bXj = onClickListener;
    }
}
