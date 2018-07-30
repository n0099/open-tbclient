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
    private View Lr;
    private View dox;
    private Animator fJa;
    private Animator fJb;
    private ValueAnimator fJc;
    private ValueAnimator fJd;
    private AnimatorSet fJe;
    private AnimatorSet fJf;
    private View fJg;
    private View fJh;
    private a fwp;
    private int fJi = UtilHelper.getLightStatusBarHeight();
    private boolean fJj = false;
    private boolean aJi = false;
    private int aWC = 0;
    private boolean fJk = false;
    private boolean fGJ = false;
    private boolean fJl = false;
    private boolean aWD = false;
    private boolean dpJ = true;
    private final Handler.Callback dpL = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.avR()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.avQ();
                    return true;
                case 2:
                    b.this.avO();
                    return true;
                case 3:
                    b.this.avP();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dpL);
    private boolean dpI = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jF(boolean z);
    }

    public void a(a aVar) {
        this.fwp = aVar;
    }

    public void fN(boolean z) {
        this.aWD = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fJg = view;
        this.dox = view2;
        this.Lr = view3;
        this.fJh = this.Lr.findViewById(d.g.sticky_view);
        Ua();
        fP(false);
    }

    private void beY() {
        this.fJa = ObjectAnimator.ofFloat(this.fJg, "translationY", (-this.fJg.getMeasuredHeight()) + this.Lr.getMeasuredHeight());
        this.fJa.setInterpolator(new LinearInterpolator());
        this.fJa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fJg != null) {
                    b.this.fJg.clearAnimation();
                    if (b.this.fJl) {
                        b.this.fP(false);
                    } else {
                        b.this.fP(true);
                    }
                    if (b.this.fwp != null) {
                        b.this.fwp.jF(false);
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
        this.fJd = ValueAnimator.ofInt(0, this.fJi);
        this.fJd.setInterpolator(new LinearInterpolator());
        this.fJd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fJh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fJh.setLayoutParams(layoutParams);
                }
                b.this.fJh.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fJh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fJi;
                    b.this.fJh.setLayoutParams(layoutParams);
                }
                b.this.fJh.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fJd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fJh.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fJh.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fJf = new AnimatorSet();
        this.fJf.play(this.fJa).with(this.fJd);
    }

    private void beZ() {
        this.fJb = ObjectAnimator.ofFloat(this.fJg, "translationY", 0.0f);
        this.fJb.setInterpolator(new LinearInterpolator());
        this.fJb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fJg != null) {
                    b.this.fJg.clearAnimation();
                    b.this.fJg.setVisibility(0);
                    b.this.fP(false);
                    if (b.this.fwp != null) {
                        b.this.fwp.jF(true);
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
        this.fJc = ValueAnimator.ofInt(this.fJi, 0);
        this.fJc.setInterpolator(new LinearInterpolator());
        this.fJc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fJh.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fJh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fJi;
                    b.this.fJh.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fJh.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fJh.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fJh.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fJc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fJh.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fJh.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fJe = new AnimatorSet();
        this.fJe.play(this.fJb).with(this.fJc);
    }

    public void avO() {
        x(false, false);
    }

    public void avP() {
        x(false, true);
    }

    public void x(boolean z, boolean z2) {
        if (this.fJg != null && this.fJg.getY() == 0.0f && !avR()) {
            if (z2) {
                this.fJg.setVisibility(8);
                if (this.fJl) {
                    fP(false);
                    return;
                } else {
                    fP(true);
                    return;
                }
            }
            this.fJg.setVisibility(0);
            if (this.fJf == null) {
                beY();
            }
            if (this.fJf != null) {
                this.fJf.cancel();
                this.fJf.setDuration(300L).start();
            }
        }
    }

    public void avQ() {
        if (this.fJg != null && this.fJg.getY() < 0.0f && !avR()) {
            this.fJg.setVisibility(0);
            if (this.fJe == null) {
                beZ();
            }
            if (this.fJe != null) {
                this.fJe.cancel();
                this.fJe.setDuration(300L).start();
            }
        }
    }

    public void Lr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Ls() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lt() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avR() {
        return (this.fJe != null && this.fJe.isRunning()) || (this.fJf != null && this.fJf.isRunning());
    }

    public void hideFloatingView() {
        if (this.dpJ) {
            if (this.aJi) {
                fP(true);
            } else if (this.fJg != null && !this.fJk && !this.fGJ && bfa()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Ls();
            }
        }
    }

    public void showFloatingView() {
        if (this.dpJ) {
            if (this.aJi) {
                fP(true);
            } else if (this.fJg != null && !bfa()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Lr();
            }
        }
    }

    public boolean bfa() {
        return this.fJg.getVisibility() == 0 && this.fJg.getY() >= 0.0f;
    }

    public void ky(boolean z) {
        this.fJk = z;
    }

    public void kz(boolean z) {
        this.fGJ = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dpJ && this.fJg != null && !this.fJk && !this.fGJ && this.fJj) {
            if (i > this.aWC && bfa()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aWC && !bfa()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aWC = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fJj = true;
        } else if (i == 0) {
            this.fJj = false;
        }
        if (this.dpJ && !this.fJk && !this.fGJ) {
            if (this.aJi) {
                fP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aWC) {
                    Ls();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aWC) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Lr();
                } else if (firstVisiblePosition == this.aWC) {
                    if (firstVisiblePosition == 0 || !this.aWD || c(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Lr();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Ls();
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

    private void Ua() {
        if (this.dox != null) {
            if (this.dpI && this.dox.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dox.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dox.setLayoutParams(layoutParams);
                fP(true);
                return;
            }
            fP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fP(boolean z) {
        if (this.dox != null) {
            if (this.dpI && z && this.dox.getVisibility() != 0) {
                this.dox.setVisibility(0);
            } else if (!z && this.dox.getVisibility() != 8) {
                this.dox.setVisibility(8);
            }
        }
    }
}
