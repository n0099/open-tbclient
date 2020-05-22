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
/* loaded from: classes9.dex */
public class b {
    private View bdq;
    private a jLq;
    private Animator jWh;
    private Animator jWi;
    private ValueAnimator jWj;
    private ValueAnimator jWk;
    private AnimatorSet jWl;
    private AnimatorSet jWm;
    private View jWn;
    private View jWo;
    private View mExpandView;
    private int jWp = UtilHelper.getLightStatusBarHeight();
    private boolean jWq = false;
    private boolean eiy = false;
    private int evt = 0;
    private boolean jWr = false;
    private boolean jSD = false;
    private boolean jWs = false;
    private boolean evu = false;
    private boolean hri = true;
    private final Handler.Callback hrl = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bWY()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bWX();
                    return true;
                case 2:
                    b.this.bWV();
                    return true;
                case 3:
                    b.this.bWW();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hrl);
    private boolean bdr = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void rz(boolean z);
    }

    public void a(a aVar) {
        this.jLq = aVar;
    }

    public void nf(boolean z) {
        this.evu = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.jWn = view;
        this.bdq = view2;
        this.mExpandView = view3;
        this.jWo = this.mExpandView.findViewById(R.id.sticky_view);
        Hc();
        ch(false);
    }

    private void cIO() {
        this.jWh = ObjectAnimator.ofFloat(this.jWn, "translationY", (-this.jWn.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.jWh.setInterpolator(new LinearInterpolator());
        this.jWh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jWn != null) {
                    b.this.jWn.clearAnimation();
                    if (b.this.jWs) {
                        b.this.ch(false);
                    } else {
                        b.this.ch(true);
                    }
                    if (b.this.jLq != null) {
                        b.this.jLq.rz(false);
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
        this.jWk = ValueAnimator.ofInt(0, this.jWp);
        this.jWk.setInterpolator(new LinearInterpolator());
        this.jWk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jWo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jWo.setLayoutParams(layoutParams);
                }
                b.this.jWo.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jWo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jWp;
                    b.this.jWo.setLayoutParams(layoutParams);
                }
                b.this.jWo.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jWk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jWo.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jWo.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jWm = new AnimatorSet();
        this.jWm.play(this.jWh).with(this.jWk);
    }

    private void cIP() {
        this.jWi = ObjectAnimator.ofFloat(this.jWn, "translationY", 0.0f);
        this.jWi.setInterpolator(new LinearInterpolator());
        this.jWi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jWn != null) {
                    b.this.jWn.clearAnimation();
                    b.this.jWn.setVisibility(0);
                    b.this.ch(false);
                    if (b.this.jLq != null) {
                        b.this.jLq.rz(true);
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
        this.jWj = ValueAnimator.ofInt(this.jWp, 0);
        this.jWj.setInterpolator(new LinearInterpolator());
        this.jWj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.jWo.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.jWo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jWp;
                    b.this.jWo.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.jWo.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.jWo.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jWo.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jWj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jWo.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jWo.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jWl = new AnimatorSet();
        this.jWl.play(this.jWi).with(this.jWj);
    }

    public void bWV() {
        Q(false, false);
    }

    public void bWW() {
        Q(false, true);
    }

    public void Q(boolean z, boolean z2) {
        if (this.jWn != null && this.jWn.getY() == 0.0f && !bWY()) {
            if (z2) {
                this.jWn.setVisibility(8);
                if (this.jWs) {
                    ch(false);
                    return;
                } else {
                    ch(true);
                    return;
                }
            }
            this.jWn.setVisibility(0);
            if (this.jWm == null) {
                cIO();
            }
            if (this.jWm != null) {
                this.jWm.cancel();
                this.jWm.setDuration(300L).start();
            }
        }
    }

    public void bWX() {
        if (this.jWn != null && this.jWn.getY() < 0.0f && !bWY()) {
            this.jWn.setVisibility(0);
            if (this.jWl == null) {
                cIP();
            }
            if (this.jWl != null) {
                this.jWl.cancel();
                this.jWl.setDuration(300L).start();
            }
        }
    }

    public void bgJ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bgK() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void bld() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bWY() {
        return (this.jWl != null && this.jWl.isRunning()) || (this.jWm != null && this.jWm.isRunning());
    }

    public void hideFloatingView() {
        if (this.hri) {
            if (this.eiy) {
                ch(true);
            } else if (this.jWn != null && !this.jWr && !this.jSD && cIQ()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bgK();
            }
        }
    }

    public void showFloatingView() {
        if (this.hri) {
            if (this.eiy) {
                ch(true);
            } else if (this.jWn != null && !cIQ()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bgJ();
            }
        }
    }

    public boolean cIQ() {
        return this.jWn.getVisibility() == 0 && this.jWn.getY() >= 0.0f;
    }

    public void sk(boolean z) {
        this.jWr = z;
    }

    public void sl(boolean z) {
        this.jSD = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hri && this.jWn != null && !this.jWr && !this.jSD && this.jWq) {
            if (i > this.evt && cIQ()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.evt && !cIQ()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.evt = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.jWq = true;
        } else if (i == 0) {
            this.jWq = false;
        }
        if (this.hri && !this.jWr && !this.jSD) {
            if (this.eiy) {
                ch(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.evt) {
                    bgK();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.evt) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bgJ();
                } else if (firstVisiblePosition == this.evt) {
                    if (firstVisiblePosition == 0 || !this.evu || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bgJ();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bgK();
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

    private void Hc() {
        if (this.bdq != null) {
            if (this.bdr && this.bdq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bdq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bdq.setLayoutParams(layoutParams);
                ch(true);
                return;
            }
            ch(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (this.bdq != null) {
            if (this.bdr && z && this.bdq.getVisibility() != 0) {
                this.bdq.setVisibility(0);
            } else if (!z && this.bdq.getVisibility() != 8) {
                this.bdq.setVisibility(8);
            }
        }
    }
}
