package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator goV;
    private ValueAnimator goW;
    private int goX = 800;
    private b goY;

    public void brT() {
        if (this.goV != null) {
            this.goV.cancel();
            this.goV = null;
        }
    }

    public void bD(View view) {
        if (this.goV == null || !this.goV.isStarted()) {
            if (this.goY != null) {
                this.goY.brK();
            }
            this.goV = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.goV.setRepeatCount(-1);
            this.goV.setRepeatMode(1);
            this.goV.setDuration(this.goX);
            this.goV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.goY != null) {
                        m.this.goY.brL();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.goV.start();
        }
    }

    public void brU() {
        brT();
        this.goW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.goW.setRepeatCount(0);
        this.goW.setDuration(800L);
        this.goW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.goY != null) {
                    m.this.goY.ak(floatValue);
                }
            }
        });
        this.goW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.brO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.goW.start();
    }

    public m(b bVar) {
        this.goY = bVar;
    }

    public boolean isRunning() {
        if (this.goV == null || !this.goV.isStarted()) {
            return this.goW != null && this.goW.isStarted();
        }
        return true;
    }

    public void brO() {
        if (this.goV != null) {
            this.goV.cancel();
        }
        if (this.goW != null) {
            this.goW.cancel();
        }
    }
}
