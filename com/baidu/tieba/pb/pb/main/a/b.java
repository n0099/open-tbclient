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
    private View Ha;
    private View ceh;
    private a eIn;
    private Animator eUl;
    private Animator eUm;
    private ValueAnimator eUn;
    private ValueAnimator eUo;
    private AnimatorSet eUp;
    private AnimatorSet eUq;
    private View eUr;
    private View eUs;
    private Context mContext;
    private int eUt = UtilHelper.getLightStatusBarHeight();
    private boolean eUu = false;
    private boolean awB = false;
    private int aMx = 0;
    private boolean eUv = false;
    private boolean eUw = false;
    private boolean aMy = false;
    private boolean cej = true;
    private final Handler.Callback cek = new Handler.Callback() { // from class: com.baidu.tieba.pb.pb.main.a.b.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if ((message.what == 1 || message.what == 2) && b.this.adJ()) {
                b.this.mHandler.sendEmptyMessageDelayed(message.what, 100L);
                return true;
            }
            switch (message.what) {
                case 1:
                    b.this.adI();
                    return true;
                case 2:
                    b.this.adG();
                    return true;
                case 3:
                    b.this.adH();
                    return true;
                default:
                    return false;
            }
        }
    };
    private final Handler mHandler = new Handler(this.cek);
    private boolean cei = UtilHelper.canUseStyleImmersiveSticky();

    /* loaded from: classes.dex */
    public interface a {
        void et(boolean z);
    }

    public void a(a aVar) {
        this.eIn = aVar;
    }

    public void er(boolean z) {
        this.aMy = z;
    }

    public b(Context context, View view, View view2, View view3) {
        this.mContext = context;
        this.eUr = view;
        this.ceh = view2;
        this.Ha = view3;
        this.eUs = this.Ha.findViewById(d.h.sticky_view);
        adK();
        es(false);
    }

    private void adE() {
        this.eUl = ObjectAnimator.ofFloat(this.eUr, "translationY", (-this.eUr.getMeasuredHeight()) + this.Ha.getMeasuredHeight());
        this.eUl.setInterpolator(new LinearInterpolator());
        this.eUl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eUr != null) {
                    b.this.eUr.clearAnimation();
                    if (b.this.eUw) {
                        b.this.es(false);
                    } else {
                        b.this.es(true);
                    }
                    if (b.this.eIn != null) {
                        b.this.eIn.et(false);
                    }
                    b.this.Ha.clearAnimation();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eUo = ValueAnimator.ofInt(0, this.eUt);
        this.eUo.setInterpolator(new LinearInterpolator());
        this.eUo.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eUs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eUs.setLayoutParams(layoutParams);
                }
                b.this.eUs.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ViewGroup.LayoutParams layoutParams = b.this.eUs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eUt;
                    b.this.eUs.setLayoutParams(layoutParams);
                }
                b.this.eUs.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eUo.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eUs.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eUs.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eUq = new AnimatorSet();
        this.eUq.play(this.eUl).with(this.eUo);
    }

    private void adF() {
        this.eUm = ObjectAnimator.ofFloat(this.eUr, "translationY", 0.0f);
        this.eUm.setInterpolator(new LinearInterpolator());
        this.eUm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (b.this.eUr != null) {
                    b.this.eUr.clearAnimation();
                    b.this.eUr.setVisibility(0);
                    b.this.es(false);
                    if (b.this.eIn != null) {
                        b.this.eIn.et(true);
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
        this.eUn = ValueAnimator.ofInt(this.eUt, 0);
        this.eUn.setInterpolator(new LinearInterpolator());
        this.eUn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.eUs.setVisibility(0);
                ViewGroup.LayoutParams layoutParams = b.this.eUs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = b.this.eUt;
                    b.this.eUs.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.eUs.setVisibility(8);
                ViewGroup.LayoutParams layoutParams = b.this.eUs.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = 0;
                    b.this.eUs.setLayoutParams(layoutParams);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eUn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.pb.main.a.b.7
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator != null && (valueAnimator.getAnimatedValue() instanceof Integer)) {
                    Integer num = (Integer) valueAnimator.getAnimatedValue();
                    ViewGroup.LayoutParams layoutParams = b.this.eUs.getLayoutParams();
                    if (layoutParams != null) {
                        layoutParams.height = num.intValue();
                        b.this.eUs.setLayoutParams(layoutParams);
                    }
                }
            }
        });
        this.eUp = new AnimatorSet();
        this.eUp.play(this.eUm).with(this.eUn);
    }

    public void adG() {
        r(false, false);
    }

    public void adH() {
        r(false, true);
    }

    public void r(boolean z, boolean z2) {
        if (this.eUr != null && this.eUr.getY() == 0.0f && !adJ()) {
            if (z2) {
                this.eUr.setVisibility(8);
                if (this.eUw) {
                    es(false);
                    return;
                } else {
                    es(true);
                    return;
                }
            }
            this.eUr.setVisibility(0);
            if (this.eUq == null) {
                adE();
            }
            if (this.eUq != null) {
                this.eUq.cancel();
                this.eUq.setDuration(300L).start();
            }
        }
    }

    public void adI() {
        if (this.eUr != null && this.eUr.getY() < 0.0f && !adJ()) {
            this.eUr.setVisibility(0);
            if (this.eUp == null) {
                adF();
            }
            if (this.eUp != null) {
                this.eUp.cancel();
                this.eUp.setDuration(300L).start();
            }
        }
    }

    public void Hl() {
        this.mHandler.removeMessages(2);
        if (!this.mHandler.hasMessages(1)) {
            this.mHandler.sendEmptyMessageDelayed(1, 60L);
        }
    }

    public void Hm() {
        this.mHandler.removeMessages(1);
        if (!this.mHandler.hasMessages(2)) {
            this.mHandler.sendEmptyMessageDelayed(2, 110L);
        }
    }

    public void Hn() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public boolean adJ() {
        return (this.eUp != null && this.eUp.isRunning()) || (this.eUq != null && this.eUq.isRunning());
    }

    public void hideFloatingView() {
        if (this.cej) {
            if (this.awB) {
                es(true);
            } else if (this.eUr != null && !this.eUv && aUn()) {
                Log.i("PbView", "hideFloatingView: startDragDown");
                Hm();
            }
        }
    }

    public void showFloatingView() {
        if (this.cej) {
            if (this.awB) {
                es(true);
            } else if (this.eUr != null && !aUn()) {
                Log.i("PbView", "showFloatingView: startDragUp");
                Hl();
            }
        }
    }

    private boolean aUn() {
        return this.eUr.getVisibility() == 0 && this.eUr.getY() >= 0.0f;
    }

    public void jT(boolean z) {
        this.eUv = z;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.cej && this.eUr != null && !this.eUv && this.eUu) {
            if (i > this.aMx && aUn()) {
                Log.i("PbView", "onScroll hideFloatingView");
                hideFloatingView();
            } else if (i < this.aMx && !aUn()) {
                Log.i("PbView", "onScroll showFloatingView");
                showFloatingView();
            }
            this.aMx = i;
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.eUu = true;
        } else if (i == 0) {
            this.eUu = false;
        }
        if (this.cej && !this.eUv) {
            if (this.awB) {
                es(true);
            } else if (absListView != null && i == 0) {
                int firstVisiblePosition = absListView.getFirstVisiblePosition();
                if (firstVisiblePosition > this.aMx) {
                    Hm();
                    Log.i("PbView", "onScrollStateChanged startDragDown: firstVisibleItem > mLastFirstVisibleItem");
                } else if (firstVisiblePosition < this.aMx) {
                    Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem < mLastFirstVisibleItem");
                    Hl();
                } else if (firstVisiblePosition == this.aMx) {
                    if (firstVisiblePosition == 0 || !this.aMy || a(absListView)) {
                        Log.i("PbView", "onScrollStateChanged startDragUp: firstVisibleItem == 0");
                        Hl();
                        return;
                    }
                    Log.i("PbView", "onScrollStateChanged startDragDown:");
                    Hm();
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

    private void adK() {
        if (this.ceh != null) {
            if (this.cei && this.ceh.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.ceh.getLayoutParams();
                layoutParams.height = UtilHelper.getStatusBarHeight();
                this.ceh.setLayoutParams(layoutParams);
                es(true);
                return;
            }
            es(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void es(boolean z) {
        if (this.ceh != null) {
            if (this.cei && z && this.ceh.getVisibility() != 0) {
                this.ceh.setVisibility(0);
            } else if (!z && this.ceh.getVisibility() != 8) {
                this.ceh.setVisibility(8);
            }
        }
    }
}
