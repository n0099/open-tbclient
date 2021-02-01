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
/* loaded from: classes2.dex */
public class b {
    private View bLj;
    private a lSu;
    private View mExpandView;
    private Animator meb;
    private Animator mec;
    private ValueAnimator med;
    private ValueAnimator mee;
    private AnimatorSet mef;
    private AnimatorSet meg;
    private View meh;
    private View mei;
    private int mej = UtilHelper.getLightStatusBarHeight();
    private boolean mek = false;
    private boolean fyD = false;
    private int fNi = 0;
    private boolean mel = false;
    private boolean maj = false;
    private boolean men = false;
    private boolean fNj = false;
    private boolean jla = true;
    private final Handler.Callback jld = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.b.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.cEN()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.cEL();
                    return true;
                case 2:
                    b.this.cEJ();
                    return true;
                case 3:
                    b.this.cEK();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.jld);
    private boolean bLk = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes2.dex */
    public interface a {
        void vg(boolean z);
    }

    public void a(a aVar) {
        this.lSu = aVar;
    }

    public void qR(boolean z) {
        this.fNj = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.meh = view;
        this.bLj = view2;
        this.mExpandView = view3;
        this.mei = this.mExpandView.findViewById(R.id.sticky_view);
        Uh();
        dm(false);
    }

    private void dsa() {
        this.meb = ObjectAnimator.ofFloat(this.meh, "translationY", (-this.meh.getMeasuredHeight()) + this.mExpandView.getMeasuredHeight());
        this.meb.setInterpolator(new LinearInterpolator());
        this.meb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.meh != null) {
                    b.this.meh.clearAnimation();
                    if (b.this.men) {
                        b.this.dm(false);
                    } else {
                        b.this.dm(true);
                    }
                    if (b.this.lSu != null) {
                        b.this.lSu.vg(false);
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
        this.mee = ValueAnimator.ofInt(0, this.mej);
        this.mee.setInterpolator(new LinearInterpolator());
        this.mee.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.mei.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.mei.setLayoutParams(layoutParams);
                }
                b.this.mei.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.mei.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.mej;
                    b.this.mei.setLayoutParams(layoutParams);
                }
                b.this.mei.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mee.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.mei.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.mei.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.meg = new AnimatorSet();
        this.meg.play(this.meb).with(this.mee);
    }

    private void dsb() {
        this.mec = ObjectAnimator.ofFloat(this.meh, "translationY", 0.0f);
        this.mec.setInterpolator(new LinearInterpolator());
        this.mec.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.meh != null) {
                    b.this.meh.clearAnimation();
                    b.this.meh.setVisibility(0);
                    b.this.dm(false);
                    if (b.this.lSu != null) {
                        b.this.lSu.vg(true);
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
        this.med = ValueAnimator.ofInt(this.mej, 0);
        this.med.setInterpolator(new LinearInterpolator());
        this.med.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.mei.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.mei.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.mej;
                    b.this.mei.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.mei.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.mei.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.mei.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.med.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.b.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.mei.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.mei.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.mef = new AnimatorSet();
        this.mef.play(this.mec).with(this.med);
    }

    public void cEJ() {
        ab(false, false);
    }

    public void cEK() {
        ab(false, true);
    }

    public void ab(boolean z, boolean z2) {
        if (this.meh != null && this.meh.getY() == 0.0f && !cEN()) {
            if (z2) {
                this.meh.setVisibility(8);
                if (this.men) {
                    dm(false);
                    return;
                } else {
                    dm(true);
                    return;
                }
            }
            this.meh.setVisibility(0);
            if (this.meg == null) {
                dsa();
            }
            if (this.meg != null) {
                this.meg.cancel();
                this.meg.setDuration(300L).start();
            }
        }
    }

    public void cEL() {
        if (this.meh != null && this.meh.getY() < 0.0f && !cEN()) {
            this.meh.setVisibility(0);
            if (this.mef == null) {
                dsb();
            }
            if (this.mef != null) {
                this.mef.cancel();
                this.mef.setDuration(300L).start();
            }
        }
    }

    public void bFD() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void bFE() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void cEM() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean cEN() {
        return (this.mef != null && this.mef.isRunning()) || (this.meg != null && this.meg.isRunning());
    }

    public void hideFloatingView() {
        if (this.jla) {
            if (this.fyD) {
                dm(true);
            } else if (this.meh != null && !this.mel && !this.maj && dsc()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                bFE();
            }
        }
    }

    public void showFloatingView() {
        if (this.jla) {
            if (this.fyD) {
                dm(true);
            } else if (this.meh != null && !dsc()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                bFD();
            }
        }
    }

    public boolean dsc() {
        return this.meh.getVisibility() == 0 && this.meh.getY() >= 0.0f;
    }

    public void vW(boolean z) {
        this.mel = z;
    }

    public void vX(boolean z) {
        this.maj = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.jla && this.meh != null && !this.mel && !this.maj && this.mek) {
            if (i > this.fNi && dsc()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.fNi && !dsc()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.fNi = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.mek = true;
        } else if (i == 0) {
            this.mek = false;
        }
        if (this.jla && !this.mel && !this.maj) {
            if (this.fyD) {
                dm(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.fNi) {
                    bFE();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.fNi) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    bFD();
                } else if (firstVisiblePosition == this.fNi) {
                    if (firstVisiblePosition == 0 || !this.fNj || b(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        bFD();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    bFE();
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

    private void Uh() {
        if (this.bLj != null) {
            if (this.bLk && this.bLj.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.bLj.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.bLj.setLayoutParams(layoutParams);
                dm(true);
                return;
            }
            dm(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dm(boolean z) {
        if (this.bLj != null) {
            if (this.bLk && z && this.bLj.getVisibility() != 0) {
                this.bLj.setVisibility(0);
            } else if (!z && this.bLj.getVisibility() != 8) {
                this.bLj.setVisibility(8);
            }
        }
    }
}
