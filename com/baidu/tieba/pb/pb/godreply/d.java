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
/* loaded from: classes16.dex */
public class d {
    private static final int kzq = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fre;
    private ViewStub kvN;
    private PbFragment kzt;
    private NoNetworkView kzu;
    private PbLandscapeListView kzv;
    private b kzw;
    private View kzx;
    private View rootView;
    private int kzr = 3;
    private int kzs = 3;
    private View jyn = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.kzt = pbFragment;
        this.kvN = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.kzv = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cqO();
            this.kzx = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.kzu = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.kzw = new b(this.kzt.getPageContext());
            this.kzv.setNextPage(this.kzw);
        }
    }

    private void cqO() {
        this.fre = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.jyn = this.fre.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fre.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jyn.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.jyn != null && (this.jyn.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jyn.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.jyn.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.jyn.getPaddingTop(), this.jyn.getPaddingRight(), this.jyn.getPaddingBottom());
            this.jyn.setLayoutParams(layoutParams2);
        }
        if (this.fre.getBackImageView() != null) {
            SvgManager.bjq().a(this.fre.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cWI() && this.rootView.getVisibility() == 0;
    }

    private void cWH() {
        if (!cWI()) {
            this.rootView = this.kvN.inflate();
            init();
            if (this.kzr != this.kzs) {
                DU(this.kzs);
            }
        }
    }

    public boolean cWI() {
        return this.rootView != null;
    }

    public void show() {
        cWH();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sH(boolean z) {
        if (z) {
            this.kzw.ciR();
        } else {
            this.kzw.endLoadData();
        }
    }

    public void hide() {
        if (cWI()) {
            this.rootView.setVisibility(8);
            this.fre.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (cWI()) {
            this.fre.setStatusBarVisibility(0);
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
        if (cWI()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (cWI()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.kzt.getContext())[1]);
            this.kzx.setAlpha(0.0f);
            a(kzq, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cWI()) {
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
            this.kzx.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.kzs = i;
        if (cWI()) {
            DU(i);
        }
    }

    private void DU(int i) {
        this.kzr = i;
        this.kzt.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fre.onChangeSkinType(this.kzt.getPageContext(), i);
        ap.setBackgroundResource(this.kzx, R.color.cp_bg_line_k_alpha40);
        this.kzu.onChangeSkinType(this.kzt.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.kzv;
    }

    public NavigationBar bJH() {
        return this.fre;
    }

    public View cWJ() {
        return this.jyn;
    }

    public View cWK() {
        return this.kzx;
    }

    public boolean cWL() {
        if (this.kzv == null || this.kzv.getChildCount() <= 0) {
            return true;
        }
        if (this.kzv.getFirstVisiblePosition() <= 0) {
            View childAt = this.kzv.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cWM() {
        return this.kzw;
    }
}
