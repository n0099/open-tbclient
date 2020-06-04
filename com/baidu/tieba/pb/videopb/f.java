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
    private FragmentActivity keh;
    private ViewGroup kei;
    private View kej;
    private ViewGroup.LayoutParams kek;
    private ViewGroup.LayoutParams kel;
    private View kem;
    private Rect ken;
    private Rect keo;
    private ValueAnimator keq;
    private ValueAnimator ker;
    private Animator.AnimatorListener kes;
    private View[] ket;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean kep = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.keh = fragmentActivity;
        this.kej = view;
        this.kei = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.kem = this.kei.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.kei.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.ket = new View[3];
        this.ket[0] = this.kei.findViewById(R.id.pb_video_view_pager);
        this.ket[1] = this.kei.findViewById(R.id.pb_video_tab_strip);
        this.ket[2] = this.kei.findViewById(R.id.video_pb_comment_container);
        this.kei.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.kei.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.kei.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.kei.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.kei.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.kei.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.kei.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.kei.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.keh);
        am.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.kei.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.keq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.keq.setInterpolator(new DecelerateInterpolator());
        this.keq.setDuration(300L);
        this.keq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ap(valueAnimator.getAnimatedFraction());
            }
        });
        this.keq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.kes != null) {
                    f.this.kes.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cLF();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cLF();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ker = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ker.setDuration(100L);
        this.ker.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.ao(valueAnimator.getAnimatedFraction());
            }
        });
        this.ker.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.kei.removeView(f.this.mMaskView);
                am.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.ket) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cLE();
                if (f.this.kes != null) {
                    f.this.kes.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cLE();
                if (f.this.kes != null) {
                    f.this.kes.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLE() {
        this.isPlaying = false;
        for (View view : this.ket) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cLF() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.kej.setTranslationX(0.0f);
        this.kej.setTranslationY(0.0f);
        this.kem.setLayoutParams(this.kek);
        if (this.kem.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.kem.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.kej instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.kej).getOriginHeight() - ((VideoContainerLayout) this.kej).getMaxHeight());
            }
        }
        this.kej.setLayoutParams(this.kel);
        this.ker.start();
    }

    public void c(Rect rect, Rect rect2) {
        this.ken = rect;
        this.keo = rect2;
        if (cLG()) {
            init();
        }
    }

    public void start() {
        this.kep = false;
        this.isPlaying = true;
        for (View view : this.ket) {
            view.setVisibility(8);
        }
        this.kek = this.kem.getLayoutParams();
        this.kem.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.kel = this.kej.getLayoutParams();
        this.kej.setLayoutParams(new RelativeLayout.LayoutParams(this.kel.width, this.kel.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.keq.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ao(float f) {
        for (View view : this.ket) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ap(float f) {
        float width = this.ken.width() + ((this.keo.width() - this.ken.width()) * f);
        float height = this.ken.height() + ((this.keo.height() - this.ken.height()) * f);
        float f2 = this.ken.left + ((this.keo.left - this.ken.left) * f);
        float f3 = this.ken.top + ((this.keo.top - this.ken.top) * f);
        int i = (int) (f2 - this.keo.left);
        int i2 = (int) (f3 - this.keo.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.kej.setTranslationX(i);
        this.kej.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.kej.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.kej.setLayoutParams(layoutParams);
        }
    }

    public boolean cLG() {
        return (!this.kep || this.ken == null || this.ken.isEmpty() || this.keo == null || this.keo.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kes = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
