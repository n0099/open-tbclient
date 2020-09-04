package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends h {
    private ValueAnimator isd;
    private ValueAnimator ise;
    private boolean mMn;
    private boolean mMo;
    private boolean mMp;
    private ValueAnimator mMq;
    private ValueAnimator mMr;
    private a.b mMs;
    private ValueAnimator.AnimatorUpdateListener mMt;
    private Animator.AnimatorListener mMu;
    private ValueAnimator.AnimatorUpdateListener mMv;
    private Animator.AnimatorListener mMw;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.mMn = false;
        this.mMo = false;
        this.mMp = false;
        this.mMt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.mMn || animatedFraction < 0.6923f || !d.this.mMs.mLw.isAnimating()) {
                    if (!d.this.mMp && animatedFraction >= 0.38461f && d.this.mMs.mLw.isAnimating()) {
                        d.this.mMp = true;
                        return;
                    }
                    return;
                }
                d.this.mMn = true;
            }
        };
        this.mMu = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dFI();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mMv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.mMo && animatedFraction >= 0.57142f && d.this.mMs.mLw.isAnimating()) {
                    d.this.mMo = true;
                    d.this.dFJ();
                }
            }
        };
        this.mMw = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dFK();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mMs = bVar;
        init();
    }

    private void init() {
        this.isd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.isd.setDuration(451L);
        this.isd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mMs.dzC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.isd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mMs.dzC.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ise = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ise.setDuration(485L);
        this.ise.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mMs.dzC.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ise.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mMs.dzC.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mMq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMq.setDuration(104L);
        this.mMq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mMq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.mMr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mMr.setDuration(208L);
        this.mMr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mMr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dFI() {
        this.mMs.mLw.setVisibility(0);
        this.mMs.wW(true);
        this.mState = 2;
        if (this.mMO != null) {
            this.mMO.Jw(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFJ() {
        this.mMq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFK() {
        this.mMn = false;
        this.mMp = false;
        this.mMo = false;
        this.mMs.wW(false);
        if (this.eiX != null) {
            this.eiX.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Jt(8);
        this.mState = 4;
        if (this.mMO != null) {
            this.mMO.Jw(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFL() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mMO != null) {
                this.mMO.Jw(this.mState);
            }
            clearAnimation();
            Jt(0);
            this.mMs.mLw.setVisibility(0);
            this.isd.start();
            this.mMr.start();
            this.mMs.mLw.removeAnimatorListener(this.mMw);
            this.mMs.mLw.removeUpdateListener(this.mMv);
            this.mMs.mLw.addAnimatorUpdateListener(this.mMt);
            this.mMs.mLw.addAnimatorListener(this.mMu);
            this.mMs.mLw.setMinAndMaxProgress(0.0f, 1.0f);
            this.mMs.mLw.setProgress(0.0f);
            this.mMs.mLw.setSpeed(1.4f);
            this.mMs.mLw.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void asN() {
        if (this.mState == 2) {
            this.mMs.wX(false);
            this.mState = 3;
            if (this.mMO != null) {
                this.mMO.Jw(this.mState);
            }
            this.mMs.mLw.setVisibility(0);
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.ise.start();
                }
            }, 300L);
            this.mMs.wW(false);
            this.mMs.mLw.removeAnimatorListener(this.mMu);
            this.mMs.mLw.removeUpdateListener(this.mMt);
            this.mMs.mLw.addAnimatorUpdateListener(this.mMv);
            this.mMs.mLw.addAnimatorListener(this.mMw);
            this.mMs.mLw.setMinAndMaxProgress(0.0f, 1.0f);
            this.mMs.mLw.setProgress(1.0f);
            this.mMs.mLw.setSpeed(-1.68f);
            this.mMs.mLw.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFM() {
        dFK();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.mMs.mLw.cancelAnimation();
    }

    private void clearAnimation() {
        this.isd.cancel();
        this.ise.cancel();
        this.mMq.cancel();
        this.mMr.cancel();
    }

    private void Jt(int i) {
        this.mMs.mLv.setVisibility(i);
        this.mMs.dzC.setVisibility(i);
        this.mMs.mLx.setVerticalGravity(i);
    }
}
