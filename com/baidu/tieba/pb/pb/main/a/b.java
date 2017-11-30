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
    private View cIM;
    private a eTi;
    private Animator feV;
    private Animator feW;
    private ValueAnimator feX;
    private ValueAnimator feY;
    private AnimatorSet feZ;
    private AnimatorSet ffa;
    private View ffb;
    private View ffc;
    private int ffd = UtilHelper.getLightStatusBarHeight();
    private boolean ffe = false;
    private boolean ayA = false;
    private int aNg = 0;
    private boolean fff = false;
    private boolean fcJ = false;
    private boolean ffg = false;
    private boolean aNh = false;
    private boolean cKj = true;
    private final Handler.Callback cKl = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.amy()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.amx();
                    return true;
                case 2:
                    b.this.amv();
                    return true;
                case 3:
                    b.this.amw();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cKl);
    private boolean cKi = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void jj(boolean z);
    }

    public void a(a aVar) {
        this.eTi = aVar;
    }

    public void fb(boolean z) {
        this.aNh = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.ffb = view;
        this.cIM = view2;
        this.GN = view3;
        this.ffc = this.GN.findViewById(d.g.sticky_view);
        amz();
        fd(false);
    }

    private void aWV() {
        this.feV = ObjectAnimator.ofFloat(this.ffb, "translationY", (-this.ffb.getMeasuredHeight()) + this.GN.getMeasuredHeight());
        this.feV.setInterpolator(new LinearInterpolator());
        this.feV.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ffb != null) {
                    b.this.ffb.clearAnimation();
                    if (b.this.ffg) {
                        b.this.fd(false);
                    } else {
                        b.this.fd(true);
                    }
                    if (b.this.eTi != null) {
                        b.this.eTi.jj(false);
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
        this.feY = ValueAnimator.ofInt(0, this.ffd);
        this.feY.setInterpolator(new LinearInterpolator());
        this.feY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ffc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ffc.setLayoutParams(layoutParams);
                }
                b.this.ffc.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.ffc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ffd;
                    b.this.ffc.setLayoutParams(layoutParams);
                }
                b.this.ffc.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.feY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ffc.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ffc.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.ffa = new AnimatorSet();
        this.ffa.play(this.feV).with(this.feY);
    }

    private void aWW() {
        this.feW = ObjectAnimator.ofFloat(this.ffb, "translationY", 0.0f);
        this.feW.setInterpolator(new LinearInterpolator());
        this.feW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.ffb != null) {
                    b.this.ffb.clearAnimation();
                    b.this.ffb.setVisibility(0);
                    b.this.fd(false);
                    if (b.this.eTi != null) {
                        b.this.eTi.jj(true);
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
        this.feX = ValueAnimator.ofInt(this.ffd, 0);
        this.feX.setInterpolator(new LinearInterpolator());
        this.feX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.ffc.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.ffc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.ffd;
                    b.this.ffc.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.ffc.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.ffc.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.ffc.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.feX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.ffc.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.ffc.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.feZ = new AnimatorSet();
        this.feZ.play(this.feW).with(this.feX);
    }

    public void amv() {
        w(false, false);
    }

    public void amw() {
        w(false, true);
    }

    public void w(boolean z, boolean z2) {
        if (this.ffb != null && this.ffb.getY() == 0.0f && !amy()) {
            if (z2) {
                this.ffb.setVisibility(8);
                if (this.ffg) {
                    fd(false);
                    return;
                } else {
                    fd(true);
                    return;
                }
            }
            this.ffb.setVisibility(0);
            if (this.ffa == null) {
                aWV();
            }
            if (this.ffa != null) {
                this.ffa.cancel();
                this.ffa.setDuration(300L).start();
            }
        }
    }

    public void amx() {
        if (this.ffb != null && this.ffb.getY() < 0.0f && !amy()) {
            this.ffb.setVisibility(0);
            if (this.feZ == null) {
                aWW();
            }
            if (this.feZ != null) {
                this.feZ.cancel();
                this.feZ.setDuration(300L).start();
            }
        }
    }

    public void Hn() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Ho() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hp() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean amy() {
        return (this.feZ != null && this.feZ.isRunning()) || (this.ffa != null && this.ffa.isRunning());
    }

    public void hideFloatingView() {
        if (this.cKj) {
            if (this.ayA) {
                fd(true);
            } else if (this.ffb != null && !this.fff && !this.fcJ && aWX()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Ho();
            }
        }
    }

    public void showFloatingView() {
        if (this.cKj) {
            if (this.ayA) {
                fd(true);
            } else if (this.ffb != null && !aWX()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Hn();
            }
        }
    }

    public boolean aWX() {
        return this.ffb.getVisibility() == 0 && this.ffb.getY() >= 0.0f;
    }

    public void kd(boolean z) {
        this.fff = z;
    }

    public void ke(boolean z) {
        this.fcJ = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cKj && this.ffb != null && !this.fff && !this.fcJ && this.ffe) {
            if (i > this.aNg && aWX()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aNg && !aWX()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aNg = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.ffe = true;
        } else if (i == 0) {
            this.ffe = false;
        }
        if (this.cKj && !this.fff && !this.fcJ) {
            if (this.ayA) {
                fd(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aNg) {
                    Ho();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aNg) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Hn();
                } else if (firstVisiblePosition == this.aNg) {
                    if (firstVisiblePosition == 0 || !this.aNh || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Hn();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Ho();
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

    private void amz() {
        if (this.cIM != null) {
            if (this.cKi && this.cIM.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.cIM.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.cIM.setLayoutParams(layoutParams);
                fd(true);
                return;
            }
            fd(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(boolean z) {
        if (this.cIM != null) {
            if (this.cKi && z && this.cIM.getVisibility() != 0) {
                this.cIM.setVisibility(0);
            } else if (!z && this.cIM.getVisibility() != 8) {
                this.cIM.setVisibility(8);
            }
        }
    }
}
