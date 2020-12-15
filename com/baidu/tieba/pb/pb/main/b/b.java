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
/* loaded from: classes22.dex */
public class b {
    private View bHy;
    private a lIN;
    private Animator lUq;
    private Animator lUr;
    private ValueAnimator lUs;
    private ValueAnimator lUt;
    private AnimatorSet lUu;
    private AnimatorSet lUv;
    private View lUw;
    private View lUx;
    private View mExpandView;
    private int lUy = UtilHelper.getLightStatusBarHeight();
    private boolean lUz = false;
    private boolean frp = false;
    private int fGa = 0;
    private boolean lUA = false;
    private boolean lQE = false;
    private boolean lUB = false;
    private boolean fGb = false;
    private boolean iXO = true;
    private final Handler.Callback iXR = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cEx()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cEv();
                    return true;
                case 2:
                    b.this.cEt();
                    return true;
                case 3:
                    b.this.cEu();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iXR);
    private boolean bHz = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes22.dex */
    public interface a {
        void uU(boolean z);
    }

    public void a(a aVar) {
        this.lIN = aVar;
    }

    public void qn(boolean z) {
        this.fGb = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lUw = view;
        this.bHy = view2;
        this.mExpandView = view3;
        this.lUx = this.mExpandView.findViewById(R.id.sticky_view);
        Vq();
        df(false);
    }

    private void dtO() {
        this.lUq = ObjectAnimator.ofFloat(this.lUw, "translationY", (-this.lUw.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lUq.setInterpolator(new LinearInterpolator());
        this.lUq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lUw != null) {
                    b.this.lUw.clearAnimation();
                    if (b.this.lUB) {
                        b.this.df(false);
                    } else {
                        b.this.df(true);
                    }
                    if (b.this.lIN != null) {
                        b.this.lIN.uU(false);
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
        this.lUt = ValueAnimator.ofInt(0, this.lUy);
        this.lUt.setInterpolator(new LinearInterpolator());
        this.lUt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lUx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lUx.setLayoutParams(layoutParams);
                }
                b.this.lUx.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lUx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lUy;
                    b.this.lUx.setLayoutParams(layoutParams);
                }
                b.this.lUx.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lUx.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lUx.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lUv = new AnimatorSet();
        this.lUv.play(this.lUq).with(this.lUt);
    }

    private void dtP() {
        this.lUr = ObjectAnimator.ofFloat(this.lUw, "translationY", 0.0f);
        this.lUr.setInterpolator(new LinearInterpolator());
        this.lUr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lUw != null) {
                    b.this.lUw.clearAnimation();
                    b.this.lUw.setVisibility(0);
                    b.this.df(false);
                    if (b.this.lIN != null) {
                        b.this.lIN.uU(true);
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
        this.lUs = ValueAnimator.ofInt(this.lUy, 0);
        this.lUs.setInterpolator(new LinearInterpolator());
        this.lUs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lUx.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lUx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lUy;
                    b.this.lUx.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lUx.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lUx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lUx.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lUs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lUx.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lUx.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lUu = new AnimatorSet();
        this.lUu.play(this.lUr).with(this.lUs);
    }

    public void cEt() {
        Z(false, false);
    }

    public void cEu() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.lUw != null && this.lUw.getY() == 0.0f && !cEx()) {
            if (z2) {
                this.lUw.setVisibility(8);
                if (this.lUB) {
                    df(false);
                    return;
                } else {
                    df(true);
                    return;
                }
            }
            this.lUw.setVisibility(0);
            if (this.lUv == null) {
                dtO();
            }
            if (this.lUv != null) {
                this.lUv.cancel();
                this.lUv.setDuration(300L).start();
            }
        }
    }

    public void cEv() {
        if (this.lUw != null && this.lUw.getY() < 0.0f && !cEx()) {
            this.lUw.setVisibility(0);
            if (this.lUu == null) {
                dtP();
            }
            if (this.lUu != null) {
                this.lUu.cancel();
                this.lUu.setDuration(300L).start();
            }
        }
    }

    public void bGI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bGJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cEw() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cEx() {
        return (this.lUu != null && this.lUu.isRunning()) || (this.lUv != null && this.lUv.isRunning());
    }

    public void hideFloatingView() {
        if (this.iXO) {
            if (this.frp) {
                df(true);
            } else if (this.lUw != null && !this.lUA && !this.lQE && dtQ()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bGJ();
            }
        }
    }

    public void showFloatingView() {
        if (this.iXO) {
            if (this.frp) {
                df(true);
            } else if (this.lUw != null && !dtQ()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bGI();
            }
        }
    }

    public boolean dtQ() {
        return this.lUw.getVisibility() == 0 && this.lUw.getY() >= 0.0f;
    }

    public void vJ(boolean z) {
        this.lUA = z;
    }

    public void vK(boolean z) {
        this.lQE = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iXO && this.lUw != null && !this.lUA && !this.lQE && this.lUz) {
            if (i > this.fGa && dtQ()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fGa && !dtQ()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fGa = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lUz = true;
        } else if (i == 0) {
            this.lUz = false;
        }
        if (this.iXO && !this.lUA && !this.lQE) {
            if (this.frp) {
                df(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fGa) {
                    bGJ();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fGa) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bGI();
                } else if (firstVisiblePosition == this.fGa) {
                    if (firstVisiblePosition == 0 || !this.fGb || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bGI();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bGJ();
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

    private void Vq() {
        if (this.bHy != null) {
            if (this.bHz && this.bHy.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHy.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHy.setLayoutParams(layoutParams);
                df(true);
                return;
            }
            df(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void df(boolean z) {
        if (this.bHy != null) {
            if (this.bHz && z && this.bHy.getVisibility() != 0) {
                this.bHy.setVisibility(0);
            } else if (!z && this.bHy.getVisibility() != 8) {
                this.bHy.setVisibility(8);
            }
        }
    }
}
