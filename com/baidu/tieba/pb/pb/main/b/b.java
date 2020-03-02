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
    private View aCb;
    private a iIu;
    private Animator iSI;
    private Animator iSJ;
    private ValueAnimator iSK;
    private ValueAnimator iSL;
    private AnimatorSet iSM;
    private AnimatorSet iSN;
    private View iSO;
    private View iSP;
    private View mExpandView;
    private int iSQ = UtilHelper.getLightStatusBarHeight();
    private boolean iSR = false;
    private boolean dtP = false;
    private int dGM = 0;
    private boolean iSS = false;
    private boolean iPh = false;
    private boolean iST = false;
    private boolean dGN = false;
    private boolean gsm = true;
    private final Handler.Callback gsp = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bFP()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bFO();
                    return true;
                case 2:
                    b.this.bFM();
                    return true;
                case 3:
                    b.this.bFN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gsp);
    private boolean aCc = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void pQ(boolean z);
    }

    public void a(a aVar) {
        this.iIu = aVar;
    }

    public void lC(boolean z) {
        this.dGN = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.iSO = view;
        this.aCb = view2;
        this.mExpandView = view3;
        this.iSP = this.mExpandView.findViewById(R.id.sticky_view);
        Ah();
        bs(false);
    }

    private void cqR() {
        this.iSI = ObjectAnimator.ofFloat(this.iSO, "translationY", (-this.iSO.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.iSI.setInterpolator(new LinearInterpolator());
        this.iSI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iSO != null) {
                    b.this.iSO.clearAnimation();
                    if (b.this.iST) {
                        b.this.bs(false);
                    } else {
                        b.this.bs(true);
                    }
                    if (b.this.iIu != null) {
                        b.this.iIu.pQ(false);
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
        this.iSL = ValueAnimator.ofInt(0, this.iSQ);
        this.iSL.setInterpolator(new LinearInterpolator());
        this.iSL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iSP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iSP.setLayoutParams(layoutParams);
                }
                b.this.iSP.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iSP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iSQ;
                    b.this.iSP.setLayoutParams(layoutParams);
                }
                b.this.iSP.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iSL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iSP.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iSP.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iSN = new AnimatorSet();
        this.iSN.play(this.iSI).with(this.iSL);
    }

    private void cqS() {
        this.iSJ = ObjectAnimator.ofFloat(this.iSO, "translationY", 0.0f);
        this.iSJ.setInterpolator(new LinearInterpolator());
        this.iSJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iSO != null) {
                    b.this.iSO.clearAnimation();
                    b.this.iSO.setVisibility(0);
                    b.this.bs(false);
                    if (b.this.iIu != null) {
                        b.this.iIu.pQ(true);
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
        this.iSK = ValueAnimator.ofInt(this.iSQ, 0);
        this.iSK.setInterpolator(new LinearInterpolator());
        this.iSK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.iSP.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.iSP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iSQ;
                    b.this.iSP.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.iSP.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.iSP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iSP.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iSK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iSP.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iSP.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iSM = new AnimatorSet();
        this.iSM.play(this.iSJ).with(this.iSK);
    }

    public void bFM() {
        N(false, false);
    }

    public void bFN() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.iSO != null && this.iSO.getY() == 0.0f && !bFP()) {
            if (z2) {
                this.iSO.setVisibility(8);
                if (this.iST) {
                    bs(false);
                    return;
                } else {
                    bs(true);
                    return;
                }
            }
            this.iSO.setVisibility(0);
            if (this.iSN == null) {
                cqR();
            }
            if (this.iSN != null) {
                this.iSN.cancel();
                this.iSN.setDuration(300L).start();
            }
        }
    }

    public void bFO() {
        if (this.iSO != null && this.iSO.getY() < 0.0f && !bFP()) {
            this.iSO.setVisibility(0);
            if (this.iSM == null) {
                cqS();
            }
            if (this.iSM != null) {
                this.iSM.cancel();
                this.iSM.setDuration(300L).start();
            }
        }
    }

    public void aSm() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSn() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWI() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bFP() {
        return (this.iSM != null && this.iSM.isRunning()) || (this.iSN != null && this.iSN.isRunning());
    }

    public void hideFloatingView() {
        if (this.gsm) {
            if (this.dtP) {
                bs(true);
            } else if (this.iSO != null && !this.iSS && !this.iPh && cqT()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aSn();
            }
        }
    }

    public void showFloatingView() {
        if (this.gsm) {
            if (this.dtP) {
                bs(true);
            } else if (this.iSO != null && !cqT()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aSm();
            }
        }
    }

    public boolean cqT() {
        return this.iSO.getVisibility() == 0 && this.iSO.getY() >= 0.0f;
    }

    public void qB(boolean z) {
        this.iSS = z;
    }

    public void qC(boolean z) {
        this.iPh = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gsm && this.iSO != null && !this.iSS && !this.iPh && this.iSR) {
            if (i > this.dGM && cqT()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.dGM && !cqT()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.dGM = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.iSR = true;
        } else if (i == 0) {
            this.iSR = false;
        }
        if (this.gsm && !this.iSS && !this.iPh) {
            if (this.dtP) {
                bs(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.dGM) {
                    aSn();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.dGM) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aSm();
                } else if (firstVisiblePosition == this.dGM) {
                    if (firstVisiblePosition == 0 || !this.dGN || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aSm();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aSn();
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

    private void Ah() {
        if (this.aCb != null) {
            if (this.aCc && this.aCb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCb.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(boolean z) {
        if (this.aCb != null) {
            if (this.aCc && z && this.aCb.getVisibility() != 0) {
                this.aCb.setVisibility(0);
            } else if (!z && this.aCb.getVisibility() != 8) {
                this.aCb.setVisibility(8);
            }
        }
    }
}
