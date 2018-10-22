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
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b {
    private View Ok;
    private View dCt;
    private a fLC;
    private Animator fYa;
    private Animator fYb;
    private ValueAnimator fYc;
    private ValueAnimator fYd;
    private AnimatorSet fYe;
    private AnimatorSet fYf;
    private View fYg;
    private View fYh;
    private int fYi = UtilHelper.getLightStatusBarHeight();
    private boolean fYj = false;
    private boolean aQX = false;
    private int bew = 0;
    private boolean fYk = false;
    private boolean fVD = false;
    private boolean fYl = false;
    private boolean bex = false;
    private boolean dDW = true;
    private final Handler.Callback dDY = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aBx()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aBw();
                    return true;
                case 2:
                    b.this.aBu();
                    return true;
                case 3:
                    b.this.aBv();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dDY);
    private boolean dDV = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes6.dex */
    public interface a {
        void kx(boolean z);
    }

    public void a(a aVar) {
        this.fLC = aVar;
    }

    public void gC(boolean z) {
        this.bex = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fYg = view;
        this.dCt = view2;
        this.Ok = view3;
        this.fYh = this.Ok.findViewById(e.g.sticky_view);
        Zy();
        gE(false);
    }

    private void bkJ() {
        this.fYa = ObjectAnimator.ofFloat(this.fYg, "translationY", (-this.fYg.getMeasuredHeight()) + this.Ok.getMeasuredHeight());
        this.fYa.setInterpolator(new LinearInterpolator());
        this.fYa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fYg != null) {
                    b.this.fYg.clearAnimation();
                    if (b.this.fYl) {
                        b.this.gE(false);
                    } else {
                        b.this.gE(true);
                    }
                    if (b.this.fLC != null) {
                        b.this.fLC.kx(false);
                    }
                    b.this.Ok.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYd = ValueAnimator.ofInt(0, this.fYi);
        this.fYd.setInterpolator(new LinearInterpolator());
        this.fYd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYh.setLayoutParams(layoutParams);
                }
                b.this.fYh.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYi;
                    b.this.fYh.setLayoutParams(layoutParams);
                }
                b.this.fYh.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYh.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYh.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fYf = new AnimatorSet();
        this.fYf.play(this.fYa).with(this.fYd);
    }

    private void bkK() {
        this.fYb = ObjectAnimator.ofFloat(this.fYg, "translationY", 0.0f);
        this.fYb.setInterpolator(new LinearInterpolator());
        this.fYb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fYg != null) {
                    b.this.fYg.clearAnimation();
                    b.this.fYg.setVisibility(0);
                    b.this.gE(false);
                    if (b.this.fLC != null) {
                        b.this.fLC.kx(true);
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
        this.fYc = ValueAnimator.ofInt(this.fYi, 0);
        this.fYc.setInterpolator(new LinearInterpolator());
        this.fYc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fYh.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fYh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYi;
                    b.this.fYh.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fYh.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fYh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYh.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYh.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYh.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fYe = new AnimatorSet();
        this.fYe.play(this.fYb).with(this.fYc);
    }

    public void aBu() {
        A(false, false);
    }

    public void aBv() {
        A(false, true);
    }

    public void A(boolean z, boolean z2) {
        if (this.fYg != null && this.fYg.getY() == 0.0f && !aBx()) {
            if (z2) {
                this.fYg.setVisibility(8);
                if (this.fYl) {
                    gE(false);
                    return;
                } else {
                    gE(true);
                    return;
                }
            }
            this.fYg.setVisibility(0);
            if (this.fYf == null) {
                bkJ();
            }
            if (this.fYf != null) {
                this.fYf.cancel();
                this.fYf.setDuration(300L).start();
            }
        }
    }

    public void aBw() {
        if (this.fYg != null && this.fYg.getY() < 0.0f && !aBx()) {
            this.fYg.setVisibility(0);
            if (this.fYe == null) {
                bkK();
            }
            if (this.fYe != null) {
                this.fYe.cancel();
                this.fYe.setDuration(300L).start();
            }
        }
    }

    public void OL() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OM() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void ON() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aBx() {
        return (this.fYe != null && this.fYe.isRunning()) || (this.fYf != null && this.fYf.isRunning());
    }

    public void hideFloatingView() {
        if (this.dDW) {
            if (this.aQX) {
                gE(true);
            } else if (this.fYg != null && !this.fYk && !this.fVD && bkL()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                OM();
            }
        }
    }

    public void showFloatingView() {
        if (this.dDW) {
            if (this.aQX) {
                gE(true);
            } else if (this.fYg != null && !bkL()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                OL();
            }
        }
    }

    public boolean bkL() {
        return this.fYg.getVisibility() == 0 && this.fYg.getY() >= 0.0f;
    }

    public void ln(boolean z) {
        this.fYk = z;
    }

    public void lo(boolean z) {
        this.fVD = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dDW && this.fYg != null && !this.fYk && !this.fVD && this.fYj) {
            if (i > this.bew && bkL()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bew && !bkL()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bew = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fYj = true;
        } else if (i == 0) {
            this.fYj = false;
        }
        if (this.dDW && !this.fYk && !this.fVD) {
            if (this.aQX) {
                gE(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bew) {
                    OM();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bew) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    OL();
                } else if (firstVisiblePosition == this.bew) {
                    if (firstVisiblePosition == 0 || !this.bex || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        OL();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    OM();
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

    private void Zy() {
        if (this.dCt != null) {
            if (this.dDV && this.dCt.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dCt.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dCt.setLayoutParams(layoutParams);
                gE(true);
                return;
            }
            gE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gE(boolean z) {
        if (this.dCt != null) {
            if (this.dDV && z && this.dCt.getVisibility() != 0) {
                this.dCt.setVisibility(0);
            } else if (!z && this.dCt.getVisibility() != 8) {
                this.dCt.setVisibility(8);
            }
        }
    }
}
