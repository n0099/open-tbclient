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
    private static final int lDD = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar gcG;
    private PbFragment lDG;
    private NoNetworkView lDH;
    private PbLandscapeListView lDI;
    private b lDJ;
    private View lDK;
    private ViewStub lzP;
    private View rootView;
    private int lDE = 3;
    private int lDF = 3;
    private View kCv = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lDG = pbFragment;
        this.lzP = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lDI = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cHW();
            this.lDK = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lDH = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lDJ = new b(this.lDG.getPageContext());
            this.lDI.setNextPage(this.lDJ);
        }
    }

    private void cHW() {
        this.gcG = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kCv = this.gcG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.gcG.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kCv.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kCv != null && (this.kCv.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kCv.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kCv.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kCv.getPaddingTop(), this.kCv.getPaddingRight(), this.kCv.getPaddingBottom());
            this.kCv.setLayoutParams(layoutParams2);
        }
        if (this.gcG.getBackImageView() != null) {
            SvgManager.btW().a(this.gcG.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dop() && this.rootView.getVisibility() == 0;
    }

    private void doo() {
        if (!dop()) {
            this.rootView = this.lzP.inflate();
            init();
            if (this.lDE != this.lDF) {
                GU(this.lDF);
            }
        }
    }

    public boolean dop() {
        return this.rootView != null;
    }

    public void show() {
        doo();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uC(boolean z) {
        if (z) {
            this.lDJ.czd();
        } else {
            this.lDJ.endLoadData();
        }
    }

    public void hide() {
        if (dop()) {
            this.rootView.setVisibility(8);
            this.gcG.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (dop()) {
            this.gcG.setStatusBarVisibility(0);
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
        if (dop()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (dop()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lDG.getContext())[1]);
            this.lDK.setAlpha(0.0f);
            a(lDD, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dop()) {
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
            this.lDK.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lDF = i;
        if (dop()) {
            GU(i);
        }
    }

    private void GU(int i) {
        this.lDE = i;
        this.lDG.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.gcG.onChangeSkinType(this.lDG.getPageContext(), i);
        ap.setBackgroundResource(this.lDK, R.color.cp_bg_line_k_alpha40);
        this.lDH.onChangeSkinType(this.lDG.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lDI;
    }

    public NavigationBar bVK() {
        return this.gcG;
    }

    public View doq() {
        return this.kCv;
    }

    public View dor() {
        return this.lDK;
    }

    public boolean dos() {
        if (this.lDI == null || this.lDI.getChildCount() <= 0) {
            return true;
        }
        if (this.lDI.getFirstVisiblePosition() <= 0) {
            View childAt = this.lDI.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dot() {
        return this.lDJ;
    }
}
