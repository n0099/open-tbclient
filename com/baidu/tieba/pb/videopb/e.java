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
    private FragmentActivity mgF;
    private ViewGroup mgG;
    private View mgH;
    private ViewGroup.LayoutParams mgI;
    private ViewGroup.LayoutParams mgJ;
    private View mgK;
    private Rect mgL;
    private Rect mgM;
    private ValueAnimator mgO;
    private ValueAnimator mgP;
    private Animator.AnimatorListener mgQ;
    private View[] mgR;
    private boolean mgN = true;
    private boolean aGS = false;

    public e(FragmentActivity fragmentActivity, View view) {
        this.mgF = fragmentActivity;
        this.mgH = view;
        this.mgG = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mgK = this.mgG.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mgG.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mgR = new View[3];
        this.mgR[0] = this.mgG.findViewById(R.id.pb_video_view_pager);
        this.mgR[1] = this.mgG.findViewById(R.id.pb_video_tab_strip);
        this.mgR[2] = this.mgG.findViewById(R.id.video_pb_comment_container);
        this.mgG.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mgG.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mgG.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mgG.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mgG.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mgG.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mgG.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mgG.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mgF);
        ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mgG.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mgO = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mgO.setInterpolator(new DecelerateInterpolator());
        this.mgO.setDuration(300L);
        this.mgO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aT(valueAnimator.getAnimatedFraction());
            }
        });
        this.mgO.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.mgQ != null) {
                    e.this.mgQ.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.dwk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.dwk();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mgP = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mgP.setDuration(100L);
        this.mgP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aS(valueAnimator.getAnimatedFraction());
            }
        });
        this.mgP.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                e.this.mgG.removeView(e.this.mMaskView);
                ao.setBackgroundColor(e.this.mRootView, R.color.CAM_X0201);
                for (View view : e.this.mgR) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.dwj();
                if (e.this.mgQ != null) {
                    e.this.mgQ.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.dwj();
                if (e.this.mgQ != null) {
                    e.this.mgQ.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwj() {
        this.aGS = false;
        for (View view : this.mgR) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dwk() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mgH.setTranslationX(0.0f);
        this.mgH.setTranslationY(0.0f);
        this.mgK.setLayoutParams(this.mgI);
        if (this.mgK.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mgK.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mgH instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mgH).getOriginHeight() - ((VideoContainerLayout) this.mgH).getMaxHeight());
            }
        }
        this.mgH.setLayoutParams(this.mgJ);
        this.mgP.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mgL = rect;
        this.mgM = rect2;
        if (dwl()) {
            init();
        }
    }

    public void start() {
        this.mgN = false;
        this.aGS = true;
        for (View view : this.mgR) {
            view.setVisibility(8);
        }
        this.mgI = this.mgK.getLayoutParams();
        this.mgK.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mgJ = this.mgH.getLayoutParams();
        this.mgH.setLayoutParams(new RelativeLayout.LayoutParams(this.mgJ.width, this.mgJ.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mgO.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(float f) {
        for (View view : this.mgR) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(float f) {
        float width = this.mgL.width() + ((this.mgM.width() - this.mgL.width()) * f);
        float height = this.mgL.height() + ((this.mgM.height() - this.mgL.height()) * f);
        float f2 = this.mgL.left + ((this.mgM.left - this.mgL.left) * f);
        float f3 = this.mgL.top + ((this.mgM.top - this.mgL.top) * f);
        int i = (int) (f2 - this.mgM.left);
        int i2 = (int) (f3 - this.mgM.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.mgH.setTranslationX(i);
        this.mgH.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.mgH.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.mgH.setLayoutParams(layoutParams);
        }
    }

    public boolean dwl() {
        return (!this.mgN || this.mgL == null || this.mgL.isEmpty() || this.mgM == null || this.mgM.isEmpty()) ? false : true;
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.mgQ = animatorListener;
    }

    public boolean isPlaying() {
        return this.aGS;
    }
}
