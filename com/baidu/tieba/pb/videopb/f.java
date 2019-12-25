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
/* loaded from: classes6.dex */
public class f {
    private FragmentActivity iUg;
    private ViewGroup iUh;
    private View iUi;
    private ViewGroup.LayoutParams iUj;
    private ViewGroup.LayoutParams iUk;
    private View iUl;
    private Rect iUm;
    private Rect iUn;
    private ValueAnimator iUp;
    private ValueAnimator iUq;
    private Animator.AnimatorListener iUr;
    private View[] iUs;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean iUo = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.iUg = fragmentActivity;
        this.iUi = view;
        this.iUh = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.iUl = this.iUh.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.iUh.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.iUs = new View[3];
        this.iUs[0] = this.iUh.findViewById(R.id.pb_video_view_pager);
        this.iUs[1] = this.iUh.findViewById(R.id.pb_video_tab_strip);
        this.iUs[2] = this.iUh.findViewById(R.id.video_pb_comment_container);
        this.iUh.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.iUh.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.iUh.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.iUh.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.iUh.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.iUh.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.iUh.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.iUh.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.iUg);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.iUh.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iUp = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iUp.setInterpolator(new DecelerateInterpolator());
        this.iUp.setDuration(300L);
        this.iUp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aI(valueAnimator.getAnimatedFraction());
            }
        });
        this.iUp.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.iUr != null) {
                    f.this.iUr.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cqO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cqO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iUq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iUq.setDuration(100L);
        this.iUq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aH(valueAnimator.getAnimatedFraction());
            }
        });
        this.iUq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.iUh.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.iUs) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cqN();
                if (f.this.iUr != null) {
                    f.this.iUr.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cqN();
                if (f.this.iUr != null) {
                    f.this.iUr.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqN() {
        this.isPlaying = false;
        for (View view : this.iUs) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cqO() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.iUi.setTranslationX(0.0f);
        this.iUi.setTranslationY(0.0f);
        this.iUl.setLayoutParams(this.iUj);
        if (this.iUl.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.iUl.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.iUi instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.iUi).getOriginHeight() - ((VideoContainerLayout) this.iUi).getMaxHeight());
            }
        }
        this.iUi.setLayoutParams(this.iUk);
        this.iUq.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.iUm = rect;
        this.iUn = rect2;
        if (cqP()) {
            init();
        }
    }

    public void start() {
        this.iUo = false;
        this.isPlaying = true;
        for (View view : this.iUs) {
            view.setVisibility(8);
        }
        this.iUj = this.iUl.getLayoutParams();
        this.iUl.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.iUk = this.iUi.getLayoutParams();
        this.iUi.setLayoutParams(new RelativeLayout.LayoutParams(this.iUk.width, this.iUk.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.iUp.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        for (View view : this.iUs) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aI(float f) {
        float width = this.iUm.width() + ((this.iUn.width() - this.iUm.width()) * f);
        float height = this.iUm.height() + ((this.iUn.height() - this.iUm.height()) * f);
        float f2 = this.iUm.left + ((this.iUn.left - this.iUm.left) * f);
        float f3 = this.iUm.top + ((this.iUn.top - this.iUm.top) * f);
        int i = (int) (f2 - this.iUn.left);
        int i2 = (int) (f3 - this.iUn.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.iUi.setTranslationX(i);
        this.iUi.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.iUi.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.iUi.setLayoutParams(layoutParams);
        }
    }

    public boolean cqP() {
        return (!this.iUo || this.iUm == null || this.iUm.isEmpty() || this.iUn == null || this.iUn.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.iUr = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
