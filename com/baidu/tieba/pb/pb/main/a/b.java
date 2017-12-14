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
    private View cIW;
    private a eUl;
    private Animator ffW;
    private Animator ffX;
    private ValueAnimator ffY;
    private ValueAnimator ffZ;
    private AnimatorSet fga;
    private AnimatorSet fgb;
    private View fgc;
    private View fgd;
    private int fge = UtilHelper.getLightStatusBarHeight();
    private boolean fgf = false;
    private boolean ayF = false;
    private int aNj = 0;
    private boolean fgg = false;
    private boolean fdK = false;
    private boolean fgh = false;
    private boolean aNk = false;
    private boolean cKt = true;
    private final Handler.Callback cKv = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.amH()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.amG();
                    return true;
                case 2:
                    b.this.amE();
                    return true;
                case 3:
                    b.this.amF();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cKv);
    private boolean cKs = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void jk(boolean z);
    }

    public void a(a aVar) {
        this.eUl = aVar;
    }

    public void fc(boolean z) {
        this.aNk = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fgc = view;
        this.cIW = view2;
        this.GN = view3;
        this.fgd = this.GN.findViewById(d.g.sticky_view);
        amI();
        fe(false);
    }

    private void aXe() {
        this.ffW = ObjectAnimator.ofFloat(this.fgc, "translationY", (-this.fgc.getMeasuredHeight()) + this.GN.getMeasuredHeight());
        this.ffW.setInterpolator(new LinearInterpolator());
        this.ffW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fgc != null) {
                    b.this.fgc.clearAnimation();
                    if (b.this.fgh) {
                        b.this.fe(false);
                    } else {
                        b.this.fe(true);
                    }
                    if (b.this.eUl != null) {
                        b.this.eUl.jk(false);
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
        this.ffZ = ValueAnimator.ofInt(0, this.fge);
        this.ffZ.setInterpolator(new LinearInterpolator());
        this.ffZ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fgd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fgd.setLayoutParams(layoutParams);
                }
                b.this.fgd.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fgd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fge;
                    b.this.fgd.setLayoutParams(layoutParams);
                }
                b.this.fgd.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ffZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fgd.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fgd.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fgb = new AnimatorSet();
        this.fgb.play(this.ffW).with(this.ffZ);
    }

    private void aXf() {
        this.ffX = ObjectAnimator.ofFloat(this.fgc, "translationY", 0.0f);
        this.ffX.setInterpolator(new LinearInterpolator());
        this.ffX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fgc != null) {
                    b.this.fgc.clearAnimation();
                    b.this.fgc.setVisibility(0);
                    b.this.fe(false);
                    if (b.this.eUl != null) {
                        b.this.eUl.jk(true);
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
        this.ffY = ValueAnimator.ofInt(this.fge, 0);
        this.ffY.setInterpolator(new LinearInterpolator());
        this.ffY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fgd.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fgd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fge;
                    b.this.fgd.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fgd.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fgd.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fgd.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ffY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fgd.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fgd.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fga = new AnimatorSet();
        this.fga.play(this.ffX).with(this.ffY);
    }

    public void amE() {
        w(false, false);
    }

    public void amF() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.fgc != null && this.fgc.getY() == 0.0f && !amH()) {
            if (z2) {
                this.fgc.setVisibility(8);
                if (this.fgh) {
                    fe(false);
                    return;
                } else {
                    fe(true);
                    return;
                }
            }
            this.fgc.setVisibility(0);
            if (this.fgb == null) {
                aXe();
            }
            if (this.fgb != null) {
                this.fgb.cancel();
                this.fgb.setDuration(300L).start();
            }
        }
    }

    public void amG() {
        if (this.fgc != null && this.fgc.getY() < 0.0f && !amH()) {
            this.fgc.setVisibility(0);
            if (this.fga == null) {
                aXf();
            }
            if (this.fga != null) {
                this.fga.cancel();
                this.fga.setDuration(300L).start();
            }
        }
    }

    public void Ho() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hp() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean amH() {
        return (this.fga != null && this.fga.isRunning()) || (this.fgb != null && this.fgb.isRunning());
    }

    public void hideFloatingView() {
        if (this.cKt) {
            if (this.ayF) {
                fe(true);
            } else if (this.fgc != null && !this.fgg && !this.fdK && aXg()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Hp();
            }
        }
    }

    public void showFloatingView() {
        if (this.cKt) {
            if (this.ayF) {
                fe(true);
            } else if (this.fgc != null && !aXg()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Ho();
            }
        }
    }

    public boolean aXg() {
        return this.fgc.getVisibility() == 0 && this.fgc.getY() >= 0.0f;
    }

    public void ke(boolean z) {
        this.fgg = z;
    }

    public void kf(boolean z) {
        this.fdK = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cKt && this.fgc != null && !this.fgg && !this.fdK && this.fgf) {
            if (i > this.aNj && aXg()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aNj && !aXg()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aNj = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fgf = true;
        } else if (i == 0) {
            this.fgf = false;
        }
        if (this.cKt && !this.fgg && !this.fdK) {
            if (this.ayF) {
                fe(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aNj) {
                    Hp();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aNj) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Ho();
                } else if (firstVisiblePosition == this.aNj) {
                    if (firstVisiblePosition == 0 || !this.aNk || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Ho();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Hp();
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

    private void amI() {
        if (this.cIW != null) {
            if (this.cKs && this.cIW.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cIW.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cIW.setLayoutParams(layoutParams);
                fe(true);
                return;
            }
            fe(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(boolean z) {
        if (this.cIW != null) {
            if (this.cKs && z && this.cIW.getVisibility() != 0) {
                this.cIW.setVisibility(0);
            } else if (!z && this.cIW.getVisibility() != 8) {
                this.cIW.setVisibility(8);
            }
        }
    }
}
