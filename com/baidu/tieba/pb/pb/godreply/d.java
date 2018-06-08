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
/* loaded from: classes2.dex */
public class d {
    private static final int fqz = l.e(TbadkCoreApplication.getInst(), d.e.ds160);
    private NavigationBar bnG;
    private View contentView;
    private ViewStub fnC;
    private final PbActivity fpV;
    private NoNetworkView fqC;
    private PbLandscapeListView fqD;
    private b fqE;
    private View fqF;
    private View rootView;
    private int fqA = 3;
    private int fqB = 3;
    private View etA = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fpV = pbActivity;
        this.fnC = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fqD = (PbLandscapeListView) this.rootView.findViewById(d.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(d.g.more_god_reply_list_content);
            axm();
            this.fqF = this.rootView.findViewById(d.g.more_god_reply_back_curtain);
            this.fqC = (NoNetworkView) this.rootView.findViewById(d.g.more_god_reply_view_no_network);
            this.fqE = new b(this.fpV.getPageContext());
            this.fqD.setNextPage(this.fqE);
        }
    }

    private void axm() {
        this.bnG = (NavigationBar) this.rootView.findViewById(d.g.more_god_reply_nav_bar);
        this.etA = this.bnG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bnG.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.etA.getLayoutParams();
            int e = l.e(this.fpV.getPageContext().getPageActivity(), d.e.ds30);
            layoutParams.height = e;
            layoutParams.width = e;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.etA != null && (this.etA.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.etA.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.etA.setPadding(l.e(this.fpV.getPageContext().getPageActivity(), d.e.ds32), this.etA.getPaddingTop(), this.etA.getPaddingRight(), this.etA.getPaddingBottom());
            this.etA.setLayoutParams(layoutParams2);
        }
        this.bnG.setmBackImageViewBg(d.f.subpb_navigationbar_close, d.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bbx() && this.rootView.getVisibility() == 0;
    }

    private void bbw() {
        if (!bbx()) {
            this.rootView = this.fnC.inflate();
            init();
            if (this.fqA != this.fqB) {
                qn(this.fqB);
            }
        }
    }

    public boolean bbx() {
        return this.rootView != null;
    }

    public void show() {
        bbw();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jB(boolean z) {
        if (z) {
            this.fqE.aqQ();
        } else {
            this.fqE.As();
        }
    }

    public void hide() {
        if (bbx()) {
            this.rootView.setVisibility(8);
            this.bnG.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bbx()) {
            this.bnG.setStatusBarVisibility(0);
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
        if (bbx()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bbx()) {
            this.contentView.setTranslationY(l.al(this.fpV)[1]);
            this.fqF.setAlpha(0.0f);
            a(fqz, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bbx()) {
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
            this.fqF.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fqB = i;
        if (bbx()) {
            qn(i);
        }
    }

    private void qn(int i) {
        this.fqA = i;
        this.fpV.getLayoutMode().onModeChanged(this.rootView);
        this.bnG.onChangeSkinType(this.fpV.getPageContext(), i);
        al.i(this.fqF, d.C0141d.cp_bg_line_k_alpha40);
        this.fqC.onChangeSkinType(this.fpV.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fqD;
    }

    public NavigationBar UB() {
        return this.bnG;
    }

    public View bby() {
        return this.etA;
    }

    public View bbz() {
        return this.fqF;
    }

    public boolean bbA() {
        if (this.fqD == null || this.fqD.getChildCount() <= 0) {
            return true;
        }
        if (this.fqD.getFirstVisiblePosition() <= 0) {
            View childAt = this.fqD.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bbB() {
        return this.fqE;
    }
}
