package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator grC;
    private ValueAnimator grD;
    private int grE = 800;
    private b grF;

    public void bsy() {
        if (this.grC != null) {
            this.grC.cancel();
            this.grC = null;
        }
    }

    public void bH(View view) {
        if (this.grC == null || !this.grC.isStarted()) {
            if (this.grF != null) {
                this.grF.bsp();
            }
            this.grC = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.grC.setRepeatCount(-1);
            this.grC.setRepeatMode(1);
            this.grC.setDuration(this.grE);
            this.grC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.grF != null) {
                        m.this.grF.bsq();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.grC.start();
        }
    }

    public void bsz() {
        bsy();
        this.grD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.grD.setRepeatCount(0);
        this.grD.setDuration(800L);
        this.grD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.grF != null) {
                    m.this.grF.ak(floatValue);
                }
            }
        });
        this.grD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bst();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.grD.start();
    }

    public m(b bVar) {
        this.grF = bVar;
    }

    public boolean isRunning() {
        if (this.grC == null || !this.grC.isStarted()) {
            return this.grD != null && this.grD.isStarted();
        }
        return true;
    }

    public void bst() {
        if (this.grC != null) {
            this.grC.cancel();
        }
        if (this.grD != null) {
            this.grD.cancel();
        }
    }
}
