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
    private ValueAnimator iZA;
    private ValueAnimator iZB;
    private Animator.AnimatorListener iZC;
    private View[] iZD;
    private FragmentActivity iZr;
    private ViewGroup iZs;
    private View iZt;
    private ViewGroup.LayoutParams iZu;
    private ViewGroup.LayoutParams iZv;
    private View iZw;
    private Rect iZx;
    private Rect iZy;
    private boolean iZz = true;
    private boolean isPlaying = false;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;

    public f(FragmentActivity fragmentActivity, View view) {
        this.iZr = fragmentActivity;
        this.iZt = view;
        this.iZs = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.iZw = this.iZs.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.iZs.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.iZD = new View[3];
        this.iZD[0] = this.iZs.findViewById(R.id.pb_video_view_pager);
        this.iZD[1] = this.iZs.findViewById(R.id.pb_video_tab_strip);
        this.iZD[2] = this.iZs.findViewById(R.id.video_pb_comment_container);
        this.iZs.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.iZs.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.iZs.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.iZs.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.iZs.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.iZs.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.iZs.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.iZs.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.iZr);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.iZs.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iZA = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iZA.setInterpolator(new DecelerateInterpolator());
        this.iZA.setDuration(300L);
        this.iZA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aG(valueAnimator.getAnimatedFraction());
            }
        });
        this.iZA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.iZC != null) {
                    f.this.iZC.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cts();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cts();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iZB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iZB.setDuration(100L);
        this.iZB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aF(valueAnimator.getAnimatedFraction());
            }
        });
        this.iZB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.iZs.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.iZD) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.ctr();
                if (f.this.iZC != null) {
                    f.this.iZC.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.ctr();
                if (f.this.iZC != null) {
                    f.this.iZC.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctr() {
        this.isPlaying = false;
        for (View view : this.iZD) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cts() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.iZt.setTranslationX(0.0f);
        this.iZt.setTranslationY(0.0f);
        this.iZw.setLayoutParams(this.iZu);
        if (this.iZw.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.iZw.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.iZt instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.iZt).getOriginHeight() - ((VideoContainerLayout) this.iZt).getMaxHeight());
            }
        }
        this.iZt.setLayoutParams(this.iZv);
        this.iZB.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.iZx = rect;
        this.iZy = rect2;
        if (ctt()) {
            init();
        }
    }

    public void start() {
        this.iZz = false;
        this.isPlaying = true;
        for (View view : this.iZD) {
            view.setVisibility(8);
        }
        this.iZu = this.iZw.getLayoutParams();
        this.iZw.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.iZv = this.iZt.getLayoutParams();
        this.iZt.setLayoutParams(new RelativeLayout.LayoutParams(this.iZv.width, this.iZv.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.iZA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(float f) {
        for (View view : this.iZD) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        float width = this.iZx.width() + ((this.iZy.width() - this.iZx.width()) * f);
        float height = this.iZx.height() + ((this.iZy.height() - this.iZx.height()) * f);
        float f2 = this.iZx.left + ((this.iZy.left - this.iZx.left) * f);
        float f3 = this.iZx.top + ((this.iZy.top - this.iZx.top) * f);
        int i = (int) (f2 - this.iZy.left);
        int i2 = (int) (f3 - this.iZy.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.iZt.setTranslationX(i);
        this.iZt.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.iZt.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.iZt.setLayoutParams(layoutParams);
        }
    }

    public boolean ctt() {
        return (!this.iZz || this.iZx == null || this.iZx.isEmpty() || this.iZy == null || this.iZy.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.iZC = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
