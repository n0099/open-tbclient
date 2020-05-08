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
    private static final int jpT = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar eCn;
    private ViewStub jmG;
    private PbFragment jpW;
    private NoNetworkView jpX;
    private PbLandscapeListView jpY;
    private b jpZ;
    private View jqa;
    private View rootView;
    private int jpU = 3;
    private int jpV = 3;
    private View iux = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.jpW = pbFragment;
        this.jmG = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.jpY = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bST();
            this.jqa = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.jpX = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.jpZ = new b(this.jpW.getPageContext());
            this.jpY.setNextPage(this.jpZ);
        }
    }

    private void bST() {
        this.eCn = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.iux = this.eCn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.eCn.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iux.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.iux != null && (this.iux.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.iux.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.iux.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.iux.getPaddingTop(), this.iux.getPaddingRight(), this.iux.getPaddingBottom());
            this.iux.setLayoutParams(layoutParams2);
        }
        if (this.eCn.getBackImageView() != null) {
            SvgManager.aOR().a(this.eCn.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cwF() && this.rootView.getVisibility() == 0;
    }

    private void cwE() {
        if (!cwF()) {
            this.rootView = this.jmG.inflate();
            init();
            if (this.jpU != this.jpV) {
                zo(this.jpV);
            }
        }
    }

    public boolean cwF() {
        return this.rootView != null;
    }

    public void show() {
        cwE();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void qK(boolean z) {
        if (z) {
            this.jpZ.bLH();
        } else {
            this.jpZ.endLoadData();
        }
    }

    public void hide() {
        if (cwF()) {
            this.rootView.setVisibility(8);
            this.eCn.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(final Runnable runnable) {
        if (cwF()) {
            this.eCn.setStatusBarVisibility(0);
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
        if (cwF()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(Runnable runnable) {
        if (cwF()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.jpW.getContext())[1]);
            this.jqa.setAlpha(0.0f);
            a(jpT, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cwF()) {
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
            this.jqa.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.jpV = i;
        if (cwF()) {
            zo(i);
        }
    }

    private void zo(int i) {
        this.jpU = i;
        this.jpW.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.eCn.onChangeSkinType(this.jpW.getPageContext(), i);
        am.setBackgroundResource(this.jqa, R.color.cp_bg_line_k_alpha40);
        this.jpX.onChangeSkinType(this.jpW.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.jpY;
    }

    public NavigationBar bof() {
        return this.eCn;
    }

    public View cwG() {
        return this.iux;
    }

    public View cwH() {
        return this.jqa;
    }

    public boolean cwI() {
        if (this.jpY == null || this.jpY.getChildCount() <= 0) {
            return true;
        }
        if (this.jpY.getFirstVisiblePosition() <= 0) {
            View childAt = this.jpY.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cwJ() {
        return this.jpZ;
    }
}
