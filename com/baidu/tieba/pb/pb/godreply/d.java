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
/* loaded from: classes9.dex */
public class d {
    private static final int jGC = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar eQM;
    private ViewStub jDc;
    private PbFragment jGF;
    private NoNetworkView jGG;
    private PbLandscapeListView jGH;
    private b jGI;
    private View jGJ;
    private View rootView;
    private int jGD = 3;
    private int jGE = 3;
    private View iJd = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.jGF = pbFragment;
        this.jDc = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.jGH = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bZp();
            this.jGJ = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.jGG = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.jGI = new b(this.jGF.getPageContext());
            this.jGH.setNextPage(this.jGI);
        }
    }

    private void bZp() {
        this.eQM = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.iJd = this.eQM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.eQM.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iJd.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.iJd != null && (this.iJd.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iJd.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.iJd.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.iJd.getPaddingTop(), this.iJd.getPaddingRight(), this.iJd.getPaddingBottom());
            this.iJd.setLayoutParams(layoutParams2);
        }
        if (this.eQM.getBackImageView() != null) {
            SvgManager.aUV().a(this.eQM.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cDD() && this.rootView.getVisibility() == 0;
    }

    private void cDC() {
        if (!cDD()) {
            this.rootView = this.jDc.inflate();
            init();
            if (this.jGD != this.jGE) {
                zY(this.jGE);
            }
        }
    }

    public boolean cDD() {
        return this.rootView != null;
    }

    public void show() {
        cDC();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ri(boolean z) {
        if (z) {
            this.jGI.bSd();
        } else {
            this.jGI.endLoadData();
        }
    }

    public void hide() {
        if (cDD()) {
            this.rootView.setVisibility(8);
            this.eQM.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(final Runnable runnable) {
        if (cDD()) {
            this.eQM.setStatusBarVisibility(0);
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
    public void z(Runnable runnable) {
        if (cDD()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(Runnable runnable) {
        if (cDD()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.jGF.getContext())[1]);
            this.jGJ.setAlpha(0.0f);
            a(jGC, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cDD()) {
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
            this.jGJ.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.jGE = i;
        if (cDD()) {
            zY(i);
        }
    }

    private void zY(int i) {
        this.jGD = i;
        this.jGF.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.eQM.onChangeSkinType(this.jGF.getPageContext(), i);
        am.setBackgroundResource(this.jGJ, R.color.cp_bg_line_k_alpha40);
        this.jGG.onChangeSkinType(this.jGF.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.jGH;
    }

    public NavigationBar btY() {
        return this.eQM;
    }

    public View cDE() {
        return this.iJd;
    }

    public View cDF() {
        return this.jGJ;
    }

    public boolean cDG() {
        if (this.jGH == null || this.jGH.getChildCount() <= 0) {
            return true;
        }
        if (this.jGH.getFirstVisiblePosition() <= 0) {
            View childAt = this.jGH.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cDH() {
        return this.jGI;
    }
}
