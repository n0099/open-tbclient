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
    private static final int hDt = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private NavigationBar cXZ;
    private View contentView;
    private ViewStub hAo;
    private final PbActivity hCP;
    private NoNetworkView hDw;
    private PbLandscapeListView hDx;
    private b hDy;
    private View hDz;
    private View rootView;
    private int hDu = 3;
    private int hDv = 3;
    private View gIZ = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hCP = pbActivity;
        this.hAo = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hDx = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            boe();
            this.hDz = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hDw = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hDy = new b(this.hCP.getPageContext());
            this.hDx.setNextPage(this.hDy);
        }
    }

    private void boe() {
        this.cXZ = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gIZ = this.cXZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cXZ.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gIZ.getLayoutParams();
            int g = l.g(this.hCP.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gIZ != null && (this.gIZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gIZ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gIZ.setPadding(l.g(this.hCP.getPageContext().getPageActivity(), R.dimen.ds32), this.gIZ.getPaddingTop(), this.gIZ.getPaddingRight(), this.gIZ.getPaddingBottom());
            this.gIZ.setLayoutParams(layoutParams2);
        }
        this.cXZ.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bQV() && this.rootView.getVisibility() == 0;
    }

    private void bQU() {
        if (!bQV()) {
            this.rootView = this.hAo.inflate();
            init();
            if (this.hDu != this.hDv) {
                xe(this.hDv);
            }
        }
    }

    public boolean bQV() {
        return this.rootView != null;
    }

    public void show() {
        bQU();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nV(boolean z) {
        if (z) {
            this.hDy.bgp();
        } else {
            this.hDy.ajz();
        }
    }

    public void hide() {
        if (bQV()) {
            this.rootView.setVisibility(8);
            this.cXZ.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        if (bQV()) {
            this.cXZ.setStatusBarVisibility(0);
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
        if (bQV()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Runnable runnable) {
        if (bQV()) {
            this.contentView.setTranslationY(l.aj(this.hCP)[1]);
            this.hDz.setAlpha(0.0f);
            a(hDt, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bQV()) {
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
            this.hDz.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hDv = i;
        if (bQV()) {
            xe(i);
        }
    }

    private void xe(int i) {
        this.hDu = i;
        this.hCP.getLayoutMode().onModeChanged(this.rootView);
        this.cXZ.onChangeSkinType(this.hCP.getPageContext(), i);
        al.k(this.hDz, R.color.cp_bg_line_k_alpha40);
        this.hDw.onChangeSkinType(this.hCP.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hDx;
    }

    public NavigationBar aJC() {
        return this.cXZ;
    }

    public View bQW() {
        return this.gIZ;
    }

    public View bQX() {
        return this.hDz;
    }

    public boolean bQY() {
        if (this.hDx == null || this.hDx.getChildCount() <= 0) {
            return true;
        }
        if (this.hDx.getFirstVisiblePosition() <= 0) {
            View childAt = this.hDx.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bQZ() {
        return this.hDy;
    }
}
