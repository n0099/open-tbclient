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
    private static final int iFI = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar ecv;
    private ViewStub iCw;
    private PbFragment iFL;
    private NoNetworkView iFM;
    private PbLandscapeListView iFN;
    private b iFO;
    private View iFP;
    private View rootView;
    private int iFJ = 3;
    private int iFK = 3;
    private View hKB = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.iFL = pbFragment;
        this.iCw = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.iFN = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bIw();
            this.iFP = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.iFM = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.iFO = new b(this.iFL.getPageContext());
            this.iFN.setNextPage(this.iFO);
        }
    }

    private void bIw() {
        this.ecv = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.hKB = this.ecv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.ecv.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hKB.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.hKB != null && (this.hKB.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hKB.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.hKB.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.hKB.getPaddingTop(), this.hKB.getPaddingRight(), this.hKB.getPaddingBottom());
            this.hKB.setLayoutParams(layoutParams2);
        }
        if (this.ecv.getBackImageView() != null) {
            SvgManager.aGG().a(this.ecv.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cmc() && this.rootView.getVisibility() == 0;
    }

    private void cmb() {
        if (!cmc()) {
            this.rootView = this.iCw.inflate();
            init();
            if (this.iFJ != this.iFK) {
                yN(this.iFK);
            }
        }
    }

    public boolean cmc() {
        return this.rootView != null;
    }

    public void show() {
        cmb();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pG(boolean z) {
        if (z) {
            this.iFO.bBj();
        } else {
            this.iFO.endLoadData();
        }
    }

    public void hide() {
        if (cmc()) {
            this.rootView.setVisibility(8);
            this.ecv.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (cmc()) {
            this.ecv.setStatusBarVisibility(0);
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
        if (cmc()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (cmc()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.iFL.getContext())[1]);
            this.iFP.setAlpha(0.0f);
            a(iFI, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cmc()) {
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
            this.iFP.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.iFK = i;
        if (cmc()) {
            yN(i);
        }
    }

    private void yN(int i) {
        this.iFJ = i;
        this.iFL.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.ecv.onChangeSkinType(this.iFL.getPageContext(), i);
        am.setBackgroundResource(this.iFP, R.color.cp_bg_line_k_alpha40);
        this.iFM.onChangeSkinType(this.iFL.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.iFN;
    }

    public NavigationBar beR() {
        return this.ecv;
    }

    public View cmd() {
        return this.hKB;
    }

    public View cme() {
        return this.iFP;
    }

    public boolean cmf() {
        if (this.iFN == null || this.iFN.getChildCount() <= 0) {
            return true;
        }
        if (this.iFN.getFirstVisiblePosition() <= 0) {
            View childAt = this.iFN.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cmg() {
        return this.iFO;
    }
}
