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
import com.baidu.tieba.R;
import com.baidu.tieba.c;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int jch = ((l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener bVi;
    private VoiceManager foO;
    private ImageView gLf;
    private VoiceData.VoiceModel gLj;
    private TextView jcc;
    private RelativeLayout jcd;
    private AudioAnimationView jce;
    private int jcf;
    private float jcg;
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
        this.jcf = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.jcf = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.jcc != null) {
            this.jcc.setTextSize(0, l.g(getContext(), i));
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
        this.jcd = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.jcd.setOnClickListener(this);
        this.gLf = (ImageView) findViewById(R.id.playingImg);
        this.jcc = (TextView) findViewById(R.id.playTime);
        this.jce = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cnA();
    }

    private void cnA() {
        this.jce.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gLj = voiceModel;
        if (this.gLj != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                vw(this.gLj.elapse);
                return;
            }
            vx(this.gLj.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.jcf = (int) this.jcc.getPaint().measureText(formatVoiceTime);
            this.jcg = this.jcf + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.jce.setCertainColumnCount(getAudioVoiceColumnCount());
            this.jce.pV();
            this.jcd.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.jcg, getPaddingBottom());
            this.jcc.setText(formatVoiceTime);
        }
    }

    public void vw(int i) {
        String formatVoiceTime;
        if (this.gLj != null && this.jcc != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gLj.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gLj.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gLj.duration);
            }
            String a = k.a(this.jcc.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.jcc.setText(formatVoiceTime);
            }
        }
    }

    public void vx(int i) {
        this.jce.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            qR(true);
            this.jce.setVisibility(0);
            this.jce.start();
            return;
        }
        this.jce.pV();
        this.jce.setVisibility(4);
        qR(false);
        if (i == 1) {
            if (this.gLj != null) {
                this.jcc.setText(VoiceManager.formatVoiceTime(this.gLj.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gLj != null) {
                this.jcc.setText(VoiceManager.formatVoiceTime(this.gLj.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gLj != null && view == this.jcd) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bVi != null) {
                this.bVi.onClick(this);
            }
            TiebaStatic.log(this.gLj.from);
        }
    }

    public void bvO() {
        VoiceManager voiceManager;
        if (this.gLj != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void qR(boolean z) {
        if (this.gLf != null) {
            if (z) {
                al.c(this.gLf, (int) R.drawable.icon_common_voice_pause);
            } else {
                al.c(this.gLf, (int) R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.foO = voiceManager;
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
        return this.foO;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.ayv();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.ayu() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.alj();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.ayu();
            setVoiceModel(voiceModel);
            cnA();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gLj != voiceModel) {
                vx(1);
            } else {
                vx(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (!cnC()) {
            vx(1);
            return;
        }
        vw(i);
        if (this.gLj != null) {
            this.gLj.elapse = i;
        }
    }

    private boolean cnC() {
        if (this.gLj == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gLj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gLj;
    }

    public void bFA() {
        cnA();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gLj);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gLj);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qb() {
    }

    public void reset() {
        this.gLj = null;
        setTag(null);
        vx(1);
    }

    public void cnD() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jce.getLayoutParams();
        layoutParams.width = -2;
        this.jce.setLayoutParams(layoutParams);
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
            d = jch * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = jch * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = jch * 0.6d * 2.0d;
        } else {
            d = jch * 2;
        }
        if (d < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double g = (d - this.jcg) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (g > 0.0d) {
            return (int) g;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVi = onClickListener;
    }
}
