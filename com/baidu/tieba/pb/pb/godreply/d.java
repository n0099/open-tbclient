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
    private static final int kXf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fGE;
    private ViewStub kTE;
    private PbFragment kXi;
    private NoNetworkView kXj;
    private PbLandscapeListView kXk;
    private b kXl;
    private View kXm;
    private View rootView;
    private int kXg = 3;
    private int kXh = 3;
    private View jVS = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.kXi = pbFragment;
        this.kTE = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.kXk = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cxz();
            this.kXm = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.kXj = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.kXl = new b(this.kXi.getPageContext());
            this.kXk.setNextPage(this.kXl);
        }
    }

    private void cxz() {
        this.fGE = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.jVS = this.fGE.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fGE.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jVS.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.jVS != null && (this.jVS.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jVS.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.jVS.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.jVS.getPaddingTop(), this.jVS.getPaddingRight(), this.jVS.getPaddingBottom());
            this.jVS.setLayoutParams(layoutParams2);
        }
        if (this.fGE.getBackImageView() != null) {
            SvgManager.bmU().a(this.fGE.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return ddV() && this.rootView.getVisibility() == 0;
    }

    private void ddU() {
        if (!ddV()) {
            this.rootView = this.kTE.inflate();
            init();
            if (this.kXg != this.kXh) {
                Fb(this.kXh);
            }
        }
    }

    public boolean ddV() {
        return this.rootView != null;
    }

    public void show() {
        ddU();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tx(boolean z) {
        if (z) {
            this.kXl.cpD();
        } else {
            this.kXl.endLoadData();
        }
    }

    public void hide() {
        if (ddV()) {
            this.rootView.setVisibility(8);
            this.fGE.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (ddV()) {
            this.fGE.setStatusBarVisibility(0);
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
        if (ddV()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (ddV()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.kXi.getContext())[1]);
            this.kXm.setAlpha(0.0f);
            a(kXf, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (ddV()) {
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
            this.kXm.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.kXh = i;
        if (ddV()) {
            Fb(i);
        }
    }

    private void Fb(int i) {
        this.kXg = i;
        this.kXi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fGE.onChangeSkinType(this.kXi.getPageContext(), i);
        ap.setBackgroundResource(this.kXm, R.color.cp_bg_line_k_alpha40);
        this.kXj.onChangeSkinType(this.kXi.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.kXk;
    }

    public NavigationBar bNC() {
        return this.fGE;
    }

    public View ddW() {
        return this.jVS;
    }

    public View ddX() {
        return this.kXm;
    }

    public boolean ddY() {
        if (this.kXk == null || this.kXk.getChildCount() <= 0) {
            return true;
        }
        if (this.kXk.getFirstVisiblePosition() <= 0) {
            View childAt = this.kXk.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b ddZ() {
        return this.kXl;
    }
}
