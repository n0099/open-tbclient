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
/* loaded from: classes16.dex */
public class b {
    private View boC;
    private a kEq;
    private Animator kPI;
    private Animator kPJ;
    private ValueAnimator kPK;
    private ValueAnimator kPL;
    private AnimatorSet kPM;
    private AnimatorSet kPN;
    private View kPO;
    private View kPP;
    private View mExpandView;
    private int kPQ = UtilHelper.getLightStatusBarHeight();
    private boolean kPR = false;
    private boolean eIb = false;
    private int eVA = 0;
    private boolean kPS = false;
    private boolean kMd = false;
    private boolean kPT = false;
    private boolean eVB = false;
    private boolean hXI = true;
    private final Handler.Callback hXL = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.coj()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.coh();
                    return true;
                case 2:
                    b.this.cof();
                    return true;
                case 3:
                    b.this.cog();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.hXL);
    private boolean boD = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes16.dex */
    public interface a {
        void sZ(boolean z);
    }

    public void a(a aVar) {
        this.kEq = aVar;
    }

    public void oz(boolean z) {
        this.eVB = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.kPO = view;
        this.boC = view2;
        this.mExpandView = view3;
        this.kPP = this.mExpandView.findViewById(R.id.sticky_view);
        Oo();
        cx(false);
    }

    private void dbZ() {
        this.kPI = ObjectAnimator.ofFloat(this.kPO, "translationY", (-this.kPO.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.kPI.setInterpolator(new LinearInterpolator());
        this.kPI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kPO != null) {
                    b.this.kPO.clearAnimation();
                    if (b.this.kPT) {
                        b.this.cx(false);
                    } else {
                        b.this.cx(true);
                    }
                    if (b.this.kEq != null) {
                        b.this.kEq.sZ(false);
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
        this.kPL = ValueAnimator.ofInt(0, this.kPQ);
        this.kPL.setInterpolator(new LinearInterpolator());
        this.kPL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kPP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kPP.setLayoutParams(layoutParams);
                }
                b.this.kPP.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kPP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kPQ;
                    b.this.kPP.setLayoutParams(layoutParams);
                }
                b.this.kPP.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kPL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kPP.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kPP.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kPN = new AnimatorSet();
        this.kPN.play(this.kPI).with(this.kPL);
    }

    private void dca() {
        this.kPJ = ObjectAnimator.ofFloat(this.kPO, "translationY", 0.0f);
        this.kPJ.setInterpolator(new LinearInterpolator());
        this.kPJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kPO != null) {
                    b.this.kPO.clearAnimation();
                    b.this.kPO.setVisibility(0);
                    b.this.cx(false);
                    if (b.this.kEq != null) {
                        b.this.kEq.sZ(true);
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
        this.kPK = ValueAnimator.ofInt(this.kPQ, 0);
        this.kPK.setInterpolator(new LinearInterpolator());
        this.kPK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.kPP.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.kPP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kPQ;
                    b.this.kPP.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.kPP.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.kPP.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kPP.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kPK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kPP.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kPP.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kPM = new AnimatorSet();
        this.kPM.play(this.kPJ).with(this.kPK);
    }

    public void cof() {
        V(false, false);
    }

    public void cog() {
        V(false, true);
    }

    public void V(boolean z, boolean z2) {
        if (this.kPO != null && this.kPO.getY() == 0.0f && !coj()) {
            if (z2) {
                this.kPO.setVisibility(8);
                if (this.kPT) {
                    cx(false);
                    return;
                } else {
                    cx(true);
                    return;
                }
            }
            this.kPO.setVisibility(0);
            if (this.kPN == null) {
                dbZ();
            }
            if (this.kPN != null) {
                this.kPN.cancel();
                this.kPN.setDuration(300L).start();
            }
        }
    }

    public void coh() {
        if (this.kPO != null && this.kPO.getY() < 0.0f && !coj()) {
            this.kPO.setVisibility(0);
            if (this.kPM == null) {
                dca();
            }
            if (this.kPM != null) {
                this.kPM.cancel();
                this.kPM.setDuration(300L).start();
            }
        }
    }

    public void bvE() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bvF() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void coi() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean coj() {
        return (this.kPM != null && this.kPM.isRunning()) || (this.kPN != null && this.kPN.isRunning());
    }

    public void hideFloatingView() {
        if (this.hXI) {
            if (this.eIb) {
                cx(true);
            } else if (this.kPO != null && !this.kPS && !this.kMd && dcb()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bvF();
            }
        }
    }

    public void showFloatingView() {
        if (this.hXI) {
            if (this.eIb) {
                cx(true);
            } else if (this.kPO != null && !dcb()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bvE();
            }
        }
    }

    public boolean dcb() {
        return this.kPO.getVisibility() == 0 && this.kPO.getY() >= 0.0f;
    }

    public void tN(boolean z) {
        this.kPS = z;
    }

    public void tO(boolean z) {
        this.kMd = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.hXI && this.kPO != null && !this.kPS && !this.kMd && this.kPR) {
            if (i > this.eVA && dcb()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.eVA && !dcb()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.eVA = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kPR = true;
        } else if (i == 0) {
            this.kPR = false;
        }
        if (this.hXI && !this.kPS && !this.kMd) {
            if (this.eIb) {
                cx(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.eVA) {
                    bvF();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.eVA) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bvE();
                } else if (firstVisiblePosition == this.eVA) {
                    if (firstVisiblePosition == 0 || !this.eVB || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bvE();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bvF();
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

    private void Oo() {
        if (this.boC != null) {
            if (this.boD && this.boC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.boC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.boC.setLayoutParams(layoutParams);
                cx(true);
                return;
            }
            cx(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cx(boolean z) {
        if (this.boC != null) {
            if (this.boD && z && this.boC.getVisibility() != 0) {
                this.boC.setVisibility(0);
            } else if (!z && this.boC.getVisibility() != 8) {
                this.boC.setVisibility(8);
            }
        }
    }
}
