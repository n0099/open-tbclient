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
    private FragmentActivity iXJ;
    private ViewGroup iXK;
    private View iXL;
    private ViewGroup.LayoutParams iXM;
    private ViewGroup.LayoutParams iXN;
    private View iXO;
    private Rect iXP;
    private Rect iXQ;
    private ValueAnimator iXS;
    private ValueAnimator iXT;
    private Animator.AnimatorListener iXU;
    private View[] iXV;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean iXR = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.iXJ = fragmentActivity;
        this.iXL = view;
        this.iXK = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.iXO = this.iXK.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.iXK.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.iXV = new View[3];
        this.iXV[0] = this.iXK.findViewById(R.id.pb_video_view_pager);
        this.iXV[1] = this.iXK.findViewById(R.id.pb_video_tab_strip);
        this.iXV[2] = this.iXK.findViewById(R.id.video_pb_comment_container);
        this.iXK.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.iXK.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.iXK.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.iXK.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.iXK.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.iXK.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.iXK.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.iXK.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.iXJ);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.iXK.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iXS = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iXS.setInterpolator(new DecelerateInterpolator());
        this.iXS.setDuration(300L);
        this.iXS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aH(valueAnimator.getAnimatedFraction());
            }
        });
        this.iXS.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.iXU != null) {
                    f.this.iXU.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.crV();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.crV();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iXT = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iXT.setDuration(100L);
        this.iXT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aG(valueAnimator.getAnimatedFraction());
            }
        });
        this.iXT.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.iXK.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.iXV) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.crU();
                if (f.this.iXU != null) {
                    f.this.iXU.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.crU();
                if (f.this.iXU != null) {
                    f.this.iXU.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crU() {
        this.isPlaying = false;
        for (View view : this.iXV) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crV() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.iXL.setTranslationX(0.0f);
        this.iXL.setTranslationY(0.0f);
        this.iXO.setLayoutParams(this.iXM);
        if (this.iXO.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.iXO.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.iXL instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.iXL).getOriginHeight() - ((VideoContainerLayout) this.iXL).getMaxHeight());
            }
        }
        this.iXL.setLayoutParams(this.iXN);
        this.iXT.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.iXP = rect;
        this.iXQ = rect2;
        if (crW()) {
            init();
        }
    }

    public void start() {
        this.iXR = false;
        this.isPlaying = true;
        for (View view : this.iXV) {
            view.setVisibility(8);
        }
        this.iXM = this.iXO.getLayoutParams();
        this.iXO.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.iXN = this.iXL.getLayoutParams();
        this.iXL.setLayoutParams(new RelativeLayout.LayoutParams(this.iXN.width, this.iXN.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.iXS.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        for (View view : this.iXV) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aH(float f) {
        float width = this.iXP.width() + ((this.iXQ.width() - this.iXP.width()) * f);
        float height = this.iXP.height() + ((this.iXQ.height() - this.iXP.height()) * f);
        float f2 = this.iXP.left + ((this.iXQ.left - this.iXP.left) * f);
        float f3 = this.iXP.top + ((this.iXQ.top - this.iXP.top) * f);
        int i = (int) (f2 - this.iXQ.left);
        int i2 = (int) (f3 - this.iXQ.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.iXL.setTranslationX(i);
        this.iXL.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.iXL.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.iXL.setLayoutParams(layoutParams);
        }
    }

    public boolean crW() {
        return (!this.iXR || this.iXP == null || this.iXP.isEmpty() || this.iXQ == null || this.iXQ.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.iXU = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
