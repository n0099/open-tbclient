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
    private static final int lDF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar gcI;
    private PbFragment lDI;
    private NoNetworkView lDJ;
    private PbLandscapeListView lDK;
    private b lDL;
    private View lDM;
    private ViewStub lzR;
    private View rootView;
    private int lDG = 3;
    private int lDH = 3;
    private View kCx = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lDI = pbFragment;
        this.lzR = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lDK = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cHX();
            this.lDM = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lDJ = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lDL = new b(this.lDI.getPageContext());
            this.lDK.setNextPage(this.lDL);
        }
    }

    private void cHX() {
        this.gcI = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kCx = this.gcI.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.gcI.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kCx.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kCx != null && (this.kCx.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kCx.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kCx.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kCx.getPaddingTop(), this.kCx.getPaddingRight(), this.kCx.getPaddingBottom());
            this.kCx.setLayoutParams(layoutParams2);
        }
        if (this.gcI.getBackImageView() != null) {
            SvgManager.btW().a(this.gcI.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return doq() && this.rootView.getVisibility() == 0;
    }

    private void dop() {
        if (!doq()) {
            this.rootView = this.lzR.inflate();
            init();
            if (this.lDG != this.lDH) {
                GU(this.lDH);
            }
        }
    }

    public boolean doq() {
        return this.rootView != null;
    }

    public void show() {
        dop();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uC(boolean z) {
        if (z) {
            this.lDL.cze();
        } else {
            this.lDL.endLoadData();
        }
    }

    public void hide() {
        if (doq()) {
            this.rootView.setVisibility(8);
            this.gcI.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (doq()) {
            this.gcI.setStatusBarVisibility(0);
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
        if (doq()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (doq()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lDI.getContext())[1]);
            this.lDM.setAlpha(0.0f);
            a(lDF, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (doq()) {
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
            this.lDM.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lDH = i;
        if (doq()) {
            GU(i);
        }
    }

    private void GU(int i) {
        this.lDG = i;
        this.lDI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.gcI.onChangeSkinType(this.lDI.getPageContext(), i);
        ap.setBackgroundResource(this.lDM, R.color.cp_bg_line_k_alpha40);
        this.lDJ.onChangeSkinType(this.lDI.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lDK;
    }

    public NavigationBar bVL() {
        return this.gcI;
    }

    public View dor() {
        return this.kCx;
    }

    public View dos() {
        return this.lDM;
    }

    public boolean dot() {
        if (this.lDK == null || this.lDK.getChildCount() <= 0) {
            return true;
        }
        if (this.lDK.getFirstVisiblePosition() <= 0) {
            View childAt = this.lDK.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dou() {
        return this.lDL;
    }
}
