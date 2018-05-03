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
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes2.dex */
public class d {
    private static final int fdV = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bfy;
    private View contentView;
    private ViewStub fba;
    private NoNetworkView fdY;
    private PbLandscapeListView fdZ;
    private final PbActivity fdr;
    private b fea;
    private View feb;
    private View rootView;
    private int fdW = 3;
    private int fdX = 3;
    private View ehc = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fdr = pbActivity;
        this.fba = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fdZ = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            ath();
            this.feb = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fdY = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fea = new b(this.fdr.getPageContext());
            this.fdZ.setNextPage(this.fea);
        }
    }

    private void ath() {
        this.bfy = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.ehc = this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bfy.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehc.getLayoutParams();
            int e = l.e(this.fdr.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.ehc != null && (this.ehc.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ehc.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.ehc.setPadding(l.e(this.fdr.getPageContext().getPageActivity(), d.e.ds32), this.ehc.getPaddingTop(), this.ehc.getPaddingRight(), this.ehc.getPaddingBottom());
            this.ehc.setLayoutParams(layoutParams2);
        }
        this.bfy.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aWB() && this.rootView.getVisibility() == 0;
    }

    private void aWA() {
        if (!aWB()) {
            this.rootView = this.fba.inflate();
            init();
            if (this.fdW != this.fdX) {
                qc(this.fdX);
            }
        }
    }

    public boolean aWB() {
        return this.rootView != null;
    }

    public void show() {
        aWA();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ju(boolean z) {
        if (z) {
            this.fea.amL();
        } else {
            this.fea.wS();
        }
    }

    public void hide() {
        if (aWB()) {
            this.rootView.setVisibility(8);
            this.bfy.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        if (aWB()) {
            this.bfy.setStatusBarVisibility(0);
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
    public void k(Runnable runnable) {
        if (aWB()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Runnable runnable) {
        if (aWB()) {
            this.contentView.setTranslationY(l.aj(this.fdr)[1]);
            this.feb.setAlpha(0.0f);
            a(fdV, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aWB()) {
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
            this.feb.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fdX = i;
        if (aWB()) {
            qc(i);
        }
    }

    private void qc(int i) {
        this.fdW = i;
        this.fdr.getLayoutMode().u(this.rootView);
        this.bfy.onChangeSkinType(this.fdr.getPageContext(), i);
        ak.i(this.feb, d.C0126d.cp_bg_line_k_alpha40);
        this.fdY.onChangeSkinType(this.fdr.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fdZ;
    }

    public NavigationBar Rg() {
        return this.bfy;
    }

    public View aWC() {
        return this.ehc;
    }

    public View aWD() {
        return this.feb;
    }

    public boolean aWE() {
        if (this.fdZ == null || this.fdZ.getChildCount() <= 0) {
            return true;
        }
        if (this.fdZ.getFirstVisiblePosition() <= 0) {
            View childAt = this.fdZ.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aWF() {
        return this.fea;
    }
}
