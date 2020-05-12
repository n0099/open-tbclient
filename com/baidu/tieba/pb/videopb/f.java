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
    private Animator.AnimatorListener jLA;
    private View[] jLB;
    private FragmentActivity jLp;
    private ViewGroup jLq;
    private View jLr;
    private ViewGroup.LayoutParams jLs;
    private ViewGroup.LayoutParams jLt;
    private View jLu;
    private Rect jLv;
    private Rect jLw;
    private ValueAnimator jLy;
    private ValueAnimator jLz;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean jLx = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.jLp = fragmentActivity;
        this.jLr = view;
        this.jLq = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.jLu = this.jLq.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.jLq.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.jLB = new View[3];
        this.jLB[0] = this.jLq.findViewById(R.id.pb_video_view_pager);
        this.jLB[1] = this.jLq.findViewById(R.id.pb_video_tab_strip);
        this.jLB[2] = this.jLq.findViewById(R.id.video_pb_comment_container);
        this.jLq.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.jLq.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.jLq.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.jLq.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.jLq.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.jLq.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.jLq.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.jLq.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.jLp);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.jLq.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jLy = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLy.setInterpolator(new DecelerateInterpolator());
        this.jLy.setDuration(300L);
        this.jLy.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aq(valueAnimator.getAnimatedFraction());
            }
        });
        this.jLy.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.jLA != null) {
                    f.this.jLA.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cEs();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cEs();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLz = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLz.setDuration(100L);
        this.jLz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ap(valueAnimator.getAnimatedFraction());
            }
        });
        this.jLz.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.jLq.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.jLB) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cEr();
                if (f.this.jLA != null) {
                    f.this.jLA.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cEr();
                if (f.this.jLA != null) {
                    f.this.jLA.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEr() {
        this.isPlaying = false;
        for (View view : this.jLB) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEs() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.jLr.setTranslationX(0.0f);
        this.jLr.setTranslationY(0.0f);
        this.jLu.setLayoutParams(this.jLs);
        if (this.jLu.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.jLu.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.jLr instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.jLr).getOriginHeight() - ((VideoContainerLayout) this.jLr).getMaxHeight());
            }
        }
        this.jLr.setLayoutParams(this.jLt);
        this.jLz.start();
    }

    public void c(Rect rect, Rect rect2) {
        this.jLv = rect;
        this.jLw = rect2;
        if (cEt()) {
            init();
        }
    }

    public void start() {
        this.jLx = false;
        this.isPlaying = true;
        for (View view : this.jLB) {
            view.setVisibility(8);
        }
        this.jLs = this.jLu.getLayoutParams();
        this.jLu.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.jLt = this.jLr.getLayoutParams();
        this.jLr.setLayoutParams(new RelativeLayout.LayoutParams(this.jLt.width, this.jLt.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.jLy.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        for (View view : this.jLB) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f) {
        float width = this.jLv.width() + ((this.jLw.width() - this.jLv.width()) * f);
        float height = this.jLv.height() + ((this.jLw.height() - this.jLv.height()) * f);
        float f2 = this.jLv.left + ((this.jLw.left - this.jLv.left) * f);
        float f3 = this.jLv.top + ((this.jLw.top - this.jLv.top) * f);
        int i = (int) (f2 - this.jLw.left);
        int i2 = (int) (f3 - this.jLw.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.jLr.setTranslationX(i);
        this.jLr.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.jLr.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.jLr.setLayoutParams(layoutParams);
        }
    }

    public boolean cEt() {
        return (!this.jLx || this.jLv == null || this.jLv.isEmpty() || this.jLw == null || this.jLw.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.jLA = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
