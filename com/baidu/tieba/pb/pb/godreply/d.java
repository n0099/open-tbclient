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
    private static final int iEh = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar ecf;
    private ViewStub iAW;
    private PbFragment iEk;
    private NoNetworkView iEl;
    private PbLandscapeListView iEm;
    private b iEn;
    private View iEo;
    private View rootView;
    private int iEi = 3;
    private int iEj = 3;
    private View hJb = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.iEk = pbFragment;
        this.iAW = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.iEm = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bIk();
            this.iEo = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.iEl = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.iEn = new b(this.iEk.getPageContext());
            this.iEm.setNextPage(this.iEn);
        }
    }

    private void bIk() {
        this.ecf = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.hJb = this.ecf.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.ecf.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hJb.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.hJb != null && (this.hJb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hJb.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.hJb.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.hJb.getPaddingTop(), this.hJb.getPaddingRight(), this.hJb.getPaddingBottom());
            this.hJb.setLayoutParams(layoutParams2);
        }
        if (this.ecf.getBackImageView() != null) {
            SvgManager.aGC().a(this.ecf.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return clH() && this.rootView.getVisibility() == 0;
    }

    private void clG() {
        if (!clH()) {
            this.rootView = this.iAW.inflate();
            init();
            if (this.iEi != this.iEj) {
                yF(this.iEj);
            }
        }
    }

    public boolean clH() {
        return this.rootView != null;
    }

    public void show() {
        clG();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void pA(boolean z) {
        if (z) {
            this.iEn.bBd();
        } else {
            this.iEn.endLoadData();
        }
    }

    public void hide() {
        if (clH()) {
            this.rootView.setVisibility(8);
            this.ecf.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (clH()) {
            this.ecf.setStatusBarVisibility(0);
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
        if (clH()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (clH()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.iEk.getContext())[1]);
            this.iEo.setAlpha(0.0f);
            a(iEh, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (clH()) {
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
            this.iEo.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.iEj = i;
        if (clH()) {
            yF(i);
        }
    }

    private void yF(int i) {
        this.iEi = i;
        this.iEk.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.ecf.onChangeSkinType(this.iEk.getPageContext(), i);
        am.setBackgroundResource(this.iEo, R.color.cp_bg_line_k_alpha40);
        this.iEl.onChangeSkinType(this.iEk.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.iEm;
    }

    public NavigationBar beM() {
        return this.ecf;
    }

    public View clI() {
        return this.hJb;
    }

    public View clJ() {
        return this.iEo;
    }

    public boolean clK() {
        if (this.iEm == null || this.iEm.getChildCount() <= 0) {
            return true;
        }
        if (this.iEm.getFirstVisiblePosition() <= 0) {
            View childAt = this.iEm.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b clL() {
        return this.iEn;
    }
}
