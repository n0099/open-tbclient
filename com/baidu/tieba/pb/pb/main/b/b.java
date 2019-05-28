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
    private View frn;
    private a hFk;
    private Animator hRJ;
    private Animator hRK;
    private ValueAnimator hRL;
    private ValueAnimator hRM;
    private AnimatorSet hRN;
    private AnimatorSet hRO;
    private View hRP;
    private View hRQ;
    private int hRR = UtilHelper.getLightStatusBarHeight();
    private boolean hRS = false;
    private boolean cny = false;
    private int cBQ = 0;
    private boolean hRT = false;
    private boolean hPk = false;
    private boolean hRU = false;
    private boolean cBR = false;
    private boolean fsY = true;
    private final Handler.Callback fta = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
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
    private final Handler mHandler = new Handler(this.fta);
    private boolean fsX = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void od(boolean z);
    }

    public void a(a aVar) {
        this.hFk = aVar;
    }

    public void kb(boolean z) {
        this.cBR = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hRP = view;
        this.frn = view2;
        this.Mx = view3;
        this.hRQ = this.Mx.findViewById(R.id.sticky_view);
        aIz();
        kd(false);
    }

    private void bVE() {
        this.hRJ = ObjectAnimator.ofFloat(this.hRP, "translationY", (-this.hRP.getMeasuredHeight()) + this.Mx.getMeasuredHeight());
        this.hRJ.setInterpolator(new LinearInterpolator());
        this.hRJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hRP != null) {
                    b.this.hRP.clearAnimation();
                    if (b.this.hRU) {
                        b.this.kd(false);
                    } else {
                        b.this.kd(true);
                    }
                    if (b.this.hFk != null) {
                        b.this.hFk.od(false);
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
        this.hRM = ValueAnimator.ofInt(0, this.hRR);
        this.hRM.setInterpolator(new LinearInterpolator());
        this.hRM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hRQ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hRQ.setLayoutParams(layoutParams);
                }
                b.this.hRQ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hRQ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hRR;
                    b.this.hRQ.setLayoutParams(layoutParams);
                }
                b.this.hRQ.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hRQ.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hRQ.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hRO = new AnimatorSet();
        this.hRO.play(this.hRJ).with(this.hRM);
    }

    private void bVF() {
        this.hRK = ObjectAnimator.ofFloat(this.hRP, "translationY", 0.0f);
        this.hRK.setInterpolator(new LinearInterpolator());
        this.hRK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hRP != null) {
                    b.this.hRP.clearAnimation();
                    b.this.hRP.setVisibility(0);
                    b.this.kd(false);
                    if (b.this.hFk != null) {
                        b.this.hFk.od(true);
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
        this.hRL = ValueAnimator.ofInt(this.hRR, 0);
        this.hRL.setInterpolator(new LinearInterpolator());
        this.hRL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hRQ.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hRQ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hRR;
                    b.this.hRQ.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hRQ.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hRQ.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hRQ.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hRQ.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hRQ.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hRN = new AnimatorSet();
        this.hRN.play(this.hRK).with(this.hRL);
    }

    public void blM() {
        F(false, false);
    }

    public void blN() {
        F(false, true);
    }

    public void F(boolean z, boolean z2) {
        if (this.hRP != null && this.hRP.getY() == 0.0f && !blP()) {
            if (z2) {
                this.hRP.setVisibility(8);
                if (this.hRU) {
                    kd(false);
                    return;
                } else {
                    kd(true);
                    return;
                }
            }
            this.hRP.setVisibility(0);
            if (this.hRO == null) {
                bVE();
            }
            if (this.hRO != null) {
                this.hRO.cancel();
                this.hRO.setDuration(300L).start();
            }
        }
    }

    public void blO() {
        if (this.hRP != null && this.hRP.getY() < 0.0f && !blP()) {
            this.hRP.setVisibility(0);
            if (this.hRN == null) {
                bVF();
            }
            if (this.hRN != null) {
                this.hRN.cancel();
                this.hRN.setDuration(300L).start();
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

    public boolean blP() {
        return (this.hRN != null && this.hRN.isRunning()) || (this.hRO != null && this.hRO.isRunning());
    }

    public void hideFloatingView() {
        if (this.fsY) {
            if (this.cny) {
                kd(true);
            } else if (this.hRP != null && !this.hRT && !this.hPk && bVG()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                avl();
            }
        }
    }

    public void showFloatingView() {
        if (this.fsY) {
            if (this.cny) {
                kd(true);
            } else if (this.hRP != null && !bVG()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                avk();
            }
        }
    }

    public boolean bVG() {
        return this.hRP.getVisibility() == 0 && this.hRP.getY() >= 0.0f;
    }

    public void oS(boolean z) {
        this.hRT = z;
    }

    public void oT(boolean z) {
        this.hPk = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fsY && this.hRP != null && !this.hRT && !this.hPk && this.hRS) {
            if (i > this.cBQ && bVG()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cBQ && !bVG()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cBQ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hRS = true;
        } else if (i == 0) {
            this.hRS = false;
        }
        if (this.fsY && !this.hRT && !this.hPk) {
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

    private void aIz() {
        if (this.frn != null) {
            if (this.fsX && this.frn.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.frn.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.frn.setLayoutParams(layoutParams);
                kd(true);
                return;
            }
            kd(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kd(boolean z) {
        if (this.frn != null) {
            if (this.fsX && z && this.frn.getVisibility() != 0) {
                this.frn.setVisibility(0);
            } else if (!z && this.frn.getVisibility() != 8) {
                this.frn.setVisibility(8);
            }
        }
    }
}
