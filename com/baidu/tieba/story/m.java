package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fZA;
    private int fZB = 800;
    private b fZC;
    private ValueAnimator fZz;

    public void boQ() {
        if (this.fZz != null) {
            this.fZz.cancel();
            this.fZz = null;
        }
    }

    public void bx(View view) {
        if (this.fZz == null || !this.fZz.isStarted()) {
            if (this.fZC != null) {
                this.fZC.boI();
            }
            this.fZz = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fZz.setRepeatCount(-1);
            this.fZz.setRepeatMode(1);
            this.fZz.setDuration(this.fZB);
            this.fZz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fZC != null) {
                        m.this.fZC.boJ();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fZz.start();
        }
    }

    public void boR() {
        boQ();
        this.fZA = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fZA.setRepeatCount(0);
        this.fZA.setDuration(800L);
        this.fZA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fZC != null) {
                    m.this.fZC.aj(floatValue);
                }
            }
        });
        this.fZA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.boM();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fZA.start();
    }

    public m(b bVar) {
        this.fZC = bVar;
    }

    public boolean isRunning() {
        if (this.fZz == null || !this.fZz.isStarted()) {
            return this.fZA != null && this.fZA.isStarted();
        }
        return true;
    }

    public void boM() {
        if (this.fZz != null) {
            this.fZz.cancel();
        }
        if (this.fZA != null) {
            this.fZA.cancel();
        }
    }
}
