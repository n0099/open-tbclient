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
    private static final int hJH = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private NavigationBar cZw;
    private View contentView;
    private ViewStub hGD;
    private NoNetworkView hJK;
    private PbLandscapeListView hJL;
    private b hJM;
    private View hJN;
    private final PbActivity hJd;
    private View rootView;
    private int hJI = 3;
    private int hJJ = 3;
    private View gPl = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hJd = pbActivity;
        this.hGD = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hJL = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bqf();
            this.hJN = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hJK = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hJM = new b(this.hJd.getPageContext());
            this.hJL.setNextPage(this.hJM);
        }
    }

    private void bqf() {
        this.cZw = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gPl = this.cZw.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cZw.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gPl.getLayoutParams();
            int g = l.g(this.hJd.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gPl != null && (this.gPl.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gPl.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gPl.setPadding(l.g(this.hJd.getPageContext().getPageActivity(), R.dimen.ds32), this.gPl.getPaddingTop(), this.gPl.getPaddingRight(), this.gPl.getPaddingBottom());
            this.gPl.setLayoutParams(layoutParams2);
        }
        this.cZw.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bTI() && this.rootView.getVisibility() == 0;
    }

    private void bTH() {
        if (!bTI()) {
            this.rootView = this.hGD.inflate();
            init();
            if (this.hJI != this.hJJ) {
                xI(this.hJJ);
            }
        }
    }

    public boolean bTI() {
        return this.rootView != null;
    }

    public void show() {
        bTH();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(boolean z) {
        if (z) {
            this.hJM.bis();
        } else {
            this.hJM.akE();
        }
    }

    public void hide() {
        if (bTI()) {
            this.rootView.setVisibility(8);
            this.cZw.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (bTI()) {
            this.cZw.setStatusBarVisibility(0);
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
        if (bTI()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (bTI()) {
            this.contentView.setTranslationY(l.aj(this.hJd)[1]);
            this.hJN.setAlpha(0.0f);
            a(hJH, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bTI()) {
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
            this.hJN.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hJJ = i;
        if (bTI()) {
            xI(i);
        }
    }

    private void xI(int i) {
        this.hJI = i;
        this.hJd.getLayoutMode().onModeChanged(this.rootView);
        this.cZw.onChangeSkinType(this.hJd.getPageContext(), i);
        am.k(this.hJN, R.color.cp_bg_line_k_alpha40);
        this.hJK.onChangeSkinType(this.hJd.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hJL;
    }

    public NavigationBar aLh() {
        return this.cZw;
    }

    public View bTJ() {
        return this.gPl;
    }

    public View bTK() {
        return this.hJN;
    }

    public boolean bTL() {
        if (this.hJL == null || this.hJL.getChildCount() <= 0) {
            return true;
        }
        if (this.hJL.getFirstVisiblePosition() <= 0) {
            View childAt = this.hJL.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bTM() {
        return this.hJM;
    }
}
