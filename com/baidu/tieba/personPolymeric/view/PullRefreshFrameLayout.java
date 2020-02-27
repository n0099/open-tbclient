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
    private static final int jsZ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int jta = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int jtb = jta + jsZ;
    private static final int jtc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final float jtd = (float) ((jtc * 1.0d) / jta);
    private double bGa;
    private int czn;
    private int czo;
    private boolean isLoading;
    private ValueAnimator jsH;
    boolean jte;
    boolean jtf;
    boolean jtg;
    private int jth;
    private ContinuousAnimationView jti;
    private FrameLayout.LayoutParams jtj;
    private b jtk;
    private a jtl;

    /* loaded from: classes11.dex */
    public interface a {
        void cxR();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void c(int i, double d);

        void cxQ();

        void l(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.jte = false;
        this.jtf = false;
        this.jtg = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jte = false;
        this.jtf = false;
        this.jtg = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jte = false;
        this.jtf = false;
        this.jtg = false;
        this.isLoading = false;
        init();
    }

    private void init() {
        this.jti = new ContinuousAnimationView(getContext());
        this.jtj = new FrameLayout.LayoutParams(jsZ, jsZ);
        this.jtj.gravity = 49;
        this.jtj.topMargin = -jsZ;
        this.jti.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jti, this.jtj);
        this.jti.bringToFront();
        this.jti.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.jtg = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.jte = false;
                    this.jtf = false;
                    this.czo = y;
                    this.czn = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.czo;
                    int i2 = x - this.czn;
                    if (!this.jte) {
                        if (!this.jtf) {
                            if (this.jtg) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.jtf = false;
                                    this.jte = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.jtf = true;
                                    this.jte = false;
                                    break;
                                }
                            } else {
                                this.jtf = true;
                                this.jte = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.czo = y;
            this.czn = x;
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
                this.czo = y;
                this.czn = x;
                return true;
            case 1:
            case 3:
                cxS();
                reset();
                return true;
            case 2:
                int i = x - this.czn;
                Aj(y - this.czo);
                this.czo = y;
                this.czn = x;
                return true;
            default:
                return true;
        }
    }

    private void Aj(int i) {
        int i2 = this.jtj.topMargin + i;
        if (i2 > jtb - jsZ) {
            i2 = jtb - jsZ;
        } else if (i2 < (-jsZ)) {
            i2 = -jsZ;
        }
        this.jtj.topMargin = i2;
        this.jti.setLayoutParams(this.jtj);
        this.jth += i;
        if (this.jth > jtb) {
            this.jth = jtb;
        } else if (this.jth < 0) {
            this.jth = 0;
        }
        this.bGa = (this.jth * 1.0d) / jtb;
        if (this.jtk != null) {
            this.jtk.l(this.bGa);
        }
    }

    private void cxS() {
        if (this.bGa >= jtd) {
            this.isLoading = true;
            this.jsH = ValueAnimator.ofFloat(this.jtj.topMargin, jtc);
            this.jsH.setDuration(150L);
            this.jsH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.jtj.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.jti.setLayoutParams(PullRefreshFrameLayout.this.jtj);
                }
            });
            this.jsH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.jtl != null) {
                        PullRefreshFrameLayout.this.jtl.cxR();
                    }
                    PullRefreshFrameLayout.this.jti.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jsH.start();
            this.jtk.c(this.jtj.topMargin - jtc, (jtc * 1.0d) / this.jtj.topMargin);
            return;
        }
        cxT();
    }

    public void cxT() {
        hideLoading();
        if (this.jtk != null) {
            this.jtk.cxQ();
        }
    }

    public void ahU() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.jtj.topMargin > (-jsZ)) {
            this.jsH = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jsH.setDuration(300L);
            final int i = this.jtj.topMargin;
            this.jsH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.jti.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.jtj.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.jti.setLayoutParams(PullRefreshFrameLayout.this.jtj);
                }
            });
            this.jsH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.jtj.topMargin = -PullRefreshFrameLayout.jsZ;
                    PullRefreshFrameLayout.this.jti.setLayoutParams(PullRefreshFrameLayout.this.jtj);
                    PullRefreshFrameLayout.this.jti.cancelAnimation();
                    PullRefreshFrameLayout.this.jti.setFrame(0);
                    PullRefreshFrameLayout.this.jti.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jsH.start();
        }
    }

    private void reset() {
        this.bGa = 0.0d;
        this.czo = 0;
        this.czn = 0;
        this.jth = 0;
        this.jte = false;
        this.jtf = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.jtk = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.jtl = aVar;
    }

    public void onDestroy() {
        if (this.jti != null) {
            this.jti.clearAnimation();
        }
        if (this.jsH != null) {
            this.jsH.cancel();
            this.jsH.removeAllListeners();
            this.jsH.removeAllUpdateListeners();
            this.jsH = null;
        }
        this.jtk = null;
        this.jtl = null;
    }
}
