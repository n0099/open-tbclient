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
    private View auO;
    private View dCY;
    private a fIs;
    private ValueAnimator fUA;
    private AnimatorSet fUB;
    private AnimatorSet fUC;
    private View fUD;
    private View fUE;
    private Animator fUx;
    private Animator fUy;
    private ValueAnimator fUz;
    private int fUF = UtilHelper.getLightStatusBarHeight();
    private boolean fUG = false;
    private boolean bmW = false;
    private int bBi = 0;
    private boolean fUH = false;
    private boolean fSg = false;
    private boolean fUI = false;
    private boolean bBj = false;
    private boolean dEd = true;
    private final Handler.Callback dEf = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.avr()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.avq();
                    return true;
                case 2:
                    b.this.avo();
                    return true;
                case 3:
                    b.this.avp();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dEf);
    private boolean dEc = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jP(boolean z);
    }

    public void a(a aVar) {
        this.fIs = aVar;
    }

    public void fM(boolean z) {
        this.bBj = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fUD = view;
        this.dCY = view2;
        this.auO = view3;
        this.fUE = this.auO.findViewById(d.g.sticky_view);
        avs();
        fO(false);
    }

    private void bew() {
        this.fUx = ObjectAnimator.ofFloat(this.fUD, "translationY", (-this.fUD.getMeasuredHeight()) + this.auO.getMeasuredHeight());
        this.fUx.setInterpolator(new LinearInterpolator());
        this.fUx.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fUD != null) {
                    b.this.fUD.clearAnimation();
                    if (b.this.fUI) {
                        b.this.fO(false);
                    } else {
                        b.this.fO(true);
                    }
                    if (b.this.fIs != null) {
                        b.this.fIs.jP(false);
                    }
                    b.this.auO.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fUA = ValueAnimator.ofInt(0, this.fUF);
        this.fUA.setInterpolator(new LinearInterpolator());
        this.fUA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fUE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fUE.setLayoutParams(layoutParams);
                }
                b.this.fUE.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fUE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fUF;
                    b.this.fUE.setLayoutParams(layoutParams);
                }
                b.this.fUE.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fUA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fUE.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fUE.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fUC = new AnimatorSet();
        this.fUC.play(this.fUx).with(this.fUA);
    }

    private void bex() {
        this.fUy = ObjectAnimator.ofFloat(this.fUD, "translationY", 0.0f);
        this.fUy.setInterpolator(new LinearInterpolator());
        this.fUy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fUD != null) {
                    b.this.fUD.clearAnimation();
                    b.this.fUD.setVisibility(0);
                    b.this.fO(false);
                    if (b.this.fIs != null) {
                        b.this.fIs.jP(true);
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
        this.fUz = ValueAnimator.ofInt(this.fUF, 0);
        this.fUz.setInterpolator(new LinearInterpolator());
        this.fUz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fUE.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fUE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fUF;
                    b.this.fUE.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fUE.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fUE.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fUE.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fUz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fUE.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fUE.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fUB = new AnimatorSet();
        this.fUB.play(this.fUy).with(this.fUz);
    }

    public void avo() {
        y(false, false);
    }

    public void avp() {
        y(false, true);
    }

    public void y(boolean z, boolean z2) {
        if (this.fUD != null && this.fUD.getY() == 0.0f && !avr()) {
            if (z2) {
                this.fUD.setVisibility(8);
                if (this.fUI) {
                    fO(false);
                    return;
                } else {
                    fO(true);
                    return;
                }
            }
            this.fUD.setVisibility(0);
            if (this.fUC == null) {
                bew();
            }
            if (this.fUC != null) {
                this.fUC.cancel();
                this.fUC.setDuration(300L).start();
            }
        }
    }

    public void avq() {
        if (this.fUD != null && this.fUD.getY() < 0.0f && !avr()) {
            this.fUD.setVisibility(0);
            if (this.fUB == null) {
                bex();
            }
            if (this.fUB != null) {
                this.fUB.cancel();
                this.fUB.setDuration(300L).start();
            }
        }
    }

    public void OB() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void OC() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void OD() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean avr() {
        return (this.fUB != null && this.fUB.isRunning()) || (this.fUC != null && this.fUC.isRunning());
    }

    public void hideFloatingView() {
        if (this.dEd) {
            if (this.bmW) {
                fO(true);
            } else if (this.fUD != null && !this.fUH && !this.fSg && bey()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                OC();
            }
        }
    }

    public void showFloatingView() {
        if (this.dEd) {
            if (this.bmW) {
                fO(true);
            } else if (this.fUD != null && !bey()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                OB();
            }
        }
    }

    public boolean bey() {
        return this.fUD.getVisibility() == 0 && this.fUD.getY() >= 0.0f;
    }

    public void kI(boolean z) {
        this.fUH = z;
    }

    public void kJ(boolean z) {
        this.fSg = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dEd && this.fUD != null && !this.fUH && !this.fSg && this.fUG) {
            if (i > this.bBi && bey()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bBi && !bey()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bBi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fUG = true;
        } else if (i == 0) {
            this.fUG = false;
        }
        if (this.dEd && !this.fUH && !this.fSg) {
            if (this.bmW) {
                fO(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bBi) {
                    OC();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bBi) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    OB();
                } else if (firstVisiblePosition == this.bBi) {
                    if (firstVisiblePosition == 0 || !this.bBj || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        OB();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    OC();
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

    private void avs() {
        if (this.dCY != null) {
            if (this.dEc && this.dCY.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dCY.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dCY.setLayoutParams(layoutParams);
                fO(true);
                return;
            }
            fO(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fO(boolean z) {
        if (this.dCY != null) {
            if (this.dEc && z && this.dCY.getVisibility() != 0) {
                this.dCY.setVisibility(0);
            } else if (!z && this.dCY.getVisibility() != 8) {
                this.dCY.setVisibility(8);
            }
        }
    }
}
