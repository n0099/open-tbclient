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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes4.dex */
public class d {
    private static final int hKA = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private NavigationBar cZD;
    private View contentView;
    private ViewStub hHv;
    private final PbActivity hJW;
    private NoNetworkView hKD;
    private PbLandscapeListView hKE;
    private b hKF;
    private View hKG;
    private View rootView;
    private int hKB = 3;
    private int hKC = 3;
    private View gQd = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hJW = pbActivity;
        this.hHv = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hKE = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bqs();
            this.hKG = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hKD = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hKF = new b(this.hJW.getPageContext());
            this.hKE.setNextPage(this.hKF);
        }
    }

    private void bqs() {
        this.cZD = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gQd = this.cZD.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cZD.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gQd.getLayoutParams();
            int g = l.g(this.hJW.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gQd != null && (this.gQd.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gQd.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gQd.setPadding(l.g(this.hJW.getPageContext().getPageActivity(), R.dimen.ds32), this.gQd.getPaddingTop(), this.gQd.getPaddingRight(), this.gQd.getPaddingBottom());
            this.gQd.setLayoutParams(layoutParams2);
        }
        this.cZD.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bTW() && this.rootView.getVisibility() == 0;
    }

    private void bTV() {
        if (!bTW()) {
            this.rootView = this.hHv.inflate();
            init();
            if (this.hKB != this.hKC) {
                xK(this.hKC);
            }
        }
    }

    public boolean bTW() {
        return this.rootView != null;
    }

    public void show() {
        bTV();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(boolean z) {
        if (z) {
            this.hKF.biz();
        } else {
            this.hKF.akG();
        }
    }

    public void hide() {
        if (bTW()) {
            this.rootView.setVisibility(8);
            this.cZD.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (bTW()) {
            this.cZD.setStatusBarVisibility(0);
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
        if (bTW()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (bTW()) {
            this.contentView.setTranslationY(l.aj(this.hJW)[1]);
            this.hKG.setAlpha(0.0f);
            a(hKA, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bTW()) {
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
            this.hKG.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hKC = i;
        if (bTW()) {
            xK(i);
        }
    }

    private void xK(int i) {
        this.hKB = i;
        this.hJW.getLayoutMode().onModeChanged(this.rootView);
        this.cZD.onChangeSkinType(this.hJW.getPageContext(), i);
        am.k(this.hKG, R.color.cp_bg_line_k_alpha40);
        this.hKD.onChangeSkinType(this.hJW.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hKE;
    }

    public NavigationBar aLj() {
        return this.cZD;
    }

    public View bTX() {
        return this.gQd;
    }

    public View bTY() {
        return this.hKG;
    }

    public boolean bTZ() {
        if (this.hKE == null || this.hKE.getChildCount() <= 0) {
            return true;
        }
        if (this.hKE.getFirstVisiblePosition() <= 0) {
            View childAt = this.hKE.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bUa() {
        return this.hKF;
    }
}
