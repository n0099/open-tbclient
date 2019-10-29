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
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes4.dex */
public class d {
    private static final int hLb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar dkM;
    private ViewStub hHW;
    private final PbActivity hKw;
    private NoNetworkView hLe;
    private PbLandscapeListView hLf;
    private b hLg;
    private View hLh;
    private View rootView;
    private int hLc = 3;
    private int hLd = 3;
    private View gPY = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hKw = pbActivity;
        this.hHW = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hLf = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            boi();
            this.hLh = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hLe = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hLg = new b(this.hKw.getPageContext());
            this.hLf.setNextPage(this.hLg);
        }
    }

    private void boi() {
        this.dkM = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gPY = this.dkM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.dkM.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gPY.getLayoutParams();
            int dimens = l.getDimens(this.hKw.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gPY != null && (this.gPY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gPY.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gPY.setPadding(l.getDimens(this.hKw.getPageContext().getPageActivity(), R.dimen.ds32), this.gPY.getPaddingTop(), this.gPY.getPaddingRight(), this.gPY.getPaddingBottom());
            this.gPY.setLayoutParams(layoutParams2);
        }
        if (this.dkM.getBackImageView() != null) {
            SvgManager.amN().a(this.dkM.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return bRK() && this.rootView.getVisibility() == 0;
    }

    private void bRJ() {
        if (!bRK()) {
            this.rootView = this.hHW.inflate();
            init();
            if (this.hLc != this.hLd) {
                ws(this.hLd);
            }
        }
    }

    public boolean bRK() {
        return this.rootView != null;
    }

    public void show() {
        bRJ();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nX(boolean z) {
        if (z) {
            this.hLg.bhd();
        } else {
            this.hLg.endLoadData();
        }
    }

    public void hide() {
        if (bRK()) {
            this.rootView.setVisibility(8);
            this.dkM.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(final Runnable runnable) {
        if (bRK()) {
            this.dkM.setStatusBarVisibility(0);
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
    public void p(Runnable runnable) {
        if (bRK()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Runnable runnable) {
        if (bRK()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.hKw)[1]);
            this.hLh.setAlpha(0.0f);
            a(hLb, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bRK()) {
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
            this.hLh.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hLd = i;
        if (bRK()) {
            ws(i);
        }
    }

    private void ws(int i) {
        this.hLc = i;
        this.hKw.getLayoutMode().onModeChanged(this.rootView);
        this.dkM.onChangeSkinType(this.hKw.getPageContext(), i);
        am.setBackgroundResource(this.hLh, R.color.cp_bg_line_k_alpha40);
        this.hLe.onChangeSkinType(this.hKw.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hLf;
    }

    public NavigationBar aKR() {
        return this.dkM;
    }

    public View bRL() {
        return this.gPY;
    }

    public View bRM() {
        return this.hLh;
    }

    public boolean bRN() {
        if (this.hLf == null || this.hLf.getChildCount() <= 0) {
            return true;
        }
        if (this.hLf.getFirstVisiblePosition() <= 0) {
            View childAt = this.hLf.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bRO() {
        return this.hLg;
    }
}
