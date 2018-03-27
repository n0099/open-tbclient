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
    private View auE;
    private View dGj;
    private a fMc;
    private Animator fYj;
    private Animator fYk;
    private ValueAnimator fYl;
    private ValueAnimator fYm;
    private AnimatorSet fYn;
    private AnimatorSet fYo;
    private View fYp;
    private View fYq;
    private int fYr = UtilHelper.getLightStatusBarHeight();
    private boolean fYs = false;
    private boolean bpj = false;
    private int bDk = 0;
    private boolean fYt = false;
    private boolean fVT = false;
    private boolean fYu = false;
    private boolean bDl = false;
    private boolean dHv = true;
    private final Handler.Callback dHx = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.awv()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.awu();
                    return true;
                case 2:
                    b.this.aws();
                    return true;
                case 3:
                    b.this.awt();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.dHx);
    private boolean dHu = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void kg(boolean z);
    }

    public void a(a aVar) {
        this.fMc = aVar;
    }

    public void fW(boolean z) {
        this.bDl = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.fYp = view;
        this.dGj = view2;
        this.auE = view3;
        this.fYq = this.auE.findViewById(d.g.sticky_view);
        XD();
        fY(false);
    }

    private void bgb() {
        this.fYj = ObjectAnimator.ofFloat(this.fYp, "translationY", (-this.fYp.getMeasuredHeight()) + this.auE.getMeasuredHeight());
        this.fYj.setInterpolator(new LinearInterpolator());
        this.fYj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fYp != null) {
                    b.this.fYp.clearAnimation();
                    if (b.this.fYu) {
                        b.this.fY(false);
                    } else {
                        b.this.fY(true);
                    }
                    if (b.this.fMc != null) {
                        b.this.fMc.kg(false);
                    }
                    b.this.auE.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYm = ValueAnimator.ofInt(0, this.fYr);
        this.fYm.setInterpolator(new LinearInterpolator());
        this.fYm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYq.setLayoutParams(layoutParams);
                }
                b.this.fYq.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.fYq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYr;
                    b.this.fYq.setLayoutParams(layoutParams);
                }
                b.this.fYq.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYq.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYq.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fYo = new AnimatorSet();
        this.fYo.play(this.fYj).with(this.fYm);
    }

    private void bgc() {
        this.fYk = ObjectAnimator.ofFloat(this.fYp, "translationY", 0.0f);
        this.fYk.setInterpolator(new LinearInterpolator());
        this.fYk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.fYp != null) {
                    b.this.fYp.clearAnimation();
                    b.this.fYp.setVisibility(0);
                    b.this.fY(false);
                    if (b.this.fMc != null) {
                        b.this.fMc.kg(true);
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
        this.fYl = ValueAnimator.ofInt(this.fYr, 0);
        this.fYl.setInterpolator(new LinearInterpolator());
        this.fYl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.fYq.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.fYq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.fYr;
                    b.this.fYq.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.fYq.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.fYq.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.fYq.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fYl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.fYq.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.fYq.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.fYn = new AnimatorSet();
        this.fYn.play(this.fYk).with(this.fYl);
    }

    public void aws() {
        z(false, false);
    }

    public void awt() {
        z(false, true);
    }

    public void z(boolean z, boolean z2) {
        if (this.fYp != null && this.fYp.getY() == 0.0f && !awv()) {
            if (z2) {
                this.fYp.setVisibility(8);
                if (this.fYu) {
                    fY(false);
                    return;
                } else {
                    fY(true);
                    return;
                }
            }
            this.fYp.setVisibility(0);
            if (this.fYo == null) {
                bgb();
            }
            if (this.fYo != null) {
                this.fYo.cancel();
                this.fYo.setDuration(300L).start();
            }
        }
    }

    public void awu() {
        if (this.fYp != null && this.fYp.getY() < 0.0f && !awv()) {
            this.fYp.setVisibility(0);
            if (this.fYn == null) {
                bgc();
            }
            if (this.fYn != null) {
                this.fYn.cancel();
                this.fYn.setDuration(300L).start();
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

    public boolean awv() {
        return (this.fYn != null && this.fYn.isRunning()) || (this.fYo != null && this.fYo.isRunning());
    }

    public void hideFloatingView() {
        if (this.dHv) {
            if (this.bpj) {
                fY(true);
            } else if (this.fYp != null && !this.fYt && !this.fVT && bgd()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Pj();
            }
        }
    }

    public void showFloatingView() {
        if (this.dHv) {
            if (this.bpj) {
                fY(true);
            } else if (this.fYp != null && !bgd()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Pi();
            }
        }
    }

    public boolean bgd() {
        return this.fYp.getVisibility() == 0 && this.fYp.getY() >= 0.0f;
    }

    public void kY(boolean z) {
        this.fYt = z;
    }

    public void kZ(boolean z) {
        this.fVT = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.dHv && this.fYp != null && !this.fYt && !this.fVT && this.fYs) {
            if (i > this.bDk && bgd()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.bDk && !bgd()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.bDk = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.fYs = true;
        } else if (i == 0) {
            this.fYs = false;
        }
        if (this.dHv && !this.fYt && !this.fVT) {
            if (this.bpj) {
                fY(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.bDk) {
                    Pj();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.bDk) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Pi();
                } else if (firstVisiblePosition == this.bDk) {
                    if (firstVisiblePosition == 0 || !this.bDl || a(absListView)) {
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
        if (this.dGj != null) {
            if (this.dHu && this.dGj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.dGj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.dGj.setLayoutParams(layoutParams);
                fY(true);
                return;
            }
            fY(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fY(boolean z) {
        if (this.dGj != null) {
            if (this.dHu && z && this.dGj.getVisibility() != 0) {
                this.dGj.setVisibility(0);
            } else if (!z && this.dGj.getVisibility() != 8) {
                this.dGj.setVisibility(8);
            }
        }
    }
}
