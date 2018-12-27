package com.baidu.tieba.tbadkCore.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.base.i;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.lib.util.l;
import com.baidu.searchbox.ng.ai.apps.util.AiAppsFileUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener aFa;
    private AnimationDrawable beb;
    private VoiceManager dKQ;
    private ImageView fdk;
    private VoiceData.VoiceModel fdo;
    private TextView hrO;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(e.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(bV(i, getBtnWidth()), AiAppsFileUtils.GB), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], AiAppsFileUtils.GB));
    }

    private int bV(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(e.C0210e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0210e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(e.C0210e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(e.C0210e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(e.h.play_voice_bnt, (ViewGroup) this, true);
        this.fdk = (ImageView) findViewById(e.g.playingImg);
        this.hrO = (TextView) findViewById(e.g.playTime);
        this.mProgress = (ProgressBar) findViewById(e.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        bFp();
        setContentDescription(TbadkCoreApplication.getInst().getString(e.j.msglist_voice));
    }

    private void bFp() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.i(this, e.f.but_thread_voice_selector);
            if (this.hrO != null) {
                this.hrO.setTextSize(0, this.mContext.getResources().getDimension(e.C0210e.ds36));
                this.hrO.setTextColor(i);
            }
            if (this.fdk != null) {
                al.c(this.fdk, e.a.voice_btn_play_anim);
            }
            this.fdk.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? -16777216 : -8682095;
            al.i(this, e.f.but_thread_voice_reply_selector);
            if (this.hrO != null) {
                this.hrO.setTextSize(0, this.mContext.getResources().getDimension(e.C0210e.ds28));
                this.hrO.setTextColor(i2);
            }
            if (this.fdk != null) {
                al.c(this.fdk, e.a.voice_btn_play_anim);
            }
            this.fdk.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.fdk.getDrawable()).stop();
    }

    public void setVoiceModel(VoiceData.VoiceModel voiceModel) {
        requestLayout();
        this.fdo = voiceModel;
        if (this.fdo != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null && voiceManager.isPlayDoing(voiceModel)) {
                voiceManager.resetPlayView(this);
                qI(this.fdo.elapse);
                return;
            }
            qJ(this.fdo.voice_status.intValue());
            this.hrO.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
        }
    }

    public void qI(int i) {
        String formatVoiceTime;
        if (this.fdo != null && this.hrO != null) {
            int i2 = i / 1000;
            if (i2 > 0 && i2 < this.fdo.duration) {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fdo.duration - i2);
            } else {
                formatVoiceTime = VoiceManager.formatVoiceTime(this.fdo.duration);
            }
            String a = k.a(this.hrO.getText(), null);
            if (a == null || !a.equals(formatVoiceTime)) {
                this.hrO.setText(formatVoiceTime);
            }
        }
    }

    public void qJ(int i) {
        if (i == 3) {
            if (this.fdk != null) {
                this.fdk.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            aVs();
            return;
        }
        aVt();
        if (i == 1) {
            if (this.fdk != null) {
                this.fdk.setVisibility(0);
            }
            if (this.fdo != null) {
                this.hrO.setText(VoiceManager.formatVoiceTime(this.fdo.duration));
            }
            this.mProgress.setVisibility(4);
        } else if (i == 2) {
            if (this.fdo != null) {
                this.hrO.setText(VoiceManager.formatVoiceTime(this.fdo.duration));
            }
            this.mProgress.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fdo != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.aFa != null) {
                this.aFa.onClick(view);
            }
            TiebaStatic.log(this.fdo.from);
        }
    }

    private void bFq() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? e.a.voice_btn_play_anim : e.a.voice_btn_play_anim_1;
        }
        if (this.fdk != null) {
            this.fdk.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.fdk != null) {
            if (this.play_type == 0) {
                al.c(this.fdk, e.f.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.fdk, e.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void aVs() {
        if (this.beb != null) {
            this.beb.stop();
        }
        bFq();
        this.beb = (AnimationDrawable) this.fdk.getDrawable();
        this.beb.start();
    }

    public void aVt() {
        Drawable drawable = this.fdk.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.beb = (AnimationDrawable) drawable;
        }
        if (this.beb != null) {
            this.beb.stop();
        }
        this.beb = null;
        stopAnimation();
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.dKQ = voiceManager;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).getVoiceManager();
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.dKQ;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData.VoiceModel voiceModel = (VoiceData.VoiceModel) tbRichTextVoiceInfo.SY();
            if (voiceModel == null) {
                voiceModel = new VoiceData.VoiceModel();
                if (tbRichTextVoiceInfo.SX() == 0) {
                    voiceModel.from = "pb_voice_play";
                } else {
                    voiceModel.from = "floor_voice_play";
                }
                voiceModel.voiceId = tbRichTextVoiceInfo.GH();
                voiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.M(voiceModel);
            }
            this.play_type = tbRichTextVoiceInfo.SX();
            setVoiceModel(voiceModel);
            bFp();
            obj = voiceModel;
        }
        super.setTag(obj);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void b(VoiceData.VoiceModel voiceModel) {
        if (voiceModel != null) {
            if (this.fdo != voiceModel) {
                qJ(1);
            } else {
                qJ(voiceModel.voice_status.intValue());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void bz(int i) {
        if (!bFr()) {
            qJ(1);
            return;
        }
        if (this.beb == null) {
            qJ(this.fdo.voice_status.intValue());
        }
        qI(i);
        if (this.fdo != null) {
            this.fdo.elapse = i;
        }
    }

    private boolean bFr() {
        if (this.fdo == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.fdo);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void onShowErr(int i, String str) {
        l.S(getContext(), str);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceData.VoiceModel getVoiceModel() {
        return this.fdo;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public VoiceManager.b getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.c) {
            return ((VoiceManager.c) context).c(this.fdo);
        }
        if ((i.aK(getContext()) instanceof com.baidu.adp.base.e) && (tbPageContext = (TbPageContext) i.aK(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.c)) {
            return ((VoiceManager.c) tbPageContext.getOrignalPage()).c(this.fdo);
        }
        return this;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.b
    public void pZ() {
    }

    public void reset() {
        this.fdo = null;
        setTag(null);
        qJ(1);
    }

    private int getBtnWidth() {
        VoiceData.VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int aO = l.aO(getContext());
        if (i > 10) {
            if (i <= 30) {
                int i2 = (int) (aO * 0.3f);
                return (((i - 10) * (((int) (aO * 0.45f)) - i2)) / 20) + i2;
            }
            return (int) (aO * 0.45f);
        }
        int i3 = (int) (aO * 0.18f);
        int i4 = (int) (aO * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return (((i - 1) * (i4 - i3)) / 10) + i3;
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.aFa = onClickListener;
    }
}
