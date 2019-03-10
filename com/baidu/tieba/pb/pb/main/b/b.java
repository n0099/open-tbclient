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
    private Animator hAp;
    private Animator hAq;
    private ValueAnimator hAr;
    private ValueAnimator hAs;
    private AnimatorSet hAt;
    private AnimatorSet hAu;
    private View hAv;
    private View hAw;
    private a hnZ;
    private int hAx = UtilHelper.getLightStatusBarHeight();
    private boolean hAy = false;
    private boolean cfo = false;
    private int ctH = 0;
    private boolean hAz = false;
    private boolean hxS = false;
    private boolean hAA = false;
    private boolean ctI = false;
    private boolean fcX = true;
    private final Handler.Callback fcZ = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bex()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bew();
                    return true;
                case 2:
                    b.this.beu();
                    return true;
                case 3:
                    b.this.bev();
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
        this.hnZ = aVar;
    }

    public void jr(boolean z) {
        this.ctI = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.hAv = view;
        this.fbm = view2;
        this.OO = view3;
        this.hAw = this.OO.findViewById(d.g.sticky_view);
        aCn();
        jt(false);
    }

    private void bNL() {
        this.hAp = ObjectAnimator.ofFloat(this.hAv, "translationY", (-this.hAv.getMeasuredHeight()) + this.OO.getMeasuredHeight());
        this.hAp.setInterpolator(new LinearInterpolator());
        this.hAp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAv != null) {
                    b.this.hAv.clearAnimation();
                    if (b.this.hAA) {
                        b.this.jt(false);
                    } else {
                        b.this.jt(true);
                    }
                    if (b.this.hnZ != null) {
                        b.this.hnZ.no(false);
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
        this.hAs = ValueAnimator.ofInt(0, this.hAx);
        this.hAs.setInterpolator(new LinearInterpolator());
        this.hAs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAw.setLayoutParams(layoutParams);
                }
                b.this.hAw.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.hAw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAx;
                    b.this.hAw.setLayoutParams(layoutParams);
                }
                b.this.hAw.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAw.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAw.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAu = new AnimatorSet();
        this.hAu.play(this.hAp).with(this.hAs);
    }

    private void bNM() {
        this.hAq = ObjectAnimator.ofFloat(this.hAv, "translationY", 0.0f);
        this.hAq.setInterpolator(new LinearInterpolator());
        this.hAq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.hAv != null) {
                    b.this.hAv.clearAnimation();
                    b.this.hAv.setVisibility(0);
                    b.this.jt(false);
                    if (b.this.hnZ != null) {
                        b.this.hnZ.no(true);
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
        this.hAr = ValueAnimator.ofInt(this.hAx, 0);
        this.hAr.setInterpolator(new LinearInterpolator());
        this.hAr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.hAw.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.hAw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.hAx;
                    b.this.hAw.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.hAw.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.hAw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.hAw.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.hAr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.hAw.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.hAw.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.hAt = new AnimatorSet();
        this.hAt.play(this.hAq).with(this.hAr);
    }

    public void beu() {
        G(false, false);
    }

    public void bev() {
        G(false, true);
    }

    public void G(boolean z, boolean z2) {
        if (this.hAv != null && this.hAv.getY() == 0.0f && !bex()) {
            if (z2) {
                this.hAv.setVisibility(8);
                if (this.hAA) {
                    jt(false);
                    return;
                } else {
                    jt(true);
                    return;
                }
            }
            this.hAv.setVisibility(0);
            if (this.hAu == null) {
                bNL();
            }
            if (this.hAu != null) {
                this.hAu.cancel();
                this.hAu.setDuration(300L).start();
            }
        }
    }

    public void bew() {
        if (this.hAv != null && this.hAv.getY() < 0.0f && !bex()) {
            this.hAv.setVisibility(0);
            if (this.hAt == null) {
                bNM();
            }
            if (this.hAt != null) {
                this.hAt.cancel();
                this.hAt.setDuration(300L).start();
            }
        }
    }

    public void aqj() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aqk() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aql() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bex() {
        return (this.hAt != null && this.hAt.isRunning()) || (this.hAu != null && this.hAu.isRunning());
    }

    public void hideFloatingView() {
        if (this.fcX) {
            if (this.cfo) {
                jt(true);
            } else if (this.hAv != null && !this.hAz && !this.hxS && bNN()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aqk();
            }
        }
    }

    public void showFloatingView() {
        if (this.fcX) {
            if (this.cfo) {
                jt(true);
            } else if (this.hAv != null && !bNN()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aqj();
            }
        }
    }

    public boolean bNN() {
        return this.hAv.getVisibility() == 0 && this.hAv.getY() >= 0.0f;
    }

    public void od(boolean z) {
        this.hAz = z;
    }

    public void oe(boolean z) {
        this.hxS = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.fcX && this.hAv != null && !this.hAz && !this.hxS && this.hAy) {
            if (i > this.ctH && bNN()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.ctH && !bNN()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.ctH = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.hAy = true;
        } else if (i == 0) {
            this.hAy = false;
        }
        if (this.fcX && !this.hAz && !this.hxS) {
            if (this.cfo) {
                jt(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.ctH) {
                    aqk();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.ctH) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aqj();
                } else if (firstVisiblePosition == this.ctH) {
                    if (firstVisiblePosition == 0 || !this.ctI || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aqj();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aqk();
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

    private void aCn() {
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
