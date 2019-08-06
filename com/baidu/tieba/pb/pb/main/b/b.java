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
    private View fwK;
    private a hMs;
    private Animator hYT;
    private Animator hYU;
    private ValueAnimator hYV;
    private ValueAnimator hYW;
    private AnimatorSet hYX;
    private AnimatorSet hYY;
    private View hYZ;
    private View hZa;
    private int hZb = UtilHelper.getLightStatusBarHeight();
    private boolean hZc = false;
    private boolean coS = false;
    private int cDp = 0;
    private boolean hZd = false;
    private boolean hWu = false;
    private boolean hZe = false;
    private boolean cDq = false;
    private boolean fyt = true;
    private final Handler.Callback fyv = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.boa()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bnZ();
                    return true;
                case 2:
                    b.this.bnX();
                    return true;
                case 3:
                    b.this.bnY();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fyv);
    private boolean fys = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void os(boolean z);
    }

    public void a(a aVar) {
        this.hMs = aVar;
    }

    public void kl(boolean z) {
        this.cDq = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hYZ = view;
        this.fwK = view2;
        this.MM = view3;
        this.hZa = this.MM.findViewById(R.id.sticky_view);
        aKc();
        kn(false);
    }

    private void bYK() {
        this.hYT = ObjectAnimator.ofFloat(this.hYZ, "translationY", (-this.hYZ.getMeasuredHeight()) + this.MM.getMeasuredHeight());
        this.hYT.setInterpolator(new LinearInterpolator());
        this.hYT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hYZ != null) {
                    b.this.hYZ.clearAnimation();
                    if (b.this.hZe) {
                        b.this.kn(false);
                    } else {
                        b.this.kn(true);
                    }
                    if (b.this.hMs != null) {
                        b.this.hMs.os(false);
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
        this.hYW = ValueAnimator.ofInt(0, this.hZb);
        this.hYW.setInterpolator(new LinearInterpolator());
        this.hYW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hZa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hZa.setLayoutParams(layoutParams);
                }
                b.this.hZa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hZa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hZb;
                    b.this.hZa.setLayoutParams(layoutParams);
                }
                b.this.hZa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hYW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hZa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hZa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hYY = new AnimatorSet();
        this.hYY.play(this.hYT).with(this.hYW);
    }

    private void bYL() {
        this.hYU = ObjectAnimator.ofFloat(this.hYZ, "translationY", 0.0f);
        this.hYU.setInterpolator(new LinearInterpolator());
        this.hYU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hYZ != null) {
                    b.this.hYZ.clearAnimation();
                    b.this.hYZ.setVisibility(0);
                    b.this.kn(false);
                    if (b.this.hMs != null) {
                        b.this.hMs.os(true);
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
        this.hYV = ValueAnimator.ofInt(this.hZb, 0);
        this.hYV.setInterpolator(new LinearInterpolator());
        this.hYV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hZa.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hZa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hZb;
                    b.this.hZa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hZa.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hZa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hZa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hYV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hZa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hZa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hYX = new AnimatorSet();
        this.hYX.play(this.hYU).with(this.hYV);
    }

    public void bnX() {
        I(false, false);
    }

    public void bnY() {
        I(false, true);
    }

    public void I(boolean z, boolean z2) {
        if (this.hYZ != null && this.hYZ.getY() == 0.0f && !boa()) {
            if (z2) {
                this.hYZ.setVisibility(8);
                if (this.hZe) {
                    kn(false);
                    return;
                } else {
                    kn(true);
                    return;
                }
            }
            this.hYZ.setVisibility(0);
            if (this.hYY == null) {
                bYK();
            }
            if (this.hYY != null) {
                this.hYY.cancel();
                this.hYY.setDuration(300L).start();
            }
        }
    }

    public void bnZ() {
        if (this.hYZ != null && this.hYZ.getY() < 0.0f && !boa()) {
            this.hYZ.setVisibility(0);
            if (this.hYX == null) {
                bYL();
            }
            if (this.hYX != null) {
                this.hYX.cancel();
                this.hYX.setDuration(300L).start();
            }
        }
    }

    public void awv() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aww() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awx() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean boa() {
        return (this.hYX != null && this.hYX.isRunning()) || (this.hYY != null && this.hYY.isRunning());
    }

    public void hideFloatingView() {
        if (this.fyt) {
            if (this.coS) {
                kn(true);
            } else if (this.hYZ != null && !this.hZd && !this.hWu && bYM()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aww();
            }
        }
    }

    public void showFloatingView() {
        if (this.fyt) {
            if (this.coS) {
                kn(true);
            } else if (this.hYZ != null && !bYM()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                awv();
            }
        }
    }

    public boolean bYM() {
        return this.hYZ.getVisibility() == 0 && this.hYZ.getY() >= 0.0f;
    }

    public void ph(boolean z) {
        this.hZd = z;
    }

    public void pi(boolean z) {
        this.hWu = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fyt && this.hYZ != null && !this.hZd && !this.hWu && this.hZc) {
            if (i > this.cDp && bYM()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cDp && !bYM()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cDp = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hZc = true;
        } else if (i == 0) {
            this.hZc = false;
        }
        if (this.fyt && !this.hZd && !this.hWu) {
            if (this.coS) {
                kn(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.cDp) {
                    aww();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.cDp) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    awv();
                } else if (firstVisiblePosition == this.cDp) {
                    if (firstVisiblePosition == 0 || !this.cDq || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        awv();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aww();
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

    private void aKc() {
        if (this.fwK != null) {
            if (this.fys && this.fwK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fwK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fwK.setLayoutParams(layoutParams);
                kn(true);
                return;
            }
            kn(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kn(boolean z) {
        if (this.fwK != null) {
            if (this.fys && z && this.fwK.getVisibility() != 0) {
                this.fwK.setVisibility(0);
            } else if (!z && this.fwK.getVisibility() != 8) {
                this.fwK.setVisibility(8);
            }
        }
    }
}
