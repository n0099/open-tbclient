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
    private a lIL;
    private Animator lUo;
    private Animator lUp;
    private ValueAnimator lUq;
    private ValueAnimator lUr;
    private AnimatorSet lUs;
    private AnimatorSet lUt;
    private View lUu;
    private View lUv;
    private View mExpandView;
    private int lUw = UtilHelper.getLightStatusBarHeight();
    private boolean lUx = false;
    private boolean frp = false;
    private int fGa = 0;
    private boolean lUy = false;
    private boolean lQC = false;
    private boolean lUz = false;
    private boolean fGb = false;
    private boolean iXM = true;
    private final Handler.Callback iXP = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cEw()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cEu();
                    return true;
                case 2:
                    b.this.cEs();
                    return true;
                case 3:
                    b.this.cEt();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iXP);
    private boolean bHz = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes22.dex */
    public interface a {
        void uU(boolean z);
    }

    public void a(a aVar) {
        this.lIL = aVar;
    }

    public void qn(boolean z) {
        this.fGb = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lUu = view;
        this.bHy = view2;
        this.mExpandView = view3;
        this.lUv = this.mExpandView.findViewById(R.id.sticky_view);
        Vq();
        df(false);
    }

    private void dtN() {
        this.lUo = ObjectAnimator.ofFloat(this.lUu, "translationY", (-this.lUu.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lUo.setInterpolator(new LinearInterpolator());
        this.lUo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lUu != null) {
                    b.this.lUu.clearAnimation();
                    if (b.this.lUz) {
                        b.this.df(false);
                    } else {
                        b.this.df(true);
                    }
                    if (b.this.lIL != null) {
                        b.this.lIL.uU(false);
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
        this.lUr = ValueAnimator.ofInt(0, this.lUw);
        this.lUr.setInterpolator(new LinearInterpolator());
        this.lUr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lUv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lUv.setLayoutParams(layoutParams);
                }
                b.this.lUv.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lUv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lUw;
                    b.this.lUv.setLayoutParams(layoutParams);
                }
                b.this.lUv.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lUr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lUv.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lUv.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lUt = new AnimatorSet();
        this.lUt.play(this.lUo).with(this.lUr);
    }

    private void dtO() {
        this.lUp = ObjectAnimator.ofFloat(this.lUu, "translationY", 0.0f);
        this.lUp.setInterpolator(new LinearInterpolator());
        this.lUp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lUu != null) {
                    b.this.lUu.clearAnimation();
                    b.this.lUu.setVisibility(0);
                    b.this.df(false);
                    if (b.this.lIL != null) {
                        b.this.lIL.uU(true);
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
        this.lUq = ValueAnimator.ofInt(this.lUw, 0);
        this.lUq.setInterpolator(new LinearInterpolator());
        this.lUq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lUv.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lUv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lUw;
                    b.this.lUv.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lUv.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lUv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lUv.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lUq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lUv.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lUv.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lUs = new AnimatorSet();
        this.lUs.play(this.lUp).with(this.lUq);
    }

    public void cEs() {
        Z(false, false);
    }

    public void cEt() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.lUu != null && this.lUu.getY() == 0.0f && !cEw()) {
            if (z2) {
                this.lUu.setVisibility(8);
                if (this.lUz) {
                    df(false);
                    return;
                } else {
                    df(true);
                    return;
                }
            }
            this.lUu.setVisibility(0);
            if (this.lUt == null) {
                dtN();
            }
            if (this.lUt != null) {
                this.lUt.cancel();
                this.lUt.setDuration(300L).start();
            }
        }
    }

    public void cEu() {
        if (this.lUu != null && this.lUu.getY() < 0.0f && !cEw()) {
            this.lUu.setVisibility(0);
            if (this.lUs == null) {
                dtO();
            }
            if (this.lUs != null) {
                this.lUs.cancel();
                this.lUs.setDuration(300L).start();
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

    public void cEv() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cEw() {
        return (this.lUs != null && this.lUs.isRunning()) || (this.lUt != null && this.lUt.isRunning());
    }

    public void hideFloatingView() {
        if (this.iXM) {
            if (this.frp) {
                df(true);
            } else if (this.lUu != null && !this.lUy && !this.lQC && dtP()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bGJ();
            }
        }
    }

    public void showFloatingView() {
        if (this.iXM) {
            if (this.frp) {
                df(true);
            } else if (this.lUu != null && !dtP()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bGI();
            }
        }
    }

    public boolean dtP() {
        return this.lUu.getVisibility() == 0 && this.lUu.getY() >= 0.0f;
    }

    public void vJ(boolean z) {
        this.lUy = z;
    }

    public void vK(boolean z) {
        this.lQC = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iXM && this.lUu != null && !this.lUy && !this.lQC && this.lUx) {
            if (i > this.fGa && dtP()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fGa && !dtP()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fGa = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lUx = true;
        } else if (i == 0) {
            this.lUx = false;
        }
        if (this.iXM && !this.lUy && !this.lQC) {
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
