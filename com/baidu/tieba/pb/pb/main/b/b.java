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
/* loaded from: classes21.dex */
public class b {
    private View bCq;
    private AnimatorSet lGA;
    private View lGB;
    private View lGC;
    private Animator lGv;
    private Animator lGw;
    private ValueAnimator lGx;
    private ValueAnimator lGy;
    private AnimatorSet lGz;
    private a luY;
    private View mExpandView;
    private int lGD = UtilHelper.getLightStatusBarHeight();
    private boolean lGE = false;
    private boolean fjQ = false;
    private int fyl = 0;
    private boolean lGF = false;
    private boolean lCP = false;
    private boolean lGG = false;
    private boolean fym = false;
    private boolean iMV = true;
    private final Handler.Callback iMY = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cAg()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cAe();
                    return true;
                case 2:
                    b.this.cAc();
                    return true;
                case 3:
                    b.this.cAd();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iMY);
    private boolean bCr = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes21.dex */
    public interface a {
        void us(boolean z);
    }

    public void a(a aVar) {
        this.luY = aVar;
    }

    public void pQ(boolean z) {
        this.fym = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lGB = view;
        this.bCq = view2;
        this.mExpandView = view3;
        this.lGC = this.mExpandView.findViewById(R.id.sticky_view);
        SQ();
        cR(false);
    }

    private void dow() {
        this.lGv = ObjectAnimator.ofFloat(this.lGB, "translationY", (-this.lGB.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lGv.setInterpolator(new LinearInterpolator());
        this.lGv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lGB != null) {
                    b.this.lGB.clearAnimation();
                    if (b.this.lGG) {
                        b.this.cR(false);
                    } else {
                        b.this.cR(true);
                    }
                    if (b.this.luY != null) {
                        b.this.luY.us(false);
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
        this.lGy = ValueAnimator.ofInt(0, this.lGD);
        this.lGy.setInterpolator(new LinearInterpolator());
        this.lGy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lGC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lGC.setLayoutParams(layoutParams);
                }
                b.this.lGC.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lGC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lGD;
                    b.this.lGC.setLayoutParams(layoutParams);
                }
                b.this.lGC.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lGy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lGC.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lGC.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lGA = new AnimatorSet();
        this.lGA.play(this.lGv).with(this.lGy);
    }

    private void dox() {
        this.lGw = ObjectAnimator.ofFloat(this.lGB, "translationY", 0.0f);
        this.lGw.setInterpolator(new LinearInterpolator());
        this.lGw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lGB != null) {
                    b.this.lGB.clearAnimation();
                    b.this.lGB.setVisibility(0);
                    b.this.cR(false);
                    if (b.this.luY != null) {
                        b.this.luY.us(true);
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
        this.lGx = ValueAnimator.ofInt(this.lGD, 0);
        this.lGx.setInterpolator(new LinearInterpolator());
        this.lGx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lGC.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lGC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lGD;
                    b.this.lGC.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lGC.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lGC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lGC.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lGx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lGC.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lGC.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lGz = new AnimatorSet();
        this.lGz.play(this.lGw).with(this.lGx);
    }

    public void cAc() {
        Z(false, false);
    }

    public void cAd() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.lGB != null && this.lGB.getY() == 0.0f && !cAg()) {
            if (z2) {
                this.lGB.setVisibility(8);
                if (this.lGG) {
                    cR(false);
                    return;
                } else {
                    cR(true);
                    return;
                }
            }
            this.lGB.setVisibility(0);
            if (this.lGA == null) {
                dow();
            }
            if (this.lGA != null) {
                this.lGA.cancel();
                this.lGA.setDuration(300L).start();
            }
        }
    }

    public void cAe() {
        if (this.lGB != null && this.lGB.getY() < 0.0f && !cAg()) {
            this.lGB.setVisibility(0);
            if (this.lGz == null) {
                dox();
            }
            if (this.lGz != null) {
                this.lGz.cancel();
                this.lGz.setDuration(300L).start();
            }
        }
    }

    public void bDh() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bDi() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cAf() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cAg() {
        return (this.lGz != null && this.lGz.isRunning()) || (this.lGA != null && this.lGA.isRunning());
    }

    public void hideFloatingView() {
        if (this.iMV) {
            if (this.fjQ) {
                cR(true);
            } else if (this.lGB != null && !this.lGF && !this.lCP && doy()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bDi();
            }
        }
    }

    public void showFloatingView() {
        if (this.iMV) {
            if (this.fjQ) {
                cR(true);
            } else if (this.lGB != null && !doy()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bDh();
            }
        }
    }

    public boolean doy() {
        return this.lGB.getVisibility() == 0 && this.lGB.getY() >= 0.0f;
    }

    public void vg(boolean z) {
        this.lGF = z;
    }

    public void vh(boolean z) {
        this.lCP = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iMV && this.lGB != null && !this.lGF && !this.lCP && this.lGE) {
            if (i > this.fyl && doy()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fyl && !doy()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fyl = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lGE = true;
        } else if (i == 0) {
            this.lGE = false;
        }
        if (this.iMV && !this.lGF && !this.lCP) {
            if (this.fjQ) {
                cR(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fyl) {
                    bDi();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fyl) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bDh();
                } else if (firstVisiblePosition == this.fyl) {
                    if (firstVisiblePosition == 0 || !this.fym || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bDh();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bDi();
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

    private void SQ() {
        if (this.bCq != null) {
            if (this.bCr && this.bCq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bCq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bCq.setLayoutParams(layoutParams);
                cR(true);
                return;
            }
            cR(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cR(boolean z) {
        if (this.bCq != null) {
            if (this.bCr && z && this.bCq.getVisibility() != 0) {
                this.bCq.setVisibility(0);
            } else if (!z && this.bCq.getVisibility() != 8) {
                this.bCq.setVisibility(8);
            }
        }
    }
}
