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
    private ImageView amM;
    private ScaleAnimation anx;
    private TextView ePD;
    private TextView ePE;
    private boolean ePF;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.ePF = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ePF = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ePF = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.ePD = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, l.f(context, d.f.ds48));
        layoutParams.topMargin = l.f(context, d.f.ds12);
        this.ePD.setLayoutParams(layoutParams);
        this.ePD.setTextSize(0, l.f(context, d.f.fontsize26));
        this.ePD.setGravity(17);
        aj.i(this.ePD, d.e.cp_cont_j);
        linearLayout.addView(this.ePD);
        this.amM = new ImageView(context);
        aj.c(this.amM, d.g.icon_floor_praise_n);
        this.amM.setPadding(l.f(context, d.f.ds6), l.f(context, d.f.ds12), l.f(context, d.f.ds18), 0);
        linearLayout.addView(this.amM);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        addView(linearLayout, layoutParams2);
        this.ePE = new TextView(getContext());
        this.ePE.setTextSize(0, l.f(getContext(), d.f.fontsize24));
        addView(this.ePE);
        this.ePE.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.ePF != z) {
            this.ePF = z;
            onChangeSkinType();
        }
        this.ePD.setText(am.v(j));
        if (z2) {
            this.amM.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.anx == null) {
            this.anx = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.anx.setDuration(200L);
        }
        return this.anx;
    }

    public void onChangeSkinType() {
        if (this.ePF) {
            aj.c(this.amM, d.g.icon_floor_praised);
            aj.i(this.ePD, d.e.cp_cont_h);
            return;
        }
        aj.c(this.amM, d.g.icon_floor_praise_n);
        aj.i(this.ePD, d.e.cp_cont_j);
    }

    public void pG(int i) {
        if (this.amM != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.ePE.getAnimation() != null) {
                this.ePE.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.l.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(aj.getColor(d.e.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.ePE.setText(spannableStringBuilder);
            this.ePE.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, l.f(getContext(), d.f.ds20), 0.0f, -l.f(getContext(), d.f.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.ePE.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.ePE.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.ePE.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
