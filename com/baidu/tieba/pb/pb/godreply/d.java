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
    private static final int fGw = l.s(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bTn;
    private View contentView;
    private ViewStub fCv;
    private final PbActivity fFT;
    private PbLandscapeListView fGA;
    private b fGB;
    private View fGC;
    private NoNetworkView fGz;
    private View rootView;
    private int fGx = 3;
    private int fGy = 3;
    private View eHL = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fFT = pbActivity;
        this.fCv = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fGA = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            axo();
            this.fGC = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fGz = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fGB = new b(this.fFT.getPageContext());
            this.fGA.setNextPage(this.fGB);
        }
    }

    private void axo() {
        this.bTn = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eHL = this.bTn.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bTn.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eHL.getLayoutParams();
            int s = l.s(this.fFT.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = s;
            layoutParams.width = s;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eHL != null && (this.eHL.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eHL.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eHL.setPadding(l.s(this.fFT.getPageContext().getPageActivity(), d.e.ds32), this.eHL.getPaddingTop(), this.eHL.getPaddingRight(), this.eHL.getPaddingBottom());
            this.eHL.setLayoutParams(layoutParams2);
        }
        this.bTn.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aZS() && this.rootView.getVisibility() == 0;
    }

    private void aZR() {
        if (!aZS()) {
            this.rootView = this.fCv.inflate();
            init();
            if (this.fGx != this.fGy) {
                sD(this.fGy);
            }
        }
    }

    public boolean aZS() {
        return this.rootView != null;
    }

    public void show() {
        aZR();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jH(boolean z) {
        if (z) {
            this.fGB.arA();
        } else {
            this.fGB.DL();
        }
    }

    public void hide() {
        if (aZS()) {
            this.rootView.setVisibility(8);
            this.bTn.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aZS()) {
            this.bTn.setStatusBarVisibility(0);
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
        if (aZS()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aZS()) {
            this.contentView.setTranslationY(l.as(this.fFT)[1]);
            this.fGC.setAlpha(0.0f);
            a(fGw, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aZS()) {
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
            this.fGC.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fGy = i;
        if (aZS()) {
            sD(i);
        }
    }

    private void sD(int i) {
        this.fGx = i;
        this.fFT.getLayoutMode().aM(this.rootView);
        this.bTn.onChangeSkinType(this.fFT.getPageContext(), i);
        aj.s(this.fGC, d.C0107d.cp_bg_line_k_alpha40);
        this.fGz.onChangeSkinType(this.fFT.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fGA;
    }

    public NavigationBar aup() {
        return this.bTn;
    }

    public View aZT() {
        return this.eHL;
    }

    public View aZU() {
        return this.fGC;
    }

    public boolean aZV() {
        if (this.fGA == null || this.fGA.getChildCount() <= 0) {
            return true;
        }
        if (this.fGA.getFirstVisiblePosition() <= 0) {
            View childAt = this.fGA.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aZW() {
        return this.fGB;
    }
}
