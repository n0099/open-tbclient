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
    private ValueAnimator fSk;
    private ValueAnimator fSl;
    private ValueAnimator jOS;
    private ValueAnimator jOT;
    private ValueAnimator jPf;
    private ValueAnimator jPg;
    private float jPh;
    private float jPi;
    private float jPj;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jPf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jPf.setDuration(450L);
        this.jPf.setInterpolator(new OvershootInterpolator());
        this.jPf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jPh != 0.0f || d.this.jPi != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jPl.jPM.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jPl.jPM.setTranslationX(d.this.jPh - (d.this.jPh * valueAnimator.getAnimatedFraction()));
                    d.this.jPl.jPM.setTranslationY(d.this.jPi - (d.this.jPi * valueAnimator.getAnimatedFraction()));
                    d.this.jPl.jPM.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jPf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bRL != null) {
                    d.this.bRL.setVisibility(4);
                    d.this.bRL.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jPl.jPM.setTranslationX(0.0f);
                d.this.jPl.jPM.setTranslationY(0.0f);
                d.this.jPl.jPM.setRotation(-135.0f);
                d.this.jPl.jPM.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jPg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jPg.setDuration(300L);
        this.jPg.setInterpolator(new AccelerateInterpolator());
        this.jPg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jPh != 0.0f || d.this.jPi != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jPl.jPM.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jPl.jPM.setTranslationX(d.this.jPh * valueAnimator.getAnimatedFraction());
                    d.this.jPl.jPM.setTranslationY(d.this.jPi * valueAnimator.getAnimatedFraction());
                    d.this.jPl.jPM.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jPg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jPl.jPM.setTranslationX(d.this.jPh);
                d.this.jPl.jPM.setTranslationY(d.this.jPi);
                d.this.jPl.jPM.setRotation(0.0f);
                d.this.jPl.jPM.setCrossFade(0.0f);
                if (d.this.bRL != null) {
                    d.this.bRL.setVisibility(0);
                    d.this.bRL.setAlpha(1.0f);
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
        this.fSk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fSk.setDuration(500L);
        this.fSk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jPl.jPy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jPl.jPz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fSk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jPl.jPy.setAlpha(1.0f);
                d.this.jPl.jPz.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fSl = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fSl.setDuration(300L);
        this.fSl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jPl.jPy.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jPl.jPz.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jPl.jPP.getVisibility() == 0 && d.this.jPl.jPO.getVisibility() == 0) {
                        d.this.jPl.jPP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jPl.jPO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fSl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jPl.jPy.setAlpha(0.0f);
                d.this.jPl.jPz.setAlpha(0.0f);
                if (d.this.jPl.jPP.getVisibility() == 0 && d.this.jPl.jPO.getVisibility() == 0) {
                    d.this.jPl.jPP.setAlpha(0.0f);
                    d.this.jPl.jPO.setAlpha(0);
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
        this.jOS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jOS.setDuration(450L);
        this.jOS.setInterpolator(new OvershootInterpolator(1.0f));
        this.jOS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jPl.jPN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jPl.jPN.setTranslationY(d.this.jPj - (d.this.jPj * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jOS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jPl.jPK.setClickable(false);
                d.this.jPl.jPH.setClickable(false);
                d.this.jPl.jPE.setClickable(false);
                d.this.jPl.jPB.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jPl.jPN.setAlpha(1.0f);
                d.this.jPl.jPN.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jPt != null) {
                    d.this.jPt.CT(d.this.mState);
                }
                d.this.jPl.jPK.setClickable(true);
                d.this.jPl.jPH.setClickable(true);
                d.this.jPl.jPE.setClickable(true);
                d.this.jPl.jPB.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jOT = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jOT.setDuration(300L);
        this.jOT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jPl.jPN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jPl.jPN.setTranslationY(d.this.jPj * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jOT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jPl.jPK.setClickable(false);
                d.this.jPl.jPH.setClickable(false);
                d.this.jPl.jPE.setClickable(false);
                d.this.jPl.jPB.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jPl.jPN.setAlpha(0.0f);
                d.this.jPl.jPN.setTranslationY(d.this.jPj);
                d.this.cAw();
                d.this.jPl.jPK.setClickable(true);
                d.this.jPl.jPH.setClickable(true);
                d.this.jPl.jPE.setClickable(true);
                d.this.jPl.jPB.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jPl.jPD.setVisibility(0);
        this.jPl.jPA.setVisibility(0);
        this.jPl.jPG.setVisibility(0);
        this.jPl.jPJ.setVisibility(0);
        this.jPj = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cAx() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jPt != null) {
                this.jPt.CT(this.mState);
            }
            clearAnimation();
            CQ(0);
            this.fSk.start();
            this.jOS.start();
            cAC();
        }
    }

    private void cAC() {
        this.jPl.jPM.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jPR != null && d.this.jPh == 0.0f && d.this.jPi == 0.0f) {
                    d.this.jPl.jPM.getGlobalVisibleRect(d.this.jPS);
                    d.this.jPh = d.this.jPR.centerX() - d.this.jPS.centerX();
                    d.this.jPi = d.this.jPR.centerY() - d.this.jPS.centerY();
                }
                d.this.jPl.jPM.setVisibility(0);
                d.this.jPl.jPM.setTranslationX(d.this.jPh);
                d.this.jPl.jPM.setTranslationY(d.this.jPi);
                if (d.this.bRL instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bRL).a(d.this.jPl.jPM);
                }
                d.this.jPf.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cAz() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jPt != null) {
                this.jPt.CT(this.mState);
            }
            clearAnimation();
            this.fSl.start();
            this.jPg.start();
            this.jOT.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cAA() {
        cAw();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAw() {
        if (this.bRL != null) {
            this.bRL.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        CQ(8);
        this.jPl.jPM.setVisibility(4);
        if (this.bRL != null) {
            this.bRL.setVisibility(0);
            this.bRL.setAlpha(1.0f);
        }
        if (this.jPt != null) {
            this.jPt.CT(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jPf.cancel();
        this.jPg.cancel();
        this.fSl.cancel();
        this.fSk.cancel();
    }

    private void CQ(int i) {
        this.jPl.jPz.setVisibility(i);
        this.jPl.jPy.setVisibility(i);
        this.jPl.jPN.setVisibility(i);
    }
}
