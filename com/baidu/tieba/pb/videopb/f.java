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
    private FragmentActivity iZD;
    private ViewGroup iZE;
    private View iZF;
    private ViewGroup.LayoutParams iZG;
    private ViewGroup.LayoutParams iZH;
    private View iZI;
    private Rect iZJ;
    private Rect iZK;
    private ValueAnimator iZM;
    private ValueAnimator iZN;
    private Animator.AnimatorListener iZO;
    private View[] iZP;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean iZL = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.iZD = fragmentActivity;
        this.iZF = view;
        this.iZE = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.iZI = this.iZE.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.iZE.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.iZP = new View[3];
        this.iZP[0] = this.iZE.findViewById(R.id.pb_video_view_pager);
        this.iZP[1] = this.iZE.findViewById(R.id.pb_video_tab_strip);
        this.iZP[2] = this.iZE.findViewById(R.id.video_pb_comment_container);
        this.iZE.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.iZE.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.iZE.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.iZE.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.iZE.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.iZE.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.iZE.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.iZE.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.iZD);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.iZE.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.iZM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iZM.setInterpolator(new DecelerateInterpolator());
        this.iZM.setDuration(300L);
        this.iZM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aG(valueAnimator.getAnimatedFraction());
            }
        });
        this.iZM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.iZO != null) {
                    f.this.iZO.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.ctt();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.ctt();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.iZN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.iZN.setDuration(100L);
        this.iZN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aF(valueAnimator.getAnimatedFraction());
            }
        });
        this.iZN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.iZE.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.iZP) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cts();
                if (f.this.iZO != null) {
                    f.this.iZO.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cts();
                if (f.this.iZO != null) {
                    f.this.iZO.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cts() {
        this.isPlaying = false;
        for (View view : this.iZP) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctt() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.iZF.setTranslationX(0.0f);
        this.iZF.setTranslationY(0.0f);
        this.iZI.setLayoutParams(this.iZG);
        if (this.iZI.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.iZI.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.iZF instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.iZF).getOriginHeight() - ((VideoContainerLayout) this.iZF).getMaxHeight());
            }
        }
        this.iZF.setLayoutParams(this.iZH);
        this.iZN.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.iZJ = rect;
        this.iZK = rect2;
        if (ctu()) {
            init();
        }
    }

    public void start() {
        this.iZL = false;
        this.isPlaying = true;
        for (View view : this.iZP) {
            view.setVisibility(8);
        }
        this.iZG = this.iZI.getLayoutParams();
        this.iZI.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.iZH = this.iZF.getLayoutParams();
        this.iZF.setLayoutParams(new RelativeLayout.LayoutParams(this.iZH.width, this.iZH.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.iZM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(float f) {
        for (View view : this.iZP) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        float width = this.iZJ.width() + ((this.iZK.width() - this.iZJ.width()) * f);
        float height = this.iZJ.height() + ((this.iZK.height() - this.iZJ.height()) * f);
        float f2 = this.iZJ.left + ((this.iZK.left - this.iZJ.left) * f);
        float f3 = this.iZJ.top + ((this.iZK.top - this.iZJ.top) * f);
        int i = (int) (f2 - this.iZK.left);
        int i2 = (int) (f3 - this.iZK.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.iZF.setTranslationX(i);
        this.iZF.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.iZF.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.iZF.setLayoutParams(layoutParams);
        }
    }

    public boolean ctu() {
        return (!this.iZL || this.iZJ == null || this.iZJ.isEmpty() || this.iZK == null || this.iZK.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.iZO = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
