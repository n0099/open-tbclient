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
/* loaded from: classes22.dex */
public class d {
    private static final int ljE = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fOZ;
    private ViewStub lgd;
    private PbFragment ljH;
    private NoNetworkView ljI;
    private PbLandscapeListView ljJ;
    private b ljK;
    private View ljL;
    private View rootView;
    private int ljF = 3;
    private int ljG = 3;
    private View kit = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.ljH = pbFragment;
        this.lgd = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.ljJ = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cAG();
            this.ljL = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.ljI = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.ljK = new b(this.ljH.getPageContext());
            this.ljJ.setNextPage(this.ljK);
        }
    }

    private void cAG() {
        this.fOZ = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kit = this.fOZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fOZ.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kit.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kit != null && (this.kit.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kit.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kit.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kit.getPaddingTop(), this.kit.getPaddingRight(), this.kit.getPaddingBottom());
            this.kit.setLayoutParams(layoutParams2);
        }
        if (this.fOZ.getBackImageView() != null) {
            SvgManager.boN().a(this.fOZ.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dhc() && this.rootView.getVisibility() == 0;
    }

    private void dhb() {
        if (!dhc()) {
            this.rootView = this.lgd.inflate();
            init();
            if (this.ljF != this.ljG) {
                Fu(this.ljG);
            }
        }
    }

    public boolean dhc() {
        return this.rootView != null;
    }

    public void show() {
        dhb();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tO(boolean z) {
        if (z) {
            this.ljK.csK();
        } else {
            this.ljK.endLoadData();
        }
    }

    public void hide() {
        if (dhc()) {
            this.rootView.setVisibility(8);
            this.fOZ.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (dhc()) {
            this.fOZ.setStatusBarVisibility(0);
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
        if (dhc()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (dhc()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.ljH.getContext())[1]);
            this.ljL.setAlpha(0.0f);
            a(ljE, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dhc()) {
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
            this.ljL.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.ljG = i;
        if (dhc()) {
            Fu(i);
        }
    }

    private void Fu(int i) {
        this.ljF = i;
        this.ljH.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fOZ.onChangeSkinType(this.ljH.getPageContext(), i);
        ap.setBackgroundResource(this.ljL, R.color.cp_bg_line_k_alpha40);
        this.ljI.onChangeSkinType(this.ljH.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.ljJ;
    }

    public NavigationBar bQh() {
        return this.fOZ;
    }

    public View dhd() {
        return this.kit;
    }

    public View dhe() {
        return this.ljL;
    }

    public boolean dhf() {
        if (this.ljJ == null || this.ljJ.getChildCount() <= 0) {
            return true;
        }
        if (this.ljJ.getFirstVisiblePosition() <= 0) {
            View childAt = this.ljJ.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dhg() {
        return this.ljK;
    }
}
