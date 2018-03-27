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
    private static final int fKt = l.t(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bVs;
    private View contentView;
    private ViewStub fGy;
    private final PbActivity fJQ;
    private NoNetworkView fKw;
    private PbLandscapeListView fKx;
    private b fKy;
    private View fKz;
    private View rootView;
    private int fKu = 3;
    private int fKv = 3;
    private View eMz = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fJQ = pbActivity;
        this.fGy = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fKx = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            ays();
            this.fKz = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fKw = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fKy = new b(this.fJQ.getPageContext());
            this.fKx.setNextPage(this.fKy);
        }
    }

    private void ays() {
        this.bVs = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eMz = this.bVs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bVs.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eMz.getLayoutParams();
            int t = l.t(this.fJQ.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = t;
            layoutParams.width = t;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eMz != null && (this.eMz.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eMz.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eMz.setPadding(l.t(this.fJQ.getPageContext().getPageActivity(), d.e.ds32), this.eMz.getPaddingTop(), this.eMz.getPaddingRight(), this.eMz.getPaddingBottom());
            this.eMz.setLayoutParams(layoutParams2);
        }
        this.bVs.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bbE() && this.rootView.getVisibility() == 0;
    }

    private void bbD() {
        if (!bbE()) {
            this.rootView = this.fGy.inflate();
            init();
            if (this.fKu != this.fKv) {
                sH(this.fKv);
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
    public void jY(boolean z) {
        if (z) {
            this.fKy.asv();
        } else {
            this.fKy.Eh();
        }
    }

    public void hide() {
        if (bbE()) {
            this.rootView.setVisibility(8);
            this.bVs.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (bbE()) {
            this.bVs.setStatusBarVisibility(0);
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
            this.contentView.setTranslationY(l.as(this.fJQ)[1]);
            this.fKz.setAlpha(0.0f);
            a(fKt, 1.0f, runnable);
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
            this.fKz.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fKv = i;
        if (bbE()) {
            sH(i);
        }
    }

    private void sH(int i) {
        this.fKu = i;
        this.fJQ.getLayoutMode().aM(this.rootView);
        this.bVs.onChangeSkinType(this.fJQ.getPageContext(), i);
        aj.s(this.fKz, d.C0141d.cp_bg_line_k_alpha40);
        this.fKw.onChangeSkinType(this.fJQ.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fKx;
    }

    public NavigationBar avk() {
        return this.bVs;
    }

    public View bbF() {
        return this.eMz;
    }

    public View bbG() {
        return this.fKz;
    }

    public boolean bbH() {
        if (this.fKx == null || this.fKx.getChildCount() <= 0) {
            return true;
        }
        if (this.fKx.getFirstVisiblePosition() <= 0) {
            View childAt = this.fKx.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bbI() {
        return this.fKy;
    }
}
