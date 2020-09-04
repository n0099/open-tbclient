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
/* loaded from: classes16.dex */
public class b {
    private View boF;
    private a kEx;
    private Animator kPP;
    private Animator kPQ;
    private ValueAnimator kPR;
    private ValueAnimator kPS;
    private AnimatorSet kPT;
    private AnimatorSet kPU;
    private View kPV;
    private View kPW;
    private View mExpandView;
    private int kPX = UtilHelper.getLightStatusBarHeight();
    private boolean kPY = false;
    private boolean eIf = false;
    private int eVE = 0;
    private boolean kPZ = false;
    private boolean kMk = false;
    private boolean kQa = false;
    private boolean eVF = false;
    private boolean hXO = true;
    private final Handler.Callback hXR = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cok()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.coi();
                    return true;
                case 2:
                    b.this.cog();
                    return true;
                case 3:
                    b.this.coh();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hXR);
    private boolean boG = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes16.dex */
    public interface a {
        void tb(boolean z);
    }

    public void a(a aVar) {
        this.kEx = aVar;
    }

    public void oB(boolean z) {
        this.eVF = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.kPV = view;
        this.boF = view2;
        this.mExpandView = view3;
        this.kPW = this.mExpandView.findViewById(R.id.sticky_view);
        Oo();
        cy(false);
    }

    private void dca() {
        this.kPP = ObjectAnimator.ofFloat(this.kPV, "translationY", (-this.kPV.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.kPP.setInterpolator(new LinearInterpolator());
        this.kPP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kPV != null) {
                    b.this.kPV.clearAnimation();
                    if (b.this.kQa) {
                        b.this.cy(false);
                    } else {
                        b.this.cy(true);
                    }
                    if (b.this.kEx != null) {
                        b.this.kEx.tb(false);
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
        this.kPS = ValueAnimator.ofInt(0, this.kPX);
        this.kPS.setInterpolator(new LinearInterpolator());
        this.kPS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kPW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kPW.setLayoutParams(layoutParams);
                }
                b.this.kPW.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kPW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kPX;
                    b.this.kPW.setLayoutParams(layoutParams);
                }
                b.this.kPW.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kPS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kPW.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kPW.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kPU = new AnimatorSet();
        this.kPU.play(this.kPP).with(this.kPS);
    }

    private void dcb() {
        this.kPQ = ObjectAnimator.ofFloat(this.kPV, "translationY", 0.0f);
        this.kPQ.setInterpolator(new LinearInterpolator());
        this.kPQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kPV != null) {
                    b.this.kPV.clearAnimation();
                    b.this.kPV.setVisibility(0);
                    b.this.cy(false);
                    if (b.this.kEx != null) {
                        b.this.kEx.tb(true);
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
        this.kPR = ValueAnimator.ofInt(this.kPX, 0);
        this.kPR.setInterpolator(new LinearInterpolator());
        this.kPR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.kPW.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.kPW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kPX;
                    b.this.kPW.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.kPW.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.kPW.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kPW.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kPR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kPW.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kPW.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kPT = new AnimatorSet();
        this.kPT.play(this.kPQ).with(this.kPR);
    }

    public void cog() {
        V(false, false);
    }

    public void coh() {
        V(false, true);
    }

    public void V(boolean z, boolean z2) {
        if (this.kPV != null && this.kPV.getY() == 0.0f && !cok()) {
            if (z2) {
                this.kPV.setVisibility(8);
                if (this.kQa) {
                    cy(false);
                    return;
                } else {
                    cy(true);
                    return;
                }
            }
            this.kPV.setVisibility(0);
            if (this.kPU == null) {
                dca();
            }
            if (this.kPU != null) {
                this.kPU.cancel();
                this.kPU.setDuration(300L).start();
            }
        }
    }

    public void coi() {
        if (this.kPV != null && this.kPV.getY() < 0.0f && !cok()) {
            this.kPV.setVisibility(0);
            if (this.kPT == null) {
                dcb();
            }
            if (this.kPT != null) {
                this.kPT.cancel();
                this.kPT.setDuration(300L).start();
            }
        }
    }

    public void bvF() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bvG() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void coj() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cok() {
        return (this.kPT != null && this.kPT.isRunning()) || (this.kPU != null && this.kPU.isRunning());
    }

    public void hideFloatingView() {
        if (this.hXO) {
            if (this.eIf) {
                cy(true);
            } else if (this.kPV != null && !this.kPZ && !this.kMk && dcc()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bvG();
            }
        }
    }

    public void showFloatingView() {
        if (this.hXO) {
            if (this.eIf) {
                cy(true);
            } else if (this.kPV != null && !dcc()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bvF();
            }
        }
    }

    public boolean dcc() {
        return this.kPV.getVisibility() == 0 && this.kPV.getY() >= 0.0f;
    }

    public void tP(boolean z) {
        this.kPZ = z;
    }

    public void tQ(boolean z) {
        this.kMk = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hXO && this.kPV != null && !this.kPZ && !this.kMk && this.kPY) {
            if (i > this.eVE && dcc()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.eVE && !dcc()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.eVE = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kPY = true;
        } else if (i == 0) {
            this.kPY = false;
        }
        if (this.hXO && !this.kPZ && !this.kMk) {
            if (this.eIf) {
                cy(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.eVE) {
                    bvG();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.eVE) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bvF();
                } else if (firstVisiblePosition == this.eVE) {
                    if (firstVisiblePosition == 0 || !this.eVF || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bvF();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bvG();
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

    private void Oo() {
        if (this.boF != null) {
            if (this.boG && this.boF.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.boF.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.boF.setLayoutParams(layoutParams);
                cy(true);
                return;
            }
            cy(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (this.boF != null) {
            if (this.boG && z && this.boF.getVisibility() != 0) {
                this.boF.setVisibility(0);
            } else if (!z && this.boF.getVisibility() != 8) {
                this.boF.setVisibility(8);
            }
        }
    }
}
