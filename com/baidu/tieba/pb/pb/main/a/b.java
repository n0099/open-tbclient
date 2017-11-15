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
/* loaded from: classes.dex */
public class b {
    private View GN;
    private View czH;
    private a eLB;
    private Animator eYg;
    private Animator eYh;
    private ValueAnimator eYi;
    private ValueAnimator eYj;
    private AnimatorSet eYk;
    private AnimatorSet eYl;
    private View eYm;
    private View eYn;
    private int eYo = UtilHelper.getLightStatusBarHeight();
    private boolean eYp = false;
    private boolean axZ = false;
    private int aMF = 0;
    private boolean eYq = false;
    private boolean eTY = false;
    private boolean eYr = false;
    private boolean aMG = false;
    private boolean cBf = true;
    private final Handler.Callback cBh = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.akC()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.akB();
                    return true;
                case 2:
                    b.this.akz();
                    return true;
                case 3:
                    b.this.akA();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cBh);
    private boolean cBe = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void iS(boolean z);
    }

    public void a(a aVar) {
        this.eLB = aVar;
    }

    public void eK(boolean z) {
        this.aMG = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.eYm = view;
        this.czH = view2;
        this.GN = view3;
        this.eYn = this.GN.findViewById(d.g.sticky_view);
        akD();
        eM(false);
    }

    private void aVW() {
        this.eYg = ObjectAnimator.ofFloat(this.eYm, "translationY", (-this.eYm.getMeasuredHeight()) + this.GN.getMeasuredHeight());
        this.eYg.setInterpolator(new LinearInterpolator());
        this.eYg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eYm != null) {
                    b.this.eYm.clearAnimation();
                    if (b.this.eYr) {
                        b.this.eM(false);
                    } else {
                        b.this.eM(true);
                    }
                    if (b.this.eLB != null) {
                        b.this.eLB.iS(false);
                    }
                    b.this.GN.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eYj = ValueAnimator.ofInt(0, this.eYo);
        this.eYj.setInterpolator(new LinearInterpolator());
        this.eYj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eYn.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eYn.setLayoutParams(layoutParams);
                }
                b.this.eYn.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eYn.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eYo;
                    b.this.eYn.setLayoutParams(layoutParams);
                }
                b.this.eYn.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eYj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eYn.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eYn.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eYl = new AnimatorSet();
        this.eYl.play(this.eYg).with(this.eYj);
    }

    private void aVX() {
        this.eYh = ObjectAnimator.ofFloat(this.eYm, "translationY", 0.0f);
        this.eYh.setInterpolator(new LinearInterpolator());
        this.eYh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eYm != null) {
                    b.this.eYm.clearAnimation();
                    b.this.eYm.setVisibility(0);
                    b.this.eM(false);
                    if (b.this.eLB != null) {
                        b.this.eLB.iS(true);
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
        this.eYi = ValueAnimator.ofInt(this.eYo, 0);
        this.eYi.setInterpolator(new LinearInterpolator());
        this.eYi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.eYn.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.eYn.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eYo;
                    b.this.eYn.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.eYn.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.eYn.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eYn.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eYi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eYn.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eYn.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eYk = new AnimatorSet();
        this.eYk.play(this.eYh).with(this.eYi);
    }

    public void akz() {
        w(false, false);
    }

    public void akA() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.eYm != null && this.eYm.getY() == 0.0f && !akC()) {
            if (z2) {
                this.eYm.setVisibility(8);
                if (this.eYr) {
                    eM(false);
                    return;
                } else {
                    eM(true);
                    return;
                }
            }
            this.eYm.setVisibility(0);
            if (this.eYl == null) {
                aVW();
            }
            if (this.eYl != null) {
                this.eYl.cancel();
                this.eYl.setDuration(300L).start();
            }
        }
    }

    public void akB() {
        if (this.eYm != null && this.eYm.getY() < 0.0f && !akC()) {
            this.eYm.setVisibility(0);
            if (this.eYk == null) {
                aVX();
            }
            if (this.eYk != null) {
                this.eYk.cancel();
                this.eYk.setDuration(300L).start();
            }
        }
    }

    public void Hg() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hh() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hi() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean akC() {
        return (this.eYk != null && this.eYk.isRunning()) || (this.eYl != null && this.eYl.isRunning());
    }

    public void hideFloatingView() {
        if (this.cBf) {
            if (this.axZ) {
                eM(true);
            } else if (this.eYm != null && !this.eYq && !this.eTY && aVY()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Hh();
            }
        }
    }

    public void showFloatingView() {
        if (this.cBf) {
            if (this.axZ) {
                eM(true);
            } else if (this.eYm != null && !aVY()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Hg();
            }
        }
    }

    public boolean aVY() {
        return this.eYm.getVisibility() == 0 && this.eYm.getY() >= 0.0f;
    }

    public void jF(boolean z) {
        this.eYq = z;
    }

    public void jG(boolean z) {
        this.eTY = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cBf && this.eYm != null && !this.eYq && !this.eTY && this.eYp) {
            if (i > this.aMF && aVY()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aMF && !aVY()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aMF = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.eYp = true;
        } else if (i == 0) {
            this.eYp = false;
        }
        if (this.cBf && !this.eYq && !this.eTY) {
            if (this.axZ) {
                eM(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMF) {
                    Hh();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aMF) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Hg();
                } else if (firstVisiblePosition == this.aMF) {
                    if (firstVisiblePosition == 0 || !this.aMG || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Hg();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Hh();
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

    private void akD() {
        if (this.czH != null) {
            if (this.cBe && this.czH.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.czH.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.czH.setLayoutParams(layoutParams);
                eM(true);
                return;
            }
            eM(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eM(boolean z) {
        if (this.czH != null) {
            if (this.cBe && z && this.czH.getVisibility() != 0) {
                this.czH.setVisibility(0);
            } else if (!z && this.czH.getVisibility() != 8) {
                this.czH.setVisibility(8);
            }
        }
    }
}
