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
    private View auM;
    private View dGq;
    private a fLX;
    private Animator fYe;
    private Animator fYf;
    private ValueAnimator fYg;
    private ValueAnimator fYh;
    private AnimatorSet fYi;
    private AnimatorSet fYj;
    private View fYk;
    private View fYl;
    private int fYm = UtilHelper.getLightStatusBarHeight();
    private boolean fYn = false;
    private boolean bpt = false;
    private int bDu = 0;
    private boolean fYo = false;
    private boolean fVO = false;
    private boolean fYp = false;
    private boolean bDv = false;
    private boolean dHC = true;
    private final Handler.Callback dHE = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.awu()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.awt();
                    return true;
                case 2:
                    b.this.awr();
                    return true;
                case 3:
                    b.this.aws();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dHE);
    private boolean dHB = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void kb(boolean z);
    }

    public void a(a aVar) {
        this.fLX = aVar;
    }

    public void fW(boolean z) {
        this.bDv = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fYk = view;
        this.dGq = view2;
        this.auM = view3;
        this.fYl = this.auM.findViewById(d.g.sticky_view);
        XD();
        fY(false);
    }

    private void bgb() {
        this.fYe = ObjectAnimator.ofFloat(this.fYk, "translationY", (-this.fYk.getMeasuredHeight()) + this.auM.getMeasuredHeight());
        this.fYe.setInterpolator(new LinearInterpolator());
        this.fYe.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fYk != null) {
                    b.this.fYk.clearAnimation();
                    if (b.this.fYp) {
                        b.this.fY(false);
                    } else {
                        b.this.fY(true);
                    }
                    if (b.this.fLX != null) {
                        b.this.fLX.kb(false);
                    }
                    b.this.auM.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYh = ValueAnimator.ofInt(0, this.fYm);
        this.fYh.setInterpolator(new LinearInterpolator());
        this.fYh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYl.setLayoutParams(layoutParams);
                }
                b.this.fYl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYm;
                    b.this.fYl.setLayoutParams(layoutParams);
                }
                b.this.fYl.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYl.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYl.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fYj = new AnimatorSet();
        this.fYj.play(this.fYe).with(this.fYh);
    }

    private void bgc() {
        this.fYf = ObjectAnimator.ofFloat(this.fYk, "translationY", 0.0f);
        this.fYf.setInterpolator(new LinearInterpolator());
        this.fYf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fYk != null) {
                    b.this.fYk.clearAnimation();
                    b.this.fYk.setVisibility(0);
                    b.this.fY(false);
                    if (b.this.fLX != null) {
                        b.this.fLX.kb(true);
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
        this.fYg = ValueAnimator.ofInt(this.fYm, 0);
        this.fYg.setInterpolator(new LinearInterpolator());
        this.fYg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fYl.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fYl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYm;
                    b.this.fYl.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fYl.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fYl.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYl.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYl.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYl.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fYi = new AnimatorSet();
        this.fYi.play(this.fYf).with(this.fYg);
    }

    public void awr() {
        z(false, false);
    }

    public void aws() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.fYk != null && this.fYk.getY() == 0.0f && !awu()) {
            if (z2) {
                this.fYk.setVisibility(8);
                if (this.fYp) {
                    fY(false);
                    return;
                } else {
                    fY(true);
                    return;
                }
            }
            this.fYk.setVisibility(0);
            if (this.fYj == null) {
                bgb();
            }
            if (this.fYj != null) {
                this.fYj.cancel();
                this.fYj.setDuration(300L).start();
            }
        }
    }

    public void awt() {
        if (this.fYk != null && this.fYk.getY() < 0.0f && !awu()) {
            this.fYk.setVisibility(0);
            if (this.fYi == null) {
                bgc();
            }
            if (this.fYi != null) {
                this.fYi.cancel();
                this.fYi.setDuration(300L).start();
            }
        }
    }

    public void Pi() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Pj() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Pk() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean awu() {
        return (this.fYi != null && this.fYi.isRunning()) || (this.fYj != null && this.fYj.isRunning());
    }

    public void hideFloatingView() {
        if (this.dHC) {
            if (this.bpt) {
                fY(true);
            } else if (this.fYk != null && !this.fYo && !this.fVO && bgd()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Pj();
            }
        }
    }

    public void showFloatingView() {
        if (this.dHC) {
            if (this.bpt) {
                fY(true);
            } else if (this.fYk != null && !bgd()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Pi();
            }
        }
    }

    public boolean bgd() {
        return this.fYk.getVisibility() == 0 && this.fYk.getY() >= 0.0f;
    }

    public void kT(boolean z) {
        this.fYo = z;
    }

    public void kU(boolean z) {
        this.fVO = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dHC && this.fYk != null && !this.fYo && !this.fVO && this.fYn) {
            if (i > this.bDu && bgd()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bDu && !bgd()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bDu = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fYn = true;
        } else if (i == 0) {
            this.fYn = false;
        }
        if (this.dHC && !this.fYo && !this.fVO) {
            if (this.bpt) {
                fY(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bDu) {
                    Pj();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bDu) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Pi();
                } else if (firstVisiblePosition == this.bDu) {
                    if (firstVisiblePosition == 0 || !this.bDv || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Pi();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Pj();
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

    private void XD() {
        if (this.dGq != null) {
            if (this.dHB && this.dGq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dGq.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dGq.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY(boolean z) {
        if (this.dGq != null) {
            if (this.dHB && z && this.dGq.getVisibility() != 0) {
                this.dGq.setVisibility(0);
            } else if (!z && this.dGq.getVisibility() != 8) {
                this.dGq.setVisibility(8);
            }
        }
    }
}
