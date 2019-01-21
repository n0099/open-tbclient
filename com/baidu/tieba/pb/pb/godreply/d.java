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
    private static final int fVV = l.h(TbadkCoreApplication.getInst(), e.C0210e.ds160);
    private NavigationBar bEG;
    private View contentView;
    private ViewStub fSS;
    private NoNetworkView fVY;
    private PbLandscapeListView fVZ;
    private final PbActivity fVr;
    private b fWa;
    private View fWb;
    private View rootView;
    private int fVW = 3;
    private int fVX = 3;
    private View fbR = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.fVr = pbActivity;
        this.fSS = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.fVZ = (PbLandscapeListView) this.rootView.findViewById(e.g.more_god_reply_list);
            this.contentView = this.rootView.findViewById(e.g.more_god_reply_list_content);
            aGu();
            this.fWb = this.rootView.findViewById(e.g.more_god_reply_back_curtain);
            this.fVY = (NoNetworkView) this.rootView.findViewById(e.g.more_god_reply_view_no_network);
            this.fWa = new b(this.fVr.getPageContext());
            this.fVZ.setNextPage(this.fWa);
        }
    }

    private void aGu() {
        this.bEG = (NavigationBar) this.rootView.findViewById(e.g.more_god_reply_nav_bar);
        this.fbR = this.bEG.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.bEG.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fbR.getLayoutParams();
            int h = l.h(this.fVr.getPageContext().getPageActivity(), e.C0210e.ds30);
            layoutParams.height = h;
            layoutParams.width = h;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.fbR != null && (this.fbR.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.fbR.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.fbR.setPadding(l.h(this.fVr.getPageContext().getPageActivity(), e.C0210e.ds32), this.fbR.getPaddingTop(), this.fbR.getPaddingRight(), this.fbR.getPaddingBottom());
            this.fbR.setLayoutParams(layoutParams2);
        }
        this.bEG.setmBackImageViewBg(e.f.subpb_navigationbar_close, e.f.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return biH() && this.rootView.getVisibility() == 0;
    }

    private void biG() {
        if (!biH()) {
            this.rootView = this.fSS.inflate();
            init();
            if (this.fVW != this.fVX) {
                st(this.fVX);
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
            this.fWa.ayr();
        } else {
            this.fWa.Fq();
        }
    }

    public void hide() {
        if (biH()) {
            this.rootView.setVisibility(8);
            this.bEG.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(final Runnable runnable) {
        if (biH()) {
            this.bEG.setStatusBarVisibility(0);
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
            this.contentView.setTranslationY(l.aS(this.fVr)[1]);
            this.fWb.setAlpha(0.0f);
            a(fVV, 1.0f, runnable);
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
            this.fWb.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.fVX = i;
        if (biH()) {
            st(i);
        }
    }

    private void st(int i) {
        this.fVW = i;
        this.fVr.getLayoutMode().onModeChanged(this.rootView);
        this.bEG.onChangeSkinType(this.fVr.getPageContext(), i);
        al.i(this.fWb, e.d.cp_bg_line_k_alpha40);
        this.fVY.onChangeSkinType(this.fVr.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.fVZ;
    }

    public NavigationBar act() {
        return this.bEG;
    }

    public View biI() {
        return this.fbR;
    }

    public View biJ() {
        return this.fWb;
    }

    public boolean biK() {
        if (this.fVZ == null || this.fVZ.getChildCount() <= 0) {
            return true;
        }
        if (this.fVZ.getFirstVisiblePosition() <= 0) {
            View childAt = this.fVZ.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b biL() {
        return this.fWa;
    }
}
