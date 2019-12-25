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
/* loaded from: classes8.dex */
public class PullRefreshFrameLayout extends FrameLayout {
    private static final int joG = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds62);
    private static final int joH = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds210);
    public static final int joI = joH + joG;
    private static final int joJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds135);
    private static final float joK = (float) ((joJ * 1.0d) / joH);
    private double bBi;
    private int cve;
    private int cvf;
    private boolean isLoading;
    boolean joL;
    boolean joM;
    boolean joN;
    private int joO;
    private ContinuousAnimationView joP;
    private FrameLayout.LayoutParams joQ;
    private b joR;
    private a joS;
    private ValueAnimator jon;

    /* loaded from: classes8.dex */
    public interface a {
        void cvp();
    }

    /* loaded from: classes8.dex */
    public interface b {
        void c(int i, double d);

        void cvo();

        void l(double d);
    }

    public PullRefreshFrameLayout(Context context) {
        super(context);
        this.joL = false;
        this.joM = false;
        this.joN = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.joL = false;
        this.joM = false;
        this.joN = false;
        this.isLoading = false;
        init();
    }

    public PullRefreshFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.joL = false;
        this.joM = false;
        this.joN = false;
        this.isLoading = false;
        init();
    }

    private void init() {
        this.joP = new ContinuousAnimationView(getContext());
        this.joQ = new FrameLayout.LayoutParams(joG, joG);
        this.joQ.gravity = 49;
        this.joQ.topMargin = -joG;
        this.joP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.joP, this.joQ);
        this.joP.bringToFront();
        this.joP.setAnimation(R.raw.ad_refresh_load);
    }

    public void setInterceptScrollDown(boolean z) {
        this.joN = z;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!this.isLoading) {
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            switch (motionEvent.getAction()) {
                case 0:
                    this.joL = false;
                    this.joM = false;
                    this.cvf = y;
                    this.cve = x;
                    break;
                case 1:
                case 3:
                    reset();
                    break;
                case 2:
                    int i = y - this.cvf;
                    int i2 = x - this.cve;
                    if (!this.joL) {
                        if (!this.joM) {
                            if (this.joN) {
                                if (i > 0 && Math.abs(i) > Math.abs(i2)) {
                                    this.joM = false;
                                    this.joL = true;
                                    z = true;
                                    break;
                                } else if (i < 0) {
                                    this.joM = true;
                                    this.joL = false;
                                    break;
                                }
                            } else {
                                this.joM = true;
                                this.joL = false;
                                break;
                            }
                        }
                    } else {
                        z = true;
                        break;
                    }
                    break;
            }
            this.cvf = y;
            this.cve = x;
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
                this.cvf = y;
                this.cve = x;
                return true;
            case 1:
            case 3:
                cvq();
                reset();
                return true;
            case 2:
                int i = x - this.cve;
                zW(y - this.cvf);
                this.cvf = y;
                this.cve = x;
                return true;
            default:
                return true;
        }
    }

    private void zW(int i) {
        int i2 = this.joQ.topMargin + i;
        if (i2 > joI - joG) {
            i2 = joI - joG;
        } else if (i2 < (-joG)) {
            i2 = -joG;
        }
        this.joQ.topMargin = i2;
        this.joP.setLayoutParams(this.joQ);
        this.joO += i;
        if (this.joO > joI) {
            this.joO = joI;
        } else if (this.joO < 0) {
            this.joO = 0;
        }
        this.bBi = (this.joO * 1.0d) / joI;
        if (this.joR != null) {
            this.joR.l(this.bBi);
        }
    }

    private void cvq() {
        if (this.bBi >= joK) {
            this.isLoading = true;
            this.jon = ValueAnimator.ofFloat(this.joQ.topMargin, joJ);
            this.jon.setDuration(150L);
            this.jon.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    PullRefreshFrameLayout.this.joQ.topMargin = (int) ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    PullRefreshFrameLayout.this.joP.setLayoutParams(PullRefreshFrameLayout.this.joQ);
                }
            });
            this.jon.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.2
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (PullRefreshFrameLayout.this.joS != null) {
                        PullRefreshFrameLayout.this.joS.cvp();
                    }
                    PullRefreshFrameLayout.this.joP.playAnimation();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jon.start();
            this.joR.c(this.joQ.topMargin - joJ, (joJ * 1.0d) / this.joQ.topMargin);
            return;
        }
        cvr();
    }

    public void cvr() {
        hideLoading();
        if (this.joR != null) {
            this.joR.cvo();
        }
    }

    public void afn() {
        if (this.isLoading) {
            hideLoading();
        }
    }

    private void hideLoading() {
        this.isLoading = false;
        if (this.joQ.topMargin > (-joG)) {
            this.jon = ValueAnimator.ofFloat(1.0f, 0.0f);
            this.jon.setDuration(300L);
            final int i = this.joQ.topMargin;
            this.jon.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (((float) (floatValue * 0.3d)) <= 0.0f) {
                    }
                    PullRefreshFrameLayout.this.joP.setAlpha(floatValue);
                    PullRefreshFrameLayout.this.joQ.topMargin = (int) (floatValue * i);
                    PullRefreshFrameLayout.this.joP.setLayoutParams(PullRefreshFrameLayout.this.joQ);
                }
            });
            this.jon.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.personPolymeric.view.PullRefreshFrameLayout.4
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    PullRefreshFrameLayout.this.joQ.topMargin = -PullRefreshFrameLayout.joG;
                    PullRefreshFrameLayout.this.joP.setLayoutParams(PullRefreshFrameLayout.this.joQ);
                    PullRefreshFrameLayout.this.joP.cancelAnimation();
                    PullRefreshFrameLayout.this.joP.setFrame(0);
                    PullRefreshFrameLayout.this.joP.setAlpha(1.0f);
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }
            });
            this.jon.start();
        }
    }

    private void reset() {
        this.bBi = 0.0d;
        this.cvf = 0;
        this.cve = 0;
        this.joO = 0;
        this.joL = false;
        this.joM = false;
    }

    public void setOnTouchCallback(b bVar) {
        this.joR = bVar;
    }

    public void setOnPullRefreshListener(a aVar) {
        this.joS = aVar;
    }

    public void onDestroy() {
        if (this.joP != null) {
            this.joP.clearAnimation();
        }
        if (this.jon != null) {
            this.jon.cancel();
            this.jon.removeAllListeners();
            this.jon.removeAllUpdateListeners();
            this.jon = null;
        }
        this.joR = null;
        this.joS = null;
    }
}
