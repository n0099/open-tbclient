package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator ggd;
    private ValueAnimator gge;
    private int ggf = 800;
    private b ggg;

    public void bql() {
        if (this.ggd != null) {
            this.ggd.cancel();
            this.ggd = null;
        }
    }

    public void bI(View view) {
        if (this.ggd == null || !this.ggd.isStarted()) {
            if (this.ggg != null) {
                this.ggg.bqc();
            }
            this.ggd = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.ggd.setRepeatCount(-1);
            this.ggd.setRepeatMode(1);
            this.ggd.setDuration(this.ggf);
            this.ggd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.ggg != null) {
                        m.this.ggg.bqd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.ggd.start();
        }
    }

    public void bqm() {
        bql();
        this.gge = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gge.setRepeatCount(0);
        this.gge.setDuration(800L);
        this.gge.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.ggg != null) {
                    m.this.ggg.aa(floatValue);
                }
            }
        });
        this.gge.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bqg();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gge.start();
    }

    public m(b bVar) {
        this.ggg = bVar;
    }

    public boolean isRunning() {
        if (this.ggd == null || !this.ggd.isStarted()) {
            return this.gge != null && this.gge.isStarted();
        }
        return true;
    }

    public void bqg() {
        if (this.ggd != null) {
            this.ggd.cancel();
        }
        if (this.gge != null) {
            this.gge.cancel();
        }
    }
}
