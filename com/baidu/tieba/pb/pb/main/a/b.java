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
/* loaded from: classes2.dex */
public class b {
    private View Fq;
    private View cZd;
    private a ffF;
    private Animator fsm;
    private Animator fsn;
    private ValueAnimator fso;
    private ValueAnimator fsp;
    private AnimatorSet fsq;
    private AnimatorSet fsr;
    private View fss;
    private View fst;
    private int fsu = UtilHelper.getLightStatusBarHeight();
    private boolean fsv = false;
    private boolean azI = false;
    private int aNH = 0;
    private boolean fsw = false;
    private boolean fpW = false;
    private boolean fsx = false;
    private boolean aNI = false;
    private boolean dal = true;
    private final Handler.Callback dan = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aqO()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aqN();
                    return true;
                case 2:
                    b.this.aqL();
                    return true;
                case 3:
                    b.this.aqM();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dan);
    private boolean dak = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jC(boolean z);
    }

    public void a(a aVar) {
        this.ffF = aVar;
    }

    public void fB(boolean z) {
        this.aNI = z;
    }

    public b(Context context, View view2, View view3, View view4) {
        this.fss = view2;
        this.cZd = view3;
        this.Fq = view4;
        this.fst = this.Fq.findViewById(d.g.sticky_view);
        Qd();
        fD(false);
    }

    private void baY() {
        this.fsm = ObjectAnimator.ofFloat(this.fss, "translationY", (-this.fss.getMeasuredHeight()) + this.Fq.getMeasuredHeight());
        this.fsm.setInterpolator(new LinearInterpolator());
        this.fsm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fss != null) {
                    b.this.fss.clearAnimation();
                    if (b.this.fsx) {
                        b.this.fD(false);
                    } else {
                        b.this.fD(true);
                    }
                    if (b.this.ffF != null) {
                        b.this.ffF.jC(false);
                    }
                    b.this.Fq.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fsp = ValueAnimator.ofInt(0, this.fsu);
        this.fsp.setInterpolator(new LinearInterpolator());
        this.fsp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fst.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fst.setLayoutParams(layoutParams);
                }
                b.this.fst.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fst.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fsu;
                    b.this.fst.setLayoutParams(layoutParams);
                }
                b.this.fst.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fsp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fst.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fst.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fsr = new AnimatorSet();
        this.fsr.play(this.fsm).with(this.fsp);
    }

    private void baZ() {
        this.fsn = ObjectAnimator.ofFloat(this.fss, "translationY", 0.0f);
        this.fsn.setInterpolator(new LinearInterpolator());
        this.fsn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fss != null) {
                    b.this.fss.clearAnimation();
                    b.this.fss.setVisibility(0);
                    b.this.fD(false);
                    if (b.this.ffF != null) {
                        b.this.ffF.jC(true);
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
        this.fso = ValueAnimator.ofInt(this.fsu, 0);
        this.fso.setInterpolator(new LinearInterpolator());
        this.fso.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fst.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fst.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fsu;
                    b.this.fst.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fst.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fst.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fst.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fso.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fst.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fst.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fsq = new AnimatorSet();
        this.fsq.play(this.fsn).with(this.fso);
    }

    public void aqL() {
        v(false, false);
    }

    public void aqM() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.fss != null && this.fss.getY() == 0.0f && !aqO()) {
            if (z2) {
                this.fss.setVisibility(8);
                if (this.fsx) {
                    fD(false);
                    return;
                } else {
                    fD(true);
                    return;
                }
            }
            this.fss.setVisibility(0);
            if (this.fsr == null) {
                baY();
            }
            if (this.fsr != null) {
                this.fsr.cancel();
                this.fsr.setDuration(300L).start();
            }
        }
    }

    public void aqN() {
        if (this.fss != null && this.fss.getY() < 0.0f && !aqO()) {
            this.fss.setVisibility(0);
            if (this.fsq == null) {
                baZ();
            }
            if (this.fsq != null) {
                this.fsq.cancel();
                this.fsq.setDuration(300L).start();
            }
        }
    }

    public void HK() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void HL() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void HM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aqO() {
        return (this.fsq != null && this.fsq.isRunning()) || (this.fsr != null && this.fsr.isRunning());
    }

    public void hideFloatingView() {
        if (this.dal) {
            if (this.azI) {
                fD(true);
            } else if (this.fss != null && !this.fsw && !this.fpW && bba()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                HL();
            }
        }
    }

    public void showFloatingView() {
        if (this.dal) {
            if (this.azI) {
                fD(true);
            } else if (this.fss != null && !bba()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                HK();
            }
        }
    }

    public boolean bba() {
        return this.fss.getVisibility() == 0 && this.fss.getY() >= 0.0f;
    }

    public void kv(boolean z) {
        this.fsw = z;
    }

    public void kw(boolean z) {
        this.fpW = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dal && this.fss != null && !this.fsw && !this.fpW && this.fsv) {
            if (i > this.aNH && bba()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aNH && !bba()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aNH = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fsv = true;
        } else if (i == 0) {
            this.fsv = false;
        }
        if (this.dal && !this.fsw && !this.fpW) {
            if (this.azI) {
                fD(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aNH) {
                    HL();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aNH) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    HK();
                } else if (firstVisiblePosition == this.aNH) {
                    if (firstVisiblePosition == 0 || !this.aNI || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        HK();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    HL();
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

    private void Qd() {
        if (this.cZd != null) {
            if (this.dak && this.cZd.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cZd.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cZd.setLayoutParams(layoutParams);
                fD(true);
                return;
            }
            fD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(boolean z) {
        if (this.cZd != null) {
            if (this.dak && z && this.cZd.getVisibility() != 0) {
                this.cZd.setVisibility(0);
            } else if (!z && this.cZd.getVisibility() != 8) {
                this.cZd.setVisibility(8);
            }
        }
    }
}
