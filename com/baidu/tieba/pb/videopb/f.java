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
    private FragmentActivity lMX;
    private ViewGroup lMY;
    private View lMZ;
    private ViewGroup.LayoutParams lNa;
    private ViewGroup.LayoutParams lNb;
    private View lNc;
    private Rect lNd;
    private Rect lNe;
    private ValueAnimator lNg;
    private ValueAnimator lNh;
    private Animator.AnimatorListener lNi;
    private View[] lNj;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean lNf = true;
    private boolean aFG = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.lMX = fragmentActivity;
        this.lMZ = view;
        this.lMY = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.lNc = this.lMY.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.lMY.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.lNj = new View[3];
        this.lNj[0] = this.lMY.findViewById(R.id.pb_video_view_pager);
        this.lNj[1] = this.lMY.findViewById(R.id.pb_video_tab_strip);
        this.lNj[2] = this.lMY.findViewById(R.id.video_pb_comment_container);
        this.lMY.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.lMY.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.lMY.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.lMY.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.lMY.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.lMY.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.lMY.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.lMY.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.lMX);
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.lMY.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.lNg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lNg.setInterpolator(new DecelerateInterpolator());
        this.lNg.setDuration(300L);
        this.lNg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aJ(valueAnimator.getAnimatedFraction());
            }
        });
        this.lNg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.lNi != null) {
                    f.this.lNi.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.drB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.drB();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lNh = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lNh.setDuration(100L);
        this.lNh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aI(valueAnimator.getAnimatedFraction());
            }
        });
        this.lNh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.lMY.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.lNj) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.drA();
                if (f.this.lNi != null) {
                    f.this.lNi.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.drA();
                if (f.this.lNi != null) {
                    f.this.lNi.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drA() {
        this.aFG = false;
        for (View view : this.lNj) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drB() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.lMZ.setTranslationX(0.0f);
        this.lMZ.setTranslationY(0.0f);
        this.lNc.setLayoutParams(this.lNa);
        if (this.lNc.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.lNc.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.lMZ instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.lMZ).getOriginHeight() - ((VideoContainerLayout) this.lMZ).getMaxHeight());
            }
        }
        this.lMZ.setLayoutParams(this.lNb);
        this.lNh.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.lNd = rect;
        this.lNe = rect2;
        if (drC()) {
            init();
        }
    }

    public void start() {
        this.lNf = false;
        this.aFG = true;
        for (View view : this.lNj) {
            view.setVisibility(8);
        }
        this.lNa = this.lNc.getLayoutParams();
        this.lNc.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.lNb = this.lMZ.getLayoutParams();
        this.lMZ.setLayoutParams(new RelativeLayout.LayoutParams(this.lNb.width, this.lNb.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.lNg.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(float f) {
        for (View view : this.lNj) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aJ(float f) {
        float width = this.lNd.width() + ((this.lNe.width() - this.lNd.width()) * f);
        float height = this.lNd.height() + ((this.lNe.height() - this.lNd.height()) * f);
        float f2 = this.lNd.left + ((this.lNe.left - this.lNd.left) * f);
        float f3 = this.lNd.top + ((this.lNe.top - this.lNd.top) * f);
        int i = (int) (f2 - this.lNe.left);
        int i2 = (int) (f3 - this.lNe.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.lMZ.setTranslationX(i);
        this.lMZ.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.lMZ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.lMZ.setLayoutParams(layoutParams);
        }
    }

    public boolean drC() {
        return (!this.lNf || this.lNd == null || this.lNd.isEmpty() || this.lNe == null || this.lNe.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.lNi = animatorListener;
    }

    public boolean isPlaying() {
        return this.aFG;
    }
}
