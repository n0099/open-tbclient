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
    private static final int fUX = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private NavigationBar bDS;
    private View contentView;
    private ViewStub fRU;
    private final PbActivity fUt;
    private NoNetworkView fVa;
    private PbLandscapeListView fVb;
    private b fVc;
    private View fVd;
    private View rootView;
    private int fUY = 3;
    private int fUZ = 3;
    private View fbd = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fUt = pbActivity;
        this.fRU = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fVb = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aFX();
            this.fVd = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fVa = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fVc = new b(this.fUt.getPageContext());
            this.fVb.setNextPage(this.fVc);
        }
    }

    private void aFX() {
        this.bDS = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.fbd = this.bDS.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bDS.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fbd.getLayoutParams();
            int h = l.h(this.fUt.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.fbd != null && (this.fbd.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbd.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.fbd.setPadding(l.h(this.fUt.getPageContext().getPageActivity(), e.C0210e.ds32), this.fbd.getPaddingTop(), this.fbd.getPaddingRight(), this.fbd.getPaddingBottom());
            this.fbd.setLayoutParams(layoutParams2);
        }
        this.bDS.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bid() && this.rootView.getVisibility() == 0;
    }

    private void bic() {
        if (!bid()) {
            this.rootView = this.fRU.inflate();
            init();
            if (this.fUY != this.fUZ) {
                sp(this.fUZ);
            }
        }
    }

    public boolean bid() {
        return this.rootView != null;
    }

    public void show() {
        bic();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void kG(boolean z) {
        if (z) {
            this.fVc.axU();
        } else {
            this.fVc.Fd();
        }
    }

    public void hide() {
        if (bid()) {
            this.rootView.setVisibility(8);
            this.bDS.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        if (bid()) {
            this.bDS.setStatusBarVisibility(0);
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
        if (bid()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(Runnable runnable) {
        if (bid()) {
            this.contentView.setTranslationY(l.aS(this.fUt)[1]);
            this.fVd.setAlpha(0.0f);
            a(fUX, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bid()) {
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
            this.fVd.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fUZ = i;
        if (bid()) {
            sp(i);
        }
    }

    private void sp(int i) {
        this.fUY = i;
        this.fUt.getLayoutMode().onModeChanged(this.rootView);
        this.bDS.onChangeSkinType(this.fUt.getPageContext(), i);
        al.i(this.fVd, e.d.cp_bg_line_k_alpha40);
        this.fVa.onChangeSkinType(this.fUt.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fVb;
    }

    public NavigationBar abW() {
        return this.bDS;
    }

    public View bie() {
        return this.fbd;
    }

    public View bif() {
        return this.fVd;
    }

    public boolean big() {
        if (this.fVb == null || this.fVb.getChildCount() <= 0) {
            return true;
        }
        if (this.fVb.getFirstVisiblePosition() <= 0) {
            View childAt = this.fVb.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bih() {
        return this.fVc;
    }
}
