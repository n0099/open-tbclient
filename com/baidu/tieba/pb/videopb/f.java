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
    private FragmentActivity jbd;
    private ViewGroup jbe;
    private View jbf;
    private ViewGroup.LayoutParams jbg;
    private ViewGroup.LayoutParams jbh;
    private View jbi;
    private Rect jbj;
    private Rect jbk;
    private ValueAnimator jbm;
    private ValueAnimator jbn;
    private Animator.AnimatorListener jbo;
    private View[] jbp;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean jbl = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.jbd = fragmentActivity;
        this.jbf = view;
        this.jbe = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.jbi = this.jbe.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.jbe.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.jbp = new View[3];
        this.jbp[0] = this.jbe.findViewById(R.id.pb_video_view_pager);
        this.jbp[1] = this.jbe.findViewById(R.id.pb_video_tab_strip);
        this.jbp[2] = this.jbe.findViewById(R.id.video_pb_comment_container);
        this.jbe.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.jbe.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.jbe.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.jbe.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.jbe.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.jbe.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.jbe.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.jbe.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.jbd);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.jbe.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.jbm = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jbm.setInterpolator(new DecelerateInterpolator());
        this.jbm.setDuration(300L);
        this.jbm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aG(valueAnimator.getAnimatedFraction());
            }
        });
        this.jbm.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.jbo != null) {
                    f.this.jbo.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.ctO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.ctO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.jbn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.jbn.setDuration(100L);
        this.jbn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aF(valueAnimator.getAnimatedFraction());
            }
        });
        this.jbn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.jbe.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.jbp) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.ctN();
                if (f.this.jbo != null) {
                    f.this.jbo.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.ctN();
                if (f.this.jbo != null) {
                    f.this.jbo.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctN() {
        this.isPlaying = false;
        for (View view : this.jbp) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ctO() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.jbf.setTranslationX(0.0f);
        this.jbf.setTranslationY(0.0f);
        this.jbi.setLayoutParams(this.jbg);
        if (this.jbi.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.jbi.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.jbf instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.jbf).getOriginHeight() - ((VideoContainerLayout) this.jbf).getMaxHeight());
            }
        }
        this.jbf.setLayoutParams(this.jbh);
        this.jbn.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.jbj = rect;
        this.jbk = rect2;
        if (ctP()) {
            init();
        }
    }

    public void start() {
        this.jbl = false;
        this.isPlaying = true;
        for (View view : this.jbp) {
            view.setVisibility(8);
        }
        this.jbg = this.jbi.getLayoutParams();
        this.jbi.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.jbh = this.jbf.getLayoutParams();
        this.jbf.setLayoutParams(new RelativeLayout.LayoutParams(this.jbh.width, this.jbh.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.jbm.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(float f) {
        for (View view : this.jbp) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aG(float f) {
        float width = this.jbj.width() + ((this.jbk.width() - this.jbj.width()) * f);
        float height = this.jbj.height() + ((this.jbk.height() - this.jbj.height()) * f);
        float f2 = this.jbj.left + ((this.jbk.left - this.jbj.left) * f);
        float f3 = this.jbj.top + ((this.jbk.top - this.jbj.top) * f);
        int i = (int) (f2 - this.jbk.left);
        int i2 = (int) (f3 - this.jbk.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.jbf.setTranslationX(i);
        this.jbf.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.jbf.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.jbf.setLayoutParams(layoutParams);
        }
    }

    public boolean ctP() {
        return (!this.jbl || this.jbj == null || this.jbj.isEmpty() || this.jbk == null || this.jbk.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.jbo = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
