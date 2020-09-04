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
    private FragmentActivity kWH;
    private ViewGroup kWI;
    private View kWJ;
    private ViewGroup.LayoutParams kWK;
    private ViewGroup.LayoutParams kWL;
    private View kWM;
    private Rect kWN;
    private Rect kWO;
    private ValueAnimator kWQ;
    private ValueAnimator kWR;
    private Animator.AnimatorListener kWS;
    private View[] kWT;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean kWP = true;
    private boolean aAX = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.kWH = fragmentActivity;
        this.kWJ = view;
        this.kWI = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.kWM = this.kWI.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.kWI.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.kWT = new View[3];
        this.kWT[0] = this.kWI.findViewById(R.id.pb_video_view_pager);
        this.kWT[1] = this.kWI.findViewById(R.id.pb_video_tab_strip);
        this.kWT[2] = this.kWI.findViewById(R.id.video_pb_comment_container);
        this.kWI.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.kWI.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.kWI.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.kWI.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.kWI.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.kWI.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.kWI.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.kWI.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.kWH);
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.kWI.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.kWQ = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kWQ.setInterpolator(new DecelerateInterpolator());
        this.kWQ.setDuration(300L);
        this.kWQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.az(valueAnimator.getAnimatedFraction());
            }
        });
        this.kWQ.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.kWS != null) {
                    f.this.kWS.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.deE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.deE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kWR = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kWR.setDuration(100L);
        this.kWR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ay(valueAnimator.getAnimatedFraction());
            }
        });
        this.kWR.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.kWI.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.kWT) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.deD();
                if (f.this.kWS != null) {
                    f.this.kWS.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.deD();
                if (f.this.kWS != null) {
                    f.this.kWS.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deD() {
        this.aAX = false;
        for (View view : this.kWT) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void deE() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.kWJ.setTranslationX(0.0f);
        this.kWJ.setTranslationY(0.0f);
        this.kWM.setLayoutParams(this.kWK);
        if (this.kWM.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.kWM.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.kWJ instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.kWJ).getOriginHeight() - ((VideoContainerLayout) this.kWJ).getMaxHeight());
            }
        }
        this.kWJ.setLayoutParams(this.kWL);
        this.kWR.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.kWN = rect;
        this.kWO = rect2;
        if (deF()) {
            init();
        }
    }

    public void start() {
        this.kWP = false;
        this.aAX = true;
        for (View view : this.kWT) {
            view.setVisibility(8);
        }
        this.kWK = this.kWM.getLayoutParams();
        this.kWM.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.kWL = this.kWJ.getLayoutParams();
        this.kWJ.setLayoutParams(new RelativeLayout.LayoutParams(this.kWL.width, this.kWL.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.kWQ.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ay(float f) {
        for (View view : this.kWT) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az(float f) {
        float width = this.kWN.width() + ((this.kWO.width() - this.kWN.width()) * f);
        float height = this.kWN.height() + ((this.kWO.height() - this.kWN.height()) * f);
        float f2 = this.kWN.left + ((this.kWO.left - this.kWN.left) * f);
        float f3 = this.kWN.top + ((this.kWO.top - this.kWN.top) * f);
        int i = (int) (f2 - this.kWO.left);
        int i2 = (int) (f3 - this.kWO.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.kWJ.setTranslationX(i);
        this.kWJ.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.kWJ.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.kWJ.setLayoutParams(layoutParams);
        }
    }

    public boolean deF() {
        return (!this.kWP || this.kWN == null || this.kWN.isEmpty() || this.kWO == null || this.kWO.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kWS = animatorListener;
    }

    public boolean isPlaying() {
        return this.aAX;
    }
}
