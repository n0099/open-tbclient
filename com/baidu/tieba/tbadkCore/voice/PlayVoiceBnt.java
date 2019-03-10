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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PlayVoiceBnt extends RelativeLayout implements View.OnClickListener, VoiceManager.b {
    private View.OnClickListener bNt;
    private VoiceManager eYS;
    private AnimationDrawable ffA;
    private ImageView guf;
    private VoiceData.VoiceModel guj;
    private TextView iJF;
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, d.l.Voice_play_type);
        this.play_type = obtainStyledAttributes.getInteger(d.l.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        init(context);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(cr(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    private int cr(int i, int i2) {
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
            iArr[0] = (int) getContext().getResources().getDimension(d.e.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(d.e.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(d.e.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(d.e.ds76);
        }
        return iArr;
    }

    public void init(Context context) {
        aW(context);
        setOnClickListener(this);
    }

    public void aW(Context context) {
        LayoutInflater.from(context).inflate(d.h.play_voice_bnt, (ViewGroup) this, true);
        this.guf = (ImageView) findViewById(d.g.playingImg);
        this.iJF = (TextView) findViewById(d.g.playTime);
        this.mProgress = (ProgressBar) findViewById(d.g.progress);
        if (this.mProgress != null) {
            this.mProgress.setVisibility(4);
        }
        this.mContext = context;
        cfy();
        setContentDescription(TbadkCoreApplication.getInst().getString(d.j.msglist_voice));
    }

    private void cfy() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            al.k(this, d.f.but_thread_voice_selector);
            if (this.iJF != null) {
                this.iJF.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds36));
                this.iJF.setTextColor(i);
            }
            if (this.guf != null) {
                al.c(this.guf, d.a.voice_btn_play_anim);
            }
            this.guf.setPadding(l.dip2px(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? ViewCompat.MEASURED_STATE_MASK : -8682095;
            al.k(this, d.f.but_thread_voice_reply_selector);
            if (this.iJF != null) {
                this.iJF.setTextSize(0, this.mContext.getResources().getDimension(d.e.ds28));
                this.iJF.setTextColor(i2);
            }
            if (this.guf != null) {
                al.c(this.guf, d.a.voice_btn_play_anim);
            }
            this.guf.setPadding(l.dip2px(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.guf.getDrawable()).stop();
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
            this.iJF.setText(VoiceManager.formatVoiceTime(voiceModel.duration));
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
        if (i == 3) {
            if (this.guf != null) {
                this.guf.setVisibility(0);
            }
            this.mProgress.setVisibility(4);
            bwy();
            return;
        }
        bwz();
        if (i == 1) {
            if (this.guf != null) {
                this.guf.setVisibility(0);
            }
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
        if (this.guj != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            if (this.bNt != null) {
                this.bNt.onClick(view);
            }
            TiebaStatic.log(this.guj.from);
        }
    }

    private void cfz() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.play_type == 0) {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? d.a.voice_btn_play_anim : d.a.voice_btn_play_anim_1;
        }
        if (this.guf != null) {
            this.guf.setImageResource(i);
        }
    }

    private void stopAnimation() {
        TbadkCoreApplication.getInst().getSkinType();
        if (this.guf != null) {
            if (this.play_type == 0) {
                al.c(this.guf, d.f.icon_thread_voice_reply_curve_three);
            } else {
                al.c(this.guf, d.f.icon_thread_voice_reply_curve_three);
            }
        }
    }

    private void bwy() {
        if (this.ffA != null) {
            this.ffA.stop();
        }
        cfz();
        this.ffA = (AnimationDrawable) this.guf.getDrawable();
        this.ffA.start();
    }

    public void bwz() {
        Drawable drawable = this.guf.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.ffA = (AnimationDrawable) drawable;
        }
        if (this.ffA != null) {
            this.ffA.stop();
        }
        this.ffA = null;
        stopAnimation();
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
        if (this.ffA == null) {
            uu(this.guj.voice_status.intValue());
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
        this.bNt = onClickListener;
    }
}
