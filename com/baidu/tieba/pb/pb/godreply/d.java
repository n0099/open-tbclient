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
/* loaded from: classes.dex */
public class d {
    private static final int eSq = l.f(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bfX;
    private View contentView;
    private ViewStub eOu;
    private final PbActivity eRN;
    private NoNetworkView eSt;
    private PbLandscapeListView eSu;
    private b eSv;
    private View eSw;
    private View rootView;
    private int eSr = 3;
    private int eSs = 3;
    private View dTZ = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.eRN = pbActivity;
        this.eOu = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.eSu = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            apk();
            this.eSw = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.eSt = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.eSv = new b(this.eRN.getPageContext());
            this.eSu.setNextPage(this.eSv);
        }
    }

    private void apk() {
        this.bfX = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.dTZ = this.bfX.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bfX.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.dTZ.getLayoutParams();
            int f = l.f(this.eRN.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = f;
            layoutParams.width = f;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.dTZ != null && (this.dTZ.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.dTZ.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.dTZ.setPadding(l.f(this.eRN.getPageContext().getPageActivity(), d.e.ds32), this.dTZ.getPaddingTop(), this.dTZ.getPaddingRight(), this.dTZ.getPaddingBottom());
            this.dTZ.setLayoutParams(layoutParams2);
        }
        this.bfX.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return aSB() && this.rootView.getVisibility() == 0;
    }

    private void aSA() {
        if (!aSB()) {
            this.rootView = this.eOu.inflate();
            init();
            if (this.eSr != this.eSs) {
                pQ(this.eSs);
            }
        }
    }

    public boolean aSB() {
        return this.rootView != null;
    }

    public void show() {
        aSA();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jc(boolean z) {
        if (z) {
            this.eSv.aiX();
        } else {
            this.eSv.ww();
        }
    }

    public void hide() {
        if (aSB()) {
            this.rootView.setVisibility(8);
            this.bfX.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(final Runnable runnable) {
        if (aSB()) {
            this.bfX.setStatusBarVisibility(0);
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
        if (aSB()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Runnable runnable) {
        if (aSB()) {
            this.contentView.setTranslationY(l.ag(this.eRN)[1]);
            this.eSw.setAlpha(0.0f);
            a(eSq, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (aSB()) {
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
            this.eSw.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.eSs = i;
        if (aSB()) {
            pQ(i);
        }
    }

    private void pQ(int i) {
        this.eSr = i;
        this.eRN.getLayoutMode().t(this.rootView);
        this.bfX.onChangeSkinType(this.eRN.getPageContext(), i);
        aj.j(this.eSw, d.C0096d.cp_bg_line_k_alpha40);
        this.eSt.onChangeSkinType(this.eRN.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.eSu;
    }

    public NavigationBar alD() {
        return this.bfX;
    }

    public View aSC() {
        return this.dTZ;
    }

    public View aSD() {
        return this.eSw;
    }

    public boolean aSE() {
        if (this.eSu == null || this.eSu.getChildCount() <= 0) {
            return true;
        }
        if (this.eSu.getFirstVisiblePosition() <= 0) {
            View childAt = this.eSu.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b aSF() {
        return this.eSv;
    }
}
