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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class b {
    private View OP;
    private View fbl;
    private Animator hAj;
    private Animator hAk;
    private ValueAnimator hAl;
    private ValueAnimator hAm;
    private AnimatorSet hAn;
    private AnimatorSet hAo;
    private View hAp;
    private View hAq;
    private a hnS;
    private int hAr = UtilHelper.getLightStatusBarHeight();
    private boolean hAs = false;
    private boolean cfo = false;
    private int ctE = 0;
    private boolean hAt = false;
    private boolean hxM = false;
    private boolean hAu = false;
    private boolean ctF = false;
    private boolean fcW = true;
    private final Handler.Callback fcY = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bew()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bev();
                    return true;
                case 2:
                    b.this.bet();
                    return true;
                case 3:
                    b.this.beu();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.fcY);
    private boolean fcV = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void no(boolean z);
    }

    public void a(a aVar) {
        this.hnS = aVar;
    }

    public void jr(boolean z) {
        this.ctF = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hAp = view;
        this.fbl = view2;
        this.OP = view3;
        this.hAq = this.OP.findViewById(d.g.sticky_view);
        aCm();
        jt(false);
    }

    private void bNL() {
        this.hAj = ObjectAnimator.ofFloat(this.hAp, "translationY", (-this.hAp.getMeasuredHeight()) + this.OP.getMeasuredHeight());
        this.hAj.setInterpolator(new LinearInterpolator());
        this.hAj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAp != null) {
                    b.this.hAp.clearAnimation();
                    if (b.this.hAu) {
                        b.this.jt(false);
                    } else {
                        b.this.jt(true);
                    }
                    if (b.this.hnS != null) {
                        b.this.hnS.no(false);
                    }
                    b.this.OP.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAm = ValueAnimator.ofInt(0, this.hAr);
        this.hAm.setInterpolator(new LinearInterpolator());
        this.hAm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAq.setLayoutParams(layoutParams);
                }
                b.this.hAq.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAr;
                    b.this.hAq.setLayoutParams(layoutParams);
                }
                b.this.hAq.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAq.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAq.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAo = new AnimatorSet();
        this.hAo.play(this.hAj).with(this.hAm);
    }

    private void bNM() {
        this.hAk = ObjectAnimator.ofFloat(this.hAp, "translationY", 0.0f);
        this.hAk.setInterpolator(new LinearInterpolator());
        this.hAk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAp != null) {
                    b.this.hAp.clearAnimation();
                    b.this.hAp.setVisibility(0);
                    b.this.jt(false);
                    if (b.this.hnS != null) {
                        b.this.hnS.no(true);
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
        this.hAl = ValueAnimator.ofInt(this.hAr, 0);
        this.hAl.setInterpolator(new LinearInterpolator());
        this.hAl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hAq.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hAq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAr;
                    b.this.hAq.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hAq.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hAq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAq.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAq.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAq.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAn = new AnimatorSet();
        this.hAn.play(this.hAk).with(this.hAl);
    }

    public void bet() {
        G(false, false);
    }

    public void beu() {
        G(false, true);
    }

    public void G(boolean z, boolean z2) {
        if (this.hAp != null && this.hAp.getY() == 0.0f && !bew()) {
            if (z2) {
                this.hAp.setVisibility(8);
                if (this.hAu) {
                    jt(false);
                    return;
                } else {
                    jt(true);
                    return;
                }
            }
            this.hAp.setVisibility(0);
            if (this.hAo == null) {
                bNL();
            }
            if (this.hAo != null) {
                this.hAo.cancel();
                this.hAo.setDuration(300L).start();
            }
        }
    }

    public void bev() {
        if (this.hAp != null && this.hAp.getY() < 0.0f && !bew()) {
            this.hAp.setVisibility(0);
            if (this.hAn == null) {
                bNM();
            }
            if (this.hAn != null) {
                this.hAn.cancel();
                this.hAn.setDuration(300L).start();
            }
        }
    }

    public void aqi() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqj() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aqk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bew() {
        return (this.hAn != null && this.hAn.isRunning()) || (this.hAo != null && this.hAo.isRunning());
    }

    public void hideFloatingView() {
        if (this.fcW) {
            if (this.cfo) {
                jt(true);
            } else if (this.hAp != null && !this.hAt && !this.hxM && bNN()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aqj();
            }
        }
    }

    public void showFloatingView() {
        if (this.fcW) {
            if (this.cfo) {
                jt(true);
            } else if (this.hAp != null && !bNN()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aqi();
            }
        }
    }

    public boolean bNN() {
        return this.hAp.getVisibility() == 0 && this.hAp.getY() >= 0.0f;
    }

    public void od(boolean z) {
        this.hAt = z;
    }

    public void oe(boolean z) {
        this.hxM = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fcW && this.hAp != null && !this.hAt && !this.hxM && this.hAs) {
            if (i > this.ctE && bNN()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.ctE && !bNN()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.ctE = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hAs = true;
        } else if (i == 0) {
            this.hAs = false;
        }
        if (this.fcW && !this.hAt && !this.hxM) {
            if (this.cfo) {
                jt(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.ctE) {
                    aqj();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.ctE) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aqi();
                } else if (firstVisiblePosition == this.ctE) {
                    if (firstVisiblePosition == 0 || !this.ctF || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aqi();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aqj();
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

    private void aCm() {
        if (this.fbl != null) {
            if (this.fcV && this.fbl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fbl.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fbl.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt(boolean z) {
        if (this.fbl != null) {
            if (this.fcV && z && this.fbl.getVisibility() != 0) {
                this.fbl.setVisibility(0);
            } else if (!z && this.fbl.getVisibility() != 8) {
                this.fbl.setVisibility(8);
            }
        }
    }
}
