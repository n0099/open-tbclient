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
    private FragmentActivity luD;
    private ViewGroup luE;
    private View luF;
    private ViewGroup.LayoutParams luG;
    private ViewGroup.LayoutParams luH;
    private View luI;
    private Rect luJ;
    private Rect luK;
    private ValueAnimator luM;
    private ValueAnimator luN;
    private Animator.AnimatorListener luO;
    private View[] luP;
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private boolean luL = true;
    private boolean aEI = false;

    public f(FragmentActivity fragmentActivity, View view) {
        this.luD = fragmentActivity;
        this.luF = view;
        this.luE = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.luI = this.luE.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.luE.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.luP = new View[3];
        this.luP[0] = this.luE.findViewById(R.id.pb_video_view_pager);
        this.luP[1] = this.luE.findViewById(R.id.pb_video_tab_strip);
        this.luP[2] = this.luE.findViewById(R.id.video_pb_comment_container);
        this.luE.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.luE.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.luE.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.luE.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.luE.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.luE.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.luE.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.luE.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.luD);
        ap.setBackgroundColor(this.mMaskView, R.color.cp_bg_line_d);
        this.luE.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.luM = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.luM.setInterpolator(new DecelerateInterpolator());
        this.luM.setDuration(300L);
        this.luM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aF(valueAnimator.getAnimatedFraction());
            }
        });
        this.luM.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (f.this.luO != null) {
                    f.this.luO.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dlR();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dlR();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.luN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.luN.setDuration(100L);
        this.luN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.f.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                f.this.aE(valueAnimator.getAnimatedFraction());
            }
        });
        this.luN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.f.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                f.this.luE.removeView(f.this.mMaskView);
                ap.setBackgroundColor(f.this.mRootView, R.color.cp_bg_line_d);
                for (View view : f.this.luP) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.dlQ();
                if (f.this.luO != null) {
                    f.this.luO.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                f.this.dlQ();
                if (f.this.luO != null) {
                    f.this.luO.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlQ() {
        this.aEI = false;
        for (View view : this.luP) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dlR() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.luF.setTranslationX(0.0f);
        this.luF.setTranslationY(0.0f);
        this.luI.setLayoutParams(this.luG);
        if (this.luI.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.luI.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.luF instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.luF).getOriginHeight() - ((VideoContainerLayout) this.luF).getMaxHeight());
            }
        }
        this.luF.setLayoutParams(this.luH);
        this.luN.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.luJ = rect;
        this.luK = rect2;
        if (dlS()) {
            init();
        }
    }

    public void start() {
        this.luL = false;
        this.aEI = true;
        for (View view : this.luP) {
            view.setVisibility(8);
        }
        this.luG = this.luI.getLayoutParams();
        this.luI.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.luH = this.luF.getLayoutParams();
        this.luF.setLayoutParams(new RelativeLayout.LayoutParams(this.luH.width, this.luH.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.luM.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aE(float f) {
        for (View view : this.luP) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aF(float f) {
        float width = this.luJ.width() + ((this.luK.width() - this.luJ.width()) * f);
        float height = this.luJ.height() + ((this.luK.height() - this.luJ.height()) * f);
        float f2 = this.luJ.left + ((this.luK.left - this.luJ.left) * f);
        float f3 = this.luJ.top + ((this.luK.top - this.luJ.top) * f);
        int i = (int) (f2 - this.luK.left);
        int i2 = (int) (f3 - this.luK.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.luF.setTranslationX(i);
        this.luF.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.luF.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.luF.setLayoutParams(layoutParams);
        }
    }

    public boolean dlS() {
        return (!this.luL || this.luJ == null || this.luJ.isEmpty() || this.luK == null || this.luK.isEmpty()) ? false : true;
    }

    public void a(Animator.AnimatorListener animatorListener) {
        this.luO = animatorListener;
    }

    public boolean isPlaying() {
        return this.aEI;
    }
}
