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
/* loaded from: classes2.dex */
public class b {
    private View bMJ;
    private a lUL;
    private View mExpandView;
    private View mgA;
    private Animator mgt;
    private Animator mgu;
    private ValueAnimator mgv;
    private ValueAnimator mgw;
    private AnimatorSet mgx;
    private AnimatorSet mgy;
    private View mgz;
    private int mgB = UtilHelper.getLightStatusBarHeight();
    private boolean mgC = false;
    private boolean fAc = false;
    private int fOI = 0;
    private boolean mgD = false;
    private boolean mcC = false;
    private boolean mgE = false;
    private boolean fOJ = false;
    private boolean jmY = true;
    private final Handler.Callback jnb = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cFa()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cEY();
                    return true;
                case 2:
                    b.this.cEW();
                    return true;
                case 3:
                    b.this.cEX();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jnb);
    private boolean bMK = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void vg(boolean z);
    }

    public void a(a aVar) {
        this.lUL = aVar;
    }

    public void qR(boolean z) {
        this.fOJ = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.mgz = view;
        this.bMJ = view2;
        this.mExpandView = view3;
        this.mgA = this.mExpandView.findViewById(R.id.sticky_view);
        Uk();
        dm(false);
    }

    private void dsq() {
        this.mgt = ObjectAnimator.ofFloat(this.mgz, "translationY", (-this.mgz.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.mgt.setInterpolator(new LinearInterpolator());
        this.mgt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.mgz != null) {
                    b.this.mgz.clearAnimation();
                    if (b.this.mgE) {
                        b.this.dm(false);
                    } else {
                        b.this.dm(true);
                    }
                    if (b.this.lUL != null) {
                        b.this.lUL.vg(false);
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
        this.mgw = ValueAnimator.ofInt(0, this.mgB);
        this.mgw.setInterpolator(new LinearInterpolator());
        this.mgw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.mgA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.mgA.setLayoutParams(layoutParams);
                }
                b.this.mgA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.mgA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.mgB;
                    b.this.mgA.setLayoutParams(layoutParams);
                }
                b.this.mgA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mgw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.mgA.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.mgA.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.mgy = new AnimatorSet();
        this.mgy.play(this.mgt).with(this.mgw);
    }

    private void dsr() {
        this.mgu = ObjectAnimator.ofFloat(this.mgz, "translationY", 0.0f);
        this.mgu.setInterpolator(new LinearInterpolator());
        this.mgu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.mgz != null) {
                    b.this.mgz.clearAnimation();
                    b.this.mgz.setVisibility(0);
                    b.this.dm(false);
                    if (b.this.lUL != null) {
                        b.this.lUL.vg(true);
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
        this.mgv = ValueAnimator.ofInt(this.mgB, 0);
        this.mgv.setInterpolator(new LinearInterpolator());
        this.mgv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.mgA.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.mgA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.mgB;
                    b.this.mgA.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.mgA.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.mgA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.mgA.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mgv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.mgA.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.mgA.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.mgx = new AnimatorSet();
        this.mgx.play(this.mgu).with(this.mgv);
    }

    public void cEW() {
        ab(false, false);
    }

    public void cEX() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.mgz != null && this.mgz.getY() == 0.0f && !cFa()) {
            if (z2) {
                this.mgz.setVisibility(8);
                if (this.mgE) {
                    dm(false);
                    return;
                } else {
                    dm(true);
                    return;
                }
            }
            this.mgz.setVisibility(0);
            if (this.mgy == null) {
                dsq();
            }
            if (this.mgy != null) {
                this.mgy.cancel();
                this.mgy.setDuration(300L).start();
            }
        }
    }

    public void cEY() {
        if (this.mgz != null && this.mgz.getY() < 0.0f && !cFa()) {
            this.mgz.setVisibility(0);
            if (this.mgx == null) {
                dsr();
            }
            if (this.mgx != null) {
                this.mgx.cancel();
                this.mgx.setDuration(300L).start();
            }
        }
    }

    public void bFH() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFI() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cEZ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cFa() {
        return (this.mgx != null && this.mgx.isRunning()) || (this.mgy != null && this.mgy.isRunning());
    }

    public void hideFloatingView() {
        if (this.jmY) {
            if (this.fAc) {
                dm(true);
            } else if (this.mgz != null && !this.mgD && !this.mcC && dss()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bFI();
            }
        }
    }

    public void showFloatingView() {
        if (this.jmY) {
            if (this.fAc) {
                dm(true);
            } else if (this.mgz != null && !dss()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bFH();
            }
        }
    }

    public boolean dss() {
        return this.mgz.getVisibility() == 0 && this.mgz.getY() >= 0.0f;
    }

    public void vW(boolean z) {
        this.mgD = z;
    }

    public void vX(boolean z) {
        this.mcC = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jmY && this.mgz != null && !this.mgD && !this.mcC && this.mgC) {
            if (i > this.fOI && dss()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fOI && !dss()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fOI = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.mgC = true;
        } else if (i == 0) {
            this.mgC = false;
        }
        if (this.jmY && !this.mgD && !this.mcC) {
            if (this.fAc) {
                dm(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fOI) {
                    bFI();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fOI) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bFH();
                } else if (firstVisiblePosition == this.fOI) {
                    if (firstVisiblePosition == 0 || !this.fOJ || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bFH();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bFI();
                }
            }
        }
    }

    public boolean b(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void Uk() {
        if (this.bMJ != null) {
            if (this.bMK && this.bMJ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMJ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMJ.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(boolean z) {
        if (this.bMJ != null) {
            if (this.bMK && z && this.bMJ.getVisibility() != 0) {
                this.bMJ.setVisibility(0);
            } else if (!z && this.bMJ.getVisibility() != 8) {
                this.bMJ.setVisibility(8);
            }
        }
    }
}
