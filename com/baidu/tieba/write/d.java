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
    private ValueAnimator fRD;
    private ValueAnimator fRE;
    private ValueAnimator jMY;
    private ValueAnimator jMZ;
    private ValueAnimator jNl;
    private ValueAnimator jNm;
    private float jNn;
    private float jNo;
    private float jNp;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jNl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jNl.setDuration(450L);
        this.jNl.setInterpolator(new OvershootInterpolator());
        this.jNl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jNn != 0.0f || d.this.jNo != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jNr.jNS.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jNr.jNS.setTranslationX(d.this.jNn - (d.this.jNn * valueAnimator.getAnimatedFraction()));
                    d.this.jNr.jNS.setTranslationY(d.this.jNo - (d.this.jNo * valueAnimator.getAnimatedFraction()));
                    d.this.jNr.jNS.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jNl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.cir != null) {
                    d.this.cir.setVisibility(4);
                    d.this.cir.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jNr.jNS.setTranslationX(0.0f);
                d.this.jNr.jNS.setTranslationY(0.0f);
                d.this.jNr.jNS.setRotation(-135.0f);
                d.this.jNr.jNS.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jNm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jNm.setDuration(300L);
        this.jNm.setInterpolator(new AccelerateInterpolator());
        this.jNm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jNn != 0.0f || d.this.jNo != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jNr.jNS.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jNr.jNS.setTranslationX(d.this.jNn * valueAnimator.getAnimatedFraction());
                    d.this.jNr.jNS.setTranslationY(d.this.jNo * valueAnimator.getAnimatedFraction());
                    d.this.jNr.jNS.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jNm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jNr.jNS.setTranslationX(d.this.jNn);
                d.this.jNr.jNS.setTranslationY(d.this.jNo);
                d.this.jNr.jNS.setRotation(0.0f);
                d.this.jNr.jNS.setCrossFade(0.0f);
                if (d.this.cir != null) {
                    d.this.cir.setVisibility(0);
                    d.this.cir.setAlpha(1.0f);
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
        this.fRD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fRD.setDuration(500L);
        this.fRD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jNr.jNE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jNr.jNF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fRD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jNr.jNE.setAlpha(1.0f);
                d.this.jNr.jNF.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fRE = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fRE.setDuration(300L);
        this.fRE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jNr.jNE.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jNr.jNF.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jNr.jNV.getVisibility() == 0 && d.this.jNr.jNU.getVisibility() == 0) {
                        d.this.jNr.jNV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jNr.jNU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fRE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jNr.jNE.setAlpha(0.0f);
                d.this.jNr.jNF.setAlpha(0.0f);
                if (d.this.jNr.jNV.getVisibility() == 0 && d.this.jNr.jNU.getVisibility() == 0) {
                    d.this.jNr.jNV.setAlpha(0.0f);
                    d.this.jNr.jNU.setAlpha(0);
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
        this.jMY = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMY.setDuration(450L);
        this.jMY.setInterpolator(new OvershootInterpolator(1.0f));
        this.jMY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jNr.jNT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jNr.jNT.setTranslationY(d.this.jNp - (d.this.jNp * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jMY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jNr.jNQ.setClickable(false);
                d.this.jNr.jNN.setClickable(false);
                d.this.jNr.jNK.setClickable(false);
                d.this.jNr.jNH.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jNr.jNT.setAlpha(1.0f);
                d.this.jNr.jNT.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jNz != null) {
                    d.this.jNz.Bx(d.this.mState);
                }
                d.this.jNr.jNQ.setClickable(true);
                d.this.jNr.jNN.setClickable(true);
                d.this.jNr.jNK.setClickable(true);
                d.this.jNr.jNH.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMZ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMZ.setDuration(300L);
        this.jMZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jNr.jNT.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jNr.jNT.setTranslationY(d.this.jNp * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jNr.jNQ.setClickable(false);
                d.this.jNr.jNN.setClickable(false);
                d.this.jNr.jNK.setClickable(false);
                d.this.jNr.jNH.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jNr.jNT.setAlpha(0.0f);
                d.this.jNr.jNT.setTranslationY(d.this.jNp);
                d.this.cxH();
                d.this.jNr.jNQ.setClickable(true);
                d.this.jNr.jNN.setClickable(true);
                d.this.jNr.jNK.setClickable(true);
                d.this.jNr.jNH.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jNr.jNJ.setVisibility(0);
        this.jNr.jNG.setVisibility(0);
        this.jNr.jNM.setVisibility(0);
        this.jNr.jNP.setVisibility(0);
        this.jNp = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cxI() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jNz != null) {
                this.jNz.Bx(this.mState);
            }
            clearAnimation();
            Bu(0);
            this.fRD.start();
            this.jMY.start();
            cxN();
        }
    }

    private void cxN() {
        this.jNr.jNS.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jNX != null && d.this.jNn == 0.0f && d.this.jNo == 0.0f) {
                    d.this.jNr.jNS.getGlobalVisibleRect(d.this.jNY);
                    d.this.jNn = d.this.jNX.centerX() - d.this.jNY.centerX();
                    d.this.jNo = d.this.jNX.centerY() - d.this.jNY.centerY();
                }
                d.this.jNr.jNS.setVisibility(0);
                d.this.jNr.jNS.setTranslationX(d.this.jNn);
                d.this.jNr.jNS.setTranslationY(d.this.jNo);
                if (d.this.cir instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.cir).a(d.this.jNr.jNS);
                }
                d.this.jNl.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cxK() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jNz != null) {
                this.jNz.Bx(this.mState);
            }
            clearAnimation();
            this.fRE.start();
            this.jNm.start();
            this.jMZ.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cxL() {
        cxH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxH() {
        if (this.cir != null) {
            this.cir.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Bu(8);
        this.jNr.jNS.setVisibility(4);
        if (this.cir != null) {
            this.cir.setVisibility(0);
            this.cir.setAlpha(1.0f);
        }
        if (this.jNz != null) {
            this.jNz.Bx(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jNl.cancel();
        this.jNm.cancel();
        this.fRE.cancel();
        this.fRD.cancel();
    }

    private void Bu(int i) {
        this.jNr.jNF.setVisibility(i);
        this.jNr.jNE.setVisibility(i);
        this.jNr.jNT.setVisibility(i);
    }
}
