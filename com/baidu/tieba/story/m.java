package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fWB;
    private ValueAnimator fWC;
    private int fWD = 800;
    private b fWE;

    public void bnc() {
        if (this.fWB != null) {
            this.fWB.cancel();
            this.fWB = null;
        }
    }

    public void bD(View view) {
        if (this.fWB == null || !this.fWB.isStarted()) {
            if (this.fWE != null) {
                this.fWE.bmT();
            }
            this.fWB = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fWB.setRepeatCount(-1);
            this.fWB.setRepeatMode(1);
            this.fWB.setDuration(this.fWD);
            this.fWB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fWE != null) {
                        m.this.fWE.bmU();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fWB.start();
        }
    }

    public void bnd() {
        bnc();
        this.fWC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fWC.setRepeatCount(0);
        this.fWC.setDuration(800L);
        this.fWC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fWE != null) {
                    m.this.fWE.ab(floatValue);
                }
            }
        });
        this.fWC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bmX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fWC.start();
    }

    public m(b bVar) {
        this.fWE = bVar;
    }

    public boolean isRunning() {
        if (this.fWB == null || !this.fWB.isStarted()) {
            return this.fWC != null && this.fWC.isStarted();
        }
        return true;
    }

    public void bmX() {
        if (this.fWB != null) {
            this.fWB.cancel();
        }
        if (this.fWC != null) {
            this.fWC.cancel();
        }
    }
}
