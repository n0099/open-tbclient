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
import com.baidu.tieba.f;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes2.dex */
public class d {
    private static final int fuw = l.f(TbadkCoreApplication.getInst(), f.e.ds160);
    private NavigationBar bpP;
    private View contentView;
    private ViewStub frB;
    private final PbActivity ftS;
    private PbLandscapeListView fuA;
    private b fuB;
    private View fuC;
    private NoNetworkView fuz;
    private View rootView;
    private int fux = 3;
    private int fuy = 3;
    private View eBe = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.ftS = pbActivity;
        this.frB = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fuA = (PbLandscapeListView) this.rootView.findViewById(f.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(f.g.more_god_reply_list_content);
            ayt();
            this.fuC = this.rootView.findViewById(f.g.more_god_reply_back_curtain);
            this.fuz = (NoNetworkView) this.rootView.findViewById(f.g.more_god_reply_view_no_network);
            this.fuB = new b(this.ftS.getPageContext());
            this.fuA.setNextPage(this.fuB);
        }
    }

    private void ayt() {
        this.bpP = (NavigationBar) this.rootView.findViewById(f.g.more_god_reply_nav_bar);
        this.eBe = this.bpP.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bpP.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eBe.getLayoutParams();
            int f = l.f(this.ftS.getPageContext().getPageActivity(), f.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eBe != null && (this.eBe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eBe.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eBe.setPadding(l.f(this.ftS.getPageContext().getPageActivity(), f.e.ds32), this.eBe.getPaddingTop(), this.eBe.getPaddingRight(), this.eBe.getPaddingBottom());
            this.eBe.setLayoutParams(layoutParams2);
        }
        this.bpP.setmBackImageViewBg(f.C0146f.subpb_navigationbar_close, f.C0146f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bas() && this.rootView.getVisibility() == 0;
    }

    private void bar() {
        if (!bas()) {
            this.rootView = this.frB.inflate();
            init();
            if (this.fux != this.fuy) {
                qr(this.fuy);
            }
        }
    }

    public boolean bas() {
        return this.rootView != null;
    }

    public void show() {
        bar();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jx(boolean z) {
        if (z) {
            this.fuB.aqL();
        } else {
            this.fuB.Aw();
        }
    }

    public void hide() {
        if (bas()) {
            this.rootView.setVisibility(8);
            this.bpP.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bas()) {
            this.bpP.setStatusBarVisibility(0);
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
        if (bas()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bas()) {
            this.contentView.setTranslationY(l.al(this.ftS)[1]);
            this.fuC.setAlpha(0.0f);
            a(fuw, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bas()) {
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
            this.fuC.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fuy = i;
        if (bas()) {
            qr(i);
        }
    }

    private void qr(int i) {
        this.fux = i;
        this.ftS.getLayoutMode().onModeChanged(this.rootView);
        this.bpP.onChangeSkinType(this.ftS.getPageContext(), i);
        am.i(this.fuC, f.d.cp_bg_line_k_alpha40);
        this.fuz.onChangeSkinType(this.ftS.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fuA;
    }

    public NavigationBar Vj() {
        return this.bpP;
    }

    public View bat() {
        return this.eBe;
    }

    public View bau() {
        return this.fuC;
    }

    public boolean bav() {
        if (this.fuA == null || this.fuA.getChildCount() <= 0) {
            return true;
        }
        if (this.fuA.getFirstVisiblePosition() <= 0) {
            View childAt = this.fuA.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b baw() {
        return this.fuB;
    }
}
