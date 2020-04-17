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
    private static final int jpP = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar eCi;
    private ViewStub jmC;
    private PbFragment jpS;
    private NoNetworkView jpT;
    private PbLandscapeListView jpU;
    private b jpV;
    private View jpW;
    private View rootView;
    private int jpQ = 3;
    private int jpR = 3;
    private View iur = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.jpS = pbFragment;
        this.jmC = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.jpU = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bSV();
            this.jpW = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.jpT = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.jpV = new b(this.jpS.getPageContext());
            this.jpU.setNextPage(this.jpV);
        }
    }

    private void bSV() {
        this.eCi = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.iur = this.eCi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.eCi.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iur.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.iur != null && (this.iur.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iur.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.iur.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.iur.getPaddingTop(), this.iur.getPaddingRight(), this.iur.getPaddingBottom());
            this.iur.setLayoutParams(layoutParams2);
        }
        if (this.eCi.getBackImageView() != null) {
            SvgManager.aOU().a(this.eCi.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cwI() && this.rootView.getVisibility() == 0;
    }

    private void cwH() {
        if (!cwI()) {
            this.rootView = this.jmC.inflate();
            init();
            if (this.jpQ != this.jpR) {
                zo(this.jpR);
            }
        }
    }

    public boolean cwI() {
        return this.rootView != null;
    }

    public void show() {
        cwH();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qK(boolean z) {
        if (z) {
            this.jpV.bLJ();
        } else {
            this.jpV.endLoadData();
        }
    }

    public void hide() {
        if (cwI()) {
            this.rootView.setVisibility(8);
            this.eCi.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(final Runnable runnable) {
        if (cwI()) {
            this.eCi.setStatusBarVisibility(0);
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
    public void x(Runnable runnable) {
        if (cwI()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(Runnable runnable) {
        if (cwI()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.jpS.getContext())[1]);
            this.jpW.setAlpha(0.0f);
            a(jpP, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cwI()) {
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
            this.jpW.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.jpR = i;
        if (cwI()) {
            zo(i);
        }
    }

    private void zo(int i) {
        this.jpQ = i;
        this.jpS.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.eCi.onChangeSkinType(this.jpS.getPageContext(), i);
        am.setBackgroundResource(this.jpW, R.color.cp_bg_line_k_alpha40);
        this.jpT.onChangeSkinType(this.jpS.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.jpU;
    }

    public NavigationBar boh() {
        return this.eCi;
    }

    public View cwJ() {
        return this.iur;
    }

    public View cwK() {
        return this.jpW;
    }

    public boolean cwL() {
        if (this.jpU == null || this.jpU.getChildCount() <= 0) {
            return true;
        }
        if (this.jpU.getFirstVisiblePosition() <= 0) {
            View childAt = this.jpU.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cwM() {
        return this.jpV;
    }
}
