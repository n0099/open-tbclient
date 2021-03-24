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
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.richText.TbRichTextVoiceInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.R$styleable;
import d.b.b.a.f;
import d.b.b.a.j;
import d.b.b.e.p.k;
import d.b.b.e.p.l;
/* loaded from: classes5.dex */
public class PlayVoiceBnt extends RelativeLayout implements VoiceManager.i, View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public int f21419e;

    /* renamed from: f  reason: collision with root package name */
    public VoiceData$VoiceModel f21420f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f21421g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f21422h;
    public ProgressBar i;
    public Context j;
    public View.OnClickListener k;
    public AnimationDrawable l;
    public VoiceManager m;

    /* loaded from: classes5.dex */
    public enum PLAY_TYPE {
        NORMAL,
        REPLY
    }

    public PlayVoiceBnt(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21419e = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.Voice_play_type);
        this.f21419e = obtainStyledAttributes.getInteger(R$styleable.Voice_play_type_play_type, 0);
        obtainStyledAttributes.recycle();
        d(context);
    }

    private int getBtnWidth() {
        VoiceData$VoiceModel voiceModel = getVoiceModel();
        if (voiceModel == null) {
            return -1;
        }
        int i = voiceModel.duration;
        int k = l.k(getContext());
        if (i > 10) {
            if (i <= 30) {
                float f2 = k;
                int i2 = (int) (0.3f * f2);
                return i2 + (((i - 10) * (((int) (f2 * 0.45f)) - i2)) / 20);
            }
            return (int) (k * 0.45f);
        }
        float f3 = k;
        int i3 = (int) (0.18f * f3);
        int i4 = (int) (f3 * 0.3f);
        if (i < 5) {
            i = 4;
        }
        return i3 + (((i - 1) * (i4 - i3)) / 10);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void a(int i) {
        if (!h()) {
            k(1);
            return;
        }
        if (this.l == null) {
            k(this.f21420f.voice_status.intValue());
        }
        j(i);
        VoiceData$VoiceModel voiceData$VoiceModel = this.f21420f;
        if (voiceData$VoiceModel != null) {
            voiceData$VoiceModel.elapse = i;
        }
    }

    public final void b() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.f21419e == 0) {
            int i = skinType != 1 ? -13553101 : -6574132;
            SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_selector);
            TextView textView = this.f21422h;
            if (textView != null) {
                textView.setTextSize(0, this.j.getResources().getDimension(R.dimen.ds36));
                this.f21422h.setTextColor(i);
            }
            ImageView imageView = this.f21421g;
            if (imageView != null) {
                SkinManager.setImageResource(imageView, R.anim.voice_btn_play_anim);
            }
            this.f21421g.setPadding(l.e(getContext(), 12.0f), 0, 0, 0);
        } else {
            int i2 = skinType != 1 ? -16777216 : -8682095;
            SkinManager.setBackgroundResource(this, R.drawable.but_thread_voice_reply_selector);
            TextView textView2 = this.f21422h;
            if (textView2 != null) {
                textView2.setTextSize(0, this.j.getResources().getDimension(R.dimen.ds28));
                this.f21422h.setTextColor(i2);
            }
            ImageView imageView2 = this.f21421g;
            if (imageView2 != null) {
                SkinManager.setImageResource(imageView2, R.anim.voice_btn_play_anim);
            }
            this.f21421g.setPadding(l.e(getContext(), 8.0f), 0, 0, 0);
        }
        ((AnimationDrawable) this.f21421g.getDrawable()).stop();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void c(VoiceData$VoiceModel voiceData$VoiceModel) {
        if (voiceData$VoiceModel == null) {
            return;
        }
        if (this.f21420f != voiceData$VoiceModel) {
            k(1);
        } else {
            k(voiceData$VoiceModel.voice_status.intValue());
        }
    }

    public void d(Context context) {
        f(context);
        setOnClickListener(this);
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void e() {
    }

    public void f(Context context) {
        LayoutInflater.from(context).inflate(R.layout.play_voice_bnt, (ViewGroup) this, true);
        this.f21421g = (ImageView) findViewById(R.id.playingImg);
        this.f21422h = (TextView) findViewById(R.id.playTime);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progress);
        this.i = progressBar;
        if (progressBar != null) {
            progressBar.setVisibility(4);
        }
        this.j = context;
        b();
        setContentDescription(TbadkCoreApplication.getInst().getString(R.string.msglist_voice));
    }

    public int[] getDefinedWH() {
        int[] iArr = {0, 0};
        if (this.f21419e == 0) {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds184);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds86);
        } else {
            iArr[0] = (int) getContext().getResources().getDimension(R.dimen.ds150);
            iArr[1] = (int) getContext().getResources().getDimension(R.dimen.ds76);
        }
        return iArr;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceManager.i getRealView() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getRealView(this.f21420f);
        }
        return ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) ? ((VoiceManager.j) tbPageContext.getOrignalPage()).getRealView(this.f21420f) : this;
    }

    public VoiceManager getVoiceManager() {
        TbPageContext tbPageContext;
        Context context = getContext();
        if (context instanceof VoiceManager.j) {
            return ((VoiceManager.j) context).getVoiceManager();
        }
        if ((j.a(getContext()) instanceof f) && (tbPageContext = (TbPageContext) j.a(getContext())) != null && (tbPageContext.getOrignalPage() instanceof VoiceManager.j)) {
            return ((VoiceManager.j) tbPageContext.getOrignalPage()).getVoiceManager();
        }
        return this.m;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public VoiceData$VoiceModel getVoiceModel() {
        return this.f21420f;
    }

    public final boolean h() {
        if (this.f21420f == null) {
            return false;
        }
        VoiceManager voiceManager = getVoiceManager();
        return voiceManager == null || voiceManager.isPlayDoing(this.f21420f);
    }

    public final int i(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return Math.max(size, i2);
        }
        return Math.min(size, i2);
    }

    public void j(int i) {
        String formatVoiceTime;
        int i2;
        VoiceData$VoiceModel voiceData$VoiceModel = this.f21420f;
        if (voiceData$VoiceModel == null || this.f21422h == null) {
            return;
        }
        int i3 = i / 1000;
        if (i3 > 0 && i3 < (i2 = voiceData$VoiceModel.duration)) {
            formatVoiceTime = VoiceManager.formatVoiceTime(i2 - i3);
        } else {
            formatVoiceTime = VoiceManager.formatVoiceTime(this.f21420f.duration);
        }
        String charSequence2String = k.charSequence2String(this.f21422h.getText(), null);
        if (charSequence2String == null || !charSequence2String.equals(formatVoiceTime)) {
            this.f21422h.setText(formatVoiceTime);
        }
    }

    public void k(int i) {
        if (i == 3) {
            ImageView imageView = this.f21421g;
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            this.i.setVisibility(4);
            n();
            return;
        }
        p();
        if (i != 1) {
            if (i == 2) {
                VoiceData$VoiceModel voiceData$VoiceModel = this.f21420f;
                if (voiceData$VoiceModel != null) {
                    this.f21422h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
                }
                this.i.setVisibility(0);
                return;
            }
            return;
        }
        ImageView imageView2 = this.f21421g;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        VoiceData$VoiceModel voiceData$VoiceModel2 = this.f21420f;
        if (voiceData$VoiceModel2 != null) {
            this.f21422h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel2.duration));
        }
        this.i.setVisibility(4);
    }

    public void l() {
        this.f21420f = null;
        setTag(null);
        k(1);
    }

    public final void m() {
        int i;
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (this.f21419e == 0) {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        } else {
            i = skinType != 1 ? R.anim.voice_btn_play_anim : R.anim.voice_btn_play_anim_1;
        }
        ImageView imageView = this.f21421g;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public final void n() {
        AnimationDrawable animationDrawable = this.l;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        m();
        AnimationDrawable animationDrawable2 = (AnimationDrawable) this.f21421g.getDrawable();
        this.l = animationDrawable2;
        animationDrawable2.start();
    }

    public final void o() {
        TbadkCoreApplication.getInst().getSkinType();
        ImageView imageView = this.f21421g;
        if (imageView != null) {
            if (this.f21419e == 0) {
                SkinManager.setImageResource(imageView, R.drawable.icon_thread_voice_reply_curve_three);
            } else {
                SkinManager.setImageResource(imageView, R.drawable.icon_thread_voice_reply_curve_three);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f21420f != null) {
            VoiceManager voiceManager = getVoiceManager();
            if (voiceManager != null) {
                voiceManager.setAllowChangeVoiceMode(true);
                voiceManager.startPlay(this);
            }
            View.OnClickListener onClickListener = this.k;
            if (onClickListener != null) {
                onClickListener.onClick(view);
            }
            TiebaStatic.log(this.f21420f.from);
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i(i, getBtnWidth()), 1073741824), View.MeasureSpec.makeMeasureSpec(getDefinedWH()[1], 1073741824));
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.i
    public void onShowErr(int i, String str) {
        l.I(getContext(), str);
    }

    public void p() {
        Drawable drawable = this.f21421g.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            this.l = (AnimationDrawable) drawable;
        }
        AnimationDrawable animationDrawable = this.l;
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
        this.l = null;
        o();
    }

    public void setAfterClickListener(View.OnClickListener onClickListener) {
        this.k = onClickListener;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        if (obj != null && (obj instanceof TbRichTextVoiceInfo)) {
            TbRichTextVoiceInfo tbRichTextVoiceInfo = (TbRichTextVoiceInfo) obj;
            VoiceData$VoiceModel voiceData$VoiceModel = (VoiceData$VoiceModel) tbRichTextVoiceInfo.u();
            if (voiceData$VoiceModel == null) {
                voiceData$VoiceModel = new VoiceData$VoiceModel();
                if (tbRichTextVoiceInfo.s() == 0) {
                    voiceData$VoiceModel.from = TbadkCoreStatisticKey.PB_VOICE_PLAY;
                } else {
                    voiceData$VoiceModel.from = TbadkCoreStatisticKey.FLOOR_VOICE_PLAY;
                }
                voiceData$VoiceModel.voiceId = tbRichTextVoiceInfo.t();
                voiceData$VoiceModel.duration = tbRichTextVoiceInfo.getDuration();
                tbRichTextVoiceInfo.v(voiceData$VoiceModel);
            }
            this.f21419e = tbRichTextVoiceInfo.s();
            setVoiceModel(voiceData$VoiceModel);
            b();
            obj = voiceData$VoiceModel;
        }
        super.setTag(obj);
    }

    public void setVoiceManager(VoiceManager voiceManager) {
        this.m = voiceManager;
    }

    public void setVoiceModel(VoiceData$VoiceModel voiceData$VoiceModel) {
        requestLayout();
        this.f21420f = voiceData$VoiceModel;
        if (voiceData$VoiceModel == null) {
            return;
        }
        VoiceManager voiceManager = getVoiceManager();
        if (voiceManager != null && voiceManager.isPlayDoing(voiceData$VoiceModel)) {
            voiceManager.resetPlayView(this);
            j(this.f21420f.elapse);
            return;
        }
        k(this.f21420f.voice_status.intValue());
        this.f21422h.setText(VoiceManager.formatVoiceTime(voiceData$VoiceModel.duration));
    }
}
