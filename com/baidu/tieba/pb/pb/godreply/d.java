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
    private static final int fEW = l.s(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bTg;
    private View contentView;
    private ViewStub fAV;
    private NoNetworkView fEZ;
    private final PbActivity fEt;
    private PbLandscapeListView fFa;
    private b fFb;
    private View fFc;
    private View rootView;
    private int fEX = 3;
    private int fEY = 3;
    private View eGl = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fEt = pbActivity;
        this.fAV = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fFa = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            awl();
            this.fFc = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fEZ = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fFb = new b(this.fEt.getPageContext());
            this.fFa.setNextPage(this.fFb);
        }
    }

    private void awl() {
        this.bTg = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eGl = this.bTg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bTg.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eGl.getLayoutParams();
            int s = l.s(this.fEt.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = s;
            layoutParams.width = s;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eGl != null && (this.eGl.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eGl.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eGl.setPadding(l.s(this.fEt.getPageContext().getPageActivity(), d.e.ds32), this.eGl.getPaddingTop(), this.eGl.getPaddingRight(), this.eGl.getPaddingBottom());
            this.eGl.setLayoutParams(layoutParams2);
        }
        this.bTg.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aZO() && this.rootView.getVisibility() == 0;
    }

    private void aZN() {
        if (!aZO()) {
            this.rootView = this.fAV.inflate();
            init();
            if (this.fEX != this.fEY) {
                sK(this.fEY);
            }
        }
    }

    public boolean aZO() {
        return this.rootView != null;
    }

    public void show() {
        aZN();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jE(boolean z) {
        if (z) {
            this.fFb.aqx();
        } else {
            this.fFb.DU();
        }
    }

    public void hide() {
        if (aZO()) {
            this.rootView.setVisibility(8);
            this.bTg.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aZO()) {
            this.bTg.setStatusBarVisibility(0);
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
        if (aZO()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aZO()) {
            this.contentView.setTranslationY(l.as(this.fEt)[1]);
            this.fFc.setAlpha(0.0f);
            a(fEW, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aZO()) {
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
            this.fFc.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fEY = i;
        if (aZO()) {
            sK(i);
        }
    }

    private void sK(int i) {
        this.fEX = i;
        this.fEt.getLayoutMode().aM(this.rootView);
        this.bTg.onChangeSkinType(this.fEt.getPageContext(), i);
        aj.s(this.fFc, d.C0108d.cp_bg_line_k_alpha40);
        this.fEZ.onChangeSkinType(this.fEt.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fFa;
    }

    public NavigationBar atm() {
        return this.bTg;
    }

    public View aZP() {
        return this.eGl;
    }

    public View aZQ() {
        return this.fFc;
    }

    public boolean aZR() {
        if (this.fFa == null || this.fFa.getChildCount() <= 0) {
            return true;
        }
        if (this.fFa.getFirstVisiblePosition() <= 0) {
            View childAt = this.fFa.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aZS() {
        return this.fFb;
    }
}
