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
import com.baidu.tieba.c;
import com.baidu.tieba.view.AudioAnimationView;
/* loaded from: classes.dex */
public class PlayVoiceBntNew extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private static final int jiF = ((l.af(TbadkCoreApplication.getInst()) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44) * 2)) - (l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10) * 2)) / 3;
    private View.OnClickListener bWk;
    private VoiceManager ftO;
    private ImageView gRs;
    private VoiceData.VoiceModel gRw;
    private TextView jiA;
    private RelativeLayout jiB;
    private AudioAnimationView jiC;
    private int jiD;
    private float jiE;
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
        this.jiD = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBntNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        this.jiD = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, c.a.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    public void setPlayTimeTextView(int i) {
        if (this.jiA != null) {
            this.jiA.setTextSize(0, l.g(getContext(), i));
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
        this.jiB = (RelativeLayout) findViewById(R.id.voice_image_content);
        this.jiB.setOnClickListener(this);
        this.gRs = (ImageView) findViewById(R.id.playingImg);
        this.jiA = (TextView) findViewById(R.id.playTime);
        this.jiC = (AudioAnimationView) findViewById(R.id.audioAnimationView);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cqw();
    }

    private void cqw() {
        this.jiC.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.gRw = voiceModel;
        if (this.gRw != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                vX(this.gRw.elapse);
                return;
            }
            vY(this.gRw.voice_status.intValue());
            String formatVoiceTime = VoiceManager.formatVoiceTime(voiceModel.duration);
            this.jiD = (int) this.jiA.getPaint().measureText(formatVoiceTime);
            this.jiE = this.jiD + l.g(TbadkCoreApplication.getInst(), R.dimen.tbds58);
            this.jiC.setCertainColumnCount(getAudioVoiceColumnCount());
            this.jiC.qr();
            this.jiB.setPadding(getPaddingLeft(), getPaddingTop(), (int) this.jiE, getPaddingBottom());
            this.jiA.setText(formatVoiceTime);
        }
    }

    public void vX(int i) {
        String formatVoiceTime;
        if (this.gRw != null && this.jiA != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.gRw.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gRw.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.gRw.duration);
            }
            String a = k.a(this.jiA.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.jiA.setText(formatVoiceTime);
            }
        }
    }

    public void vY(int i) {
        this.jiC.setCertainColumnCount(getAudioVoiceColumnCount());
        if (i == 3) {
            this.mProgress.setVisibility(4);
            rh(true);
            this.jiC.setVisibility(0);
            this.jiC.start();
            return;
        }
        this.jiC.qr();
        this.jiC.setVisibility(4);
        rh(false);
        if (i == 1) {
            if (this.gRw != null) {
                this.jiA.setText(VoiceManager.formatVoiceTime(this.gRw.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.gRw != null) {
                this.jiA.setText(VoiceManager.formatVoiceTime(this.gRw.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gRw != null && view == this.jiB) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bWk != null) {
                this.bWk.onClick(this);
            }
            TiebaStatic.log(this.gRw.from);
        }
    }

    public void bwl() {
        VoiceManager voiceManager;
        if (this.gRw != null && (voiceManager = getVoiceManager()) != null) {
            voiceManager.stopPlay();
        }
    }

    private void rh(boolean z) {
        if (this.gRs != null) {
            if (z) {
                am.c(this.gRs, (int) R.drawable.icon_common_voice_pause);
            } else {
                am.c(this.gRs, (int) R.drawable.icon_common_voice_play);
            }
        }
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.ftO = voiceManager;
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
        return this.ftO;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.azI();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.azH() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.amo();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.ag(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.azH();
            setVoiceModel(voiceModel);
            cqw();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.gRw != voiceModel) {
                vY(1);
            } else {
                vY(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bl(int i) {
        if (!cqy()) {
            vY(1);
            return;
        }
        vX(i);
        if (this.gRw != null) {
            this.gRw.elapse = i;
        }
    }

    private boolean cqy() {
        if (this.gRw == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.gRw);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.E(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.gRw;
    }

    public void bIl() {
        cqw();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.gRw);
        }
        if ((i.ab(getContext()) instanceof e) && (tbPageContext = (TbPageContext) i.ab(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.gRw);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void qx() {
    }

    public void reset() {
        this.gRw = null;
        setTag(null);
        vY(1);
    }

    public void cqz() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jiC.getLayoutParams();
        layoutParams.width = -2;
        this.jiC.setLayoutParams(layoutParams);
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
            d = jiF * 0.6d;
        } else if (voiceModel.duration < 30) {
            d = jiF * 0.6d * 2.0d;
        } else if (voiceModel.duration < 60) {
            d = jiF * 0.6d * 2.0d;
        } else {
            d = jiF * 2;
        }
        if (d < l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216)) {
            d = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds216);
        }
        double g = (d - this.jiE) - l.g(TbadkCoreApplication.getInst(), R.dimen.tbds75);
        if (g > 0.0d) {
            return (int) g;
        }
        return 0;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bWk = onClickListener;
    }
}
