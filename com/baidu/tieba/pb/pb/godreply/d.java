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
    private static final int eJP = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bcK;
    private View contentView;
    private ViewStub eFI;
    private NoNetworkView eJS;
    private PbLandscapeListView eJT;
    private b eJU;
    private View eJV;
    private final PbActivity eJm;
    private View rootView;
    private int eJQ = 3;
    private int eJR = 3;
    private View dLg = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.eJm = pbActivity;
        this.eFI = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.eJT = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            ani();
            this.eJV = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.eJS = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.eJU = new b(this.eJm.getPageContext());
            this.eJT.setNextPage(this.eJU);
        }
    }

    private void ani() {
        this.bcK = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.dLg = this.bcK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bcK.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dLg.getLayoutParams();
            int f = l.f(this.eJm.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.dLg != null && (this.dLg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dLg.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.dLg.setPadding(l.f(this.eJm.getPageContext().getPageActivity(), d.e.ds32), this.dLg.getPaddingTop(), this.dLg.getPaddingRight(), this.dLg.getPaddingBottom());
            this.dLg.setLayoutParams(layoutParams2);
        }
        this.bcK.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aRf() && this.rootView.getVisibility() == 0;
    }

    private void aRe() {
        if (!aRf()) {
            this.rootView = this.eFI.inflate();
            init();
            if (this.eJQ != this.eJR) {
                pw(this.eJR);
            }
        }
    }

    public boolean aRf() {
        return this.rootView != null;
    }

    public void show() {
        aRe();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void iK(boolean z) {
        if (z) {
            this.eJU.ahd();
        } else {
            this.eJU.wu();
        }
    }

    public void hide() {
        if (aRf()) {
            this.rootView.setVisibility(8);
            this.bcK.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aRf()) {
            this.bcK.setStatusBarVisibility(0);
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
        if (aRf()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aRf()) {
            this.contentView.setTranslationY(l.ag(this.eJm)[1]);
            this.eJV.setAlpha(0.0f);
            a(eJP, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aRf()) {
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
            this.eJV.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.eJR = i;
        if (aRf()) {
            pw(i);
        }
    }

    private void pw(int i) {
        this.eJQ = i;
        this.eJm.getLayoutMode().t(this.rootView);
        this.bcK.onChangeSkinType(this.eJm.getPageContext(), i);
        aj.j(this.eJV, d.C0080d.cp_bg_line_k_alpha40);
        this.eJS.onChangeSkinType(this.eJm.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.eJT;
    }

    public NavigationBar ajA() {
        return this.bcK;
    }

    public View aRg() {
        return this.dLg;
    }

    public View aRh() {
        return this.eJV;
    }

    public boolean aRi() {
        if (this.eJT == null || this.eJT.getChildCount() <= 0) {
            return true;
        }
        if (this.eJT.getFirstVisiblePosition() <= 0) {
            View childAt = this.eJT.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aRj() {
        return this.eJU;
    }
}
