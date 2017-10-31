package com.baidu.tieba.story;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
/* loaded from: classes.dex */
public class m {
    private ValueAnimator gfb;
    private ValueAnimator gfc;
    private int gfd = 800;
    private b gfe;

    public void bqa() {
        if (this.gfb != null) {
            this.gfb.cancel();
            this.gfb = null;
        }
    }

    public void bH(View view) {
        if (this.gfb == null || !this.gfb.isStarted()) {
            if (this.gfe != null) {
                this.gfe.bpR();
            }
            this.gfb = ObjectAnimator.ofFloat(view, "rotation", 0.0f, 360.0f);
            this.gfb.setRepeatCount(-1);
            this.gfb.setRepeatMode(1);
            this.gfb.setDuration(this.gfd);
            this.gfb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (m.this.gfe != null) {
                        m.this.gfe.bpS();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.gfb.start();
        }
    }

    public void bqb() {
        bqa();
        this.gfc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gfc.setRepeatCount(0);
        this.gfc.setDuration(800L);
        this.gfc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.story.m.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 360.0f;
                if (m.this.gfe != null) {
                    m.this.gfe.aa(floatValue);
                }
            }
        });
        this.gfc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.story.m.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                m.this.bpV();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gfc.start();
    }

    public m(b bVar) {
        this.gfe = bVar;
    }

    public boolean isRunning() {
        if (this.gfb == null || !this.gfb.isStarted()) {
            return this.gfc != null && this.gfc.isStarted();
        }
        return true;
    }

    public void bpV() {
        if (this.gfb != null) {
            this.gfb.cancel();
        }
        if (this.gfc != null) {
            this.gfc.cancel();
        }
    }
}
