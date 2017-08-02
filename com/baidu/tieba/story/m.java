package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fWu;
    private ValueAnimator fWv;
    private int fWw = 800;
    private b fWx;

    public void bob() {
        if (this.fWu != null) {
            this.fWu.cancel();
            this.fWu = null;
        }
    }

    public void bv(View view) {
        if (this.fWu == null || !this.fWu.isStarted()) {
            if (this.fWx != null) {
                this.fWx.bnT();
            }
            this.fWu = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fWu.setRepeatCount(-1);
            this.fWu.setRepeatMode(1);
            this.fWu.setDuration(this.fWw);
            this.fWu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fWx != null) {
                        m.this.fWx.bnU();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fWu.start();
        }
    }

    public void boc() {
        bob();
        this.fWv = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fWv.setRepeatCount(0);
        this.fWv.setDuration(800L);
        this.fWv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fWx != null) {
                    m.this.fWx.aj(floatValue);
                }
            }
        });
        this.fWv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bnX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fWv.start();
    }

    public m(b bVar) {
        this.fWx = bVar;
    }

    public boolean isRunning() {
        if (this.fWu == null || !this.fWu.isStarted()) {
            return this.fWv != null && this.fWv.isStarted();
        }
        return true;
    }

    public void bnX() {
        if (this.fWu != null) {
            this.fWu.cancel();
        }
        if (this.fWv != null) {
            this.fWv.cancel();
        }
    }
}
