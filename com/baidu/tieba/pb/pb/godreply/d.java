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
/* loaded from: classes2.dex */
public class d {
    private static final int lPl = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar glw;
    private ViewStub lLu;
    private PbFragment lPo;
    private NoNetworkView lPp;
    private PbLandscapeListView lPq;
    private b lPr;
    private View lPs;
    private View rootView;
    private int lPm = 3;
    private int lPn = 3;
    private View kNJ = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lPo = pbFragment;
        this.lLu = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lPq = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cIG();
            this.lPs = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lPp = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lPr = new b(this.lPo.getPageContext());
            this.lPq.setNextPage(this.lPr);
        }
    }

    private void cIG() {
        this.glw = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kNJ = this.glw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.glw.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kNJ.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kNJ != null && (this.kNJ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kNJ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kNJ.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kNJ.getPaddingTop(), this.kNJ.getPaddingRight(), this.kNJ.getPaddingBottom());
            this.kNJ.setLayoutParams(layoutParams2);
        }
        if (this.glw.getBackImageView() != null) {
            SvgManager.bsU().a(this.glw.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dmL() && this.rootView.getVisibility() == 0;
    }

    private void dmK() {
        if (!dmL()) {
            this.rootView = this.lLu.inflate();
            init();
            if (this.lPm != this.lPn) {
                FC(this.lPn);
            }
        }
    }

    public boolean dmL() {
        return this.rootView != null;
    }

    public void show() {
        dmK();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uN(boolean z) {
        if (z) {
            this.lPr.czE();
        } else {
            this.lPr.endLoadData();
        }
    }

    public void hide() {
        if (dmL()) {
            this.rootView.setVisibility(8);
            this.glw.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        if (dmL()) {
            this.glw.setStatusBarVisibility(0);
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
    public void r(Runnable runnable) {
        if (dmL()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Runnable runnable) {
        if (dmL()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lPo.getContext())[1]);
            this.lPs.setAlpha(0.0f);
            a(lPl, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dmL()) {
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
            this.lPs.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lPn = i;
        if (dmL()) {
            FC(i);
        }
    }

    private void FC(int i) {
        this.lPm = i;
        this.lPo.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.glw.onChangeSkinType(this.lPo.getPageContext(), i);
        ap.setBackgroundResource(this.lPs, R.color.cp_bg_line_k_alpha40);
        this.lPp.onChangeSkinType(this.lPo.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lPq;
    }

    public NavigationBar bVq() {
        return this.glw;
    }

    public View dmM() {
        return this.kNJ;
    }

    public View dmN() {
        return this.lPs;
    }

    public boolean dmO() {
        if (this.lPq == null || this.lPq.getChildCount() <= 0) {
            return true;
        }
        if (this.lPq.getFirstVisiblePosition() <= 0) {
            View childAt = this.lPq.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dmP() {
        return this.lPr;
    }
}
