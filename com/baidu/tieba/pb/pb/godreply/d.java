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
    private static final int fdY = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bfy;
    private View contentView;
    private ViewStub fbd;
    private final PbActivity fdu;
    private NoNetworkView feb;
    private PbLandscapeListView fec;
    private b fed;
    private View fee;
    private View rootView;
    private int fdZ = 3;
    private int fea = 3;
    private View ehf = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fdu = pbActivity;
        this.fbd = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fec = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            ath();
            this.fee = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.feb = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fed = new b(this.fdu.getPageContext());
            this.fec.setNextPage(this.fed);
        }
    }

    private void ath() {
        this.bfy = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.ehf = this.bfy.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bfy.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ehf.getLayoutParams();
            int e = l.e(this.fdu.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.ehf != null && (this.ehf.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.ehf.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.ehf.setPadding(l.e(this.fdu.getPageContext().getPageActivity(), d.e.ds32), this.ehf.getPaddingTop(), this.ehf.getPaddingRight(), this.ehf.getPaddingBottom());
            this.ehf.setLayoutParams(layoutParams2);
        }
        this.bfy.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aWB() && this.rootView.getVisibility() == 0;
    }

    private void aWA() {
        if (!aWB()) {
            this.rootView = this.fbd.inflate();
            init();
            if (this.fdZ != this.fea) {
                qd(this.fea);
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
    public void ju(boolean z) {
        if (z) {
            this.fed.amL();
        } else {
            this.fed.wS();
        }
    }

    public void hide() {
        if (aWB()) {
            this.rootView.setVisibility(8);
            this.bfy.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        if (aWB()) {
            this.bfy.setStatusBarVisibility(0);
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
            this.contentView.setTranslationY(l.aj(this.fdu)[1]);
            this.fee.setAlpha(0.0f);
            a(fdY, 1.0f, runnable);
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
            this.fee.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fea = i;
        if (aWB()) {
            qd(i);
        }
    }

    private void qd(int i) {
        this.fdZ = i;
        this.fdu.getLayoutMode().u(this.rootView);
        this.bfy.onChangeSkinType(this.fdu.getPageContext(), i);
        ak.i(this.fee, d.C0126d.cp_bg_line_k_alpha40);
        this.feb.onChangeSkinType(this.fdu.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fec;
    }

    public NavigationBar Rg() {
        return this.bfy;
    }

    public View aWC() {
        return this.ehf;
    }

    public View aWD() {
        return this.fee;
    }

    public boolean aWE() {
        if (this.fec == null || this.fec.getChildCount() <= 0) {
            return true;
        }
        if (this.fec.getFirstVisiblePosition() <= 0) {
            View childAt = this.fec.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aWF() {
        return this.fed;
    }
}
