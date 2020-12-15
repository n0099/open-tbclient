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
/* loaded from: classes22.dex */
public class f {
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private Rect mbA;
    private ValueAnimator mbC;
    private ValueAnimator mbD;
    private Animator.AnimatorListener mbE;
    private View[] mbF;
    private FragmentActivity mbt;
    private ViewGroup mbu;
    private View mbv;
    private ViewGroup.LayoutParams mbw;
    private ViewGroup.LayoutParams mbx;
    private View mby;
    private Rect mbz;
    private boolean mbB = true;
    private boolean aGB = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.mbt = fragmentActivity;
        this.mbv = view;
        this.mbu = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mby = this.mbu.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mbu.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mbF = new View[3];
        this.mbF[0] = this.mbu.findViewById(R.id.pb_video_view_pager);
        this.mbF[1] = this.mbu.findViewById(R.id.pb_video_tab_strip);
        this.mbF[2] = this.mbu.findViewById(R.id.video_pb_comment_container);
        this.mbu.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mbu.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mbu.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mbu.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mbu.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mbu.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mbu.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mbu.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mbt);
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mbu.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mbC = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mbC.setInterpolator(new DecelerateInterpolator());
        this.mbC.setDuration(300L);
        this.mbC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aR(valueAnimator.getAnimatedFraction());
            }
        });
        this.mbC.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.mbE != null) {
                    f.this.mbE.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dwv();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dwv();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mbD = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mbD.setDuration(100L);
        this.mbD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aQ(valueAnimator.getAnimatedFraction());
            }
        });
        this.mbD.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.mbu.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.CAM_X0201);
                for (View view : f.this.mbF) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dwu();
                if (f.this.mbE != null) {
                    f.this.mbE.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dwu();
                if (f.this.mbE != null) {
                    f.this.mbE.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwu() {
        this.aGB = false;
        for (View view : this.mbF) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwv() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mbv.setTranslationX(0.0f);
        this.mbv.setTranslationY(0.0f);
        this.mby.setLayoutParams(this.mbw);
        if (this.mby.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mby.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mbv instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mbv).getOriginHeight() - ((VideoContainerLayout) this.mbv).getMaxHeight());
            }
        }
        this.mbv.setLayoutParams(this.mbx);
        this.mbD.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mbz = rect;
        this.mbA = rect2;
        if (dww()) {
            init();
        }
    }

    public void start() {
        this.mbB = false;
        this.aGB = true;
        for (View view : this.mbF) {
            view.setVisibility(8);
        }
        this.mbw = this.mby.getLayoutParams();
        this.mby.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mbx = this.mbv.getLayoutParams();
        this.mbv.setLayoutParams(new RelativeLayout.LayoutParams(this.mbx.width, this.mbx.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mbC.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(float f) {
        for (View view : this.mbF) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(float f) {
        float width = this.mbz.width() + ((this.mbA.width() - this.mbz.width()) * f);
        float height = this.mbz.height() + ((this.mbA.height() - this.mbz.height()) * f);
        float f2 = this.mbz.left + ((this.mbA.left - this.mbz.left) * f);
        float f3 = this.mbz.top + ((this.mbA.top - this.mbz.top) * f);
        int i = (int) (f2 - this.mbA.left);
        int i2 = (int) (f3 - this.mbA.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.mbv.setTranslationX(i);
        this.mbv.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.mbv.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.mbv.setLayoutParams(layoutParams);
        }
    }

    public boolean dww() {
        return (!this.mbB || this.mbz == null || this.mbz.isEmpty() || this.mbA == null || this.mbA.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.mbE = animatorListener;
    }

    public boolean isPlaying() {
        return this.aGB;
    }
}
