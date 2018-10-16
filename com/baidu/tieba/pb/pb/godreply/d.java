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
    private static final int fJP = l.h(TbadkCoreApplication.getInst(), e.C0175e.ds160);
    private NavigationBar bzH;
    private View contentView;
    private ViewStub fGN;
    private NoNetworkView fJS;
    private PbLandscapeListView fJT;
    private b fJU;
    private View fJV;
    private final PbActivity fJl;
    private View rootView;
    private int fJQ = 3;
    private int fJR = 3;
    private View eQe = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fJl = pbActivity;
        this.fGN = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fJT = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aEb();
            this.fJV = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fJS = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fJU = new b(this.fJl.getPageContext());
            this.fJT.setNextPage(this.fJU);
        }
    }

    private void aEb() {
        this.bzH = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.eQe = this.bzH.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bzH.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eQe.getLayoutParams();
            int h = l.h(this.fJl.getPageContext().getPageActivity(), e.C0175e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eQe != null && (this.eQe.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eQe.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eQe.setPadding(l.h(this.fJl.getPageContext().getPageActivity(), e.C0175e.ds32), this.eQe.getPaddingTop(), this.eQe.getPaddingRight(), this.eQe.getPaddingBottom());
            this.eQe.setLayoutParams(layoutParams2);
        }
        this.bzH.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bge() && this.rootView.getVisibility() == 0;
    }

    private void bgd() {
        if (!bge()) {
            this.rootView = this.fGN.inflate();
            init();
            if (this.fJQ != this.fJR) {
                rp(this.fJR);
            }
        }
    }

    public boolean bge() {
        return this.rootView != null;
    }

    public void show() {
        bgd();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kp(boolean z) {
        if (z) {
            this.fJU.avV();
        } else {
            this.fJU.DP();
        }
    }

    public void hide() {
        if (bge()) {
            this.rootView.setVisibility(8);
            this.bzH.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bge()) {
            this.bzH.setStatusBarVisibility(0);
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
        if (bge()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bge()) {
            this.contentView.setTranslationY(l.aS(this.fJl)[1]);
            this.fJV.setAlpha(0.0f);
            a(fJP, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bge()) {
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
            this.fJV.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fJR = i;
        if (bge()) {
            rp(i);
        }
    }

    private void rp(int i) {
        this.fJQ = i;
        this.fJl.getLayoutMode().onModeChanged(this.rootView);
        this.bzH.onChangeSkinType(this.fJl.getPageContext(), i);
        al.i(this.fJV, e.d.cp_bg_line_k_alpha40);
        this.fJS.onChangeSkinType(this.fJl.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fJT;
    }

    public NavigationBar aaD() {
        return this.bzH;
    }

    public View bgf() {
        return this.eQe;
    }

    public View bgg() {
        return this.fJV;
    }

    public boolean bgh() {
        if (this.fJT == null || this.fJT.getChildCount() <= 0) {
            return true;
        }
        if (this.fJT.getFirstVisiblePosition() <= 0) {
            View childAt = this.fJT.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bgi() {
        return this.fJU;
    }
}
