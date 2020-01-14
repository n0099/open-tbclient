package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator gIn;
    private ValueAnimator gIo;
    private boolean kKW;
    private boolean kKX;
    private boolean kKY;
    private ValueAnimator kKZ;
    private ValueAnimator kLa;
    private a.C0622a kLb;
    private ValueAnimator.AnimatorUpdateListener kLc;
    private Animator.AnimatorListener kLd;
    private ValueAnimator.AnimatorUpdateListener kLe;
    private Animator.AnimatorListener kLf;

    public d(Context context, a.C0622a c0622a) {
        super(context, c0622a);
        this.kKW = false;
        this.kKX = false;
        this.kKY = false;
        this.kLc = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.kKW || animatedFraction < 0.6923f || !d.this.kLb.kKq.isAnimating()) {
                    if (!d.this.kKY && animatedFraction >= 0.38461f && d.this.kLb.kKq.isAnimating()) {
                        d.this.kKY = true;
                        return;
                    }
                    return;
                }
                d.this.kKW = true;
            }
        };
        this.kLd = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cSR();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLe = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.kKX && animatedFraction >= 0.57142f && d.this.kLb.kKq.isAnimating()) {
                    d.this.kKX = true;
                    d.this.cSS();
                }
            }
        };
        this.kLf = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cST();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLb = c0622a;
        init();
    }

    private void init() {
        this.gIn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gIn.setDuration(451L);
        this.gIn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLb.cqv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLb.cqv.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gIo = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gIo.setDuration(485L);
        this.gIo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLb.cqv.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gIo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLb.cqv.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kKZ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kKZ.setDuration(104L);
        this.kKZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kKZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.kLa = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLa.setDuration(208L);
        this.kLa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kLa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void cSR() {
        this.kLb.kKq.setVisibility(0);
        this.kLb.tB(true);
        this.mState = 2;
        if (this.kLv != null) {
            this.kLv.CI(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cSS() {
        this.kKZ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cST() {
        this.kKW = false;
        this.kKY = false;
        this.kKX = false;
        this.kLb.tB(false);
        if (this.cUu != null) {
            this.cUu.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        DW(8);
        this.mState = 4;
        if (this.kLv != null) {
            this.kLv.CI(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cSU() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kLv != null) {
                this.kLv.CI(this.mState);
            }
            clearAnimation();
            DW(0);
            this.kLb.kKq.setVisibility(0);
            this.gIn.start();
            this.kLa.start();
            this.kLb.kKq.removeAnimatorListener(this.kLf);
            this.kLb.kKq.removeUpdateListener(this.kLe);
            this.kLb.kKq.addAnimatorUpdateListener(this.kLc);
            this.kLb.kKq.addAnimatorListener(this.kLd);
            this.kLb.kKq.setMinAndMaxProgress(0.0f, 0.54f);
            this.kLb.kKq.setProgress(0.0f);
            this.kLb.kKq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kLv != null) {
                this.kLv.CI(this.mState);
            }
            this.kLb.kKq.setVisibility(0);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gIo.start();
                }
            }, 300L);
            this.kLb.tB(false);
            this.kLb.kKq.removeAnimatorListener(this.kLd);
            this.kLb.kKq.removeUpdateListener(this.kLc);
            this.kLb.kKq.addAnimatorUpdateListener(this.kLe);
            this.kLb.kKq.addAnimatorListener(this.kLf);
            this.kLb.kKq.setMinAndMaxProgress(0.54f, 1.0f);
            this.kLb.kKq.setProgress(0.0f);
            this.kLb.kKq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cSV() {
        cST();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.kLb.kKq.cancelAnimation();
    }

    private void clearAnimation() {
        this.gIn.cancel();
        this.gIo.cancel();
        this.kKZ.cancel();
        this.kLa.cancel();
    }

    private void DW(int i) {
        this.kLb.kKp.setVisibility(i);
        this.kLb.cqv.setVisibility(i);
        this.kLb.kKr.setVerticalGravity(i);
    }
}
