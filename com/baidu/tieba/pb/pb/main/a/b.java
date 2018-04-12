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
    private View cZg;
    private a ffI;
    private Animator fsp;
    private Animator fsq;
    private ValueAnimator fsr;
    private ValueAnimator fss;
    private AnimatorSet fst;
    private AnimatorSet fsu;
    private View fsv;
    private View fsw;
    private int fsx = UtilHelper.getLightStatusBarHeight();
    private boolean fsy = false;
    private boolean azI = false;
    private int aNH = 0;
    private boolean fsz = false;
    private boolean fpZ = false;
    private boolean fsA = false;
    private boolean aNI = false;
    private boolean dao = true;
    private final Handler.Callback daq = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
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
    private final Handler mHandler = new Handler(this.daq);
    private boolean dan = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jC(boolean z);
    }

    public void a(a aVar) {
        this.ffI = aVar;
    }

    public void fB(boolean z) {
        this.aNI = z;
    }

    public b(Context context, View view2, View view3, View view4) {
        this.fsv = view2;
        this.cZg = view3;
        this.Fq = view4;
        this.fsw = this.Fq.findViewById(d.g.sticky_view);
        Qd();
        fD(false);
    }

    private void baY() {
        this.fsp = ObjectAnimator.ofFloat(this.fsv, "translationY", (-this.fsv.getMeasuredHeight()) + this.Fq.getMeasuredHeight());
        this.fsp.setInterpolator(new LinearInterpolator());
        this.fsp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fsv != null) {
                    b.this.fsv.clearAnimation();
                    if (b.this.fsA) {
                        b.this.fD(false);
                    } else {
                        b.this.fD(true);
                    }
                    if (b.this.ffI != null) {
                        b.this.ffI.jC(false);
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
        this.fss = ValueAnimator.ofInt(0, this.fsx);
        this.fss.setInterpolator(new LinearInterpolator());
        this.fss.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fsw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fsw.setLayoutParams(layoutParams);
                }
                b.this.fsw.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fsw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fsx;
                    b.this.fsw.setLayoutParams(layoutParams);
                }
                b.this.fsw.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fss.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fsw.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fsw.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fsu = new AnimatorSet();
        this.fsu.play(this.fsp).with(this.fss);
    }

    private void baZ() {
        this.fsq = ObjectAnimator.ofFloat(this.fsv, "translationY", 0.0f);
        this.fsq.setInterpolator(new LinearInterpolator());
        this.fsq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fsv != null) {
                    b.this.fsv.clearAnimation();
                    b.this.fsv.setVisibility(0);
                    b.this.fD(false);
                    if (b.this.ffI != null) {
                        b.this.ffI.jC(true);
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
        this.fsr = ValueAnimator.ofInt(this.fsx, 0);
        this.fsr.setInterpolator(new LinearInterpolator());
        this.fsr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fsw.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fsw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fsx;
                    b.this.fsw.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fsw.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fsw.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fsw.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fsr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fsw.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fsw.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fst = new AnimatorSet();
        this.fst.play(this.fsq).with(this.fsr);
    }

    public void aqL() {
        v(false, false);
    }

    public void aqM() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.fsv != null && this.fsv.getY() == 0.0f && !aqO()) {
            if (z2) {
                this.fsv.setVisibility(8);
                if (this.fsA) {
                    fD(false);
                    return;
                } else {
                    fD(true);
                    return;
                }
            }
            this.fsv.setVisibility(0);
            if (this.fsu == null) {
                baY();
            }
            if (this.fsu != null) {
                this.fsu.cancel();
                this.fsu.setDuration(300L).start();
            }
        }
    }

    public void aqN() {
        if (this.fsv != null && this.fsv.getY() < 0.0f && !aqO()) {
            this.fsv.setVisibility(0);
            if (this.fst == null) {
                baZ();
            }
            if (this.fst != null) {
                this.fst.cancel();
                this.fst.setDuration(300L).start();
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
        return (this.fst != null && this.fst.isRunning()) || (this.fsu != null && this.fsu.isRunning());
    }

    public void hideFloatingView() {
        if (this.dao) {
            if (this.azI) {
                fD(true);
            } else if (this.fsv != null && !this.fsz && !this.fpZ && bba()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                HL();
            }
        }
    }

    public void showFloatingView() {
        if (this.dao) {
            if (this.azI) {
                fD(true);
            } else if (this.fsv != null && !bba()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                HK();
            }
        }
    }

    public boolean bba() {
        return this.fsv.getVisibility() == 0 && this.fsv.getY() >= 0.0f;
    }

    public void kv(boolean z) {
        this.fsz = z;
    }

    public void kw(boolean z) {
        this.fpZ = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dao && this.fsv != null && !this.fsz && !this.fpZ && this.fsy) {
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
            this.fsy = true;
        } else if (i == 0) {
            this.fsy = false;
        }
        if (this.dao && !this.fsz && !this.fpZ) {
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
        if (this.cZg != null) {
            if (this.dan && this.cZg.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cZg.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cZg.setLayoutParams(layoutParams);
                fD(true);
                return;
            }
            fD(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fD(boolean z) {
        if (this.cZg != null) {
            if (this.dan && z && this.cZg.getVisibility() != 0) {
                this.cZg.setVisibility(0);
            } else if (!z && this.cZg.getVisibility() != 8) {
                this.cZg.setVisibility(8);
            }
        }
    }
}
