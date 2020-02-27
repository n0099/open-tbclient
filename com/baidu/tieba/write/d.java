package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class d extends g {
    private ValueAnimator gKm;
    private ValueAnimator gKn;
    private boolean kLC;
    private boolean kLD;
    private boolean kLE;
    private ValueAnimator kLF;
    private ValueAnimator kLG;
    private a.C0630a kLH;
    private ValueAnimator.AnimatorUpdateListener kLI;
    private Animator.AnimatorListener kLJ;
    private ValueAnimator.AnimatorUpdateListener kLK;
    private Animator.AnimatorListener kLL;

    public d(Context context, a.C0630a c0630a) {
        super(context, c0630a);
        this.kLC = false;
        this.kLD = false;
        this.kLE = false;
        this.kLI = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (d.this.kLC || animatedFraction < 0.6923f || !d.this.kLH.kKW.isAnimating()) {
                    if (!d.this.kLE && animatedFraction >= 0.38461f && d.this.kLH.kKW.isAnimating()) {
                        d.this.kLE = true;
                        return;
                    }
                    return;
                }
                d.this.kLC = true;
            }
        };
        this.kLJ = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUf();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLK = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                if (!d.this.kLD && animatedFraction >= 0.57142f && d.this.kLH.kKW.isAnimating()) {
                    d.this.kLD = true;
                    d.this.cUg();
                }
            }
        };
        this.kLL = new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.cUh();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        };
        this.kLH = c0630a;
        init();
    }

    private void init() {
        this.gKm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gKm.setDuration(451L);
        this.gKm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLH.cuy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLH.cuy.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gKn = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gKn.setDuration(485L);
        this.gKn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.kLH.cuy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.kLH.cuy.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLF.setDuration(104L);
        this.kLF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kLF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
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
        this.kLG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLG.setDuration(208L);
        this.kLG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning() && d.this.mAnchorView != null) {
                    d.this.mAnchorView.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.kLG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
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
    public void cUf() {
        this.kLH.kKW.setVisibility(0);
        this.kLH.tF(true);
        this.mState = 2;
        if (this.kMb != null) {
            this.kMb.CO(this.mState);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUg() {
        this.kLF.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUh() {
        this.kLC = false;
        this.kLE = false;
        this.kLD = false;
        this.kLH.tF(false);
        if (this.cYw != null) {
            this.cYw.setVisibility(0);
        }
        if (this.mAnchorView != null) {
            this.mAnchorView.setAlpha(1.0f);
            this.mAnchorView.setVisibility(0);
        }
        clearAnimation();
        Eb(8);
        this.mState = 4;
        if (this.kMb != null) {
            this.kMb.CO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUi() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kMb != null) {
                this.kMb.CO(this.mState);
            }
            clearAnimation();
            Eb(0);
            this.kLH.kKW.setVisibility(0);
            this.gKm.start();
            this.kLG.start();
            this.kLH.kKW.removeAnimatorListener(this.kLL);
            this.kLH.kKW.removeUpdateListener(this.kLK);
            this.kLH.kKW.addAnimatorUpdateListener(this.kLI);
            this.kLH.kKW.addAnimatorListener(this.kLJ);
            this.kLH.kKW.setMinAndMaxProgress(0.0f, 0.54f);
            this.kLH.kKW.setProgress(0.0f);
            this.kLH.kKW.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kMb != null) {
                this.kMb.CO(this.mState);
            }
            this.kLH.kKW.setVisibility(0);
            com.baidu.adp.lib.f.e.gx().postDelayed(new Runnable() { // from class: com.baidu.tieba.write.d.5
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gKn.start();
                }
            }, 300L);
            this.kLH.tF(false);
            this.kLH.kKW.removeAnimatorListener(this.kLJ);
            this.kLH.kKW.removeUpdateListener(this.kLI);
            this.kLH.kKW.addAnimatorUpdateListener(this.kLK);
            this.kLH.kKW.addAnimatorListener(this.kLL);
            this.kLH.kKW.setMinAndMaxProgress(0.54f, 1.0f);
            this.kLH.kKW.setProgress(0.0f);
            this.kLH.kKW.playAnimation();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUj() {
        cUh();
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
        this.kLH.kKW.cancelAnimation();
    }

    private void clearAnimation() {
        this.gKm.cancel();
        this.gKn.cancel();
        this.kLF.cancel();
        this.kLG.cancel();
    }

    private void Eb(int i) {
        this.kLH.kKV.setVisibility(i);
        this.kLH.cuy.setVisibility(i);
        this.kLH.kKX.setVerticalGravity(i);
    }
}
