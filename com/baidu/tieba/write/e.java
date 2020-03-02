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
/* loaded from: classes.dex */
public class e extends g {
    private ValueAnimator gKo;
    private ValueAnimator gKp;
    private ValueAnimator kLP;
    private ValueAnimator kLQ;
    private float kLR;
    private float kLS;
    private ValueAnimator kLT;
    private ValueAnimator kLU;
    private float kLV;
    private a.b kLW;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.kLW = bVar;
        init();
    }

    private void init() {
        this.kLP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLP.setDuration(450L);
        this.kLP.setInterpolator(new OvershootInterpolator());
        this.kLP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLR != 0.0f || e.this.kLS != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLW.kLq.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.kLW.kLq.setTranslationX(e.this.kLR - (e.this.kLR * valueAnimator.getAnimatedFraction()));
                    e.this.kLW.kLq.setTranslationY(e.this.kLS - (e.this.kLS * valueAnimator.getAnimatedFraction()));
                    e.this.kLW.kLq.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.cYx != null) {
                    e.this.cYx.setVisibility(4);
                    e.this.cYx.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLW.kLq.setTranslationX(0.0f);
                e.this.kLW.kLq.setTranslationY(0.0f);
                e.this.kLW.kLq.setRotation(-135.0f);
                e.this.kLW.kLq.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLQ.setDuration(300L);
        this.kLQ.setInterpolator(new AccelerateInterpolator());
        this.kLQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLR != 0.0f || e.this.kLS != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLW.kLq.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.kLW.kLq.setTranslationX(e.this.kLR * valueAnimator.getAnimatedFraction());
                    e.this.kLW.kLq.setTranslationY(e.this.kLS * valueAnimator.getAnimatedFraction());
                    e.this.kLW.kLq.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLW.kLq.setTranslationX(e.this.kLR);
                e.this.kLW.kLq.setTranslationY(e.this.kLS);
                e.this.kLW.kLq.setRotation(0.0f);
                e.this.kLW.kLq.setCrossFade(0.0f);
                if (e.this.cYx != null) {
                    e.this.cYx.setVisibility(0);
                    e.this.cYx.setAlpha(1.0f);
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
        this.gKo = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gKo.setDuration(500L);
        this.gKo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLW.kKX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLW.kLe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLW.kKX.setAlpha(1.0f);
                e.this.kLW.kLe.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gKp = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gKp.setDuration(300L);
        this.gKp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLW.kKX.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLW.kLe.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLW.kKX.setAlpha(0.0f);
                e.this.kLW.kLe.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLT.setDuration(450L);
        this.kLT.setInterpolator(new OvershootInterpolator(1.0f));
        this.kLT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLW.kLr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLW.kLr.setTranslationY(e.this.kLV - (e.this.kLV * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLW.kLo.setClickable(false);
                e.this.kLW.kLl.setClickable(false);
                e.this.kLW.kLi.setClickable(false);
                e.this.kLW.kLf.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLW.kLr.setAlpha(1.0f);
                e.this.kLW.kLr.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.kMd != null) {
                    e.this.kMd.CO(e.this.mState);
                }
                e.this.kLW.kLo.setClickable(true);
                e.this.kLW.kLl.setClickable(true);
                e.this.kLW.kLi.setClickable(true);
                e.this.kLW.kLf.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLU = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLU.setDuration(300L);
        this.kLU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLW.kLr.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLW.kLr.setTranslationY(e.this.kLV * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLW.kLo.setClickable(false);
                e.this.kLW.kLl.setClickable(false);
                e.this.kLW.kLi.setClickable(false);
                e.this.kLW.kLf.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLW.kLr.setAlpha(0.0f);
                e.this.kLW.kLr.setTranslationY(e.this.kLV);
                e.this.cUj();
                e.this.kLW.kLo.setClickable(true);
                e.this.kLW.kLl.setClickable(true);
                e.this.kLW.kLi.setClickable(true);
                e.this.kLW.kLf.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLW.kLh.setVisibility(0);
        this.kLW.mPhotoView.setVisibility(0);
        this.kLW.kLk.setVisibility(0);
        this.kLW.kLn.setVisibility(0);
        this.kLV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void cUk() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kMd != null) {
                this.kMd.CO(this.mState);
            }
            clearAnimation();
            Eb(0);
            this.gKo.start();
            this.kLT.start();
            cUm();
        }
    }

    private void cUm() {
        this.kLW.kLq.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.kMi != null && e.this.kLR == 0.0f && e.this.kLS == 0.0f) {
                    e.this.kLW.kLq.getGlobalVisibleRect(e.this.kMj);
                    e.this.kLR = e.this.kMi.centerX() - e.this.kMj.centerX();
                    e.this.kLS = e.this.kMi.centerY() - e.this.kMj.centerY();
                }
                e.this.kLW.kLq.setVisibility(0);
                e.this.kLW.kLq.setTranslationX(e.this.kLR);
                e.this.kLW.kLq.setTranslationY(e.this.kLS);
                if (e.this.cYx instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.cYx).a(e.this.kLW.kLq);
                }
                e.this.kLP.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kMd != null) {
                this.kMd.CO(this.mState);
            }
            clearAnimation();
            this.gKp.start();
            this.kLQ.start();
            this.kLU.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUl() {
        cUj();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUj() {
        if (this.cYx != null) {
            this.cYx.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Eb(8);
        this.kLW.kLq.setVisibility(4);
        if (this.cYx != null) {
            this.cYx.setVisibility(0);
            this.cYx.setAlpha(1.0f);
        }
        if (this.kMd != null) {
            this.kMd.CO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.kLP.cancel();
        this.kLQ.cancel();
        this.gKp.cancel();
        this.gKo.cancel();
    }

    private void Eb(int i) {
        this.kLW.kLe.setVisibility(i);
        this.kLW.kKX.setVisibility(i);
        this.kLW.kLr.setVisibility(i);
    }
}
