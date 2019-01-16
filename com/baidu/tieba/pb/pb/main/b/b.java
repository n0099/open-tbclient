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
    private View Ow;
    private View dNG;
    private a fXG;
    private Animator gkm;
    private Animator gkn;
    private ValueAnimator gko;
    private ValueAnimator gkp;
    private AnimatorSet gkq;
    private AnimatorSet gkr;
    private View gks;
    private View gkt;
    private int gku = UtilHelper.getLightStatusBarHeight();
    private boolean gkv = false;
    private boolean aVV = false;
    private int bjz = 0;
    private boolean gkw = false;
    private boolean ghO = false;
    private boolean gkx = false;
    private boolean bjA = false;
    private boolean dPi = true;
    private final Handler.Callback dPk = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aDQ()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aDP();
                    return true;
                case 2:
                    b.this.aDN();
                    return true;
                case 3:
                    b.this.aDO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dPk);
    private boolean dPh = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes6.dex */
    public interface a {
        void kO(boolean z);
    }

    public void a(a aVar) {
        this.fXG = aVar;
    }

    public void gT(boolean z) {
        this.bjA = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.gks = view;
        this.dNG = view2;
        this.Ow = view3;
        this.gkt = this.Ow.findViewById(e.g.sticky_view);
        abn();
        gV(false);
    }

    private void bns() {
        this.gkm = ObjectAnimator.ofFloat(this.gks, "translationY", (-this.gks.getMeasuredHeight()) + this.Ow.getMeasuredHeight());
        this.gkm.setInterpolator(new LinearInterpolator());
        this.gkm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.gks != null) {
                    b.this.gks.clearAnimation();
                    if (b.this.gkx) {
                        b.this.gV(false);
                    } else {
                        b.this.gV(true);
                    }
                    if (b.this.fXG != null) {
                        b.this.fXG.kO(false);
                    }
                    b.this.Ow.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gkp = ValueAnimator.ofInt(0, this.gku);
        this.gkp.setInterpolator(new LinearInterpolator());
        this.gkp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.gkt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.gkt.setLayoutParams(layoutParams);
                }
                b.this.gkt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.gkt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.gku;
                    b.this.gkt.setLayoutParams(layoutParams);
                }
                b.this.gkt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gkp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.gkt.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.gkt.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.gkr = new AnimatorSet();
        this.gkr.play(this.gkm).with(this.gkp);
    }

    private void bnt() {
        this.gkn = ObjectAnimator.ofFloat(this.gks, "translationY", 0.0f);
        this.gkn.setInterpolator(new LinearInterpolator());
        this.gkn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.gks != null) {
                    b.this.gks.clearAnimation();
                    b.this.gks.setVisibility(0);
                    b.this.gV(false);
                    if (b.this.fXG != null) {
                        b.this.fXG.kO(true);
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
        this.gko = ValueAnimator.ofInt(this.gku, 0);
        this.gko.setInterpolator(new LinearInterpolator());
        this.gko.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.gkt.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.gkt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.gku;
                    b.this.gkt.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.gkt.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.gkt.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.gkt.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gko.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.gkt.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.gkt.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.gkq = new AnimatorSet();
        this.gkq.play(this.gkn).with(this.gko);
    }

    public void aDN() {
        C(false, false);
    }

    public void aDO() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.gks != null && this.gks.getY() == 0.0f && !aDQ()) {
            if (z2) {
                this.gks.setVisibility(8);
                if (this.gkx) {
                    gV(false);
                    return;
                } else {
                    gV(true);
                    return;
                }
            }
            this.gks.setVisibility(0);
            if (this.gkr == null) {
                bns();
            }
            if (this.gkr != null) {
                this.gkr.cancel();
                this.gkr.setDuration(300L).start();
            }
        }
    }

    public void aDP() {
        if (this.gks != null && this.gks.getY() < 0.0f && !aDQ()) {
            this.gks.setVisibility(0);
            if (this.gkq == null) {
                bnt();
            }
            if (this.gkq != null) {
                this.gkq.cancel();
                this.gkq.setDuration(300L).start();
            }
        }
    }

    public void Qx() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qy() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qz() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aDQ() {
        return (this.gkq != null && this.gkq.isRunning()) || (this.gkr != null && this.gkr.isRunning());
    }

    public void hideFloatingView() {
        if (this.dPi) {
            if (this.aVV) {
                gV(true);
            } else if (this.gks != null && !this.gkw && !this.ghO && bnu()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Qy();
            }
        }
    }

    public void showFloatingView() {
        if (this.dPi) {
            if (this.aVV) {
                gV(true);
            } else if (this.gks != null && !bnu()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Qx();
            }
        }
    }

    public boolean bnu() {
        return this.gks.getVisibility() == 0 && this.gks.getY() >= 0.0f;
    }

    public void lE(boolean z) {
        this.gkw = z;
    }

    public void lF(boolean z) {
        this.ghO = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dPi && this.gks != null && !this.gkw && !this.ghO && this.gkv) {
            if (i > this.bjz && bnu()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bjz && !bnu()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bjz = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.gkv = true;
        } else if (i == 0) {
            this.gkv = false;
        }
        if (this.dPi && !this.gkw && !this.ghO) {
            if (this.aVV) {
                gV(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bjz) {
                    Qy();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bjz) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Qx();
                } else if (firstVisiblePosition == this.bjz) {
                    if (firstVisiblePosition == 0 || !this.bjA || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Qx();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Qy();
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

    private void abn() {
        if (this.dNG != null) {
            if (this.dPh && this.dNG.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dNG.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dNG.setLayoutParams(layoutParams);
                gV(true);
                return;
            }
            gV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(boolean z) {
        if (this.dNG != null) {
            if (this.dPh && z && this.dNG.getVisibility() != 0) {
                this.dNG.setVisibility(0);
            } else if (!z && this.dNG.getVisibility() != 8) {
                this.dNG.setVisibility(8);
            }
        }
    }
}
