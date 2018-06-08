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
    private View Lt;
    private View djC;
    private Animator fEK;
    private Animator fEL;
    private ValueAnimator fEM;
    private ValueAnimator fEN;
    private AnimatorSet fEO;
    private AnimatorSet fEP;
    private View fEQ;
    private View fER;
    private a fsl;
    private int fES = UtilHelper.getLightStatusBarHeight();
    private boolean fET = false;
    private boolean aIe = false;
    private int aVF = 0;
    private boolean fEU = false;
    private boolean fCv = false;
    private boolean fEV = false;
    private boolean aVG = false;
    private boolean dkK = true;
    private final Handler.Callback dkM = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.auS()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.auR();
                    return true;
                case 2:
                    b.this.auP();
                    return true;
                case 3:
                    b.this.auQ();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dkM);
    private boolean dkJ = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void jJ(boolean z);
    }

    public void a(a aVar) {
        this.fsl = aVar;
    }

    public void fH(boolean z) {
        this.aVG = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fEQ = view;
        this.djC = view2;
        this.Lt = view3;
        this.fER = this.Lt.findViewById(d.g.sticky_view);
        Ty();
        fJ(false);
    }

    private void bfX() {
        this.fEK = ObjectAnimator.ofFloat(this.fEQ, "translationY", (-this.fEQ.getMeasuredHeight()) + this.Lt.getMeasuredHeight());
        this.fEK.setInterpolator(new LinearInterpolator());
        this.fEK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fEQ != null) {
                    b.this.fEQ.clearAnimation();
                    if (b.this.fEV) {
                        b.this.fJ(false);
                    } else {
                        b.this.fJ(true);
                    }
                    if (b.this.fsl != null) {
                        b.this.fsl.jJ(false);
                    }
                    b.this.Lt.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fEN = ValueAnimator.ofInt(0, this.fES);
        this.fEN.setInterpolator(new LinearInterpolator());
        this.fEN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fER.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fER.setLayoutParams(layoutParams);
                }
                b.this.fER.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fER.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fES;
                    b.this.fER.setLayoutParams(layoutParams);
                }
                b.this.fER.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fEN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fER.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fER.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fEP = new AnimatorSet();
        this.fEP.play(this.fEK).with(this.fEN);
    }

    private void bfY() {
        this.fEL = ObjectAnimator.ofFloat(this.fEQ, "translationY", 0.0f);
        this.fEL.setInterpolator(new LinearInterpolator());
        this.fEL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fEQ != null) {
                    b.this.fEQ.clearAnimation();
                    b.this.fEQ.setVisibility(0);
                    b.this.fJ(false);
                    if (b.this.fsl != null) {
                        b.this.fsl.jJ(true);
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
        this.fEM = ValueAnimator.ofInt(this.fES, 0);
        this.fEM.setInterpolator(new LinearInterpolator());
        this.fEM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fER.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fER.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fES;
                    b.this.fER.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fER.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fER.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fER.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fEM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fER.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fER.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fEO = new AnimatorSet();
        this.fEO.play(this.fEL).with(this.fEM);
    }

    public void auP() {
        v(false, false);
    }

    public void auQ() {
        v(false, true);
    }

    public void v(boolean z, boolean z2) {
        if (this.fEQ != null && this.fEQ.getY() == 0.0f && !auS()) {
            if (z2) {
                this.fEQ.setVisibility(8);
                if (this.fEV) {
                    fJ(false);
                    return;
                } else {
                    fJ(true);
                    return;
                }
            }
            this.fEQ.setVisibility(0);
            if (this.fEP == null) {
                bfX();
            }
            if (this.fEP != null) {
                this.fEP.cancel();
                this.fEP.setDuration(300L).start();
            }
        }
    }

    public void auR() {
        if (this.fEQ != null && this.fEQ.getY() < 0.0f && !auS()) {
            this.fEQ.setVisibility(0);
            if (this.fEO == null) {
                bfY();
            }
            if (this.fEO != null) {
                this.fEO.cancel();
                this.fEO.setDuration(300L).start();
            }
        }
    }

    public void Le() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Lf() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Lg() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean auS() {
        return (this.fEO != null && this.fEO.isRunning()) || (this.fEP != null && this.fEP.isRunning());
    }

    public void hideFloatingView() {
        if (this.dkK) {
            if (this.aIe) {
                fJ(true);
            } else if (this.fEQ != null && !this.fEU && !this.fCv && bfZ()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Lf();
            }
        }
    }

    public void showFloatingView() {
        if (this.dkK) {
            if (this.aIe) {
                fJ(true);
            } else if (this.fEQ != null && !bfZ()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Le();
            }
        }
    }

    public boolean bfZ() {
        return this.fEQ.getVisibility() == 0 && this.fEQ.getY() >= 0.0f;
    }

    public void kC(boolean z) {
        this.fEU = z;
    }

    public void kD(boolean z) {
        this.fCv = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dkK && this.fEQ != null && !this.fEU && !this.fCv && this.fET) {
            if (i > this.aVF && bfZ()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aVF && !bfZ()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aVF = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fET = true;
        } else if (i == 0) {
            this.fET = false;
        }
        if (this.dkK && !this.fEU && !this.fCv) {
            if (this.aIe) {
                fJ(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aVF) {
                    Lf();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aVF) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Le();
                } else if (firstVisiblePosition == this.aVF) {
                    if (firstVisiblePosition == 0 || !this.aVG || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Le();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Lf();
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

    private void Ty() {
        if (this.djC != null) {
            if (this.dkJ && this.djC.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.djC.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.djC.setLayoutParams(layoutParams);
                fJ(true);
                return;
            }
            fJ(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fJ(boolean z) {
        if (this.djC != null) {
            if (this.dkJ && z && this.djC.getVisibility() != 0) {
                this.djC.setVisibility(0);
            } else if (!z && this.djC.getVisibility() != 8) {
                this.djC.setVisibility(8);
            }
        }
    }
}
