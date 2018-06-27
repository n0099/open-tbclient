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
    private View Lv;
    private View dlF;
    private Animator fIL;
    private Animator fIM;
    private ValueAnimator fIN;
    private ValueAnimator fIO;
    private AnimatorSet fIP;
    private AnimatorSet fIQ;
    private View fIR;
    private View fIS;
    private a fwd;
    private int fIT = UtilHelper.getLightStatusBarHeight();
    private boolean fIU = false;
    private boolean aJb = false;
    private int aWA = 0;
    private boolean fIV = false;
    private boolean fGw = false;
    private boolean fIW = false;
    private boolean aWB = false;
    private boolean dmR = true;
    private final Handler.Callback dmT = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.avm()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.avl();
                    return true;
                case 2:
                    b.this.avj();
                    return true;
                case 3:
                    b.this.avk();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dmT);
    private boolean dmQ = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jT(boolean z);
    }

    public void a(a aVar) {
        this.fwd = aVar;
    }

    public void fL(boolean z) {
        this.aWB = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fIR = view;
        this.dlF = view2;
        this.Lv = view3;
        this.fIS = this.Lv.findViewById(d.g.sticky_view);
        TS();
        fN(false);
    }

    private void bgF() {
        this.fIL = ObjectAnimator.ofFloat(this.fIR, "translationY", (-this.fIR.getMeasuredHeight()) + this.Lv.getMeasuredHeight());
        this.fIL.setInterpolator(new LinearInterpolator());
        this.fIL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fIR != null) {
                    b.this.fIR.clearAnimation();
                    if (b.this.fIW) {
                        b.this.fN(false);
                    } else {
                        b.this.fN(true);
                    }
                    if (b.this.fwd != null) {
                        b.this.fwd.jT(false);
                    }
                    b.this.Lv.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fIO = ValueAnimator.ofInt(0, this.fIT);
        this.fIO.setInterpolator(new LinearInterpolator());
        this.fIO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fIS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fIS.setLayoutParams(layoutParams);
                }
                b.this.fIS.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fIS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fIT;
                    b.this.fIS.setLayoutParams(layoutParams);
                }
                b.this.fIS.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fIO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fIS.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fIS.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fIQ = new AnimatorSet();
        this.fIQ.play(this.fIL).with(this.fIO);
    }

    private void bgG() {
        this.fIM = ObjectAnimator.ofFloat(this.fIR, "translationY", 0.0f);
        this.fIM.setInterpolator(new LinearInterpolator());
        this.fIM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fIR != null) {
                    b.this.fIR.clearAnimation();
                    b.this.fIR.setVisibility(0);
                    b.this.fN(false);
                    if (b.this.fwd != null) {
                        b.this.fwd.jT(true);
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
        this.fIN = ValueAnimator.ofInt(this.fIT, 0);
        this.fIN.setInterpolator(new LinearInterpolator());
        this.fIN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fIS.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fIS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fIT;
                    b.this.fIS.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fIS.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fIS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fIS.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fIN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fIS.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fIS.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fIP = new AnimatorSet();
        this.fIP.play(this.fIM).with(this.fIN);
    }

    public void avj() {
        x(false, false);
    }

    public void avk() {
        x(false, true);
    }

    public void x(boolean z, boolean z2) {
        if (this.fIR != null && this.fIR.getY() == 0.0f && !avm()) {
            if (z2) {
                this.fIR.setVisibility(8);
                if (this.fIW) {
                    fN(false);
                    return;
                } else {
                    fN(true);
                    return;
                }
            }
            this.fIR.setVisibility(0);
            if (this.fIQ == null) {
                bgF();
            }
            if (this.fIQ != null) {
                this.fIQ.cancel();
                this.fIQ.setDuration(300L).start();
            }
        }
    }

    public void avl() {
        if (this.fIR != null && this.fIR.getY() < 0.0f && !avm()) {
            this.fIR.setVisibility(0);
            if (this.fIP == null) {
                bgG();
            }
            if (this.fIP != null) {
                this.fIP.cancel();
                this.fIP.setDuration(300L).start();
            }
        }
    }

    public void Lw() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lx() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Ly() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avm() {
        return (this.fIP != null && this.fIP.isRunning()) || (this.fIQ != null && this.fIQ.isRunning());
    }

    public void hideFloatingView() {
        if (this.dmR) {
            if (this.aJb) {
                fN(true);
            } else if (this.fIR != null && !this.fIV && !this.fGw && bgH()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Lx();
            }
        }
    }

    public void showFloatingView() {
        if (this.dmR) {
            if (this.aJb) {
                fN(true);
            } else if (this.fIR != null && !bgH()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Lw();
            }
        }
    }

    public boolean bgH() {
        return this.fIR.getVisibility() == 0 && this.fIR.getY() >= 0.0f;
    }

    public void kM(boolean z) {
        this.fIV = z;
    }

    public void kN(boolean z) {
        this.fGw = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dmR && this.fIR != null && !this.fIV && !this.fGw && this.fIU) {
            if (i > this.aWA && bgH()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aWA && !bgH()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aWA = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fIU = true;
        } else if (i == 0) {
            this.fIU = false;
        }
        if (this.dmR && !this.fIV && !this.fGw) {
            if (this.aJb) {
                fN(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aWA) {
                    Lx();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aWA) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Lw();
                } else if (firstVisiblePosition == this.aWA) {
                    if (firstVisiblePosition == 0 || !this.aWB || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Lw();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Lx();
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

    private void TS() {
        if (this.dlF != null) {
            if (this.dmQ && this.dlF.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dlF.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dlF.setLayoutParams(layoutParams);
                fN(true);
                return;
            }
            fN(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fN(boolean z) {
        if (this.dlF != null) {
            if (this.dmQ && z && this.dlF.getVisibility() != 0) {
                this.dlF.setVisibility(0);
            } else if (!z && this.dlF.getVisibility() != 8) {
                this.dlF.setVisibility(8);
            }
        }
    }
}
