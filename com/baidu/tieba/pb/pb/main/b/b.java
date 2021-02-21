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
    private View bLj;
    private a lSJ;
    private View mExpandView;
    private Animator mer;
    private Animator mes;
    private ValueAnimator met;
    private ValueAnimator meu;
    private AnimatorSet mev;
    private AnimatorSet mew;
    private View mex;
    private View mey;
    private int mez = UtilHelper.getLightStatusBarHeight();
    private boolean meA = false;
    private boolean fyD = false;
    private int fNi = 0;
    private boolean meB = false;
    private boolean maA = false;
    private boolean meC = false;
    private boolean fNj = false;
    private boolean jlo = true;
    private final Handler.Callback jlr = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cEU()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cES();
                    return true;
                case 2:
                    b.this.cEQ();
                    return true;
                case 3:
                    b.this.cER();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jlr);
    private boolean bLk = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void vg(boolean z);
    }

    public void a(a aVar) {
        this.lSJ = aVar;
    }

    public void qR(boolean z) {
        this.fNj = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.mex = view;
        this.bLj = view2;
        this.mExpandView = view3;
        this.mey = this.mExpandView.findViewById(R.id.sticky_view);
        Uh();
        dm(false);
    }

    private void dsh() {
        this.mer = ObjectAnimator.ofFloat(this.mex, "translationY", (-this.mex.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.mer.setInterpolator(new LinearInterpolator());
        this.mer.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.mex != null) {
                    b.this.mex.clearAnimation();
                    if (b.this.meC) {
                        b.this.dm(false);
                    } else {
                        b.this.dm(true);
                    }
                    if (b.this.lSJ != null) {
                        b.this.lSJ.vg(false);
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
        this.meu = ValueAnimator.ofInt(0, this.mez);
        this.meu.setInterpolator(new LinearInterpolator());
        this.meu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.mey.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.mey.setLayoutParams(layoutParams);
                }
                b.this.mey.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.mey.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.mez;
                    b.this.mey.setLayoutParams(layoutParams);
                }
                b.this.mey.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.meu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.mey.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.mey.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.mew = new AnimatorSet();
        this.mew.play(this.mer).with(this.meu);
    }

    private void dsi() {
        this.mes = ObjectAnimator.ofFloat(this.mex, "translationY", 0.0f);
        this.mes.setInterpolator(new LinearInterpolator());
        this.mes.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.mex != null) {
                    b.this.mex.clearAnimation();
                    b.this.mex.setVisibility(0);
                    b.this.dm(false);
                    if (b.this.lSJ != null) {
                        b.this.lSJ.vg(true);
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
        this.met = ValueAnimator.ofInt(this.mez, 0);
        this.met.setInterpolator(new LinearInterpolator());
        this.met.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.mey.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.mey.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.mez;
                    b.this.mey.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.mey.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.mey.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.mey.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.met.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.mey.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.mey.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.mev = new AnimatorSet();
        this.mev.play(this.mes).with(this.met);
    }

    public void cEQ() {
        ab(false, false);
    }

    public void cER() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.mex != null && this.mex.getY() == 0.0f && !cEU()) {
            if (z2) {
                this.mex.setVisibility(8);
                if (this.meC) {
                    dm(false);
                    return;
                } else {
                    dm(true);
                    return;
                }
            }
            this.mex.setVisibility(0);
            if (this.mew == null) {
                dsh();
            }
            if (this.mew != null) {
                this.mew.cancel();
                this.mew.setDuration(300L).start();
            }
        }
    }

    public void cES() {
        if (this.mex != null && this.mex.getY() < 0.0f && !cEU()) {
            this.mex.setVisibility(0);
            if (this.mev == null) {
                dsi();
            }
            if (this.mev != null) {
                this.mev.cancel();
                this.mev.setDuration(300L).start();
            }
        }
    }

    public void bFD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cET() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cEU() {
        return (this.mev != null && this.mev.isRunning()) || (this.mew != null && this.mew.isRunning());
    }

    public void hideFloatingView() {
        if (this.jlo) {
            if (this.fyD) {
                dm(true);
            } else if (this.mex != null && !this.meB && !this.maA && dsj()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bFE();
            }
        }
    }

    public void showFloatingView() {
        if (this.jlo) {
            if (this.fyD) {
                dm(true);
            } else if (this.mex != null && !dsj()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bFD();
            }
        }
    }

    public boolean dsj() {
        return this.mex.getVisibility() == 0 && this.mex.getY() >= 0.0f;
    }

    public void vW(boolean z) {
        this.meB = z;
    }

    public void vX(boolean z) {
        this.maA = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jlo && this.mex != null && !this.meB && !this.maA && this.meA) {
            if (i > this.fNi && dsj()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fNi && !dsj()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fNi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.meA = true;
        } else if (i == 0) {
            this.meA = false;
        }
        if (this.jlo && !this.meB && !this.maA) {
            if (this.fyD) {
                dm(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fNi) {
                    bFE();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fNi) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bFD();
                } else if (firstVisiblePosition == this.fNi) {
                    if (firstVisiblePosition == 0 || !this.fNj || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bFD();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bFE();
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

    private void Uh() {
        if (this.bLj != null) {
            if (this.bLk && this.bLj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bLj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bLj.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(boolean z) {
        if (this.bLj != null) {
            if (this.bLk && z && this.bLj.getVisibility() != 0) {
                this.bLj.setVisibility(0);
            } else if (!z && this.bLj.getVisibility() != 8) {
                this.bLj.setVisibility(8);
            }
        }
    }
}
