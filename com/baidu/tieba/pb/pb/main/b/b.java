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
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class b {
    private View On;
    private View dMX;
    private a fWJ;
    private Animator gjj;
    private Animator gjk;
    private ValueAnimator gjl;
    private ValueAnimator gjm;
    private AnimatorSet gjn;
    private AnimatorSet gjo;
    private View gjp;
    private View gjq;
    private int gjr = UtilHelper.getLightStatusBarHeight();
    private boolean gjs = false;
    private boolean aVn = false;
    private int biM = 0;
    private boolean gjt = false;
    private boolean ggL = false;
    private boolean gju = false;
    private boolean biN = false;
    private boolean dOz = true;
    private final Handler.Callback dOB = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aDt()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aDs();
                    return true;
                case 2:
                    b.this.aDq();
                    return true;
                case 3:
                    b.this.aDr();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dOB);
    private boolean dOy = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes6.dex */
    public interface a {
        void kO(boolean z);
    }

    public void a(a aVar) {
        this.fWJ = aVar;
    }

    public void gQ(boolean z) {
        this.biN = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.gjp = view;
        this.dMX = view2;
        this.On = view3;
        this.gjq = this.On.findViewById(e.g.sticky_view);
        aaQ();
        gS(false);
    }

    private void bmK() {
        this.gjj = ObjectAnimator.ofFloat(this.gjp, "translationY", (-this.gjp.getMeasuredHeight()) + this.On.getMeasuredHeight());
        this.gjj.setInterpolator(new LinearInterpolator());
        this.gjj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.gjp != null) {
                    b.this.gjp.clearAnimation();
                    if (b.this.gju) {
                        b.this.gS(false);
                    } else {
                        b.this.gS(true);
                    }
                    if (b.this.fWJ != null) {
                        b.this.fWJ.kO(false);
                    }
                    b.this.On.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gjm = ValueAnimator.ofInt(0, this.gjr);
        this.gjm.setInterpolator(new LinearInterpolator());
        this.gjm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.gjq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.gjq.setLayoutParams(layoutParams);
                }
                b.this.gjq.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.gjq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.gjr;
                    b.this.gjq.setLayoutParams(layoutParams);
                }
                b.this.gjq.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gjm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.gjq.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.gjq.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.gjo = new AnimatorSet();
        this.gjo.play(this.gjj).with(this.gjm);
    }

    private void bmL() {
        this.gjk = ObjectAnimator.ofFloat(this.gjp, "translationY", 0.0f);
        this.gjk.setInterpolator(new LinearInterpolator());
        this.gjk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.gjp != null) {
                    b.this.gjp.clearAnimation();
                    b.this.gjp.setVisibility(0);
                    b.this.gS(false);
                    if (b.this.fWJ != null) {
                        b.this.fWJ.kO(true);
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
        this.gjl = ValueAnimator.ofInt(this.gjr, 0);
        this.gjl.setInterpolator(new LinearInterpolator());
        this.gjl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.gjq.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.gjq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.gjr;
                    b.this.gjq.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.gjq.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.gjq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.gjq.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gjl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.gjq.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.gjq.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.gjn = new AnimatorSet();
        this.gjn.play(this.gjk).with(this.gjl);
    }

    public void aDq() {
        C(false, false);
    }

    public void aDr() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.gjp != null && this.gjp.getY() == 0.0f && !aDt()) {
            if (z2) {
                this.gjp.setVisibility(8);
                if (this.gju) {
                    gS(false);
                    return;
                } else {
                    gS(true);
                    return;
                }
            }
            this.gjp.setVisibility(0);
            if (this.gjo == null) {
                bmK();
            }
            if (this.gjo != null) {
                this.gjo.cancel();
                this.gjo.setDuration(300L).start();
            }
        }
    }

    public void aDs() {
        if (this.gjp != null && this.gjp.getY() < 0.0f && !aDt()) {
            this.gjp.setVisibility(0);
            if (this.gjn == null) {
                bmL();
            }
            if (this.gjn != null) {
                this.gjn.cancel();
                this.gjn.setDuration(300L).start();
            }
        }
    }

    public void Qc() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qd() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qe() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aDt() {
        return (this.gjn != null && this.gjn.isRunning()) || (this.gjo != null && this.gjo.isRunning());
    }

    public void hideFloatingView() {
        if (this.dOz) {
            if (this.aVn) {
                gS(true);
            } else if (this.gjp != null && !this.gjt && !this.ggL && bmM()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Qd();
            }
        }
    }

    public void showFloatingView() {
        if (this.dOz) {
            if (this.aVn) {
                gS(true);
            } else if (this.gjp != null && !bmM()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Qc();
            }
        }
    }

    public boolean bmM() {
        return this.gjp.getVisibility() == 0 && this.gjp.getY() >= 0.0f;
    }

    public void lE(boolean z) {
        this.gjt = z;
    }

    public void lF(boolean z) {
        this.ggL = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dOz && this.gjp != null && !this.gjt && !this.ggL && this.gjs) {
            if (i > this.biM && bmM()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.biM && !bmM()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.biM = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.gjs = true;
        } else if (i == 0) {
            this.gjs = false;
        }
        if (this.dOz && !this.gjt && !this.ggL) {
            if (this.aVn) {
                gS(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.biM) {
                    Qd();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.biM) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Qc();
                } else if (firstVisiblePosition == this.biM) {
                    if (firstVisiblePosition == 0 || !this.biN || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Qc();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Qd();
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

    private void aaQ() {
        if (this.dMX != null) {
            if (this.dOy && this.dMX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dMX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dMX.setLayoutParams(layoutParams);
                gS(true);
                return;
            }
            gS(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gS(boolean z) {
        if (this.dMX != null) {
            if (this.dOy && z && this.dMX.getVisibility() != 0) {
                this.dMX.setVisibility(0);
            } else if (!z && this.dMX.getVisibility() != 8) {
                this.dMX.setVisibility(8);
            }
        }
    }
}
