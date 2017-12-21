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
    private View GO;
    private View cJa;
    private a eUq;
    private Animator fgb;
    private Animator fgc;
    private ValueAnimator fgd;
    private ValueAnimator fge;
    private AnimatorSet fgf;
    private AnimatorSet fgg;
    private View fgh;
    private View fgi;
    private int fgj = UtilHelper.getLightStatusBarHeight();
    private boolean fgk = false;
    private boolean ayI = false;
    private int aNm = 0;
    private boolean fgl = false;
    private boolean fdP = false;
    private boolean fgm = false;
    private boolean aNn = false;
    private boolean cKx = true;
    private final Handler.Callback cKz = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.amH()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.amG();
                    return true;
                case 2:
                    b.this.amE();
                    return true;
                case 3:
                    b.this.amF();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cKz);
    private boolean cKw = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void jk(boolean z);
    }

    public void a(a aVar) {
        this.eUq = aVar;
    }

    public void fc(boolean z) {
        this.aNn = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fgh = view;
        this.cJa = view2;
        this.GO = view3;
        this.fgi = this.GO.findViewById(d.g.sticky_view);
        amI();
        fe(false);
    }

    private void aXe() {
        this.fgb = ObjectAnimator.ofFloat(this.fgh, "translationY", (-this.fgh.getMeasuredHeight()) + this.GO.getMeasuredHeight());
        this.fgb.setInterpolator(new LinearInterpolator());
        this.fgb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fgh != null) {
                    b.this.fgh.clearAnimation();
                    if (b.this.fgm) {
                        b.this.fe(false);
                    } else {
                        b.this.fe(true);
                    }
                    if (b.this.eUq != null) {
                        b.this.eUq.jk(false);
                    }
                    b.this.GO.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fge = ValueAnimator.ofInt(0, this.fgj);
        this.fge.setInterpolator(new LinearInterpolator());
        this.fge.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fgi.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fgi.setLayoutParams(layoutParams);
                }
                b.this.fgi.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fgi.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fgj;
                    b.this.fgi.setLayoutParams(layoutParams);
                }
                b.this.fgi.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fge.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fgi.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fgi.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fgg = new AnimatorSet();
        this.fgg.play(this.fgb).with(this.fge);
    }

    private void aXf() {
        this.fgc = ObjectAnimator.ofFloat(this.fgh, "translationY", 0.0f);
        this.fgc.setInterpolator(new LinearInterpolator());
        this.fgc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fgh != null) {
                    b.this.fgh.clearAnimation();
                    b.this.fgh.setVisibility(0);
                    b.this.fe(false);
                    if (b.this.eUq != null) {
                        b.this.eUq.jk(true);
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
        this.fgd = ValueAnimator.ofInt(this.fgj, 0);
        this.fgd.setInterpolator(new LinearInterpolator());
        this.fgd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fgi.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fgi.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fgj;
                    b.this.fgi.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fgi.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fgi.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fgi.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fgd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fgi.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fgi.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fgf = new AnimatorSet();
        this.fgf.play(this.fgc).with(this.fgd);
    }

    public void amE() {
        w(false, false);
    }

    public void amF() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.fgh != null && this.fgh.getY() == 0.0f && !amH()) {
            if (z2) {
                this.fgh.setVisibility(8);
                if (this.fgm) {
                    fe(false);
                    return;
                } else {
                    fe(true);
                    return;
                }
            }
            this.fgh.setVisibility(0);
            if (this.fgg == null) {
                aXe();
            }
            if (this.fgg != null) {
                this.fgg.cancel();
                this.fgg.setDuration(300L).start();
            }
        }
    }

    public void amG() {
        if (this.fgh != null && this.fgh.getY() < 0.0f && !amH()) {
            this.fgh.setVisibility(0);
            if (this.fgf == null) {
                aXf();
            }
            if (this.fgf != null) {
                this.fgf.cancel();
                this.fgf.setDuration(300L).start();
            }
        }
    }

    public void Ho() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hp() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hq() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean amH() {
        return (this.fgf != null && this.fgf.isRunning()) || (this.fgg != null && this.fgg.isRunning());
    }

    public void hideFloatingView() {
        if (this.cKx) {
            if (this.ayI) {
                fe(true);
            } else if (this.fgh != null && !this.fgl && !this.fdP && aXg()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Hp();
            }
        }
    }

    public void showFloatingView() {
        if (this.cKx) {
            if (this.ayI) {
                fe(true);
            } else if (this.fgh != null && !aXg()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Ho();
            }
        }
    }

    public boolean aXg() {
        return this.fgh.getVisibility() == 0 && this.fgh.getY() >= 0.0f;
    }

    public void ke(boolean z) {
        this.fgl = z;
    }

    public void kf(boolean z) {
        this.fdP = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cKx && this.fgh != null && !this.fgl && !this.fdP && this.fgk) {
            if (i > this.aNm && aXg()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aNm && !aXg()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aNm = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fgk = true;
        } else if (i == 0) {
            this.fgk = false;
        }
        if (this.cKx && !this.fgl && !this.fdP) {
            if (this.ayI) {
                fe(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aNm) {
                    Hp();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aNm) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Ho();
                } else if (firstVisiblePosition == this.aNm) {
                    if (firstVisiblePosition == 0 || !this.aNn || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Ho();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Hp();
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

    private void amI() {
        if (this.cJa != null) {
            if (this.cKw && this.cJa.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cJa.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cJa.setLayoutParams(layoutParams);
                fe(true);
                return;
            }
            fe(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fe(boolean z) {
        if (this.cJa != null) {
            if (this.cKw && z && this.cJa.getVisibility() != 0) {
                this.cJa.setVisibility(0);
            } else if (!z && this.cJa.getVisibility() != 8) {
                this.cJa.setVisibility(8);
            }
        }
    }
}
