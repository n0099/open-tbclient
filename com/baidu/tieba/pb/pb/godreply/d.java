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
import com.baidu.tieba.d;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes4.dex */
public class d {
    private static final int hlP = l.h(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar cPM;
    private View contentView;
    private ViewStub hiS;
    private NoNetworkView hlS;
    private PbLandscapeListView hlT;
    private b hlU;
    private View hlV;
    private final PbActivity hll;
    private View rootView;
    private int hlQ = 3;
    private int hlR = 3;
    private View grK = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hll = pbActivity;
        this.hiS = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hlT = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            bgK();
            this.hlV = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.hlS = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.hlU = new b(this.hll.getPageContext());
            this.hlT.setNextPage(this.hlU);
        }
    }

    private void bgK() {
        this.cPM = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.grK = this.cPM.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cPM.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.grK.getLayoutParams();
            int h = l.h(this.hll.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.grK != null && (this.grK.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.grK.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.grK.setPadding(l.h(this.hll.getPageContext().getPageActivity(), d.e.ds32), this.grK.getPaddingTop(), this.grK.getPaddingRight(), this.grK.getPaddingBottom());
            this.grK.setLayoutParams(layoutParams2);
        }
        this.cPM.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bJb() && this.rootView.getVisibility() == 0;
    }

    private void bJa() {
        if (!bJb()) {
            this.rootView = this.hiS.inflate();
            init();
            if (this.hlQ != this.hlR) {
                vY(this.hlR);
            }
        }
    }

    public boolean bJb() {
        return this.rootView != null;
    }

    public void show() {
        bJa();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ng(boolean z) {
        if (z) {
            this.hlU.aYS();
        } else {
            this.hlU.aeA();
        }
    }

    public void hide() {
        if (bJb()) {
            this.rootView.setVisibility(8);
            this.cPM.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(final Runnable runnable) {
        if (bJb()) {
            this.cPM.setStatusBarVisibility(0);
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
    public void p(Runnable runnable) {
        if (bJb()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(Runnable runnable) {
        if (bJb()) {
            this.contentView.setTranslationY(l.aS(this.hll)[1]);
            this.hlV.setAlpha(0.0f);
            a(hlP, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bJb()) {
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
            this.hlV.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hlR = i;
        if (bJb()) {
            vY(i);
        }
    }

    private void vY(int i) {
        this.hlQ = i;
        this.hll.getLayoutMode().onModeChanged(this.rootView);
        this.cPM.onChangeSkinType(this.hll.getPageContext(), i);
        al.k(this.hlV, d.C0277d.cp_bg_line_k_alpha40);
        this.hlS.onChangeSkinType(this.hll.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hlT;
    }

    public NavigationBar aDm() {
        return this.cPM;
    }

    public View bJc() {
        return this.grK;
    }

    public View bJd() {
        return this.hlV;
    }

    public boolean bJe() {
        if (this.hlT == null || this.hlT.getChildCount() <= 0) {
            return true;
        }
        if (this.hlT.getFirstVisiblePosition() <= 0) {
            View childAt = this.hlT.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bJf() {
        return this.hlU;
    }
}
