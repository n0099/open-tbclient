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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes2.dex */
public class d {
    private static final int fus = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bpg;
    private View contentView;
    private ViewStub frw;
    private final PbActivity ftO;
    private NoNetworkView fuv;
    private PbLandscapeListView fuw;
    private b fux;
    private View fuy;
    private View rootView;
    private int fut = 3;
    private int fuu = 3;
    private View exp = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.ftO = pbActivity;
        this.frw = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fuw = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            axQ();
            this.fuy = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fuv = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fux = new b(this.ftO.getPageContext());
            this.fuw.setNextPage(this.fux);
        }
    }

    private void axQ() {
        this.bpg = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.exp = this.bpg.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bpg.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.exp.getLayoutParams();
            int e = l.e(this.ftO.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.exp != null && (this.exp.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.exp.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.exp.setPadding(l.e(this.ftO.getPageContext().getPageActivity(), d.e.ds32), this.exp.getPaddingTop(), this.exp.getPaddingRight(), this.exp.getPaddingBottom());
            this.exp.setLayoutParams(layoutParams2);
        }
        this.bpg.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bce() && this.rootView.getVisibility() == 0;
    }

    private void bcd() {
        if (!bce()) {
            this.rootView = this.frw.inflate();
            init();
            if (this.fut != this.fuu) {
                qu(this.fuu);
            }
        }
    }

    public boolean bce() {
        return this.rootView != null;
    }

    public void show() {
        bcd();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jL(boolean z) {
        if (z) {
            this.fux.aql();
        } else {
            this.fux.AI();
        }
    }

    public void hide() {
        if (bce()) {
            this.rootView.setVisibility(8);
            this.bpg.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bce()) {
            this.bpg.setStatusBarVisibility(0);
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
    public void j(Runnable runnable) {
        if (bce()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bce()) {
            this.contentView.setTranslationY(l.al(this.ftO)[1]);
            this.fuy.setAlpha(0.0f);
            a(fus, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bce()) {
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
            this.fuy.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fuu = i;
        if (bce()) {
            qu(i);
        }
    }

    private void qu(int i) {
        this.fut = i;
        this.ftO.getLayoutMode().onModeChanged(this.rootView);
        this.bpg.onChangeSkinType(this.ftO.getPageContext(), i);
        am.i(this.fuy, d.C0142d.cp_bg_line_k_alpha40);
        this.fuv.onChangeSkinType(this.ftO.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fuw;
    }

    public NavigationBar UW() {
        return this.bpg;
    }

    public View bcf() {
        return this.exp;
    }

    public View bcg() {
        return this.fuy;
    }

    public boolean bch() {
        if (this.fuw == null || this.fuw.getChildCount() <= 0) {
            return true;
        }
        if (this.fuw.getFirstVisiblePosition() <= 0) {
            View childAt = this.fuw.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bci() {
        return this.fux;
    }
}
