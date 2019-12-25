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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes6.dex */
public class d {
    private static final int iyx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar dXE;
    private ViewStub ivj;
    private PbFragment iyA;
    private NoNetworkView iyB;
    private PbLandscapeListView iyC;
    private b iyD;
    private View iyE;
    private View rootView;
    private int iyy = 3;
    private int iyz = 3;
    private View hDl = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.iyA = pbFragment;
        this.ivj = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.iyC = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bFD();
            this.iyE = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.iyB = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.iyD = new b(this.iyA.getPageContext());
            this.iyC.setNextPage(this.iyD);
        }
    }

    private void bFD() {
        this.dXE = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.hDl = this.dXE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.dXE.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hDl.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.hDl != null && (this.hDl.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hDl.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.hDl.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.hDl.getPaddingTop(), this.hDl.getPaddingRight(), this.hDl.getPaddingBottom());
            this.hDl.setLayoutParams(layoutParams2);
        }
        if (this.dXE.getBackImageView() != null) {
            SvgManager.aDW().a(this.dXE.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return ciZ() && this.rootView.getVisibility() == 0;
    }

    private void ciY() {
        if (!ciZ()) {
            this.rootView = this.ivj.inflate();
            init();
            if (this.iyy != this.iyz) {
                yt(this.iyz);
            }
        }
    }

    public boolean ciZ() {
        return this.rootView != null;
    }

    public void show() {
        ciY();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pl(boolean z) {
        if (z) {
            this.iyD.byw();
        } else {
            this.iyD.endLoadData();
        }
    }

    public void hide() {
        if (ciZ()) {
            this.rootView.setVisibility(8);
            this.dXE.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (ciZ()) {
            this.dXE.setStatusBarVisibility(0);
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
    public void s(Runnable runnable) {
        if (ciZ()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (ciZ()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.iyA.getContext())[1]);
            this.iyE.setAlpha(0.0f);
            a(iyx, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (ciZ()) {
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
            this.iyE.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.iyz = i;
        if (ciZ()) {
            yt(i);
        }
    }

    private void yt(int i) {
        this.iyy = i;
        this.iyA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.dXE.onChangeSkinType(this.iyA.getPageContext(), i);
        am.setBackgroundResource(this.iyE, R.color.cp_bg_line_k_alpha40);
        this.iyB.onChangeSkinType(this.iyA.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.iyC;
    }

    public NavigationBar bcb() {
        return this.dXE;
    }

    public View cja() {
        return this.hDl;
    }

    public View cjb() {
        return this.iyE;
    }

    public boolean cjc() {
        if (this.iyC == null || this.iyC.getChildCount() <= 0) {
            return true;
        }
        if (this.iyC.getFirstVisiblePosition() <= 0) {
            View childAt = this.iyC.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cjd() {
        return this.iyD;
    }
}
