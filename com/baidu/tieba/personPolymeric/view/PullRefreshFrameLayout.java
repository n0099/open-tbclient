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
    private static final int jtb = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int jtc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int jtd = jtc + jtb;
    private static final int jte = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final float jtf = (float) ((jte * 1.0d) / jtc);
    private double bGb;
    private int czo;
    private int czp;
    private boolean isLoading;
    private ValueAnimator jsJ;
    boolean jtg;
    boolean jth;
    boolean jti;
    private int jtj;
    private ContinuousAnimationView jtk;
    private FrameLayout.LayoutParams jtl;
    private b jtm;
    private a jtn;

    /* loaded from: classes11.dex */
    public interface a {
        void cxT();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void c(int i, double d);

        void cxS();

        void l(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.jtg = false;
        this.jth = false;
        this.jti = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jtg = false;
        this.jth = false;
        this.jti = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jtg = false;
        this.jth = false;
        this.jti = false;
        this.isLoading = false;
        init();
    }

    private void init() {
        this.jtk = new ContinuousAnimationView(getContext());
        this.jtl = new FrameLayout.LayoutParams(jtb, jtb);
        this.jtl.gravity = 49;
        this.jtl.topMargin = -jtb;
        this.jtk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jtk, this.jtl);
        this.jtk.bringToFront();
        this.jtk.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.jti = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.jtg = false;
                    this.jth = false;
                    this.czp = y;
                    this.czo = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.czp;
                    int i2 = x - this.czo;
                    if (!this.jtg) {
                        if (!this.jth) {
                            if (this.jti) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.jth = false;
                                    this.jtg = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.jth = true;
                                    this.jtg = false;
                                    break;
                                }
                            } else {
                                this.jth = true;
                                this.jtg = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.czp = y;
            this.czo = x;
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
                this.czp = y;
                this.czo = x;
                return true;
            case 1:
            case 3:
                cxU();
                reset();
                return true;
            case 2:
                int i = x - this.czo;
                Aj(y - this.czp);
                this.czp = y;
                this.czo = x;
                return true;
            default:
                return true;
        }
    }

    private void Aj(int i) {
        int i2 = this.jtl.topMargin + i;
        if (i2 > jtd - jtb) {
            i2 = jtd - jtb;
        } else if (i2 < (-jtb)) {
            i2 = -jtb;
        }
        this.jtl.topMargin = i2;
        this.jtk.setLayoutParams(this.jtl);
        this.jtj += i;
        if (this.jtj > jtd) {
            this.jtj = jtd;
        } else if (this.jtj < 0) {
            this.jtj = 0;
        }
        this.bGb = (this.jtj * 1.0d) / jtd;
        if (this.jtm != null) {
            this.jtm.l(this.bGb);
        }
    }

    private void cxU() {
        if (this.bGb >= jtf) {
            this.isLoading = true;
            this.jsJ = ValueAnimator.ofFloat(this.jtl.topMargin, jte);
            this.jsJ.setDuration(150L);
            this.jsJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.jtl.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.jtk.setLayoutParams(PullRefreshFrameLayout.this.jtl);
                }
            });
            this.jsJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.jtn != null) {
                        PullRefreshFrameLayout.this.jtn.cxT();
                    }
                    PullRefreshFrameLayout.this.jtk.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jsJ.start();
            this.jtm.c(this.jtl.topMargin - jte, (jte * 1.0d) / this.jtl.topMargin);
            return;
        }
        cxV();
    }

    public void cxV() {
        hideLoading();
        if (this.jtm != null) {
            this.jtm.cxS();
        }
    }

    public void ahW() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.jtl.topMargin > (-jtb)) {
            this.jsJ = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jsJ.setDuration(300L);
            final int i = this.jtl.topMargin;
            this.jsJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.jtk.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.jtl.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.jtk.setLayoutParams(PullRefreshFrameLayout.this.jtl);
                }
            });
            this.jsJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.jtl.topMargin = -PullRefreshFrameLayout.jtb;
                    PullRefreshFrameLayout.this.jtk.setLayoutParams(PullRefreshFrameLayout.this.jtl);
                    PullRefreshFrameLayout.this.jtk.cancelAnimation();
                    PullRefreshFrameLayout.this.jtk.setFrame(0);
                    PullRefreshFrameLayout.this.jtk.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jsJ.start();
        }
    }

    private void reset() {
        this.bGb = 0.0d;
        this.czp = 0;
        this.czo = 0;
        this.jtj = 0;
        this.jtg = false;
        this.jth = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.jtm = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.jtn = aVar;
    }

    public void onDestroy() {
        if (this.jtk != null) {
            this.jtk.clearAnimation();
        }
        if (this.jsJ != null) {
            this.jsJ.cancel();
            this.jsJ.removeAllListeners();
            this.jsJ.removeAllUpdateListeners();
            this.jsJ = null;
        }
        this.jtm = null;
        this.jtn = null;
    }
}
