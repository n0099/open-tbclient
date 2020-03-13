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
    private ValueAnimator gKA;
    private ValueAnimator gKB;
    private ValueAnimator kMb;
    private ValueAnimator kMc;
    private float kMd;
    private float kMe;
    private ValueAnimator kMf;
    private ValueAnimator kMg;
    private float kMh;
    private a.b kMi;

    public e(Context context, a.b bVar) {
        super(context, bVar);
        this.kMi = bVar;
        init();
    }

    private void init() {
        this.kMb = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kMb.setDuration(450L);
        this.kMb.setInterpolator(new OvershootInterpolator());
        this.kMb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kMd != 0.0f || e.this.kMe != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kMi.kLC.setCrossFade(valueAnimator.getAnimatedFraction());
                    e.this.kMi.kLC.setTranslationX(e.this.kMd - (e.this.kMd * valueAnimator.getAnimatedFraction()));
                    e.this.kMi.kLC.setTranslationY(e.this.kMe - (e.this.kMe * valueAnimator.getAnimatedFraction()));
                    e.this.kMi.kLC.setRotation((-135.0f) * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kMb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.cYy != null) {
                    e.this.cYy.setVisibility(4);
                    e.this.cYy.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kMi.kLC.setTranslationX(0.0f);
                e.this.kMi.kLC.setTranslationY(0.0f);
                e.this.kMi.kLC.setRotation(-135.0f);
                e.this.kMi.kLC.setCrossFade(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kMc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kMc.setDuration(300L);
        this.kMc.setInterpolator(new AccelerateInterpolator());
        this.kMc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if ((e.this.kMd != 0.0f || e.this.kMe != 0.0f) && valueAnimator.isRunning()) {
                    e.this.kMi.kLC.setCrossFade(1.0f - valueAnimator.getAnimatedFraction());
                    e.this.kMi.kLC.setTranslationX(e.this.kMd * valueAnimator.getAnimatedFraction());
                    e.this.kMi.kLC.setTranslationY(e.this.kMe * valueAnimator.getAnimatedFraction());
                    e.this.kMi.kLC.setRotation((-135.0f) + (135.0f * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kMc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.8
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kMi.kLC.setTranslationX(e.this.kMd);
                e.this.kMi.kLC.setTranslationY(e.this.kMe);
                e.this.kMi.kLC.setRotation(0.0f);
                e.this.kMi.kLC.setCrossFade(0.0f);
                if (e.this.cYy != null) {
                    e.this.cYy.setVisibility(0);
                    e.this.cYy.setAlpha(1.0f);
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
        this.gKA = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gKA.setDuration(500L);
        this.gKA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.9
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kMi.kLj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kMi.kLq.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.10
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kMi.kLj.setAlpha(1.0f);
                e.this.kMi.kLq.setAlpha(1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gKB = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.gKB.setDuration(300L);
        this.gKB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.11
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kMi.kLj.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kMi.kLq.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            }
        });
        this.gKB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.12
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kMi.kLj.setAlpha(0.0f);
                e.this.kMi.kLq.setAlpha(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kMf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kMf.setDuration(450L);
        this.kMf.setInterpolator(new OvershootInterpolator(1.0f));
        this.kMf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.13
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kMi.kLD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kMi.kLD.setTranslationY(e.this.kMh - (e.this.kMh * valueAnimator.getAnimatedFraction()));
                }
            }
        });
        this.kMf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kMi.kLA.setClickable(false);
                e.this.kMi.kLx.setClickable(false);
                e.this.kMi.kLu.setClickable(false);
                e.this.kMi.kLr.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kMi.kLD.setAlpha(1.0f);
                e.this.kMi.kLD.setTranslationY(0.0f);
                e.this.mState = 2;
                if (e.this.kMp != null) {
                    e.this.kMp.CO(e.this.mState);
                }
                e.this.kMi.kLA.setClickable(true);
                e.this.kMi.kLx.setClickable(true);
                e.this.kMi.kLu.setClickable(true);
                e.this.kMi.kLr.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kMg = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.kMg.setDuration(300L);
        this.kMg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.write.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.isRunning()) {
                    e.this.kMi.kLD.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    e.this.kMi.kLD.setTranslationY(e.this.kMh * valueAnimator.getAnimatedFraction());
                }
            }
        });
        this.kMg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.write.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                e.this.kMi.kLA.setClickable(false);
                e.this.kMi.kLx.setClickable(false);
                e.this.kMi.kLu.setClickable(false);
                e.this.kMi.kLr.setClickable(false);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.kMi.kLD.setAlpha(0.0f);
                e.this.kMi.kLD.setTranslationY(e.this.kMh);
                e.this.cUk();
                e.this.kMi.kLA.setClickable(true);
                e.this.kMi.kLx.setClickable(true);
                e.this.kMi.kLu.setClickable(true);
                e.this.kMi.kLr.setClickable(true);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                onAnimationEnd(animator);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kMi.kLt.setVisibility(0);
        this.kMi.mPhotoView.setVisibility(0);
        this.kMi.kLw.setVisibility(0);
        this.kMi.kLz.setVisibility(0);
        this.kMh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds501);
    }

    @Override // com.baidu.tieba.write.g
    public void cUl() {
        if (this.mState == 4) {
            this.mState = 1;
            if (this.kMp != null) {
                this.kMp.CO(this.mState);
            }
            clearAnimation();
            Eb(0);
            this.gKA.start();
            this.kMf.start();
            cUn();
        }
    }

    private void cUn() {
        this.kMi.kLC.post(new Runnable() { // from class: com.baidu.tieba.write.e.5
            @Override // java.lang.Runnable
            public void run() {
                if (e.this.kMu != null && e.this.kMd == 0.0f && e.this.kMe == 0.0f) {
                    e.this.kMi.kLC.getGlobalVisibleRect(e.this.kMv);
                    e.this.kMd = e.this.kMu.centerX() - e.this.kMv.centerX();
                    e.this.kMe = e.this.kMu.centerY() - e.this.kMv.centerY();
                }
                e.this.kMi.kLC.setVisibility(0);
                e.this.kMi.kLC.setTranslationX(e.this.kMd);
                e.this.kMi.kLC.setTranslationY(e.this.kMe);
                if (e.this.cYy instanceof OvalActionButton) {
                    ((OvalActionButton) e.this.cYy).a(e.this.kMi.kLC);
                }
                e.this.kMb.start();
            }
        });
    }

    @Override // com.baidu.tieba.write.g
    public void startHideAnimation() {
        if (this.mState == 2) {
            this.mState = 3;
            if (this.kMp != null) {
                this.kMp.CO(this.mState);
            }
            clearAnimation();
            this.gKB.start();
            this.kMc.start();
            this.kMg.start();
        }
    }

    @Override // com.baidu.tieba.write.g
    public void cUm() {
        cUk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cUk() {
        if (this.cYy != null) {
            this.cYy.setVisibility(0);
        }
        this.mState = 4;
        clearAnimation();
        Eb(8);
        this.kMi.kLC.setVisibility(4);
        if (this.cYy != null) {
            this.cYy.setVisibility(0);
            this.cYy.setAlpha(1.0f);
        }
        if (this.kMp != null) {
            this.kMp.CO(this.mState);
        }
    }

    @Override // com.baidu.tieba.write.g
    public void onDestroy() {
        clearAnimation();
    }

    private void clearAnimation() {
        this.kMb.cancel();
        this.kMc.cancel();
        this.gKB.cancel();
        this.gKA.cancel();
    }

    private void Eb(int i) {
        this.kMi.kLq.setVisibility(i);
        this.kMi.kLj.setVisibility(i);
        this.kMi.kLD.setVisibility(i);
    }
}
