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
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class f {
    private FragmentActivity kxW;
    private ViewGroup kxX;
    private View kxY;
    private ViewGroup.LayoutParams kxZ;
    private ViewGroup.LayoutParams kya;
    private View kyb;
    private Rect kyc;
    private Rect kyd;
    private ValueAnimator kyf;
    private ValueAnimator kyg;
    private Animator.AnimatorListener kyh;
    private View[] kyi;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean kye = true;
    private boolean isPlaying = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.kxW = fragmentActivity;
        this.kxY = view;
        this.kxX = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.kyb = this.kxX.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.kxX.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.kyi = new View[3];
        this.kyi[0] = this.kxX.findViewById(R.id.pb_video_view_pager);
        this.kyi[1] = this.kxX.findViewById(R.id.pb_video_tab_strip);
        this.kyi[2] = this.kxX.findViewById(R.id.video_pb_comment_container);
        this.kxX.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.kxX.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.kxX.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.kxX.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.kxX.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.kxX.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.kxX.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.kxX.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.kxW);
        an.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.kxX.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.kyf = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kyf.setInterpolator(new DecelerateInterpolator());
        this.kyf.setDuration(300L);
        this.kyf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.au(valueAnimator.getAnimatedFraction());
            }
        });
        this.kyf.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.kyh != null) {
                    f.this.kyh.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cPX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cPX();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.kyg = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.kyg.setDuration(100L);
        this.kyg.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.at(valueAnimator.getAnimatedFraction());
            }
        });
        this.kyg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.kxX.removeView(f.this.mMaskView);
                an.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.kyi) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.cPW();
                if (f.this.kyh != null) {
                    f.this.kyh.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.cPW();
                if (f.this.kyh != null) {
                    f.this.kyh.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPW() {
        this.isPlaying = false;
        for (View view : this.kyi) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cPX() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.kxY.setTranslationX(0.0f);
        this.kxY.setTranslationY(0.0f);
        this.kyb.setLayoutParams(this.kxZ);
        if (this.kyb.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.kyb.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.kxY instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.kxY).getOriginHeight() - ((VideoContainerLayout) this.kxY).getMaxHeight());
            }
        }
        this.kxY.setLayoutParams(this.kya);
        this.kyg.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.kyc = rect;
        this.kyd = rect2;
        if (cPY()) {
            init();
        }
    }

    public void start() {
        this.kye = false;
        this.isPlaying = true;
        for (View view : this.kyi) {
            view.setVisibility(8);
        }
        this.kxZ = this.kyb.getLayoutParams();
        this.kyb.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.kya = this.kxY.getLayoutParams();
        this.kxY.setLayoutParams(new RelativeLayout.LayoutParams(this.kya.width, this.kya.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.kyf.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void at(float f) {
        for (View view : this.kyi) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void au(float f) {
        float width = this.kyc.width() + ((this.kyd.width() - this.kyc.width()) * f);
        float height = this.kyc.height() + ((this.kyd.height() - this.kyc.height()) * f);
        float f2 = this.kyc.left + ((this.kyd.left - this.kyc.left) * f);
        float f3 = this.kyc.top + ((this.kyd.top - this.kyc.top) * f);
        int i = (int) (f2 - this.kyd.left);
        int i2 = (int) (f3 - this.kyd.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.kxY.setTranslationX(i);
        this.kxY.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.kxY.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.kxY.setLayoutParams(layoutParams);
        }
    }

    public boolean cPY() {
        return (!this.kye || this.kyc == null || this.kyc.isEmpty() || this.kyd == null || this.kyd.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.kyh = animatorListener;
    }

    public boolean isPlaying() {
        return this.isPlaying;
    }
}
