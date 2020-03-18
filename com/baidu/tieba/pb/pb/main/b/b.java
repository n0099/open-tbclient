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
/* loaded from: classes9.dex */
public class b {
    private View aCq;
    private a iKh;
    private AnimatorSet iUA;
    private View iUB;
    private View iUC;
    private Animator iUv;
    private Animator iUw;
    private ValueAnimator iUx;
    private ValueAnimator iUy;
    private AnimatorSet iUz;
    private View mExpandView;
    private int iUD = UtilHelper.getLightStatusBarHeight();
    private boolean iUE = false;
    private boolean dup = false;
    private int dHp = 0;
    private boolean iUF = false;
    private boolean iQU = false;
    private boolean iUG = false;
    private boolean dHq = false;
    private boolean gtd = true;
    private final Handler.Callback gtg = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bGb()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bGa();
                    return true;
                case 2:
                    b.this.bFY();
                    return true;
                case 3:
                    b.this.bFZ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gtg);
    private boolean aCr = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void pW(boolean z);
    }

    public void a(a aVar) {
        this.iKh = aVar;
    }

    public void lH(boolean z) {
        this.dHq = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.iUB = view;
        this.aCq = view2;
        this.mExpandView = view3;
        this.iUC = this.mExpandView.findViewById(R.id.sticky_view);
        Ao();
        bt(false);
    }

    private void crn() {
        this.iUv = ObjectAnimator.ofFloat(this.iUB, "translationY", (-this.iUB.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.iUv.setInterpolator(new LinearInterpolator());
        this.iUv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iUB != null) {
                    b.this.iUB.clearAnimation();
                    if (b.this.iUG) {
                        b.this.bt(false);
                    } else {
                        b.this.bt(true);
                    }
                    if (b.this.iKh != null) {
                        b.this.iKh.pW(false);
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
        this.iUy = ValueAnimator.ofInt(0, this.iUD);
        this.iUy.setInterpolator(new LinearInterpolator());
        this.iUy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iUC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iUC.setLayoutParams(layoutParams);
                }
                b.this.iUC.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iUC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iUD;
                    b.this.iUC.setLayoutParams(layoutParams);
                }
                b.this.iUC.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iUy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iUC.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iUC.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iUA = new AnimatorSet();
        this.iUA.play(this.iUv).with(this.iUy);
    }

    private void cro() {
        this.iUw = ObjectAnimator.ofFloat(this.iUB, "translationY", 0.0f);
        this.iUw.setInterpolator(new LinearInterpolator());
        this.iUw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iUB != null) {
                    b.this.iUB.clearAnimation();
                    b.this.iUB.setVisibility(0);
                    b.this.bt(false);
                    if (b.this.iKh != null) {
                        b.this.iKh.pW(true);
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
        this.iUx = ValueAnimator.ofInt(this.iUD, 0);
        this.iUx.setInterpolator(new LinearInterpolator());
        this.iUx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.iUC.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.iUC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iUD;
                    b.this.iUC.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.iUC.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.iUC.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iUC.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iUx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iUC.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iUC.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iUz = new AnimatorSet();
        this.iUz.play(this.iUw).with(this.iUx);
    }

    public void bFY() {
        N(false, false);
    }

    public void bFZ() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.iUB != null && this.iUB.getY() == 0.0f && !bGb()) {
            if (z2) {
                this.iUB.setVisibility(8);
                if (this.iUG) {
                    bt(false);
                    return;
                } else {
                    bt(true);
                    return;
                }
            }
            this.iUB.setVisibility(0);
            if (this.iUA == null) {
                crn();
            }
            if (this.iUA != null) {
                this.iUA.cancel();
                this.iUA.setDuration(300L).start();
            }
        }
    }

    public void bGa() {
        if (this.iUB != null && this.iUB.getY() < 0.0f && !bGb()) {
            this.iUB.setVisibility(0);
            if (this.iUz == null) {
                cro();
            }
            if (this.iUz != null) {
                this.iUz.cancel();
                this.iUz.setDuration(300L).start();
            }
        }
    }

    public void aSr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSs() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWN() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bGb() {
        return (this.iUz != null && this.iUz.isRunning()) || (this.iUA != null && this.iUA.isRunning());
    }

    public void hideFloatingView() {
        if (this.gtd) {
            if (this.dup) {
                bt(true);
            } else if (this.iUB != null && !this.iUF && !this.iQU && crp()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aSs();
            }
        }
    }

    public void showFloatingView() {
        if (this.gtd) {
            if (this.dup) {
                bt(true);
            } else if (this.iUB != null && !crp()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aSr();
            }
        }
    }

    public boolean crp() {
        return this.iUB.getVisibility() == 0 && this.iUB.getY() >= 0.0f;
    }

    public void qH(boolean z) {
        this.iUF = z;
    }

    public void qI(boolean z) {
        this.iQU = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gtd && this.iUB != null && !this.iUF && !this.iQU && this.iUE) {
            if (i > this.dHp && crp()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.dHp && !crp()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.dHp = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.iUE = true;
        } else if (i == 0) {
            this.iUE = false;
        }
        if (this.gtd && !this.iUF && !this.iQU) {
            if (this.dup) {
                bt(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.dHp) {
                    aSs();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.dHp) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aSr();
                } else if (firstVisiblePosition == this.dHp) {
                    if (firstVisiblePosition == 0 || !this.dHq || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aSr();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aSs();
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

    private void Ao() {
        if (this.aCq != null) {
            if (this.aCr && this.aCq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCq.setLayoutParams(layoutParams);
                bt(true);
                return;
            }
            bt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt(boolean z) {
        if (this.aCq != null) {
            if (this.aCr && z && this.aCq.getVisibility() != 0) {
                this.aCq.setVisibility(0);
            } else if (!z && this.aCq.getVisibility() != 8) {
                this.aCq.setVisibility(8);
            }
        }
    }
}
