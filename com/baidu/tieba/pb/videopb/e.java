package com.baidu.tieba.pb.videopb;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.FragmentActivity;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.SwipeBackLayout;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private FragmentActivity mgE;
    private ViewGroup mgF;
    private View mgG;
    private ViewGroup.LayoutParams mgH;
    private ViewGroup.LayoutParams mgI;
    private View mgJ;
    private Rect mgK;
    private Rect mgL;
    private ValueAnimator mgN;
    private ValueAnimator mgO;
    private Animator.AnimatorListener mgP;
    private View[] mgQ;
    private boolean mgM = true;
    private boolean aGS = false;

    public e(FragmentActivity fragmentActivity, View view) {
        this.mgE = fragmentActivity;
        this.mgG = view;
        this.mgF = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mgJ = this.mgF.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mgF.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mgQ = new View[3];
        this.mgQ[0] = this.mgF.findViewById(R.id.pb_video_view_pager);
        this.mgQ[1] = this.mgF.findViewById(R.id.pb_video_tab_strip);
        this.mgQ[2] = this.mgF.findViewById(R.id.video_pb_comment_container);
        this.mgF.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mgF.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mgF.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mgF.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mgF.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mgF.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mgF.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mgF.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mgE);
        ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mgF.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mgN = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mgN.setInterpolator(new DecelerateInterpolator());
        this.mgN.setDuration(300L);
        this.mgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aT(valueAnimator.getAnimatedFraction());
            }
        });
        this.mgN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.mgP != null) {
                    e.this.mgP.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.dwl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.dwl();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mgO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mgO.setDuration(100L);
        this.mgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aS(valueAnimator.getAnimatedFraction());
            }
        });
        this.mgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                e.this.mgF.removeView(e.this.mMaskView);
                ao.setBackgroundColor(e.this.mRootView, R.color.CAM_X0201);
                for (View view : e.this.mgQ) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.dwk();
                if (e.this.mgP != null) {
                    e.this.mgP.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.dwk();
                if (e.this.mgP != null) {
                    e.this.mgP.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwk() {
        this.aGS = false;
        for (View view : this.mgQ) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwl() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mgG.setTranslationX(0.0f);
        this.mgG.setTranslationY(0.0f);
        this.mgJ.setLayoutParams(this.mgH);
        if (this.mgJ.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mgJ.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mgG instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mgG).getOriginHeight() - ((VideoContainerLayout) this.mgG).getMaxHeight());
            }
        }
        this.mgG.setLayoutParams(this.mgI);
        this.mgO.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mgK = rect;
        this.mgL = rect2;
        if (dwm()) {
            init();
        }
    }

    public void start() {
        this.mgM = false;
        this.aGS = true;
        for (View view : this.mgQ) {
            view.setVisibility(8);
        }
        this.mgH = this.mgJ.getLayoutParams();
        this.mgJ.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mgI = this.mgG.getLayoutParams();
        this.mgG.setLayoutParams(new RelativeLayout.LayoutParams(this.mgI.width, this.mgI.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mgN.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(float f) {
        for (View view : this.mgQ) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(float f) {
        float width = this.mgK.width() + ((this.mgL.width() - this.mgK.width()) * f);
        float height = this.mgK.height() + ((this.mgL.height() - this.mgK.height()) * f);
        float f2 = this.mgK.left + ((this.mgL.left - this.mgK.left) * f);
        float f3 = this.mgK.top + ((this.mgL.top - this.mgK.top) * f);
        int i = (int) (f2 - this.mgL.left);
        int i2 = (int) (f3 - this.mgL.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.mgG.setTranslationX(i);
        this.mgG.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.mgG.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.mgG.setLayoutParams(layoutParams);
        }
    }

    public boolean dwm() {
        return (!this.mgM || this.mgK == null || this.mgK.isEmpty() || this.mgL == null || this.mgL.isEmpty()) ? false : true;
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.mgP = animatorListener;
    }

    public boolean isPlaying() {
        return this.aGS;
    }
}
