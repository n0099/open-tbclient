package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private View mVideoView;
    private Animator.AnimatorListener mlA;
    private View[] mlB;
    private FragmentActivity mlq;
    private ViewGroup mlr;
    private ViewGroup.LayoutParams mls;
    private ViewGroup.LayoutParams mlt;
    private View mlu;
    private Rect mlv;
    private Rect mlw;
    private ValueAnimator mly;
    private ValueAnimator mlz;
    private boolean mlx = true;
    private boolean aDS = false;

    public e(FragmentActivity fragmentActivity, View view) {
        this.mlq = fragmentActivity;
        this.mVideoView = view;
        this.mlr = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mlu = this.mlr.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mlr.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mlB = new View[3];
        this.mlB[0] = this.mlr.findViewById(R.id.pb_video_view_pager);
        this.mlB[1] = this.mlr.findViewById(R.id.pb_video_tab_strip);
        this.mlB[2] = this.mlr.findViewById(R.id.video_pb_comment_container);
        this.mlr.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mlr.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mlr.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mlr.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mlr.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mlr.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mlr.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mlr.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mlq);
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mlr.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mly = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mly.setInterpolator(new DecelerateInterpolator());
        this.mly.setDuration(300L);
        this.mly.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aW(valueAnimator.getAnimatedFraction());
            }
        });
        this.mly.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.mlA != null) {
                    e.this.mlA.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.duL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.duL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlz.setDuration(100L);
        this.mlz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aV(valueAnimator.getAnimatedFraction());
            }
        });
        this.mlz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                e.this.mlr.removeView(e.this.mMaskView);
                ap.setBackgroundColor(e.this.mRootView, R.color.CAM_X0201);
                for (View view : e.this.mlB) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.duK();
                if (e.this.mlA != null) {
                    e.this.mlA.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.duK();
                if (e.this.mlA != null) {
                    e.this.mlA.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duK() {
        this.aDS = false;
        for (View view : this.mlB) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duL() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mVideoView.setTranslationX(0.0f);
        this.mVideoView.setTranslationY(0.0f);
        this.mlu.setLayoutParams(this.mls);
        if (this.mlu.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mlu.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mVideoView instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mVideoView).getOriginHeight() - ((VideoContainerLayout) this.mVideoView).getMaxHeight());
            }
        }
        this.mVideoView.setLayoutParams(this.mlt);
        this.mlz.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mlv = rect;
        this.mlw = rect2;
        if (duM()) {
            init();
        }
    }

    public void start() {
        this.mlx = false;
        this.aDS = true;
        for (View view : this.mlB) {
            view.setVisibility(8);
        }
        this.mls = this.mlu.getLayoutParams();
        this.mlu.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mlt = this.mVideoView.getLayoutParams();
        this.mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(this.mlt.width, this.mlt.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mly.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(float f) {
        for (View view : this.mlB) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(float f) {
        float width = this.mlv.width() + ((this.mlw.width() - this.mlv.width()) * f);
        float height = this.mlv.height() + ((this.mlw.height() - this.mlv.height()) * f);
        float f2 = this.mlv.left + ((this.mlw.left - this.mlv.left) * f);
        float f3 = this.mlv.top + ((this.mlw.top - this.mlv.top) * f);
        int i = (int) (f2 - this.mlw.left);
        int i2 = (int) (f3 - this.mlw.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.mVideoView.setTranslationX(i);
        this.mVideoView.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.mVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.mVideoView.setLayoutParams(layoutParams);
        }
    }

    public boolean duM() {
        return (!this.mlx || this.mlv == null || this.mlv.isEmpty() || this.mlw == null || this.mlw.isEmpty()) ? false : true;
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.mlA = animatorListener;
    }

    public boolean isPlaying() {
        return this.aDS;
    }
}
