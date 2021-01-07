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
    private View bMl;
    private a lOb;
    private Animator lZB;
    private Animator lZC;
    private ValueAnimator lZD;
    private ValueAnimator lZE;
    private AnimatorSet lZF;
    private AnimatorSet lZG;
    private View lZH;
    private View lZI;
    private View mExpandView;
    private int lZJ = UtilHelper.getLightStatusBarHeight();
    private boolean lZK = false;
    private boolean fAV = false;
    private int fPD = 0;
    private boolean lZL = false;
    private boolean lVQ = false;
    private boolean lZM = false;
    private boolean fPE = false;
    private boolean jkb = true;
    private final Handler.Callback jke = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cHt()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cHr();
                    return true;
                case 2:
                    b.this.cHp();
                    return true;
                case 3:
                    b.this.cHq();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jke);
    private boolean bMm = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void uV(boolean z);
    }

    public void a(a aVar) {
        this.lOb = aVar;
    }

    public void qL(boolean z) {
        this.fPE = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lZH = view;
        this.bMl = view2;
        this.mExpandView = view3;
        this.lZI = this.mExpandView.findViewById(R.id.sticky_view);
        Wt();
        di(false);
    }

    private void dtE() {
        this.lZB = ObjectAnimator.ofFloat(this.lZH, "translationY", (-this.lZH.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lZB.setInterpolator(new LinearInterpolator());
        this.lZB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lZH != null) {
                    b.this.lZH.clearAnimation();
                    if (b.this.lZM) {
                        b.this.di(false);
                    } else {
                        b.this.di(true);
                    }
                    if (b.this.lOb != null) {
                        b.this.lOb.uV(false);
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
        this.lZE = ValueAnimator.ofInt(0, this.lZJ);
        this.lZE.setInterpolator(new LinearInterpolator());
        this.lZE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lZI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lZI.setLayoutParams(layoutParams);
                }
                b.this.lZI.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lZI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lZJ;
                    b.this.lZI.setLayoutParams(layoutParams);
                }
                b.this.lZI.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lZE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lZI.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lZI.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lZG = new AnimatorSet();
        this.lZG.play(this.lZB).with(this.lZE);
    }

    private void dtF() {
        this.lZC = ObjectAnimator.ofFloat(this.lZH, "translationY", 0.0f);
        this.lZC.setInterpolator(new LinearInterpolator());
        this.lZC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lZH != null) {
                    b.this.lZH.clearAnimation();
                    b.this.lZH.setVisibility(0);
                    b.this.di(false);
                    if (b.this.lOb != null) {
                        b.this.lOb.uV(true);
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
        this.lZD = ValueAnimator.ofInt(this.lZJ, 0);
        this.lZD.setInterpolator(new LinearInterpolator());
        this.lZD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lZI.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lZI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lZJ;
                    b.this.lZI.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lZI.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lZI.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lZI.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lZD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lZI.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lZI.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lZF = new AnimatorSet();
        this.lZF.play(this.lZC).with(this.lZD);
    }

    public void cHp() {
        ab(false, false);
    }

    public void cHq() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.lZH != null && this.lZH.getY() == 0.0f && !cHt()) {
            if (z2) {
                this.lZH.setVisibility(8);
                if (this.lZM) {
                    di(false);
                    return;
                } else {
                    di(true);
                    return;
                }
            }
            this.lZH.setVisibility(0);
            if (this.lZG == null) {
                dtE();
            }
            if (this.lZG != null) {
                this.lZG.cancel();
                this.lZG.setDuration(300L).start();
            }
        }
    }

    public void cHr() {
        if (this.lZH != null && this.lZH.getY() < 0.0f && !cHt()) {
            this.lZH.setVisibility(0);
            if (this.lZF == null) {
                dtF();
            }
            if (this.lZF != null) {
                this.lZF.cancel();
                this.lZF.setDuration(300L).start();
            }
        }
    }

    public void bJc() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bJd() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cHs() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cHt() {
        return (this.lZF != null && this.lZF.isRunning()) || (this.lZG != null && this.lZG.isRunning());
    }

    public void hideFloatingView() {
        if (this.jkb) {
            if (this.fAV) {
                di(true);
            } else if (this.lZH != null && !this.lZL && !this.lVQ && dtG()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bJd();
            }
        }
    }

    public void showFloatingView() {
        if (this.jkb) {
            if (this.fAV) {
                di(true);
            } else if (this.lZH != null && !dtG()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bJc();
            }
        }
    }

    public boolean dtG() {
        return this.lZH.getVisibility() == 0 && this.lZH.getY() >= 0.0f;
    }

    public void vK(boolean z) {
        this.lZL = z;
    }

    public void vL(boolean z) {
        this.lVQ = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jkb && this.lZH != null && !this.lZL && !this.lVQ && this.lZK) {
            if (i > this.fPD && dtG()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fPD && !dtG()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fPD = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lZK = true;
        } else if (i == 0) {
            this.lZK = false;
        }
        if (this.jkb && !this.lZL && !this.lVQ) {
            if (this.fAV) {
                di(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fPD) {
                    bJd();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fPD) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bJc();
                } else if (firstVisiblePosition == this.fPD) {
                    if (firstVisiblePosition == 0 || !this.fPE || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bJc();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bJd();
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

    private void Wt() {
        if (this.bMl != null) {
            if (this.bMm && this.bMl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bMl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bMl.setLayoutParams(layoutParams);
                di(true);
                return;
            }
            di(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void di(boolean z) {
        if (this.bMl != null) {
            if (this.bMm && z && this.bMl.getVisibility() != 0) {
                this.bMl.setVisibility(0);
            } else if (!z && this.bMl.getVisibility() != 8) {
                this.bMl.setVisibility(8);
            }
        }
    }
}
