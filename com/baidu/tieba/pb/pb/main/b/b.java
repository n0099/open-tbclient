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
    private a lOc;
    private Animator lZC;
    private Animator lZD;
    private ValueAnimator lZE;
    private ValueAnimator lZF;
    private AnimatorSet lZG;
    private AnimatorSet lZH;
    private View lZI;
    private View lZJ;
    private View mExpandView;
    private int lZK = UtilHelper.getLightStatusBarHeight();
    private boolean lZL = false;
    private boolean fAV = false;
    private int fPD = 0;
    private boolean lZM = false;
    private boolean lVR = false;
    private boolean lZN = false;
    private boolean fPE = false;
    private boolean jkb = true;
    private final Handler.Callback jke = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cHs()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cHq();
                    return true;
                case 2:
                    b.this.cHo();
                    return true;
                case 3:
                    b.this.cHp();
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
        this.lOc = aVar;
    }

    public void qL(boolean z) {
        this.fPE = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lZI = view;
        this.bMl = view2;
        this.mExpandView = view3;
        this.lZJ = this.mExpandView.findViewById(R.id.sticky_view);
        Ws();
        di(false);
    }

    private void dtD() {
        this.lZC = ObjectAnimator.ofFloat(this.lZI, "translationY", (-this.lZI.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lZC.setInterpolator(new LinearInterpolator());
        this.lZC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lZI != null) {
                    b.this.lZI.clearAnimation();
                    if (b.this.lZN) {
                        b.this.di(false);
                    } else {
                        b.this.di(true);
                    }
                    if (b.this.lOc != null) {
                        b.this.lOc.uV(false);
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
        this.lZF = ValueAnimator.ofInt(0, this.lZK);
        this.lZF.setInterpolator(new LinearInterpolator());
        this.lZF.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lZJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lZJ.setLayoutParams(layoutParams);
                }
                b.this.lZJ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lZJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lZK;
                    b.this.lZJ.setLayoutParams(layoutParams);
                }
                b.this.lZJ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lZF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lZJ.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lZJ.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lZH = new AnimatorSet();
        this.lZH.play(this.lZC).with(this.lZF);
    }

    private void dtE() {
        this.lZD = ObjectAnimator.ofFloat(this.lZI, "translationY", 0.0f);
        this.lZD.setInterpolator(new LinearInterpolator());
        this.lZD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lZI != null) {
                    b.this.lZI.clearAnimation();
                    b.this.lZI.setVisibility(0);
                    b.this.di(false);
                    if (b.this.lOc != null) {
                        b.this.lOc.uV(true);
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
        this.lZE = ValueAnimator.ofInt(this.lZK, 0);
        this.lZE.setInterpolator(new LinearInterpolator());
        this.lZE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lZJ.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lZJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lZK;
                    b.this.lZJ.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lZJ.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lZJ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lZJ.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lZE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lZJ.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lZJ.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lZG = new AnimatorSet();
        this.lZG.play(this.lZD).with(this.lZE);
    }

    public void cHo() {
        ab(false, false);
    }

    public void cHp() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.lZI != null && this.lZI.getY() == 0.0f && !cHs()) {
            if (z2) {
                this.lZI.setVisibility(8);
                if (this.lZN) {
                    di(false);
                    return;
                } else {
                    di(true);
                    return;
                }
            }
            this.lZI.setVisibility(0);
            if (this.lZH == null) {
                dtD();
            }
            if (this.lZH != null) {
                this.lZH.cancel();
                this.lZH.setDuration(300L).start();
            }
        }
    }

    public void cHq() {
        if (this.lZI != null && this.lZI.getY() < 0.0f && !cHs()) {
            this.lZI.setVisibility(0);
            if (this.lZG == null) {
                dtE();
            }
            if (this.lZG != null) {
                this.lZG.cancel();
                this.lZG.setDuration(300L).start();
            }
        }
    }

    public void bJb() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bJc() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cHr() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cHs() {
        return (this.lZG != null && this.lZG.isRunning()) || (this.lZH != null && this.lZH.isRunning());
    }

    public void hideFloatingView() {
        if (this.jkb) {
            if (this.fAV) {
                di(true);
            } else if (this.lZI != null && !this.lZM && !this.lVR && dtF()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bJc();
            }
        }
    }

    public void showFloatingView() {
        if (this.jkb) {
            if (this.fAV) {
                di(true);
            } else if (this.lZI != null && !dtF()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bJb();
            }
        }
    }

    public boolean dtF() {
        return this.lZI.getVisibility() == 0 && this.lZI.getY() >= 0.0f;
    }

    public void vK(boolean z) {
        this.lZM = z;
    }

    public void vL(boolean z) {
        this.lVR = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jkb && this.lZI != null && !this.lZM && !this.lVR && this.lZL) {
            if (i > this.fPD && dtF()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fPD && !dtF()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fPD = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lZL = true;
        } else if (i == 0) {
            this.lZL = false;
        }
        if (this.jkb && !this.lZM && !this.lVR) {
            if (this.fAV) {
                di(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fPD) {
                    bJc();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fPD) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bJb();
                } else if (firstVisiblePosition == this.fPD) {
                    if (firstVisiblePosition == 0 || !this.fPE || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bJb();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bJc();
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

    private void Ws() {
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
