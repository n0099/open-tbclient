package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fWn;
    private ValueAnimator fWo;
    private int fWp = 800;
    private b fWq;

    public void bmV() {
        if (this.fWn != null) {
            this.fWn.cancel();
            this.fWn = null;
        }
    }

    public void bD(View view) {
        if (this.fWn == null || !this.fWn.isStarted()) {
            if (this.fWq != null) {
                this.fWq.bmM();
            }
            this.fWn = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fWn.setRepeatCount(-1);
            this.fWn.setRepeatMode(1);
            this.fWn.setDuration(this.fWp);
            this.fWn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fWq != null) {
                        m.this.fWq.bmN();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fWn.start();
        }
    }

    public void bmW() {
        bmV();
        this.fWo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fWo.setRepeatCount(0);
        this.fWo.setDuration(800L);
        this.fWo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fWq != null) {
                    m.this.fWq.ab(floatValue);
                }
            }
        });
        this.fWo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bmQ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fWo.start();
    }

    public m(b bVar) {
        this.fWq = bVar;
    }

    public boolean isRunning() {
        if (this.fWn == null || !this.fWn.isStarted()) {
            return this.fWo != null && this.fWo.isStarted();
        }
        return true;
    }

    public void bmQ() {
        if (this.fWn != null) {
            this.fWn.cancel();
        }
        if (this.fWo != null) {
            this.fWo.cancel();
        }
    }
}
