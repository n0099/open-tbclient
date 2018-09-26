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
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class b {
    private View NU;
    private View dus;
    private a fEa;
    private Animator fQA;
    private ValueAnimator fQB;
    private ValueAnimator fQC;
    private AnimatorSet fQD;
    private AnimatorSet fQE;
    private View fQF;
    private View fQG;
    private Animator fQz;
    private int fQH = UtilHelper.getLightStatusBarHeight();
    private boolean fQI = false;
    private boolean aMv = false;
    private int aZU = 0;
    private boolean fQJ = false;
    private boolean fOb = false;
    private boolean fQK = false;
    private boolean aZV = false;
    private boolean dvV = true;
    private final Handler.Callback dvX = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.ayb()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aya();
                    return true;
                case 2:
                    b.this.axY();
                    return true;
                case 3:
                    b.this.axZ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dvX);
    private boolean dvU = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void kg(boolean z);
    }

    public void a(a aVar) {
        this.fEa = aVar;
    }

    public void gk(boolean z) {
        this.aZV = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fQF = view;
        this.dus = view2;
        this.NU = view3;
        this.fQG = this.NU.findViewById(e.g.sticky_view);
        VQ();
        gm(false);
    }

    private void bhx() {
        this.fQz = ObjectAnimator.ofFloat(this.fQF, "translationY", (-this.fQF.getMeasuredHeight()) + this.NU.getMeasuredHeight());
        this.fQz.setInterpolator(new LinearInterpolator());
        this.fQz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fQF != null) {
                    b.this.fQF.clearAnimation();
                    if (b.this.fQK) {
                        b.this.gm(false);
                    } else {
                        b.this.gm(true);
                    }
                    if (b.this.fEa != null) {
                        b.this.fEa.kg(false);
                    }
                    b.this.NU.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fQC = ValueAnimator.ofInt(0, this.fQH);
        this.fQC.setInterpolator(new LinearInterpolator());
        this.fQC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fQG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fQG.setLayoutParams(layoutParams);
                }
                b.this.fQG.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fQG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fQH;
                    b.this.fQG.setLayoutParams(layoutParams);
                }
                b.this.fQG.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fQC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fQG.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fQG.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fQE = new AnimatorSet();
        this.fQE.play(this.fQz).with(this.fQC);
    }

    private void bhy() {
        this.fQA = ObjectAnimator.ofFloat(this.fQF, "translationY", 0.0f);
        this.fQA.setInterpolator(new LinearInterpolator());
        this.fQA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fQF != null) {
                    b.this.fQF.clearAnimation();
                    b.this.fQF.setVisibility(0);
                    b.this.gm(false);
                    if (b.this.fEa != null) {
                        b.this.fEa.kg(true);
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
        this.fQB = ValueAnimator.ofInt(this.fQH, 0);
        this.fQB.setInterpolator(new LinearInterpolator());
        this.fQB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fQG.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fQG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fQH;
                    b.this.fQG.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fQG.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fQG.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fQG.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fQB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fQG.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fQG.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fQD = new AnimatorSet();
        this.fQD.play(this.fQA).with(this.fQB);
    }

    public void axY() {
        z(false, false);
    }

    public void axZ() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.fQF != null && this.fQF.getY() == 0.0f && !ayb()) {
            if (z2) {
                this.fQF.setVisibility(8);
                if (this.fQK) {
                    gm(false);
                    return;
                } else {
                    gm(true);
                    return;
                }
            }
            this.fQF.setVisibility(0);
            if (this.fQE == null) {
                bhx();
            }
            if (this.fQE != null) {
                this.fQE.cancel();
                this.fQE.setDuration(300L).start();
            }
        }
    }

    public void aya() {
        if (this.fQF != null && this.fQF.getY() < 0.0f && !ayb()) {
            this.fQF.setVisibility(0);
            if (this.fQD == null) {
                bhy();
            }
            if (this.fQD != null) {
                this.fQD.cancel();
                this.fQD.setDuration(300L).start();
            }
        }
    }

    public void MN() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void MO() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void MP() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean ayb() {
        return (this.fQD != null && this.fQD.isRunning()) || (this.fQE != null && this.fQE.isRunning());
    }

    public void hideFloatingView() {
        if (this.dvV) {
            if (this.aMv) {
                gm(true);
            } else if (this.fQF != null && !this.fQJ && !this.fOb && bhz()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                MO();
            }
        }
    }

    public void showFloatingView() {
        if (this.dvV) {
            if (this.aMv) {
                gm(true);
            } else if (this.fQF != null && !bhz()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                MN();
            }
        }
    }

    public boolean bhz() {
        return this.fQF.getVisibility() == 0 && this.fQF.getY() >= 0.0f;
    }

    public void kW(boolean z) {
        this.fQJ = z;
    }

    public void kX(boolean z) {
        this.fOb = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dvV && this.fQF != null && !this.fQJ && !this.fOb && this.fQI) {
            if (i > this.aZU && bhz()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aZU && !bhz()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aZU = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fQI = true;
        } else if (i == 0) {
            this.fQI = false;
        }
        if (this.dvV && !this.fQJ && !this.fOb) {
            if (this.aMv) {
                gm(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aZU) {
                    MO();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aZU) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    MN();
                } else if (firstVisiblePosition == this.aZU) {
                    if (firstVisiblePosition == 0 || !this.aZV || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        MN();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    MO();
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

    private void VQ() {
        if (this.dus != null) {
            if (this.dvU && this.dus.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dus.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dus.setLayoutParams(layoutParams);
                gm(true);
                return;
            }
            gm(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(boolean z) {
        if (this.dus != null) {
            if (this.dvU && z && this.dus.getVisibility() != 0) {
                this.dus.setVisibility(0);
            } else if (!z && this.dus.getVisibility() != 8) {
                this.dus.setVisibility(8);
            }
        }
    }
}
