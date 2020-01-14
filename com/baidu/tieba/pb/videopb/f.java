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
/* loaded from: classes7.dex */
public class f {
    private FragmentActivity iXO;
    private ViewGroup iXP;
    private View iXQ;
    private ViewGroup.LayoutParams iXR;
    private ViewGroup.LayoutParams iXS;
    private View iXT;
    private Rect iXU;
    private Rect iXV;
    private ValueAnimator iXX;
    private ValueAnimator iXY;
    private Animator.AnimatorListener iXZ;
    private View[] iYa;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean iXW = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.iXO = fragmentActivity;
        this.iXQ = view;
        this.iXP = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.iXT = this.iXP.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.iXP.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.iYa = new View[3];
        this.iYa[0] = this.iXP.findViewById(R.id.pb_video_view_pager);
        this.iYa[1] = this.iXP.findViewById(R.id.pb_video_tab_strip);
        this.iYa[2] = this.iXP.findViewById(R.id.video_pb_comment_container);
        this.iXP.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.iXP.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.iXP.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.iXP.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.iXP.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.iXP.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.iXP.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.iXP.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.iXO);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.iXP.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iXX = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iXX.setInterpolator(new DecelerateInterpolator());
        this.iXX.setDuration(300L);
        this.iXX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aH(valueAnimator.getAnimatedFraction());
            }
        });
        this.iXX.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.iXZ != null) {
                    f.this.iXZ.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.crX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.crX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iXY = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iXY.setDuration(100L);
        this.iXY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aG(valueAnimator.getAnimatedFraction());
            }
        });
        this.iXY.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.iXP.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.iYa) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.crW();
                if (f.this.iXZ != null) {
                    f.this.iXZ.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.crW();
                if (f.this.iXZ != null) {
                    f.this.iXZ.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crW() {
        this.isPlaying = false;
        for (View view : this.iYa) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crX() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.iXQ.setTranslationX(0.0f);
        this.iXQ.setTranslationY(0.0f);
        this.iXT.setLayoutParams(this.iXR);
        if (this.iXT.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.iXT.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.iXQ instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.iXQ).getOriginHeight() - ((VideoContainerLayout) this.iXQ).getMaxHeight());
            }
        }
        this.iXQ.setLayoutParams(this.iXS);
        this.iXY.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.iXU = rect;
        this.iXV = rect2;
        if (crY()) {
            init();
        }
    }

    public void start() {
        this.iXW = false;
        this.isPlaying = true;
        for (View view : this.iYa) {
            view.setVisibility(8);
        }
        this.iXR = this.iXT.getLayoutParams();
        this.iXT.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.iXS = this.iXQ.getLayoutParams();
        this.iXQ.setLayoutParams(new RelativeLayout.LayoutParams(this.iXS.width, this.iXS.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.iXX.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        for (View view : this.iYa) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        float width = this.iXU.width() + ((this.iXV.width() - this.iXU.width()) * f);
        float height = this.iXU.height() + ((this.iXV.height() - this.iXU.height()) * f);
        float f2 = this.iXU.left + ((this.iXV.left - this.iXU.left) * f);
        float f3 = this.iXU.top + ((this.iXV.top - this.iXU.top) * f);
        int i = (int) (f2 - this.iXV.left);
        int i2 = (int) (f3 - this.iXV.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.iXQ.setTranslationX(i);
        this.iXQ.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.iXQ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.iXQ.setLayoutParams(layoutParams);
        }
    }

    public boolean crY() {
        return (!this.iXW || this.iXU == null || this.iXU.isEmpty() || this.iXV == null || this.iXV.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.iXZ = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
