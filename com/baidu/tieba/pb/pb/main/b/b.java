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
    private a jMw;
    private Animator jXn;
    private Animator jXo;
    private ValueAnimator jXp;
    private ValueAnimator jXq;
    private AnimatorSet jXr;
    private AnimatorSet jXs;
    private View jXt;
    private View jXu;
    private View mExpandView;
    private int jXv = UtilHelper.getLightStatusBarHeight();
    private boolean jXw = false;
    private boolean eiy = false;
    private int evt = 0;
    private boolean jXx = false;
    private boolean jTJ = false;
    private boolean jXy = false;
    private boolean evu = false;
    private boolean hrt = true;
    private final Handler.Callback hrw = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bXa()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bWZ();
                    return true;
                case 2:
                    b.this.bWX();
                    return true;
                case 3:
                    b.this.bWY();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hrw);
    private boolean bdr = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void rz(boolean z);
    }

    public void a(a aVar) {
        this.jMw = aVar;
    }

    public void nf(boolean z) {
        this.evu = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.jXt = view;
        this.bdq = view2;
        this.mExpandView = view3;
        this.jXu = this.mExpandView.findViewById(R.id.sticky_view);
        Hc();
        ch(false);
    }

    private void cJe() {
        this.jXn = ObjectAnimator.ofFloat(this.jXt, "translationY", (-this.jXt.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.jXn.setInterpolator(new LinearInterpolator());
        this.jXn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jXt != null) {
                    b.this.jXt.clearAnimation();
                    if (b.this.jXy) {
                        b.this.ch(false);
                    } else {
                        b.this.ch(true);
                    }
                    if (b.this.jMw != null) {
                        b.this.jMw.rz(false);
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
        this.jXq = ValueAnimator.ofInt(0, this.jXv);
        this.jXq.setInterpolator(new LinearInterpolator());
        this.jXq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jXu.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jXu.setLayoutParams(layoutParams);
                }
                b.this.jXu.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.jXu.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jXv;
                    b.this.jXu.setLayoutParams(layoutParams);
                }
                b.this.jXu.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jXq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jXu.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jXu.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jXs = new AnimatorSet();
        this.jXs.play(this.jXn).with(this.jXq);
    }

    private void cJf() {
        this.jXo = ObjectAnimator.ofFloat(this.jXt, "translationY", 0.0f);
        this.jXo.setInterpolator(new LinearInterpolator());
        this.jXo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.jXt != null) {
                    b.this.jXt.clearAnimation();
                    b.this.jXt.setVisibility(0);
                    b.this.ch(false);
                    if (b.this.jMw != null) {
                        b.this.jMw.rz(true);
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
        this.jXp = ValueAnimator.ofInt(this.jXv, 0);
        this.jXp.setInterpolator(new LinearInterpolator());
        this.jXp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.jXu.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.jXu.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.jXv;
                    b.this.jXu.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.jXu.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.jXu.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.jXu.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jXp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.jXu.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.jXu.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.jXr = new AnimatorSet();
        this.jXr.play(this.jXo).with(this.jXp);
    }

    public void bWX() {
        Q(false, false);
    }

    public void bWY() {
        Q(false, true);
    }

    public void Q(boolean z, boolean z2) {
        if (this.jXt != null && this.jXt.getY() == 0.0f && !bXa()) {
            if (z2) {
                this.jXt.setVisibility(8);
                if (this.jXy) {
                    ch(false);
                    return;
                } else {
                    ch(true);
                    return;
                }
            }
            this.jXt.setVisibility(0);
            if (this.jXs == null) {
                cJe();
            }
            if (this.jXs != null) {
                this.jXs.cancel();
                this.jXs.setDuration(300L).start();
            }
        }
    }

    public void bWZ() {
        if (this.jXt != null && this.jXt.getY() < 0.0f && !bXa()) {
            this.jXt.setVisibility(0);
            if (this.jXr == null) {
                cJf();
            }
            if (this.jXr != null) {
                this.jXr.cancel();
                this.jXr.setDuration(300L).start();
            }
        }
    }

    public void bgK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bgL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void blf() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bXa() {
        return (this.jXr != null && this.jXr.isRunning()) || (this.jXs != null && this.jXs.isRunning());
    }

    public void hideFloatingView() {
        if (this.hrt) {
            if (this.eiy) {
                ch(true);
            } else if (this.jXt != null && !this.jXx && !this.jTJ && cJg()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bgL();
            }
        }
    }

    public void showFloatingView() {
        if (this.hrt) {
            if (this.eiy) {
                ch(true);
            } else if (this.jXt != null && !cJg()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bgK();
            }
        }
    }

    public boolean cJg() {
        return this.jXt.getVisibility() == 0 && this.jXt.getY() >= 0.0f;
    }

    public void sk(boolean z) {
        this.jXx = z;
    }

    public void sl(boolean z) {
        this.jTJ = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hrt && this.jXt != null && !this.jXx && !this.jTJ && this.jXw) {
            if (i > this.evt && cJg()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.evt && !cJg()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.evt = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.jXw = true;
        } else if (i == 0) {
            this.jXw = false;
        }
        if (this.hrt && !this.jXx && !this.jTJ) {
            if (this.eiy) {
                ch(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.evt) {
                    bgL();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.evt) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bgK();
                } else if (firstVisiblePosition == this.evt) {
                    if (firstVisiblePosition == 0 || !this.evu || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bgK();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bgL();
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
