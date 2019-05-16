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
    private View Mx;
    private View frm;
    private a hFh;
    private Animator hRG;
    private Animator hRH;
    private ValueAnimator hRI;
    private ValueAnimator hRJ;
    private AnimatorSet hRK;
    private AnimatorSet hRL;
    private View hRM;
    private View hRN;
    private int hRO = UtilHelper.getLightStatusBarHeight();
    private boolean hRP = false;
    private boolean cny = false;
    private int cBQ = 0;
    private boolean hRQ = false;
    private boolean hPh = false;
    private boolean hRR = false;
    private boolean cBR = false;
    private boolean fsX = true;
    private final Handler.Callback fsZ = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.blM()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.blL();
                    return true;
                case 2:
                    b.this.blJ();
                    return true;
                case 3:
                    b.this.blK();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fsZ);
    private boolean fsW = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void od(boolean z);
    }

    public void a(a aVar) {
        this.hFh = aVar;
    }

    public void kb(boolean z) {
        this.cBR = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hRM = view;
        this.frm = view2;
        this.Mx = view3;
        this.hRN = this.Mx.findViewById(R.id.sticky_view);
        aIw();
        kd(false);
    }

    private void bVB() {
        this.hRG = ObjectAnimator.ofFloat(this.hRM, "translationY", (-this.hRM.getMeasuredHeight()) + this.Mx.getMeasuredHeight());
        this.hRG.setInterpolator(new LinearInterpolator());
        this.hRG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hRM != null) {
                    b.this.hRM.clearAnimation();
                    if (b.this.hRR) {
                        b.this.kd(false);
                    } else {
                        b.this.kd(true);
                    }
                    if (b.this.hFh != null) {
                        b.this.hFh.od(false);
                    }
                    b.this.Mx.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRJ = ValueAnimator.ofInt(0, this.hRO);
        this.hRJ.setInterpolator(new LinearInterpolator());
        this.hRJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hRN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hRN.setLayoutParams(layoutParams);
                }
                b.this.hRN.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hRN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hRO;
                    b.this.hRN.setLayoutParams(layoutParams);
                }
                b.this.hRN.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hRN.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hRN.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hRL = new AnimatorSet();
        this.hRL.play(this.hRG).with(this.hRJ);
    }

    private void bVC() {
        this.hRH = ObjectAnimator.ofFloat(this.hRM, "translationY", 0.0f);
        this.hRH.setInterpolator(new LinearInterpolator());
        this.hRH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hRM != null) {
                    b.this.hRM.clearAnimation();
                    b.this.hRM.setVisibility(0);
                    b.this.kd(false);
                    if (b.this.hFh != null) {
                        b.this.hFh.od(true);
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
        this.hRI = ValueAnimator.ofInt(this.hRO, 0);
        this.hRI.setInterpolator(new LinearInterpolator());
        this.hRI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hRN.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hRN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hRO;
                    b.this.hRN.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hRN.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hRN.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hRN.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hRN.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hRN.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hRK = new AnimatorSet();
        this.hRK.play(this.hRH).with(this.hRI);
    }

    public void blJ() {
        F(false, false);
    }

    public void blK() {
        F(false, true);
    }

    public void F(boolean z, boolean z2) {
        if (this.hRM != null && this.hRM.getY() == 0.0f && !blM()) {
            if (z2) {
                this.hRM.setVisibility(8);
                if (this.hRR) {
                    kd(false);
                    return;
                } else {
                    kd(true);
                    return;
                }
            }
            this.hRM.setVisibility(0);
            if (this.hRL == null) {
                bVB();
            }
            if (this.hRL != null) {
                this.hRL.cancel();
                this.hRL.setDuration(300L).start();
            }
        }
    }

    public void blL() {
        if (this.hRM != null && this.hRM.getY() < 0.0f && !blM()) {
            this.hRM.setVisibility(0);
            if (this.hRK == null) {
                bVC();
            }
            if (this.hRK != null) {
                this.hRK.cancel();
                this.hRK.setDuration(300L).start();
            }
        }
    }

    public void avk() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void avl() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void avm() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean blM() {
        return (this.hRK != null && this.hRK.isRunning()) || (this.hRL != null && this.hRL.isRunning());
    }

    public void hideFloatingView() {
        if (this.fsX) {
            if (this.cny) {
                kd(true);
            } else if (this.hRM != null && !this.hRQ && !this.hPh && bVD()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                avl();
            }
        }
    }

    public void showFloatingView() {
        if (this.fsX) {
            if (this.cny) {
                kd(true);
            } else if (this.hRM != null && !bVD()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                avk();
            }
        }
    }

    public boolean bVD() {
        return this.hRM.getVisibility() == 0 && this.hRM.getY() >= 0.0f;
    }

    public void oS(boolean z) {
        this.hRQ = z;
    }

    public void oT(boolean z) {
        this.hPh = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fsX && this.hRM != null && !this.hRQ && !this.hPh && this.hRP) {
            if (i > this.cBQ && bVD()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cBQ && !bVD()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cBQ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hRP = true;
        } else if (i == 0) {
            this.hRP = false;
        }
        if (this.fsX && !this.hRQ && !this.hPh) {
            if (this.cny) {
                kd(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.cBQ) {
                    avl();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.cBQ) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    avk();
                } else if (firstVisiblePosition == this.cBQ) {
                    if (firstVisiblePosition == 0 || !this.cBR || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        avk();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    avl();
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

    private void aIw() {
        if (this.frm != null) {
            if (this.fsW && this.frm.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.frm.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.frm.setLayoutParams(layoutParams);
                kd(true);
                return;
            }
            kd(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (this.frm != null) {
            if (this.fsW && z && this.frm.getVisibility() != 0) {
                this.frm.setVisibility(0);
            } else if (!z && this.frm.getVisibility() != 8) {
                this.frm.setVisibility(8);
            }
        }
    }
}
