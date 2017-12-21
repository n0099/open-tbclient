package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator grH;
    private ValueAnimator grI;
    private int grJ = 800;
    private b grK;

    public void bsz() {
        if (this.grH != null) {
            this.grH.cancel();
            this.grH = null;
        }
    }

    public void bH(View view) {
        if (this.grH == null || !this.grH.isStarted()) {
            if (this.grK != null) {
                this.grK.bsq();
            }
            this.grH = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.grH.setRepeatCount(-1);
            this.grH.setRepeatMode(1);
            this.grH.setDuration(this.grJ);
            this.grH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.grK != null) {
                        m.this.grK.bsr();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.grH.start();
        }
    }

    public void bsA() {
        bsz();
        this.grI = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.grI.setRepeatCount(0);
        this.grI.setDuration(800L);
        this.grI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.grK != null) {
                    m.this.grK.ak(floatValue);
                }
            }
        });
        this.grI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bsu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.grI.start();
    }

    public m(b bVar) {
        this.grK = bVar;
    }

    public boolean isRunning() {
        if (this.grH == null || !this.grH.isStarted()) {
            return this.grI != null && this.grI.isStarted();
        }
        return true;
    }

    public void bsu() {
        if (this.grH != null) {
            this.grH.cancel();
        }
        if (this.grI != null) {
            this.grI.cancel();
        }
    }
}
