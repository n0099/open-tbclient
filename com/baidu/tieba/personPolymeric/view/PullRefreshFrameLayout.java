package com.baidu.tieba.personPolymeric.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.widget.ContinuousAnimationView;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class PullRefreshFrameLayout extends FrameLayout {
    private static final int juM = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int juN = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int juO = juN + juM;
    private static final int juP = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final float juQ = (float) ((juP * 1.0d) / juN);
    private double bGn;
    private int czA;
    private int czB;
    private boolean isLoading;
    boolean juR;
    boolean juS;
    boolean juT;
    private int juU;
    private ContinuousAnimationView juV;
    private FrameLayout.LayoutParams juW;
    private b juX;
    private a juY;
    private ValueAnimator juu;

    /* loaded from: classes11.dex */
    public interface a {
        void cyn();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void c(int i, double d);

        void cym();

        void l(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.juR = false;
        this.juS = false;
        this.juT = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.juR = false;
        this.juS = false;
        this.juT = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.juR = false;
        this.juS = false;
        this.juT = false;
        this.isLoading = false;
        init();
    }

    private void init() {
        this.juV = new ContinuousAnimationView(getContext());
        this.juW = new FrameLayout.LayoutParams(juM, juM);
        this.juW.gravity = 49;
        this.juW.topMargin = -juM;
        this.juV.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.juV, this.juW);
        this.juV.bringToFront();
        this.juV.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.juT = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.juR = false;
                    this.juS = false;
                    this.czB = y;
                    this.czA = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.czB;
                    int i2 = x - this.czA;
                    if (!this.juR) {
                        if (!this.juS) {
                            if (this.juT) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.juS = false;
                                    this.juR = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.juS = true;
                                    this.juR = false;
                                    break;
                                }
                            } else {
                                this.juS = true;
                                this.juR = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.czB = y;
            this.czA = x;
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        switch (motionEvent.getAction()) {
            case 0:
                this.czB = y;
                this.czA = x;
                return true;
            case 1:
            case 3:
                cyo();
                reset();
                return true;
            case 2:
                int i = x - this.czA;
                Ar(y - this.czB);
                this.czB = y;
                this.czA = x;
                return true;
            default:
                return true;
        }
    }

    private void Ar(int i) {
        int i2 = this.juW.topMargin + i;
        if (i2 > juO - juM) {
            i2 = juO - juM;
        } else if (i2 < (-juM)) {
            i2 = -juM;
        }
        this.juW.topMargin = i2;
        this.juV.setLayoutParams(this.juW);
        this.juU += i;
        if (this.juU > juO) {
            this.juU = juO;
        } else if (this.juU < 0) {
            this.juU = 0;
        }
        this.bGn = (this.juU * 1.0d) / juO;
        if (this.juX != null) {
            this.juX.l(this.bGn);
        }
    }

    private void cyo() {
        if (this.bGn >= juQ) {
            this.isLoading = true;
            this.juu = ValueAnimator.ofFloat(this.juW.topMargin, juP);
            this.juu.setDuration(150L);
            this.juu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.juW.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.juV.setLayoutParams(PullRefreshFrameLayout.this.juW);
                }
            });
            this.juu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.juY != null) {
                        PullRefreshFrameLayout.this.juY.cyn();
                    }
                    PullRefreshFrameLayout.this.juV.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.juu.start();
            this.juX.c(this.juW.topMargin - juP, (juP * 1.0d) / this.juW.topMargin);
            return;
        }
        cyp();
    }

    public void cyp() {
        hideLoading();
        if (this.juX != null) {
            this.juX.cym();
        }
    }

    public void ahZ() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.juW.topMargin > (-juM)) {
            this.juu = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.juu.setDuration(300L);
            final int i = this.juW.topMargin;
            this.juu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.juV.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.juW.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.juV.setLayoutParams(PullRefreshFrameLayout.this.juW);
                }
            });
            this.juu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.juW.topMargin = -PullRefreshFrameLayout.juM;
                    PullRefreshFrameLayout.this.juV.setLayoutParams(PullRefreshFrameLayout.this.juW);
                    PullRefreshFrameLayout.this.juV.cancelAnimation();
                    PullRefreshFrameLayout.this.juV.setFrame(0);
                    PullRefreshFrameLayout.this.juV.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.juu.start();
        }
    }

    private void reset() {
        this.bGn = 0.0d;
        this.czB = 0;
        this.czA = 0;
        this.juU = 0;
        this.juR = false;
        this.juS = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.juX = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.juY = aVar;
    }

    public void onDestroy() {
        if (this.juV != null) {
            this.juV.clearAnimation();
        }
        if (this.juu != null) {
            this.juu.cancel();
            this.juu.removeAllListeners();
            this.juu.removeAllUpdateListeners();
            this.juu = null;
        }
        this.juX = null;
        this.juY = null;
    }
}
