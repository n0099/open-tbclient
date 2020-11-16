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
/* loaded from: classes21.dex */
public class f {
    private Animator.AnimatorListener lNA;
    private View[] lNB;
    private FragmentActivity lNp;
    private ViewGroup lNq;
    private View lNr;
    private ViewGroup.LayoutParams lNs;
    private ViewGroup.LayoutParams lNt;
    private View lNu;
    private Rect lNv;
    private Rect lNw;
    private ValueAnimator lNy;
    private ValueAnimator lNz;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean lNx = true;
    private boolean aDV = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.lNp = fragmentActivity;
        this.lNr = view;
        this.lNq = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.lNu = this.lNq.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.lNq.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.lNB = new View[3];
        this.lNB[0] = this.lNq.findViewById(R.id.pb_video_view_pager);
        this.lNB[1] = this.lNq.findViewById(R.id.pb_video_tab_strip);
        this.lNB[2] = this.lNq.findViewById(R.id.video_pb_comment_container);
        this.lNq.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.lNq.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.lNq.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.lNq.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.lNq.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.lNq.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.lNq.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.lNq.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.lNp);
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.lNq.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.lNy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lNy.setInterpolator(new DecelerateInterpolator());
        this.lNy.setDuration(300L);
        this.lNy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aQ(valueAnimator.getAnimatedFraction());
            }
        });
        this.lNy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.lNA != null) {
                    f.this.lNA.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.drb();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.drb();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lNz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lNz.setDuration(100L);
        this.lNz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aP(valueAnimator.getAnimatedFraction());
            }
        });
        this.lNz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.lNq.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.CAM_X0201);
                for (View view : f.this.lNB) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dra();
                if (f.this.lNA != null) {
                    f.this.lNA.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dra();
                if (f.this.lNA != null) {
                    f.this.lNA.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dra() {
        this.aDV = false;
        for (View view : this.lNB) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drb() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.lNr.setTranslationX(0.0f);
        this.lNr.setTranslationY(0.0f);
        this.lNu.setLayoutParams(this.lNs);
        if (this.lNu.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.lNu.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.lNr instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.lNr).getOriginHeight() - ((VideoContainerLayout) this.lNr).getMaxHeight());
            }
        }
        this.lNr.setLayoutParams(this.lNt);
        this.lNz.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.lNv = rect;
        this.lNw = rect2;
        if (drc()) {
            init();
        }
    }

    public void start() {
        this.lNx = false;
        this.aDV = true;
        for (View view : this.lNB) {
            view.setVisibility(8);
        }
        this.lNs = this.lNu.getLayoutParams();
        this.lNu.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.lNt = this.lNr.getLayoutParams();
        this.lNr.setLayoutParams(new RelativeLayout.LayoutParams(this.lNt.width, this.lNt.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.lNy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aP(float f) {
        for (View view : this.lNB) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(float f) {
        float width = this.lNv.width() + ((this.lNw.width() - this.lNv.width()) * f);
        float height = this.lNv.height() + ((this.lNw.height() - this.lNv.height()) * f);
        float f2 = this.lNv.left + ((this.lNw.left - this.lNv.left) * f);
        float f3 = this.lNv.top + ((this.lNw.top - this.lNv.top) * f);
        int i = (int) (f2 - this.lNw.left);
        int i2 = (int) (f3 - this.lNw.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.lNr.setTranslationX(i);
        this.lNr.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.lNr.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.lNr.setLayoutParams(layoutParams);
        }
    }

    public boolean drc() {
        return (!this.lNx || this.lNv == null || this.lNv.isEmpty() || this.lNw == null || this.lNw.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.lNA = animatorListener;
    }

    public boolean isPlaying() {
        return this.aDV;
    }
}
