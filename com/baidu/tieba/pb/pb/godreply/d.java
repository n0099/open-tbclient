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
/* loaded from: classes2.dex */
public class d {
    private static final int fCo = l.h(TbadkCoreApplication.getInst(), e.C0141e.ds160);
    private NavigationBar bvF;
    private View contentView;
    private final PbActivity fBK;
    private NoNetworkView fCr;
    private PbLandscapeListView fCs;
    private b fCt;
    private View fCu;
    private ViewStub fzl;
    private View rootView;
    private int fCp = 3;
    private int fCq = 3;
    private View eIv = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fBK = pbActivity;
        this.fzl = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fCs = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aAI();
            this.fCu = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fCr = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fCt = new b(this.fBK.getPageContext());
            this.fCs.setNextPage(this.fCt);
        }
    }

    private void aAI() {
        this.bvF = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.eIv = this.bvF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bvF.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eIv.getLayoutParams();
            int h = l.h(this.fBK.getPageContext().getPageActivity(), e.C0141e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.eIv != null && (this.eIv.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.eIv.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.eIv.setPadding(l.h(this.fBK.getPageContext().getPageActivity(), e.C0141e.ds32), this.eIv.getPaddingTop(), this.eIv.getPaddingRight(), this.eIv.getPaddingBottom());
            this.eIv.setLayoutParams(layoutParams2);
        }
        this.bvF.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bcS() && this.rootView.getVisibility() == 0;
    }

    private void bcR() {
        if (!bcS()) {
            this.rootView = this.fzl.inflate();
            init();
            if (this.fCp != this.fCq) {
                qS(this.fCq);
            }
        }
    }

    public boolean bcS() {
        return this.rootView != null;
    }

    public void show() {
        bcR();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void jY(boolean z) {
        if (z) {
            this.fCt.asz();
        } else {
            this.fCt.BJ();
        }
    }

    public void hide() {
        if (bcS()) {
            this.rootView.setVisibility(8);
            this.bvF.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(final Runnable runnable) {
        if (bcS()) {
            this.bvF.setStatusBarVisibility(0);
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
        if (bcS()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(Runnable runnable) {
        if (bcS()) {
            this.contentView.setTranslationY(l.aS(this.fBK)[1]);
            this.fCu.setAlpha(0.0f);
            a(fCo, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bcS()) {
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
            this.fCu.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fCq = i;
        if (bcS()) {
            qS(i);
        }
    }

    private void qS(int i) {
        this.fCp = i;
        this.fBK.getLayoutMode().onModeChanged(this.rootView);
        this.bvF.onChangeSkinType(this.fBK.getPageContext(), i);
        al.i(this.fCu, e.d.cp_bg_line_k_alpha40);
        this.fCr.onChangeSkinType(this.fBK.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fCs;
    }

    public NavigationBar WW() {
        return this.bvF;
    }

    public View bcT() {
        return this.eIv;
    }

    public View bcU() {
        return this.fCu;
    }

    public boolean bcV() {
        if (this.fCs == null || this.fCs.getChildCount() <= 0) {
            return true;
        }
        if (this.fCs.getFirstVisiblePosition() <= 0) {
            View childAt = this.fCs.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bcW() {
        return this.fCt;
    }
}
