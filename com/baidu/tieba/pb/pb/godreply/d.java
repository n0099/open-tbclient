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
    private static final int hKk = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar djV;
    private ViewStub hHf;
    private final PbActivity hJF;
    private NoNetworkView hKn;
    private PbLandscapeListView hKo;
    private b hKp;
    private View hKq;
    private View rootView;
    private int hKl = 3;
    private int hKm = 3;
    private View gPh = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hJF = pbActivity;
        this.hHf = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hKo = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bog();
            this.hKq = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hKn = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hKp = new b(this.hJF.getPageContext());
            this.hKo.setNextPage(this.hKp);
        }
    }

    private void bog() {
        this.djV = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gPh = this.djV.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.djV.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gPh.getLayoutParams();
            int dimens = l.getDimens(this.hJF.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gPh != null && (this.gPh.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gPh.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gPh.setPadding(l.getDimens(this.hJF.getPageContext().getPageActivity(), R.dimen.ds32), this.gPh.getPaddingTop(), this.gPh.getPaddingRight(), this.gPh.getPaddingBottom());
            this.gPh.setLayoutParams(layoutParams2);
        }
        if (this.djV.getBackImageView() != null) {
            SvgManager.amL().a(this.djV.getBackImageView(), R.drawable.icon_pure_topbar_close_n_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return bRI() && this.rootView.getVisibility() == 0;
    }

    private void bRH() {
        if (!bRI()) {
            this.rootView = this.hHf.inflate();
            init();
            if (this.hKl != this.hKm) {
                wr(this.hKm);
            }
        }
    }

    public boolean bRI() {
        return this.rootView != null;
    }

    public void show() {
        bRH();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nX(boolean z) {
        if (z) {
            this.hKp.bhb();
        } else {
            this.hKp.endLoadData();
        }
    }

    public void hide() {
        if (bRI()) {
            this.rootView.setVisibility(8);
            this.djV.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(final Runnable runnable) {
        if (bRI()) {
            this.djV.setStatusBarVisibility(0);
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
        if (bRI()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Runnable runnable) {
        if (bRI()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.hJF)[1]);
            this.hKq.setAlpha(0.0f);
            a(hKk, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bRI()) {
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
            this.hKq.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hKm = i;
        if (bRI()) {
            wr(i);
        }
    }

    private void wr(int i) {
        this.hKl = i;
        this.hJF.getLayoutMode().onModeChanged(this.rootView);
        this.djV.onChangeSkinType(this.hJF.getPageContext(), i);
        am.setBackgroundResource(this.hKq, R.color.cp_bg_line_k_alpha40);
        this.hKn.onChangeSkinType(this.hJF.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hKo;
    }

    public NavigationBar aKP() {
        return this.djV;
    }

    public View bRJ() {
        return this.gPh;
    }

    public View bRK() {
        return this.hKq;
    }

    public boolean bRL() {
        if (this.hKo == null || this.hKo.getChildCount() <= 0) {
            return true;
        }
        if (this.hKo.getFirstVisiblePosition() <= 0) {
            View childAt = this.hKo.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bRM() {
        return this.hKp;
    }
}
