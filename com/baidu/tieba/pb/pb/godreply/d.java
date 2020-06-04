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
    private static final int jHI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar eQX;
    private ViewStub jEi;
    private PbFragment jHL;
    private NoNetworkView jHM;
    private PbLandscapeListView jHN;
    private b jHO;
    private View jHP;
    private View rootView;
    private int jHJ = 3;
    private int jHK = 3;
    private View iJQ = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.jHL = pbFragment;
        this.jEi = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.jHN = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bZx();
            this.jHP = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.jHM = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.jHO = new b(this.jHL.getPageContext());
            this.jHN.setNextPage(this.jHO);
        }
    }

    private void bZx() {
        this.eQX = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.iJQ = this.eQX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.eQX.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iJQ.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.iJQ != null && (this.iJQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iJQ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.iJQ.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.iJQ.getPaddingTop(), this.iJQ.getPaddingRight(), this.iJQ.getPaddingBottom());
            this.iJQ.setLayoutParams(layoutParams2);
        }
        if (this.eQX.getBackImageView() != null) {
            SvgManager.aUW().a(this.eQX.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cDT() && this.rootView.getVisibility() == 0;
    }

    private void cDS() {
        if (!cDT()) {
            this.rootView = this.jEi.inflate();
            init();
            if (this.jHJ != this.jHK) {
                Aa(this.jHK);
            }
        }
    }

    public boolean cDT() {
        return this.rootView != null;
    }

    public void show() {
        cDS();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ri(boolean z) {
        if (z) {
            this.jHO.bSf();
        } else {
            this.jHO.endLoadData();
        }
    }

    public void hide() {
        if (cDT()) {
            this.rootView.setVisibility(8);
            this.eQX.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(final Runnable runnable) {
        if (cDT()) {
            this.eQX.setStatusBarVisibility(0);
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
        if (cDT()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(Runnable runnable) {
        if (cDT()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.jHL.getContext())[1]);
            this.jHP.setAlpha(0.0f);
            a(jHI, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cDT()) {
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
            this.jHP.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.jHK = i;
        if (cDT()) {
            Aa(i);
        }
    }

    private void Aa(int i) {
        this.jHJ = i;
        this.jHL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.eQX.onChangeSkinType(this.jHL.getPageContext(), i);
        am.setBackgroundResource(this.jHP, R.color.cp_bg_line_k_alpha40);
        this.jHM.onChangeSkinType(this.jHL.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.jHN;
    }

    public NavigationBar bua() {
        return this.eQX;
    }

    public View cDU() {
        return this.iJQ;
    }

    public View cDV() {
        return this.jHP;
    }

    public boolean cDW() {
        if (this.jHN == null || this.jHN.getChildCount() <= 0) {
            return true;
        }
        if (this.jHN.getFirstVisiblePosition() <= 0) {
            View childAt = this.jHN.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cDX() {
        return this.jHO;
    }
}
