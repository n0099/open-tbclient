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
    private static final int ffc = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bfz;
    private View contentView;
    private ViewStub fch;
    private final PbActivity fey;
    private NoNetworkView fff;
    private PbLandscapeListView ffg;
    private b ffh;
    private View ffi;
    private View rootView;
    private int ffd = 3;
    private int ffe = 3;
    private View eij = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fey = pbActivity;
        this.fch = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.ffg = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            atg();
            this.ffi = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fff = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.ffh = new b(this.fey.getPageContext());
            this.ffg.setNextPage(this.ffh);
        }
    }

    private void atg() {
        this.bfz = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eij = this.bfz.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bfz.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eij.getLayoutParams();
            int e = l.e(this.fey.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eij != null && (this.eij.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eij.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eij.setPadding(l.e(this.fey.getPageContext().getPageActivity(), d.e.ds32), this.eij.getPaddingTop(), this.eij.getPaddingRight(), this.eij.getPaddingBottom());
            this.eij.setLayoutParams(layoutParams2);
        }
        this.bfz.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aWB() && this.rootView.getVisibility() == 0;
    }

    private void aWA() {
        if (!aWB()) {
            this.rootView = this.fch.inflate();
            init();
            if (this.ffd != this.ffe) {
                qb(this.ffe);
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
    public void jv(boolean z) {
        if (z) {
            this.ffh.amK();
        } else {
            this.ffh.wR();
        }
    }

    public void hide() {
        if (aWB()) {
            this.rootView.setVisibility(8);
            this.bfz.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        if (aWB()) {
            this.bfz.setStatusBarVisibility(0);
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
            this.contentView.setTranslationY(l.aj(this.fey)[1]);
            this.ffi.setAlpha(0.0f);
            a(ffc, 1.0f, runnable);
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
            this.ffi.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.ffe = i;
        if (aWB()) {
            qb(i);
        }
    }

    private void qb(int i) {
        this.ffd = i;
        this.fey.getLayoutMode().u(this.rootView);
        this.bfz.onChangeSkinType(this.fey.getPageContext(), i);
        ak.i(this.ffi, d.C0126d.cp_bg_line_k_alpha40);
        this.fff.onChangeSkinType(this.fey.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.ffg;
    }

    public NavigationBar Rd() {
        return this.bfz;
    }

    public View aWC() {
        return this.eij;
    }

    public View aWD() {
        return this.ffi;
    }

    public boolean aWE() {
        if (this.ffg == null || this.ffg.getChildCount() <= 0) {
            return true;
        }
        if (this.ffg.getFirstVisiblePosition() <= 0) {
            View childAt = this.ffg.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aWF() {
        return this.ffh;
    }
}
