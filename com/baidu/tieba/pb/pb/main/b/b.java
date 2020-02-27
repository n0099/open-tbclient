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
    private View aCa;
    private a iIs;
    private Animator iSG;
    private Animator iSH;
    private ValueAnimator iSI;
    private ValueAnimator iSJ;
    private AnimatorSet iSK;
    private AnimatorSet iSL;
    private View iSM;
    private View iSN;
    private View mExpandView;
    private int iSO = UtilHelper.getLightStatusBarHeight();
    private boolean iSP = false;
    private boolean dtO = false;
    private int dGL = 0;
    private boolean iSQ = false;
    private boolean iPf = false;
    private boolean iSR = false;
    private boolean dGM = false;
    private boolean gsk = true;
    private final Handler.Callback gsn = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bFN()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bFM();
                    return true;
                case 2:
                    b.this.bFK();
                    return true;
                case 3:
                    b.this.bFL();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gsn);
    private boolean aCb = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void pQ(boolean z);
    }

    public void a(a aVar) {
        this.iIs = aVar;
    }

    public void lC(boolean z) {
        this.dGM = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.iSM = view;
        this.aCa = view2;
        this.mExpandView = view3;
        this.iSN = this.mExpandView.findViewById(R.id.sticky_view);
        Af();
        bs(false);
    }

    private void cqP() {
        this.iSG = ObjectAnimator.ofFloat(this.iSM, "translationY", (-this.iSM.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.iSG.setInterpolator(new LinearInterpolator());
        this.iSG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iSM != null) {
                    b.this.iSM.clearAnimation();
                    if (b.this.iSR) {
                        b.this.bs(false);
                    } else {
                        b.this.bs(true);
                    }
                    if (b.this.iIs != null) {
                        b.this.iIs.pQ(false);
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
        this.iSJ = ValueAnimator.ofInt(0, this.iSO);
        this.iSJ.setInterpolator(new LinearInterpolator());
        this.iSJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iSN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iSN.setLayoutParams(layoutParams);
                }
                b.this.iSN.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iSN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iSO;
                    b.this.iSN.setLayoutParams(layoutParams);
                }
                b.this.iSN.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iSJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iSN.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iSN.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iSL = new AnimatorSet();
        this.iSL.play(this.iSG).with(this.iSJ);
    }

    private void cqQ() {
        this.iSH = ObjectAnimator.ofFloat(this.iSM, "translationY", 0.0f);
        this.iSH.setInterpolator(new LinearInterpolator());
        this.iSH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iSM != null) {
                    b.this.iSM.clearAnimation();
                    b.this.iSM.setVisibility(0);
                    b.this.bs(false);
                    if (b.this.iIs != null) {
                        b.this.iIs.pQ(true);
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
        this.iSI = ValueAnimator.ofInt(this.iSO, 0);
        this.iSI.setInterpolator(new LinearInterpolator());
        this.iSI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.iSN.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.iSN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iSO;
                    b.this.iSN.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.iSN.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.iSN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iSN.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iSI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iSN.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iSN.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iSK = new AnimatorSet();
        this.iSK.play(this.iSH).with(this.iSI);
    }

    public void bFK() {
        N(false, false);
    }

    public void bFL() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.iSM != null && this.iSM.getY() == 0.0f && !bFN()) {
            if (z2) {
                this.iSM.setVisibility(8);
                if (this.iSR) {
                    bs(false);
                    return;
                } else {
                    bs(true);
                    return;
                }
            }
            this.iSM.setVisibility(0);
            if (this.iSL == null) {
                cqP();
            }
            if (this.iSL != null) {
                this.iSL.cancel();
                this.iSL.setDuration(300L).start();
            }
        }
    }

    public void bFM() {
        if (this.iSM != null && this.iSM.getY() < 0.0f && !bFN()) {
            this.iSM.setVisibility(0);
            if (this.iSK == null) {
                cqQ();
            }
            if (this.iSK != null) {
                this.iSK.cancel();
                this.iSK.setDuration(300L).start();
            }
        }
    }

    public void aSk() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSl() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWG() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bFN() {
        return (this.iSK != null && this.iSK.isRunning()) || (this.iSL != null && this.iSL.isRunning());
    }

    public void hideFloatingView() {
        if (this.gsk) {
            if (this.dtO) {
                bs(true);
            } else if (this.iSM != null && !this.iSQ && !this.iPf && cqR()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aSl();
            }
        }
    }

    public void showFloatingView() {
        if (this.gsk) {
            if (this.dtO) {
                bs(true);
            } else if (this.iSM != null && !cqR()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aSk();
            }
        }
    }

    public boolean cqR() {
        return this.iSM.getVisibility() == 0 && this.iSM.getY() >= 0.0f;
    }

    public void qB(boolean z) {
        this.iSQ = z;
    }

    public void qC(boolean z) {
        this.iPf = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gsk && this.iSM != null && !this.iSQ && !this.iPf && this.iSP) {
            if (i > this.dGL && cqR()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.dGL && !cqR()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.dGL = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.iSP = true;
        } else if (i == 0) {
            this.iSP = false;
        }
        if (this.gsk && !this.iSQ && !this.iPf) {
            if (this.dtO) {
                bs(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.dGL) {
                    aSl();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.dGL) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aSk();
                } else if (firstVisiblePosition == this.dGL) {
                    if (firstVisiblePosition == 0 || !this.dGM || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aSk();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aSl();
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

    private void Af() {
        if (this.aCa != null) {
            if (this.aCb && this.aCa.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCa.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCa.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(boolean z) {
        if (this.aCa != null) {
            if (this.aCb && z && this.aCa.getVisibility() != 0) {
                this.aCa.setVisibility(0);
            } else if (!z && this.aCa.getVisibility() != 8) {
                this.aCa.setVisibility(8);
            }
        }
    }
}
