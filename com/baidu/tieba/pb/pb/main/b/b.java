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
/* loaded from: classes21.dex */
public class b {
    private View brO;
    private a kMW;
    private Animator kYr;
    private Animator kYs;
    private ValueAnimator kYt;
    private ValueAnimator kYu;
    private AnimatorSet kYv;
    private AnimatorSet kYw;
    private View kYx;
    private View kYy;
    private View mExpandView;
    private int kYz = UtilHelper.getLightStatusBarHeight();
    private boolean kYA = false;
    private boolean eKm = false;
    private int eYv = 0;
    private boolean kYB = false;
    private boolean kUK = false;
    private boolean kYC = false;
    private boolean eYw = false;
    private boolean ieS = true;
    private final Handler.Callback ieV = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.crx()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.crv();
                    return true;
                case 2:
                    b.this.crt();
                    return true;
                case 3:
                    b.this.cru();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.ieV);
    private boolean brP = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes21.dex */
    public interface a {
        void ti(boolean z);
    }

    public void a(a aVar) {
        this.kMW = aVar;
    }

    public void oH(boolean z) {
        this.eYw = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.kYx = view;
        this.brO = view2;
        this.mExpandView = view3;
        this.kYy = this.mExpandView.findViewById(R.id.sticky_view);
        OR();
        cz(false);
    }

    private void dfE() {
        this.kYr = ObjectAnimator.ofFloat(this.kYx, "translationY", (-this.kYx.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.kYr.setInterpolator(new LinearInterpolator());
        this.kYr.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kYx != null) {
                    b.this.kYx.clearAnimation();
                    if (b.this.kYC) {
                        b.this.cz(false);
                    } else {
                        b.this.cz(true);
                    }
                    if (b.this.kMW != null) {
                        b.this.kMW.ti(false);
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
        this.kYu = ValueAnimator.ofInt(0, this.kYz);
        this.kYu.setInterpolator(new LinearInterpolator());
        this.kYu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kYy.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kYy.setLayoutParams(layoutParams);
                }
                b.this.kYy.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.kYy.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kYz;
                    b.this.kYy.setLayoutParams(layoutParams);
                }
                b.this.kYy.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kYu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kYy.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kYy.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kYw = new AnimatorSet();
        this.kYw.play(this.kYr).with(this.kYu);
    }

    private void dfF() {
        this.kYs = ObjectAnimator.ofFloat(this.kYx, "translationY", 0.0f);
        this.kYs.setInterpolator(new LinearInterpolator());
        this.kYs.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.kYx != null) {
                    b.this.kYx.clearAnimation();
                    b.this.kYx.setVisibility(0);
                    b.this.cz(false);
                    if (b.this.kMW != null) {
                        b.this.kMW.ti(true);
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
        this.kYt = ValueAnimator.ofInt(this.kYz, 0);
        this.kYt.setInterpolator(new LinearInterpolator());
        this.kYt.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.kYy.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.kYy.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.kYz;
                    b.this.kYy.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.kYy.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.kYy.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.kYy.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kYt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.kYy.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.kYy.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.kYv = new AnimatorSet();
        this.kYv.play(this.kYs).with(this.kYt);
    }

    public void crt() {
        X(false, false);
    }

    public void cru() {
        X(false, true);
    }

    public void X(boolean z, boolean z2) {
        if (this.kYx != null && this.kYx.getY() == 0.0f && !crx()) {
            if (z2) {
                this.kYx.setVisibility(8);
                if (this.kYC) {
                    cz(false);
                    return;
                } else {
                    cz(true);
                    return;
                }
            }
            this.kYx.setVisibility(0);
            if (this.kYw == null) {
                dfE();
            }
            if (this.kYw != null) {
                this.kYw.cancel();
                this.kYw.setDuration(300L).start();
            }
        }
    }

    public void crv() {
        if (this.kYx != null && this.kYx.getY() < 0.0f && !crx()) {
            this.kYx.setVisibility(0);
            if (this.kYv == null) {
                dfF();
            }
            if (this.kYv != null) {
                this.kYv.cancel();
                this.kYv.setDuration(300L).start();
            }
        }
    }

    public void bwO() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bwP() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void crw() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean crx() {
        return (this.kYv != null && this.kYv.isRunning()) || (this.kYw != null && this.kYw.isRunning());
    }

    public void hideFloatingView() {
        if (this.ieS) {
            if (this.eKm) {
                cz(true);
            } else if (this.kYx != null && !this.kYB && !this.kUK && dfG()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bwP();
            }
        }
    }

    public void showFloatingView() {
        if (this.ieS) {
            if (this.eKm) {
                cz(true);
            } else if (this.kYx != null && !dfG()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bwO();
            }
        }
    }

    public boolean dfG() {
        return this.kYx.getVisibility() == 0 && this.kYx.getY() >= 0.0f;
    }

    public void tW(boolean z) {
        this.kYB = z;
    }

    public void tX(boolean z) {
        this.kUK = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.ieS && this.kYx != null && !this.kYB && !this.kUK && this.kYA) {
            if (i > this.eYv && dfG()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.eYv && !dfG()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.eYv = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.kYA = true;
        } else if (i == 0) {
            this.kYA = false;
        }
        if (this.ieS && !this.kYB && !this.kUK) {
            if (this.eKm) {
                cz(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.eYv) {
                    bwP();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.eYv) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bwO();
                } else if (firstVisiblePosition == this.eYv) {
                    if (firstVisiblePosition == 0 || !this.eYw || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bwO();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bwP();
                }
            }
        }
    }

    public boolean b(AbsListView absListView) {
        if (absListView != null) {
            return (absListView.getChildCount() == 0 && absListView.getChildAt(0) == null) || absListView.getChildAt(0).getTop() == 0;
        }
        return true;
    }

    private void OR() {
        if (this.brO != null) {
            if (this.brP && this.brO.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.brO.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.brO.setLayoutParams(layoutParams);
                cz(true);
                return;
            }
            cz(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(boolean z) {
        if (this.brO != null) {
            if (this.brP && z && this.brO.getVisibility() != 0) {
                this.brO.setVisibility(0);
            } else if (!z && this.brO.getVisibility() != 8) {
                this.brO.setVisibility(8);
            }
        }
    }
}
