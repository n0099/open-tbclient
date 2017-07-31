package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fXF;
    private ValueAnimator fXG;
    private int fXH = 800;
    private b fXI;

    public void bok() {
        if (this.fXF != null) {
            this.fXF.cancel();
            this.fXF = null;
        }
    }

    public void bv(View view) {
        if (this.fXF == null || !this.fXF.isStarted()) {
            if (this.fXI != null) {
                this.fXI.boc();
            }
            this.fXF = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fXF.setRepeatCount(-1);
            this.fXF.setRepeatMode(1);
            this.fXF.setDuration(this.fXH);
            this.fXF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fXI != null) {
                        m.this.fXI.bod();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fXF.start();
        }
    }

    public void bol() {
        bok();
        this.fXG = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fXG.setRepeatCount(0);
        this.fXG.setDuration(800L);
        this.fXG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fXI != null) {
                    m.this.fXI.aj(floatValue);
                }
            }
        });
        this.fXG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bog();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fXG.start();
    }

    public m(b bVar) {
        this.fXI = bVar;
    }

    public boolean isRunning() {
        if (this.fXF == null || !this.fXF.isStarted()) {
            return this.fXG != null && this.fXG.isStarted();
        }
        return true;
    }

    public void bog() {
        if (this.fXF != null) {
            this.fXF.cancel();
        }
        if (this.fXG != null) {
            this.fXG.cancel();
        }
    }
}
