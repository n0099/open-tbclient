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
    private View Ha;
    private View ceZ;
    private a eJh;
    private Animator eVf;
    private Animator eVg;
    private ValueAnimator eVh;
    private ValueAnimator eVi;
    private AnimatorSet eVj;
    private AnimatorSet eVk;
    private View eVl;
    private View eVm;
    private Context mContext;
    private int eVn = UtilHelper.getLightStatusBarHeight();
    private boolean eVo = false;
    private boolean awy = false;
    private int aMu = 0;
    private boolean eVp = false;
    private boolean eVq = false;
    private boolean aMv = false;
    private boolean cfb = true;
    private final Handler.Callback cfc = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.adU()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.adT();
                    return true;
                case 2:
                    b.this.adR();
                    return true;
                case 3:
                    b.this.adS();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cfc);
    private boolean cfa = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void eu(boolean z);
    }

    public void a(a aVar) {
        this.eJh = aVar;
    }

    public void es(boolean z) {
        this.aMv = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.mContext = context;
        this.eVl = view;
        this.ceZ = view2;
        this.Ha = view3;
        this.eVm = this.Ha.findViewById(d.h.sticky_view);
        adV();
        et(false);
    }

    private void adP() {
        this.eVf = ObjectAnimator.ofFloat(this.eVl, "translationY", (-this.eVl.getMeasuredHeight()) + this.Ha.getMeasuredHeight());
        this.eVf.setInterpolator(new LinearInterpolator());
        this.eVf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eVl != null) {
                    b.this.eVl.clearAnimation();
                    if (b.this.eVq) {
                        b.this.et(false);
                    } else {
                        b.this.et(true);
                    }
                    if (b.this.eJh != null) {
                        b.this.eJh.eu(false);
                    }
                    b.this.Ha.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eVi = ValueAnimator.ofInt(0, this.eVn);
        this.eVi.setInterpolator(new LinearInterpolator());
        this.eVi.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eVm.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eVm.setLayoutParams(layoutParams);
                }
                b.this.eVm.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eVm.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eVn;
                    b.this.eVm.setLayoutParams(layoutParams);
                }
                b.this.eVm.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eVi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eVm.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eVm.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eVk = new AnimatorSet();
        this.eVk.play(this.eVf).with(this.eVi);
    }

    private void adQ() {
        this.eVg = ObjectAnimator.ofFloat(this.eVl, "translationY", 0.0f);
        this.eVg.setInterpolator(new LinearInterpolator());
        this.eVg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eVl != null) {
                    b.this.eVl.clearAnimation();
                    b.this.eVl.setVisibility(0);
                    b.this.et(false);
                    if (b.this.eJh != null) {
                        b.this.eJh.eu(true);
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
        this.eVh = ValueAnimator.ofInt(this.eVn, 0);
        this.eVh.setInterpolator(new LinearInterpolator());
        this.eVh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.eVm.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.eVm.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eVn;
                    b.this.eVm.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.eVm.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.eVm.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eVm.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eVh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eVm.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eVm.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eVj = new AnimatorSet();
        this.eVj.play(this.eVg).with(this.eVh);
    }

    public void adR() {
        r(false, false);
    }

    public void adS() {
        r(false, true);
    }

    public void r(boolean z, boolean z2) {
        if (this.eVl != null && this.eVl.getY() == 0.0f && !adU()) {
            if (z2) {
                this.eVl.setVisibility(8);
                if (this.eVq) {
                    et(false);
                    return;
                } else {
                    et(true);
                    return;
                }
            }
            this.eVl.setVisibility(0);
            if (this.eVk == null) {
                adP();
            }
            if (this.eVk != null) {
                this.eVk.cancel();
                this.eVk.setDuration(300L).start();
            }
        }
    }

    public void adT() {
        if (this.eVl != null && this.eVl.getY() < 0.0f && !adU()) {
            this.eVl.setVisibility(0);
            if (this.eVj == null) {
                adQ();
            }
            if (this.eVj != null) {
                this.eVj.cancel();
                this.eVj.setDuration(300L).start();
            }
        }
    }

    public void Hl() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hn() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean adU() {
        return (this.eVj != null && this.eVj.isRunning()) || (this.eVk != null && this.eVk.isRunning());
    }

    public void hideFloatingView() {
        if (this.cfb) {
            if (this.awy) {
                et(true);
            } else if (this.eVl != null && !this.eVp && aUy()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Hm();
            }
        }
    }

    public void showFloatingView() {
        if (this.cfb) {
            if (this.awy) {
                et(true);
            } else if (this.eVl != null && !aUy()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Hl();
            }
        }
    }

    private boolean aUy() {
        return this.eVl.getVisibility() == 0 && this.eVl.getY() >= 0.0f;
    }

    public void jU(boolean z) {
        this.eVp = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cfb && this.eVl != null && !this.eVp && this.eVo) {
            if (i > this.aMu && aUy()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aMu && !aUy()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aMu = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.eVo = true;
        } else if (i == 0) {
            this.eVo = false;
        }
        if (this.cfb && !this.eVp) {
            if (this.awy) {
                et(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMu) {
                    Hm();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aMu) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Hl();
                } else if (firstVisiblePosition == this.aMu) {
                    if (firstVisiblePosition == 0 || !this.aMv || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Hl();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Hm();
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

    private void adV() {
        if (this.ceZ != null) {
            if (this.cfa && this.ceZ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.ceZ.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.ceZ.setLayoutParams(layoutParams);
                et(true);
                return;
            }
            et(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void et(boolean z) {
        if (this.ceZ != null) {
            if (this.cfa && z && this.ceZ.getVisibility() != 0) {
                this.ceZ.setVisibility(0);
            } else if (!z && this.ceZ.getVisibility() != 8) {
                this.ceZ.setVisibility(8);
            }
        }
    }
}
