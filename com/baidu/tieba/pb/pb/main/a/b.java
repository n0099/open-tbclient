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
    private View Hs;
    private View crU;
    private a eCq;
    private Animator eOT;
    private Animator eOU;
    private ValueAnimator eOV;
    private ValueAnimator eOW;
    private AnimatorSet eOX;
    private AnimatorSet eOY;
    private View eOZ;
    private View ePa;
    private Context mContext;
    private int ePb = UtilHelper.getLightStatusBarHeight();
    private boolean ePc = false;
    private boolean avw = false;
    private int aLJ = 0;
    private boolean ePd = false;
    private boolean eKP = false;
    private boolean ePe = false;
    private boolean aLK = false;
    private boolean ctp = true;
    private final Handler.Callback cts = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aig()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aif();
                    return true;
                case 2:
                    b.this.aid();
                    return true;
                case 3:
                    b.this.aie();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cts);
    private boolean cto = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void iP(boolean z);
    }

    public void a(a aVar) {
        this.eCq = aVar;
    }

    public void eJ(boolean z) {
        this.aLK = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.mContext = context;
        this.eOZ = view;
        this.crU = view2;
        this.Hs = view3;
        this.ePa = this.Hs.findViewById(d.h.sticky_view);
        aih();
        eL(false);
    }

    private void aSA() {
        this.eOT = ObjectAnimator.ofFloat(this.eOZ, "translationY", (-this.eOZ.getMeasuredHeight()) + this.Hs.getMeasuredHeight());
        this.eOT.setInterpolator(new LinearInterpolator());
        this.eOT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eOZ != null) {
                    b.this.eOZ.clearAnimation();
                    if (b.this.ePe) {
                        b.this.eL(false);
                    } else {
                        b.this.eL(true);
                    }
                    if (b.this.eCq != null) {
                        b.this.eCq.iP(false);
                    }
                    b.this.Hs.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eOW = ValueAnimator.ofInt(0, this.ePb);
        this.eOW.setInterpolator(new LinearInterpolator());
        this.eOW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ePa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ePa.setLayoutParams(layoutParams);
                }
                b.this.ePa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ePa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ePb;
                    b.this.ePa.setLayoutParams(layoutParams);
                }
                b.this.ePa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eOW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ePa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ePa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eOY = new AnimatorSet();
        this.eOY.play(this.eOT).with(this.eOW);
    }

    private void aSB() {
        this.eOU = ObjectAnimator.ofFloat(this.eOZ, "translationY", 0.0f);
        this.eOU.setInterpolator(new LinearInterpolator());
        this.eOU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eOZ != null) {
                    b.this.eOZ.clearAnimation();
                    b.this.eOZ.setVisibility(0);
                    b.this.eL(false);
                    if (b.this.eCq != null) {
                        b.this.eCq.iP(true);
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
        this.eOV = ValueAnimator.ofInt(this.ePb, 0);
        this.eOV.setInterpolator(new LinearInterpolator());
        this.eOV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.ePa.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.ePa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ePb;
                    b.this.ePa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ePa.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.ePa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ePa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eOV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ePa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ePa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eOX = new AnimatorSet();
        this.eOX.play(this.eOU).with(this.eOV);
    }

    public void aid() {
        v(false, false);
    }

    public void aie() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.eOZ != null && this.eOZ.getY() == 0.0f && !aig()) {
            if (z2) {
                this.eOZ.setVisibility(8);
                if (this.ePe) {
                    eL(false);
                    return;
                } else {
                    eL(true);
                    return;
                }
            }
            this.eOZ.setVisibility(0);
            if (this.eOY == null) {
                aSA();
            }
            if (this.eOY != null) {
                this.eOY.cancel();
                this.eOY.setDuration(300L).start();
            }
        }
    }

    public void aif() {
        if (this.eOZ != null && this.eOZ.getY() < 0.0f && !aig()) {
            this.eOZ.setVisibility(0);
            if (this.eOX == null) {
                aSB();
            }
            if (this.eOX != null) {
                this.eOX.cancel();
                this.eOX.setDuration(300L).start();
            }
        }
    }

    public void GJ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GK() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GL() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aig() {
        return (this.eOX != null && this.eOX.isRunning()) || (this.eOY != null && this.eOY.isRunning());
    }

    public void hideFloatingView() {
        if (this.ctp) {
            if (this.avw) {
                eL(true);
            } else if (this.eOZ != null && !this.ePd && !this.eKP && aSC()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                GK();
            }
        }
    }

    public void showFloatingView() {
        if (this.ctp) {
            if (this.avw) {
                eL(true);
            } else if (this.eOZ != null && !aSC()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                GJ();
            }
        }
    }

    private boolean aSC() {
        return this.eOZ.getVisibility() == 0 && this.eOZ.getY() >= 0.0f;
    }

    public void jF(boolean z) {
        this.ePd = z;
    }

    public void jG(boolean z) {
        this.eKP = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ctp && this.eOZ != null && !this.ePd && !this.eKP && this.ePc) {
            if (i > this.aLJ && aSC()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aLJ && !aSC()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aLJ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.ePc = true;
        } else if (i == 0) {
            this.ePc = false;
        }
        if (this.ctp && !this.ePd && !this.eKP) {
            if (this.avw) {
                eL(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aLJ) {
                    GK();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aLJ) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    GJ();
                } else if (firstVisiblePosition == this.aLJ) {
                    if (firstVisiblePosition == 0 || !this.aLK || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        GJ();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    GK();
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

    private void aih() {
        if (this.crU != null) {
            if (this.cto && this.crU.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.crU.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.crU.setLayoutParams(layoutParams);
                eL(true);
                return;
            }
            eL(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eL(boolean z) {
        if (this.crU != null) {
            if (this.cto && z && this.crU.getVisibility() != 0) {
                this.crU.setVisibility(0);
            } else if (!z && this.crU.getVisibility() != 8) {
                this.crU.setVisibility(8);
            }
        }
    }
}
