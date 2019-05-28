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
    private static final int jcj = ((l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener bVi;
    private VoiceManager foP;
    private ImageView gLg;
    private VoiceData.VoiceModel gLk;
    private TextView jce;
    private RelativeLayout jcf;
    private AudioAnimationView jcg;
    private int jch;
    private float jci;
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
        this.jch = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.jch = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.jce != null) {
            this.jce.setTextSize(0, l.g(getContext(), i));
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
        this.jcf = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.jcf.setOnClickListener(this);
        this.gLg = (ImageView) findViewById(R.id.playingImg);
        this.jce = (TextView) findViewById(R.id.playTime);
        this.jcg = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cnC();
    }

    private void cnC() {
        this.jcg.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gLk = voiceModel;
        if (this.gLk != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                vw(this.gLk.elapse);
                return;
            }
            vx(this.gLk.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.jch = (int) this.jce.getPaint().measureText(formatVoiceTime);
            this.jci = this.jch + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.jcg.setCertainColumnCount(getAudioVoiceColumnCount());
            this.jcg.pV();
            this.jcf.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.jci, getPaddingBottom());
            this.jce.setText(formatVoiceTime);
        }
    }

    public void vw(int i) {
        String formatVoiceTime;
        if (this.gLk != null && this.jce != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gLk.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gLk.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gLk.duration);
            }
            String a = k.a(this.jce.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.jce.setText(formatVoiceTime);
            }
        }
    }

    public void vx(int i) {
        this.jcg.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            qR(true);
            this.jcg.setVisibility(0);
            this.jcg.start();
            return;
        }
        this.jcg.pV();
        this.jcg.setVisibility(4);
        qR(false);
        if (i == 1) {
            if (this.gLk != null) {
                this.jce.setText(VoiceManager.formatVoiceTime(this.gLk.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gLk != null) {
                this.jce.setText(VoiceManager.formatVoiceTime(this.gLk.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gLk != null && view == this.jcf) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bVi != null) {
                this.bVi.onClick(this);
            }
            TiebaStatic.log(this.gLk.from);
        }
    }

    public void bvR() {
        VoiceManager voiceManager;
        if (this.gLk != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void qR(boolean z) {
        if (this.gLg != null) {
            if (z) {
                al.c(this.gLg, (int) R.drawable.icon_common_voice_pause);
            } else {
                al.c(this.gLg, (int) R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.foP = voiceManager;
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
        return this.foP;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.ayw();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.ayv() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.alj();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.ayv();
            setVoiceModel(voiceModel);
            cnC();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gLk != voiceModel) {
                vx(1);
            } else {
                vx(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (!cnE()) {
            vx(1);
            return;
        }
        vw(i);
        if (this.gLk != null) {
            this.gLk.elapse = i;
        }
    }

    private boolean cnE() {
        if (this.gLk == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gLk);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gLk;
    }

    public void bFD() {
        cnC();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gLk);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gLk);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qb() {
    }

    public void reset() {
        this.gLk = null;
        setTag(null);
        vx(1);
    }

    public void cnF() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jcg.getLayoutParams();
        layoutParams.width = -2;
        this.jcg.setLayoutParams(layoutParams);
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
            d = jcj * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = jcj * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = jcj * 0.6d * 2.0d;
        } else {
            d = jcj * 2;
        }
        if (d < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double g = (d - this.jci) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (g > 0.0d) {
            return (int) g;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bVi = onClickListener;
    }
}
