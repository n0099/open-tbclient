package com.baidu.tieba.pb.pb.main.a;

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
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class b {
    private View Hr;
    private View csg;
    private a eCE;
    private Animator ePh;
    private Animator ePi;
    private ValueAnimator ePj;
    private ValueAnimator ePk;
    private AnimatorSet ePl;
    private AnimatorSet ePm;
    private View ePn;
    private View ePo;
    private Context mContext;
    private int ePp = UtilHelper.getLightStatusBarHeight();
    private boolean ePq = false;
    private boolean avI = false;
    private int aLW = 0;
    private boolean ePr = false;
    private boolean eLd = false;
    private boolean ePs = false;
    private boolean aLX = false;
    private boolean ctC = true;
    private final Handler.Callback ctF = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.ail()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aik();
                    return true;
                case 2:
                    b.this.aii();
                    return true;
                case 3:
                    b.this.aij();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.ctF);
    private boolean ctB = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void iQ(boolean z);
    }

    public void a(a aVar) {
        this.eCE = aVar;
    }

    public void eK(boolean z) {
        this.aLX = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.mContext = context;
        this.ePn = view;
        this.csg = view2;
        this.Hr = view3;
        this.ePo = this.Hr.findViewById(d.h.sticky_view);
        aim();
        eM(false);
    }

    private void aSF() {
        this.ePh = ObjectAnimator.ofFloat(this.ePn, "translationY", (-this.ePn.getMeasuredHeight()) + this.Hr.getMeasuredHeight());
        this.ePh.setInterpolator(new LinearInterpolator());
        this.ePh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ePn != null) {
                    b.this.ePn.clearAnimation();
                    if (b.this.ePs) {
                        b.this.eM(false);
                    } else {
                        b.this.eM(true);
                    }
                    if (b.this.eCE != null) {
                        b.this.eCE.iQ(false);
                    }
                    b.this.Hr.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ePk = ValueAnimator.ofInt(0, this.ePp);
        this.ePk.setInterpolator(new LinearInterpolator());
        this.ePk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ePo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ePo.setLayoutParams(layoutParams);
                }
                b.this.ePo.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ePo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ePp;
                    b.this.ePo.setLayoutParams(layoutParams);
                }
                b.this.ePo.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ePk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ePo.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ePo.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.ePm = new AnimatorSet();
        this.ePm.play(this.ePh).with(this.ePk);
    }

    private void aSG() {
        this.ePi = ObjectAnimator.ofFloat(this.ePn, "translationY", 0.0f);
        this.ePi.setInterpolator(new LinearInterpolator());
        this.ePi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ePn != null) {
                    b.this.ePn.clearAnimation();
                    b.this.ePn.setVisibility(0);
                    b.this.eM(false);
                    if (b.this.eCE != null) {
                        b.this.eCE.iQ(true);
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
        this.ePj = ValueAnimator.ofInt(this.ePp, 0);
        this.ePj.setInterpolator(new LinearInterpolator());
        this.ePj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.ePo.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.ePo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ePp;
                    b.this.ePo.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ePo.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.ePo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ePo.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ePj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ePo.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ePo.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.ePl = new AnimatorSet();
        this.ePl.play(this.ePi).with(this.ePj);
    }

    public void aii() {
        v(false, false);
    }

    public void aij() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.ePn != null && this.ePn.getY() == 0.0f && !ail()) {
            if (z2) {
                this.ePn.setVisibility(8);
                if (this.ePs) {
                    eM(false);
                    return;
                } else {
                    eM(true);
                    return;
                }
            }
            this.ePn.setVisibility(0);
            if (this.ePm == null) {
                aSF();
            }
            if (this.ePm != null) {
                this.ePm.cancel();
                this.ePm.setDuration(300L).start();
            }
        }
    }

    public void aik() {
        if (this.ePn != null && this.ePn.getY() < 0.0f && !ail()) {
            this.ePn.setVisibility(0);
            if (this.ePl == null) {
                aSG();
            }
            if (this.ePl != null) {
                this.ePl.cancel();
                this.ePl.setDuration(300L).start();
            }
        }
    }

    public void GP() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GQ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GR() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean ail() {
        return (this.ePl != null && this.ePl.isRunning()) || (this.ePm != null && this.ePm.isRunning());
    }

    public void hideFloatingView() {
        if (this.ctC) {
            if (this.avI) {
                eM(true);
            } else if (this.ePn != null && !this.ePr && !this.eLd && aSH()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                GQ();
            }
        }
    }

    public void showFloatingView() {
        if (this.ctC) {
            if (this.avI) {
                eM(true);
            } else if (this.ePn != null && !aSH()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                GP();
            }
        }
    }

    private boolean aSH() {
        return this.ePn.getVisibility() == 0 && this.ePn.getY() >= 0.0f;
    }

    public void jG(boolean z) {
        this.ePr = z;
    }

    public void jH(boolean z) {
        this.eLd = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ctC && this.ePn != null && !this.ePr && !this.eLd && this.ePq) {
            if (i > this.aLW && aSH()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aLW && !aSH()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aLW = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.ePq = true;
        } else if (i == 0) {
            this.ePq = false;
        }
        if (this.ctC && !this.ePr && !this.eLd) {
            if (this.avI) {
                eM(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aLW) {
                    GQ();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aLW) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    GP();
                } else if (firstVisiblePosition == this.aLW) {
                    if (firstVisiblePosition == 0 || !this.aLX || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        GP();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    GQ();
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

    private void aim() {
        if (this.csg != null) {
            if (this.ctB && this.csg.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.csg.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.csg.setLayoutParams(layoutParams);
                eM(true);
                return;
            }
            eM(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (this.csg != null) {
            if (this.ctB && z && this.csg.getVisibility() != 0) {
                this.csg.setVisibility(0);
            } else if (!z && this.csg.getVisibility() != 8) {
                this.csg.setVisibility(8);
            }
        }
    }
}
