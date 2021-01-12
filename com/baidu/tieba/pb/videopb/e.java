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
    private FragmentActivity mbZ;
    private ViewGroup mca;
    private View mcb;
    private ViewGroup.LayoutParams mcc;
    private ViewGroup.LayoutParams mcd;
    private View mce;
    private Rect mcf;
    private Rect mcg;
    private ValueAnimator mci;
    private ValueAnimator mcj;
    private Animator.AnimatorListener mck;
    private View[] mcl;
    private boolean mch = true;
    private boolean aCf = false;

    public e(FragmentActivity fragmentActivity, View view) {
        this.mbZ = fragmentActivity;
        this.mcb = view;
        this.mca = (ViewGroup) fragmentActivity.getWindow().getDecorView();
        this.mce = this.mca.findViewById(R.id.appbar_layout);
        this.mRootView = (ViewGroup) this.mca.findViewById(R.id.video_pb_root);
    }

    private void init() {
        this.mcl = new View[3];
        this.mcl[0] = this.mca.findViewById(R.id.pb_video_view_pager);
        this.mcl[1] = this.mca.findViewById(R.id.pb_video_tab_strip);
        this.mcl[2] = this.mca.findViewById(R.id.video_pb_comment_container);
        this.mca.findViewById(16908290).setBackgroundResource(R.color.transparent);
        this.mca.findViewById(R.id.container).setBackgroundResource(R.color.transparent);
        this.mca.findViewById(R.id.video_pb_root).setBackgroundResource(R.color.transparent);
        this.mca.findViewById(R.id.pb_video_nested_scroll_layout).setBackgroundResource(R.color.transparent);
        this.mca.findViewById(R.id.appbar_layout).setBackgroundResource(R.color.transparent);
        this.mca.findViewById(R.id.scroll_container).setBackgroundResource(R.color.transparent);
        if (this.mca.getChildAt(0) instanceof SwipeBackLayout) {
            this.mSwipeBackLayout = (SwipeBackLayout) this.mca.getChildAt(0);
            this.mSwipeBackLayout.setBgTransparent();
        }
        this.mMaskView = new View(this.mbZ);
        ao.setBackgroundColor(this.mMaskView, R.color.CAM_X0201);
        this.mca.addView(this.mMaskView, 0, new ViewGroup.LayoutParams(-1, -1));
        this.mci = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mci.setInterpolator(new DecelerateInterpolator());
        this.mci.setDuration(300L);
        this.mci.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aT(valueAnimator.getAnimatedFraction());
            }
        });
        this.mci.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (e.this.mck != null) {
                    e.this.mck.onAnimationStart(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.dst();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.dst();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.mcj = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mcj.setDuration(100L);
        this.mcj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.pb.videopb.e.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                e.this.aS(valueAnimator.getAnimatedFraction());
            }
        });
        this.mcj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.pb.videopb.e.4
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                View[] viewArr;
                e.this.mca.removeView(e.this.mMaskView);
                ao.setBackgroundColor(e.this.mRootView, R.color.CAM_X0201);
                for (View view : e.this.mcl) {
                    view.setVisibility(0);
                    view.setAlpha(0.0f);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                e.this.dss();
                if (e.this.mck != null) {
                    e.this.mck.onAnimationEnd(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                e.this.dss();
                if (e.this.mck != null) {
                    e.this.mck.onAnimationCancel(animator);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dss() {
        this.aCf = false;
        for (View view : this.mcl) {
            view.setAlpha(1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dst() {
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(1.0f);
        }
        this.mcb.setTranslationX(0.0f);
        this.mcb.setTranslationY(0.0f);
        this.mce.setLayoutParams(this.mcc);
        if (this.mce.getLayoutParams() instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) this.mce.getLayoutParams()).getBehavior();
            if ((behavior instanceof VideoZoomBehavior) && (this.mcb instanceof VideoContainerLayout)) {
                ((VideoZoomBehavior) behavior).setTopAndBottomOffset(((VideoContainerLayout) this.mcb).getOriginHeight() - ((VideoContainerLayout) this.mcb).getMaxHeight());
            }
        }
        this.mcb.setLayoutParams(this.mcd);
        this.mcj.start();
    }

    public void b(Rect rect, Rect rect2) {
        this.mcf = rect;
        this.mcg = rect2;
        if (dsu()) {
            init();
        }
    }

    public void start() {
        this.mch = false;
        this.aCf = true;
        for (View view : this.mcl) {
            view.setVisibility(8);
        }
        this.mcc = this.mce.getLayoutParams();
        this.mce.setLayoutParams(new CoordinatorLayout.LayoutParams(l.getEquipmentWidth(TbadkCoreApplication.getInst()), l.getEquipmentHeight(TbadkCoreApplication.getInst())));
        this.mcd = this.mcb.getLayoutParams();
        this.mcb.setLayoutParams(new RelativeLayout.LayoutParams(this.mcd.width, this.mcd.height));
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(0.0f);
        }
        this.mci.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aS(float f) {
        for (View view : this.mcl) {
            view.setAlpha(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aT(float f) {
        float width = this.mcf.width() + ((this.mcg.width() - this.mcf.width()) * f);
        float height = this.mcf.height() + ((this.mcg.height() - this.mcf.height()) * f);
        float f2 = this.mcf.left + ((this.mcg.left - this.mcf.left) * f);
        float f3 = this.mcf.top + ((this.mcg.top - this.mcf.top) * f);
        int i = (int) (f2 - this.mcg.left);
        int i2 = (int) (f3 - this.mcg.top);
        if (this.mMaskView != null) {
            this.mMaskView.setAlpha(f);
        }
        this.mcb.setTranslationX(i);
        this.mcb.setTranslationY(i2);
        ViewGroup.LayoutParams layoutParams = this.mcb.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) width;
            layoutParams.height = (int) height;
            this.mcb.setLayoutParams(layoutParams);
        }
    }

    public boolean dsu() {
        return (!this.mch || this.mcf == null || this.mcf.isEmpty() || this.mcg == null || this.mcg.isEmpty()) ? false : true;
    }

    public void c(Animator.AnimatorListener animatorListener) {
        this.mck = animatorListener;
    }

    public boolean isPlaying() {
        return this.aCf;
    }
}
