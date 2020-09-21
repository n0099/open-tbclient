package com.baidu.tieba.pb.pb.godreply;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes21.dex */
public class d {
    private static final int kHU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fuv;
    private ViewStub kEt;
    private PbFragment kHX;
    private NoNetworkView kHY;
    private PbLandscapeListView kHZ;
    private b kIa;
    private View kIb;
    private View rootView;
    private int kHV = 3;
    private int kHW = 3;
    private View jGV = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.kHX = pbFragment;
        this.kEt = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.kHZ = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cuc();
            this.kIb = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.kHY = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.kIa = new b(this.kHX.getPageContext());
            this.kHZ.setNextPage(this.kIa);
        }
    }

    private void cuc() {
        this.fuv = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.jGV = this.fuv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fuv.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jGV.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.jGV != null && (this.jGV.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jGV.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.jGV.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.jGV.getPaddingTop(), this.jGV.getPaddingRight(), this.jGV.getPaddingBottom());
            this.jGV.setLayoutParams(layoutParams2);
        }
        if (this.fuv.getBackImageView() != null) {
            SvgManager.bkl().a(this.fuv.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dam() && this.rootView.getVisibility() == 0;
    }

    private void dal() {
        if (!dam()) {
            this.rootView = this.kEt.inflate();
            init();
            if (this.kHV != this.kHW) {
                Ev(this.kHW);
            }
        }
    }

    public boolean dam() {
        return this.rootView != null;
    }

    public void show() {
        dal();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sQ(boolean z) {
        if (z) {
            this.kIa.cmf();
        } else {
            this.kIa.endLoadData();
        }
    }

    public void hide() {
        if (dam()) {
            this.rootView.setVisibility(8);
            this.fuv.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (dam()) {
            this.fuv.setStatusBarVisibility(0);
            this.contentView.animate().translationY(0.0f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.d.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(Runnable runnable) {
        if (dam()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (dam()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.kHX.getContext())[1]);
            this.kIb.setAlpha(0.0f);
            a(kHU, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dam()) {
            this.contentView.animate().translationY(f).setDuration(300L).setListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.pb.pb.godreply.d.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            }).start();
            this.kIb.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.kHW = i;
        if (dam()) {
            Ev(i);
        }
    }

    private void Ev(int i) {
        this.kHV = i;
        this.kHX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fuv.onChangeSkinType(this.kHX.getPageContext(), i);
        ap.setBackgroundResource(this.kIb, R.color.cp_bg_line_k_alpha40);
        this.kHY.onChangeSkinType(this.kHX.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.kHZ;
    }

    public NavigationBar bKS() {
        return this.fuv;
    }

    public View dan() {
        return this.jGV;
    }

    public View dao() {
        return this.kIb;
    }

    public boolean dap() {
        if (this.kHZ == null || this.kHZ.getChildCount() <= 0) {
            return true;
        }
        if (this.kHZ.getFirstVisiblePosition() <= 0) {
            View childAt = this.kHZ.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b daq() {
        return this.kIa;
    }
}
