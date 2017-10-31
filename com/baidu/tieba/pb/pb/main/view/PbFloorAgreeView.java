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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView amV;
    private ScaleAnimation anG;
    private TextView eYh;
    private TextView eYi;
    private boolean eYj;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.eYj = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eYj = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eYj = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eYh = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.e.ds48));
        layoutParams.topMargin = l.f(context, d.e.ds12);
        this.eYh.setLayoutParams(layoutParams);
        this.eYh.setTextSize(0, l.f(context, d.e.fontsize26));
        this.eYh.setGravity(17);
        aj.i(this.eYh, d.C0080d.cp_cont_j);
        linearLayout.addView(this.eYh);
        this.amV = new ImageView(context);
        aj.c(this.amV, d.f.icon_floor_praise_n);
        this.amV.setPadding(l.f(context, d.e.ds6), l.f(context, d.e.ds12), l.f(context, d.e.ds18), 0);
        linearLayout.addView(this.amV);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        addView(linearLayout, layoutParams2);
        this.eYi = new TextView(getContext());
        this.eYi.setTextSize(0, l.f(getContext(), d.e.fontsize24));
        addView(this.eYi);
        this.eYi.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.eYj != z) {
            this.eYj = z;
            onChangeSkinType();
        }
        this.eYh.setText(am.w(j));
        if (z2) {
            this.amV.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.anG == null) {
            this.anG = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.anG.setDuration(200L);
        }
        return this.anG;
    }

    public void onChangeSkinType() {
        if (this.eYj) {
            aj.c(this.amV, d.f.icon_floor_praised);
            aj.i(this.eYh, d.C0080d.cp_cont_h);
            return;
        }
        aj.c(this.amV, d.f.icon_floor_praise_n);
        aj.i(this.eYh, d.C0080d.cp_cont_j);
    }

    public void pZ(int i) {
        if (this.amV != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.eYi.getAnimation() != null) {
                this.eYi.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.j.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.C0080d.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.eYi.setText(spannableStringBuilder);
            this.eYi.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, l.f(getContext(), d.e.ds20), 0.0f, -l.f(getContext(), d.e.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.eYi.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.eYi.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.eYi.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
