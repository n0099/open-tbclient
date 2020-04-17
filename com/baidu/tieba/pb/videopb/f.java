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
    private FragmentActivity jLl;
    private ViewGroup jLm;
    private View jLn;
    private ViewGroup.LayoutParams jLo;
    private ViewGroup.LayoutParams jLp;
    private View jLq;
    private Rect jLr;
    private Rect jLs;
    private ValueAnimator jLu;
    private ValueAnimator jLv;
    private Animator.AnimatorListener jLw;
    private View[] jLx;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean jLt = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.jLl = fragmentActivity;
        this.jLn = view;
        this.jLm = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.jLq = this.jLm.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.jLm.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.jLx = new View[3];
        this.jLx[0] = this.jLm.findViewById(R.id.pb_video_view_pager);
        this.jLx[1] = this.jLm.findViewById(R.id.pb_video_tab_strip);
        this.jLx[2] = this.jLm.findViewById(R.id.video_pb_comment_container);
        this.jLm.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.jLm.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.jLm.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.jLm.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.jLm.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.jLm.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.jLm.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.jLm.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.jLl);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.jLm.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jLu = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLu.setInterpolator(new DecelerateInterpolator());
        this.jLu.setDuration(300L);
        this.jLu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aq(valueAnimator.getAnimatedFraction());
            }
        });
        this.jLu.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.jLw != null) {
                    f.this.jLw.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cEu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cEu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jLv = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jLv.setDuration(100L);
        this.jLv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ap(valueAnimator.getAnimatedFraction());
            }
        });
        this.jLv.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.jLm.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.jLx) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cEt();
                if (f.this.jLw != null) {
                    f.this.jLw.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cEt();
                if (f.this.jLw != null) {
                    f.this.jLw.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEt() {
        this.isPlaying = false;
        for (View view : this.jLx) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cEu() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.jLn.setTranslationX(0.0f);
        this.jLn.setTranslationY(0.0f);
        this.jLq.setLayoutParams(this.jLo);
        if (this.jLq.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.jLq.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.jLn instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.jLn).getOriginHeight() - ((VideoContainerLayout) this.jLn).getMaxHeight());
            }
        }
        this.jLn.setLayoutParams(this.jLp);
        this.jLv.start();
    }

    public void c(Rect rect, Rect rect2) {
        this.jLr = rect;
        this.jLs = rect2;
        if (cEv()) {
            init();
        }
    }

    public void start() {
        this.jLt = false;
        this.isPlaying = true;
        for (View view : this.jLx) {
            view.setVisibility(8);
        }
        this.jLo = this.jLq.getLayoutParams();
        this.jLq.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.jLp = this.jLn.getLayoutParams();
        this.jLn.setLayoutParams(new RelativeLayout.LayoutParams(this.jLp.width, this.jLp.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.jLu.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        for (View view : this.jLx) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aq(float f) {
        float width = this.jLr.width() + ((this.jLs.width() - this.jLr.width()) * f);
        float height = this.jLr.height() + ((this.jLs.height() - this.jLr.height()) * f);
        float f2 = this.jLr.left + ((this.jLs.left - this.jLr.left) * f);
        float f3 = this.jLr.top + ((this.jLs.top - this.jLr.top) * f);
        int i = (int) (f2 - this.jLs.left);
        int i2 = (int) (f3 - this.jLs.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.jLn.setTranslationX(i);
        this.jLn.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.jLn.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.jLn.setLayoutParams(layoutParams);
        }
    }

    public boolean cEv() {
        return (!this.jLt || this.jLr == null || this.jLr.isEmpty() || this.jLs == null || this.jLs.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.jLw = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
