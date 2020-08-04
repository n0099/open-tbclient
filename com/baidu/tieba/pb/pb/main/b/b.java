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
/* loaded from: classes16.dex */
public class b {
    private View biX;
    private Animator kAd;
    private Animator kAe;
    private ValueAnimator kAf;
    private ValueAnimator kAg;
    private AnimatorSet kAh;
    private AnimatorSet kAi;
    private View kAj;
    private View kAk;
    private a koZ;
    private View mExpandView;
    private int kAl = UtilHelper.getLightStatusBarHeight();
    private boolean kAm = false;
    private boolean exB = false;
    private int eKV = 0;
    private boolean kAn = false;
    private boolean kwy = false;
    private boolean kAo = false;
    private boolean eKW = false;
    private boolean hKi = true;
    private final Handler.Callback hKl = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cdK()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cdI();
                    return true;
                case 2:
                    b.this.cdG();
                    return true;
                case 3:
                    b.this.cdH();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hKl);
    private boolean biY = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes16.dex */
    public interface a {
        void sr(boolean z);
    }

    public void a(a aVar) {
        this.koZ = aVar;
    }

    public void nV(boolean z) {
        this.eKW = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.kAj = view;
        this.biX = view2;
        this.mExpandView = view3;
        this.kAk = this.mExpandView.findViewById(R.id.sticky_view);
        Iv();
        co(false);
    }

    private void cRj() {
        this.kAd = ObjectAnimator.ofFloat(this.kAj, "translationY", (-this.kAj.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.kAd.setInterpolator(new LinearInterpolator());
        this.kAd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kAj != null) {
                    b.this.kAj.clearAnimation();
                    if (b.this.kAo) {
                        b.this.co(false);
                    } else {
                        b.this.co(true);
                    }
                    if (b.this.koZ != null) {
                        b.this.koZ.sr(false);
                    }
                    b.this.mExpandView.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kAg = ValueAnimator.ofInt(0, this.kAl);
        this.kAg.setInterpolator(new LinearInterpolator());
        this.kAg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kAk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kAk.setLayoutParams(layoutParams);
                }
                b.this.kAk.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kAk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kAl;
                    b.this.kAk.setLayoutParams(layoutParams);
                }
                b.this.kAk.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kAg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kAk.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kAk.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kAi = new AnimatorSet();
        this.kAi.play(this.kAd).with(this.kAg);
    }

    private void cRk() {
        this.kAe = ObjectAnimator.ofFloat(this.kAj, "translationY", 0.0f);
        this.kAe.setInterpolator(new LinearInterpolator());
        this.kAe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kAj != null) {
                    b.this.kAj.clearAnimation();
                    b.this.kAj.setVisibility(0);
                    b.this.co(false);
                    if (b.this.koZ != null) {
                        b.this.koZ.sr(true);
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
        this.kAf = ValueAnimator.ofInt(this.kAl, 0);
        this.kAf.setInterpolator(new LinearInterpolator());
        this.kAf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.kAk.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.kAk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kAl;
                    b.this.kAk.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.kAk.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.kAk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kAk.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kAf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kAk.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kAk.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kAh = new AnimatorSet();
        this.kAh.play(this.kAe).with(this.kAf);
    }

    public void cdG() {
        R(false, false);
    }

    public void cdH() {
        R(false, true);
    }

    public void R(boolean z, boolean z2) {
        if (this.kAj != null && this.kAj.getY() == 0.0f && !cdK()) {
            if (z2) {
                this.kAj.setVisibility(8);
                if (this.kAo) {
                    co(false);
                    return;
                } else {
                    co(true);
                    return;
                }
            }
            this.kAj.setVisibility(0);
            if (this.kAi == null) {
                cRj();
            }
            if (this.kAi != null) {
                this.kAi.cancel();
                this.kAi.setDuration(300L).start();
            }
        }
    }

    public void cdI() {
        if (this.kAj != null && this.kAj.getY() < 0.0f && !cdK()) {
            this.kAj.setVisibility(0);
            if (this.kAh == null) {
                cRk();
            }
            if (this.kAh != null) {
                this.kAh.cancel();
                this.kAh.setDuration(300L).start();
            }
        }
    }

    public void bmR() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bmS() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cdJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cdK() {
        return (this.kAh != null && this.kAh.isRunning()) || (this.kAi != null && this.kAi.isRunning());
    }

    public void hideFloatingView() {
        if (this.hKi) {
            if (this.exB) {
                co(true);
            } else if (this.kAj != null && !this.kAn && !this.kwy && cRl()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bmS();
            }
        }
    }

    public void showFloatingView() {
        if (this.hKi) {
            if (this.exB) {
                co(true);
            } else if (this.kAj != null && !cRl()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bmR();
            }
        }
    }

    public boolean cRl() {
        return this.kAj.getVisibility() == 0 && this.kAj.getY() >= 0.0f;
    }

    public void te(boolean z) {
        this.kAn = z;
    }

    public void tf(boolean z) {
        this.kwy = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hKi && this.kAj != null && !this.kAn && !this.kwy && this.kAm) {
            if (i > this.eKV && cRl()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.eKV && !cRl()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.eKV = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kAm = true;
        } else if (i == 0) {
            this.kAm = false;
        }
        if (this.hKi && !this.kAn && !this.kwy) {
            if (this.exB) {
                co(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.eKV) {
                    bmS();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.eKV) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bmR();
                } else if (firstVisiblePosition == this.eKV) {
                    if (firstVisiblePosition == 0 || !this.eKW || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bmR();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bmS();
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

    private void Iv() {
        if (this.biX != null) {
            if (this.biY && this.biX.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.biX.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.biX.setLayoutParams(layoutParams);
                co(true);
                return;
            }
            co(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void co(boolean z) {
        if (this.biX != null) {
            if (this.biY && z && this.biX.getVisibility() != 0) {
                this.biX.setVisibility(0);
            } else if (!z && this.biX.getVisibility() != 8) {
                this.biX.setVisibility(8);
            }
        }
    }
}
