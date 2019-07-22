package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class d extends f {
    private ValueAnimator fPF;
    private ValueAnimator fPG;
    private ValueAnimator jLD;
    private ValueAnimator jLE;
    private float jLF;
    private float jLG;
    private float jLH;
    private ValueAnimator jLq;
    private ValueAnimator jLr;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jLD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLD.setDuration(450L);
        this.jLD.setInterpolator(new OvershootInterpolator());
        this.jLD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jLF != 0.0f || d.this.jLG != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jLJ.jMk.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jLJ.jMk.setTranslationX(d.this.jLF - (d.this.jLF * valueAnimator.getAnimatedFraction()));
                    d.this.jLJ.jMk.setTranslationY(d.this.jLG - (d.this.jLG * valueAnimator.getAnimatedFraction()));
                    d.this.jLJ.jMk.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jLD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bRe != null) {
                    d.this.bRe.setVisibility(4);
                    d.this.bRe.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jLJ.jMk.setTranslationX(0.0f);
                d.this.jLJ.jMk.setTranslationY(0.0f);
                d.this.jLJ.jMk.setRotation(-135.0f);
                d.this.jLJ.jMk.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLE.setDuration(300L);
        this.jLE.setInterpolator(new AccelerateInterpolator());
        this.jLE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jLF != 0.0f || d.this.jLG != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jLJ.jMk.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jLJ.jMk.setTranslationX(d.this.jLF * valueAnimator.getAnimatedFraction());
                    d.this.jLJ.jMk.setTranslationY(d.this.jLG * valueAnimator.getAnimatedFraction());
                    d.this.jLJ.jMk.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jLE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jLJ.jMk.setTranslationX(d.this.jLF);
                d.this.jLJ.jMk.setTranslationY(d.this.jLG);
                d.this.jLJ.jMk.setRotation(0.0f);
                d.this.jLJ.jMk.setCrossFade(0.0f);
                if (d.this.bRe != null) {
                    d.this.bRe.setVisibility(0);
                    d.this.bRe.setAlpha(1.0f);
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
        this.fPF = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fPF.setDuration(500L);
        this.fPF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jLJ.jLW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jLJ.jLX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fPF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jLJ.jLW.setAlpha(1.0f);
                d.this.jLJ.jLX.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fPG = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fPG.setDuration(300L);
        this.fPG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jLJ.jLW.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jLJ.jLX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jLJ.jMn.getVisibility() == 0 && d.this.jLJ.jMm.getVisibility() == 0) {
                        d.this.jLJ.jMn.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jLJ.jMm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fPG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jLJ.jLW.setAlpha(0.0f);
                d.this.jLJ.jLX.setAlpha(0.0f);
                if (d.this.jLJ.jMn.getVisibility() == 0 && d.this.jLJ.jMm.getVisibility() == 0) {
                    d.this.jLJ.jMn.setAlpha(0.0f);
                    d.this.jLJ.jMm.setAlpha(0);
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
        this.jLq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLq.setDuration(450L);
        this.jLq.setInterpolator(new OvershootInterpolator(1.0f));
        this.jLq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jLJ.jMl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jLJ.jMl.setTranslationY(d.this.jLH - (d.this.jLH * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jLq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jLJ.jMi.setClickable(false);
                d.this.jLJ.jMf.setClickable(false);
                d.this.jLJ.jMc.setClickable(false);
                d.this.jLJ.jLZ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jLJ.jMl.setAlpha(1.0f);
                d.this.jLJ.jMl.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jLR != null) {
                    d.this.jLR.CN(d.this.mState);
                }
                d.this.jLJ.jMi.setClickable(true);
                d.this.jLJ.jMf.setClickable(true);
                d.this.jLJ.jMc.setClickable(true);
                d.this.jLJ.jLZ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLr = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jLr.setDuration(300L);
        this.jLr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jLJ.jMl.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jLJ.jMl.setTranslationY(d.this.jLH * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jLr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jLJ.jMi.setClickable(false);
                d.this.jLJ.jMf.setClickable(false);
                d.this.jLJ.jMc.setClickable(false);
                d.this.jLJ.jLZ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jLJ.jMl.setAlpha(0.0f);
                d.this.jLJ.jMl.setTranslationY(d.this.jLH);
                d.this.czn();
                d.this.jLJ.jMi.setClickable(true);
                d.this.jLJ.jMf.setClickable(true);
                d.this.jLJ.jMc.setClickable(true);
                d.this.jLJ.jLZ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLJ.jMb.setVisibility(0);
        this.jLJ.jLY.setVisibility(0);
        this.jLJ.jMe.setVisibility(0);
        this.jLJ.jMh.setVisibility(0);
        this.jLH = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void czo() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jLR != null) {
                this.jLR.CN(this.mState);
            }
            clearAnimation();
            CK(0);
            this.fPF.start();
            this.jLq.start();
            czt();
        }
    }

    private void czt() {
        this.jLJ.jMk.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jMp != null && d.this.jLF == 0.0f && d.this.jLG == 0.0f) {
                    d.this.jLJ.jMk.getGlobalVisibleRect(d.this.jMq);
                    d.this.jLF = d.this.jMp.centerX() - d.this.jMq.centerX();
                    d.this.jLG = d.this.jMp.centerY() - d.this.jMq.centerY();
                }
                d.this.jLJ.jMk.setVisibility(0);
                d.this.jLJ.jMk.setTranslationX(d.this.jLF);
                d.this.jLJ.jMk.setTranslationY(d.this.jLG);
                if (d.this.bRe instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bRe).a(d.this.jLJ.jMk);
                }
                d.this.jLD.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void czq() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jLR != null) {
                this.jLR.CN(this.mState);
            }
            clearAnimation();
            this.fPG.start();
            this.jLE.start();
            this.jLr.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void czr() {
        czn();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void czn() {
        if (this.bRe != null) {
            this.bRe.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        CK(8);
        this.jLJ.jMk.setVisibility(4);
        if (this.bRe != null) {
            this.bRe.setVisibility(0);
            this.bRe.setAlpha(1.0f);
        }
        if (this.jLR != null) {
            this.jLR.CN(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jLD.cancel();
        this.jLE.cancel();
        this.fPG.cancel();
        this.fPF.cancel();
    }

    private void CK(int i) {
        this.jLJ.jLX.setVisibility(i);
        this.jLJ.jLW.setVisibility(i);
        this.jLJ.jMl.setVisibility(i);
    }
}
