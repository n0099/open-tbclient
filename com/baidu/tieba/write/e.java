package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.R;
import com.baidu.tieba.write.a;
/* loaded from: classes.dex */
public class e extends h {
    private int fPR;
    private ValueAnimator jKl;
    private ValueAnimator jKm;
    private ValueAnimator jjf;
    private float ofA;
    private float ofB;
    private float ofC;
    private a.c ofD;
    private com.baidu.tieba.b.d ofE;
    private ValueAnimator oft;
    private ValueAnimator ofu;
    private float ofv;
    private float ofw;
    private AnimatorSet ofx;
    private ValueAnimator ofy;
    private float ofz;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.ofC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.ofD = cVar;
        this.fPR = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.ofx = new AnimatorSet();
        this.oft = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.oft.setDuration(450L);
        this.oft.setInterpolator(new OvershootInterpolator());
        this.oft.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.ofv != 0.0f || e.this.ofw != 0.0f) && valueAnimator.isRunning()) {
                    e.this.ofD.oeT.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.ofD.oeT.setTranslationX(e.this.ofv - (e.this.ofv * valueAnimator.getAnimatedFraction()));
                    e.this.ofD.oeT.setTranslationY(e.this.ofw - (e.this.ofw * valueAnimator.getAnimatedFraction()));
                    e.this.ofD.oeT.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.oft.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.faZ != null) {
                    e.this.faZ.setVisibility(4);
                    e.this.faZ.setAlpha(0.0f);
                }
                e.this.ofD.oeT.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fPR, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ofD.oeT.setTranslationX(0.0f);
                e.this.ofD.oeT.setTranslationY(0.0f);
                e.this.ofD.oeT.setRotation(-90.0f);
                e.this.ofD.oeT.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fPR, "webp");
                e.this.ofD.oeT.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ofu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ofu.setDuration(450L);
        this.ofu.setInterpolator(new AccelerateInterpolator());
        this.ofu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.ofv != 0.0f || e.this.ofw != 0.0f) && valueAnimator.isRunning()) {
                    e.this.ofD.oeT.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.ofD.oeT.setTranslationX(e.this.ofv * valueAnimator.getAnimatedFraction());
                    e.this.ofD.oeT.setTranslationY(e.this.ofw * valueAnimator.getAnimatedFraction());
                    e.this.ofD.oeT.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.ofu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.ofD.oeT.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fPR, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ofD.oeT.setTranslationX(e.this.ofv);
                e.this.ofD.oeT.setTranslationY(e.this.ofw);
                e.this.ofD.oeT.setRotation(0.0f);
                e.this.ofD.oeT.setEndIcon(0, 0, "");
                e.this.ofD.oeT.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jKl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jKl.setDuration(416L);
        this.jKl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ofD.oeU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ofD.oep.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ofD.oey.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jKl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ofD.oeU.setAlpha(1.0f);
                e.this.ofD.oep.setAlpha(1.0f);
                e.this.ofD.oey.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jKm = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jKm.setDuration(200L);
        this.jKm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ofD.oep.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ofD.oey.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jKm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ofD.oep.setAlpha(0.0f);
                e.this.ofD.oey.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ofy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ofy.setDuration(240L);
        this.ofy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ofD.oeU.setTranslationY(e.this.ofz - (e.this.ofz * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.ofx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.ofD.oeJ.setClickable(false);
                e.this.ofD.oeG.setClickable(false);
                e.this.ofD.oeD.setClickable(false);
                e.this.ofD.oeA.setClickable(false);
                e.this.ofD.oeL.setClickable(false);
                e.this.ofD.oeN.setClickable(false);
                e.this.ofD.oeQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.b.e aJ = new com.baidu.tieba.b.e(e.this.ofB).aK(0.5f).aJ(800.0f);
                e.this.ofE = new com.baidu.tieba.b.d(e.this.ofD.oeU, com.baidu.tieba.b.d.iqm).a(aJ);
                e.this.ofE.start();
                e.this.ofD.oeU.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.ofP != null) {
                    e.this.ofP.Lm(e.this.mState);
                }
                e.this.ofD.oeJ.setClickable(true);
                e.this.ofD.oeG.setClickable(true);
                e.this.ofD.oeD.setClickable(true);
                e.this.ofD.oeA.setClickable(true);
                e.this.ofD.oeL.setClickable(true);
                e.this.ofD.oeN.setClickable(true);
                e.this.ofD.oeQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jjf = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jjf.setDuration(200L);
        this.jjf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.ofD.oeU.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.ofD.oeU.setTranslationY(e.this.ofA * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jjf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.ofD.oeJ.setClickable(false);
                e.this.ofD.oeG.setClickable(false);
                e.this.ofD.oeD.setClickable(false);
                e.this.ofD.oeA.setClickable(false);
                e.this.ofD.oeL.setClickable(false);
                e.this.ofD.oeN.setClickable(false);
                e.this.ofD.oeQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.ofD.oeU.setAlpha(0.0f);
                e.this.ofD.oeU.setTranslationY(e.this.ofA);
                e.this.Si();
                e.this.ofD.oeJ.setClickable(true);
                e.this.ofD.oeG.setClickable(true);
                e.this.ofD.oeD.setClickable(true);
                e.this.ofD.oeA.setClickable(true);
                e.this.ofD.oeL.setClickable(true);
                e.this.ofD.oeN.setClickable(true);
                e.this.ofD.oeQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ofD.oeC.setVisibility(0);
        this.ofD.oez.setVisibility(0);
        this.ofD.oeF.setVisibility(0);
        this.ofD.oeI.setVisibility(0);
        this.ofD.oeL.setVisibility(0);
        if (this.ofD.oeN.getVisibility() != 8) {
            this.ofD.oeN.setVisibility(0);
        }
        this.ofz = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.ofB = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.ofA = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.ofx.play(this.ofy);
    }

    @Override // com.baidu.tieba.write.h
    public void dWJ() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.ofP != null) {
                this.ofP.Lm(this.mState);
            }
            clearAnimation();
            Lj(0);
            this.jKl.start();
            this.ofx.start();
            dWL();
        }
    }

    private void dWL() {
        this.ofD.oeT.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.ofU != null && e.this.ofv == 0.0f && e.this.ofw == 0.0f) {
                    e.this.ofD.oeT.getGlobalVisibleRect(e.this.ofV);
                    e.this.ofv = e.this.ofU.centerX() - e.this.ofV.centerX();
                    e.this.ofw = e.this.ofU.centerY() - e.this.ofV.centerY();
                }
                e.this.ofD.oeT.setVisibility(0);
                e.this.ofD.oeT.setTranslationX(e.this.ofv);
                e.this.ofD.oeT.setTranslationY(e.this.ofw);
                if (e.this.faZ instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.faZ).a(e.this.ofD.oeT);
                }
                e.this.oft.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aBc() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.ofP != null) {
                this.ofP.Lm(this.mState);
            }
            clearAnimation();
            this.jKm.start();
            this.ofu.start();
            this.jjf.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWK() {
        Si();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Si() {
        if (this.faZ != null) {
            this.faZ.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Lj(8);
        this.ofD.oeT.setVisibility(4);
        if (this.faZ != null) {
            this.faZ.setVisibility(0);
            this.faZ.setAlpha(1.0f);
        }
        if (this.ofP != null) {
            this.ofP.Lm(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.oft.cancel();
        this.ofu.cancel();
        this.jKm.cancel();
        this.jKl.cancel();
    }

    private void Lj(int i) {
        this.ofD.oey.setVisibility(i);
        this.ofD.oep.setVisibility(i);
        this.ofD.oeU.setVisibility(i);
    }
}
