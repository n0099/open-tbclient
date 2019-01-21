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
    private View dNH;
    private a fXH;
    private Animator gkn;
    private Animator gko;
    private ValueAnimator gkp;
    private ValueAnimator gkq;
    private AnimatorSet gkr;
    private AnimatorSet gks;
    private View gkt;
    private View gku;
    private int gkv = UtilHelper.getLightStatusBarHeight();
    private boolean gkw = false;
    private boolean aVW = false;
    private int bjA = 0;
    private boolean gkx = false;
    private boolean ghP = false;
    private boolean gky = false;
    private boolean bjB = false;
    private boolean dPj = true;
    private final Handler.Callback dPl = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
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
    private final Handler mHandler = new Handler(this.dPl);
    private boolean dPi = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes6.dex */
    public interface a {
        void kO(boolean z);
    }

    public void a(a aVar) {
        this.fXH = aVar;
    }

    public void gT(boolean z) {
        this.bjB = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.gkt = view;
        this.dNH = view2;
        this.Ow = view3;
        this.gku = this.Ow.findViewById(e.g.sticky_view);
        abn();
        gV(false);
    }

    private void bns() {
        this.gkn = ObjectAnimator.ofFloat(this.gkt, "translationY", (-this.gkt.getMeasuredHeight()) + this.Ow.getMeasuredHeight());
        this.gkn.setInterpolator(new LinearInterpolator());
        this.gkn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.gkt != null) {
                    b.this.gkt.clearAnimation();
                    if (b.this.gky) {
                        b.this.gV(false);
                    } else {
                        b.this.gV(true);
                    }
                    if (b.this.fXH != null) {
                        b.this.fXH.kO(false);
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
        this.gkq = ValueAnimator.ofInt(0, this.gkv);
        this.gkq.setInterpolator(new LinearInterpolator());
        this.gkq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.gku.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.gku.setLayoutParams(layoutParams);
                }
                b.this.gku.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.gku.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.gkv;
                    b.this.gku.setLayoutParams(layoutParams);
                }
                b.this.gku.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gkq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.gku.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.gku.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.gks = new AnimatorSet();
        this.gks.play(this.gkn).with(this.gkq);
    }

    private void bnt() {
        this.gko = ObjectAnimator.ofFloat(this.gkt, "translationY", 0.0f);
        this.gko.setInterpolator(new LinearInterpolator());
        this.gko.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.gkt != null) {
                    b.this.gkt.clearAnimation();
                    b.this.gkt.setVisibility(0);
                    b.this.gV(false);
                    if (b.this.fXH != null) {
                        b.this.fXH.kO(true);
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
        this.gkp = ValueAnimator.ofInt(this.gkv, 0);
        this.gkp.setInterpolator(new LinearInterpolator());
        this.gkp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.gku.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.gku.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.gkv;
                    b.this.gku.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.gku.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.gku.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.gku.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gkp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.gku.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.gku.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.gkr = new AnimatorSet();
        this.gkr.play(this.gko).with(this.gkp);
    }

    public void aDN() {
        C(false, false);
    }

    public void aDO() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.gkt != null && this.gkt.getY() == 0.0f && !aDQ()) {
            if (z2) {
                this.gkt.setVisibility(8);
                if (this.gky) {
                    gV(false);
                    return;
                } else {
                    gV(true);
                    return;
                }
            }
            this.gkt.setVisibility(0);
            if (this.gks == null) {
                bns();
            }
            if (this.gks != null) {
                this.gks.cancel();
                this.gks.setDuration(300L).start();
            }
        }
    }

    public void aDP() {
        if (this.gkt != null && this.gkt.getY() < 0.0f && !aDQ()) {
            this.gkt.setVisibility(0);
            if (this.gkr == null) {
                bnt();
            }
            if (this.gkr != null) {
                this.gkr.cancel();
                this.gkr.setDuration(300L).start();
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
        return (this.gkr != null && this.gkr.isRunning()) || (this.gks != null && this.gks.isRunning());
    }

    public void hideFloatingView() {
        if (this.dPj) {
            if (this.aVW) {
                gV(true);
            } else if (this.gkt != null && !this.gkx && !this.ghP && bnu()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Qy();
            }
        }
    }

    public void showFloatingView() {
        if (this.dPj) {
            if (this.aVW) {
                gV(true);
            } else if (this.gkt != null && !bnu()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Qx();
            }
        }
    }

    public boolean bnu() {
        return this.gkt.getVisibility() == 0 && this.gkt.getY() >= 0.0f;
    }

    public void lE(boolean z) {
        this.gkx = z;
    }

    public void lF(boolean z) {
        this.ghP = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dPj && this.gkt != null && !this.gkx && !this.ghP && this.gkw) {
            if (i > this.bjA && bnu()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bjA && !bnu()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bjA = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.gkw = true;
        } else if (i == 0) {
            this.gkw = false;
        }
        if (this.dPj && !this.gkx && !this.ghP) {
            if (this.aVW) {
                gV(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bjA) {
                    Qy();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bjA) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Qx();
                } else if (firstVisiblePosition == this.bjA) {
                    if (firstVisiblePosition == 0 || !this.bjB || a(absListView)) {
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
        if (this.dNH != null) {
            if (this.dPi && this.dNH.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dNH.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dNH.setLayoutParams(layoutParams);
                gV(true);
                return;
            }
            gV(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gV(boolean z) {
        if (this.dNH != null) {
            if (this.dPi && z && this.dNH.getVisibility() != 0) {
                this.dNH.setVisibility(0);
            } else if (!z && this.dNH.getVisibility() != 8) {
                this.dNH.setVisibility(8);
            }
        }
    }
}
