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
/* loaded from: classes2.dex */
public class b {
    private View auP;
    private View dyx;
    private a fGS;
    private Animator fSX;
    private Animator fSY;
    private ValueAnimator fSZ;
    private ValueAnimator fTa;
    private AnimatorSet fTb;
    private AnimatorSet fTc;
    private View fTd;
    private View fTe;
    private int fTf = UtilHelper.getLightStatusBarHeight();
    private boolean fTg = false;
    private boolean bmN = false;
    private int bAZ = 0;
    private boolean fTh = false;
    private boolean fQG = false;
    private boolean fTi = false;
    private boolean bBa = false;
    private boolean dzC = true;
    private final Handler.Callback dzE = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.auo()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aun();
                    return true;
                case 2:
                    b.this.aul();
                    return true;
                case 3:
                    b.this.aum();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dzE);
    private boolean dzB = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jM(boolean z);
    }

    public void a(a aVar) {
        this.fGS = aVar;
    }

    public void fI(boolean z) {
        this.bBa = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fTd = view;
        this.dyx = view2;
        this.auP = view3;
        this.fTe = this.auP.findViewById(d.g.sticky_view);
        aup();
        fK(false);
    }

    private void bes() {
        this.fSX = ObjectAnimator.ofFloat(this.fTd, "translationY", (-this.fTd.getMeasuredHeight()) + this.auP.getMeasuredHeight());
        this.fSX.setInterpolator(new LinearInterpolator());
        this.fSX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fTd != null) {
                    b.this.fTd.clearAnimation();
                    if (b.this.fTi) {
                        b.this.fK(false);
                    } else {
                        b.this.fK(true);
                    }
                    if (b.this.fGS != null) {
                        b.this.fGS.jM(false);
                    }
                    b.this.auP.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fTa = ValueAnimator.ofInt(0, this.fTf);
        this.fTa.setInterpolator(new LinearInterpolator());
        this.fTa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fTe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fTe.setLayoutParams(layoutParams);
                }
                b.this.fTe.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fTe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fTf;
                    b.this.fTe.setLayoutParams(layoutParams);
                }
                b.this.fTe.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fTa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fTe.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fTe.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fTc = new AnimatorSet();
        this.fTc.play(this.fSX).with(this.fTa);
    }

    private void bet() {
        this.fSY = ObjectAnimator.ofFloat(this.fTd, "translationY", 0.0f);
        this.fSY.setInterpolator(new LinearInterpolator());
        this.fSY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fTd != null) {
                    b.this.fTd.clearAnimation();
                    b.this.fTd.setVisibility(0);
                    b.this.fK(false);
                    if (b.this.fGS != null) {
                        b.this.fGS.jM(true);
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
        this.fSZ = ValueAnimator.ofInt(this.fTf, 0);
        this.fSZ.setInterpolator(new LinearInterpolator());
        this.fSZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fTe.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fTe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fTf;
                    b.this.fTe.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fTe.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fTe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fTe.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fSZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fTe.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fTe.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fTb = new AnimatorSet();
        this.fTb.play(this.fSY).with(this.fSZ);
    }

    public void aul() {
        y(false, false);
    }

    public void aum() {
        y(false, true);
    }

    public void y(boolean z, boolean z2) {
        if (this.fTd != null && this.fTd.getY() == 0.0f && !auo()) {
            if (z2) {
                this.fTd.setVisibility(8);
                if (this.fTi) {
                    fK(false);
                    return;
                } else {
                    fK(true);
                    return;
                }
            }
            this.fTd.setVisibility(0);
            if (this.fTc == null) {
                bes();
            }
            if (this.fTc != null) {
                this.fTc.cancel();
                this.fTc.setDuration(300L).start();
            }
        }
    }

    public void aun() {
        if (this.fTd != null && this.fTd.getY() < 0.0f && !auo()) {
            this.fTd.setVisibility(0);
            if (this.fTb == null) {
                bet();
            }
            if (this.fTb != null) {
                this.fTb.cancel();
                this.fTb.setDuration(300L).start();
            }
        }
    }

    public void ON() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean auo() {
        return (this.fTb != null && this.fTb.isRunning()) || (this.fTc != null && this.fTc.isRunning());
    }

    public void hideFloatingView() {
        if (this.dzC) {
            if (this.bmN) {
                fK(true);
            } else if (this.fTd != null && !this.fTh && !this.fQG && beu()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                OO();
            }
        }
    }

    public void showFloatingView() {
        if (this.dzC) {
            if (this.bmN) {
                fK(true);
            } else if (this.fTd != null && !beu()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                ON();
            }
        }
    }

    public boolean beu() {
        return this.fTd.getVisibility() == 0 && this.fTd.getY() >= 0.0f;
    }

    public void kG(boolean z) {
        this.fTh = z;
    }

    public void kH(boolean z) {
        this.fQG = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dzC && this.fTd != null && !this.fTh && !this.fQG && this.fTg) {
            if (i > this.bAZ && beu()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bAZ && !beu()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bAZ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fTg = true;
        } else if (i == 0) {
            this.fTg = false;
        }
        if (this.dzC && !this.fTh && !this.fQG) {
            if (this.bmN) {
                fK(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bAZ) {
                    OO();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bAZ) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    ON();
                } else if (firstVisiblePosition == this.bAZ) {
                    if (firstVisiblePosition == 0 || !this.bBa || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        ON();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    OO();
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

    private void aup() {
        if (this.dyx != null) {
            if (this.dzB && this.dyx.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dyx.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dyx.setLayoutParams(layoutParams);
                fK(true);
                return;
            }
            fK(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fK(boolean z) {
        if (this.dyx != null) {
            if (this.dzB && z && this.dyx.getVisibility() != 0) {
                this.dyx.setVisibility(0);
            } else if (!z && this.dyx.getVisibility() != 8) {
                this.dyx.setVisibility(8);
            }
        }
    }
}
