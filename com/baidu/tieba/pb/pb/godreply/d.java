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
    private static final int hlQ = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar cPN;
    private View contentView;
    private ViewStub hiT;
    private NoNetworkView hlT;
    private PbLandscapeListView hlU;
    private b hlV;
    private View hlW;
    private final PbActivity hlm;
    private View rootView;
    private int hlR = 3;
    private int hlS = 3;
    private View grL = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hlm = pbActivity;
        this.hiT = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hlU = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            bgK();
            this.hlW = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.hlT = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.hlV = new b(this.hlm.getPageContext());
            this.hlU.setNextPage(this.hlV);
        }
    }

    private void bgK() {
        this.cPN = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.grL = this.cPN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cPN.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grL.getLayoutParams();
            int h = l.h(this.hlm.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.grL != null && (this.grL.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.grL.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.grL.setPadding(l.h(this.hlm.getPageContext().getPageActivity(), d.e.ds32), this.grL.getPaddingTop(), this.grL.getPaddingRight(), this.grL.getPaddingBottom());
            this.grL.setLayoutParams(layoutParams2);
        }
        this.cPN.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bJb() && this.rootView.getVisibility() == 0;
    }

    private void bJa() {
        if (!bJb()) {
            this.rootView = this.hiT.inflate();
            init();
            if (this.hlR != this.hlS) {
                vY(this.hlS);
            }
        }
    }

    public boolean bJb() {
        return this.rootView != null;
    }

    public void show() {
        bJa();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ng(boolean z) {
        if (z) {
            this.hlV.aYS();
        } else {
            this.hlV.aeA();
        }
    }

    public void hide() {
        if (bJb()) {
            this.rootView.setVisibility(8);
            this.cPN.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(final Runnable runnable) {
        if (bJb()) {
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
        if (bJb()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Runnable runnable) {
        if (bJb()) {
            this.contentView.setTranslationY(l.aS(this.hlm)[1]);
            this.hlW.setAlpha(0.0f);
            a(hlQ, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bJb()) {
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
            this.hlW.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hlS = i;
        if (bJb()) {
            vY(i);
        }
    }

    private void vY(int i) {
        this.hlR = i;
        this.hlm.getLayoutMode().onModeChanged(this.rootView);
        this.cPN.onChangeSkinType(this.hlm.getPageContext(), i);
        al.k(this.hlW, d.C0277d.cp_bg_line_k_alpha40);
        this.hlT.onChangeSkinType(this.hlm.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hlU;
    }

    public NavigationBar aDm() {
        return this.cPN;
    }

    public View bJc() {
        return this.grL;
    }

    public View bJd() {
        return this.hlW;
    }

    public boolean bJe() {
        if (this.hlU == null || this.hlU.getChildCount() <= 0) {
            return true;
        }
        if (this.hlU.getFirstVisiblePosition() <= 0) {
            View childAt = this.hlU.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bJf() {
        return this.hlV;
    }
}
