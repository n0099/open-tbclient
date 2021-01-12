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
/* loaded from: classes2.dex */
public class b {
    private View bHz;
    private a lJx;
    private Animator lUX;
    private Animator lUY;
    private ValueAnimator lUZ;
    private ValueAnimator lVa;
    private AnimatorSet lVb;
    private AnimatorSet lVc;
    private View lVd;
    private View lVe;
    private View mExpandView;
    private int lVf = UtilHelper.getLightStatusBarHeight();
    private boolean lVg = false;
    private boolean fwn = false;
    private int fKW = 0;
    private boolean lVh = false;
    private boolean lRm = false;
    private boolean lVi = false;
    private boolean fKX = false;
    private boolean jft = true;
    private final Handler.Callback jfw = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cDB()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cDz();
                    return true;
                case 2:
                    b.this.cDx();
                    return true;
                case 3:
                    b.this.cDy();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jfw);
    private boolean bHA = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void uR(boolean z);
    }

    public void a(a aVar) {
        this.lJx = aVar;
    }

    public void qH(boolean z) {
        this.fKX = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lVd = view;
        this.bHz = view2;
        this.mExpandView = view3;
        this.lVe = this.mExpandView.findViewById(R.id.sticky_view);
        SA();
        de(false);
    }

    private void dpM() {
        this.lUX = ObjectAnimator.ofFloat(this.lVd, "translationY", (-this.lVd.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lUX.setInterpolator(new LinearInterpolator());
        this.lUX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lVd != null) {
                    b.this.lVd.clearAnimation();
                    if (b.this.lVi) {
                        b.this.de(false);
                    } else {
                        b.this.de(true);
                    }
                    if (b.this.lJx != null) {
                        b.this.lJx.uR(false);
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
        this.lVa = ValueAnimator.ofInt(0, this.lVf);
        this.lVa.setInterpolator(new LinearInterpolator());
        this.lVa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lVe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lVe.setLayoutParams(layoutParams);
                }
                b.this.lVe.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lVe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lVf;
                    b.this.lVe.setLayoutParams(layoutParams);
                }
                b.this.lVe.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lVe.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lVe.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lVc = new AnimatorSet();
        this.lVc.play(this.lUX).with(this.lVa);
    }

    private void dpN() {
        this.lUY = ObjectAnimator.ofFloat(this.lVd, "translationY", 0.0f);
        this.lUY.setInterpolator(new LinearInterpolator());
        this.lUY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lVd != null) {
                    b.this.lVd.clearAnimation();
                    b.this.lVd.setVisibility(0);
                    b.this.de(false);
                    if (b.this.lJx != null) {
                        b.this.lJx.uR(true);
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
        this.lUZ = ValueAnimator.ofInt(this.lVf, 0);
        this.lUZ.setInterpolator(new LinearInterpolator());
        this.lUZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lVe.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lVe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lVf;
                    b.this.lVe.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lVe.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lVe.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lVe.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lUZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lVe.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lVe.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lVb = new AnimatorSet();
        this.lVb.play(this.lUY).with(this.lUZ);
    }

    public void cDx() {
        ab(false, false);
    }

    public void cDy() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.lVd != null && this.lVd.getY() == 0.0f && !cDB()) {
            if (z2) {
                this.lVd.setVisibility(8);
                if (this.lVi) {
                    de(false);
                    return;
                } else {
                    de(true);
                    return;
                }
            }
            this.lVd.setVisibility(0);
            if (this.lVc == null) {
                dpM();
            }
            if (this.lVc != null) {
                this.lVc.cancel();
                this.lVc.setDuration(300L).start();
            }
        }
    }

    public void cDz() {
        if (this.lVd != null && this.lVd.getY() < 0.0f && !cDB()) {
            this.lVd.setVisibility(0);
            if (this.lVb == null) {
                dpN();
            }
            if (this.lVb != null) {
                this.lVb.cancel();
                this.lVb.setDuration(300L).start();
            }
        }
    }

    public void bFk() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFl() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cDA() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cDB() {
        return (this.lVb != null && this.lVb.isRunning()) || (this.lVc != null && this.lVc.isRunning());
    }

    public void hideFloatingView() {
        if (this.jft) {
            if (this.fwn) {
                de(true);
            } else if (this.lVd != null && !this.lVh && !this.lRm && dpO()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bFl();
            }
        }
    }

    public void showFloatingView() {
        if (this.jft) {
            if (this.fwn) {
                de(true);
            } else if (this.lVd != null && !dpO()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bFk();
            }
        }
    }

    public boolean dpO() {
        return this.lVd.getVisibility() == 0 && this.lVd.getY() >= 0.0f;
    }

    public void vG(boolean z) {
        this.lVh = z;
    }

    public void vH(boolean z) {
        this.lRm = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jft && this.lVd != null && !this.lVh && !this.lRm && this.lVg) {
            if (i > this.fKW && dpO()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fKW && !dpO()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fKW = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lVg = true;
        } else if (i == 0) {
            this.lVg = false;
        }
        if (this.jft && !this.lVh && !this.lRm) {
            if (this.fwn) {
                de(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fKW) {
                    bFl();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fKW) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bFk();
                } else if (firstVisiblePosition == this.fKW) {
                    if (firstVisiblePosition == 0 || !this.fKX || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bFk();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bFl();
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

    private void SA() {
        if (this.bHz != null) {
            if (this.bHA && this.bHz.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bHz.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bHz.setLayoutParams(layoutParams);
                de(true);
                return;
            }
            de(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void de(boolean z) {
        if (this.bHz != null) {
            if (this.bHA && z && this.bHz.getVisibility() != 0) {
                this.bHz.setVisibility(0);
            } else if (!z && this.bHz.getVisibility() != 8) {
                this.bHz.setVisibility(8);
            }
        }
    }
}
