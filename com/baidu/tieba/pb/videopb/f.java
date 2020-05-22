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
    private FragmentActivity kdb;
    private ViewGroup kdc;
    private View kdd;
    private ViewGroup.LayoutParams kde;
    private ViewGroup.LayoutParams kdf;
    private View kdg;
    private Rect kdh;
    private Rect kdi;
    private ValueAnimator kdk;
    private ValueAnimator kdl;
    private Animator.AnimatorListener kdm;
    private View[] kdn;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean kdj = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.kdb = fragmentActivity;
        this.kdd = view;
        this.kdc = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.kdg = this.kdc.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.kdc.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.kdn = new View[3];
        this.kdn[0] = this.kdc.findViewById(R.id.pb_video_view_pager);
        this.kdn[1] = this.kdc.findViewById(R.id.pb_video_tab_strip);
        this.kdn[2] = this.kdc.findViewById(R.id.video_pb_comment_container);
        this.kdc.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.kdc.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.kdc.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.kdc.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.kdc.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.kdc.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.kdc.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.kdc.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.kdb);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.kdc.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.kdk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kdk.setInterpolator(new DecelerateInterpolator());
        this.kdk.setDuration(300L);
        this.kdk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ap(valueAnimator.getAnimatedFraction());
            }
        });
        this.kdk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.kdm != null) {
                    f.this.kdm.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cLp();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cLp();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kdl = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kdl.setDuration(100L);
        this.kdl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ao(valueAnimator.getAnimatedFraction());
            }
        });
        this.kdl.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.kdc.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.kdn) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cLo();
                if (f.this.kdm != null) {
                    f.this.kdm.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cLo();
                if (f.this.kdm != null) {
                    f.this.kdm.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLo() {
        this.isPlaying = false;
        for (View view : this.kdn) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLp() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.kdd.setTranslationX(0.0f);
        this.kdd.setTranslationY(0.0f);
        this.kdg.setLayoutParams(this.kde);
        if (this.kdg.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.kdg.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.kdd instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.kdd).getOriginHeight() - ((VideoContainerLayout) this.kdd).getMaxHeight());
            }
        }
        this.kdd.setLayoutParams(this.kdf);
        this.kdl.start();
    }

    public void c(Rect rect, Rect rect2) {
        this.kdh = rect;
        this.kdi = rect2;
        if (cLq()) {
            init();
        }
    }

    public void start() {
        this.kdj = false;
        this.isPlaying = true;
        for (View view : this.kdn) {
            view.setVisibility(8);
        }
        this.kde = this.kdg.getLayoutParams();
        this.kdg.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.kdf = this.kdd.getLayoutParams();
        this.kdd.setLayoutParams(new RelativeLayout.LayoutParams(this.kdf.width, this.kdf.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.kdk.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(float f) {
        for (View view : this.kdn) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        float width = this.kdh.width() + ((this.kdi.width() - this.kdh.width()) * f);
        float height = this.kdh.height() + ((this.kdi.height() - this.kdh.height()) * f);
        float f2 = this.kdh.left + ((this.kdi.left - this.kdh.left) * f);
        float f3 = this.kdh.top + ((this.kdi.top - this.kdh.top) * f);
        int i = (int) (f2 - this.kdi.left);
        int i2 = (int) (f3 - this.kdi.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.kdd.setTranslationX(i);
        this.kdd.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.kdd.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.kdd.setLayoutParams(layoutParams);
        }
    }

    public boolean cLq() {
        return (!this.kdj || this.kdh == null || this.kdh.isEmpty() || this.kdi == null || this.kdi.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kdm = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
