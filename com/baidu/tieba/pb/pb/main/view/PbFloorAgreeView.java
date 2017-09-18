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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ImageView anC;
    private ScaleAnimation aoh;
    private TextView eVB;
    private TextView eVC;
    private boolean eVD;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.eVD = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eVD = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eVD = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eVB = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.f(context, d.f.ds48));
        layoutParams.topMargin = k.f(context, d.f.ds12);
        this.eVB.setLayoutParams(layoutParams);
        this.eVB.setTextSize(0, k.f(context, d.f.fontsize26));
        this.eVB.setGravity(17);
        aj.i(this.eVB, d.e.cp_cont_j);
        linearLayout.addView(this.eVB);
        this.anC = new ImageView(context);
        aj.c(this.anC, d.g.icon_floor_praise_n);
        this.anC.setPadding(k.f(context, d.f.ds6), k.f(context, d.f.ds12), k.f(context, d.f.ds18), 0);
        linearLayout.addView(this.anC);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        addView(linearLayout, layoutParams2);
        this.eVC = new TextView(getContext());
        this.eVC.setTextSize(0, k.f(getContext(), d.f.fontsize24));
        addView(this.eVC);
        this.eVC.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.eVD != z) {
            this.eVD = z;
            onChangeSkinType();
        }
        this.eVB.setText(am.w(j));
        if (z2) {
            this.anC.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.aoh == null) {
            this.aoh = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.aoh.setDuration(200L);
        }
        return this.aoh;
    }

    public void onChangeSkinType() {
        if (this.eVD) {
            aj.c(this.anC, d.g.icon_floor_praised);
            aj.i(this.eVB, d.e.cp_cont_h);
            return;
        }
        aj.c(this.anC, d.g.icon_floor_praise_n);
        aj.i(this.eVB, d.e.cp_cont_j);
    }

    public void pL(int i) {
        if (this.anC != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.eVC.getAnimation() != null) {
                this.eVC.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.l.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.eVC.setText(spannableStringBuilder);
            this.eVC.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, k.f(getContext(), d.f.ds20), 0.0f, -k.f(getContext(), d.f.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.eVC.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.eVC.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.eVC.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
