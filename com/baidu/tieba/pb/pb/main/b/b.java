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
/* loaded from: classes7.dex */
public class b {
    private View axK;
    private a iGP;
    private Animator iRl;
    private Animator iRm;
    private ValueAnimator iRn;
    private ValueAnimator iRo;
    private AnimatorSet iRp;
    private AnimatorSet iRq;
    private View iRr;
    private View iRs;
    private View mExpandView;
    private int iRt = UtilHelper.getLightStatusBarHeight();
    private boolean iRu = false;
    private boolean dpG = false;
    private int dCH = 0;
    private boolean iRv = false;
    private boolean iNK = false;
    private boolean iRw = false;
    private boolean dCI = false;
    private boolean gqj = true;
    private final Handler.Callback gqm = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bEl()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bEk();
                    return true;
                case 2:
                    b.this.bEi();
                    return true;
                case 3:
                    b.this.bEj();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gqm);
    private boolean axL = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes7.dex */
    public interface a {
        void pN(boolean z);
    }

    public void a(a aVar) {
        this.iGP = aVar;
    }

    public void lz(boolean z) {
        this.dCI = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.iRr = view;
        this.axK = view2;
        this.mExpandView = view3;
        this.iRs = this.mExpandView.findViewById(R.id.sticky_view);
        xO();
        bk(false);
    }

    private void cpw() {
        this.iRl = ObjectAnimator.ofFloat(this.iRr, "translationY", (-this.iRr.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.iRl.setInterpolator(new LinearInterpolator());
        this.iRl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iRr != null) {
                    b.this.iRr.clearAnimation();
                    if (b.this.iRw) {
                        b.this.bk(false);
                    } else {
                        b.this.bk(true);
                    }
                    if (b.this.iGP != null) {
                        b.this.iGP.pN(false);
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
        this.iRo = ValueAnimator.ofInt(0, this.iRt);
        this.iRo.setInterpolator(new LinearInterpolator());
        this.iRo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iRs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iRs.setLayoutParams(layoutParams);
                }
                b.this.iRs.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iRs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iRt;
                    b.this.iRs.setLayoutParams(layoutParams);
                }
                b.this.iRs.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iRo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iRs.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iRs.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iRq = new AnimatorSet();
        this.iRq.play(this.iRl).with(this.iRo);
    }

    private void cpx() {
        this.iRm = ObjectAnimator.ofFloat(this.iRr, "translationY", 0.0f);
        this.iRm.setInterpolator(new LinearInterpolator());
        this.iRm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iRr != null) {
                    b.this.iRr.clearAnimation();
                    b.this.iRr.setVisibility(0);
                    b.this.bk(false);
                    if (b.this.iGP != null) {
                        b.this.iGP.pN(true);
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
        this.iRn = ValueAnimator.ofInt(this.iRt, 0);
        this.iRn.setInterpolator(new LinearInterpolator());
        this.iRn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.iRs.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.iRs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iRt;
                    b.this.iRs.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.iRs.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.iRs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iRs.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iRn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iRs.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iRs.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iRp = new AnimatorSet();
        this.iRp.play(this.iRm).with(this.iRn);
    }

    public void bEi() {
        L(false, false);
    }

    public void bEj() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.iRr != null && this.iRr.getY() == 0.0f && !bEl()) {
            if (z2) {
                this.iRr.setVisibility(8);
                if (this.iRw) {
                    bk(false);
                    return;
                } else {
                    bk(true);
                    return;
                }
            }
            this.iRr.setVisibility(0);
            if (this.iRq == null) {
                cpw();
            }
            if (this.iRq != null) {
                this.iRq.cancel();
                this.iRq.setDuration(300L).start();
            }
        }
    }

    public void bEk() {
        if (this.iRr != null && this.iRr.getY() < 0.0f && !bEl()) {
            this.iRr.setVisibility(0);
            if (this.iRp == null) {
                cpx();
            }
            if (this.iRp != null) {
                this.iRp.cancel();
                this.iRp.setDuration(300L).start();
            }
        }
    }

    public void aPT() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aPU() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aUq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bEl() {
        return (this.iRp != null && this.iRp.isRunning()) || (this.iRq != null && this.iRq.isRunning());
    }

    public void hideFloatingView() {
        if (this.gqj) {
            if (this.dpG) {
                bk(true);
            } else if (this.iRr != null && !this.iRv && !this.iNK && cpy()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aPU();
            }
        }
    }

    public void showFloatingView() {
        if (this.gqj) {
            if (this.dpG) {
                bk(true);
            } else if (this.iRr != null && !cpy()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aPT();
            }
        }
    }

    public boolean cpy() {
        return this.iRr.getVisibility() == 0 && this.iRr.getY() >= 0.0f;
    }

    public void qy(boolean z) {
        this.iRv = z;
    }

    public void qz(boolean z) {
        this.iNK = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gqj && this.iRr != null && !this.iRv && !this.iNK && this.iRu) {
            if (i > this.dCH && cpy()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.dCH && !cpy()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.dCH = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.iRu = true;
        } else if (i == 0) {
            this.iRu = false;
        }
        if (this.gqj && !this.iRv && !this.iNK) {
            if (this.dpG) {
                bk(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.dCH) {
                    aPU();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.dCH) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aPT();
                } else if (firstVisiblePosition == this.dCH) {
                    if (firstVisiblePosition == 0 || !this.dCI || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aPT();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aPU();
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

    private void xO() {
        if (this.axK != null) {
            if (this.axL && this.axK.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.axK.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.axK.setLayoutParams(layoutParams);
                bk(true);
                return;
            }
            bk(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk(boolean z) {
        if (this.axK != null) {
            if (this.axL && z && this.axK.getVisibility() != 0) {
                this.axK.setVisibility(0);
            } else if (!z && this.axK.getVisibility() != 8) {
                this.axK.setVisibility(8);
            }
        }
    }
}
