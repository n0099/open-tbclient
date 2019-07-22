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
/* loaded from: classes4.dex */
public class b {
    private View MM;
    private View fwl;
    private a hLy;
    private Animator hXX;
    private Animator hXY;
    private ValueAnimator hXZ;
    private ValueAnimator hYa;
    private AnimatorSet hYb;
    private AnimatorSet hYc;
    private View hYd;
    private View hYe;
    private int hYf = UtilHelper.getLightStatusBarHeight();
    private boolean hYg = false;
    private boolean coL = false;
    private int cDi = 0;
    private boolean hYh = false;
    private boolean hVy = false;
    private boolean hYi = false;
    private boolean cDj = false;
    private boolean fxU = true;
    private final Handler.Callback fxW = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bnQ()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bnP();
                    return true;
                case 2:
                    b.this.bnN();
                    return true;
                case 3:
                    b.this.bnO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fxW);
    private boolean fxT = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void os(boolean z);
    }

    public void a(a aVar) {
        this.hLy = aVar;
    }

    public void kl(boolean z) {
        this.cDj = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hYd = view;
        this.fwl = view2;
        this.MM = view3;
        this.hYe = this.MM.findViewById(R.id.sticky_view);
        aKa();
        kn(false);
    }

    private void bYt() {
        this.hXX = ObjectAnimator.ofFloat(this.hYd, "translationY", (-this.hYd.getMeasuredHeight()) + this.MM.getMeasuredHeight());
        this.hXX.setInterpolator(new LinearInterpolator());
        this.hXX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hYd != null) {
                    b.this.hYd.clearAnimation();
                    if (b.this.hYi) {
                        b.this.kn(false);
                    } else {
                        b.this.kn(true);
                    }
                    if (b.this.hLy != null) {
                        b.this.hLy.os(false);
                    }
                    b.this.MM.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hYa = ValueAnimator.ofInt(0, this.hYf);
        this.hYa.setInterpolator(new LinearInterpolator());
        this.hYa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hYe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hYe.setLayoutParams(layoutParams);
                }
                b.this.hYe.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hYe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hYf;
                    b.this.hYe.setLayoutParams(layoutParams);
                }
                b.this.hYe.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hYa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hYe.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hYe.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hYc = new AnimatorSet();
        this.hYc.play(this.hXX).with(this.hYa);
    }

    private void bYu() {
        this.hXY = ObjectAnimator.ofFloat(this.hYd, "translationY", 0.0f);
        this.hXY.setInterpolator(new LinearInterpolator());
        this.hXY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hYd != null) {
                    b.this.hYd.clearAnimation();
                    b.this.hYd.setVisibility(0);
                    b.this.kn(false);
                    if (b.this.hLy != null) {
                        b.this.hLy.os(true);
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
        this.hXZ = ValueAnimator.ofInt(this.hYf, 0);
        this.hXZ.setInterpolator(new LinearInterpolator());
        this.hXZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hYe.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hYe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hYf;
                    b.this.hYe.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hYe.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hYe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hYe.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hXZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hYe.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hYe.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hYb = new AnimatorSet();
        this.hYb.play(this.hXY).with(this.hXZ);
    }

    public void bnN() {
        I(false, false);
    }

    public void bnO() {
        I(false, true);
    }

    public void I(boolean z, boolean z2) {
        if (this.hYd != null && this.hYd.getY() == 0.0f && !bnQ()) {
            if (z2) {
                this.hYd.setVisibility(8);
                if (this.hYi) {
                    kn(false);
                    return;
                } else {
                    kn(true);
                    return;
                }
            }
            this.hYd.setVisibility(0);
            if (this.hYc == null) {
                bYt();
            }
            if (this.hYc != null) {
                this.hYc.cancel();
                this.hYc.setDuration(300L).start();
            }
        }
    }

    public void bnP() {
        if (this.hYd != null && this.hYd.getY() < 0.0f && !bnQ()) {
            this.hYd.setVisibility(0);
            if (this.hYb == null) {
                bYu();
            }
            if (this.hYb != null) {
                this.hYb.cancel();
                this.hYb.setDuration(300L).start();
            }
        }
    }

    public void awt() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void awu() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awv() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bnQ() {
        return (this.hYb != null && this.hYb.isRunning()) || (this.hYc != null && this.hYc.isRunning());
    }

    public void hideFloatingView() {
        if (this.fxU) {
            if (this.coL) {
                kn(true);
            } else if (this.hYd != null && !this.hYh && !this.hVy && bYv()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                awu();
            }
        }
    }

    public void showFloatingView() {
        if (this.fxU) {
            if (this.coL) {
                kn(true);
            } else if (this.hYd != null && !bYv()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                awt();
            }
        }
    }

    public boolean bYv() {
        return this.hYd.getVisibility() == 0 && this.hYd.getY() >= 0.0f;
    }

    public void ph(boolean z) {
        this.hYh = z;
    }

    public void pi(boolean z) {
        this.hVy = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fxU && this.hYd != null && !this.hYh && !this.hVy && this.hYg) {
            if (i > this.cDi && bYv()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cDi && !bYv()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cDi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hYg = true;
        } else if (i == 0) {
            this.hYg = false;
        }
        if (this.fxU && !this.hYh && !this.hVy) {
            if (this.coL) {
                kn(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.cDi) {
                    awu();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.cDi) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    awt();
                } else if (firstVisiblePosition == this.cDi) {
                    if (firstVisiblePosition == 0 || !this.cDj || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        awt();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    awu();
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

    private void aKa() {
        if (this.fwl != null) {
            if (this.fxT && this.fwl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fwl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fwl.setLayoutParams(layoutParams);
                kn(true);
                return;
            }
            kn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        if (this.fwl != null) {
            if (this.fxT && z && this.fwl.getVisibility() != 0) {
                this.fwl.setVisibility(0);
            } else if (!z && this.fwl.getVisibility() != 8) {
                this.fwl.setVisibility(8);
            }
        }
    }
}
