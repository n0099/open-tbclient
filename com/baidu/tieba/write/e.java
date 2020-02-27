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
    private ValueAnimator gKm;
    private ValueAnimator gKn;
    private ValueAnimator kLN;
    private ValueAnimator kLO;
    private float kLP;
    private float kLQ;
    private ValueAnimator kLR;
    private ValueAnimator kLS;
    private float kLT;
    private a.b kLU;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.kLU = bVar;
        init();
    }

    private void init() {
        this.kLN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLN.setDuration(450L);
        this.kLN.setInterpolator(new OvershootInterpolator());
        this.kLN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLP != 0.0f || e.this.kLQ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLU.kLo.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.kLU.kLo.setTranslationX(e.this.kLP - (e.this.kLP * valueAnimator.getAnimatedFraction()));
                    e.this.kLU.kLo.setTranslationY(e.this.kLQ - (e.this.kLQ * valueAnimator.getAnimatedFraction()));
                    e.this.kLU.kLo.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.cYw != null) {
                    e.this.cYw.setVisibility(4);
                    e.this.cYw.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLU.kLo.setTranslationX(0.0f);
                e.this.kLU.kLo.setTranslationY(0.0f);
                e.this.kLU.kLo.setRotation(-135.0f);
                e.this.kLU.kLo.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLO.setDuration(300L);
        this.kLO.setInterpolator(new AccelerateInterpolator());
        this.kLO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kLP != 0.0f || e.this.kLQ != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kLU.kLo.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.kLU.kLo.setTranslationX(e.this.kLP * valueAnimator.getAnimatedFraction());
                    e.this.kLU.kLo.setTranslationY(e.this.kLQ * valueAnimator.getAnimatedFraction());
                    e.this.kLU.kLo.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLU.kLo.setTranslationX(e.this.kLP);
                e.this.kLU.kLo.setTranslationY(e.this.kLQ);
                e.this.kLU.kLo.setRotation(0.0f);
                e.this.kLU.kLo.setCrossFade(0.0f);
                if (e.this.cYw != null) {
                    e.this.cYw.setVisibility(0);
                    e.this.cYw.setAlpha(1.0f);
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
        this.gKm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gKm.setDuration(500L);
        this.gKm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLU.kKV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLU.kLc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLU.kKV.setAlpha(1.0f);
                e.this.kLU.kLc.setAlpha(1.0f);
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
        this.gKn.setDuration(300L);
        this.gKn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLU.kKV.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLU.kLc.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLU.kKV.setAlpha(0.0f);
                e.this.kLU.kLc.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kLR.setDuration(450L);
        this.kLR.setInterpolator(new OvershootInterpolator(1.0f));
        this.kLR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLU.kLp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLU.kLp.setTranslationY(e.this.kLT - (e.this.kLT * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kLR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLU.kLm.setClickable(false);
                e.this.kLU.kLj.setClickable(false);
                e.this.kLU.kLg.setClickable(false);
                e.this.kLU.kLd.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLU.kLp.setAlpha(1.0f);
                e.this.kLU.kLp.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.kMb != null) {
                    e.this.kMb.CO(e.this.mState);
                }
                e.this.kLU.kLm.setClickable(true);
                e.this.kLU.kLj.setClickable(true);
                e.this.kLU.kLg.setClickable(true);
                e.this.kLU.kLd.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLS = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kLS.setDuration(300L);
        this.kLS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kLU.kLp.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kLU.kLp.setTranslationY(e.this.kLT * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kLS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kLU.kLm.setClickable(false);
                e.this.kLU.kLj.setClickable(false);
                e.this.kLU.kLg.setClickable(false);
                e.this.kLU.kLd.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kLU.kLp.setAlpha(0.0f);
                e.this.kLU.kLp.setTranslationY(e.this.kLT);
                e.this.cUh();
                e.this.kLU.kLm.setClickable(true);
                e.this.kLU.kLj.setClickable(true);
                e.this.kLU.kLg.setClickable(true);
                e.this.kLU.kLd.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kLU.kLf.setVisibility(0);
        this.kLU.mPhotoView.setVisibility(0);
        this.kLU.kLi.setVisibility(0);
        this.kLU.kLl.setVisibility(0);
        this.kLT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
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
            this.gKm.start();
            this.kLR.start();
            cUk();
        }
    }

    private void cUk() {
        this.kLU.kLo.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.kMg != null && e.this.kLP == 0.0f && e.this.kLQ == 0.0f) {
                    e.this.kLU.kLo.getGlobalVisibleRect(e.this.kMh);
                    e.this.kLP = e.this.kMg.centerX() - e.this.kMh.centerX();
                    e.this.kLQ = e.this.kMg.centerY() - e.this.kMh.centerY();
                }
                e.this.kLU.kLo.setVisibility(0);
                e.this.kLU.kLo.setTranslationX(e.this.kLP);
                e.this.kLU.kLo.setTranslationY(e.this.kLQ);
                if (e.this.cYw instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.cYw).a(e.this.kLU.kLo);
                }
                e.this.kLN.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kMb != null) {
                this.kMb.CO(this.mState);
            }
            clearAnimation();
            this.gKn.start();
            this.kLO.start();
            this.kLS.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUj() {
        cUh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUh() {
        if (this.cYw != null) {
            this.cYw.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Eb(8);
        this.kLU.kLo.setVisibility(4);
        if (this.cYw != null) {
            this.cYw.setVisibility(0);
            this.cYw.setAlpha(1.0f);
        }
        if (this.kMb != null) {
            this.kMb.CO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.kLN.cancel();
        this.kLO.cancel();
        this.gKn.cancel();
        this.gKm.cancel();
    }

    private void Eb(int i) {
        this.kLU.kLc.setVisibility(i);
        this.kLU.kKV.setVisibility(i);
        this.kLU.kLp.setVisibility(i);
    }
}
