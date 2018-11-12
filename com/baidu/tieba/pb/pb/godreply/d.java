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
    private static final int fLp = l.h(TbadkCoreApplication.getInst(), e.C0200e.ds160);
    private NavigationBar bAs;
    private View contentView;
    private ViewStub fIm;
    private final PbActivity fKL;
    private NoNetworkView fLs;
    private PbLandscapeListView fLt;
    private b fLu;
    private View fLv;
    private View rootView;
    private int fLq = 3;
    private int fLr = 3;
    private View eRx = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fKL = pbActivity;
        this.fIm = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fLt = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aDw();
            this.fLv = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fLs = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fLu = new b(this.fKL.getPageContext());
            this.fLt.setNextPage(this.fLu);
        }
    }

    private void aDw() {
        this.bAs = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.eRx = this.bAs.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bAs.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRx.getLayoutParams();
            int h = l.h(this.fKL.getPageContext().getPageActivity(), e.C0200e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eRx != null && (this.eRx.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eRx.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eRx.setPadding(l.h(this.fKL.getPageContext().getPageActivity(), e.C0200e.ds32), this.eRx.getPaddingTop(), this.eRx.getPaddingRight(), this.eRx.getPaddingBottom());
            this.eRx.setLayoutParams(layoutParams2);
        }
        this.bAs.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bfB() && this.rootView.getVisibility() == 0;
    }

    private void bfA() {
        if (!bfB()) {
            this.rootView = this.fIm.inflate();
            init();
            if (this.fLq != this.fLr) {
                rI(this.fLr);
            }
        }
    }

    public boolean bfB() {
        return this.rootView != null;
    }

    public void show() {
        bfA();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kA(boolean z) {
        if (z) {
            this.fLu.avu();
        } else {
            this.fLu.DZ();
        }
    }

    public void hide() {
        if (bfB()) {
            this.rootView.setVisibility(8);
            this.bAs.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bfB()) {
            this.bAs.setStatusBarVisibility(0);
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
        if (bfB()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bfB()) {
            this.contentView.setTranslationY(l.aS(this.fKL)[1]);
            this.fLv.setAlpha(0.0f);
            a(fLp, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bfB()) {
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
            this.fLv.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fLr = i;
        if (bfB()) {
            rI(i);
        }
    }

    private void rI(int i) {
        this.fLq = i;
        this.fKL.getLayoutMode().onModeChanged(this.rootView);
        this.bAs.onChangeSkinType(this.fKL.getPageContext(), i);
        al.i(this.fLv, e.d.cp_bg_line_k_alpha40);
        this.fLs.onChangeSkinType(this.fKL.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fLt;
    }

    public NavigationBar aaO() {
        return this.bAs;
    }

    public View bfC() {
        return this.eRx;
    }

    public View bfD() {
        return this.fLv;
    }

    public boolean bfE() {
        if (this.fLt == null || this.fLt.getChildCount() <= 0) {
            return true;
        }
        if (this.fLt.getFirstVisiblePosition() <= 0) {
            View childAt = this.fLt.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bfF() {
        return this.fLu;
    }
}
