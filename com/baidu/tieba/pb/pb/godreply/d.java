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
    private static final int hMx = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar dbp;
    private ViewStub hJr;
    private final PbActivity hLT;
    private NoNetworkView hMA;
    private PbLandscapeListView hMB;
    private b hMC;
    private View hMD;
    private View rootView;
    private int hMy = 3;
    private int hMz = 3;
    private View gRX = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hLT = pbActivity;
        this.hJr = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hMB = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bre();
            this.hMD = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hMA = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hMC = new b(this.hLT.getPageContext());
            this.hMB.setNextPage(this.hMC);
        }
    }

    private void bre() {
        this.dbp = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gRX = this.dbp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.dbp.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gRX.getLayoutParams();
            int g = l.g(this.hLT.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gRX != null && (this.gRX.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gRX.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gRX.setPadding(l.g(this.hLT.getPageContext().getPageActivity(), R.dimen.ds32), this.gRX.getPaddingTop(), this.gRX.getPaddingRight(), this.gRX.getPaddingBottom());
            this.gRX.setLayoutParams(layoutParams2);
        }
        if (this.dbp.getBackImageView() != null) {
            SvgManager.ajv().a(this.dbp.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return bUJ() && this.rootView.getVisibility() == 0;
    }

    private void bUI() {
        if (!bUJ()) {
            this.rootView = this.hJr.inflate();
            init();
            if (this.hMy != this.hMz) {
                xN(this.hMz);
            }
        }
    }

    public boolean bUJ() {
        return this.rootView != null;
    }

    public void show() {
        bUI();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void oo(boolean z) {
        if (z) {
            this.hMC.bjk();
        } else {
            this.hMC.akS();
        }
    }

    public void hide() {
        if (bUJ()) {
            this.rootView.setVisibility(8);
            this.dbp.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (bUJ()) {
            this.dbp.setStatusBarVisibility(0);
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
        if (bUJ()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (bUJ()) {
            this.contentView.setTranslationY(l.aj(this.hLT)[1]);
            this.hMD.setAlpha(0.0f);
            a(hMx, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bUJ()) {
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
            this.hMD.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hMz = i;
        if (bUJ()) {
            xN(i);
        }
    }

    private void xN(int i) {
        this.hMy = i;
        this.hLT.getLayoutMode().onModeChanged(this.rootView);
        this.dbp.onChangeSkinType(this.hLT.getPageContext(), i);
        am.k(this.hMD, R.color.cp_bg_line_k_alpha40);
        this.hMA.onChangeSkinType(this.hLT.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hMB;
    }

    public NavigationBar aLN() {
        return this.dbp;
    }

    public View bUK() {
        return this.gRX;
    }

    public View bUL() {
        return this.hMD;
    }

    public boolean bUM() {
        if (this.hMB == null || this.hMB.getChildCount() <= 0) {
            return true;
        }
        if (this.hMB.getFirstVisiblePosition() <= 0) {
            View childAt = this.hMB.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bUN() {
        return this.hMC;
    }
}
