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
/* loaded from: classes22.dex */
public class b {
    private View bvC;
    private a lci;
    private Animator lnF;
    private Animator lnG;
    private ValueAnimator lnH;
    private ValueAnimator lnI;
    private AnimatorSet lnJ;
    private AnimatorSet lnK;
    private View lnL;
    private View lnM;
    private View mExpandView;
    private int lnN = UtilHelper.getLightStatusBarHeight();
    private boolean lnO = false;
    private boolean eWt = false;
    private int fkH = 0;
    private boolean lnP = false;
    private boolean ljX = false;
    private boolean lnQ = false;
    private boolean fkI = false;
    private boolean itP = true;
    private final Handler.Callback itS = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cuV()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cuT();
                    return true;
                case 2:
                    b.this.cuR();
                    return true;
                case 3:
                    b.this.cuS();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.itS);
    private boolean bvD = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes22.dex */
    public interface a {
        void tP(boolean z);
    }

    public void a(a aVar) {
        this.lci = aVar;
    }

    public void pm(boolean z) {
        this.fkI = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lnL = view;
        this.bvC = view2;
        this.mExpandView = view3;
        this.lnM = this.mExpandView.findViewById(R.id.sticky_view);
        PW();
        cC(false);
    }

    private void djn() {
        this.lnF = ObjectAnimator.ofFloat(this.lnL, "translationY", (-this.lnL.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lnF.setInterpolator(new LinearInterpolator());
        this.lnF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lnL != null) {
                    b.this.lnL.clearAnimation();
                    if (b.this.lnQ) {
                        b.this.cC(false);
                    } else {
                        b.this.cC(true);
                    }
                    if (b.this.lci != null) {
                        b.this.lci.tP(false);
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
        this.lnI = ValueAnimator.ofInt(0, this.lnN);
        this.lnI.setInterpolator(new LinearInterpolator());
        this.lnI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lnM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lnM.setLayoutParams(layoutParams);
                }
                b.this.lnM.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lnM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lnN;
                    b.this.lnM.setLayoutParams(layoutParams);
                }
                b.this.lnM.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lnI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lnM.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lnM.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lnK = new AnimatorSet();
        this.lnK.play(this.lnF).with(this.lnI);
    }

    private void djo() {
        this.lnG = ObjectAnimator.ofFloat(this.lnL, "translationY", 0.0f);
        this.lnG.setInterpolator(new LinearInterpolator());
        this.lnG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lnL != null) {
                    b.this.lnL.clearAnimation();
                    b.this.lnL.setVisibility(0);
                    b.this.cC(false);
                    if (b.this.lci != null) {
                        b.this.lci.tP(true);
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
        this.lnH = ValueAnimator.ofInt(this.lnN, 0);
        this.lnH.setInterpolator(new LinearInterpolator());
        this.lnH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lnM.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lnM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lnN;
                    b.this.lnM.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lnM.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lnM.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lnM.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lnH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lnM.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lnM.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lnJ = new AnimatorSet();
        this.lnJ.play(this.lnG).with(this.lnH);
    }

    public void cuR() {
        W(false, false);
    }

    public void cuS() {
        W(false, true);
    }

    public void W(boolean z, boolean z2) {
        if (this.lnL != null && this.lnL.getY() == 0.0f && !cuV()) {
            if (z2) {
                this.lnL.setVisibility(8);
                if (this.lnQ) {
                    cC(false);
                    return;
                } else {
                    cC(true);
                    return;
                }
            }
            this.lnL.setVisibility(0);
            if (this.lnK == null) {
                djn();
            }
            if (this.lnK != null) {
                this.lnK.cancel();
                this.lnK.setDuration(300L).start();
            }
        }
    }

    public void cuT() {
        if (this.lnL != null && this.lnL.getY() < 0.0f && !cuV()) {
            this.lnL.setVisibility(0);
            if (this.lnJ == null) {
                djo();
            }
            if (this.lnJ != null) {
                this.lnJ.cancel();
                this.lnJ.setDuration(300L).start();
            }
        }
    }

    public void bzy() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bzz() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cuU() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cuV() {
        return (this.lnJ != null && this.lnJ.isRunning()) || (this.lnK != null && this.lnK.isRunning());
    }

    public void hideFloatingView() {
        if (this.itP) {
            if (this.eWt) {
                cC(true);
            } else if (this.lnL != null && !this.lnP && !this.ljX && djp()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bzz();
            }
        }
    }

    public void showFloatingView() {
        if (this.itP) {
            if (this.eWt) {
                cC(true);
            } else if (this.lnL != null && !djp()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bzy();
            }
        }
    }

    public boolean djp() {
        return this.lnL.getVisibility() == 0 && this.lnL.getY() >= 0.0f;
    }

    public void uD(boolean z) {
        this.lnP = z;
    }

    public void uE(boolean z) {
        this.ljX = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.itP && this.lnL != null && !this.lnP && !this.ljX && this.lnO) {
            if (i > this.fkH && djp()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fkH && !djp()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fkH = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lnO = true;
        } else if (i == 0) {
            this.lnO = false;
        }
        if (this.itP && !this.lnP && !this.ljX) {
            if (this.eWt) {
                cC(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fkH) {
                    bzz();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fkH) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bzy();
                } else if (firstVisiblePosition == this.fkH) {
                    if (firstVisiblePosition == 0 || !this.fkI || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bzy();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bzz();
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

    private void PW() {
        if (this.bvC != null) {
            if (this.bvD && this.bvC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bvC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bvC.setLayoutParams(layoutParams);
                cC(true);
                return;
            }
            cC(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(boolean z) {
        if (this.bvC != null) {
            if (this.bvD && z && this.bvC.getVisibility() != 0) {
                this.bvC.setVisibility(0);
            } else if (!z && this.bvC.getVisibility() != 8) {
                this.bvC.setVisibility(8);
            }
        }
    }
}
