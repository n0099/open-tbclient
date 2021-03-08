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
    private ValueAnimator mnA;
    private ValueAnimator mnB;
    private Animator.AnimatorListener mnC;
    private View[] mnD;
    private FragmentActivity mns;
    private ViewGroup mnt;
    private ViewGroup.LayoutParams mnu;
    private ViewGroup.LayoutParams mnv;
    private View mnw;
    private Rect mnx;
    private Rect mny;
    private boolean mnz = true;
    private boolean aFs = false;

    public e(FragmentActivity fragmentActivity, View view) {
        this.mns = fragmentActivity;
        this.mVideoView = view;
        this.mnt = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mnw = this.mnt.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mnt.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mnD = new View[3];
        this.mnD[0] = this.mnt.findViewById(R.id.pb_video_view_pager);
        this.mnD[1] = this.mnt.findViewById(R.id.pb_video_tab_strip);
        this.mnD[2] = this.mnt.findViewById(R.id.video_pb_comment_container);
        this.mnt.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mnt.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mnt.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mnt.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mnt.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mnt.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mnt.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mnt.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mns);
        ap.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mnt.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mnA = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mnA.setInterpolator(new DecelerateInterpolator());
        this.mnA.setDuration(300L);
        this.mnA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.ba(valueAnimator.getAnimatedFraction());
            }
        });
        this.mnA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.mnC != null) {
                    e.this.mnC.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.duU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.duU();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mnB = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mnB.setDuration(100L);
        this.mnB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aZ(valueAnimator.getAnimatedFraction());
            }
        });
        this.mnB.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                e.this.mnt.removeView(e.this.mMaskView);
                ap.setBackgroundColor(e.this.mRootView, R.color.CAM_X0201);
                for (View view : e.this.mnD) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.duT();
                if (e.this.mnC != null) {
                    e.this.mnC.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.duT();
                if (e.this.mnC != null) {
                    e.this.mnC.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duT() {
        this.aFs = false;
        for (View view : this.mnD) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void duU() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mVideoView.setTranslationX(0.0f);
        this.mVideoView.setTranslationY(0.0f);
        this.mnw.setLayoutParams(this.mnu);
        if (this.mnw.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mnw.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mVideoView instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mVideoView).getOriginHeight() - ((VideoContainerLayout) this.mVideoView).getMaxHeight());
            }
        }
        this.mVideoView.setLayoutParams(this.mnv);
        this.mnB.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mnx = rect;
        this.mny = rect2;
        if (duV()) {
            init();
        }
    }

    public void start() {
        this.mnz = false;
        this.aFs = true;
        for (View view : this.mnD) {
            view.setVisibility(8);
        }
        this.mnu = this.mnw.getLayoutParams();
        this.mnw.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mnv = this.mVideoView.getLayoutParams();
        this.mVideoView.setLayoutParams(new RelativeLayout.LayoutParams(this.mnv.width, this.mnv.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mnA.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aZ(float f) {
        for (View view : this.mnD) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ba(float f) {
        float width = this.mnx.width() + ((this.mny.width() - this.mnx.width()) * f);
        float height = this.mnx.height() + ((this.mny.height() - this.mnx.height()) * f);
        float f2 = this.mnx.left + ((this.mny.left - this.mnx.left) * f);
        float f3 = this.mnx.top + ((this.mny.top - this.mnx.top) * f);
        int i = (int) (f2 - this.mny.left);
        int i2 = (int) (f3 - this.mny.top);
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

    public boolean duV() {
        return (!this.mnz || this.mnx == null || this.mnx.isEmpty() || this.mny == null || this.mny.isEmpty()) ? false : true;
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.mnC = animatorListener;
    }

    public boolean isPlaying() {
        return this.aFs;
    }
}
