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
/* loaded from: classes9.dex */
public class PullRefreshFrameLayout extends FrameLayout {
    private static final int jsi = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int jsj = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int jsk = jsj + jsi;
    private static final int jsl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final float jsm = (float) ((jsl * 1.0d) / jsj);
    private double bBU;
    private int cvp;
    private int cvq;
    private boolean isLoading;
    private ValueAnimator jrP;
    boolean jsn;
    boolean jso;
    boolean jsp;
    private int jsq;
    private ContinuousAnimationView jsr;
    private FrameLayout.LayoutParams jss;
    private b jst;
    private a jsu;

    /* loaded from: classes9.dex */
    public interface a {
        void cww();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void c(int i, double d);

        void cwv();

        void l(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.jsn = false;
        this.jso = false;
        this.jsp = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jsn = false;
        this.jso = false;
        this.jsp = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jsn = false;
        this.jso = false;
        this.jsp = false;
        this.isLoading = false;
        init();
    }

    private void init() {
        this.jsr = new ContinuousAnimationView(getContext());
        this.jss = new FrameLayout.LayoutParams(jsi, jsi);
        this.jss.gravity = 49;
        this.jss.topMargin = -jsi;
        this.jsr.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jsr, this.jss);
        this.jsr.bringToFront();
        this.jsr.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.jsp = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.jsn = false;
                    this.jso = false;
                    this.cvq = y;
                    this.cvp = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.cvq;
                    int i2 = x - this.cvp;
                    if (!this.jsn) {
                        if (!this.jso) {
                            if (this.jsp) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.jso = false;
                                    this.jsn = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.jso = true;
                                    this.jsn = false;
                                    break;
                                }
                            } else {
                                this.jso = true;
                                this.jsn = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.cvq = y;
            this.cvp = x;
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
                this.cvq = y;
                this.cvp = x;
                return true;
            case 1:
            case 3:
                cwx();
                reset();
                return true;
            case 2:
                int i = x - this.cvp;
                Ab(y - this.cvq);
                this.cvq = y;
                this.cvp = x;
                return true;
            default:
                return true;
        }
    }

    private void Ab(int i) {
        int i2 = this.jss.topMargin + i;
        if (i2 > jsk - jsi) {
            i2 = jsk - jsi;
        } else if (i2 < (-jsi)) {
            i2 = -jsi;
        }
        this.jss.topMargin = i2;
        this.jsr.setLayoutParams(this.jss);
        this.jsq += i;
        if (this.jsq > jsk) {
            this.jsq = jsk;
        } else if (this.jsq < 0) {
            this.jsq = 0;
        }
        this.bBU = (this.jsq * 1.0d) / jsk;
        if (this.jst != null) {
            this.jst.l(this.bBU);
        }
    }

    private void cwx() {
        if (this.bBU >= jsm) {
            this.isLoading = true;
            this.jrP = ValueAnimator.ofFloat(this.jss.topMargin, jsl);
            this.jrP.setDuration(150L);
            this.jrP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.jss.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.jsr.setLayoutParams(PullRefreshFrameLayout.this.jss);
                }
            });
            this.jrP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.jsu != null) {
                        PullRefreshFrameLayout.this.jsu.cww();
                    }
                    PullRefreshFrameLayout.this.jsr.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jrP.start();
            this.jst.c(this.jss.topMargin - jsl, (jsl * 1.0d) / this.jss.topMargin);
            return;
        }
        cwy();
    }

    public void cwy() {
        hideLoading();
        if (this.jst != null) {
            this.jst.cwv();
        }
    }

    public void afG() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.jss.topMargin > (-jsi)) {
            this.jrP = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jrP.setDuration(300L);
            final int i = this.jss.topMargin;
            this.jrP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.jsr.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.jss.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.jsr.setLayoutParams(PullRefreshFrameLayout.this.jss);
                }
            });
            this.jrP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.jss.topMargin = -PullRefreshFrameLayout.jsi;
                    PullRefreshFrameLayout.this.jsr.setLayoutParams(PullRefreshFrameLayout.this.jss);
                    PullRefreshFrameLayout.this.jsr.cancelAnimation();
                    PullRefreshFrameLayout.this.jsr.setFrame(0);
                    PullRefreshFrameLayout.this.jsr.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jrP.start();
        }
    }

    private void reset() {
        this.bBU = 0.0d;
        this.cvq = 0;
        this.cvp = 0;
        this.jsq = 0;
        this.jsn = false;
        this.jso = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.jst = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.jsu = aVar;
    }

    public void onDestroy() {
        if (this.jsr != null) {
            this.jsr.clearAnimation();
        }
        if (this.jrP != null) {
            this.jrP.cancel();
            this.jrP.removeAllListeners();
            this.jrP.removeAllUpdateListeners();
            this.jrP = null;
        }
        this.jst = null;
        this.jsu = null;
    }
}
