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
    private int fOr;
    private ValueAnimator jIC;
    private ValueAnimator jID;
    private ValueAnimator jhv;
    private ValueAnimator odn;
    private ValueAnimator odo;
    private float odp;
    private float odq;
    private AnimatorSet odr;
    private ValueAnimator ods;
    private float odt;
    private float odu;
    private float odv;
    private float odw;
    private a.c odx;
    private com.baidu.tieba.b.d ody;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.odw = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.M_H_X009);
        this.odx = cVar;
        this.fOr = l.getDimens(this.mContext, R.dimen.tbds0);
        init();
    }

    private void init() {
        this.odr = new AnimatorSet();
        this.odn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.odn.setDuration(450L);
        this.odn.setInterpolator(new OvershootInterpolator());
        this.odn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.odp != 0.0f || e.this.odq != 0.0f) && valueAnimator.isRunning()) {
                    e.this.odx.ocO.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.odx.ocO.setTranslationX(e.this.odp - (e.this.odp * valueAnimator.getAnimatedFraction()));
                    e.this.odx.ocO.setTranslationY(e.this.odq - (e.this.odq * valueAnimator.getAnimatedFraction()));
                    e.this.odx.ocO.setRotation((-90.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.odn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eZA != null) {
                    e.this.eZA.setVisibility(4);
                    e.this.eZA.setAlpha(0.0f);
                }
                e.this.odx.ocO.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fOr, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.odx.ocO.setTranslationX(0.0f);
                e.this.odx.ocO.setTranslationY(0.0f);
                e.this.odx.ocO.setRotation(-90.0f);
                e.this.odx.ocO.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fOr, "webp");
                e.this.odx.ocO.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.odo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.odo.setDuration(450L);
        this.odo.setInterpolator(new AccelerateInterpolator());
        this.odo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.odp != 0.0f || e.this.odq != 0.0f) && valueAnimator.isRunning()) {
                    e.this.odx.ocO.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.odx.ocO.setTranslationX(e.this.odp * valueAnimator.getAnimatedFraction());
                    e.this.odx.ocO.setTranslationY(e.this.odq * valueAnimator.getAnimatedFraction());
                    e.this.odx.ocO.setRotation((-90.0f) + (90.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.odo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.odx.ocO.setEndIcon(R.drawable.icon_pure_frs_issue24, e.this.fOr, "webp");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.odx.ocO.setTranslationX(e.this.odp);
                e.this.odx.ocO.setTranslationY(e.this.odq);
                e.this.odx.ocO.setRotation(0.0f);
                e.this.odx.ocO.setEndIcon(0, 0, "");
                e.this.odx.ocO.setCrossFade(1.0f, true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jIC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jIC.setDuration(416L);
        this.jIC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.odx.ocP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.odx.ocj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.odx.oct.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jIC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.odx.ocP.setAlpha(1.0f);
                e.this.odx.ocj.setAlpha(1.0f);
                e.this.odx.oct.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jID = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jID.setDuration(200L);
        this.jID.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.odx.ocj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.odx.oct.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.jID.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.odx.ocj.setAlpha(0.0f);
                e.this.odx.oct.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ods = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ods.setDuration(240L);
        this.ods.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.odx.ocP.setTranslationY(e.this.odt - (e.this.odt * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.odr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.odx.ocE.setClickable(false);
                e.this.odx.ocB.setClickable(false);
                e.this.odx.ocy.setClickable(false);
                e.this.odx.ocv.setClickable(false);
                e.this.odx.ocG.setClickable(false);
                e.this.odx.ocI.setClickable(false);
                e.this.odx.ocL.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                com.baidu.tieba.b.e aF = new com.baidu.tieba.b.e(e.this.odv).aG(0.5f).aF(800.0f);
                e.this.ody = new com.baidu.tieba.b.d(e.this.odx.ocP, com.baidu.tieba.b.d.ioD).a(aF);
                e.this.ody.start();
                e.this.odx.ocP.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.odJ != null) {
                    e.this.odJ.Li(e.this.mState);
                }
                e.this.odx.ocE.setClickable(true);
                e.this.odx.ocB.setClickable(true);
                e.this.odx.ocy.setClickable(true);
                e.this.odx.ocv.setClickable(true);
                e.this.odx.ocG.setClickable(true);
                e.this.odx.ocI.setClickable(true);
                e.this.odx.ocL.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jhv = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jhv.setDuration(200L);
        this.jhv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.odx.ocP.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.odx.ocP.setTranslationY(e.this.odu * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jhv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.odx.ocE.setClickable(false);
                e.this.odx.ocB.setClickable(false);
                e.this.odx.ocy.setClickable(false);
                e.this.odx.ocv.setClickable(false);
                e.this.odx.ocG.setClickable(false);
                e.this.odx.ocI.setClickable(false);
                e.this.odx.ocL.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.odx.ocP.setAlpha(0.0f);
                e.this.odx.ocP.setTranslationY(e.this.odu);
                e.this.Sf();
                e.this.odx.ocE.setClickable(true);
                e.this.odx.ocB.setClickable(true);
                e.this.odx.ocy.setClickable(true);
                e.this.odx.ocv.setClickable(true);
                e.this.odx.ocG.setClickable(true);
                e.this.odx.ocI.setClickable(true);
                e.this.odx.ocL.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.odx.ocx.setVisibility(0);
        this.odx.ocu.setVisibility(0);
        this.odx.ocA.setVisibility(0);
        this.odx.ocD.setVisibility(0);
        this.odx.ocG.setVisibility(0);
        if (this.odx.ocI.getVisibility() != 8) {
            this.odx.ocI.setVisibility(0);
        }
        this.odt = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.odv = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds25);
        this.odu = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
        this.odr.play(this.ods);
    }

    @Override // com.baidu.tieba.write.h
    public void dWB() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.odJ != null) {
                this.odJ.Li(this.mState);
            }
            clearAnimation();
            Lf(0);
            this.jIC.start();
            this.odr.start();
            dWD();
        }
    }

    private void dWD() {
        this.odx.ocO.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.odO != null && e.this.odp == 0.0f && e.this.odq == 0.0f) {
                    e.this.odx.ocO.getGlobalVisibleRect(e.this.odP);
                    e.this.odp = e.this.odO.centerX() - e.this.odP.centerX();
                    e.this.odq = e.this.odO.centerY() - e.this.odP.centerY();
                }
                e.this.odx.ocO.setVisibility(0);
                e.this.odx.ocO.setTranslationX(e.this.odp);
                e.this.odx.ocO.setTranslationY(e.this.odq);
                if (e.this.eZA instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eZA).a(e.this.odx.ocO);
                }
                e.this.odn.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void aAZ() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.odJ != null) {
                this.odJ.Li(this.mState);
            }
            clearAnimation();
            this.jID.start();
            this.odo.start();
            this.jhv.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dWC() {
        Sf();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Sf() {
        if (this.eZA != null) {
            this.eZA.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Lf(8);
        this.odx.ocO.setVisibility(4);
        if (this.eZA != null) {
            this.eZA.setVisibility(0);
            this.eZA.setAlpha(1.0f);
        }
        if (this.odJ != null) {
            this.odJ.Li(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.odn.cancel();
        this.odo.cancel();
        this.jID.cancel();
        this.jIC.cancel();
    }

    private void Lf(int i) {
        this.odx.oct.setVisibility(i);
        this.odx.ocj.setVisibility(i);
        this.odx.ocP.setVisibility(i);
    }
}
