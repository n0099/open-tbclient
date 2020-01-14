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
    private static final int jsn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int jso = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int jsp = jso + jsn;
    private static final int jsq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final float jsr = (float) ((jsq * 1.0d) / jso);
    private double bBU;
    private int cvp;
    private int cvq;
    private boolean isLoading;
    private ValueAnimator jrU;
    boolean jss;
    boolean jst;
    boolean jsu;
    private int jsv;
    private ContinuousAnimationView jsw;
    private FrameLayout.LayoutParams jsx;
    private b jsy;
    private a jsz;

    /* loaded from: classes9.dex */
    public interface a {
        void cwy();
    }

    /* loaded from: classes9.dex */
    public interface b {
        void c(int i, double d);

        void cwx();

        void l(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.jss = false;
        this.jst = false;
        this.jsu = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jss = false;
        this.jst = false;
        this.jsu = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jss = false;
        this.jst = false;
        this.jsu = false;
        this.isLoading = false;
        init();
    }

    private void init() {
        this.jsw = new ContinuousAnimationView(getContext());
        this.jsx = new FrameLayout.LayoutParams(jsn, jsn);
        this.jsx.gravity = 49;
        this.jsx.topMargin = -jsn;
        this.jsw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jsw, this.jsx);
        this.jsw.bringToFront();
        this.jsw.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.jsu = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.jss = false;
                    this.jst = false;
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
                    if (!this.jss) {
                        if (!this.jst) {
                            if (this.jsu) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.jst = false;
                                    this.jss = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.jst = true;
                                    this.jss = false;
                                    break;
                                }
                            } else {
                                this.jst = true;
                                this.jss = false;
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
                cwz();
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
        int i2 = this.jsx.topMargin + i;
        if (i2 > jsp - jsn) {
            i2 = jsp - jsn;
        } else if (i2 < (-jsn)) {
            i2 = -jsn;
        }
        this.jsx.topMargin = i2;
        this.jsw.setLayoutParams(this.jsx);
        this.jsv += i;
        if (this.jsv > jsp) {
            this.jsv = jsp;
        } else if (this.jsv < 0) {
            this.jsv = 0;
        }
        this.bBU = (this.jsv * 1.0d) / jsp;
        if (this.jsy != null) {
            this.jsy.l(this.bBU);
        }
    }

    private void cwz() {
        if (this.bBU >= jsr) {
            this.isLoading = true;
            this.jrU = ValueAnimator.ofFloat(this.jsx.topMargin, jsq);
            this.jrU.setDuration(150L);
            this.jrU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.jsx.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.jsw.setLayoutParams(PullRefreshFrameLayout.this.jsx);
                }
            });
            this.jrU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.jsz != null) {
                        PullRefreshFrameLayout.this.jsz.cwy();
                    }
                    PullRefreshFrameLayout.this.jsw.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jrU.start();
            this.jsy.c(this.jsx.topMargin - jsq, (jsq * 1.0d) / this.jsx.topMargin);
            return;
        }
        cwA();
    }

    public void cwA() {
        hideLoading();
        if (this.jsy != null) {
            this.jsy.cwx();
        }
    }

    public void afG() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.jsx.topMargin > (-jsn)) {
            this.jrU = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jrU.setDuration(300L);
            final int i = this.jsx.topMargin;
            this.jrU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.jsw.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.jsx.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.jsw.setLayoutParams(PullRefreshFrameLayout.this.jsx);
                }
            });
            this.jrU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.jsx.topMargin = -PullRefreshFrameLayout.jsn;
                    PullRefreshFrameLayout.this.jsw.setLayoutParams(PullRefreshFrameLayout.this.jsx);
                    PullRefreshFrameLayout.this.jsw.cancelAnimation();
                    PullRefreshFrameLayout.this.jsw.setFrame(0);
                    PullRefreshFrameLayout.this.jsw.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jrU.start();
        }
    }

    private void reset() {
        this.bBU = 0.0d;
        this.cvq = 0;
        this.cvp = 0;
        this.jsv = 0;
        this.jss = false;
        this.jst = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.jsy = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.jsz = aVar;
    }

    public void onDestroy() {
        if (this.jsw != null) {
            this.jsw.clearAnimation();
        }
        if (this.jrU != null) {
            this.jrU.cancel();
            this.jrU.removeAllListeners();
            this.jrU.removeAllUpdateListeners();
            this.jrU = null;
        }
        this.jsy = null;
        this.jsz = null;
    }
}
