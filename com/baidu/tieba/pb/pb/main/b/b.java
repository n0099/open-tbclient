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
/* loaded from: classes6.dex */
public class b {
    private View On;
    private View dKj;
    private a fTR;
    private Animator ggq;
    private Animator ggr;
    private ValueAnimator ggs;
    private ValueAnimator ggt;
    private AnimatorSet ggu;
    private AnimatorSet ggv;
    private View ggw;
    private View ggx;
    private int ggy = UtilHelper.getLightStatusBarHeight();
    private boolean ggz = false;
    private boolean aVk = false;
    private int biJ = 0;
    private boolean ggA = false;
    private boolean gdS = false;
    private boolean ggB = false;
    private boolean biK = false;
    private boolean dLL = true;
    private final Handler.Callback dLN = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.aCE()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.aCD();
                    return true;
                case 2:
                    b.this.aCB();
                    return true;
                case 3:
                    b.this.aCC();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dLN);
    private boolean dLK = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes6.dex */
    public interface a {
        void kL(boolean z);
    }

    public void a(a aVar) {
        this.fTR = aVar;
    }

    public void gN(boolean z) {
        this.biK = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.ggw = view;
        this.dKj = view2;
        this.On = view3;
        this.ggx = this.On.findViewById(e.g.sticky_view);
        aaO();
        gP(false);
    }

    private void blZ() {
        this.ggq = ObjectAnimator.ofFloat(this.ggw, "translationY", (-this.ggw.getMeasuredHeight()) + this.On.getMeasuredHeight());
        this.ggq.setInterpolator(new LinearInterpolator());
        this.ggq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ggw != null) {
                    b.this.ggw.clearAnimation();
                    if (b.this.ggB) {
                        b.this.gP(false);
                    } else {
                        b.this.gP(true);
                    }
                    if (b.this.fTR != null) {
                        b.this.fTR.kL(false);
                    }
                    b.this.On.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ggt = ValueAnimator.ofInt(0, this.ggy);
        this.ggt.setInterpolator(new LinearInterpolator());
        this.ggt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ggx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ggx.setLayoutParams(layoutParams);
                }
                b.this.ggx.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ggx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ggy;
                    b.this.ggx.setLayoutParams(layoutParams);
                }
                b.this.ggx.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ggt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ggx.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ggx.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.ggv = new AnimatorSet();
        this.ggv.play(this.ggq).with(this.ggt);
    }

    private void bma() {
        this.ggr = ObjectAnimator.ofFloat(this.ggw, "translationY", 0.0f);
        this.ggr.setInterpolator(new LinearInterpolator());
        this.ggr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ggw != null) {
                    b.this.ggw.clearAnimation();
                    b.this.ggw.setVisibility(0);
                    b.this.gP(false);
                    if (b.this.fTR != null) {
                        b.this.fTR.kL(true);
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
        this.ggs = ValueAnimator.ofInt(this.ggy, 0);
        this.ggs.setInterpolator(new LinearInterpolator());
        this.ggs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.ggx.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.ggx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ggy;
                    b.this.ggx.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ggx.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.ggx.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ggx.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ggs.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ggx.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ggx.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.ggu = new AnimatorSet();
        this.ggu.play(this.ggr).with(this.ggs);
    }

    public void aCB() {
        C(false, false);
    }

    public void aCC() {
        C(false, true);
    }

    public void C(boolean z, boolean z2) {
        if (this.ggw != null && this.ggw.getY() == 0.0f && !aCE()) {
            if (z2) {
                this.ggw.setVisibility(8);
                if (this.ggB) {
                    gP(false);
                    return;
                } else {
                    gP(true);
                    return;
                }
            }
            this.ggw.setVisibility(0);
            if (this.ggv == null) {
                blZ();
            }
            if (this.ggv != null) {
                this.ggv.cancel();
                this.ggv.setDuration(300L).start();
            }
        }
    }

    public void aCD() {
        if (this.ggw != null && this.ggw.getY() < 0.0f && !aCE()) {
            this.ggw.setVisibility(0);
            if (this.ggu == null) {
                bma();
            }
            if (this.ggu != null) {
                this.ggu.cancel();
                this.ggu.setDuration(300L).start();
            }
        }
    }

    public void Qa() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Qb() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Qc() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean aCE() {
        return (this.ggu != null && this.ggu.isRunning()) || (this.ggv != null && this.ggv.isRunning());
    }

    public void hideFloatingView() {
        if (this.dLL) {
            if (this.aVk) {
                gP(true);
            } else if (this.ggw != null && !this.ggA && !this.gdS && bmb()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Qb();
            }
        }
    }

    public void showFloatingView() {
        if (this.dLL) {
            if (this.aVk) {
                gP(true);
            } else if (this.ggw != null && !bmb()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Qa();
            }
        }
    }

    public boolean bmb() {
        return this.ggw.getVisibility() == 0 && this.ggw.getY() >= 0.0f;
    }

    public void lB(boolean z) {
        this.ggA = z;
    }

    public void lC(boolean z) {
        this.gdS = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dLL && this.ggw != null && !this.ggA && !this.gdS && this.ggz) {
            if (i > this.biJ && bmb()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.biJ && !bmb()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.biJ = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.ggz = true;
        } else if (i == 0) {
            this.ggz = false;
        }
        if (this.dLL && !this.ggA && !this.gdS) {
            if (this.aVk) {
                gP(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.biJ) {
                    Qb();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.biJ) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Qa();
                } else if (firstVisiblePosition == this.biJ) {
                    if (firstVisiblePosition == 0 || !this.biK || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Qa();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Qb();
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

    private void aaO() {
        if (this.dKj != null) {
            if (this.dLK && this.dKj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dKj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dKj.setLayoutParams(layoutParams);
                gP(true);
                return;
            }
            gP(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gP(boolean z) {
        if (this.dKj != null) {
            if (this.dLK && z && this.dKj.getVisibility() != 0) {
                this.dKj.setVisibility(0);
            } else if (!z && this.dKj.getVisibility() != 8) {
                this.dKj.setVisibility(8);
            }
        }
    }
}
