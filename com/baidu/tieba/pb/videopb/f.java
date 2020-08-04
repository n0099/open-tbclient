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
    private FragmentActivity kGT;
    private ViewGroup kGU;
    private View kGV;
    private ViewGroup.LayoutParams kGW;
    private ViewGroup.LayoutParams kGX;
    private View kGY;
    private Rect kGZ;
    private Rect kHa;
    private ValueAnimator kHc;
    private ValueAnimator kHd;
    private Animator.AnimatorListener kHe;
    private View[] kHf;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean kHb = true;
    private boolean avT = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.kGT = fragmentActivity;
        this.kGV = view;
        this.kGU = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.kGY = this.kGU.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.kGU.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.kHf = new View[3];
        this.kHf[0] = this.kGU.findViewById(R.id.pb_video_view_pager);
        this.kHf[1] = this.kGU.findViewById(R.id.pb_video_tab_strip);
        this.kHf[2] = this.kGU.findViewById(R.id.video_pb_comment_container);
        this.kGU.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.kGU.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.kGU.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.kGU.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.kGU.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.kGU.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.kGU.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.kGU.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.kGT);
        ao.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.kGU.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.kHc = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHc.setInterpolator(new DecelerateInterpolator());
        this.kHc.setDuration(300L);
        this.kHc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.at(valueAnimator.getAnimatedFraction());
            }
        });
        this.kHc.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.kHe != null) {
                    f.this.kHe.onAnimationStart(animator);
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
        this.kHd = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kHd.setDuration(100L);
        this.kHd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.as(valueAnimator.getAnimatedFraction());
            }
        });
        this.kHd.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.kGU.removeView(f.this.mMaskView);
                ao.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.kHf) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cTK();
                if (f.this.kHe != null) {
                    f.this.kHe.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cTK();
                if (f.this.kHe != null) {
                    f.this.kHe.onAnimationCancel(animator);
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
        for (View view : this.kHf) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cTL() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.kGV.setTranslationX(0.0f);
        this.kGV.setTranslationY(0.0f);
        this.kGY.setLayoutParams(this.kGW);
        if (this.kGY.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.kGY.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.kGV instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.kGV).getOriginHeight() - ((VideoContainerLayout) this.kGV).getMaxHeight());
            }
        }
        this.kGV.setLayoutParams(this.kGX);
        this.kHd.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.kGZ = rect;
        this.kHa = rect2;
        if (cTM()) {
            init();
        }
    }

    public void start() {
        this.kHb = false;
        this.avT = true;
        for (View view : this.kHf) {
            view.setVisibility(8);
        }
        this.kGW = this.kGY.getLayoutParams();
        this.kGY.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.kGX = this.kGV.getLayoutParams();
        this.kGV.setLayoutParams(new RelativeLayout.LayoutParams(this.kGX.width, this.kGX.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.kHc.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void as(float f) {
        for (View view : this.kHf) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(float f) {
        float width = this.kGZ.width() + ((this.kHa.width() - this.kGZ.width()) * f);
        float height = this.kGZ.height() + ((this.kHa.height() - this.kGZ.height()) * f);
        float f2 = this.kGZ.left + ((this.kHa.left - this.kGZ.left) * f);
        float f3 = this.kGZ.top + ((this.kHa.top - this.kGZ.top) * f);
        int i = (int) (f2 - this.kHa.left);
        int i2 = (int) (f3 - this.kHa.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.kGV.setTranslationX(i);
        this.kGV.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.kGV.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.kGV.setLayoutParams(layoutParams);
        }
    }

    public boolean cTM() {
        return (!this.kHb || this.kGZ == null || this.kGZ.isEmpty() || this.kHa == null || this.kHa.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kHe = animatorListener;
    }

    public boolean isPlaying() {
        return this.avT;
    }
}
