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
    private static final int hmc = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar cPK;
    private View contentView;
    private ViewStub hjf;
    private final PbActivity hly;
    private NoNetworkView hmf;
    private PbLandscapeListView hmg;
    private b hmh;
    private View hmi;
    private View rootView;
    private int hmd = 3;
    private int hme = 3;
    private View grX = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hly = pbActivity;
        this.hjf = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hmg = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            bgM();
            this.hmi = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.hmf = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.hmh = new b(this.hly.getPageContext());
            this.hmg.setNextPage(this.hmh);
        }
    }

    private void bgM() {
        this.cPK = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.grX = this.cPK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cPK.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grX.getLayoutParams();
            int h = l.h(this.hly.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.grX != null && (this.grX.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.grX.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.grX.setPadding(l.h(this.hly.getPageContext().getPageActivity(), d.e.ds32), this.grX.getPaddingTop(), this.grX.getPaddingRight(), this.grX.getPaddingBottom());
            this.grX.setLayoutParams(layoutParams2);
        }
        this.cPK.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bJe() && this.rootView.getVisibility() == 0;
    }

    private void bJd() {
        if (!bJe()) {
            this.rootView = this.hjf.inflate();
            init();
            if (this.hmd != this.hme) {
                wc(this.hme);
            }
        }
    }

    public boolean bJe() {
        return this.rootView != null;
    }

    public void show() {
        bJd();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ng(boolean z) {
        if (z) {
            this.hmh.aYV();
        } else {
            this.hmh.aeD();
        }
    }

    public void hide() {
        if (bJe()) {
            this.rootView.setVisibility(8);
            this.cPK.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(final Runnable runnable) {
        if (bJe()) {
            this.cPK.setStatusBarVisibility(0);
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
        if (bJe()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Runnable runnable) {
        if (bJe()) {
            this.contentView.setTranslationY(l.aS(this.hly)[1]);
            this.hmi.setAlpha(0.0f);
            a(hmc, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bJe()) {
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
            this.hmi.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hme = i;
        if (bJe()) {
            wc(i);
        }
    }

    private void wc(int i) {
        this.hmd = i;
        this.hly.getLayoutMode().onModeChanged(this.rootView);
        this.cPK.onChangeSkinType(this.hly.getPageContext(), i);
        al.k(this.hmi, d.C0277d.cp_bg_line_k_alpha40);
        this.hmf.onChangeSkinType(this.hly.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hmg;
    }

    public NavigationBar aDp() {
        return this.cPK;
    }

    public View bJf() {
        return this.grX;
    }

    public View bJg() {
        return this.hmi;
    }

    public boolean bJh() {
        if (this.hmg == null || this.hmg.getChildCount() <= 0) {
            return true;
        }
        if (this.hmg.getFirstVisiblePosition() <= 0) {
            View childAt = this.hmg.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bJi() {
        return this.hmh;
    }
}
