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
    private static final int fKo = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bVB;
    private View contentView;
    private ViewStub fGt;
    private final PbActivity fJL;
    private NoNetworkView fKr;
    private PbLandscapeListView fKs;
    private b fKt;
    private View fKu;
    private View rootView;
    private int fKp = 3;
    private int fKq = 3;
    private View eMv = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fJL = pbActivity;
        this.fGt = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fKs = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            ayr();
            this.fKu = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fKr = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fKt = new b(this.fJL.getPageContext());
            this.fKs.setNextPage(this.fKt);
        }
    }

    private void ayr() {
        this.bVB = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eMv = this.bVB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bVB.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMv.getLayoutParams();
            int t = l.t(this.fJL.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = t;
            layoutParams.width = t;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eMv != null && (this.eMv.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMv.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eMv.setPadding(l.t(this.fJL.getPageContext().getPageActivity(), d.e.ds32), this.eMv.getPaddingTop(), this.eMv.getPaddingRight(), this.eMv.getPaddingBottom());
            this.eMv.setLayoutParams(layoutParams2);
        }
        this.bVB.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bbE() && this.rootView.getVisibility() == 0;
    }

    private void bbD() {
        if (!bbE()) {
            this.rootView = this.fGt.inflate();
            init();
            if (this.fKp != this.fKq) {
                sG(this.fKq);
            }
        }
    }

    public boolean bbE() {
        return this.rootView != null;
    }

    public void show() {
        bbD();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jT(boolean z) {
        if (z) {
            this.fKt.asv();
        } else {
            this.fKt.Eh();
        }
    }

    public void hide() {
        if (bbE()) {
            this.rootView.setVisibility(8);
            this.bVB.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (bbE()) {
            this.bVB.setStatusBarVisibility(0);
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
        if (bbE()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (bbE()) {
            this.contentView.setTranslationY(l.as(this.fJL)[1]);
            this.fKu.setAlpha(0.0f);
            a(fKo, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bbE()) {
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
            this.fKu.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fKq = i;
        if (bbE()) {
            sG(i);
        }
    }

    private void sG(int i) {
        this.fKp = i;
        this.fJL.getLayoutMode().aM(this.rootView);
        this.bVB.onChangeSkinType(this.fJL.getPageContext(), i);
        aj.s(this.fKu, d.C0140d.cp_bg_line_k_alpha40);
        this.fKr.onChangeSkinType(this.fJL.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fKs;
    }

    public NavigationBar avk() {
        return this.bVB;
    }

    public View bbF() {
        return this.eMv;
    }

    public View bbG() {
        return this.fKu;
    }

    public boolean bbH() {
        if (this.fKs == null || this.fKs.getChildCount() <= 0) {
            return true;
        }
        if (this.fKs.getFirstVisiblePosition() <= 0) {
            View childAt = this.fKs.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bbI() {
        return this.fKt;
    }
}
