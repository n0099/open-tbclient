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
/* loaded from: classes.dex */
public class d {
    private static final int eRn = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bfW;
    private View contentView;
    private ViewStub eNr;
    private final PbActivity eQK;
    private NoNetworkView eRq;
    private PbLandscapeListView eRr;
    private b eRs;
    private View eRt;
    private View rootView;
    private int eRo = 3;
    private int eRp = 3;
    private View dSU = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.eQK = pbActivity;
        this.eNr = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.eRr = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            apc();
            this.eRt = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.eRq = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.eRs = new b(this.eQK.getPageContext());
            this.eRr.setNextPage(this.eRs);
        }
    }

    private void apc() {
        this.bfW = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.dSU = this.bfW.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bfW.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dSU.getLayoutParams();
            int f = l.f(this.eQK.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.dSU != null && (this.dSU.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dSU.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.dSU.setPadding(l.f(this.eQK.getPageContext().getPageActivity(), d.e.ds32), this.dSU.getPaddingTop(), this.dSU.getPaddingRight(), this.dSU.getPaddingBottom());
            this.dSU.setLayoutParams(layoutParams2);
        }
        this.bfW.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aSt() && this.rootView.getVisibility() == 0;
    }

    private void aSs() {
        if (!aSt()) {
            this.rootView = this.eNr.inflate();
            init();
            if (this.eRo != this.eRp) {
                pJ(this.eRp);
            }
        }
    }

    public boolean aSt() {
        return this.rootView != null;
    }

    public void show() {
        aSs();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jb(boolean z) {
        if (z) {
            this.eRs.aiQ();
        } else {
            this.eRs.wy();
        }
    }

    public void hide() {
        if (aSt()) {
            this.rootView.setVisibility(8);
            this.bfW.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aSt()) {
            this.bfW.setStatusBarVisibility(0);
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
        if (aSt()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aSt()) {
            this.contentView.setTranslationY(l.ag(this.eQK)[1]);
            this.eRt.setAlpha(0.0f);
            a(eRn, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aSt()) {
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
            this.eRt.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.eRp = i;
        if (aSt()) {
            pJ(i);
        }
    }

    private void pJ(int i) {
        this.eRo = i;
        this.eQK.getLayoutMode().t(this.rootView);
        this.bfW.onChangeSkinType(this.eQK.getPageContext(), i);
        aj.j(this.eRt, d.C0082d.cp_bg_line_k_alpha40);
        this.eRq.onChangeSkinType(this.eQK.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.eRr;
    }

    public NavigationBar alu() {
        return this.bfW;
    }

    public View aSu() {
        return this.dSU;
    }

    public View aSv() {
        return this.eRt;
    }

    public boolean aSw() {
        if (this.eRr == null || this.eRr.getChildCount() <= 0) {
            return true;
        }
        if (this.eRr.getFirstVisiblePosition() <= 0) {
            View childAt = this.eRr.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aSx() {
        return this.eRs;
    }
}
