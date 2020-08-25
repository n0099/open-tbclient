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
import com.baidu.tieba.write.a;
/* loaded from: classes2.dex */
public class e extends h {
    private int eWy;
    private ValueAnimator hTQ;
    private ValueAnimator irX;
    private ValueAnimator irY;
    private ValueAnimator mMg;
    private ValueAnimator mMh;
    private float mMi;
    private float mMj;
    private ValueAnimator mMk;
    private float mMl;
    private float mMm;
    private a.c mMn;

    public e(Context context, a.c cVar) {
        super(context, cVar);
        this.mMn = cVar;
        this.eWy = l.getDimens(this.mContext, R.dimen.tbds9);
        init();
    }

    private void init() {
        this.mMg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMg.setDuration(450L);
        this.mMg.setInterpolator(new OvershootInterpolator());
        this.mMg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mMi != 0.0f || e.this.mMj != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mMn.mLH.setCrossFade(valueAnimator.getAnimatedFraction(), false);
                    e.this.mMn.mLH.setTranslationX(e.this.mMi - (e.this.mMi * valueAnimator.getAnimatedFraction()));
                    e.this.mMn.mLH.setTranslationY(e.this.mMj - (e.this.mMj * valueAnimator.getAnimatedFraction()));
                    e.this.mMn.mLH.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.mMg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.eiT != null) {
                    e.this.eiT.setVisibility(4);
                    e.this.eiT.setAlpha(0.0f);
                }
                e.this.mMn.mLH.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eWy);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMn.mLH.setTranslationX(0.0f);
                e.this.mMn.mLH.setTranslationY(0.0f);
                e.this.mMn.mLH.setRotation(-135.0f);
                e.this.mMn.mLH.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eWy);
                e.this.mMn.mLH.setCrossFade(1.0f, false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mMh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMh.setDuration(200L);
        this.mMh.setInterpolator(new AccelerateInterpolator());
        this.mMh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.mMi != 0.0f || e.this.mMj != 0.0f) && valueAnimator.isRunning()) {
                    e.this.mMn.mLH.setCrossFade(valueAnimator.getAnimatedFraction(), true);
                    e.this.mMn.mLH.setTranslationX(e.this.mMi * valueAnimator.getAnimatedFraction());
                    e.this.mMn.mLH.setTranslationY(e.this.mMj * valueAnimator.getAnimatedFraction());
                    e.this.mMn.mLH.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mMh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mMn.mLH.setEndIcon(R.drawable.ic_icon_pure_post_colse24_svg, e.this.eWy);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMn.mLH.setTranslationX(e.this.mMi);
                e.this.mMn.mLH.setTranslationY(e.this.mMj);
                e.this.mMn.mLH.setRotation(0.0f);
                e.this.mMn.mLH.setEndIcon(0, 0);
                e.this.mMn.mLH.setCrossFade(1.0f, true);
                if (e.this.eiT != null) {
                    e.this.eiT.setVisibility(0);
                    e.this.eiT.setAlpha(1.0f);
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
        this.irX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.irX.setDuration(416L);
        this.irX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMn.mLI.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMn.mLd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMn.mLm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.irX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMn.mLI.setAlpha(1.0f);
                e.this.mMn.mLd.setAlpha(1.0f);
                e.this.mMn.mLm.setAlpha(1.0f);
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
        this.irY.setDuration(200L);
        this.irY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMn.mLd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMn.mLm.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.irY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMn.mLd.setAlpha(0.0f);
                e.this.mMn.mLm.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mMk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mMk.setDuration(500L);
        this.mMk.setInterpolator(new OvershootInterpolator(1.0f));
        this.mMk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMn.mLI.setTranslationY(e.this.mMl - (e.this.mMl * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.mMk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mMn.mLx.setClickable(false);
                e.this.mMn.mLu.setClickable(false);
                e.this.mMn.mLr.setClickable(false);
                e.this.mMn.mLo.setClickable(false);
                e.this.mMn.mLz.setClickable(false);
                e.this.mMn.mLB.setClickable(false);
                e.this.mMn.mLE.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMn.mLI.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.mMw != null) {
                    e.this.mMw.Jw(e.this.mState);
                }
                e.this.mMn.mLx.setClickable(true);
                e.this.mMn.mLu.setClickable(true);
                e.this.mMn.mLr.setClickable(true);
                e.this.mMn.mLo.setClickable(true);
                e.this.mMn.mLz.setClickable(true);
                e.this.mMn.mLB.setClickable(true);
                e.this.mMn.mLE.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hTQ = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.hTQ.setDuration(200L);
        this.hTQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.mMn.mLI.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.mMn.mLI.setTranslationY(e.this.mMm * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.hTQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.mMn.mLx.setClickable(false);
                e.this.mMn.mLu.setClickable(false);
                e.this.mMn.mLr.setClickable(false);
                e.this.mMn.mLo.setClickable(false);
                e.this.mMn.mLz.setClickable(false);
                e.this.mMn.mLB.setClickable(false);
                e.this.mMn.mLE.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.mMn.mLI.setAlpha(0.0f);
                e.this.mMn.mLI.setTranslationY(e.this.mMm);
                e.this.dFB();
                e.this.mMn.mLx.setClickable(true);
                e.this.mMn.mLu.setClickable(true);
                e.this.mMn.mLr.setClickable(true);
                e.this.mMn.mLo.setClickable(true);
                e.this.mMn.mLz.setClickable(true);
                e.this.mMn.mLB.setClickable(true);
                e.this.mMn.mLE.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mMn.mLq.setVisibility(0);
        this.mMn.mLn.setVisibility(0);
        this.mMn.mLt.setVisibility(0);
        this.mMn.mLw.setVisibility(0);
        this.mMn.mLz.setVisibility(0);
        if (this.mMn.mLB.getVisibility() != 8) {
            this.mMn.mLB.setVisibility(0);
        }
        this.mMl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds360);
        this.mMm = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds177);
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
            this.irX.start();
            this.mMk.start();
            dFE();
        }
    }

    private void dFE() {
        this.mMn.mLH.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.mMB != null && e.this.mMi == 0.0f && e.this.mMj == 0.0f) {
                    e.this.mMn.mLH.getGlobalVisibleRect(e.this.mMC);
                    e.this.mMi = e.this.mMB.centerX() - e.this.mMC.centerX();
                    e.this.mMj = e.this.mMB.centerY() - e.this.mMC.centerY();
                }
                e.this.mMn.mLH.setVisibility(0);
                e.this.mMn.mLH.setTranslationX(e.this.mMi);
                e.this.mMn.mLH.setTranslationY(e.this.mMj);
                if (e.this.eiT instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.eiT).a(e.this.mMn.mLH);
                }
                e.this.mMg.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.h
    public void asN() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.mMw != null) {
                this.mMw.Jw(this.mState);
            }
            clearAnimation();
            this.irY.start();
            this.mMh.start();
            this.hTQ.start();
        }
    }

    @Override // com.baidu.tieba.write.h
    public void dFD() {
        dFB();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dFB() {
        if (this.eiT != null) {
            this.eiT.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Jt(8);
        this.mMn.mLH.setVisibility(4);
        if (this.eiT != null) {
            this.eiT.setVisibility(0);
            this.eiT.setAlpha(1.0f);
        }
        if (this.mMw != null) {
            this.mMw.Jw(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.h
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.mMg.cancel();
        this.mMh.cancel();
        this.irY.cancel();
        this.irX.cancel();
    }

    private void Jt(int i) {
        this.mMn.mLm.setVisibility(i);
        this.mMn.mLd.setVisibility(i);
        this.mMn.mLI.setVisibility(i);
    }
}
