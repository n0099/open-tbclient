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
    private View GN;
    private View czo;
    private a eLh;
    private Animator eXL;
    private Animator eXM;
    private ValueAnimator eXN;
    private ValueAnimator eXO;
    private AnimatorSet eXP;
    private AnimatorSet eXQ;
    private View eXR;
    private View eXS;
    private int eXT = UtilHelper.getLightStatusBarHeight();
    private boolean eXU = false;
    private boolean axR = false;
    private int aMx = 0;
    private boolean eXV = false;
    private boolean eTD = false;
    private boolean eXW = false;
    private boolean aMy = false;
    private boolean cAM = true;
    private final Handler.Callback cAO = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.ako()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.akn();
                    return true;
                case 2:
                    b.this.akl();
                    return true;
                case 3:
                    b.this.akm();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cAO);
    private boolean cAL = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void iM(boolean z);
    }

    public void a(a aVar) {
        this.eLh = aVar;
    }

    public void eF(boolean z) {
        this.aMy = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.eXR = view;
        this.czo = view2;
        this.GN = view3;
        this.eXS = this.GN.findViewById(d.g.sticky_view);
        akp();
        eH(false);
    }

    private void aVO() {
        this.eXL = ObjectAnimator.ofFloat(this.eXR, "translationY", (-this.eXR.getMeasuredHeight()) + this.GN.getMeasuredHeight());
        this.eXL.setInterpolator(new LinearInterpolator());
        this.eXL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eXR != null) {
                    b.this.eXR.clearAnimation();
                    if (b.this.eXW) {
                        b.this.eH(false);
                    } else {
                        b.this.eH(true);
                    }
                    if (b.this.eLh != null) {
                        b.this.eLh.iM(false);
                    }
                    b.this.GN.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eXO = ValueAnimator.ofInt(0, this.eXT);
        this.eXO.setInterpolator(new LinearInterpolator());
        this.eXO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eXS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eXS.setLayoutParams(layoutParams);
                }
                b.this.eXS.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eXS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eXT;
                    b.this.eXS.setLayoutParams(layoutParams);
                }
                b.this.eXS.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eXO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eXS.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eXS.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eXQ = new AnimatorSet();
        this.eXQ.play(this.eXL).with(this.eXO);
    }

    private void aVP() {
        this.eXM = ObjectAnimator.ofFloat(this.eXR, "translationY", 0.0f);
        this.eXM.setInterpolator(new LinearInterpolator());
        this.eXM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eXR != null) {
                    b.this.eXR.clearAnimation();
                    b.this.eXR.setVisibility(0);
                    b.this.eH(false);
                    if (b.this.eLh != null) {
                        b.this.eLh.iM(true);
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
        this.eXN = ValueAnimator.ofInt(this.eXT, 0);
        this.eXN.setInterpolator(new LinearInterpolator());
        this.eXN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.eXS.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.eXS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eXT;
                    b.this.eXS.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.eXS.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.eXS.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eXS.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eXN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eXS.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eXS.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eXP = new AnimatorSet();
        this.eXP.play(this.eXM).with(this.eXN);
    }

    public void akl() {
        w(false, false);
    }

    public void akm() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.eXR != null && this.eXR.getY() == 0.0f && !ako()) {
            if (z2) {
                this.eXR.setVisibility(8);
                if (this.eXW) {
                    eH(false);
                    return;
                } else {
                    eH(true);
                    return;
                }
            }
            this.eXR.setVisibility(0);
            if (this.eXQ == null) {
                aVO();
            }
            if (this.eXQ != null) {
                this.eXQ.cancel();
                this.eXQ.setDuration(300L).start();
            }
        }
    }

    public void akn() {
        if (this.eXR != null && this.eXR.getY() < 0.0f && !ako()) {
            this.eXR.setVisibility(0);
            if (this.eXP == null) {
                aVP();
            }
            if (this.eXP != null) {
                this.eXP.cancel();
                this.eXP.setDuration(300L).start();
            }
        }
    }

    public void GV() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void GW() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void GX() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean ako() {
        return (this.eXP != null && this.eXP.isRunning()) || (this.eXQ != null && this.eXQ.isRunning());
    }

    public void hideFloatingView() {
        if (this.cAM) {
            if (this.axR) {
                eH(true);
            } else if (this.eXR != null && !this.eXV && !this.eTD && aVQ()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                GW();
            }
        }
    }

    public void showFloatingView() {
        if (this.cAM) {
            if (this.axR) {
                eH(true);
            } else if (this.eXR != null && !aVQ()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                GV();
            }
        }
    }

    public boolean aVQ() {
        return this.eXR.getVisibility() == 0 && this.eXR.getY() >= 0.0f;
    }

    public void jz(boolean z) {
        this.eXV = z;
    }

    public void jA(boolean z) {
        this.eTD = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cAM && this.eXR != null && !this.eXV && !this.eTD && this.eXU) {
            if (i > this.aMx && aVQ()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aMx && !aVQ()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aMx = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.eXU = true;
        } else if (i == 0) {
            this.eXU = false;
        }
        if (this.cAM && !this.eXV && !this.eTD) {
            if (this.axR) {
                eH(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMx) {
                    GW();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aMx) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    GV();
                } else if (firstVisiblePosition == this.aMx) {
                    if (firstVisiblePosition == 0 || !this.aMy || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        GV();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    GW();
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

    private void akp() {
        if (this.czo != null) {
            if (this.cAL && this.czo.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.czo.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.czo.setLayoutParams(layoutParams);
                eH(true);
                return;
            }
            eH(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eH(boolean z) {
        if (this.czo != null) {
            if (this.cAL && z && this.czo.getVisibility() != 0) {
                this.czo.setVisibility(0);
            } else if (!z && this.czo.getVisibility() != 8) {
                this.czo.setVisibility(8);
            }
        }
    }
}
