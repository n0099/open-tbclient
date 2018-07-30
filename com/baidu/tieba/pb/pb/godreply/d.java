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
    private static final int fuD = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bpN;
    private View contentView;
    private ViewStub frI;
    private final PbActivity ftZ;
    private NoNetworkView fuG;
    private PbLandscapeListView fuH;
    private b fuI;
    private View fuJ;
    private View rootView;
    private int fuE = 3;
    private int fuF = 3;
    private View eBi = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.ftZ = pbActivity;
        this.frI = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fuH = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            ayv();
            this.fuJ = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fuG = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fuI = new b(this.ftZ.getPageContext());
            this.fuH.setNextPage(this.fuI);
        }
    }

    private void ayv() {
        this.bpN = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eBi = this.bpN.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bpN.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eBi.getLayoutParams();
            int f = l.f(this.ftZ.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eBi != null && (this.eBi.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eBi.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eBi.setPadding(l.f(this.ftZ.getPageContext().getPageActivity(), d.e.ds32), this.eBi.getPaddingTop(), this.eBi.getPaddingRight(), this.eBi.getPaddingBottom());
            this.eBi.setLayoutParams(layoutParams2);
        }
        this.bpN.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bax() && this.rootView.getVisibility() == 0;
    }

    private void baw() {
        if (!bax()) {
            this.rootView = this.frI.inflate();
            init();
            if (this.fuE != this.fuF) {
                qr(this.fuF);
            }
        }
    }

    public boolean bax() {
        return this.rootView != null;
    }

    public void show() {
        baw();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jx(boolean z) {
        if (z) {
            this.fuI.aqL();
        } else {
            this.fuI.Ay();
        }
    }

    public void hide() {
        if (bax()) {
            this.rootView.setVisibility(8);
            this.bpN.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bax()) {
            this.bpN.setStatusBarVisibility(0);
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
        if (bax()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bax()) {
            this.contentView.setTranslationY(l.al(this.ftZ)[1]);
            this.fuJ.setAlpha(0.0f);
            a(fuD, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bax()) {
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
            this.fuJ.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fuF = i;
        if (bax()) {
            qr(i);
        }
    }

    private void qr(int i) {
        this.fuE = i;
        this.ftZ.getLayoutMode().onModeChanged(this.rootView);
        this.bpN.onChangeSkinType(this.ftZ.getPageContext(), i);
        am.i(this.fuJ, d.C0140d.cp_bg_line_k_alpha40);
        this.fuG.onChangeSkinType(this.ftZ.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fuH;
    }

    public NavigationBar Vf() {
        return this.bpN;
    }

    public View bay() {
        return this.eBi;
    }

    public View baz() {
        return this.fuJ;
    }

    public boolean baA() {
        if (this.fuH == null || this.fuH.getChildCount() <= 0) {
            return true;
        }
        if (this.fuH.getFirstVisiblePosition() <= 0) {
            View childAt = this.fuH.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b baB() {
        return this.fuI;
    }
}
