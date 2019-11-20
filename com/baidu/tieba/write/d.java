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
    private ValueAnimator fQM;
    private ValueAnimator fQN;
    private ValueAnimator jMh;
    private ValueAnimator jMi;
    private ValueAnimator jMu;
    private ValueAnimator jMv;
    private float jMw;
    private float jMx;
    private float jMy;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jMu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMu.setDuration(450L);
        this.jMu.setInterpolator(new OvershootInterpolator());
        this.jMu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jMw != 0.0f || d.this.jMx != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jMA.jNb.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jMA.jNb.setTranslationX(d.this.jMw - (d.this.jMw * valueAnimator.getAnimatedFraction()));
                    d.this.jMA.jNb.setTranslationY(d.this.jMx - (d.this.jMx * valueAnimator.getAnimatedFraction()));
                    d.this.jMA.jNb.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.chz != null) {
                    d.this.chz.setVisibility(4);
                    d.this.chz.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMA.jNb.setTranslationX(0.0f);
                d.this.jMA.jNb.setTranslationY(0.0f);
                d.this.jMA.jNb.setRotation(-135.0f);
                d.this.jMA.jNb.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMv = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMv.setDuration(300L);
        this.jMv.setInterpolator(new AccelerateInterpolator());
        this.jMv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jMw != 0.0f || d.this.jMx != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jMA.jNb.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jMA.jNb.setTranslationX(d.this.jMw * valueAnimator.getAnimatedFraction());
                    d.this.jMA.jNb.setTranslationY(d.this.jMx * valueAnimator.getAnimatedFraction());
                    d.this.jMA.jNb.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jMv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMA.jNb.setTranslationX(d.this.jMw);
                d.this.jMA.jNb.setTranslationY(d.this.jMx);
                d.this.jMA.jNb.setRotation(0.0f);
                d.this.jMA.jNb.setCrossFade(0.0f);
                if (d.this.chz != null) {
                    d.this.chz.setVisibility(0);
                    d.this.chz.setAlpha(1.0f);
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
        this.fQM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fQM.setDuration(500L);
        this.fQM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMA.jMN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMA.jMO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.fQM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMA.jMN.setAlpha(1.0f);
                d.this.jMA.jMO.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fQN = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.fQN.setDuration(300L);
        this.fQN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMA.jMN.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMA.jMO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jMA.jNe.getVisibility() == 0 && d.this.jMA.jNd.getVisibility() == 0) {
                        d.this.jMA.jNe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jMA.jNd.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.fQN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMA.jMN.setAlpha(0.0f);
                d.this.jMA.jMO.setAlpha(0.0f);
                if (d.this.jMA.jNe.getVisibility() == 0 && d.this.jMA.jNd.getVisibility() == 0) {
                    d.this.jMA.jNe.setAlpha(0.0f);
                    d.this.jMA.jNd.setAlpha(0);
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
        this.jMh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jMh.setDuration(450L);
        this.jMh.setInterpolator(new OvershootInterpolator(1.0f));
        this.jMh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMA.jNc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMA.jNc.setTranslationY(d.this.jMy - (d.this.jMy * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jMh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jMA.jMZ.setClickable(false);
                d.this.jMA.jMW.setClickable(false);
                d.this.jMA.jMT.setClickable(false);
                d.this.jMA.jMQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMA.jNc.setAlpha(1.0f);
                d.this.jMA.jNc.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jMI != null) {
                    d.this.jMI.Bw(d.this.mState);
                }
                d.this.jMA.jMZ.setClickable(true);
                d.this.jMA.jMW.setClickable(true);
                d.this.jMA.jMT.setClickable(true);
                d.this.jMA.jMQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMi = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jMi.setDuration(300L);
        this.jMi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jMA.jNc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jMA.jNc.setTranslationY(d.this.jMy * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jMi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jMA.jMZ.setClickable(false);
                d.this.jMA.jMW.setClickable(false);
                d.this.jMA.jMT.setClickable(false);
                d.this.jMA.jMQ.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jMA.jNc.setAlpha(0.0f);
                d.this.jMA.jNc.setTranslationY(d.this.jMy);
                d.this.cxF();
                d.this.jMA.jMZ.setClickable(true);
                d.this.jMA.jMW.setClickable(true);
                d.this.jMA.jMT.setClickable(true);
                d.this.jMA.jMQ.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jMA.jMS.setVisibility(0);
        this.jMA.jMP.setVisibility(0);
        this.jMA.jMV.setVisibility(0);
        this.jMA.jMY.setVisibility(0);
        this.jMy = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cxG() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jMI != null) {
                this.jMI.Bw(this.mState);
            }
            clearAnimation();
            Bt(0);
            this.fQM.start();
            this.jMh.start();
            cxL();
        }
    }

    private void cxL() {
        this.jMA.jNb.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jNg != null && d.this.jMw == 0.0f && d.this.jMx == 0.0f) {
                    d.this.jMA.jNb.getGlobalVisibleRect(d.this.jNh);
                    d.this.jMw = d.this.jNg.centerX() - d.this.jNh.centerX();
                    d.this.jMx = d.this.jNg.centerY() - d.this.jNh.centerY();
                }
                d.this.jMA.jNb.setVisibility(0);
                d.this.jMA.jNb.setTranslationX(d.this.jMw);
                d.this.jMA.jNb.setTranslationY(d.this.jMx);
                if (d.this.chz instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.chz).a(d.this.jMA.jNb);
                }
                d.this.jMu.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void cxI() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jMI != null) {
                this.jMI.Bw(this.mState);
            }
            clearAnimation();
            this.fQN.start();
            this.jMv.start();
            this.jMi.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void cxJ() {
        cxF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxF() {
        if (this.chz != null) {
            this.chz.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Bt(8);
        this.jMA.jNb.setVisibility(4);
        if (this.chz != null) {
            this.chz.setVisibility(0);
            this.chz.setAlpha(1.0f);
        }
        if (this.jMI != null) {
            this.jMI.Bw(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jMu.cancel();
        this.jMv.cancel();
        this.fQN.cancel();
        this.fQM.cancel();
    }

    private void Bt(int i) {
        this.jMA.jMO.setVisibility(i);
        this.jMA.jMN.setVisibility(i);
        this.jMA.jNc.setVisibility(i);
    }
}
