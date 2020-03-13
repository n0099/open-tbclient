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
    private View aCc;
    private a iIG;
    private Animator iSU;
    private Animator iSV;
    private ValueAnimator iSW;
    private ValueAnimator iSX;
    private AnimatorSet iSY;
    private AnimatorSet iSZ;
    private View iTa;
    private View iTb;
    private View mExpandView;
    private int iTc = UtilHelper.getLightStatusBarHeight();
    private boolean iTd = false;
    private boolean duc = false;
    private int dGZ = 0;
    private boolean iTe = false;
    private boolean iPt = false;
    private boolean iTf = false;
    private boolean dHa = false;
    private boolean gsz = true;
    private final Handler.Callback gsC = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bFQ()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bFP();
                    return true;
                case 2:
                    b.this.bFN();
                    return true;
                case 3:
                    b.this.bFO();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gsC);
    private boolean aCd = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes9.dex */
    public interface a {
        void pQ(boolean z);
    }

    public void a(a aVar) {
        this.iIG = aVar;
    }

    public void lC(boolean z) {
        this.dHa = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.iTa = view;
        this.aCc = view2;
        this.mExpandView = view3;
        this.iTb = this.mExpandView.findViewById(R.id.sticky_view);
        Ah();
        bs(false);
    }

    private void cqS() {
        this.iSU = ObjectAnimator.ofFloat(this.iTa, "translationY", (-this.iTa.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.iSU.setInterpolator(new LinearInterpolator());
        this.iSU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iTa != null) {
                    b.this.iTa.clearAnimation();
                    if (b.this.iTf) {
                        b.this.bs(false);
                    } else {
                        b.this.bs(true);
                    }
                    if (b.this.iIG != null) {
                        b.this.iIG.pQ(false);
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
        this.iSX = ValueAnimator.ofInt(0, this.iTc);
        this.iSX.setInterpolator(new LinearInterpolator());
        this.iSX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iTb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iTb.setLayoutParams(layoutParams);
                }
                b.this.iTb.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iTb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iTc;
                    b.this.iTb.setLayoutParams(layoutParams);
                }
                b.this.iTb.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iSX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iTb.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iTb.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iSZ = new AnimatorSet();
        this.iSZ.play(this.iSU).with(this.iSX);
    }

    private void cqT() {
        this.iSV = ObjectAnimator.ofFloat(this.iTa, "translationY", 0.0f);
        this.iSV.setInterpolator(new LinearInterpolator());
        this.iSV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iTa != null) {
                    b.this.iTa.clearAnimation();
                    b.this.iTa.setVisibility(0);
                    b.this.bs(false);
                    if (b.this.iIG != null) {
                        b.this.iIG.pQ(true);
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
        this.iSW = ValueAnimator.ofInt(this.iTc, 0);
        this.iSW.setInterpolator(new LinearInterpolator());
        this.iSW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.iTb.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.iTb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iTc;
                    b.this.iTb.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.iTb.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.iTb.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iTb.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iSW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iTb.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iTb.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iSY = new AnimatorSet();
        this.iSY.play(this.iSV).with(this.iSW);
    }

    public void bFN() {
        N(false, false);
    }

    public void bFO() {
        N(false, true);
    }

    public void N(boolean z, boolean z2) {
        if (this.iTa != null && this.iTa.getY() == 0.0f && !bFQ()) {
            if (z2) {
                this.iTa.setVisibility(8);
                if (this.iTf) {
                    bs(false);
                    return;
                } else {
                    bs(true);
                    return;
                }
            }
            this.iTa.setVisibility(0);
            if (this.iSZ == null) {
                cqS();
            }
            if (this.iSZ != null) {
                this.iSZ.cancel();
                this.iSZ.setDuration(300L).start();
            }
        }
    }

    public void bFP() {
        if (this.iTa != null && this.iTa.getY() < 0.0f && !bFQ()) {
            this.iTa.setVisibility(0);
            if (this.iSY == null) {
                cqT();
            }
            if (this.iSY != null) {
                this.iSY.cancel();
                this.iSY.setDuration(300L).start();
            }
        }
    }

    public void aSn() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aSo() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aWJ() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bFQ() {
        return (this.iSY != null && this.iSY.isRunning()) || (this.iSZ != null && this.iSZ.isRunning());
    }

    public void hideFloatingView() {
        if (this.gsz) {
            if (this.duc) {
                bs(true);
            } else if (this.iTa != null && !this.iTe && !this.iPt && cqU()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aSo();
            }
        }
    }

    public void showFloatingView() {
        if (this.gsz) {
            if (this.duc) {
                bs(true);
            } else if (this.iTa != null && !cqU()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aSn();
            }
        }
    }

    public boolean cqU() {
        return this.iTa.getVisibility() == 0 && this.iTa.getY() >= 0.0f;
    }

    public void qB(boolean z) {
        this.iTe = z;
    }

    public void qC(boolean z) {
        this.iPt = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gsz && this.iTa != null && !this.iTe && !this.iPt && this.iTd) {
            if (i > this.dGZ && cqU()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.dGZ && !cqU()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.dGZ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.iTd = true;
        } else if (i == 0) {
            this.iTd = false;
        }
        if (this.gsz && !this.iTe && !this.iPt) {
            if (this.duc) {
                bs(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.dGZ) {
                    aSo();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.dGZ) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aSn();
                } else if (firstVisiblePosition == this.dGZ) {
                    if (firstVisiblePosition == 0 || !this.dHa || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aSn();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aSo();
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

    private void Ah() {
        if (this.aCc != null) {
            if (this.aCd && this.aCc.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.aCc.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.aCc.setLayoutParams(layoutParams);
                bs(true);
                return;
            }
            bs(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bs(boolean z) {
        if (this.aCc != null) {
            if (this.aCd && z && this.aCc.getVisibility() != 0) {
                this.aCc.setVisibility(0);
            } else if (!z && this.aCc.getVisibility() != 8) {
                this.aCc.setVisibility(8);
            }
        }
    }
}
