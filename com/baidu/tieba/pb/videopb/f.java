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
    private ValueAnimator mbA;
    private ValueAnimator mbB;
    private Animator.AnimatorListener mbC;
    private View[] mbD;
    private FragmentActivity mbr;
    private ViewGroup mbs;
    private View mbt;
    private ViewGroup.LayoutParams mbu;
    private ViewGroup.LayoutParams mbv;
    private View mbw;
    private Rect mbx;
    private Rect mby;
    private boolean mbz = true;
    private boolean aGB = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.mbr = fragmentActivity;
        this.mbt = view;
        this.mbs = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mbw = this.mbs.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mbs.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mbD = new View[3];
        this.mbD[0] = this.mbs.findViewById(R.id.pb_video_view_pager);
        this.mbD[1] = this.mbs.findViewById(R.id.pb_video_tab_strip);
        this.mbD[2] = this.mbs.findViewById(R.id.video_pb_comment_container);
        this.mbs.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mbs.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mbs.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mbs.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mbs.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mbs.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mbs.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mbs.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mbr);
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mbs.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mbA = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mbA.setInterpolator(new DecelerateInterpolator());
        this.mbA.setDuration(300L);
        this.mbA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aR(valueAnimator.getAnimatedFraction());
            }
        });
        this.mbA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.mbC != null) {
                    f.this.mbC.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dwu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dwu();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mbB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mbB.setDuration(100L);
        this.mbB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aQ(valueAnimator.getAnimatedFraction());
            }
        });
        this.mbB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.mbs.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.CAM_X0201);
                for (View view : f.this.mbD) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dwt();
                if (f.this.mbC != null) {
                    f.this.mbC.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dwt();
                if (f.this.mbC != null) {
                    f.this.mbC.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwt() {
        this.aGB = false;
        for (View view : this.mbD) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwu() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mbt.setTranslationX(0.0f);
        this.mbt.setTranslationY(0.0f);
        this.mbw.setLayoutParams(this.mbu);
        if (this.mbw.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mbw.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mbt instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mbt).getOriginHeight() - ((VideoContainerLayout) this.mbt).getMaxHeight());
            }
        }
        this.mbt.setLayoutParams(this.mbv);
        this.mbB.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mbx = rect;
        this.mby = rect2;
        if (dwv()) {
            init();
        }
    }

    public void start() {
        this.mbz = false;
        this.aGB = true;
        for (View view : this.mbD) {
            view.setVisibility(8);
        }
        this.mbu = this.mbw.getLayoutParams();
        this.mbw.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mbv = this.mbt.getLayoutParams();
        this.mbt.setLayoutParams(new RelativeLayout.LayoutParams(this.mbv.width, this.mbv.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mbA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aQ(float f) {
        for (View view : this.mbD) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aR(float f) {
        float width = this.mbx.width() + ((this.mby.width() - this.mbx.width()) * f);
        float height = this.mbx.height() + ((this.mby.height() - this.mbx.height()) * f);
        float f2 = this.mbx.left + ((this.mby.left - this.mbx.left) * f);
        float f3 = this.mbx.top + ((this.mby.top - this.mbx.top) * f);
        int i = (int) (f2 - this.mby.left);
        int i2 = (int) (f3 - this.mby.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.mbt.setTranslationX(i);
        this.mbt.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.mbt.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.mbt.setLayoutParams(layoutParams);
        }
    }

    public boolean dwv() {
        return (!this.mbz || this.mbx == null || this.mbx.isEmpty() || this.mby == null || this.mby.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.mbC = animatorListener;
    }

    public boolean isPlaying() {
        return this.aGB;
    }
}
