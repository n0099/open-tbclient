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
    private static final int iDT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar ebR;
    private ViewStub iAI;
    private PbFragment iDW;
    private NoNetworkView iDX;
    private PbLandscapeListView iDY;
    private b iDZ;
    private View iEa;
    private View rootView;
    private int iDU = 3;
    private int iDV = 3;
    private View hIN = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.iDW = pbFragment;
        this.iAI = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.iDY = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bIh();
            this.iEa = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.iDX = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.iDZ = new b(this.iDW.getPageContext());
            this.iDY.setNextPage(this.iDZ);
        }
    }

    private void bIh() {
        this.ebR = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.hIN = this.ebR.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.ebR.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hIN.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.hIN != null && (this.hIN.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hIN.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.hIN.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.hIN.getPaddingTop(), this.hIN.getPaddingRight(), this.hIN.getPaddingBottom());
            this.hIN.setLayoutParams(layoutParams2);
        }
        if (this.ebR.getBackImageView() != null) {
            SvgManager.aGA().a(this.ebR.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return clE() && this.rootView.getVisibility() == 0;
    }

    private void clD() {
        if (!clE()) {
            this.rootView = this.iAI.inflate();
            init();
            if (this.iDU != this.iDV) {
                yF(this.iDV);
            }
        }
    }

    public boolean clE() {
        return this.rootView != null;
    }

    public void show() {
        clD();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pA(boolean z) {
        if (z) {
            this.iDZ.bBa();
        } else {
            this.iDZ.endLoadData();
        }
    }

    public void hide() {
        if (clE()) {
            this.rootView.setVisibility(8);
            this.ebR.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (clE()) {
            this.ebR.setStatusBarVisibility(0);
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
        if (clE()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (clE()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.iDW.getContext())[1]);
            this.iEa.setAlpha(0.0f);
            a(iDT, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (clE()) {
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
            this.iEa.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.iDV = i;
        if (clE()) {
            yF(i);
        }
    }

    private void yF(int i) {
        this.iDU = i;
        this.iDW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.ebR.onChangeSkinType(this.iDW.getPageContext(), i);
        am.setBackgroundResource(this.iEa, R.color.cp_bg_line_k_alpha40);
        this.iDX.onChangeSkinType(this.iDW.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.iDY;
    }

    public NavigationBar beJ() {
        return this.ebR;
    }

    public View clF() {
        return this.hIN;
    }

    public View clG() {
        return this.iEa;
    }

    public boolean clH() {
        if (this.iDY == null || this.iDY.getChildCount() <= 0) {
            return true;
        }
        if (this.iDY.getFirstVisiblePosition() <= 0) {
            View childAt = this.iDY.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b clI() {
        return this.iDZ;
    }
}
