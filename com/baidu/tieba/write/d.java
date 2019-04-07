package com.baidu.tieba.write;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.OvalActionButton;
import com.baidu.tieba.d;
import com.baidu.tieba.write.e;
/* loaded from: classes.dex */
public class d extends f {
    private ValueAnimator ftO;
    private ValueAnimator ftP;
    private ValueAnimator jlf;
    private ValueAnimator jlg;
    private ValueAnimator jls;
    private ValueAnimator jlt;
    private float jlu;
    private float jlv;
    private float jlw;

    public d(Context context, e.a aVar) {
        super(context, aVar);
        init();
    }

    private void init() {
        this.jls = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jls.setDuration(450L);
        this.jls.setInterpolator(new OvershootInterpolator());
        this.jls.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlu != 0.0f || d.this.jlv != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jly.jlX.setCrossFade(valueAnimator.getAnimatedFraction());
                    d.this.jly.jlX.setTranslationX(d.this.jlu - (d.this.jlu * valueAnimator.getAnimatedFraction()));
                    d.this.jly.jlX.setTranslationY(d.this.jlv - (d.this.jlv * valueAnimator.getAnimatedFraction()));
                    d.this.jly.jlX.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jls.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (d.this.bIs != null) {
                    d.this.bIs.setVisibility(4);
                    d.this.bIs.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jly.jlX.setTranslationX(0.0f);
                d.this.jly.jlX.setTranslationY(0.0f);
                d.this.jly.jlX.setRotation(-135.0f);
                d.this.jly.jlX.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlt = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlt.setDuration(300L);
        this.jlt.setInterpolator(new AccelerateInterpolator());
        this.jlt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((d.this.jlu != 0.0f || d.this.jlv != 0.0f) && valueAnimator.isRunning()) {
                    d.this.jly.jlX.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    d.this.jly.jlX.setTranslationX(d.this.jlu * valueAnimator.getAnimatedFraction());
                    d.this.jly.jlX.setTranslationY(d.this.jlv * valueAnimator.getAnimatedFraction());
                    d.this.jly.jlX.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jly.jlX.setTranslationX(d.this.jlu);
                d.this.jly.jlX.setTranslationY(d.this.jlv);
                d.this.jly.jlX.setRotation(0.0f);
                d.this.jly.jlX.setCrossFade(0.0f);
                if (d.this.bIs != null) {
                    d.this.bIs.setVisibility(0);
                    d.this.bIs.setAlpha(1.0f);
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
        this.ftO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ftO.setDuration(500L);
        this.ftO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jly.jlJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jly.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.ftO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jly.jlJ.setAlpha(1.0f);
                d.this.jly.jlK.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ftP = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.ftP.setDuration(300L);
        this.ftP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jly.jlJ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jly.jlK.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    if (d.this.jly.jma.getVisibility() == 0 && d.this.jly.jlZ.getVisibility() == 0) {
                        d.this.jly.jma.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        d.this.jly.jlZ.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                }
            }
        });
        this.ftP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jly.jlJ.setAlpha(0.0f);
                d.this.jly.jlK.setAlpha(0.0f);
                if (d.this.jly.jma.getVisibility() == 0 && d.this.jly.jlZ.getVisibility() == 0) {
                    d.this.jly.jma.setAlpha(0.0f);
                    d.this.jly.jlZ.setAlpha(0);
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
        this.jlf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jlf.setDuration(450L);
        this.jlf.setInterpolator(new OvershootInterpolator(1.0f));
        this.jlf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jly.jlY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jly.jlY.setTranslationY(d.this.jlw - (d.this.jlw * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.jlf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jly.jlV.setClickable(false);
                d.this.jly.jlS.setClickable(false);
                d.this.jly.jlP.setClickable(false);
                d.this.jly.jlM.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jly.jlY.setAlpha(1.0f);
                d.this.jly.jlY.setTranslationY(0.0f);
                d.this.mState = 2;
                if (d.this.jlG != null) {
                    d.this.jlG.AX(d.this.mState);
                }
                d.this.jly.jlV.setClickable(true);
                d.this.jly.jlS.setClickable(true);
                d.this.jly.jlP.setClickable(true);
                d.this.jly.jlM.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jlg = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.jlg.setDuration(300L);
        this.jlg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.d.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    d.this.jly.jlY.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    d.this.jly.jlY.setTranslationY(d.this.jlw * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.jlg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.d.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                d.this.jly.jlV.setClickable(false);
                d.this.jly.jlS.setClickable(false);
                d.this.jly.jlP.setClickable(false);
                d.this.jly.jlM.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                d.this.jly.jlY.setAlpha(0.0f);
                d.this.jly.jlY.setTranslationY(d.this.jlw);
                d.this.cof();
                d.this.jly.jlV.setClickable(true);
                d.this.jly.jlS.setClickable(true);
                d.this.jly.jlP.setClickable(true);
                d.this.jly.jlM.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jly.jlO.setVisibility(0);
        this.jly.jlL.setVisibility(0);
        this.jly.jlR.setVisibility(0);
        this.jly.jlU.setVisibility(0);
        this.jlw = l.h(TbadkCoreApplication.getInst(), d.e.tbds501);
    }

    @Override // com.baidu.tieba.write.f
    public void cog() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.jlG != null) {
                this.jlG.AX(this.mState);
            }
            clearAnimation();
            AU(0);
            this.ftO.start();
            this.jlf.start();
            col();
        }
    }

    private void col() {
        this.jly.jlX.post(new Runnable() { // from class: com.baidu.tieba.write.d.5
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.jmc != null && d.this.jlu == 0.0f && d.this.jlv == 0.0f) {
                    d.this.jly.jlX.getGlobalVisibleRect(d.this.jmd);
                    d.this.jlu = d.this.jmc.centerX() - d.this.jmd.centerX();
                    d.this.jlv = d.this.jmc.centerY() - d.this.jmd.centerY();
                }
                d.this.jly.jlX.setVisibility(0);
                d.this.jly.jlX.setTranslationX(d.this.jlu);
                d.this.jly.jlX.setTranslationY(d.this.jlv);
                if (d.this.bIs instanceof OvalActionButton) {
                    ((OvalActionButton) d.this.bIs).a(d.this.jly.jlX);
                }
                d.this.jls.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.f
    public void coi() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.jlG != null) {
                this.jlG.AX(this.mState);
            }
            clearAnimation();
            this.ftP.start();
            this.jlt.start();
            this.jlg.start();
        }
    }

    @Override // com.baidu.tieba.write.f
    public void coj() {
        cof();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cof() {
        if (this.bIs != null) {
            this.bIs.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        AU(8);
        this.jly.jlX.setVisibility(4);
        if (this.bIs != null) {
            this.bIs.setVisibility(0);
            this.bIs.setAlpha(1.0f);
        }
        if (this.jlG != null) {
            this.jlG.AX(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.f
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.jls.cancel();
        this.jlt.cancel();
        this.ftP.cancel();
        this.ftO.cancel();
    }

    private void AU(int i) {
        this.jly.jlK.setVisibility(i);
        this.jly.jlJ.setVisibility(i);
        this.jly.jlY.setVisibility(i);
    }
}
