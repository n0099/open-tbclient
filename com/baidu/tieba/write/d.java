package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes2.dex */
public class d extends h {
    private ValueAnimator irX;
    private ValueAnimator irY;
    private boolean mLV;
    private boolean mLW;
    private boolean mLX;
    private ValueAnimator mLY;
    private ValueAnimator mLZ;
    private a.b mMa;
    private ValueAnimator.AnimatorUpdateListener mMb;
    private Animator.AnimatorListener mMc;
    private ValueAnimator.AnimatorUpdateListener mMd;
    private Animator.AnimatorListener mMe;

    public d(Context context, a.b bVar) {
        super(context, bVar);
        this.mLV = false;
        this.mLW = false;
        this.mLX = false;
        this.mMb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.mLV || animatedFraction < 0.6923f || !d.this.mMa.mLe.isAnimating()) {
                    if (!d.this.mLX && animatedFraction >= 0.38461f && d.this.mMa.mLe.isAnimating()) {
                        d.this.mLX = true;
                        return;
                    }
                    return;
                }
                d.this.mLV = true;
            }
        };
        this.mMc = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dFz();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mMd = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.mLW && animatedFraction >= 0.57142f && d.this.mMa.mLe.isAnimating()) {
                    d.this.mLW = true;
                    d.this.dFA();
                }
            }
        };
        this.mMe = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.dFB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.mMa = bVar;
        init();
    }

    private void init() {
        this.irX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.irX.setDuration(451L);
        this.irX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mMa.dzy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.irX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mMa.dzy.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.irY = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.irY.setDuration(485L);
        this.irY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.mMa.dzy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.irY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.mMa.dzy.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mLY = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mLY.setDuration(104L);
        this.mLY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mLY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.mLZ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mLZ.setDuration(208L);
        this.mLZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.mLZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void dFz() {
        this.mMa.mLe.setVisibility(0);
        this.mMa.wU(true);
        this.mState = 2;
        if (this.mMw != null) {
            this.mMw.Jw(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFA() {
        this.mLY.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFB() {
        this.mLV = false;
        this.mLX = false;
        this.mLW = false;
        this.mMa.wU(false);
        if (this.eiT != null) {
            this.eiT.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Jt(8);
        this.mState = 4;
        if (this.mMw != null) {
            this.mMw.Jw(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFC() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.mMw != null) {
                this.mMw.Jw(this.mState);
            }
            clearAnimation();
            Jt(0);
            this.mMa.mLe.setVisibility(0);
            this.irX.start();
            this.mLZ.start();
            this.mMa.mLe.removeAnimatorListener(this.mMe);
            this.mMa.mLe.removeUpdateListener(this.mMd);
            this.mMa.mLe.addAnimatorUpdateListener(this.mMb);
            this.mMa.mLe.addAnimatorListener(this.mMc);
            this.mMa.mLe.setMinAndMaxProgress(0.0f, 1.0f);
            this.mMa.mLe.setProgress(0.0f);
            this.mMa.mLe.setSpeed(1.4f);
            this.mMa.mLe.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void asN() {
        if (this.mState == 2) {
            this.mMa.wV(false);
            this.mState = 3;
            if (this.mMw != null) {
                this.mMw.Jw(this.mState);
            }
            this.mMa.mLe.setVisibility(0);
            com.baidu.adp.lib.f.e.mS().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.irY.start();
                }
            }, 300L);
            this.mMa.wU(false);
            this.mMa.mLe.removeAnimatorListener(this.mMc);
            this.mMa.mLe.removeUpdateListener(this.mMb);
            this.mMa.mLe.addAnimatorUpdateListener(this.mMd);
            this.mMa.mLe.addAnimatorListener(this.mMe);
            this.mMa.mLe.setMinAndMaxProgress(0.0f, 1.0f);
            this.mMa.mLe.setProgress(1.0f);
            this.mMa.mLe.setSpeed(-1.68f);
            this.mMa.mLe.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFD() {
        dFB();
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
        this.mMa.mLe.cancelAnimation();
    }

    private void clearAnimation() {
        this.irX.cancel();
        this.irY.cancel();
        this.mLY.cancel();
        this.mLZ.cancel();
    }

    private void Jt(int i) {
        this.mMa.mLd.setVisibility(i);
        this.mMa.dzy.setVisibility(i);
        this.mMa.mLf.setVerticalGravity(i);
    }
}
