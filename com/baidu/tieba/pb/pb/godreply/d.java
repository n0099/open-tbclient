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
    private static final int lpF = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fUP;
    private ViewStub llZ;
    private PbFragment lpI;
    private NoNetworkView lpJ;
    private PbLandscapeListView lpK;
    private b lpL;
    private View lpM;
    private View rootView;
    private int lpG = 3;
    private int lpH = 3;
    private View kop = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lpI = pbFragment;
        this.llZ = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lpK = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cDh();
            this.lpM = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lpJ = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lpL = new b(this.lpI.getPageContext());
            this.lpK.setNextPage(this.lpL);
        }
    }

    private void cDh() {
        this.fUP = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kop = this.fUP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fUP.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kop.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kop != null && (this.kop.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kop.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kop.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kop.getPaddingTop(), this.kop.getPaddingRight(), this.kop.getPaddingBottom());
            this.kop.setLayoutParams(layoutParams2);
        }
        if (this.fUP.getBackImageView() != null) {
            SvgManager.brn().a(this.fUP.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return djE() && this.rootView.getVisibility() == 0;
    }

    private void djD() {
        if (!djE()) {
            this.rootView = this.llZ.inflate();
            init();
            if (this.lpG != this.lpH) {
                FH(this.lpH);
            }
        }
    }

    public boolean djE() {
        return this.rootView != null;
    }

    public void show() {
        djD();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tX(boolean z) {
        if (z) {
            this.lpL.cvl();
        } else {
            this.lpL.endLoadData();
        }
    }

    public void hide() {
        if (djE()) {
            this.rootView.setVisibility(8);
            this.fUP.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void u(final Runnable runnable) {
        if (djE()) {
            this.fUP.setStatusBarVisibility(0);
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
        if (djE()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(Runnable runnable) {
        if (djE()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lpI.getContext())[1]);
            this.lpM.setAlpha(0.0f);
            a(lpF, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (djE()) {
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
            this.lpM.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lpH = i;
        if (djE()) {
            FH(i);
        }
    }

    private void FH(int i) {
        this.lpG = i;
        this.lpI.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fUP.onChangeSkinType(this.lpI.getPageContext(), i);
        ap.setBackgroundResource(this.lpM, R.color.cp_bg_line_k_alpha40);
        this.lpJ.onChangeSkinType(this.lpI.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lpK;
    }

    public NavigationBar bSH() {
        return this.fUP;
    }

    public View djF() {
        return this.kop;
    }

    public View djG() {
        return this.lpM;
    }

    public boolean djH() {
        if (this.lpK == null || this.lpK.getChildCount() <= 0) {
            return true;
        }
        if (this.lpK.getFirstVisiblePosition() <= 0) {
            View childAt = this.lpK.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b djI() {
        return this.lpL;
    }
}
