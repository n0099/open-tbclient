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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class e {
    private View mMaskView;
    private ViewGroup mRootView;
    private SwipeBackLayout mSwipeBackLayout;
    private View mVideoView;
    private FragmentActivity mlb;
    private ViewGroup mlc;
    private ViewGroup.LayoutParams mld;
    private ViewGroup.LayoutParams mle;
    private View mlf;
    private Rect mlg;
    private Rect mlh;
    private ValueAnimator mlj;
    private ValueAnimator mlk;
    private Animator.AnimatorListener mll;
    private View[] mlm;
    private boolean mli = true;
    private boolean aDS = false;

    public e(FragmentActivity fragmentActivity, View view) {
        this.mlb = fragmentActivity;
        this.mVideoView = view;
        this.mlc = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mlf = this.mlc.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mlc.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mlm = new View[3];
        this.mlm[0] = this.mlc.findViewById(R.id.pb_video_view_pager);
        this.mlm[1] = this.mlc.findViewById(R.id.pb_video_tab_strip);
        this.mlm[2] = this.mlc.findViewById(R.id.video_pb_comment_container);
        this.mlc.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mlc.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mlc.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mlc.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mlc.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mlc.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mlc.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mlc.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mlb);
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mlc.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mlj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlj.setInterpolator(new DecelerateInterpolator());
        this.mlj.setDuration(300L);
        this.mlj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aW(valueAnimator.getAnimatedFraction());
            }
        });
        this.mlj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.mll != null) {
                    e.this.mll.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.duE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.duE();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mlk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mlk.setDuration(100L);
        this.mlk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aV(valueAnimator.getAnimatedFraction());
            }
        });
        this.mlk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                e.this.mlc.removeView(e.this.mMaskView);
                ap.setBackgroundColor(e.this.mRootView, R.color.CAM_X0201);
                for (View view : e.this.mlm) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.duD();
                if (e.this.mll != null) {
                    e.this.mll.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.duD();
                if (e.this.mll != null) {
                    e.this.mll.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duD() {
        this.aDS = false;
        for (View view : this.mlm) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duE() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mVideoView.setTranslationX(0.0f);
        this.mVideoView.setTranslationY(0.0f);
        this.mlf.setLayoutParams(this.mld);
        if (this.mlf.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mlf.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mVideoView instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mVideoView).getOriginHeight() - ((VideoContainerLayout) this.mVideoView).getMaxHeight());
            }
        }
        this.mVideoView.setLayoutParams(this.mle);
        this.mlk.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mlg = rect;
        this.mlh = rect2;
        if (duF()) {
            init();
        }
    }

    public void start() {
        this.mli = false;
        this.aDS = true;
        for (View view : this.mlm) {
            view.setVisibility(8);
        }
        this.mld = this.mlf.getLayoutParams();
        this.mlf.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mle = this.mVideoView.getLayoutParams();
        this.mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(this.mle.width, this.mle.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mlj.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aV(float f) {
        for (View view : this.mlm) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aW(float f) {
        float width = this.mlg.width() + ((this.mlh.width() - this.mlg.width()) * f);
        float height = this.mlg.height() + ((this.mlh.height() - this.mlg.height()) * f);
        float f2 = this.mlg.left + ((this.mlh.left - this.mlg.left) * f);
        float f3 = this.mlg.top + ((this.mlh.top - this.mlg.top) * f);
        int i = (int) (f2 - this.mlh.left);
        int i2 = (int) (f3 - this.mlh.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.mVideoView.setTranslationX(i);
        this.mVideoView.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.mVideoView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.mVideoView.setLayoutParams(layoutParams);
        }
    }

    public boolean duF() {
        return (!this.mli || this.mlg == null || this.mlg.isEmpty() || this.mlh == null || this.mlh.isEmpty()) ? false : true;
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.mll = animatorListener;
    }

    public boolean isPlaying() {
        return this.aDS;
    }
}
