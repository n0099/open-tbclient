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
/* loaded from: classes22.dex */
public class b {
    private View bEb;
    private Animator lGe;
    private Animator lGf;
    private ValueAnimator lGg;
    private ValueAnimator lGh;
    private AnimatorSet lGi;
    private AnimatorSet lGj;
    private View lGk;
    private View lGl;
    private a luI;
    private View mExpandView;
    private int lGm = UtilHelper.getLightStatusBarHeight();
    private boolean lGn = false;
    private boolean fkI = false;
    private int fyY = 0;
    private boolean lGo = false;
    private boolean lCx = false;
    private boolean lGp = false;
    private boolean fyZ = false;
    private boolean iMi = true;
    private final Handler.Callback iMl = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cAD()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cAB();
                    return true;
                case 2:
                    b.this.cAz();
                    return true;
                case 3:
                    b.this.cAA();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iMl);
    private boolean bEc = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes22.dex */
    public interface a {
        void up(boolean z);
    }

    public void a(a aVar) {
        this.luI = aVar;
    }

    public void pN(boolean z) {
        this.fyZ = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lGk = view;
        this.bEb = view2;
        this.mExpandView = view3;
        this.lGl = this.mExpandView.findViewById(R.id.sticky_view);
        Tz();
        cP(false);
    }

    private void doX() {
        this.lGe = ObjectAnimator.ofFloat(this.lGk, "translationY", (-this.lGk.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lGe.setInterpolator(new LinearInterpolator());
        this.lGe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lGk != null) {
                    b.this.lGk.clearAnimation();
                    if (b.this.lGp) {
                        b.this.cP(false);
                    } else {
                        b.this.cP(true);
                    }
                    if (b.this.luI != null) {
                        b.this.luI.up(false);
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
        this.lGh = ValueAnimator.ofInt(0, this.lGm);
        this.lGh.setInterpolator(new LinearInterpolator());
        this.lGh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lGl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lGl.setLayoutParams(layoutParams);
                }
                b.this.lGl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lGl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lGm;
                    b.this.lGl.setLayoutParams(layoutParams);
                }
                b.this.lGl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lGh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lGl.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lGl.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lGj = new AnimatorSet();
        this.lGj.play(this.lGe).with(this.lGh);
    }

    private void doY() {
        this.lGf = ObjectAnimator.ofFloat(this.lGk, "translationY", 0.0f);
        this.lGf.setInterpolator(new LinearInterpolator());
        this.lGf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lGk != null) {
                    b.this.lGk.clearAnimation();
                    b.this.lGk.setVisibility(0);
                    b.this.cP(false);
                    if (b.this.luI != null) {
                        b.this.luI.up(true);
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
        this.lGg = ValueAnimator.ofInt(this.lGm, 0);
        this.lGg.setInterpolator(new LinearInterpolator());
        this.lGg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lGl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lGl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lGm;
                    b.this.lGl.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lGl.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lGl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lGl.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lGg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lGl.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lGl.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lGi = new AnimatorSet();
        this.lGi.play(this.lGf).with(this.lGg);
    }

    public void cAz() {
        Z(false, false);
    }

    public void cAA() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.lGk != null && this.lGk.getY() == 0.0f && !cAD()) {
            if (z2) {
                this.lGk.setVisibility(8);
                if (this.lGp) {
                    cP(false);
                    return;
                } else {
                    cP(true);
                    return;
                }
            }
            this.lGk.setVisibility(0);
            if (this.lGj == null) {
                doX();
            }
            if (this.lGj != null) {
                this.lGj.cancel();
                this.lGj.setDuration(300L).start();
            }
        }
    }

    public void cAB() {
        if (this.lGk != null && this.lGk.getY() < 0.0f && !cAD()) {
            this.lGk.setVisibility(0);
            if (this.lGi == null) {
                doY();
            }
            if (this.lGi != null) {
                this.lGi.cancel();
                this.lGi.setDuration(300L).start();
            }
        }
    }

    public void bDQ() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bDR() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cAC() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cAD() {
        return (this.lGi != null && this.lGi.isRunning()) || (this.lGj != null && this.lGj.isRunning());
    }

    public void hideFloatingView() {
        if (this.iMi) {
            if (this.fkI) {
                cP(true);
            } else if (this.lGk != null && !this.lGo && !this.lCx && doZ()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bDR();
            }
        }
    }

    public void showFloatingView() {
        if (this.iMi) {
            if (this.fkI) {
                cP(true);
            } else if (this.lGk != null && !doZ()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bDQ();
            }
        }
    }

    public boolean doZ() {
        return this.lGk.getVisibility() == 0 && this.lGk.getY() >= 0.0f;
    }

    public void vd(boolean z) {
        this.lGo = z;
    }

    public void ve(boolean z) {
        this.lCx = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iMi && this.lGk != null && !this.lGo && !this.lCx && this.lGn) {
            if (i > this.fyY && doZ()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fyY && !doZ()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fyY = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lGn = true;
        } else if (i == 0) {
            this.lGn = false;
        }
        if (this.iMi && !this.lGo && !this.lCx) {
            if (this.fkI) {
                cP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fyY) {
                    bDR();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fyY) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bDQ();
                } else if (firstVisiblePosition == this.fyY) {
                    if (firstVisiblePosition == 0 || !this.fyZ || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bDQ();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bDR();
                }
            }
        }
    }

    public boolean b(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void Tz() {
        if (this.bEb != null) {
            if (this.bEc && this.bEb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bEb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bEb.setLayoutParams(layoutParams);
                cP(true);
                return;
            }
            cP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cP(boolean z) {
        if (this.bEb != null) {
            if (this.bEc && z && this.bEb.getVisibility() != 0) {
                this.bEb.setVisibility(0);
            } else if (!z && this.bEb.getVisibility() != 8) {
                this.bEb.setVisibility(8);
            }
        }
    }
}
