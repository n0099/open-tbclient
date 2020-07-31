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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class f {
    private FragmentActivity kGR;
    private ViewGroup kGS;
    private View kGT;
    private ViewGroup.LayoutParams kGU;
    private ViewGroup.LayoutParams kGV;
    private View kGW;
    private Rect kGX;
    private Rect kGY;
    private ValueAnimator kHa;
    private ValueAnimator kHb;
    private Animator.AnimatorListener kHc;
    private View[] kHd;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean kGZ = true;
    private boolean avT = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.kGR = fragmentActivity;
        this.kGT = view;
        this.kGS = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.kGW = this.kGS.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.kGS.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.kHd = new View[3];
        this.kHd[0] = this.kGS.findViewById(R.id.pb_video_view_pager);
        this.kHd[1] = this.kGS.findViewById(R.id.pb_video_tab_strip);
        this.kHd[2] = this.kGS.findViewById(R.id.video_pb_comment_container);
        this.kGS.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.kGS.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.kGS.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.kGS.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.kGS.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.kGS.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.kGS.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.kGS.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.kGR);
        ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.kGS.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.kHa = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHa.setInterpolator(new DecelerateInterpolator());
        this.kHa.setDuration(300L);
        this.kHa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.at(valueAnimator.getAnimatedFraction());
            }
        });
        this.kHa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.kHc != null) {
                    f.this.kHc.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cTL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cTL();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kHb = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHb.setDuration(100L);
        this.kHb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.as(valueAnimator.getAnimatedFraction());
            }
        });
        this.kHb.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.kGS.removeView(f.this.mMaskView);
                ao.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.kHd) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cTK();
                if (f.this.kHc != null) {
                    f.this.kHc.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cTK();
                if (f.this.kHc != null) {
                    f.this.kHc.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTK() {
        this.avT = false;
        for (View view : this.kHd) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTL() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.kGT.setTranslationX(0.0f);
        this.kGT.setTranslationY(0.0f);
        this.kGW.setLayoutParams(this.kGU);
        if (this.kGW.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.kGW.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.kGT instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.kGT).getOriginHeight() - ((VideoContainerLayout) this.kGT).getMaxHeight());
            }
        }
        this.kGT.setLayoutParams(this.kGV);
        this.kHb.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.kGX = rect;
        this.kGY = rect2;
        if (cTM()) {
            init();
        }
    }

    public void start() {
        this.kGZ = false;
        this.avT = true;
        for (View view : this.kHd) {
            view.setVisibility(8);
        }
        this.kGU = this.kGW.getLayoutParams();
        this.kGW.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.kGV = this.kGT.getLayoutParams();
        this.kGT.setLayoutParams(new RelativeLayout.LayoutParams(this.kGV.width, this.kGV.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.kHa.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(float f) {
        for (View view : this.kHd) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(float f) {
        float width = this.kGX.width() + ((this.kGY.width() - this.kGX.width()) * f);
        float height = this.kGX.height() + ((this.kGY.height() - this.kGX.height()) * f);
        float f2 = this.kGX.left + ((this.kGY.left - this.kGX.left) * f);
        float f3 = this.kGX.top + ((this.kGY.top - this.kGX.top) * f);
        int i = (int) (f2 - this.kGY.left);
        int i2 = (int) (f3 - this.kGY.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.kGT.setTranslationX(i);
        this.kGT.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.kGT.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.kGT.setLayoutParams(layoutParams);
        }
    }

    public boolean cTM() {
        return (!this.kGZ || this.kGX == null || this.kGX.isEmpty() || this.kGY == null || this.kGY.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kHc = animatorListener;
    }

    public boolean isPlaying() {
        return this.avT;
    }
}
