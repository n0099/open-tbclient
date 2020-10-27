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
    private View bxQ;
    private Animator lAi;
    private Animator lAj;
    private ValueAnimator lAk;
    private ValueAnimator lAl;
    private AnimatorSet lAm;
    private AnimatorSet lAn;
    private View lAo;
    private View lAp;
    private a loL;
    private View mExpandView;
    private int lAq = UtilHelper.getLightStatusBarHeight();
    private boolean lAr = false;
    private boolean feP = false;
    private int ftg = 0;
    private boolean lAs = false;
    private boolean lwA = false;
    private boolean lAt = false;
    private boolean fth = false;
    private boolean iGl = true;
    private final Handler.Callback iGo = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cyc()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cya();
                    return true;
                case 2:
                    b.this.cxY();
                    return true;
                case 3:
                    b.this.cxZ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.iGo);
    private boolean bxR = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes22.dex */
    public interface a {
        void ug(boolean z);
    }

    public void a(a aVar) {
        this.loL = aVar;
    }

    public void pE(boolean z) {
        this.fth = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.lAo = view;
        this.bxQ = view2;
        this.mExpandView = view3;
        this.lAp = this.mExpandView.findViewById(R.id.sticky_view);
        QR();
        cI(false);
    }

    private void dmu() {
        this.lAi = ObjectAnimator.ofFloat(this.lAo, "translationY", (-this.lAo.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.lAi.setInterpolator(new LinearInterpolator());
        this.lAi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lAo != null) {
                    b.this.lAo.clearAnimation();
                    if (b.this.lAt) {
                        b.this.cI(false);
                    } else {
                        b.this.cI(true);
                    }
                    if (b.this.loL != null) {
                        b.this.loL.ug(false);
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
        this.lAl = ValueAnimator.ofInt(0, this.lAq);
        this.lAl.setInterpolator(new LinearInterpolator());
        this.lAl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lAp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lAp.setLayoutParams(layoutParams);
                }
                b.this.lAp.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.lAp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lAq;
                    b.this.lAp.setLayoutParams(layoutParams);
                }
                b.this.lAp.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lAl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lAp.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lAp.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lAn = new AnimatorSet();
        this.lAn.play(this.lAi).with(this.lAl);
    }

    private void dmv() {
        this.lAj = ObjectAnimator.ofFloat(this.lAo, "translationY", 0.0f);
        this.lAj.setInterpolator(new LinearInterpolator());
        this.lAj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.lAo != null) {
                    b.this.lAo.clearAnimation();
                    b.this.lAo.setVisibility(0);
                    b.this.cI(false);
                    if (b.this.loL != null) {
                        b.this.loL.ug(true);
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
        this.lAk = ValueAnimator.ofInt(this.lAq, 0);
        this.lAk.setInterpolator(new LinearInterpolator());
        this.lAk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.lAp.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.lAp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.lAq;
                    b.this.lAp.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.lAp.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.lAp.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.lAp.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lAk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.lAp.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.lAp.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.lAm = new AnimatorSet();
        this.lAm.play(this.lAj).with(this.lAk);
    }

    public void cxY() {
        Z(false, false);
    }

    public void cxZ() {
        Z(false, true);
    }

    public void Z(boolean z, boolean z2) {
        if (this.lAo != null && this.lAo.getY() == 0.0f && !cyc()) {
            if (z2) {
                this.lAo.setVisibility(8);
                if (this.lAt) {
                    cI(false);
                    return;
                } else {
                    cI(true);
                    return;
                }
            }
            this.lAo.setVisibility(0);
            if (this.lAn == null) {
                dmu();
            }
            if (this.lAn != null) {
                this.lAn.cancel();
                this.lAn.setDuration(300L).start();
            }
        }
    }

    public void cya() {
        if (this.lAo != null && this.lAo.getY() < 0.0f && !cyc()) {
            this.lAo.setVisibility(0);
            if (this.lAm == null) {
                dmv();
            }
            if (this.lAm != null) {
                this.lAm.cancel();
                this.lAm.setDuration(300L).start();
            }
        }
    }

    public void bBr() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bBs() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cyb() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cyc() {
        return (this.lAm != null && this.lAm.isRunning()) || (this.lAn != null && this.lAn.isRunning());
    }

    public void hideFloatingView() {
        if (this.iGl) {
            if (this.feP) {
                cI(true);
            } else if (this.lAo != null && !this.lAs && !this.lwA && dmw()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bBs();
            }
        }
    }

    public void showFloatingView() {
        if (this.iGl) {
            if (this.feP) {
                cI(true);
            } else if (this.lAo != null && !dmw()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bBr();
            }
        }
    }

    public boolean dmw() {
        return this.lAo.getVisibility() == 0 && this.lAo.getY() >= 0.0f;
    }

    public void uU(boolean z) {
        this.lAs = z;
    }

    public void uV(boolean z) {
        this.lwA = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iGl && this.lAo != null && !this.lAs && !this.lwA && this.lAr) {
            if (i > this.ftg && dmw()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.ftg && !dmw()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.ftg = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.lAr = true;
        } else if (i == 0) {
            this.lAr = false;
        }
        if (this.iGl && !this.lAs && !this.lwA) {
            if (this.feP) {
                cI(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.ftg) {
                    bBs();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.ftg) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bBr();
                } else if (firstVisiblePosition == this.ftg) {
                    if (firstVisiblePosition == 0 || !this.fth || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bBr();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bBs();
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

    private void QR() {
        if (this.bxQ != null) {
            if (this.bxR && this.bxQ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bxQ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bxQ.setLayoutParams(layoutParams);
                cI(true);
                return;
            }
            cI(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(boolean z) {
        if (this.bxQ != null) {
            if (this.bxR && z && this.bxQ.getVisibility() != 0) {
                this.bxQ.setVisibility(0);
            } else if (!z && this.bxQ.getVisibility() != 8) {
                this.bxQ.setVisibility(8);
            }
        }
    }
}
