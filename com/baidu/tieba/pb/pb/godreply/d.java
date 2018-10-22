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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes6.dex */
public class d {
    private static final int fJQ = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds160);
    private NavigationBar bzH;
    private View contentView;
    private ViewStub fGO;
    private NoNetworkView fJT;
    private PbLandscapeListView fJU;
    private b fJV;
    private View fJW;
    private final PbActivity fJm;
    private View rootView;
    private int fJR = 3;
    private int fJS = 3;
    private View eQf = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fJm = pbActivity;
        this.fGO = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fJU = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aEc();
            this.fJW = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fJT = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fJV = new b(this.fJm.getPageContext());
            this.fJU.setNextPage(this.fJV);
        }
    }

    private void aEc() {
        this.bzH = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.eQf = this.bzH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bzH.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQf.getLayoutParams();
            int h = l.h(this.fJm.getPageContext().getPageActivity(), e.C0175e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eQf != null && (this.eQf.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eQf.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eQf.setPadding(l.h(this.fJm.getPageContext().getPageActivity(), e.C0175e.ds32), this.eQf.getPaddingTop(), this.eQf.getPaddingRight(), this.eQf.getPaddingBottom());
            this.eQf.setLayoutParams(layoutParams2);
        }
        this.bzH.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bge() && this.rootView.getVisibility() == 0;
    }

    private void bgd() {
        if (!bge()) {
            this.rootView = this.fGO.inflate();
            init();
            if (this.fJR != this.fJS) {
                rp(this.fJS);
            }
        }
    }

    public boolean bge() {
        return this.rootView != null;
    }

    public void show() {
        bgd();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kp(boolean z) {
        if (z) {
            this.fJV.avW();
        } else {
            this.fJV.DP();
        }
    }

    public void hide() {
        if (bge()) {
            this.rootView.setVisibility(8);
            this.bzH.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bge()) {
            this.bzH.setStatusBarVisibility(0);
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
    public void j(Runnable runnable) {
        if (bge()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bge()) {
            this.contentView.setTranslationY(l.aS(this.fJm)[1]);
            this.fJW.setAlpha(0.0f);
            a(fJQ, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bge()) {
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
            this.fJW.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fJS = i;
        if (bge()) {
            rp(i);
        }
    }

    private void rp(int i) {
        this.fJR = i;
        this.fJm.getLayoutMode().onModeChanged(this.rootView);
        this.bzH.onChangeSkinType(this.fJm.getPageContext(), i);
        al.i(this.fJW, e.d.cp_bg_line_k_alpha40);
        this.fJT.onChangeSkinType(this.fJm.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fJU;
    }

    public NavigationBar aaE() {
        return this.bzH;
    }

    public View bgf() {
        return this.eQf;
    }

    public View bgg() {
        return this.fJW;
    }

    public boolean bgh() {
        if (this.fJU == null || this.fJU.getChildCount() <= 0) {
            return true;
        }
        if (this.fJU.getFirstVisiblePosition() <= 0) {
            View childAt = this.fJU.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bgi() {
        return this.fJV;
    }
}
