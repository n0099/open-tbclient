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
    private View apC;
    private a hMS;
    private ValueAnimator hZA;
    private AnimatorSet hZB;
    private AnimatorSet hZC;
    private View hZD;
    private View hZE;
    private Animator hZx;
    private Animator hZy;
    private ValueAnimator hZz;
    private View mExpandView;
    private int hZF = UtilHelper.getLightStatusBarHeight();
    private boolean hZG = false;
    private boolean cCB = false;
    private int cPm = 0;
    private boolean hZH = false;
    private boolean hXa = false;
    private boolean hZI = false;
    private boolean cPn = false;
    private boolean fzu = true;
    private final Handler.Callback fzx = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.blP()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.blO();
                    return true;
                case 2:
                    b.this.blM();
                    return true;
                case 3:
                    b.this.blN();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fzx);
    private boolean apD = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void of(boolean z);
    }

    public void a(a aVar) {
        this.hMS = aVar;
    }

    public void kc(boolean z) {
        this.cPn = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hZD = view;
        this.apC = view2;
        this.mExpandView = view3;
        this.hZE = this.mExpandView.findViewById(R.id.sticky_view);
        vz();
        aP(false);
    }

    private void bWz() {
        this.hZx = ObjectAnimator.ofFloat(this.hZD, "translationY", (-this.hZD.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.hZx.setInterpolator(new LinearInterpolator());
        this.hZx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hZD != null) {
                    b.this.hZD.clearAnimation();
                    if (b.this.hZI) {
                        b.this.aP(false);
                    } else {
                        b.this.aP(true);
                    }
                    if (b.this.hMS != null) {
                        b.this.hMS.of(false);
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
        this.hZA = ValueAnimator.ofInt(0, this.hZF);
        this.hZA.setInterpolator(new LinearInterpolator());
        this.hZA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hZE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hZE.setLayoutParams(layoutParams);
                }
                b.this.hZE.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hZE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hZF;
                    b.this.hZE.setLayoutParams(layoutParams);
                }
                b.this.hZE.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hZA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hZE.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hZE.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hZC = new AnimatorSet();
        this.hZC.play(this.hZx).with(this.hZA);
    }

    private void bWA() {
        this.hZy = ObjectAnimator.ofFloat(this.hZD, "translationY", 0.0f);
        this.hZy.setInterpolator(new LinearInterpolator());
        this.hZy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hZD != null) {
                    b.this.hZD.clearAnimation();
                    b.this.hZD.setVisibility(0);
                    b.this.aP(false);
                    if (b.this.hMS != null) {
                        b.this.hMS.of(true);
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
        this.hZz = ValueAnimator.ofInt(this.hZF, 0);
        this.hZz.setInterpolator(new LinearInterpolator());
        this.hZz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hZE.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hZE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hZF;
                    b.this.hZE.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hZE.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hZE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hZE.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hZz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hZE.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hZE.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hZB = new AnimatorSet();
        this.hZB.play(this.hZy).with(this.hZz);
    }

    public void blM() {
        L(false, false);
    }

    public void blN() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.hZD != null && this.hZD.getY() == 0.0f && !blP()) {
            if (z2) {
                this.hZD.setVisibility(8);
                if (this.hZI) {
                    aP(false);
                    return;
                } else {
                    aP(true);
                    return;
                }
            }
            this.hZD.setVisibility(0);
            if (this.hZC == null) {
                bWz();
            }
            if (this.hZC != null) {
                this.hZC.cancel();
                this.hZC.setDuration(300L).start();
            }
        }
    }

    public void blO() {
        if (this.hZD != null && this.hZD.getY() < 0.0f && !blP()) {
            this.hZD.setVisibility(0);
            if (this.hZB == null) {
                bWA();
            }
            if (this.hZB != null) {
                this.hZB.cancel();
                this.hZB.setDuration(300L).start();
            }
        }
    }

    public void axK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void axL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void axM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean blP() {
        return (this.hZB != null && this.hZB.isRunning()) || (this.hZC != null && this.hZC.isRunning());
    }

    public void hideFloatingView() {
        if (this.fzu) {
            if (this.cCB) {
                aP(true);
            } else if (this.hZD != null && !this.hZH && !this.hXa && bWB()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                axL();
            }
        }
    }

    public void showFloatingView() {
        if (this.fzu) {
            if (this.cCB) {
                aP(true);
            } else if (this.hZD != null && !bWB()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                axK();
            }
        }
    }

    public boolean bWB() {
        return this.hZD.getVisibility() == 0 && this.hZD.getY() >= 0.0f;
    }

    public void oU(boolean z) {
        this.hZH = z;
    }

    public void oV(boolean z) {
        this.hXa = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fzu && this.hZD != null && !this.hZH && !this.hXa && this.hZG) {
            if (i > this.cPm && bWB()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cPm && !bWB()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cPm = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hZG = true;
        } else if (i == 0) {
            this.hZG = false;
        }
        if (this.fzu && !this.hZH && !this.hXa) {
            if (this.cCB) {
                aP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.cPm) {
                    axL();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.cPm) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    axK();
                } else if (firstVisiblePosition == this.cPm) {
                    if (firstVisiblePosition == 0 || !this.cPn || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        axK();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    axL();
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

    private void vz() {
        if (this.apC != null) {
            if (this.apD && this.apC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.apC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.apC.setLayoutParams(layoutParams);
                aP(true);
                return;
            }
            aP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(boolean z) {
        if (this.apC != null) {
            if (this.apD && z && this.apC.getVisibility() != 0) {
                this.apC.setVisibility(0);
            } else if (!z && this.apC.getVisibility() != 8) {
                this.apC.setVisibility(8);
            }
        }
    }
}
