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
/* loaded from: classes2.dex */
public class d {
    private static final int lNj = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar gjT;
    private ViewStub lJs;
    private PbFragment lNm;
    private NoNetworkView lNn;
    private PbLandscapeListView lNo;
    private b lNp;
    private View lNq;
    private View rootView;
    private int lNk = 3;
    private int lNl = 3;
    private View kLH = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lNm = pbFragment;
        this.lJs = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lNo = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cIA();
            this.lNq = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lNn = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lNp = new b(this.lNm.getPageContext());
            this.lNo.setNextPage(this.lNp);
        }
    }

    private void cIA() {
        this.gjT = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kLH = this.gjT.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.gjT.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kLH.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kLH != null && (this.kLH.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kLH.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kLH.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kLH.getPaddingTop(), this.kLH.getPaddingRight(), this.kLH.getPaddingBottom());
            this.kLH.setLayoutParams(layoutParams2);
        }
        if (this.gjT.getBackImageView() != null) {
            SvgManager.bsR().a(this.gjT.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dmC() && this.rootView.getVisibility() == 0;
    }

    private void dmB() {
        if (!dmC()) {
            this.rootView = this.lJs.inflate();
            init();
            if (this.lNk != this.lNl) {
                Fz(this.lNl);
            }
        }
    }

    public boolean dmC() {
        return this.rootView != null;
    }

    public void show() {
        dmB();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uN(boolean z) {
        if (z) {
            this.lNp.czy();
        } else {
            this.lNp.endLoadData();
        }
    }

    public void hide() {
        if (dmC()) {
            this.rootView.setVisibility(8);
            this.gjT.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (dmC()) {
            this.gjT.setStatusBarVisibility(0);
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
        if (dmC()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (dmC()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lNm.getContext())[1]);
            this.lNq.setAlpha(0.0f);
            a(lNj, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dmC()) {
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
            this.lNq.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lNl = i;
        if (dmC()) {
            Fz(i);
        }
    }

    private void Fz(int i) {
        this.lNk = i;
        this.lNm.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.gjT.onChangeSkinType(this.lNm.getPageContext(), i);
        ap.setBackgroundResource(this.lNq, R.color.cp_bg_line_k_alpha40);
        this.lNn.onChangeSkinType(this.lNm.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lNo;
    }

    public NavigationBar bVk() {
        return this.gjT;
    }

    public View dmD() {
        return this.kLH;
    }

    public View dmE() {
        return this.lNq;
    }

    public boolean dmF() {
        if (this.lNo == null || this.lNo.getChildCount() <= 0) {
            return true;
        }
        if (this.lNo.getFirstVisiblePosition() <= 0) {
            View childAt = this.lNo.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dmG() {
        return this.lNp;
    }
}
