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
    private FragmentActivity lfm;
    private ViewGroup lfn;
    private View lfo;
    private ViewGroup.LayoutParams lfp;
    private ViewGroup.LayoutParams lfq;
    private View lfr;
    private Rect lfs;
    private Rect lft;
    private ValueAnimator lfv;
    private ValueAnimator lfw;
    private Animator.AnimatorListener lfx;
    private View[] lfy;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean lfu = true;
    private boolean aBD = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.lfm = fragmentActivity;
        this.lfo = view;
        this.lfn = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.lfr = this.lfn.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.lfn.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.lfy = new View[3];
        this.lfy[0] = this.lfn.findViewById(R.id.pb_video_view_pager);
        this.lfy[1] = this.lfn.findViewById(R.id.pb_video_tab_strip);
        this.lfy[2] = this.lfn.findViewById(R.id.video_pb_comment_container);
        this.lfn.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.lfn.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.lfn.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.lfn.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.lfn.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.lfn.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.lfn.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.lfn.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.lfm);
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.lfn.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.lfv = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lfv.setInterpolator(new DecelerateInterpolator());
        this.lfv.setDuration(300L);
        this.lfv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.az(valueAnimator.getAnimatedFraction());
            }
        });
        this.lfv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.lfx != null) {
                    f.this.lfx.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dii();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dii();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.lfw = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.lfw.setDuration(100L);
        this.lfw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ay(valueAnimator.getAnimatedFraction());
            }
        });
        this.lfw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.lfn.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.lfy) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dih();
                if (f.this.lfx != null) {
                    f.this.lfx.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dih();
                if (f.this.lfx != null) {
                    f.this.lfx.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dih() {
        this.aBD = false;
        for (View view : this.lfy) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dii() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.lfo.setTranslationX(0.0f);
        this.lfo.setTranslationY(0.0f);
        this.lfr.setLayoutParams(this.lfp);
        if (this.lfr.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.lfr.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.lfo instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.lfo).getOriginHeight() - ((VideoContainerLayout) this.lfo).getMaxHeight());
            }
        }
        this.lfo.setLayoutParams(this.lfq);
        this.lfw.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.lfs = rect;
        this.lft = rect2;
        if (dij()) {
            init();
        }
    }

    public void start() {
        this.lfu = false;
        this.aBD = true;
        for (View view : this.lfy) {
            view.setVisibility(8);
        }
        this.lfp = this.lfr.getLayoutParams();
        this.lfr.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.lfq = this.lfo.getLayoutParams();
        this.lfo.setLayoutParams(new RelativeLayout.LayoutParams(this.lfq.width, this.lfq.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.lfv.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(float f) {
        for (View view : this.lfy) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        float width = this.lfs.width() + ((this.lft.width() - this.lfs.width()) * f);
        float height = this.lfs.height() + ((this.lft.height() - this.lfs.height()) * f);
        float f2 = this.lfs.left + ((this.lft.left - this.lfs.left) * f);
        float f3 = this.lfs.top + ((this.lft.top - this.lfs.top) * f);
        int i = (int) (f2 - this.lft.left);
        int i2 = (int) (f3 - this.lft.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.lfo.setTranslationX(i);
        this.lfo.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.lfo.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.lfo.setLayoutParams(layoutParams);
        }
    }

    public boolean dij() {
        return (!this.lfu || this.lfs == null || this.lfs.isEmpty() || this.lft == null || this.lft.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.lfx = animatorListener;
    }

    public boolean isPlaying() {
        return this.aBD;
    }
}
