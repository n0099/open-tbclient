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
    private static final int jtn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int jto = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int jtp = jto + jtn;
    private static final int jtq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final float jtr = (float) ((jtq * 1.0d) / jto);
    private double bGc;
    private int czp;
    private int czq;
    private boolean isLoading;
    private ValueAnimator jsV;
    boolean jts;
    boolean jtt;
    boolean jtu;
    private int jtv;
    private ContinuousAnimationView jtw;
    private FrameLayout.LayoutParams jtx;
    private b jty;
    private a jtz;

    /* loaded from: classes11.dex */
    public interface a {
        void cxU();
    }

    /* loaded from: classes11.dex */
    public interface b {
        void c(int i, double d);

        void cxT();

        void l(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.jts = false;
        this.jtt = false;
        this.jtu = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.jts = false;
        this.jtt = false;
        this.jtu = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jts = false;
        this.jtt = false;
        this.jtu = false;
        this.isLoading = false;
        init();
    }

    private void init() {
        this.jtw = new ContinuousAnimationView(getContext());
        this.jtx = new FrameLayout.LayoutParams(jtn, jtn);
        this.jtx.gravity = 49;
        this.jtx.topMargin = -jtn;
        this.jtw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.jtw, this.jtx);
        this.jtw.bringToFront();
        this.jtw.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.jtu = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.jts = false;
                    this.jtt = false;
                    this.czq = y;
                    this.czp = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.czq;
                    int i2 = x - this.czp;
                    if (!this.jts) {
                        if (!this.jtt) {
                            if (this.jtu) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.jtt = false;
                                    this.jts = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.jtt = true;
                                    this.jts = false;
                                    break;
                                }
                            } else {
                                this.jtt = true;
                                this.jts = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.czq = y;
            this.czp = x;
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
                this.czq = y;
                this.czp = x;
                return true;
            case 1:
            case 3:
                cxV();
                reset();
                return true;
            case 2:
                int i = x - this.czp;
                Aj(y - this.czq);
                this.czq = y;
                this.czp = x;
                return true;
            default:
                return true;
        }
    }

    private void Aj(int i) {
        int i2 = this.jtx.topMargin + i;
        if (i2 > jtp - jtn) {
            i2 = jtp - jtn;
        } else if (i2 < (-jtn)) {
            i2 = -jtn;
        }
        this.jtx.topMargin = i2;
        this.jtw.setLayoutParams(this.jtx);
        this.jtv += i;
        if (this.jtv > jtp) {
            this.jtv = jtp;
        } else if (this.jtv < 0) {
            this.jtv = 0;
        }
        this.bGc = (this.jtv * 1.0d) / jtp;
        if (this.jty != null) {
            this.jty.l(this.bGc);
        }
    }

    private void cxV() {
        if (this.bGc >= jtr) {
            this.isLoading = true;
            this.jsV = ValueAnimator.ofFloat(this.jtx.topMargin, jtq);
            this.jsV.setDuration(150L);
            this.jsV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.jtx.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.jtw.setLayoutParams(PullRefreshFrameLayout.this.jtx);
                }
            });
            this.jsV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.jtz != null) {
                        PullRefreshFrameLayout.this.jtz.cxU();
                    }
                    PullRefreshFrameLayout.this.jtw.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jsV.start();
            this.jty.c(this.jtx.topMargin - jtq, (jtq * 1.0d) / this.jtx.topMargin);
            return;
        }
        cxW();
    }

    public void cxW() {
        hideLoading();
        if (this.jty != null) {
            this.jty.cxT();
        }
    }

    public void ahW() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.jtx.topMargin > (-jtn)) {
            this.jsV = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jsV.setDuration(300L);
            final int i = this.jtx.topMargin;
            this.jsV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.jtw.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.jtx.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.jtw.setLayoutParams(PullRefreshFrameLayout.this.jtx);
                }
            });
            this.jsV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.jtx.topMargin = -PullRefreshFrameLayout.jtn;
                    PullRefreshFrameLayout.this.jtw.setLayoutParams(PullRefreshFrameLayout.this.jtx);
                    PullRefreshFrameLayout.this.jtw.cancelAnimation();
                    PullRefreshFrameLayout.this.jtw.setFrame(0);
                    PullRefreshFrameLayout.this.jtw.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jsV.start();
        }
    }

    private void reset() {
        this.bGc = 0.0d;
        this.czq = 0;
        this.czp = 0;
        this.jtv = 0;
        this.jts = false;
        this.jtt = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.jty = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.jtz = aVar;
    }

    public void onDestroy() {
        if (this.jtw != null) {
            this.jtw.clearAnimation();
        }
        if (this.jsV != null) {
            this.jsV.cancel();
            this.jsV.removeAllListeners();
            this.jsV.removeAllUpdateListeners();
            this.jsV = null;
        }
        this.jty = null;
        this.jtz = null;
    }
}
