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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f {
    private Animator.AnimatorListener iZA;
    private View[] iZB;
    private FragmentActivity iZp;
    private ViewGroup iZq;
    private View iZr;
    private ViewGroup.LayoutParams iZs;
    private ViewGroup.LayoutParams iZt;
    private View iZu;
    private Rect iZv;
    private Rect iZw;
    private ValueAnimator iZy;
    private ValueAnimator iZz;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean iZx = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.iZp = fragmentActivity;
        this.iZr = view;
        this.iZq = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.iZu = this.iZq.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.iZq.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.iZB = new View[3];
        this.iZB[0] = this.iZq.findViewById(R.id.pb_video_view_pager);
        this.iZB[1] = this.iZq.findViewById(R.id.pb_video_tab_strip);
        this.iZB[2] = this.iZq.findViewById(R.id.video_pb_comment_container);
        this.iZq.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.iZq.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.iZq.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.iZq.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.iZq.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.iZq.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.iZq.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.iZq.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.iZp);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.iZq.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iZy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iZy.setInterpolator(new DecelerateInterpolator());
        this.iZy.setDuration(300L);
        this.iZy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aG(valueAnimator.getAnimatedFraction());
            }
        });
        this.iZy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.iZA != null) {
                    f.this.iZA.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.ctq();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.ctq();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iZz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iZz.setDuration(100L);
        this.iZz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aF(valueAnimator.getAnimatedFraction());
            }
        });
        this.iZz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.iZq.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.iZB) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.ctp();
                if (f.this.iZA != null) {
                    f.this.iZA.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.ctp();
                if (f.this.iZA != null) {
                    f.this.iZA.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctp() {
        this.isPlaying = false;
        for (View view : this.iZB) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctq() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.iZr.setTranslationX(0.0f);
        this.iZr.setTranslationY(0.0f);
        this.iZu.setLayoutParams(this.iZs);
        if (this.iZu.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.iZu.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.iZr instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.iZr).getOriginHeight() - ((VideoContainerLayout) this.iZr).getMaxHeight());
            }
        }
        this.iZr.setLayoutParams(this.iZt);
        this.iZz.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.iZv = rect;
        this.iZw = rect2;
        if (ctr()) {
            init();
        }
    }

    public void start() {
        this.iZx = false;
        this.isPlaying = true;
        for (View view : this.iZB) {
            view.setVisibility(8);
        }
        this.iZs = this.iZu.getLayoutParams();
        this.iZu.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.iZt = this.iZr.getLayoutParams();
        this.iZr.setLayoutParams(new RelativeLayout.LayoutParams(this.iZt.width, this.iZt.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.iZy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(float f) {
        for (View view : this.iZB) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        float width = this.iZv.width() + ((this.iZw.width() - this.iZv.width()) * f);
        float height = this.iZv.height() + ((this.iZw.height() - this.iZv.height()) * f);
        float f2 = this.iZv.left + ((this.iZw.left - this.iZv.left) * f);
        float f3 = this.iZv.top + ((this.iZw.top - this.iZv.top) * f);
        int i = (int) (f2 - this.iZw.left);
        int i2 = (int) (f3 - this.iZw.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.iZr.setTranslationX(i);
        this.iZr.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.iZr.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.iZr.setLayoutParams(layoutParams);
        }
    }

    public boolean ctr() {
        return (!this.iZx || this.iZv == null || this.iZv.isEmpty() || this.iZw == null || this.iZw.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.iZA = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
