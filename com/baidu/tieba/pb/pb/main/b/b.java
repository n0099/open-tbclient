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
/* loaded from: classes6.dex */
public class b {
    private View axb;
    private a iDl;
    private Animator iNH;
    private Animator iNI;
    private ValueAnimator iNJ;
    private ValueAnimator iNK;
    private AnimatorSet iNL;
    private AnimatorSet iNM;
    private View iNN;
    private View iNO;
    private View mExpandView;
    private int iNP = UtilHelper.getLightStatusBarHeight();
    private boolean iNQ = false;
    private boolean dpv = false;
    private int dCx = 0;
    private boolean iNR = false;
    private boolean iKg = false;
    private boolean iNS = false;
    private boolean dCy = false;
    private boolean gna = true;
    private final Handler.Callback gnd = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.bDj()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.bDi();
                    return true;
                case 2:
                    b.this.bDg();
                    return true;
                case 3:
                    b.this.bDh();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.gnd);
    private boolean axc = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes6.dex */
    public interface a {
        void pB(boolean z);
    }

    public void a(a aVar) {
        this.iDl = aVar;
    }

    public void lo(boolean z) {
        this.dCy = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.iNN = view;
        this.axb = view2;
        this.mExpandView = view3;
        this.iNO = this.mExpandView.findViewById(R.id.sticky_view);
        xy();
        bg(false);
    }

    private void cop() {
        this.iNH = ObjectAnimator.ofFloat(this.iNN, "translationY", (-this.iNN.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.iNH.setInterpolator(new LinearInterpolator());
        this.iNH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iNN != null) {
                    b.this.iNN.clearAnimation();
                    if (b.this.iNS) {
                        b.this.bg(false);
                    } else {
                        b.this.bg(true);
                    }
                    if (b.this.iDl != null) {
                        b.this.iDl.pB(false);
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
        this.iNK = ValueAnimator.ofInt(0, this.iNP);
        this.iNK.setInterpolator(new LinearInterpolator());
        this.iNK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iNO.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iNO.setLayoutParams(layoutParams);
                }
                b.this.iNO.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.iNO.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iNP;
                    b.this.iNO.setLayoutParams(layoutParams);
                }
                b.this.iNO.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iNK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iNO.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iNO.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iNM = new AnimatorSet();
        this.iNM.play(this.iNH).with(this.iNK);
    }

    private void coq() {
        this.iNI = ObjectAnimator.ofFloat(this.iNN, "translationY", 0.0f);
        this.iNI.setInterpolator(new LinearInterpolator());
        this.iNI.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.iNN != null) {
                    b.this.iNN.clearAnimation();
                    b.this.iNN.setVisibility(0);
                    b.this.bg(false);
                    if (b.this.iDl != null) {
                        b.this.iDl.pB(true);
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
        this.iNJ = ValueAnimator.ofInt(this.iNP, 0);
        this.iNJ.setInterpolator(new LinearInterpolator());
        this.iNJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.iNO.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.iNO.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.iNP;
                    b.this.iNO.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.iNO.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.iNO.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.iNO.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iNJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.iNO.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.iNO.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.iNL = new AnimatorSet();
        this.iNL.play(this.iNI).with(this.iNJ);
    }

    public void bDg() {
        L(false, false);
    }

    public void bDh() {
        L(false, true);
    }

    public void L(boolean z, boolean z2) {
        if (this.iNN != null && this.iNN.getY() == 0.0f && !bDj()) {
            if (z2) {
                this.iNN.setVisibility(8);
                if (this.iNS) {
                    bg(false);
                    return;
                } else {
                    bg(true);
                    return;
                }
            }
            this.iNN.setVisibility(0);
            if (this.iNM == null) {
                cop();
            }
            if (this.iNM != null) {
                this.iNM.cancel();
                this.iNM.setDuration(300L).start();
            }
        }
    }

    public void bDi() {
        if (this.iNN != null && this.iNN.getY() < 0.0f && !bDj()) {
            this.iNN.setVisibility(0);
            if (this.iNL == null) {
                coq();
            }
            if (this.iNL != null) {
                this.iNL.cancel();
                this.iNL.setDuration(300L).start();
            }
        }
    }

    public void aPA() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void aPB() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void aTW() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean bDj() {
        return (this.iNL != null && this.iNL.isRunning()) || (this.iNM != null && this.iNM.isRunning());
    }

    public void hideFloatingView() {
        if (this.gna) {
            if (this.dpv) {
                bg(true);
            } else if (this.iNN != null && !this.iNR && !this.iKg && cor()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                aPB();
            }
        }
    }

    public void showFloatingView() {
        if (this.gna) {
            if (this.dpv) {
                bg(true);
            } else if (this.iNN != null && !cor()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                aPA();
            }
        }
    }

    public boolean cor() {
        return this.iNN.getVisibility() == 0 && this.iNN.getY() >= 0.0f;
    }

    public void qm(boolean z) {
        this.iNR = z;
    }

    public void qn(boolean z) {
        this.iKg = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.gna && this.iNN != null && !this.iNR && !this.iKg && this.iNQ) {
            if (i > this.dCx && cor()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.dCx && !cor()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.dCx = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.iNQ = true;
        } else if (i == 0) {
            this.iNQ = false;
        }
        if (this.gna && !this.iNR && !this.iKg) {
            if (this.dpv) {
                bg(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.dCx) {
                    aPB();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.dCx) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    aPA();
                } else if (firstVisiblePosition == this.dCx) {
                    if (firstVisiblePosition == 0 || !this.dCy || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        aPA();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    aPB();
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

    private void xy() {
        if (this.axb != null) {
            if (this.axc && this.axb.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.axb.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.axb.setLayoutParams(layoutParams);
                bg(true);
                return;
            }
            bg(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bg(boolean z) {
        if (this.axb != null) {
            if (this.axc && z && this.axb.getVisibility() != 0) {
                this.axb.setVisibility(0);
            } else if (!z && this.axb.getVisibility() != 8) {
                this.axb.setVisibility(8);
            }
        }
    }
}
