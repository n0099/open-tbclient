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
    private static final int eJv = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bcB;
    private View contentView;
    private ViewStub eFo;
    private final PbActivity eIS;
    private b eJA;
    private View eJB;
    private NoNetworkView eJy;
    private PbLandscapeListView eJz;
    private View rootView;
    private int eJw = 3;
    private int eJx = 3;
    private View dLb = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.eIS = pbActivity;
        this.eFo = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.eJz = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            amU();
            this.eJB = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.eJy = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.eJA = new b(this.eIS.getPageContext());
            this.eJz.setNextPage(this.eJA);
        }
    }

    private void amU() {
        this.bcB = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.dLb = this.bcB.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bcB.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLb.getLayoutParams();
            int f = l.f(this.eIS.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.dLb != null && (this.dLb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLb.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.dLb.setPadding(l.f(this.eIS.getPageContext().getPageActivity(), d.e.ds32), this.dLb.getPaddingTop(), this.dLb.getPaddingRight(), this.dLb.getPaddingBottom());
            this.dLb.setLayoutParams(layoutParams2);
        }
        this.bcB.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aQX() && this.rootView.getVisibility() == 0;
    }

    private void aQW() {
        if (!aQX()) {
            this.rootView = this.eFo.inflate();
            init();
            if (this.eJw != this.eJx) {
                pv(this.eJx);
            }
        }
    }

    public boolean aQX() {
        return this.rootView != null;
    }

    public void show() {
        aQW();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iE(boolean z) {
        if (z) {
            this.eJA.agP();
        } else {
            this.eJA.wu();
        }
    }

    public void hide() {
        if (aQX()) {
            this.rootView.setVisibility(8);
            this.bcB.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aQX()) {
            this.bcB.setStatusBarVisibility(0);
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
        if (aQX()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aQX()) {
            this.contentView.setTranslationY(l.ag(this.eIS)[1]);
            this.eJB.setAlpha(0.0f);
            a(eJv, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aQX()) {
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
            this.eJB.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.eJx = i;
        if (aQX()) {
            pv(i);
        }
    }

    private void pv(int i) {
        this.eJw = i;
        this.eIS.getLayoutMode().t(this.rootView);
        this.bcB.onChangeSkinType(this.eIS.getPageContext(), i);
        aj.j(this.eJB, d.C0080d.cp_bg_line_k_alpha40);
        this.eJy.onChangeSkinType(this.eIS.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.eJz;
    }

    public NavigationBar ajm() {
        return this.bcB;
    }

    public View aQY() {
        return this.dLb;
    }

    public View aQZ() {
        return this.eJB;
    }

    public boolean aRa() {
        if (this.eJz == null || this.eJz.getChildCount() <= 0) {
            return true;
        }
        if (this.eJz.getFirstVisiblePosition() <= 0) {
            View childAt = this.eJz.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aRb() {
        return this.eJA;
    }
}
