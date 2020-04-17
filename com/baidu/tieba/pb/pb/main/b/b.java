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
    private View aVX;
    private Animator jEE;
    private Animator jEF;
    private ValueAnimator jEG;
    private ValueAnimator jEH;
    private AnimatorSet jEI;
    private AnimatorSet jEJ;
    private View jEK;
    private View jEL;
    private a juo;
    private View mExpandView;
    private int jEM = UtilHelper.getLightStatusBarHeight();
    private boolean jEN = false;
    private boolean dUk = false;
    private int egW = 0;
    private boolean jEO = false;
    private boolean jBd = false;
    private boolean jEP = false;
    private boolean egX = false;
    private boolean hco = true;
    private final Handler.Callback hcr = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bQD()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bQC();
                    return true;
                case 2:
                    b.this.bQA();
                    return true;
                case 3:
                    b.this.bQB();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hcr);
    private boolean aVY = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void ra(boolean z);
    }

    public void a(a aVar) {
        this.juo = aVar;
    }

    public void mK(boolean z) {
        this.egX = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.jEK = view;
        this.aVX = view2;
        this.mExpandView = view3;
        this.jEL = this.mExpandView.findViewById(R.id.sticky_view);
        Fm();
        bX(false);
    }

    private void cBT() {
        this.jEE = ObjectAnimator.ofFloat(this.jEK, "translationY", (-this.jEK.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.jEE.setInterpolator(new LinearInterpolator());
        this.jEE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jEK != null) {
                    b.this.jEK.clearAnimation();
                    if (b.this.jEP) {
                        b.this.bX(false);
                    } else {
                        b.this.bX(true);
                    }
                    if (b.this.juo != null) {
                        b.this.juo.ra(false);
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
        this.jEH = ValueAnimator.ofInt(0, this.jEM);
        this.jEH.setInterpolator(new LinearInterpolator());
        this.jEH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jEL.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jEL.setLayoutParams(layoutParams);
                }
                b.this.jEL.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jEL.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jEM;
                    b.this.jEL.setLayoutParams(layoutParams);
                }
                b.this.jEL.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jEL.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jEL.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jEJ = new AnimatorSet();
        this.jEJ.play(this.jEE).with(this.jEH);
    }

    private void cBU() {
        this.jEF = ObjectAnimator.ofFloat(this.jEK, "translationY", 0.0f);
        this.jEF.setInterpolator(new LinearInterpolator());
        this.jEF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jEK != null) {
                    b.this.jEK.clearAnimation();
                    b.this.jEK.setVisibility(0);
                    b.this.bX(false);
                    if (b.this.juo != null) {
                        b.this.juo.ra(true);
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
        this.jEG = ValueAnimator.ofInt(this.jEM, 0);
        this.jEG.setInterpolator(new LinearInterpolator());
        this.jEG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.jEL.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.jEL.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jEM;
                    b.this.jEL.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.jEL.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.jEL.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jEL.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jEG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jEL.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jEL.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jEI = new AnimatorSet();
        this.jEI.play(this.jEF).with(this.jEG);
    }

    public void bQA() {
        N(false, false);
    }

    public void bQB() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.jEK != null && this.jEK.getY() == 0.0f && !bQD()) {
            if (z2) {
                this.jEK.setVisibility(8);
                if (this.jEP) {
                    bX(false);
                    return;
                } else {
                    bX(true);
                    return;
                }
            }
            this.jEK.setVisibility(0);
            if (this.jEJ == null) {
                cBT();
            }
            if (this.jEJ != null) {
                this.jEJ.cancel();
                this.jEJ.setDuration(300L).start();
            }
        }
    }

    public void bQC() {
        if (this.jEK != null && this.jEK.getY() < 0.0f && !bQD()) {
            this.jEK.setVisibility(0);
            if (this.jEI == null) {
                cBU();
            }
            if (this.jEI != null) {
                this.jEI.cancel();
                this.jEI.setDuration(300L).start();
            }
        }
    }

    public void baA() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void baB() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void beT() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bQD() {
        return (this.jEI != null && this.jEI.isRunning()) || (this.jEJ != null && this.jEJ.isRunning());
    }

    public void hideFloatingView() {
        if (this.hco) {
            if (this.dUk) {
                bX(true);
            } else if (this.jEK != null && !this.jEO && !this.jBd && cBV()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                baB();
            }
        }
    }

    public void showFloatingView() {
        if (this.hco) {
            if (this.dUk) {
                bX(true);
            } else if (this.jEK != null && !cBV()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                baA();
            }
        }
    }

    public boolean cBV() {
        return this.jEK.getVisibility() == 0 && this.jEK.getY() >= 0.0f;
    }

    public void rL(boolean z) {
        this.jEO = z;
    }

    public void rM(boolean z) {
        this.jBd = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hco && this.jEK != null && !this.jEO && !this.jBd && this.jEN) {
            if (i > this.egW && cBV()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.egW && !cBV()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.egW = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.jEN = true;
        } else if (i == 0) {
            this.jEN = false;
        }
        if (this.hco && !this.jEO && !this.jBd) {
            if (this.dUk) {
                bX(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.egW) {
                    baB();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.egW) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    baA();
                } else if (firstVisiblePosition == this.egW) {
                    if (firstVisiblePosition == 0 || !this.egX || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        baA();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    baB();
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

    private void Fm() {
        if (this.aVX != null) {
            if (this.aVY && this.aVX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aVX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aVX.setLayoutParams(layoutParams);
                bX(true);
                return;
            }
            bX(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bX(boolean z) {
        if (this.aVX != null) {
            if (this.aVY && z && this.aVX.getVisibility() != 0) {
                this.aVX.setVisibility(0);
            } else if (!z && this.aVX.getVisibility() != 8) {
                this.aVX.setVisibility(8);
            }
        }
    }
}
