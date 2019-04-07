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
    private View hAb;
    private View hAc;
    private a hnF;
    private Animator hzV;
    private Animator hzW;
    private ValueAnimator hzX;
    private ValueAnimator hzY;
    private AnimatorSet hzZ;
    private int hAd = UtilHelper.getLightStatusBarHeight();
    private boolean hAe = false;
    private boolean cfq = false;
    private int ctG = 0;
    private boolean hAf = false;
    private boolean hxy = false;
    private boolean hAg = false;
    private boolean ctH = false;
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
        this.hnF = aVar;
    }

    public void jr(boolean z) {
        this.ctH = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hAb = view;
        this.faY = view2;
        this.OP = view3;
        this.hAc = this.OP.findViewById(d.g.sticky_view);
        aCj();
        jt(false);
    }

    private void bNI() {
        this.hzV = ObjectAnimator.ofFloat(this.hAb, "translationY", (-this.hAb.getMeasuredHeight()) + this.OP.getMeasuredHeight());
        this.hzV.setInterpolator(new LinearInterpolator());
        this.hzV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAb != null) {
                    b.this.hAb.clearAnimation();
                    if (b.this.hAg) {
                        b.this.jt(false);
                    } else {
                        b.this.jt(true);
                    }
                    if (b.this.hnF != null) {
                        b.this.hnF.no(false);
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
        this.hzY = ValueAnimator.ofInt(0, this.hAd);
        this.hzY.setInterpolator(new LinearInterpolator());
        this.hzY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAc.setLayoutParams(layoutParams);
                }
                b.this.hAc.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAd;
                    b.this.hAc.setLayoutParams(layoutParams);
                }
                b.this.hAc.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hzY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAc.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAc.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAa = new AnimatorSet();
        this.hAa.play(this.hzV).with(this.hzY);
    }

    private void bNJ() {
        this.hzW = ObjectAnimator.ofFloat(this.hAb, "translationY", 0.0f);
        this.hzW.setInterpolator(new LinearInterpolator());
        this.hzW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAb != null) {
                    b.this.hAb.clearAnimation();
                    b.this.hAb.setVisibility(0);
                    b.this.jt(false);
                    if (b.this.hnF != null) {
                        b.this.hnF.no(true);
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
        this.hzX = ValueAnimator.ofInt(this.hAd, 0);
        this.hzX.setInterpolator(new LinearInterpolator());
        this.hzX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hAc.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hAc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAd;
                    b.this.hAc.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hAc.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hAc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAc.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hzX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAc.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAc.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hzZ = new AnimatorSet();
        this.hzZ.play(this.hzW).with(this.hzX);
    }

    public void ber() {
        E(false, false);
    }

    public void bes() {
        E(false, true);
    }

    public void E(boolean z, boolean z2) {
        if (this.hAb != null && this.hAb.getY() == 0.0f && !beu()) {
            if (z2) {
                this.hAb.setVisibility(8);
                if (this.hAg) {
                    jt(false);
                    return;
                } else {
                    jt(true);
                    return;
                }
            }
            this.hAb.setVisibility(0);
            if (this.hAa == null) {
                bNI();
            }
            if (this.hAa != null) {
                this.hAa.cancel();
                this.hAa.setDuration(300L).start();
            }
        }
    }

    public void bet() {
        if (this.hAb != null && this.hAb.getY() < 0.0f && !beu()) {
            this.hAb.setVisibility(0);
            if (this.hzZ == null) {
                bNJ();
            }
            if (this.hzZ != null) {
                this.hzZ.cancel();
                this.hzZ.setDuration(300L).start();
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
        return (this.hzZ != null && this.hzZ.isRunning()) || (this.hAa != null && this.hAa.isRunning());
    }

    public void hideFloatingView() {
        if (this.fcJ) {
            if (this.cfq) {
                jt(true);
            } else if (this.hAb != null && !this.hAf && !this.hxy && bNK()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aqg();
            }
        }
    }

    public void showFloatingView() {
        if (this.fcJ) {
            if (this.cfq) {
                jt(true);
            } else if (this.hAb != null && !bNK()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aqf();
            }
        }
    }

    public boolean bNK() {
        return this.hAb.getVisibility() == 0 && this.hAb.getY() >= 0.0f;
    }

    public void od(boolean z) {
        this.hAf = z;
    }

    public void oe(boolean z) {
        this.hxy = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fcJ && this.hAb != null && !this.hAf && !this.hxy && this.hAe) {
            if (i > this.ctG && bNK()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.ctG && !bNK()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.ctG = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hAe = true;
        } else if (i == 0) {
            this.hAe = false;
        }
        if (this.fcJ && !this.hAf && !this.hxy) {
            if (this.cfq) {
                jt(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.ctG) {
                    aqg();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.ctG) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aqf();
                } else if (firstVisiblePosition == this.ctG) {
                    if (firstVisiblePosition == 0 || !this.ctH || a(absListView)) {
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
