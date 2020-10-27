package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator jaI;
    private ValueAnimator jaJ;
    private boolean nyh;
    private boolean nyi;
    private boolean nyj;
    private ValueAnimator nyk;
    private ValueAnimator nyl;
    private a.b nym;
    private ValueAnimator.AnimatorUpdateListener nyn;
    private Animator.AnimatorListener nyo;
    private ValueAnimator.AnimatorUpdateListener nyp;
    private Animator.AnimatorListener nyq;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.nyh = false;
        this.nyi = false;
        this.nyj = false;
        this.nyn = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.nyh || animatedFraction < 0.6923f || !d.this.nym.nxq.isAnimating()) {
                    if (!d.this.nyj && animatedFraction >= 0.38461f && d.this.nym.nxq.isAnimating()) {
                        d.this.nyj = true;
                        return;
                    }
                    return;
                }
                d.this.nyh = true;
            }
        };
        this.nyo = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dQw();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nyp = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.nyi && animatedFraction >= 0.57142f && d.this.nym.nxq.isAnimating()) {
                    d.this.nyi = true;
                    d.this.dQx();
                }
            }
        };
        this.nyq = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dQy();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.nym = bVar;
        init();
    }

    private void init() {
        this.jaI = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jaI.setDuration(451L);
        this.jaI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nym.dWb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jaI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nym.dWb.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jaJ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jaJ.setDuration(485L);
        this.jaJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.nym.dWb.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jaJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.nym.dWb.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.nyk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.nyk.setDuration(104L);
        this.nyk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nyk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.nyl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.nyl.setDuration(208L);
        this.nyl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.nyl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dQw() {
        this.nym.nxq.setVisibility(0);
        this.nym.yd(true);
        this.mState = 2;
        if (this.nyK != null) {
            this.nyK.KY(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQx() {
        this.nyk.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dQy() {
        this.nyh = false;
        this.nyj = false;
        this.nyi = false;
        this.nym.yd(false);
        if (this.eFT != null) {
            this.eFT.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        KV(8);
        this.mState = 4;
        if (this.nyK != null) {
            this.nyK.KY(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dQz() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.nyK != null) {
                this.nyK.KY(this.mState);
            }
            clearAnimation();
            KV(0);
            this.nym.nxq.setVisibility(0);
            this.jaI.start();
            this.nyl.start();
            this.nym.nxq.removeAnimatorListener(this.nyq);
            this.nym.nxq.removeUpdateListener(this.nyp);
            this.nym.nxq.addAnimatorUpdateListener(this.nyn);
            this.nym.nxq.addAnimatorListener(this.nyo);
            this.nym.nxq.setMinAndMaxProgress(0.0f, 1.0f);
            this.nym.nxq.setProgress(0.0f);
            this.nym.nxq.setSpeed(1.4f);
            this.nym.nxq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void ayb() {
        if (this.mState == 2) {
            this.nym.ye(false);
            this.mState = 3;
            if (this.nyK != null) {
                this.nyK.KY(this.mState);
            }
            this.nym.nxq.setVisibility(0);
            com.baidu.adp.lib.f.e.mY().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.jaJ.start();
                }
            }, 300L);
            this.nym.yd(false);
            this.nym.nxq.removeAnimatorListener(this.nyo);
            this.nym.nxq.removeUpdateListener(this.nyn);
            this.nym.nxq.addAnimatorUpdateListener(this.nyp);
            this.nym.nxq.addAnimatorListener(this.nyq);
            this.nym.nxq.setMinAndMaxProgress(0.0f, 1.0f);
            this.nym.nxq.setProgress(1.0f);
            this.nym.nxq.setSpeed(-1.68f);
            this.nym.nxq.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dQA() {
        dQy();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.nym.nxq.cancelAnimation();
    }

    private void clearAnimation() {
        this.jaI.cancel();
        this.jaJ.cancel();
        this.nyk.cancel();
        this.nyl.cancel();
    }

    private void KV(int i) {
        this.nym.nxp.setVisibility(i);
        this.nym.dWb.setVisibility(i);
        this.nym.nxr.setVerticalGravity(i);
    }
}
