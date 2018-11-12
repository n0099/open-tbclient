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
    private View dDK;
    private a fNb;
    private Animator fZA;
    private ValueAnimator fZB;
    private ValueAnimator fZC;
    private AnimatorSet fZD;
    private AnimatorSet fZE;
    private View fZF;
    private View fZG;
    private Animator fZz;
    private int fZH = UtilHelper.getLightStatusBarHeight();
    private boolean fZI = false;
    private boolean aRN = false;
    private int bfj = 0;
    private boolean fZJ = false;
    private boolean fXc = false;
    private boolean fZK = false;
    private boolean bfk = false;
    private boolean dFm = true;
    private final Handler.Callback dFo = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aAU()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aAT();
                    return true;
                case 2:
                    b.this.aAR();
                    return true;
                case 3:
                    b.this.aAS();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dFo);
    private boolean dFl = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes6.dex */
    public interface a {
        void kI(boolean z);
    }

    public void a(a aVar) {
        this.fNb = aVar;
    }

    public void gM(boolean z) {
        this.bfk = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fZF = view;
        this.dDK = view2;
        this.On = view3;
        this.fZG = this.On.findViewById(e.g.sticky_view);
        ZI();
        gO(false);
    }

    private void bkg() {
        this.fZz = ObjectAnimator.ofFloat(this.fZF, "translationY", (-this.fZF.getMeasuredHeight()) + this.On.getMeasuredHeight());
        this.fZz.setInterpolator(new LinearInterpolator());
        this.fZz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fZF != null) {
                    b.this.fZF.clearAnimation();
                    if (b.this.fZK) {
                        b.this.gO(false);
                    } else {
                        b.this.gO(true);
                    }
                    if (b.this.fNb != null) {
                        b.this.fNb.kI(false);
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
        this.fZC = ValueAnimator.ofInt(0, this.fZH);
        this.fZC.setInterpolator(new LinearInterpolator());
        this.fZC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fZG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fZG.setLayoutParams(layoutParams);
                }
                b.this.fZG.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fZG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fZH;
                    b.this.fZG.setLayoutParams(layoutParams);
                }
                b.this.fZG.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fZC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fZG.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fZG.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fZE = new AnimatorSet();
        this.fZE.play(this.fZz).with(this.fZC);
    }

    private void bkh() {
        this.fZA = ObjectAnimator.ofFloat(this.fZF, "translationY", 0.0f);
        this.fZA.setInterpolator(new LinearInterpolator());
        this.fZA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fZF != null) {
                    b.this.fZF.clearAnimation();
                    b.this.fZF.setVisibility(0);
                    b.this.gO(false);
                    if (b.this.fNb != null) {
                        b.this.fNb.kI(true);
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
        this.fZB = ValueAnimator.ofInt(this.fZH, 0);
        this.fZB.setInterpolator(new LinearInterpolator());
        this.fZB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fZG.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fZG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fZH;
                    b.this.fZG.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fZG.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fZG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fZG.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fZB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fZG.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fZG.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fZD = new AnimatorSet();
        this.fZD.play(this.fZA).with(this.fZB);
    }

    public void aAR() {
        C(false, false);
    }

    public void aAS() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.fZF != null && this.fZF.getY() == 0.0f && !aAU()) {
            if (z2) {
                this.fZF.setVisibility(8);
                if (this.fZK) {
                    gO(false);
                    return;
                } else {
                    gO(true);
                    return;
                }
            }
            this.fZF.setVisibility(0);
            if (this.fZE == null) {
                bkg();
            }
            if (this.fZE != null) {
                this.fZE.cancel();
                this.fZE.setDuration(300L).start();
            }
        }
    }

    public void aAT() {
        if (this.fZF != null && this.fZF.getY() < 0.0f && !aAU()) {
            this.fZF.setVisibility(0);
            if (this.fZD == null) {
                bkh();
            }
            if (this.fZD != null) {
                this.fZD.cancel();
                this.fZD.setDuration(300L).start();
            }
        }
    }

    public void OU() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OV() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OW() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aAU() {
        return (this.fZD != null && this.fZD.isRunning()) || (this.fZE != null && this.fZE.isRunning());
    }

    public void hideFloatingView() {
        if (this.dFm) {
            if (this.aRN) {
                gO(true);
            } else if (this.fZF != null && !this.fZJ && !this.fXc && bki()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                OV();
            }
        }
    }

    public void showFloatingView() {
        if (this.dFm) {
            if (this.aRN) {
                gO(true);
            } else if (this.fZF != null && !bki()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                OU();
            }
        }
    }

    public boolean bki() {
        return this.fZF.getVisibility() == 0 && this.fZF.getY() >= 0.0f;
    }

    public void ly(boolean z) {
        this.fZJ = z;
    }

    public void lz(boolean z) {
        this.fXc = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dFm && this.fZF != null && !this.fZJ && !this.fXc && this.fZI) {
            if (i > this.bfj && bki()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bfj && !bki()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bfj = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fZI = true;
        } else if (i == 0) {
            this.fZI = false;
        }
        if (this.dFm && !this.fZJ && !this.fXc) {
            if (this.aRN) {
                gO(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bfj) {
                    OV();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bfj) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    OU();
                } else if (firstVisiblePosition == this.bfj) {
                    if (firstVisiblePosition == 0 || !this.bfk || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        OU();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    OV();
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

    private void ZI() {
        if (this.dDK != null) {
            if (this.dFl && this.dDK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dDK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dDK.setLayoutParams(layoutParams);
                gO(true);
                return;
            }
            gO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gO(boolean z) {
        if (this.dDK != null) {
            if (this.dFl && z && this.dDK.getVisibility() != 0) {
                this.dDK.setVisibility(0);
            } else if (!z && this.dDK.getVisibility() != 8) {
                this.dDK.setVisibility(8);
            }
        }
    }
}
