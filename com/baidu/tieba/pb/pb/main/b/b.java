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
/* loaded from: classes4.dex */
public class b {
    private View apj;
    private a hMb;
    private Animator hYG;
    private Animator hYH;
    private ValueAnimator hYI;
    private ValueAnimator hYJ;
    private AnimatorSet hYK;
    private AnimatorSet hYL;
    private View hYM;
    private View hYN;
    private View mExpandView;
    private int hYO = UtilHelper.getLightStatusBarHeight();
    private boolean hYP = false;
    private boolean cBK = false;
    private int cOv = 0;
    private boolean hYQ = false;
    private boolean hWj = false;
    private boolean hYR = false;
    private boolean cOw = false;
    private boolean fyD = true;
    private final Handler.Callback fyG = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.blN()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.blM();
                    return true;
                case 2:
                    b.this.blK();
                    return true;
                case 3:
                    b.this.blL();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fyG);
    private boolean apk = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void of(boolean z);
    }

    public void a(a aVar) {
        this.hMb = aVar;
    }

    public void kc(boolean z) {
        this.cOw = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hYM = view;
        this.apj = view2;
        this.mExpandView = view3;
        this.hYN = this.mExpandView.findViewById(R.id.sticky_view);
        vA();
        aP(false);
    }

    private void bWx() {
        this.hYG = ObjectAnimator.ofFloat(this.hYM, "translationY", (-this.hYM.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.hYG.setInterpolator(new LinearInterpolator());
        this.hYG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hYM != null) {
                    b.this.hYM.clearAnimation();
                    if (b.this.hYR) {
                        b.this.aP(false);
                    } else {
                        b.this.aP(true);
                    }
                    if (b.this.hMb != null) {
                        b.this.hMb.of(false);
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
        this.hYJ = ValueAnimator.ofInt(0, this.hYO);
        this.hYJ.setInterpolator(new LinearInterpolator());
        this.hYJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hYN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hYN.setLayoutParams(layoutParams);
                }
                b.this.hYN.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hYN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hYO;
                    b.this.hYN.setLayoutParams(layoutParams);
                }
                b.this.hYN.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hYJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hYN.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hYN.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hYL = new AnimatorSet();
        this.hYL.play(this.hYG).with(this.hYJ);
    }

    private void bWy() {
        this.hYH = ObjectAnimator.ofFloat(this.hYM, "translationY", 0.0f);
        this.hYH.setInterpolator(new LinearInterpolator());
        this.hYH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hYM != null) {
                    b.this.hYM.clearAnimation();
                    b.this.hYM.setVisibility(0);
                    b.this.aP(false);
                    if (b.this.hMb != null) {
                        b.this.hMb.of(true);
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
        this.hYI = ValueAnimator.ofInt(this.hYO, 0);
        this.hYI.setInterpolator(new LinearInterpolator());
        this.hYI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hYN.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hYN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hYO;
                    b.this.hYN.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hYN.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hYN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hYN.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hYI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hYN.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hYN.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hYK = new AnimatorSet();
        this.hYK.play(this.hYH).with(this.hYI);
    }

    public void blK() {
        L(false, false);
    }

    public void blL() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.hYM != null && this.hYM.getY() == 0.0f && !blN()) {
            if (z2) {
                this.hYM.setVisibility(8);
                if (this.hYR) {
                    aP(false);
                    return;
                } else {
                    aP(true);
                    return;
                }
            }
            this.hYM.setVisibility(0);
            if (this.hYL == null) {
                bWx();
            }
            if (this.hYL != null) {
                this.hYL.cancel();
                this.hYL.setDuration(300L).start();
            }
        }
    }

    public void blM() {
        if (this.hYM != null && this.hYM.getY() < 0.0f && !blN()) {
            this.hYM.setVisibility(0);
            if (this.hYK == null) {
                bWy();
            }
            if (this.hYK != null) {
                this.hYK.cancel();
                this.hYK.setDuration(300L).start();
            }
        }
    }

    public void axI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void axJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void axK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean blN() {
        return (this.hYK != null && this.hYK.isRunning()) || (this.hYL != null && this.hYL.isRunning());
    }

    public void hideFloatingView() {
        if (this.fyD) {
            if (this.cBK) {
                aP(true);
            } else if (this.hYM != null && !this.hYQ && !this.hWj && bWz()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                axJ();
            }
        }
    }

    public void showFloatingView() {
        if (this.fyD) {
            if (this.cBK) {
                aP(true);
            } else if (this.hYM != null && !bWz()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                axI();
            }
        }
    }

    public boolean bWz() {
        return this.hYM.getVisibility() == 0 && this.hYM.getY() >= 0.0f;
    }

    public void oU(boolean z) {
        this.hYQ = z;
    }

    public void oV(boolean z) {
        this.hWj = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fyD && this.hYM != null && !this.hYQ && !this.hWj && this.hYP) {
            if (i > this.cOv && bWz()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cOv && !bWz()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cOv = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hYP = true;
        } else if (i == 0) {
            this.hYP = false;
        }
        if (this.fyD && !this.hYQ && !this.hWj) {
            if (this.cBK) {
                aP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.cOv) {
                    axJ();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.cOv) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    axI();
                } else if (firstVisiblePosition == this.cOv) {
                    if (firstVisiblePosition == 0 || !this.cOw || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        axI();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    axJ();
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

    private void vA() {
        if (this.apj != null) {
            if (this.apk && this.apj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apj.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        if (this.apj != null) {
            if (this.apk && z && this.apj.getVisibility() != 0) {
                this.apj.setVisibility(0);
            } else if (!z && this.apj.getVisibility() != 8) {
                this.apj.setVisibility(8);
            }
        }
    }
}
