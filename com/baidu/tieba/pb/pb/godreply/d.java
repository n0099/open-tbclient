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
    private static final int fSf = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private NavigationBar bDP;
    private View contentView;
    private ViewStub fPc;
    private final PbActivity fRB;
    private NoNetworkView fSi;
    private PbLandscapeListView fSj;
    private b fSk;
    private View fSl;
    private View rootView;
    private int fSg = 3;
    private int fSh = 3;
    private View eYm = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fRB = pbActivity;
        this.fPc = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fSj = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aFi();
            this.fSl = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fSi = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fSk = new b(this.fRB.getPageContext());
            this.fSj.setNextPage(this.fSk);
        }
    }

    private void aFi() {
        this.bDP = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.eYm = this.bDP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bDP.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eYm.getLayoutParams();
            int h = l.h(this.fRB.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eYm != null && (this.eYm.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eYm.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eYm.setPadding(l.h(this.fRB.getPageContext().getPageActivity(), e.C0210e.ds32), this.eYm.getPaddingTop(), this.eYm.getPaddingRight(), this.eYm.getPaddingBottom());
            this.eYm.setLayoutParams(layoutParams2);
        }
        this.bDP.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bhr() && this.rootView.getVisibility() == 0;
    }

    private void bhq() {
        if (!bhr()) {
            this.rootView = this.fPc.inflate();
            init();
            if (this.fSg != this.fSh) {
                sc(this.fSh);
            }
        }
    }

    public boolean bhr() {
        return this.rootView != null;
    }

    public void show() {
        bhq();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kD(boolean z) {
        if (z) {
            this.fSk.axf();
        } else {
            this.fSk.Fd();
        }
    }

    public void hide() {
        if (bhr()) {
            this.rootView.setVisibility(8);
            this.bDP.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        if (bhr()) {
            this.bDP.setStatusBarVisibility(0);
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
        if (bhr()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Runnable runnable) {
        if (bhr()) {
            this.contentView.setTranslationY(l.aS(this.fRB)[1]);
            this.fSl.setAlpha(0.0f);
            a(fSf, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bhr()) {
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
            this.fSl.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fSh = i;
        if (bhr()) {
            sc(i);
        }
    }

    private void sc(int i) {
        this.fSg = i;
        this.fRB.getLayoutMode().onModeChanged(this.rootView);
        this.bDP.onChangeSkinType(this.fRB.getPageContext(), i);
        al.i(this.fSl, e.d.cp_bg_line_k_alpha40);
        this.fSi.onChangeSkinType(this.fRB.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fSj;
    }

    public NavigationBar abU() {
        return this.bDP;
    }

    public View bhs() {
        return this.eYm;
    }

    public View bht() {
        return this.fSl;
    }

    public boolean bhu() {
        if (this.fSj == null || this.fSj.getChildCount() <= 0) {
            return true;
        }
        if (this.fSj.getFirstVisiblePosition() <= 0) {
            View childAt = this.fSj.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bhv() {
        return this.fSk;
    }
}
