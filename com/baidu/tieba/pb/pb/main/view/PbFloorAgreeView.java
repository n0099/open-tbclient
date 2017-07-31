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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class PbFloorAgreeView extends FrameLayout {
    private ScaleAnimation aoL;
    private ImageView aoj;
    private TextView eUn;
    private TextView eUo;
    private boolean eUp;

    public PbFloorAgreeView(Context context) {
        super(context);
        this.eUp = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.eUp = false;
        init();
    }

    public PbFloorAgreeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.eUp = false;
        init();
    }

    public void init() {
        Context context = getContext();
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.eUn = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, k.g(context, d.f.ds48));
        layoutParams.topMargin = k.g(context, d.f.ds12);
        this.eUn.setLayoutParams(layoutParams);
        this.eUn.setTextSize(0, k.g(context, d.f.fontsize24));
        this.eUn.setGravity(17);
        ai.i(this.eUn, d.e.cp_cont_d);
        linearLayout.addView(this.eUn);
        this.aoj = new ImageView(context);
        ai.c(this.aoj, d.g.icon_floor_praise_n);
        this.aoj.setPadding(k.g(context, d.f.ds6), k.g(context, d.f.ds12), k.g(context, d.f.ds18), 0);
        linearLayout.addView(this.aoj);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 5;
        addView(linearLayout, layoutParams2);
        this.eUo = new TextView(getContext());
        this.eUo.setTextSize(0, k.g(getContext(), d.f.fontsize24));
        addView(this.eUo);
        this.eUo.setVisibility(8);
    }

    public void a(boolean z, long j, boolean z2) {
        if (this.eUp != z) {
            this.eUp = z;
            onChangeSkinType();
        }
        this.eUn.setText(al.x(j));
        if (z2) {
            this.aoj.startAnimation(getScaleAnimation());
        }
    }

    private Animation getScaleAnimation() {
        if (this.aoL == null) {
            this.aoL = new ScaleAnimation(1.4f, 1.0f, 1.4f, 1.0f, 1, 0.5f, 1, 1.0f);
            this.aoL.setDuration(200L);
        }
        return this.aoL;
    }

    public void onChangeSkinType() {
        if (this.eUp) {
            ai.c(this.aoj, d.g.icon_floor_praised);
            ai.i(this.eUn, d.e.cp_cont_h);
            return;
        }
        ai.c(this.aoj, d.g.icon_floor_praise_n);
        ai.i(this.eUn, d.e.cp_cont_f);
    }

    public void pw(int i) {
        if (this.aoj != null && getVisibility() == 0) {
            if (getParent() != null) {
                ((ViewGroup) getParent()).setClipChildren(false);
            }
            if (this.eUo.getAnimation() != null) {
                this.eUo.getAnimation().cancel();
            }
            String valueOf = String.valueOf(i);
            String format = String.format(getResources().getString(d.l.pb_add_score), valueOf);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(format);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_cont_f)), 0, 2, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_cont_h)), 2, valueOf.length() + 3, 33);
            spannableStringBuilder.setSpan(new ForegroundColorSpan(ai.getColor(d.e.cp_cont_f)), valueOf.length() + 3, format.length(), 33);
            this.eUo.setText(spannableStringBuilder);
            this.eUo.setVisibility(0);
            AnimationSet animationSet = new AnimationSet(true);
            animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
            animationSet.addAnimation(new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f));
            animationSet.addAnimation(new TranslateAnimation(0.0f, k.g(getContext(), d.f.ds20), 0.0f, -k.g(getContext(), d.f.ds20)));
            animationSet.setDuration(300L);
            animationSet.setInterpolator(new OvershootInterpolator());
            animationSet.setFillAfter(true);
            this.eUo.startAnimation(animationSet);
            final AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    PbFloorAgreeView.this.eUo.setVisibility(8);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            alphaAnimation.setDuration(300L);
            postDelayed(new Runnable() { // from class: com.baidu.tieba.pb.pb.main.view.PbFloorAgreeView.2
                @Override // java.lang.Runnable
                public void run() {
                    PbFloorAgreeView.this.eUo.startAnimation(alphaAnimation);
                }
            }, 1800L);
        }
    }
}
