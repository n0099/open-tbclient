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
    private View biD;
    private a kgh;
    private Animator krd;
    private Animator kre;
    private ValueAnimator krf;
    private ValueAnimator krg;
    private AnimatorSet krh;
    private AnimatorSet kri;
    private View krj;
    private View krk;
    private View mExpandView;
    private int krl = UtilHelper.getLightStatusBarHeight();
    private boolean krm = false;
    private boolean eri = false;
    private int eEz = 0;
    private boolean krn = false;
    private boolean knz = false;
    private boolean kro = false;
    private boolean eEA = false;
    private boolean hEk = true;
    private final Handler.Callback hEn = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cal()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cak();
                    return true;
                case 2:
                    b.this.cai();
                    return true;
                case 3:
                    b.this.caj();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hEn);
    private boolean biE = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void rM(boolean z);
    }

    public void a(a aVar) {
        this.kgh = aVar;
    }

    public void nq(boolean z) {
        this.eEA = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.krj = view;
        this.biD = view2;
        this.mExpandView = view3;
        this.krk = this.mExpandView.findViewById(R.id.sticky_view);
        Ip();
        cm(false);
    }

    private void cNv() {
        this.krd = ObjectAnimator.ofFloat(this.krj, "translationY", (-this.krj.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.krd.setInterpolator(new LinearInterpolator());
        this.krd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.krj != null) {
                    b.this.krj.clearAnimation();
                    if (b.this.kro) {
                        b.this.cm(false);
                    } else {
                        b.this.cm(true);
                    }
                    if (b.this.kgh != null) {
                        b.this.kgh.rM(false);
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
        this.krg = ValueAnimator.ofInt(0, this.krl);
        this.krg.setInterpolator(new LinearInterpolator());
        this.krg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.krk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.krk.setLayoutParams(layoutParams);
                }
                b.this.krk.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.krk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.krl;
                    b.this.krk.setLayoutParams(layoutParams);
                }
                b.this.krk.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.krg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.krk.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.krk.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kri = new AnimatorSet();
        this.kri.play(this.krd).with(this.krg);
    }

    private void cNw() {
        this.kre = ObjectAnimator.ofFloat(this.krj, "translationY", 0.0f);
        this.kre.setInterpolator(new LinearInterpolator());
        this.kre.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.krj != null) {
                    b.this.krj.clearAnimation();
                    b.this.krj.setVisibility(0);
                    b.this.cm(false);
                    if (b.this.kgh != null) {
                        b.this.kgh.rM(true);
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
        this.krf = ValueAnimator.ofInt(this.krl, 0);
        this.krf.setInterpolator(new LinearInterpolator());
        this.krf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.krk.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.krk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.krl;
                    b.this.krk.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.krk.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.krk.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.krk.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.krf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.krk.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.krk.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.krh = new AnimatorSet();
        this.krh.play(this.kre).with(this.krf);
    }

    public void cai() {
        Q(false, false);
    }

    public void caj() {
        Q(false, true);
    }

    public void Q(boolean z, boolean z2) {
        if (this.krj != null && this.krj.getY() == 0.0f && !cal()) {
            if (z2) {
                this.krj.setVisibility(8);
                if (this.kro) {
                    cm(false);
                    return;
                } else {
                    cm(true);
                    return;
                }
            }
            this.krj.setVisibility(0);
            if (this.kri == null) {
                cNv();
            }
            if (this.kri != null) {
                this.kri.cancel();
                this.kri.setDuration(300L).start();
            }
        }
    }

    public void cak() {
        if (this.krj != null && this.krj.getY() < 0.0f && !cal()) {
            this.krj.setVisibility(0);
            if (this.krh == null) {
                cNw();
            }
            if (this.krh != null) {
                this.krh.cancel();
                this.krh.setDuration(300L).start();
            }
        }
    }

    public void biX() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void biY() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void bnE() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cal() {
        return (this.krh != null && this.krh.isRunning()) || (this.kri != null && this.kri.isRunning());
    }

    public void hideFloatingView() {
        if (this.hEk) {
            if (this.eri) {
                cm(true);
            } else if (this.krj != null && !this.krn && !this.knz && cNx()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                biY();
            }
        }
    }

    public void showFloatingView() {
        if (this.hEk) {
            if (this.eri) {
                cm(true);
            } else if (this.krj != null && !cNx()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                biX();
            }
        }
    }

    public boolean cNx() {
        return this.krj.getVisibility() == 0 && this.krj.getY() >= 0.0f;
    }

    public void sy(boolean z) {
        this.krn = z;
    }

    public void sz(boolean z) {
        this.knz = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hEk && this.krj != null && !this.krn && !this.knz && this.krm) {
            if (i > this.eEz && cNx()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.eEz && !cNx()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.eEz = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.krm = true;
        } else if (i == 0) {
            this.krm = false;
        }
        if (this.hEk && !this.krn && !this.knz) {
            if (this.eri) {
                cm(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.eEz) {
                    biY();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.eEz) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    biX();
                } else if (firstVisiblePosition == this.eEz) {
                    if (firstVisiblePosition == 0 || !this.eEA || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        biX();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    biY();
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

    private void Ip() {
        if (this.biD != null) {
            if (this.biE && this.biD.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.biD.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.biD.setLayoutParams(layoutParams);
                cm(true);
                return;
            }
            cm(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cm(boolean z) {
        if (this.biD != null) {
            if (this.biE && z && this.biD.getVisibility() != 0) {
                this.biD.setVisibility(0);
            } else if (!z && this.biD.getVisibility() != 8) {
                this.biD.setVisibility(8);
            }
        }
    }
}
