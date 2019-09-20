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
    private View fyx;
    private a hOp;
    private Animator iaQ;
    private Animator iaR;
    private ValueAnimator iaS;
    private ValueAnimator iaT;
    private AnimatorSet iaU;
    private AnimatorSet iaV;
    private View iaW;
    private View iaX;
    private int iaY = UtilHelper.getLightStatusBarHeight();
    private boolean iaZ = false;
    private boolean cpN = false;
    private int cEg = 0;
    private boolean iba = false;
    private boolean hYr = false;
    private boolean ibb = false;
    private boolean cEh = false;
    private boolean fAg = true;
    private final Handler.Callback fAi = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.boL()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.boK();
                    return true;
                case 2:
                    b.this.boI();
                    return true;
                case 3:
                    b.this.boJ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fAi);
    private boolean fAf = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void ow(boolean z);
    }

    public void a(a aVar) {
        this.hOp = aVar;
    }

    public void ko(boolean z) {
        this.cEh = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.iaW = view;
        this.fyx = view2;
        this.MM = view3;
        this.iaX = this.MM.findViewById(R.id.sticky_view);
        aKG();
        kq(false);
    }

    private void bZx() {
        this.iaQ = ObjectAnimator.ofFloat(this.iaW, "translationY", (-this.iaW.getMeasuredHeight()) + this.MM.getMeasuredHeight());
        this.iaQ.setInterpolator(new LinearInterpolator());
        this.iaQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iaW != null) {
                    b.this.iaW.clearAnimation();
                    if (b.this.ibb) {
                        b.this.kq(false);
                    } else {
                        b.this.kq(true);
                    }
                    if (b.this.hOp != null) {
                        b.this.hOp.ow(false);
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
        this.iaT = ValueAnimator.ofInt(0, this.iaY);
        this.iaT.setInterpolator(new LinearInterpolator());
        this.iaT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iaX.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iaX.setLayoutParams(layoutParams);
                }
                b.this.iaX.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iaX.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iaY;
                    b.this.iaX.setLayoutParams(layoutParams);
                }
                b.this.iaX.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iaT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iaX.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iaX.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iaV = new AnimatorSet();
        this.iaV.play(this.iaQ).with(this.iaT);
    }

    private void bZy() {
        this.iaR = ObjectAnimator.ofFloat(this.iaW, "translationY", 0.0f);
        this.iaR.setInterpolator(new LinearInterpolator());
        this.iaR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iaW != null) {
                    b.this.iaW.clearAnimation();
                    b.this.iaW.setVisibility(0);
                    b.this.kq(false);
                    if (b.this.hOp != null) {
                        b.this.hOp.ow(true);
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
        this.iaS = ValueAnimator.ofInt(this.iaY, 0);
        this.iaS.setInterpolator(new LinearInterpolator());
        this.iaS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.iaX.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.iaX.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iaY;
                    b.this.iaX.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.iaX.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.iaX.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iaX.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iaS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iaX.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iaX.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iaU = new AnimatorSet();
        this.iaU.play(this.iaR).with(this.iaS);
    }

    public void boI() {
        I(false, false);
    }

    public void boJ() {
        I(false, true);
    }

    public void I(boolean z, boolean z2) {
        if (this.iaW != null && this.iaW.getY() == 0.0f && !boL()) {
            if (z2) {
                this.iaW.setVisibility(8);
                if (this.ibb) {
                    kq(false);
                    return;
                } else {
                    kq(true);
                    return;
                }
            }
            this.iaW.setVisibility(0);
            if (this.iaV == null) {
                bZx();
            }
            if (this.iaV != null) {
                this.iaV.cancel();
                this.iaV.setDuration(300L).start();
            }
        }
    }

    public void boK() {
        if (this.iaW != null && this.iaW.getY() < 0.0f && !boL()) {
            this.iaW.setVisibility(0);
            if (this.iaU == null) {
                bZy();
            }
            if (this.iaU != null) {
                this.iaU.cancel();
                this.iaU.setDuration(300L).start();
            }
        }
    }

    public void awH() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void awI() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void awJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean boL() {
        return (this.iaU != null && this.iaU.isRunning()) || (this.iaV != null && this.iaV.isRunning());
    }

    public void hideFloatingView() {
        if (this.fAg) {
            if (this.cpN) {
                kq(true);
            } else if (this.iaW != null && !this.iba && !this.hYr && bZz()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                awI();
            }
        }
    }

    public void showFloatingView() {
        if (this.fAg) {
            if (this.cpN) {
                kq(true);
            } else if (this.iaW != null && !bZz()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                awH();
            }
        }
    }

    public boolean bZz() {
        return this.iaW.getVisibility() == 0 && this.iaW.getY() >= 0.0f;
    }

    public void pl(boolean z) {
        this.iba = z;
    }

    public void pm(boolean z) {
        this.hYr = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fAg && this.iaW != null && !this.iba && !this.hYr && this.iaZ) {
            if (i > this.cEg && bZz()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cEg && !bZz()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cEg = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.iaZ = true;
        } else if (i == 0) {
            this.iaZ = false;
        }
        if (this.fAg && !this.iba && !this.hYr) {
            if (this.cpN) {
                kq(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.cEg) {
                    awI();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.cEg) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    awH();
                } else if (firstVisiblePosition == this.cEg) {
                    if (firstVisiblePosition == 0 || !this.cEh || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        awH();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    awI();
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

    private void aKG() {
        if (this.fyx != null) {
            if (this.fAf && this.fyx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fyx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fyx.setLayoutParams(layoutParams);
                kq(true);
                return;
            }
            kq(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kq(boolean z) {
        if (this.fyx != null) {
            if (this.fAf && z && this.fyx.getVisibility() != 0) {
                this.fyx.setVisibility(0);
            } else if (!z && this.fyx.getVisibility() != 8) {
                this.fyx.setVisibility(8);
            }
        }
    }
}
