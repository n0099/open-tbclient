package com.baidu.tieba.pb.pb.main.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.AbsListView;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b {
    private View aWc;
    private Animator jEI;
    private Animator jEJ;
    private ValueAnimator jEK;
    private ValueAnimator jEL;
    private AnimatorSet jEM;
    private AnimatorSet jEN;
    private View jEO;
    private View jEP;
    private a jus;
    private View mExpandView;
    private int jEQ = UtilHelper.getLightStatusBarHeight();
    private boolean jER = false;
    private boolean dUp = false;
    private int ehb = 0;
    private boolean jES = false;
    private boolean jBh = false;
    private boolean jET = false;
    private boolean ehc = false;
    private boolean hcu = true;
    private final Handler.Callback hcx = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bQB()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bQA();
                    return true;
                case 2:
                    b.this.bQy();
                    return true;
                case 3:
                    b.this.bQz();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hcx);
    private boolean aWd = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void ra(boolean z);
    }

    public void a(a aVar) {
        this.jus = aVar;
    }

    public void mK(boolean z) {
        this.ehc = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.jEO = view;
        this.aWc = view2;
        this.mExpandView = view3;
        this.jEP = this.mExpandView.findViewById(R.id.sticky_view);
        Fl();
        bX(false);
    }

    private void cBQ() {
        this.jEI = ObjectAnimator.ofFloat(this.jEO, "translationY", (-this.jEO.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.jEI.setInterpolator(new LinearInterpolator());
        this.jEI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jEO != null) {
                    b.this.jEO.clearAnimation();
                    if (b.this.jET) {
                        b.this.bX(false);
                    } else {
                        b.this.bX(true);
                    }
                    if (b.this.jus != null) {
                        b.this.jus.ra(false);
                    }
                    b.this.mExpandView.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEL = ValueAnimator.ofInt(0, this.jEQ);
        this.jEL.setInterpolator(new LinearInterpolator());
        this.jEL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jEP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jEP.setLayoutParams(layoutParams);
                }
                b.this.jEP.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jEP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jEQ;
                    b.this.jEP.setLayoutParams(layoutParams);
                }
                b.this.jEP.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jEP.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jEP.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jEN = new AnimatorSet();
        this.jEN.play(this.jEI).with(this.jEL);
    }

    private void cBR() {
        this.jEJ = ObjectAnimator.ofFloat(this.jEO, "translationY", 0.0f);
        this.jEJ.setInterpolator(new LinearInterpolator());
        this.jEJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jEO != null) {
                    b.this.jEO.clearAnimation();
                    b.this.jEO.setVisibility(0);
                    b.this.bX(false);
                    if (b.this.jus != null) {
                        b.this.jus.ra(true);
                    }
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEK = ValueAnimator.ofInt(this.jEQ, 0);
        this.jEK.setInterpolator(new LinearInterpolator());
        this.jEK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.jEP.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.jEP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jEQ;
                    b.this.jEP.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.jEP.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.jEP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jEP.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jEP.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jEP.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jEM = new AnimatorSet();
        this.jEM.play(this.jEJ).with(this.jEK);
    }

    public void bQy() {
        N(false, false);
    }

    public void bQz() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.jEO != null && this.jEO.getY() == 0.0f && !bQB()) {
            if (z2) {
                this.jEO.setVisibility(8);
                if (this.jET) {
                    bX(false);
                    return;
                } else {
                    bX(true);
                    return;
                }
            }
            this.jEO.setVisibility(0);
            if (this.jEN == null) {
                cBQ();
            }
            if (this.jEN != null) {
                this.jEN.cancel();
                this.jEN.setDuration(300L).start();
            }
        }
    }

    public void bQA() {
        if (this.jEO != null && this.jEO.getY() < 0.0f && !bQB()) {
            this.jEO.setVisibility(0);
            if (this.jEM == null) {
                cBR();
            }
            if (this.jEM != null) {
                this.jEM.cancel();
                this.jEM.setDuration(300L).start();
            }
        }
    }

    public void bay() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void baz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void beR() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bQB() {
        return (this.jEM != null && this.jEM.isRunning()) || (this.jEN != null && this.jEN.isRunning());
    }

    public void hideFloatingView() {
        if (this.hcu) {
            if (this.dUp) {
                bX(true);
            } else if (this.jEO != null && !this.jES && !this.jBh && cBS()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                baz();
            }
        }
    }

    public void showFloatingView() {
        if (this.hcu) {
            if (this.dUp) {
                bX(true);
            } else if (this.jEO != null && !cBS()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bay();
            }
        }
    }

    public boolean cBS() {
        return this.jEO.getVisibility() == 0 && this.jEO.getY() >= 0.0f;
    }

    public void rL(boolean z) {
        this.jES = z;
    }

    public void rM(boolean z) {
        this.jBh = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hcu && this.jEO != null && !this.jES && !this.jBh && this.jER) {
            if (i > this.ehb && cBS()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.ehb && !cBS()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.ehb = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.jER = true;
        } else if (i == 0) {
            this.jER = false;
        }
        if (this.hcu && !this.jES && !this.jBh) {
            if (this.dUp) {
                bX(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.ehb) {
                    baz();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.ehb) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bay();
                } else if (firstVisiblePosition == this.ehb) {
                    if (firstVisiblePosition == 0 || !this.ehc || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bay();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    baz();
                }
            }
        }
    }

    public boolean a(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void Fl() {
        if (this.aWc != null) {
            if (this.aWd && this.aWc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aWc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aWc.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(boolean z) {
        if (this.aWc != null) {
            if (this.aWd && z && this.aWc.getVisibility() != 0) {
                this.aWc.setVisibility(0);
            } else if (!z && this.aWc.getVisibility() != 8) {
                this.aWc.setVisibility(8);
            }
        }
    }
}
