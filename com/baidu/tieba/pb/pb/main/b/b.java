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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b {
    private View OP;
    private View faY;
    private AnimatorSet hAa;
    private AnimatorSet hAb;
    private View hAc;
    private View hAd;
    private a hnG;
    private Animator hzW;
    private Animator hzX;
    private ValueAnimator hzY;
    private ValueAnimator hzZ;
    private int hAe = UtilHelper.getLightStatusBarHeight();
    private boolean hAf = false;
    private boolean cfr = false;
    private int ctH = 0;
    private boolean hAg = false;
    private boolean hxz = false;
    private boolean hAh = false;
    private boolean ctI = false;
    private boolean fcJ = true;
    private final Handler.Callback fcL = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.beu()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bet();
                    return true;
                case 2:
                    b.this.ber();
                    return true;
                case 3:
                    b.this.bes();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fcL);
    private boolean fcI = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void no(boolean z);
    }

    public void a(a aVar) {
        this.hnG = aVar;
    }

    public void jr(boolean z) {
        this.ctI = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hAc = view;
        this.faY = view2;
        this.OP = view3;
        this.hAd = this.OP.findViewById(d.g.sticky_view);
        aCj();
        jt(false);
    }

    private void bNI() {
        this.hzW = ObjectAnimator.ofFloat(this.hAc, "translationY", (-this.hAc.getMeasuredHeight()) + this.OP.getMeasuredHeight());
        this.hzW.setInterpolator(new LinearInterpolator());
        this.hzW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAc != null) {
                    b.this.hAc.clearAnimation();
                    if (b.this.hAh) {
                        b.this.jt(false);
                    } else {
                        b.this.jt(true);
                    }
                    if (b.this.hnG != null) {
                        b.this.hnG.no(false);
                    }
                    b.this.OP.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hzZ = ValueAnimator.ofInt(0, this.hAe);
        this.hzZ.setInterpolator(new LinearInterpolator());
        this.hzZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAd.setLayoutParams(layoutParams);
                }
                b.this.hAd.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAe;
                    b.this.hAd.setLayoutParams(layoutParams);
                }
                b.this.hAd.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hzZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAd.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAd.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAb = new AnimatorSet();
        this.hAb.play(this.hzW).with(this.hzZ);
    }

    private void bNJ() {
        this.hzX = ObjectAnimator.ofFloat(this.hAc, "translationY", 0.0f);
        this.hzX.setInterpolator(new LinearInterpolator());
        this.hzX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAc != null) {
                    b.this.hAc.clearAnimation();
                    b.this.hAc.setVisibility(0);
                    b.this.jt(false);
                    if (b.this.hnG != null) {
                        b.this.hnG.no(true);
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
        this.hzY = ValueAnimator.ofInt(this.hAe, 0);
        this.hzY.setInterpolator(new LinearInterpolator());
        this.hzY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hAd.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hAd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAe;
                    b.this.hAd.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hAd.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hAd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAd.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hzY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAd.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAd.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAa = new AnimatorSet();
        this.hAa.play(this.hzX).with(this.hzY);
    }

    public void ber() {
        E(false, false);
    }

    public void bes() {
        E(false, true);
    }

    public void E(boolean z, boolean z2) {
        if (this.hAc != null && this.hAc.getY() == 0.0f && !beu()) {
            if (z2) {
                this.hAc.setVisibility(8);
                if (this.hAh) {
                    jt(false);
                    return;
                } else {
                    jt(true);
                    return;
                }
            }
            this.hAc.setVisibility(0);
            if (this.hAb == null) {
                bNI();
            }
            if (this.hAb != null) {
                this.hAb.cancel();
                this.hAb.setDuration(300L).start();
            }
        }
    }

    public void bet() {
        if (this.hAc != null && this.hAc.getY() < 0.0f && !beu()) {
            this.hAc.setVisibility(0);
            if (this.hAa == null) {
                bNJ();
            }
            if (this.hAa != null) {
                this.hAa.cancel();
                this.hAa.setDuration(300L).start();
            }
        }
    }

    public void aqf() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqg() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aqh() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean beu() {
        return (this.hAa != null && this.hAa.isRunning()) || (this.hAb != null && this.hAb.isRunning());
    }

    public void hideFloatingView() {
        if (this.fcJ) {
            if (this.cfr) {
                jt(true);
            } else if (this.hAc != null && !this.hAg && !this.hxz && bNK()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aqg();
            }
        }
    }

    public void showFloatingView() {
        if (this.fcJ) {
            if (this.cfr) {
                jt(true);
            } else if (this.hAc != null && !bNK()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aqf();
            }
        }
    }

    public boolean bNK() {
        return this.hAc.getVisibility() == 0 && this.hAc.getY() >= 0.0f;
    }

    public void od(boolean z) {
        this.hAg = z;
    }

    public void oe(boolean z) {
        this.hxz = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fcJ && this.hAc != null && !this.hAg && !this.hxz && this.hAf) {
            if (i > this.ctH && bNK()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.ctH && !bNK()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.ctH = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hAf = true;
        } else if (i == 0) {
            this.hAf = false;
        }
        if (this.fcJ && !this.hAg && !this.hxz) {
            if (this.cfr) {
                jt(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.ctH) {
                    aqg();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.ctH) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aqf();
                } else if (firstVisiblePosition == this.ctH) {
                    if (firstVisiblePosition == 0 || !this.ctI || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aqf();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aqg();
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

    private void aCj() {
        if (this.faY != null) {
            if (this.fcI && this.faY.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.faY.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.faY.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt(boolean z) {
        if (this.faY != null) {
            if (this.fcI && z && this.faY.getVisibility() != 0) {
                this.faY.setVisibility(0);
            } else if (!z && this.faY.getVisibility() != 8) {
                this.faY.setVisibility(8);
            }
        }
    }
}
