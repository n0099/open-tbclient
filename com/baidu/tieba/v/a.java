package com.baidu.tieba.v;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
/* loaded from: classes.dex */
public class a {
    public static void a(final View view, int i, final Animation.AnimationListener animationListener) {
        if (view != null && i >= 0) {
            view.clearAnimation();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration(i);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.v.a.1
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (animationListener != null) {
                        animationListener.onAnimationStart(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (animationListener != null) {
                        animationListener.onAnimationRepeat(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(animation);
                    }
                    if (view != null) {
                        view.clearAnimation();
                        view.setVisibility(0);
                    }
                }
            });
            view.setVisibility(0);
            view.startAnimation(alphaAnimation);
        }
    }

    public static void b(final View view, int i, final Animation.AnimationListener animationListener) {
        if (view != null && i >= 0) {
            view.clearAnimation();
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(i);
            alphaAnimation.setFillAfter(true);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.v.a.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    if (animationListener != null) {
                        animationListener.onAnimationStart(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    if (animationListener != null) {
                        animationListener.onAnimationRepeat(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    if (animationListener != null) {
                        animationListener.onAnimationEnd(animation);
                    }
                    if (view != null) {
                        view.clearAnimation();
                        view.setVisibility(8);
                    }
                }
            });
            view.setVisibility(8);
            view.startAnimation(alphaAnimation);
        }
    }

    public static void A(View view, int i) {
        b(view, i, null);
    }

    public static void B(View view, int i) {
        a(view, i, null);
    }
}
