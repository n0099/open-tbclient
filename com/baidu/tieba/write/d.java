package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator hJQ;
    private ValueAnimator hJR;
    private boolean lQi;
    private boolean lQj;
    private boolean lQk;
    private ValueAnimator lQl;
    private ValueAnimator lQm;
    private a.b lQn;
    private ValueAnimator.AnimatorUpdateListener lQo;
    private Animator.AnimatorListener lQp;
    private ValueAnimator.AnimatorUpdateListener lQq;
    private Animator.AnimatorListener lQr;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.lQi = false;
        this.lQj = false;
        this.lQk = false;
        this.lQo = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.lQi || animatedFraction < 0.6923f || !d.this.lQn.lPz.isAnimating()) {
                    if (!d.this.lQk && animatedFraction >= 0.38461f && d.this.lQn.lPz.isAnimating()) {
                        d.this.lQk = true;
                        return;
                    }
                    return;
                }
                d.this.lQi = true;
            }
        };
        this.lQp = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dml();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lQq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.lQj && animatedFraction >= 0.57142f && d.this.lQn.lPz.isAnimating()) {
                    d.this.lQj = true;
                    d.this.dmm();
                }
            }
        };
        this.lQr = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dmn();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.lQn = bVar;
        init();
    }

    private void init() {
        this.hJQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.hJQ.setDuration(451L);
        this.hJQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lQn.deP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hJQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lQn.deP.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hJR = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hJR.setDuration(485L);
        this.hJR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.lQn.deP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.hJR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.lQn.deP.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lQl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lQl.setDuration(104L);
        this.lQl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lQl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(1.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lQm = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.lQm.setDuration(208L);
        this.lQm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.lQm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dml() {
        this.lQn.lPz.setVisibility(0);
        this.lQn.vj(true);
        this.mState = 2;
        if (this.lQI != null) {
            this.lQI.El(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmm() {
        this.lQl.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dmn() {
        this.lQi = false;
        this.lQk = false;
        this.lQj = false;
        this.lQn.vj(false);
        if (this.dMf != null) {
            this.dMf.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Fv(8);
        this.mState = 4;
        if (this.lQI != null) {
            this.lQI.El(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmo() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.lQI != null) {
                this.lQI.El(this.mState);
            }
            clearAnimation();
            Fv(0);
            this.lQn.lPz.setVisibility(0);
            this.hJQ.start();
            this.lQm.start();
            this.lQn.lPz.removeAnimatorListener(this.lQr);
            this.lQn.lPz.removeUpdateListener(this.lQq);
            this.lQn.lPz.addAnimatorUpdateListener(this.lQo);
            this.lQn.lPz.addAnimatorListener(this.lQp);
            this.lQn.lPz.setMinAndMaxProgress(0.0f, 1.0f);
            this.lQn.lPz.setProgress(0.0f);
            this.lQn.lPz.setSpeed(1.4f);
            this.lQn.lPz.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void aiD() {
        if (this.mState == 2) {
            this.lQn.vk(false);
            this.mState = 3;
            if (this.lQI != null) {
                this.lQI.El(this.mState);
            }
            this.lQn.lPz.setVisibility(0);
            com.baidu.adp.lib.f.e.ld().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.hJR.start();
                }
            }, 300L);
            this.lQn.vj(false);
            this.lQn.lPz.removeAnimatorListener(this.lQp);
            this.lQn.lPz.removeUpdateListener(this.lQo);
            this.lQn.lPz.addAnimatorUpdateListener(this.lQq);
            this.lQn.lPz.addAnimatorListener(this.lQr);
            this.lQn.lPz.setMinAndMaxProgress(0.0f, 1.0f);
            this.lQn.lPz.setProgress(1.0f);
            this.lQn.lPz.setSpeed(-1.68f);
            this.lQn.lPz.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dmp() {
        dmn();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.lQn.lPz.cancelAnimation();
    }

    private void clearAnimation() {
        this.hJQ.cancel();
        this.hJR.cancel();
        this.lQl.cancel();
        this.lQm.cancel();
    }

    private void Fv(int i) {
        this.lQn.lPy.setVisibility(i);
        this.lQn.deP.setVisibility(i);
        this.lQn.lPA.setVerticalGravity(i);
    }
}
