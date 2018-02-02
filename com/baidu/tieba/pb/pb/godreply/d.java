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
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes2.dex */
public class d {
    private static final int fGR = l.s(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bTv;
    private View contentView;
    private ViewStub fCQ;
    private NoNetworkView fGU;
    private PbLandscapeListView fGV;
    private b fGW;
    private View fGX;
    private final PbActivity fGo;
    private View rootView;
    private int fGS = 3;
    private int fGT = 3;
    private View eIg = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fGo = pbActivity;
        this.fCQ = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fGV = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            axt();
            this.fGX = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fGU = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fGW = new b(this.fGo.getPageContext());
            this.fGV.setNextPage(this.fGW);
        }
    }

    private void axt() {
        this.bTv = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.eIg = this.bTv.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bTv.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIg.getLayoutParams();
            int s = l.s(this.fGo.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = s;
            layoutParams.width = s;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eIg != null && (this.eIg.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eIg.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eIg.setPadding(l.s(this.fGo.getPageContext().getPageActivity(), d.e.ds32), this.eIg.getPaddingTop(), this.eIg.getPaddingRight(), this.eIg.getPaddingBottom());
            this.eIg.setLayoutParams(layoutParams2);
        }
        this.bTv.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aZX() && this.rootView.getVisibility() == 0;
    }

    private void aZW() {
        if (!aZX()) {
            this.rootView = this.fCQ.inflate();
            init();
            if (this.fGS != this.fGT) {
                sD(this.fGT);
            }
        }
    }

    public boolean aZX() {
        return this.rootView != null;
    }

    public void show() {
        aZW();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jK(boolean z) {
        if (z) {
            this.fGW.arF();
        } else {
            this.fGW.DN();
        }
    }

    public void hide() {
        if (aZX()) {
            this.rootView.setVisibility(8);
            this.bTv.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aZX()) {
            this.bTv.setStatusBarVisibility(0);
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
    public void l(Runnable runnable) {
        if (aZX()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aZX()) {
            this.contentView.setTranslationY(l.as(this.fGo)[1]);
            this.fGX.setAlpha(0.0f);
            a(fGR, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aZX()) {
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
            this.fGX.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fGT = i;
        if (aZX()) {
            sD(i);
        }
    }

    private void sD(int i) {
        this.fGS = i;
        this.fGo.getLayoutMode().aM(this.rootView);
        this.bTv.onChangeSkinType(this.fGo.getPageContext(), i);
        aj.s(this.fGX, d.C0108d.cp_bg_line_k_alpha40);
        this.fGU.onChangeSkinType(this.fGo.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fGV;
    }

    public NavigationBar auu() {
        return this.bTv;
    }

    public View aZY() {
        return this.eIg;
    }

    public View aZZ() {
        return this.fGX;
    }

    public boolean baa() {
        if (this.fGV == null || this.fGV.getChildCount() <= 0) {
            return true;
        }
        if (this.fGV.getFirstVisiblePosition() <= 0) {
            View childAt = this.fGV.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bab() {
        return this.fGW;
    }
}
