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
    private View Mw;
    private View frn;
    private a hFl;
    private Animator hRK;
    private Animator hRL;
    private ValueAnimator hRM;
    private ValueAnimator hRN;
    private AnimatorSet hRO;
    private AnimatorSet hRP;
    private View hRQ;
    private View hRR;
    private int hRS = UtilHelper.getLightStatusBarHeight();
    private boolean hRT = false;
    private boolean cnz = false;
    private int cBR = 0;
    private boolean hRU = false;
    private boolean hPl = false;
    private boolean hRV = false;
    private boolean cBS = false;
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
        void oe(boolean z);
    }

    public void a(a aVar) {
        this.hFl = aVar;
    }

    public void kb(boolean z) {
        this.cBS = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hRQ = view;
        this.frn = view2;
        this.Mw = view3;
        this.hRR = this.Mw.findViewById(R.id.sticky_view);
        aIz();
        kd(false);
    }

    private void bVF() {
        this.hRK = ObjectAnimator.ofFloat(this.hRQ, "translationY", (-this.hRQ.getMeasuredHeight()) + this.Mw.getMeasuredHeight());
        this.hRK.setInterpolator(new LinearInterpolator());
        this.hRK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hRQ != null) {
                    b.this.hRQ.clearAnimation();
                    if (b.this.hRV) {
                        b.this.kd(false);
                    } else {
                        b.this.kd(true);
                    }
                    if (b.this.hFl != null) {
                        b.this.hFl.oe(false);
                    }
                    b.this.Mw.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRN = ValueAnimator.ofInt(0, this.hRS);
        this.hRN.setInterpolator(new LinearInterpolator());
        this.hRN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hRR.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hRR.setLayoutParams(layoutParams);
                }
                b.this.hRR.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hRR.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hRS;
                    b.this.hRR.setLayoutParams(layoutParams);
                }
                b.this.hRR.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hRR.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hRR.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hRP = new AnimatorSet();
        this.hRP.play(this.hRK).with(this.hRN);
    }

    private void bVG() {
        this.hRL = ObjectAnimator.ofFloat(this.hRQ, "translationY", 0.0f);
        this.hRL.setInterpolator(new LinearInterpolator());
        this.hRL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hRQ != null) {
                    b.this.hRQ.clearAnimation();
                    b.this.hRQ.setVisibility(0);
                    b.this.kd(false);
                    if (b.this.hFl != null) {
                        b.this.hFl.oe(true);
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
        this.hRM = ValueAnimator.ofInt(this.hRS, 0);
        this.hRM.setInterpolator(new LinearInterpolator());
        this.hRM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hRR.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hRR.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hRS;
                    b.this.hRR.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hRR.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hRR.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hRR.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hRM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hRR.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hRR.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hRO = new AnimatorSet();
        this.hRO.play(this.hRL).with(this.hRM);
    }

    public void blM() {
        F(false, false);
    }

    public void blN() {
        F(false, true);
    }

    public void F(boolean z, boolean z2) {
        if (this.hRQ != null && this.hRQ.getY() == 0.0f && !blP()) {
            if (z2) {
                this.hRQ.setVisibility(8);
                if (this.hRV) {
                    kd(false);
                    return;
                } else {
                    kd(true);
                    return;
                }
            }
            this.hRQ.setVisibility(0);
            if (this.hRP == null) {
                bVF();
            }
            if (this.hRP != null) {
                this.hRP.cancel();
                this.hRP.setDuration(300L).start();
            }
        }
    }

    public void blO() {
        if (this.hRQ != null && this.hRQ.getY() < 0.0f && !blP()) {
            this.hRQ.setVisibility(0);
            if (this.hRO == null) {
                bVG();
            }
            if (this.hRO != null) {
                this.hRO.cancel();
                this.hRO.setDuration(300L).start();
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
        return (this.hRO != null && this.hRO.isRunning()) || (this.hRP != null && this.hRP.isRunning());
    }

    public void hideFloatingView() {
        if (this.fsY) {
            if (this.cnz) {
                kd(true);
            } else if (this.hRQ != null && !this.hRU && !this.hPl && bVH()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                avl();
            }
        }
    }

    public void showFloatingView() {
        if (this.fsY) {
            if (this.cnz) {
                kd(true);
            } else if (this.hRQ != null && !bVH()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                avk();
            }
        }
    }

    public boolean bVH() {
        return this.hRQ.getVisibility() == 0 && this.hRQ.getY() >= 0.0f;
    }

    public void oT(boolean z) {
        this.hRU = z;
    }

    public void oU(boolean z) {
        this.hPl = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fsY && this.hRQ != null && !this.hRU && !this.hPl && this.hRT) {
            if (i > this.cBR && bVH()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.cBR && !bVH()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.cBR = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hRT = true;
        } else if (i == 0) {
            this.hRT = false;
        }
        if (this.fsY && !this.hRU && !this.hPl) {
            if (this.cnz) {
                kd(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.cBR) {
                    avl();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.cBR) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    avk();
                } else if (firstVisiblePosition == this.cBR) {
                    if (firstVisiblePosition == 0 || !this.cBS || a(absListView)) {
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
