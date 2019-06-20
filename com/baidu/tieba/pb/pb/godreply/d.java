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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes4.dex */
public class d {
    private static final int hDu = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private NavigationBar cYa;
    private View contentView;
    private ViewStub hAp;
    private final PbActivity hCQ;
    private View hDA;
    private NoNetworkView hDx;
    private PbLandscapeListView hDy;
    private b hDz;
    private View rootView;
    private int hDv = 3;
    private int hDw = 3;
    private View gJb = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hCQ = pbActivity;
        this.hAp = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hDy = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            boe();
            this.hDA = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hDx = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hDz = new b(this.hCQ.getPageContext());
            this.hDy.setNextPage(this.hDz);
        }
    }

    private void boe() {
        this.cYa = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gJb = this.cYa.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cYa.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJb.getLayoutParams();
            int g = l.g(this.hCQ.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gJb != null && (this.gJb.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gJb.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gJb.setPadding(l.g(this.hCQ.getPageContext().getPageActivity(), R.dimen.ds32), this.gJb.getPaddingTop(), this.gJb.getPaddingRight(), this.gJb.getPaddingBottom());
            this.gJb.setLayoutParams(layoutParams2);
        }
        this.cYa.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bQW() && this.rootView.getVisibility() == 0;
    }

    private void bQV() {
        if (!bQW()) {
            this.rootView = this.hAp.inflate();
            init();
            if (this.hDv != this.hDw) {
                xe(this.hDw);
            }
        }
    }

    public boolean bQW() {
        return this.rootView != null;
    }

    public void show() {
        bQV();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nW(boolean z) {
        if (z) {
            this.hDz.bgp();
        } else {
            this.hDz.ajz();
        }
    }

    public void hide() {
        if (bQW()) {
            this.rootView.setVisibility(8);
            this.cYa.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        if (bQW()) {
            this.cYa.setStatusBarVisibility(0);
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
    public void r(Runnable runnable) {
        if (bQW()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Runnable runnable) {
        if (bQW()) {
            this.contentView.setTranslationY(l.aj(this.hCQ)[1]);
            this.hDA.setAlpha(0.0f);
            a(hDu, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bQW()) {
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
            this.hDA.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hDw = i;
        if (bQW()) {
            xe(i);
        }
    }

    private void xe(int i) {
        this.hDv = i;
        this.hCQ.getLayoutMode().onModeChanged(this.rootView);
        this.cYa.onChangeSkinType(this.hCQ.getPageContext(), i);
        al.k(this.hDA, R.color.cp_bg_line_k_alpha40);
        this.hDx.onChangeSkinType(this.hCQ.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hDy;
    }

    public NavigationBar aJC() {
        return this.cYa;
    }

    public View bQX() {
        return this.gJb;
    }

    public View bQY() {
        return this.hDA;
    }

    public boolean bQZ() {
        if (this.hDy == null || this.hDy.getChildCount() <= 0) {
            return true;
        }
        if (this.hDy.getFirstVisiblePosition() <= 0) {
            View childAt = this.hDy.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bRa() {
        return this.hDz;
    }
}
