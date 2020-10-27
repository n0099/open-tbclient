package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class f {
    private FragmentActivity lHb;
    private ViewGroup lHc;
    private View lHd;
    private ViewGroup.LayoutParams lHe;
    private ViewGroup.LayoutParams lHf;
    private View lHg;
    private Rect lHh;
    private Rect lHi;
    private ValueAnimator lHk;
    private ValueAnimator lHl;
    private Animator.AnimatorListener lHm;
    private View[] lHn;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean lHj = true;
    private boolean aEQ = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.lHb = fragmentActivity;
        this.lHd = view;
        this.lHc = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.lHg = this.lHc.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.lHc.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.lHn = new View[3];
        this.lHn[0] = this.lHc.findViewById(R.id.pb_video_view_pager);
        this.lHn[1] = this.lHc.findViewById(R.id.pb_video_tab_strip);
        this.lHn[2] = this.lHc.findViewById(R.id.video_pb_comment_container);
        this.lHc.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.lHc.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.lHc.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.lHc.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.lHc.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.lHc.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.lHc.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.lHc.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.lHb);
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.lHc.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.lHk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lHk.setInterpolator(new DecelerateInterpolator());
        this.lHk.setDuration(300L);
        this.lHk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aH(valueAnimator.getAnimatedFraction());
            }
        });
        this.lHk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.lHm != null) {
                    f.this.lHm.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.doZ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.doZ();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lHl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lHl.setDuration(100L);
        this.lHl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aG(valueAnimator.getAnimatedFraction());
            }
        });
        this.lHl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.lHc.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.lHn) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.doY();
                if (f.this.lHm != null) {
                    f.this.lHm.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.doY();
                if (f.this.lHm != null) {
                    f.this.lHm.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doY() {
        this.aEQ = false;
        for (View view : this.lHn) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doZ() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.lHd.setTranslationX(0.0f);
        this.lHd.setTranslationY(0.0f);
        this.lHg.setLayoutParams(this.lHe);
        if (this.lHg.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.lHg.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.lHd instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.lHd).getOriginHeight() - ((VideoContainerLayout) this.lHd).getMaxHeight());
            }
        }
        this.lHd.setLayoutParams(this.lHf);
        this.lHl.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.lHh = rect;
        this.lHi = rect2;
        if (dpa()) {
            init();
        }
    }

    public void start() {
        this.lHj = false;
        this.aEQ = true;
        for (View view : this.lHn) {
            view.setVisibility(8);
        }
        this.lHe = this.lHg.getLayoutParams();
        this.lHg.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.lHf = this.lHd.getLayoutParams();
        this.lHd.setLayoutParams(new RelativeLayout.LayoutParams(this.lHf.width, this.lHf.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.lHk.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        for (View view : this.lHn) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        float width = this.lHh.width() + ((this.lHi.width() - this.lHh.width()) * f);
        float height = this.lHh.height() + ((this.lHi.height() - this.lHh.height()) * f);
        float f2 = this.lHh.left + ((this.lHi.left - this.lHh.left) * f);
        float f3 = this.lHh.top + ((this.lHi.top - this.lHh.top) * f);
        int i = (int) (f2 - this.lHi.left);
        int i2 = (int) (f3 - this.lHi.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.lHd.setTranslationX(i);
        this.lHd.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.lHd.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.lHd.setLayoutParams(layoutParams);
        }
    }

    public boolean dpa() {
        return (!this.lHj || this.lHh == null || this.lHh.isEmpty() || this.lHi == null || this.lHi.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.lHm = animatorListener;
    }

    public boolean isPlaying() {
        return this.aEQ;
    }
}
