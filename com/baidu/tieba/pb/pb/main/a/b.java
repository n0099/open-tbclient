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
    private View auD;
    private View dGe;
    private a fLM;
    private Animator fXT;
    private Animator fXU;
    private ValueAnimator fXV;
    private ValueAnimator fXW;
    private AnimatorSet fXX;
    private AnimatorSet fXY;
    private View fXZ;
    private View fYa;
    private int fYb = UtilHelper.getLightStatusBarHeight();
    private boolean fYc = false;
    private boolean bpg = false;
    private int bDh = 0;
    private boolean fYd = false;
    private boolean fVD = false;
    private boolean fYe = false;
    private boolean bDi = false;
    private boolean dHq = true;
    private final Handler.Callback dHs = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.awt()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aws();
                    return true;
                case 2:
                    b.this.awq();
                    return true;
                case 3:
                    b.this.awr();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dHs);
    private boolean dHp = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void kb(boolean z);
    }

    public void a(a aVar) {
        this.fLM = aVar;
    }

    public void fW(boolean z) {
        this.bDi = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fXZ = view;
        this.dGe = view2;
        this.auD = view3;
        this.fYa = this.auD.findViewById(d.g.sticky_view);
        XC();
        fY(false);
    }

    private void bga() {
        this.fXT = ObjectAnimator.ofFloat(this.fXZ, "translationY", (-this.fXZ.getMeasuredHeight()) + this.auD.getMeasuredHeight());
        this.fXT.setInterpolator(new LinearInterpolator());
        this.fXT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fXZ != null) {
                    b.this.fXZ.clearAnimation();
                    if (b.this.fYe) {
                        b.this.fY(false);
                    } else {
                        b.this.fY(true);
                    }
                    if (b.this.fLM != null) {
                        b.this.fLM.kb(false);
                    }
                    b.this.auD.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fXW = ValueAnimator.ofInt(0, this.fYb);
        this.fXW.setInterpolator(new LinearInterpolator());
        this.fXW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYa.setLayoutParams(layoutParams);
                }
                b.this.fYa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYb;
                    b.this.fYa.setLayoutParams(layoutParams);
                }
                b.this.fYa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fXW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fXY = new AnimatorSet();
        this.fXY.play(this.fXT).with(this.fXW);
    }

    private void bgb() {
        this.fXU = ObjectAnimator.ofFloat(this.fXZ, "translationY", 0.0f);
        this.fXU.setInterpolator(new LinearInterpolator());
        this.fXU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fXZ != null) {
                    b.this.fXZ.clearAnimation();
                    b.this.fXZ.setVisibility(0);
                    b.this.fY(false);
                    if (b.this.fLM != null) {
                        b.this.fLM.kb(true);
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
        this.fXV = ValueAnimator.ofInt(this.fYb, 0);
        this.fXV.setInterpolator(new LinearInterpolator());
        this.fXV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fYa.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fYa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYb;
                    b.this.fYa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fYa.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fYa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fXV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fXX = new AnimatorSet();
        this.fXX.play(this.fXU).with(this.fXV);
    }

    public void awq() {
        z(false, false);
    }

    public void awr() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.fXZ != null && this.fXZ.getY() == 0.0f && !awt()) {
            if (z2) {
                this.fXZ.setVisibility(8);
                if (this.fYe) {
                    fY(false);
                    return;
                } else {
                    fY(true);
                    return;
                }
            }
            this.fXZ.setVisibility(0);
            if (this.fXY == null) {
                bga();
            }
            if (this.fXY != null) {
                this.fXY.cancel();
                this.fXY.setDuration(300L).start();
            }
        }
    }

    public void aws() {
        if (this.fXZ != null && this.fXZ.getY() < 0.0f && !awt()) {
            this.fXZ.setVisibility(0);
            if (this.fXX == null) {
                bgb();
            }
            if (this.fXX != null) {
                this.fXX.cancel();
                this.fXX.setDuration(300L).start();
            }
        }
    }

    public void Ph() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Pi() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Pj() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean awt() {
        return (this.fXX != null && this.fXX.isRunning()) || (this.fXY != null && this.fXY.isRunning());
    }

    public void hideFloatingView() {
        if (this.dHq) {
            if (this.bpg) {
                fY(true);
            } else if (this.fXZ != null && !this.fYd && !this.fVD && bgc()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Pi();
            }
        }
    }

    public void showFloatingView() {
        if (this.dHq) {
            if (this.bpg) {
                fY(true);
            } else if (this.fXZ != null && !bgc()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Ph();
            }
        }
    }

    public boolean bgc() {
        return this.fXZ.getVisibility() == 0 && this.fXZ.getY() >= 0.0f;
    }

    public void kT(boolean z) {
        this.fYd = z;
    }

    public void kU(boolean z) {
        this.fVD = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dHq && this.fXZ != null && !this.fYd && !this.fVD && this.fYc) {
            if (i > this.bDh && bgc()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bDh && !bgc()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bDh = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fYc = true;
        } else if (i == 0) {
            this.fYc = false;
        }
        if (this.dHq && !this.fYd && !this.fVD) {
            if (this.bpg) {
                fY(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bDh) {
                    Pi();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bDh) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Ph();
                } else if (firstVisiblePosition == this.bDh) {
                    if (firstVisiblePosition == 0 || !this.bDi || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Ph();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Pi();
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

    private void XC() {
        if (this.dGe != null) {
            if (this.dHp && this.dGe.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dGe.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dGe.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY(boolean z) {
        if (this.dGe != null) {
            if (this.dHp && z && this.dGe.getVisibility() != 0) {
                this.dGe.setVisibility(0);
            } else if (!z && this.dGe.getVisibility() != 8) {
                this.dGe.setVisibility(8);
            }
        }
    }
}
