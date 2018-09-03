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
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class b {
    private View Lr;
    private View dov;
    private Animator fIT;
    private Animator fIU;
    private ValueAnimator fIV;
    private ValueAnimator fIW;
    private AnimatorSet fIX;
    private AnimatorSet fIY;
    private View fIZ;
    private View fJa;
    private a fwi;
    private int fJb = UtilHelper.getLightStatusBarHeight();
    private boolean fJc = false;
    private boolean aJf = false;
    private int aWC = 0;
    private boolean fJd = false;
    private boolean fGC = false;
    private boolean fJe = false;
    private boolean aWD = false;
    private boolean dpH = true;
    private final Handler.Callback dpJ = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.avQ()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.avP();
                    return true;
                case 2:
                    b.this.avN();
                    return true;
                case 3:
                    b.this.avO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dpJ);
    private boolean dpG = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jF(boolean z);
    }

    public void a(a aVar) {
        this.fwi = aVar;
    }

    public void fN(boolean z) {
        this.aWD = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fIZ = view;
        this.dov = view2;
        this.Lr = view3;
        this.fJa = this.Lr.findViewById(f.g.sticky_view);
        Ud();
        fP(false);
    }

    private void beT() {
        this.fIT = ObjectAnimator.ofFloat(this.fIZ, "translationY", (-this.fIZ.getMeasuredHeight()) + this.Lr.getMeasuredHeight());
        this.fIT.setInterpolator(new LinearInterpolator());
        this.fIT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fIZ != null) {
                    b.this.fIZ.clearAnimation();
                    if (b.this.fJe) {
                        b.this.fP(false);
                    } else {
                        b.this.fP(true);
                    }
                    if (b.this.fwi != null) {
                        b.this.fwi.jF(false);
                    }
                    b.this.Lr.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fIW = ValueAnimator.ofInt(0, this.fJb);
        this.fIW.setInterpolator(new LinearInterpolator());
        this.fIW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fJa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fJa.setLayoutParams(layoutParams);
                }
                b.this.fJa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fJa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fJb;
                    b.this.fJa.setLayoutParams(layoutParams);
                }
                b.this.fJa.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fIW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fJa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fJa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fIY = new AnimatorSet();
        this.fIY.play(this.fIT).with(this.fIW);
    }

    private void beU() {
        this.fIU = ObjectAnimator.ofFloat(this.fIZ, "translationY", 0.0f);
        this.fIU.setInterpolator(new LinearInterpolator());
        this.fIU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fIZ != null) {
                    b.this.fIZ.clearAnimation();
                    b.this.fIZ.setVisibility(0);
                    b.this.fP(false);
                    if (b.this.fwi != null) {
                        b.this.fwi.jF(true);
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
        this.fIV = ValueAnimator.ofInt(this.fJb, 0);
        this.fIV.setInterpolator(new LinearInterpolator());
        this.fIV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fJa.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fJa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fJb;
                    b.this.fJa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fJa.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fJa.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fJa.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fIV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fJa.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fJa.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fIX = new AnimatorSet();
        this.fIX.play(this.fIU).with(this.fIV);
    }

    public void avN() {
        x(false, false);
    }

    public void avO() {
        x(false, true);
    }

    public void x(boolean z, boolean z2) {
        if (this.fIZ != null && this.fIZ.getY() == 0.0f && !avQ()) {
            if (z2) {
                this.fIZ.setVisibility(8);
                if (this.fJe) {
                    fP(false);
                    return;
                } else {
                    fP(true);
                    return;
                }
            }
            this.fIZ.setVisibility(0);
            if (this.fIY == null) {
                beT();
            }
            if (this.fIY != null) {
                this.fIY.cancel();
                this.fIY.setDuration(300L).start();
            }
        }
    }

    public void avP() {
        if (this.fIZ != null && this.fIZ.getY() < 0.0f && !avQ()) {
            this.fIZ.setVisibility(0);
            if (this.fIX == null) {
                beU();
            }
            if (this.fIX != null) {
                this.fIX.cancel();
                this.fIX.setDuration(300L).start();
            }
        }
    }

    public void Lv() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lw() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lx() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avQ() {
        return (this.fIX != null && this.fIX.isRunning()) || (this.fIY != null && this.fIY.isRunning());
    }

    public void hideFloatingView() {
        if (this.dpH) {
            if (this.aJf) {
                fP(true);
            } else if (this.fIZ != null && !this.fJd && !this.fGC && beV()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Lw();
            }
        }
    }

    public void showFloatingView() {
        if (this.dpH) {
            if (this.aJf) {
                fP(true);
            } else if (this.fIZ != null && !beV()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Lv();
            }
        }
    }

    public boolean beV() {
        return this.fIZ.getVisibility() == 0 && this.fIZ.getY() >= 0.0f;
    }

    public void ky(boolean z) {
        this.fJd = z;
    }

    public void kz(boolean z) {
        this.fGC = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dpH && this.fIZ != null && !this.fJd && !this.fGC && this.fJc) {
            if (i > this.aWC && beV()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aWC && !beV()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aWC = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fJc = true;
        } else if (i == 0) {
            this.fJc = false;
        }
        if (this.dpH && !this.fJd && !this.fGC) {
            if (this.aJf) {
                fP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aWC) {
                    Lw();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aWC) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Lv();
                } else if (firstVisiblePosition == this.aWC) {
                    if (firstVisiblePosition == 0 || !this.aWD || c(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Lv();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Lw();
                }
            }
        }
    }

    public boolean c(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void Ud() {
        if (this.dov != null) {
            if (this.dpG && this.dov.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dov.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dov.setLayoutParams(layoutParams);
                fP(true);
                return;
            }
            fP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(boolean z) {
        if (this.dov != null) {
            if (this.dpG && z && this.dov.getVisibility() != 0) {
                this.dov.setVisibility(0);
            } else if (!z && this.dov.getVisibility() != 8) {
                this.dov.setVisibility(8);
            }
        }
    }
}
