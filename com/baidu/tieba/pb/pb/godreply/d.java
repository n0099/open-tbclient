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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes2.dex */
public class d {
    private static final int fKd = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bVp;
    private View contentView;
    private ViewStub fGi;
    private final PbActivity fJA;
    private NoNetworkView fKg;
    private PbLandscapeListView fKh;
    private b fKi;
    private View fKj;
    private View rootView;
    private int fKe = 3;
    private int fKf = 3;
    private View eMj = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fJA = pbActivity;
        this.fGi = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fKh = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            ayq();
            this.fKj = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fKg = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fKi = new b(this.fJA.getPageContext());
            this.fKh.setNextPage(this.fKi);
        }
    }

    private void ayq() {
        this.bVp = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eMj = this.bVp.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bVp.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMj.getLayoutParams();
            int t = l.t(this.fJA.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = t;
            layoutParams.width = t;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eMj != null && (this.eMj.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMj.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eMj.setPadding(l.t(this.fJA.getPageContext().getPageActivity(), d.e.ds32), this.eMj.getPaddingTop(), this.eMj.getPaddingRight(), this.eMj.getPaddingBottom());
            this.eMj.setLayoutParams(layoutParams2);
        }
        this.bVp.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bbD() && this.rootView.getVisibility() == 0;
    }

    private void bbC() {
        if (!bbD()) {
            this.rootView = this.fGi.inflate();
            init();
            if (this.fKe != this.fKf) {
                sH(this.fKf);
            }
        }
    }

    public boolean bbD() {
        return this.rootView != null;
    }

    public void show() {
        bbC();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jT(boolean z) {
        if (z) {
            this.fKi.asu();
        } else {
            this.fKi.Eg();
        }
    }

    public void hide() {
        if (bbD()) {
            this.rootView.setVisibility(8);
            this.bVp.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (bbD()) {
            this.bVp.setStatusBarVisibility(0);
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
    public void l(Runnable runnable) {
        if (bbD()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (bbD()) {
            this.contentView.setTranslationY(l.as(this.fJA)[1]);
            this.fKj.setAlpha(0.0f);
            a(fKd, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bbD()) {
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
            this.fKj.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fKf = i;
        if (bbD()) {
            sH(i);
        }
    }

    private void sH(int i) {
        this.fKe = i;
        this.fJA.getLayoutMode().aM(this.rootView);
        this.bVp.onChangeSkinType(this.fJA.getPageContext(), i);
        aj.s(this.fKj, d.C0141d.cp_bg_line_k_alpha40);
        this.fKg.onChangeSkinType(this.fJA.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fKh;
    }

    public NavigationBar avj() {
        return this.bVp;
    }

    public View bbE() {
        return this.eMj;
    }

    public View bbF() {
        return this.fKj;
    }

    public boolean bbG() {
        if (this.fKh == null || this.fKh.getChildCount() <= 0) {
            return true;
        }
        if (this.fKh.getFirstVisiblePosition() <= 0) {
            View childAt = this.fKh.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bbH() {
        return this.fKi;
    }
}
