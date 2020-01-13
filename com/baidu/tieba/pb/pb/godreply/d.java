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
/* loaded from: classes7.dex */
public class d {
    private static final int iCb = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar dXN;
    private PbFragment iCe;
    private NoNetworkView iCf;
    private PbLandscapeListView iCg;
    private b iCh;
    private View iCi;
    private ViewStub iyN;
    private View rootView;
    private int iCc = 3;
    private int iCd = 3;
    private View hGO = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.iCe = pbFragment;
        this.iyN = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.iCg = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bGF();
            this.iCi = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.iCf = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.iCh = new b(this.iCe.getPageContext());
            this.iCg.setNextPage(this.iCh);
        }
    }

    private void bGF() {
        this.dXN = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.hGO = this.dXN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.dXN.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hGO.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.hGO != null && (this.hGO.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.hGO.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.hGO.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.hGO.getPaddingTop(), this.hGO.getPaddingRight(), this.hGO.getPaddingBottom());
            this.hGO.setLayoutParams(layoutParams2);
        }
        if (this.dXN.getBackImageView() != null) {
            SvgManager.aEp().a(this.dXN.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return ckh() && this.rootView.getVisibility() == 0;
    }

    private void ckg() {
        if (!ckh()) {
            this.rootView = this.iyN.inflate();
            init();
            if (this.iCc != this.iCd) {
                yy(this.iCd);
            }
        }
    }

    public boolean ckh() {
        return this.rootView != null;
    }

    public void show() {
        ckg();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void px(boolean z) {
        if (z) {
            this.iCh.bzy();
        } else {
            this.iCh.endLoadData();
        }
    }

    public void hide() {
        if (ckh()) {
            this.rootView.setVisibility(8);
            this.dXN.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (ckh()) {
            this.dXN.setStatusBarVisibility(0);
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
        if (ckh()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (ckh()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.iCe.getContext())[1]);
            this.iCi.setAlpha(0.0f);
            a(iCb, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (ckh()) {
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
            this.iCi.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.iCd = i;
        if (ckh()) {
            yy(i);
        }
    }

    private void yy(int i) {
        this.iCc = i;
        this.iCe.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.dXN.onChangeSkinType(this.iCe.getPageContext(), i);
        am.setBackgroundResource(this.iCi, R.color.cp_bg_line_k_alpha40);
        this.iCf.onChangeSkinType(this.iCe.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.iCg;
    }

    public NavigationBar bcw() {
        return this.dXN;
    }

    public View cki() {
        return this.hGO;
    }

    public View ckj() {
        return this.iCi;
    }

    public boolean ckk() {
        if (this.iCg == null || this.iCg.getChildCount() <= 0) {
            return true;
        }
        if (this.iCg.getFirstVisiblePosition() <= 0) {
            View childAt = this.iCg.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b ckl() {
        return this.iCh;
    }
}
