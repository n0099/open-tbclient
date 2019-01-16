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
    private static final int fVU = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private NavigationBar bEF;
    private View contentView;
    private ViewStub fSR;
    private NoNetworkView fVX;
    private PbLandscapeListView fVY;
    private b fVZ;
    private final PbActivity fVq;
    private View fWa;
    private View rootView;
    private int fVV = 3;
    private int fVW = 3;
    private View fbQ = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fVq = pbActivity;
        this.fSR = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fVY = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aGu();
            this.fWa = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fVX = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fVZ = new b(this.fVq.getPageContext());
            this.fVY.setNextPage(this.fVZ);
        }
    }

    private void aGu() {
        this.bEF = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.fbQ = this.bEF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bEF.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fbQ.getLayoutParams();
            int h = l.h(this.fVq.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.fbQ != null && (this.fbQ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbQ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.fbQ.setPadding(l.h(this.fVq.getPageContext().getPageActivity(), e.C0210e.ds32), this.fbQ.getPaddingTop(), this.fbQ.getPaddingRight(), this.fbQ.getPaddingBottom());
            this.fbQ.setLayoutParams(layoutParams2);
        }
        this.bEF.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return biH() && this.rootView.getVisibility() == 0;
    }

    private void biG() {
        if (!biH()) {
            this.rootView = this.fSR.inflate();
            init();
            if (this.fVV != this.fVW) {
                st(this.fVW);
            }
        }
    }

    public boolean biH() {
        return this.rootView != null;
    }

    public void show() {
        biG();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kG(boolean z) {
        if (z) {
            this.fVZ.ayr();
        } else {
            this.fVZ.Fq();
        }
    }

    public void hide() {
        if (biH()) {
            this.rootView.setVisibility(8);
            this.bEF.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        if (biH()) {
            this.bEF.setStatusBarVisibility(0);
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
        if (biH()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Runnable runnable) {
        if (biH()) {
            this.contentView.setTranslationY(l.aS(this.fVq)[1]);
            this.fWa.setAlpha(0.0f);
            a(fVU, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (biH()) {
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
            this.fWa.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fVW = i;
        if (biH()) {
            st(i);
        }
    }

    private void st(int i) {
        this.fVV = i;
        this.fVq.getLayoutMode().onModeChanged(this.rootView);
        this.bEF.onChangeSkinType(this.fVq.getPageContext(), i);
        al.i(this.fWa, e.d.cp_bg_line_k_alpha40);
        this.fVX.onChangeSkinType(this.fVq.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fVY;
    }

    public NavigationBar act() {
        return this.bEF;
    }

    public View biI() {
        return this.fbQ;
    }

    public View biJ() {
        return this.fWa;
    }

    public boolean biK() {
        if (this.fVY == null || this.fVY.getChildCount() <= 0) {
            return true;
        }
        if (this.fVY.getFirstVisiblePosition() <= 0) {
            View childAt = this.fVY.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b biL() {
        return this.fVZ;
    }
}
