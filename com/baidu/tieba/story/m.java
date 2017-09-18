package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator fYY;
    private ValueAnimator fYZ;
    private int fZa = 800;
    private b fZb;

    public void boj() {
        if (this.fYY != null) {
            this.fYY.cancel();
            this.fYY = null;
        }
    }

    public void bD(View view) {
        if (this.fYY == null || !this.fYY.isStarted()) {
            if (this.fZb != null) {
                this.fZb.boa();
            }
            this.fYY = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.fYY.setRepeatCount(-1);
            this.fYY.setRepeatMode(1);
            this.fYY.setDuration(this.fZa);
            this.fYY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.fZb != null) {
                        m.this.fZb.bob();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.fYY.start();
        }
    }

    public void bok() {
        boj();
        this.fYZ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fYZ.setRepeatCount(0);
        this.fYZ.setDuration(800L);
        this.fYZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.fZb != null) {
                    m.this.fZb.Y(floatValue);
                }
            }
        });
        this.fYZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.boe();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYZ.start();
    }

    public m(b bVar) {
        this.fZb = bVar;
    }

    public boolean isRunning() {
        if (this.fYY == null || !this.fYY.isStarted()) {
            return this.fYZ != null && this.fYZ.isStarted();
        }
        return true;
    }

    public void boe() {
        if (this.fYY != null) {
            this.fYY.cancel();
        }
        if (this.fYZ != null) {
            this.fYZ.cancel();
        }
    }
}
