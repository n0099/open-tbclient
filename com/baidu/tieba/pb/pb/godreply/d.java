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
    private static final int iDV = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar ebS;
    private ViewStub iAK;
    private PbFragment iDY;
    private NoNetworkView iDZ;
    private PbLandscapeListView iEa;
    private b iEb;
    private View iEc;
    private View rootView;
    private int iDW = 3;
    private int iDX = 3;
    private View hIP = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.iDY = pbFragment;
        this.iAK = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.iEa = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bIj();
            this.iEc = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.iDZ = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.iEb = new b(this.iDY.getPageContext());
            this.iEa.setNextPage(this.iEb);
        }
    }

    private void bIj() {
        this.ebS = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.hIP = this.ebS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.ebS.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hIP.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.hIP != null && (this.hIP.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hIP.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.hIP.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.hIP.getPaddingTop(), this.hIP.getPaddingRight(), this.hIP.getPaddingBottom());
            this.hIP.setLayoutParams(layoutParams2);
        }
        if (this.ebS.getBackImageView() != null) {
            SvgManager.aGC().a(this.ebS.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return clG() && this.rootView.getVisibility() == 0;
    }

    private void clF() {
        if (!clG()) {
            this.rootView = this.iAK.inflate();
            init();
            if (this.iDW != this.iDX) {
                yF(this.iDX);
            }
        }
    }

    public boolean clG() {
        return this.rootView != null;
    }

    public void show() {
        clF();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pA(boolean z) {
        if (z) {
            this.iEb.bBc();
        } else {
            this.iEb.endLoadData();
        }
    }

    public void hide() {
        if (clG()) {
            this.rootView.setVisibility(8);
            this.ebS.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (clG()) {
            this.ebS.setStatusBarVisibility(0);
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
        if (clG()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (clG()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.iDY.getContext())[1]);
            this.iEc.setAlpha(0.0f);
            a(iDV, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (clG()) {
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
            this.iEc.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.iDX = i;
        if (clG()) {
            yF(i);
        }
    }

    private void yF(int i) {
        this.iDW = i;
        this.iDY.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.ebS.onChangeSkinType(this.iDY.getPageContext(), i);
        am.setBackgroundResource(this.iEc, R.color.cp_bg_line_k_alpha40);
        this.iDZ.onChangeSkinType(this.iDY.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.iEa;
    }

    public NavigationBar beL() {
        return this.ebS;
    }

    public View clH() {
        return this.hIP;
    }

    public View clI() {
        return this.iEc;
    }

    public boolean clJ() {
        if (this.iEa == null || this.iEa.getChildCount() <= 0) {
            return true;
        }
        if (this.iEa.getFirstVisiblePosition() <= 0) {
            View childAt = this.iEa.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b clK() {
        return this.iEb;
    }
}
