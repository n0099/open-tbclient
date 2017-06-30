package com.baidu.tieba.pb.pb.main.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends FrameLayout {
    private TextView eGA;
    private boolean eGB;
    private ScaleAnimation eGC;
    private ImageView eGy;
    private TextView eGz;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.eGB = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eGB = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eGB = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eGz = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.baidu.adp.lib.util.k.g(context, w.f.ds48));
        layoutParams.topMargin = com.baidu.adp.lib.util.k.g(context, w.f.ds12);
        this.eGz.setLayoutParams(layoutParams);
        this.eGz.setTextSize(0, com.baidu.adp.lib.util.k.g(context, w.f.fontsize24));
        this.eGz.setGravity(17);
        as.i(this.eGz, w.e.cp_cont_d);
        linearLayout.addView(this.eGz);
        this.eGy = new ImageView(context);
        as.c(this.eGy, w.g.icon_floor_praise_n);
        this.eGy.setPadding(com.baidu.adp.lib.util.k.g(context, w.f.ds6), com.baidu.adp.lib.util.k.g(context, w.f.ds12), com.baidu.adp.lib.util.k.g(context, w.f.ds18), 0);
        linearLayout.addView(this.eGy);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        addView(linearLayout, layoutParams2);
        this.eGA = new TextView(getContext());
        this.eGA.setTextSize(0, com.baidu.adp.lib.util.k.g(getContext(), w.f.fontsize24));
        addView(this.eGA);
        this.eGA.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.eGB != z) {
            this.eGB = z;
            onChangeSkinType();
        }
        this.eGz.setText(aw.w(j));
        if (z2) {
            this.eGy.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.eGC == null) {
            this.eGC = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.eGC.setDuration(200L);
        }
        return this.eGC;
    }

    public void onChangeSkinType() {
        if (this.eGB) {
            as.c(this.eGy, w.g.icon_floor_praised);
            as.i(this.eGz, w.e.cp_cont_h);
            return;
        }
        as.c(this.eGy, w.g.icon_floor_praise_n);
        as.i(this.eGz, w.e.cp_cont_f);
    }

    public void ph(int i) {
        if (this.eGy != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.eGA.getAnimation() != null) {
                this.eGA.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(w.l.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(as.getColor(w.e.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(as.getColor(w.e.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(as.getColor(w.e.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.eGA.setText(spannableStringBuilder);
            this.eGA.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20), 0.0f, -com.baidu.adp.lib.util.k.g(getContext(), w.f.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.eGA.startAnimation(animationSet);
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new f(this));
            alphaAnimation.setDuration(300L);
            postDelayed(new g(this, alphaAnimation), 1800L);
        }
    }
}
