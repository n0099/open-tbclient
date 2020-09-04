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
    private static final int kzx = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fri;
    private ViewStub kvU;
    private PbFragment kzA;
    private NoNetworkView kzB;
    private PbLandscapeListView kzC;
    private b kzD;
    private View kzE;
    private View rootView;
    private int kzy = 3;
    private int kzz = 3;
    private View jyt = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.kzA = pbFragment;
        this.kvU = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.kzC = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cqP();
            this.kzE = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.kzB = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.kzD = new b(this.kzA.getPageContext());
            this.kzC.setNextPage(this.kzD);
        }
    }

    private void cqP() {
        this.fri = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.jyt = this.fri.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fri.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jyt.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.jyt != null && (this.jyt.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jyt.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.jyt.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.jyt.getPaddingTop(), this.jyt.getPaddingRight(), this.jyt.getPaddingBottom());
            this.jyt.setLayoutParams(layoutParams2);
        }
        if (this.fri.getBackImageView() != null) {
            SvgManager.bjq().a(this.fri.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cWJ() && this.rootView.getVisibility() == 0;
    }

    private void cWI() {
        if (!cWJ()) {
            this.rootView = this.kvU.inflate();
            init();
            if (this.kzy != this.kzz) {
                DU(this.kzz);
            }
        }
    }

    public boolean cWJ() {
        return this.rootView != null;
    }

    public void show() {
        cWI();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sJ(boolean z) {
        if (z) {
            this.kzD.ciS();
        } else {
            this.kzD.endLoadData();
        }
    }

    public void hide() {
        if (cWJ()) {
            this.rootView.setVisibility(8);
            this.fri.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (cWJ()) {
            this.fri.setStatusBarVisibility(0);
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
        if (cWJ()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (cWJ()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.kzA.getContext())[1]);
            this.kzE.setAlpha(0.0f);
            a(kzx, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cWJ()) {
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
            this.kzE.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.kzz = i;
        if (cWJ()) {
            DU(i);
        }
    }

    private void DU(int i) {
        this.kzy = i;
        this.kzA.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fri.onChangeSkinType(this.kzA.getPageContext(), i);
        ap.setBackgroundResource(this.kzE, R.color.cp_bg_line_k_alpha40);
        this.kzB.onChangeSkinType(this.kzA.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.kzC;
    }

    public NavigationBar bJI() {
        return this.fri;
    }

    public View cWK() {
        return this.jyt;
    }

    public View cWL() {
        return this.kzE;
    }

    public boolean cWM() {
        if (this.kzC == null || this.kzC.getChildCount() <= 0) {
            return true;
        }
        if (this.kzC.getFirstVisiblePosition() <= 0) {
            View childAt = this.kzC.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cWN() {
        return this.kzD;
    }
}
