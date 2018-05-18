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
    private View Fm;
    private View dak;
    private a fgM;
    private View ftA;
    private Animator ftt;
    private Animator ftu;
    private ValueAnimator ftv;
    private ValueAnimator ftw;
    private AnimatorSet ftx;
    private AnimatorSet fty;
    private View ftz;
    private int ftB = UtilHelper.getLightStatusBarHeight();
    private boolean ftC = false;
    private boolean azJ = false;
    private int aNI = 0;
    private boolean ftD = false;
    private boolean frd = false;
    private boolean ftE = false;
    private boolean aNJ = false;
    private boolean dbu = true;
    private final Handler.Callback dbw = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aqN()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aqM();
                    return true;
                case 2:
                    b.this.aqK();
                    return true;
                case 3:
                    b.this.aqL();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dbw);
    private boolean dbt = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jD(boolean z);
    }

    public void a(a aVar) {
        this.fgM = aVar;
    }

    public void fC(boolean z) {
        this.aNJ = z;
    }

    public b(Context context, View view2, View view3, View view4) {
        this.ftz = view2;
        this.dak = view3;
        this.Fm = view4;
        this.ftA = this.Fm.findViewById(d.g.sticky_view);
        Qa();
        fE(false);
    }

    private void baY() {
        this.ftt = ObjectAnimator.ofFloat(this.ftz, "translationY", (-this.ftz.getMeasuredHeight()) + this.Fm.getMeasuredHeight());
        this.ftt.setInterpolator(new LinearInterpolator());
        this.ftt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ftz != null) {
                    b.this.ftz.clearAnimation();
                    if (b.this.ftE) {
                        b.this.fE(false);
                    } else {
                        b.this.fE(true);
                    }
                    if (b.this.fgM != null) {
                        b.this.fgM.jD(false);
                    }
                    b.this.Fm.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ftw = ValueAnimator.ofInt(0, this.ftB);
        this.ftw.setInterpolator(new LinearInterpolator());
        this.ftw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ftA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ftA.setLayoutParams(layoutParams);
                }
                b.this.ftA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ftA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ftB;
                    b.this.ftA.setLayoutParams(layoutParams);
                }
                b.this.ftA.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ftw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ftA.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ftA.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fty = new AnimatorSet();
        this.fty.play(this.ftt).with(this.ftw);
    }

    private void baZ() {
        this.ftu = ObjectAnimator.ofFloat(this.ftz, "translationY", 0.0f);
        this.ftu.setInterpolator(new LinearInterpolator());
        this.ftu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ftz != null) {
                    b.this.ftz.clearAnimation();
                    b.this.ftz.setVisibility(0);
                    b.this.fE(false);
                    if (b.this.fgM != null) {
                        b.this.fgM.jD(true);
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
        this.ftv = ValueAnimator.ofInt(this.ftB, 0);
        this.ftv.setInterpolator(new LinearInterpolator());
        this.ftv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.ftA.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.ftA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ftB;
                    b.this.ftA.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ftA.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.ftA.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ftA.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ftv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ftA.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ftA.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.ftx = new AnimatorSet();
        this.ftx.play(this.ftu).with(this.ftv);
    }

    public void aqK() {
        v(false, false);
    }

    public void aqL() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.ftz != null && this.ftz.getY() == 0.0f && !aqN()) {
            if (z2) {
                this.ftz.setVisibility(8);
                if (this.ftE) {
                    fE(false);
                    return;
                } else {
                    fE(true);
                    return;
                }
            }
            this.ftz.setVisibility(0);
            if (this.fty == null) {
                baY();
            }
            if (this.fty != null) {
                this.fty.cancel();
                this.fty.setDuration(300L).start();
            }
        }
    }

    public void aqM() {
        if (this.ftz != null && this.ftz.getY() < 0.0f && !aqN()) {
            this.ftz.setVisibility(0);
            if (this.ftx == null) {
                baZ();
            }
            if (this.ftx != null) {
                this.ftx.cancel();
                this.ftx.setDuration(300L).start();
            }
        }
    }

    public void HI() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void HJ() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void HK() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aqN() {
        return (this.ftx != null && this.ftx.isRunning()) || (this.fty != null && this.fty.isRunning());
    }

    public void hideFloatingView() {
        if (this.dbu) {
            if (this.azJ) {
                fE(true);
            } else if (this.ftz != null && !this.ftD && !this.frd && bba()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                HJ();
            }
        }
    }

    public void showFloatingView() {
        if (this.dbu) {
            if (this.azJ) {
                fE(true);
            } else if (this.ftz != null && !bba()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                HI();
            }
        }
    }

    public boolean bba() {
        return this.ftz.getVisibility() == 0 && this.ftz.getY() >= 0.0f;
    }

    public void kw(boolean z) {
        this.ftD = z;
    }

    public void kx(boolean z) {
        this.frd = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dbu && this.ftz != null && !this.ftD && !this.frd && this.ftC) {
            if (i > this.aNI && bba()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aNI && !bba()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aNI = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.ftC = true;
        } else if (i == 0) {
            this.ftC = false;
        }
        if (this.dbu && !this.ftD && !this.frd) {
            if (this.azJ) {
                fE(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aNI) {
                    HJ();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aNI) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    HI();
                } else if (firstVisiblePosition == this.aNI) {
                    if (firstVisiblePosition == 0 || !this.aNJ || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        HI();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    HJ();
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

    private void Qa() {
        if (this.dak != null) {
            if (this.dbt && this.dak.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dak.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dak.setLayoutParams(layoutParams);
                fE(true);
                return;
            }
            fE(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fE(boolean z) {
        if (this.dak != null) {
            if (this.dbt && z && this.dak.getVisibility() != 0) {
                this.dak.setVisibility(0);
            } else if (!z && this.dak.getVisibility() != 8) {
                this.dak.setVisibility(8);
            }
        }
    }
}
