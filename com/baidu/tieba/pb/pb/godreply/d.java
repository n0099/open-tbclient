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
    private static final int eSv = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bgb;
    private View contentView;
    private ViewStub eOz;
    private final PbActivity eRS;
    private b eSA;
    private View eSB;
    private NoNetworkView eSy;
    private PbLandscapeListView eSz;
    private View rootView;
    private int eSw = 3;
    private int eSx = 3;
    private View dUd = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.eRS = pbActivity;
        this.eOz = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.eSz = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            apl();
            this.eSB = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.eSy = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.eSA = new b(this.eRS.getPageContext());
            this.eSz.setNextPage(this.eSA);
        }
    }

    private void apl() {
        this.bgb = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.dUd = this.bgb.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bgb.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dUd.getLayoutParams();
            int f = l.f(this.eRS.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.dUd != null && (this.dUd.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dUd.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.dUd.setPadding(l.f(this.eRS.getPageContext().getPageActivity(), d.e.ds32), this.dUd.getPaddingTop(), this.dUd.getPaddingRight(), this.dUd.getPaddingBottom());
            this.dUd.setLayoutParams(layoutParams2);
        }
        this.bgb.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aSC() && this.rootView.getVisibility() == 0;
    }

    private void aSB() {
        if (!aSC()) {
            this.rootView = this.eOz.inflate();
            init();
            if (this.eSw != this.eSx) {
                pQ(this.eSx);
            }
        }
    }

    public boolean aSC() {
        return this.rootView != null;
    }

    public void show() {
        aSB();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jc(boolean z) {
        if (z) {
            this.eSA.aiX();
        } else {
            this.eSA.ww();
        }
    }

    public void hide() {
        if (aSC()) {
            this.rootView.setVisibility(8);
            this.bgb.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aSC()) {
            this.bgb.setStatusBarVisibility(0);
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
        if (aSC()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aSC()) {
            this.contentView.setTranslationY(l.ag(this.eRS)[1]);
            this.eSB.setAlpha(0.0f);
            a(eSv, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aSC()) {
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
            this.eSB.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.eSx = i;
        if (aSC()) {
            pQ(i);
        }
    }

    private void pQ(int i) {
        this.eSw = i;
        this.eRS.getLayoutMode().t(this.rootView);
        this.bgb.onChangeSkinType(this.eRS.getPageContext(), i);
        aj.j(this.eSB, d.C0095d.cp_bg_line_k_alpha40);
        this.eSy.onChangeSkinType(this.eRS.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.eSz;
    }

    public NavigationBar alD() {
        return this.bgb;
    }

    public View aSD() {
        return this.dUd;
    }

    public View aSE() {
        return this.eSB;
    }

    public boolean aSF() {
        if (this.eSz == null || this.eSz.getChildCount() <= 0) {
            return true;
        }
        if (this.eSz.getFirstVisiblePosition() <= 0) {
            View childAt = this.eSz.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aSG() {
        return this.eSA;
    }
}
