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
/* loaded from: classes16.dex */
public class f {
    private FragmentActivity kWA;
    private ViewGroup kWB;
    private View kWC;
    private ViewGroup.LayoutParams kWD;
    private ViewGroup.LayoutParams kWE;
    private View kWF;
    private Rect kWG;
    private Rect kWH;
    private ValueAnimator kWJ;
    private ValueAnimator kWK;
    private Animator.AnimatorListener kWL;
    private View[] kWM;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean kWI = true;
    private boolean aAV = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.kWA = fragmentActivity;
        this.kWC = view;
        this.kWB = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.kWF = this.kWB.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.kWB.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.kWM = new View[3];
        this.kWM[0] = this.kWB.findViewById(R.id.pb_video_view_pager);
        this.kWM[1] = this.kWB.findViewById(R.id.pb_video_tab_strip);
        this.kWM[2] = this.kWB.findViewById(R.id.video_pb_comment_container);
        this.kWB.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.kWB.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.kWB.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.kWB.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.kWB.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.kWB.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.kWB.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.kWB.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.kWA);
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.kWB.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.kWJ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kWJ.setInterpolator(new DecelerateInterpolator());
        this.kWJ.setDuration(300L);
        this.kWJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.az(valueAnimator.getAnimatedFraction());
            }
        });
        this.kWJ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.kWL != null) {
                    f.this.kWL.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.deD();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.deD();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kWK = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kWK.setDuration(100L);
        this.kWK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ay(valueAnimator.getAnimatedFraction());
            }
        });
        this.kWK.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.kWB.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.kWM) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.deC();
                if (f.this.kWL != null) {
                    f.this.kWL.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.deC();
                if (f.this.kWL != null) {
                    f.this.kWL.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deC() {
        this.aAV = false;
        for (View view : this.kWM) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deD() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.kWC.setTranslationX(0.0f);
        this.kWC.setTranslationY(0.0f);
        this.kWF.setLayoutParams(this.kWD);
        if (this.kWF.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.kWF.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.kWC instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.kWC).getOriginHeight() - ((VideoContainerLayout) this.kWC).getMaxHeight());
            }
        }
        this.kWC.setLayoutParams(this.kWE);
        this.kWK.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.kWG = rect;
        this.kWH = rect2;
        if (deE()) {
            init();
        }
    }

    public void start() {
        this.kWI = false;
        this.aAV = true;
        for (View view : this.kWM) {
            view.setVisibility(8);
        }
        this.kWD = this.kWF.getLayoutParams();
        this.kWF.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.kWE = this.kWC.getLayoutParams();
        this.kWC.setLayoutParams(new RelativeLayout.LayoutParams(this.kWE.width, this.kWE.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.kWJ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(float f) {
        for (View view : this.kWM) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        float width = this.kWG.width() + ((this.kWH.width() - this.kWG.width()) * f);
        float height = this.kWG.height() + ((this.kWH.height() - this.kWG.height()) * f);
        float f2 = this.kWG.left + ((this.kWH.left - this.kWG.left) * f);
        float f3 = this.kWG.top + ((this.kWH.top - this.kWG.top) * f);
        int i = (int) (f2 - this.kWH.left);
        int i2 = (int) (f3 - this.kWH.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.kWC.setTranslationX(i);
        this.kWC.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.kWC.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.kWC.setLayoutParams(layoutParams);
        }
    }

    public boolean deE() {
        return (!this.kWI || this.kWG == null || this.kWG.isEmpty() || this.kWH == null || this.kWH.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kWL = animatorListener;
    }

    public boolean isPlaying() {
        return this.aAV;
    }
}
