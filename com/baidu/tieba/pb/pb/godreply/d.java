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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes4.dex */
public class d {
    private static final int hmh = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar cPN;
    private View contentView;
    private ViewStub hjg;
    private final PbActivity hlD;
    private NoNetworkView hmk;
    private PbLandscapeListView hml;
    private b hmm;
    private View hmn;
    private View rootView;
    private int hmi = 3;
    private int hmj = 3;
    private View grY = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hlD = pbActivity;
        this.hjg = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hml = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            bgN();
            this.hmn = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.hmk = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.hmm = new b(this.hlD.getPageContext());
            this.hml.setNextPage(this.hmm);
        }
    }

    private void bgN() {
        this.cPN = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.grY = this.cPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cPN.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grY.getLayoutParams();
            int h = l.h(this.hlD.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.grY != null && (this.grY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.grY.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.grY.setPadding(l.h(this.hlD.getPageContext().getPageActivity(), d.e.ds32), this.grY.getPaddingTop(), this.grY.getPaddingRight(), this.grY.getPaddingBottom());
            this.grY.setLayoutParams(layoutParams2);
        }
        this.cPN.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bJf() && this.rootView.getVisibility() == 0;
    }

    private void bJe() {
        if (!bJf()) {
            this.rootView = this.hjg.inflate();
            init();
            if (this.hmi != this.hmj) {
                wc(this.hmj);
            }
        }
    }

    public boolean bJf() {
        return this.rootView != null;
    }

    public void show() {
        bJe();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ng(boolean z) {
        if (z) {
            this.hmm.aYW();
        } else {
            this.hmm.aeD();
        }
    }

    public void hide() {
        if (bJf()) {
            this.rootView.setVisibility(8);
            this.cPN.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(final Runnable runnable) {
        if (bJf()) {
            this.cPN.setStatusBarVisibility(0);
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
    public void p(Runnable runnable) {
        if (bJf()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Runnable runnable) {
        if (bJf()) {
            this.contentView.setTranslationY(l.aS(this.hlD)[1]);
            this.hmn.setAlpha(0.0f);
            a(hmh, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bJf()) {
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
            this.hmn.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hmj = i;
        if (bJf()) {
            wc(i);
        }
    }

    private void wc(int i) {
        this.hmi = i;
        this.hlD.getLayoutMode().onModeChanged(this.rootView);
        this.cPN.onChangeSkinType(this.hlD.getPageContext(), i);
        al.k(this.hmn, d.C0236d.cp_bg_line_k_alpha40);
        this.hmk.onChangeSkinType(this.hlD.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hml;
    }

    public NavigationBar aDq() {
        return this.cPN;
    }

    public View bJg() {
        return this.grY;
    }

    public View bJh() {
        return this.hmn;
    }

    public boolean bJi() {
        if (this.hml == null || this.hml.getChildCount() <= 0) {
            return true;
        }
        if (this.hml.getFirstVisiblePosition() <= 0) {
            View childAt = this.hml.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bJj() {
        return this.hmm;
    }
}
