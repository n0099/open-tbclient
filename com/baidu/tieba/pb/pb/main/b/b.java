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
    private View OO;
    private View fbm;
    private Animator hAo;
    private Animator hAp;
    private ValueAnimator hAq;
    private ValueAnimator hAr;
    private AnimatorSet hAs;
    private AnimatorSet hAt;
    private View hAu;
    private View hAv;
    private a hnY;
    private int hAw = UtilHelper.getLightStatusBarHeight();
    private boolean hAx = false;
    private boolean cfo = false;
    private int ctH = 0;
    private boolean hAy = false;
    private boolean hxR = false;
    private boolean hAz = false;
    private boolean ctI = false;
    private boolean fcX = true;
    private final Handler.Callback fcZ = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
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
    private final Handler mHandler = new Handler(this.fcZ);
    private boolean fcW = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes4.dex */
    public interface a {
        void no(boolean z);
    }

    public void a(a aVar) {
        this.hnY = aVar;
    }

    public void jr(boolean z) {
        this.ctI = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hAu = view;
        this.fbm = view2;
        this.OO = view3;
        this.hAv = this.OO.findViewById(d.g.sticky_view);
        aCm();
        jt(false);
    }

    private void bNK() {
        this.hAo = ObjectAnimator.ofFloat(this.hAu, "translationY", (-this.hAu.getMeasuredHeight()) + this.OO.getMeasuredHeight());
        this.hAo.setInterpolator(new LinearInterpolator());
        this.hAo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAu != null) {
                    b.this.hAu.clearAnimation();
                    if (b.this.hAz) {
                        b.this.jt(false);
                    } else {
                        b.this.jt(true);
                    }
                    if (b.this.hnY != null) {
                        b.this.hnY.no(false);
                    }
                    b.this.OO.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAr = ValueAnimator.ofInt(0, this.hAw);
        this.hAr.setInterpolator(new LinearInterpolator());
        this.hAr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAv.setLayoutParams(layoutParams);
                }
                b.this.hAv.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAw;
                    b.this.hAv.setLayoutParams(layoutParams);
                }
                b.this.hAv.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAv.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAv.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAt = new AnimatorSet();
        this.hAt.play(this.hAo).with(this.hAr);
    }

    private void bNL() {
        this.hAp = ObjectAnimator.ofFloat(this.hAu, "translationY", 0.0f);
        this.hAp.setInterpolator(new LinearInterpolator());
        this.hAp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAu != null) {
                    b.this.hAu.clearAnimation();
                    b.this.hAu.setVisibility(0);
                    b.this.jt(false);
                    if (b.this.hnY != null) {
                        b.this.hnY.no(true);
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
        this.hAq = ValueAnimator.ofInt(this.hAw, 0);
        this.hAq.setInterpolator(new LinearInterpolator());
        this.hAq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hAv.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hAv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAw;
                    b.this.hAv.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hAv.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hAv.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAv.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAv.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAv.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAs = new AnimatorSet();
        this.hAs.play(this.hAp).with(this.hAq);
    }

    public void bet() {
        G(false, false);
    }

    public void beu() {
        G(false, true);
    }

    public void G(boolean z, boolean z2) {
        if (this.hAu != null && this.hAu.getY() == 0.0f && !bew()) {
            if (z2) {
                this.hAu.setVisibility(8);
                if (this.hAz) {
                    jt(false);
                    return;
                } else {
                    jt(true);
                    return;
                }
            }
            this.hAu.setVisibility(0);
            if (this.hAt == null) {
                bNK();
            }
            if (this.hAt != null) {
                this.hAt.cancel();
                this.hAt.setDuration(300L).start();
            }
        }
    }

    public void bev() {
        if (this.hAu != null && this.hAu.getY() < 0.0f && !bew()) {
            this.hAu.setVisibility(0);
            if (this.hAs == null) {
                bNL();
            }
            if (this.hAs != null) {
                this.hAs.cancel();
                this.hAs.setDuration(300L).start();
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
        return (this.hAs != null && this.hAs.isRunning()) || (this.hAt != null && this.hAt.isRunning());
    }

    public void hideFloatingView() {
        if (this.fcX) {
            if (this.cfo) {
                jt(true);
            } else if (this.hAu != null && !this.hAy && !this.hxR && bNM()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aqj();
            }
        }
    }

    public void showFloatingView() {
        if (this.fcX) {
            if (this.cfo) {
                jt(true);
            } else if (this.hAu != null && !bNM()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aqi();
            }
        }
    }

    public boolean bNM() {
        return this.hAu.getVisibility() == 0 && this.hAu.getY() >= 0.0f;
    }

    public void od(boolean z) {
        this.hAy = z;
    }

    public void oe(boolean z) {
        this.hxR = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fcX && this.hAu != null && !this.hAy && !this.hxR && this.hAx) {
            if (i > this.ctH && bNM()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.ctH && !bNM()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.ctH = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hAx = true;
        } else if (i == 0) {
            this.hAx = false;
        }
        if (this.fcX && !this.hAy && !this.hxR) {
            if (this.cfo) {
                jt(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.ctH) {
                    aqj();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.ctH) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aqi();
                } else if (firstVisiblePosition == this.ctH) {
                    if (firstVisiblePosition == 0 || !this.ctI || a(absListView)) {
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
        if (this.fbm != null) {
            if (this.fcW && this.fbm.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fbm.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.fbm.setLayoutParams(layoutParams);
                jt(true);
                return;
            }
            jt(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void jt(boolean z) {
        if (this.fbm != null) {
            if (this.fcW && z && this.fbm.getVisibility() != 0) {
                this.fbm.setVisibility(0);
            } else if (!z && this.fbm.getVisibility() != 8) {
                this.fbm.setVisibility(8);
            }
        }
    }
}
