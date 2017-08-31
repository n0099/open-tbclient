package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fYe;
    private ValueAnimator fYf;
    private int fYg = 800;
    private b fYh;

    public void bnY() {
        if (this.fYe != null) {
            this.fYe.cancel();
            this.fYe = null;
        }
    }

    public void bD(View view) {
        if (this.fYe == null || !this.fYe.isStarted()) {
            if (this.fYh != null) {
                this.fYh.bnP();
            }
            this.fYe = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fYe.setRepeatCount(-1);
            this.fYe.setRepeatMode(1);
            this.fYe.setDuration(this.fYg);
            this.fYe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fYh != null) {
                        m.this.fYh.bnQ();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fYe.start();
        }
    }

    public void bnZ() {
        bnY();
        this.fYf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fYf.setRepeatCount(0);
        this.fYf.setDuration(800L);
        this.fYf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fYh != null) {
                    m.this.fYh.Y(floatValue);
                }
            }
        });
        this.fYf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bnT();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYf.start();
    }

    public m(b bVar) {
        this.fYh = bVar;
    }

    public boolean isRunning() {
        if (this.fYe == null || !this.fYe.isStarted()) {
            return this.fYf != null && this.fYf.isStarted();
        }
        return true;
    }

    public void bnT() {
        if (this.fYe != null) {
            this.fYe.cancel();
        }
        if (this.fYf != null) {
            this.fYf.cancel();
        }
    }
}
