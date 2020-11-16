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
/* loaded from: classes21.dex */
public class d {
    private static final int lpU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fUw;
    private ViewStub lmp;
    private PbFragment lpX;
    private NoNetworkView lpY;
    private PbLandscapeListView lpZ;
    private b lqa;
    private View lqb;
    private View rootView;
    private int lpV = 3;
    private int lpW = 3;
    private View koZ = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lpX = pbFragment;
        this.lmp = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lpZ = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cCL();
            this.lqb = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lpY = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lqa = new b(this.lpX.getPageContext());
            this.lpZ.setNextPage(this.lqa);
        }
    }

    private void cCL() {
        this.fUw = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.koZ = this.fUw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fUw.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.koZ.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.koZ != null && (this.koZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.koZ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.koZ.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.koZ.getPaddingTop(), this.koZ.getPaddingRight(), this.koZ.getPaddingBottom());
            this.koZ.setLayoutParams(layoutParams2);
        }
        if (this.fUw.getBackImageView() != null) {
            SvgManager.bqB().a(this.fUw.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dja() && this.rootView.getVisibility() == 0;
    }

    private void diZ() {
        if (!dja()) {
            this.rootView = this.lmp.inflate();
            init();
            if (this.lpV != this.lpW) {
                Gf(this.lpW);
            }
        }
    }

    public boolean dja() {
        return this.rootView != null;
    }

    public void show() {
        diZ();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ua(boolean z) {
        if (z) {
            this.lqa.cuO();
        } else {
            this.lqa.endLoadData();
        }
    }

    public void hide() {
        if (dja()) {
            this.rootView.setVisibility(8);
            this.fUw.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (dja()) {
            this.fUw.setStatusBarVisibility(0);
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
    public void v(Runnable runnable) {
        if (dja()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (dja()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lpX.getContext())[1]);
            this.lqb.setAlpha(0.0f);
            a(lpU, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dja()) {
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
            this.lqb.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lpW = i;
        if (dja()) {
            Gf(i);
        }
    }

    private void Gf(int i) {
        this.lpV = i;
        this.lpX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fUw.onChangeSkinType(this.lpX.getPageContext(), i);
        ap.setBackgroundResource(this.lqb, R.color.cp_bg_line_k_alpha40);
        this.lpY.onChangeSkinType(this.lpX.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lpZ;
    }

    public NavigationBar bSa() {
        return this.fUw;
    }

    public View djb() {
        return this.koZ;
    }

    public View djc() {
        return this.lqb;
    }

    public boolean djd() {
        if (this.lpZ == null || this.lpZ.getChildCount() <= 0) {
            return true;
        }
        if (this.lpZ.getFirstVisiblePosition() <= 0) {
            View childAt = this.lpZ.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dje() {
        return this.lqa;
    }
}
