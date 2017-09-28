package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fWC;
    private ValueAnimator fWD;
    private int fWE = 800;
    private b fWF;

    public void bnd() {
        if (this.fWC != null) {
            this.fWC.cancel();
            this.fWC = null;
        }
    }

    public void bD(View view) {
        if (this.fWC == null || !this.fWC.isStarted()) {
            if (this.fWF != null) {
                this.fWF.bmU();
            }
            this.fWC = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fWC.setRepeatCount(-1);
            this.fWC.setRepeatMode(1);
            this.fWC.setDuration(this.fWE);
            this.fWC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fWF != null) {
                        m.this.fWF.bmV();
                    }
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
    }

    public void bne() {
        bnd();
        this.fWD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fWD.setRepeatCount(0);
        this.fWD.setDuration(800L);
        this.fWD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fWF != null) {
                    m.this.fWF.ab(floatValue);
                }
            }
        });
        this.fWD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bmY();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fWD.start();
    }

    public m(b bVar) {
        this.fWF = bVar;
    }

    public boolean isRunning() {
        if (this.fWC == null || !this.fWC.isStarted()) {
            return this.fWD != null && this.fWD.isStarted();
        }
        return true;
    }

    public void bmY() {
        if (this.fWC != null) {
            this.fWC.cancel();
        }
        if (this.fWD != null) {
            this.fWD.cancel();
        }
    }
}
