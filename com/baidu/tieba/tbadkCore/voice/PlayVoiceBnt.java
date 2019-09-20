package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
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
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener bXj;
    private AnimationDrawable fCY;
    private VoiceManager fwa;
    private ImageView gUd;
    private VoiceData.VoiceModel gUh;
    private TextView jmc;
    private Context mContext;
    private ProgressBar mProgress;
    private int play_type;

    /* loaded from: classes.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBnt(Context context, PLAY_TYPE play_type) {
        super(context);
        this.play_type = 0;
        this.play_type = play_type.ordinal();
        init(context);
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.play_type = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.a.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(0, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cC(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cC(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public int[] getDefinedWH() {
        int[] iArr = {0, 0};
        if (this.play_type == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        ao(context);
        setOnClickListener(this);
    }

    public void ao(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.gUd = (ImageView) findViewById(R.id.playingImg);
        this.jmc = (TextView) findViewById(R.id.playTime);
        this.mProgress = (ProgressBar) findViewById(R.id.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        crG();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    private void crG() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            am.k(this, R.drawable.but_thread_voice_selector);
            if (this.jmc != null) {
                this.jmc.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds36));
                this.jmc.setTextColor(i);
            }
            if (this.gUd != null) {
                am.c(this.gUd, (int) R.anim.voice_btn_play_anim);
            }
            this.gUd.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            am.k(this, R.drawable.but_thread_voice_reply_selector);
            if (this.jmc != null) {
                this.jmc.setTextSize(0, this.mContext.getResources().getDimension(R.dimen.ds28));
                this.jmc.setTextColor(i2);
            }
            if (this.gUd != null) {
                am.c(this.gUd, (int) R.anim.voice_btn_play_anim);
            }
            this.gUd.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.gUd.getDrawable()).stop();
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
            this.jmc.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
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
        if (i == 3) {
            if (this.gUd != null) {
                this.gUd.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bHP();
            return;
        }
        bHQ();
        if (i == 1) {
            if (this.gUd != null) {
                this.gUd.setVisibility(0);
            }
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
        if (this.gUh != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bXj != null) {
                this.bXj.onClick(view);
            }
            TiebaStatic.log(this.gUh.from);
        }
    }

    private void crH() {
        int i = R.anim.voice_btn_play_anim;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            if (skinType == 1) {
                i = R.anim.voice_btn_play_anim_1;
            }
        } else if (skinType == 1) {
            i = R.anim.voice_btn_play_anim_1;
        }
        if (this.gUd != null) {
            this.gUd.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.gUd != null) {
            if (this.play_type == 0) {
                am.c(this.gUd, (int) R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                am.c(this.gUd, (int) R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void bHP() {
        if (this.fCY != null) {
            this.fCY.stop();
        }
        crH();
        this.fCY = (AnimationDrawable) this.gUd.getDrawable();
        this.fCY.start();
    }

    public void bHQ() {
        Drawable drawable = this.gUd.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.fCY = (AnimationDrawable) drawable;
        }
        if (this.fCY != null) {
            this.fCY.stop();
        }
        this.fCY = null;
        stopAnimation();
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
        if (this.fCY == null) {
            we(this.gUh.voice_status.intValue());
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

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int af = l.af(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (af * 0.3f);
                return (((i - 10) * (((int) (af * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (af * 0.45f);
        }
        int i3 = (int) (af * 0.18f);
        int i4 = (int) (af * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.bXj = onClickListener;
    }
}
