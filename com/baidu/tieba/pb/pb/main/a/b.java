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
    private View auR;
    private View dDt;
    private a fIN;
    private Animator fUS;
    private Animator fUT;
    private ValueAnimator fUU;
    private ValueAnimator fUV;
    private AnimatorSet fUW;
    private AnimatorSet fUX;
    private View fUY;
    private View fUZ;
    private int fVa = UtilHelper.getLightStatusBarHeight();
    private boolean fVb = false;
    private boolean bnf = false;
    private int bBq = 0;
    private boolean fVc = false;
    private boolean fSB = false;
    private boolean fVd = false;
    private boolean bBr = false;
    private boolean dEy = true;
    private final Handler.Callback dEA = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.avw()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.avv();
                    return true;
                case 2:
                    b.this.avt();
                    return true;
                case 3:
                    b.this.avu();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dEA);
    private boolean dEx = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jS(boolean z);
    }

    public void a(a aVar) {
        this.fIN = aVar;
    }

    public void fP(boolean z) {
        this.bBr = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fUY = view;
        this.dDt = view2;
        this.auR = view3;
        this.fUZ = this.auR.findViewById(d.g.sticky_view);
        avx();
        fR(false);
    }

    private void beB() {
        this.fUS = ObjectAnimator.ofFloat(this.fUY, "translationY", (-this.fUY.getMeasuredHeight()) + this.auR.getMeasuredHeight());
        this.fUS.setInterpolator(new LinearInterpolator());
        this.fUS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fUY != null) {
                    b.this.fUY.clearAnimation();
                    if (b.this.fVd) {
                        b.this.fR(false);
                    } else {
                        b.this.fR(true);
                    }
                    if (b.this.fIN != null) {
                        b.this.fIN.jS(false);
                    }
                    b.this.auR.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fUV = ValueAnimator.ofInt(0, this.fVa);
        this.fUV.setInterpolator(new LinearInterpolator());
        this.fUV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fUZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fUZ.setLayoutParams(layoutParams);
                }
                b.this.fUZ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fUZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fVa;
                    b.this.fUZ.setLayoutParams(layoutParams);
                }
                b.this.fUZ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fUV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fUZ.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fUZ.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fUX = new AnimatorSet();
        this.fUX.play(this.fUS).with(this.fUV);
    }

    private void beC() {
        this.fUT = ObjectAnimator.ofFloat(this.fUY, "translationY", 0.0f);
        this.fUT.setInterpolator(new LinearInterpolator());
        this.fUT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fUY != null) {
                    b.this.fUY.clearAnimation();
                    b.this.fUY.setVisibility(0);
                    b.this.fR(false);
                    if (b.this.fIN != null) {
                        b.this.fIN.jS(true);
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
        this.fUU = ValueAnimator.ofInt(this.fVa, 0);
        this.fUU.setInterpolator(new LinearInterpolator());
        this.fUU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fUZ.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fUZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fVa;
                    b.this.fUZ.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fUZ.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fUZ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fUZ.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fUU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fUZ.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fUZ.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fUW = new AnimatorSet();
        this.fUW.play(this.fUT).with(this.fUU);
    }

    public void avt() {
        y(false, false);
    }

    public void avu() {
        y(false, true);
    }

    public void y(boolean z, boolean z2) {
        if (this.fUY != null && this.fUY.getY() == 0.0f && !avw()) {
            if (z2) {
                this.fUY.setVisibility(8);
                if (this.fVd) {
                    fR(false);
                    return;
                } else {
                    fR(true);
                    return;
                }
            }
            this.fUY.setVisibility(0);
            if (this.fUX == null) {
                beB();
            }
            if (this.fUX != null) {
                this.fUX.cancel();
                this.fUX.setDuration(300L).start();
            }
        }
    }

    public void avv() {
        if (this.fUY != null && this.fUY.getY() < 0.0f && !avw()) {
            this.fUY.setVisibility(0);
            if (this.fUW == null) {
                beC();
            }
            if (this.fUW != null) {
                this.fUW.cancel();
                this.fUW.setDuration(300L).start();
            }
        }
    }

    public void OD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OF() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avw() {
        return (this.fUW != null && this.fUW.isRunning()) || (this.fUX != null && this.fUX.isRunning());
    }

    public void hideFloatingView() {
        if (this.dEy) {
            if (this.bnf) {
                fR(true);
            } else if (this.fUY != null && !this.fVc && !this.fSB && beD()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                OE();
            }
        }
    }

    public void showFloatingView() {
        if (this.dEy) {
            if (this.bnf) {
                fR(true);
            } else if (this.fUY != null && !beD()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                OD();
            }
        }
    }

    public boolean beD() {
        return this.fUY.getVisibility() == 0 && this.fUY.getY() >= 0.0f;
    }

    public void kL(boolean z) {
        this.fVc = z;
    }

    public void kM(boolean z) {
        this.fSB = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dEy && this.fUY != null && !this.fVc && !this.fSB && this.fVb) {
            if (i > this.bBq && beD()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bBq && !beD()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bBq = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fVb = true;
        } else if (i == 0) {
            this.fVb = false;
        }
        if (this.dEy && !this.fVc && !this.fSB) {
            if (this.bnf) {
                fR(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bBq) {
                    OE();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bBq) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    OD();
                } else if (firstVisiblePosition == this.bBq) {
                    if (firstVisiblePosition == 0 || !this.bBr || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        OD();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    OE();
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

    private void avx() {
        if (this.dDt != null) {
            if (this.dEx && this.dDt.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dDt.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dDt.setLayoutParams(layoutParams);
                fR(true);
                return;
            }
            fR(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(boolean z) {
        if (this.dDt != null) {
            if (this.dEx && z && this.dDt.getVisibility() != 0) {
                this.dDt.setVisibility(0);
            } else if (!z && this.dDt.getVisibility() != 8) {
                this.dDt.setVisibility(8);
            }
        }
    }
}
