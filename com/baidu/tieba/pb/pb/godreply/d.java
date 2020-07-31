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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes16.dex */
public class d {
    private static final int kjW = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar ffK;
    private ViewStub kgs;
    private PbFragment kjZ;
    private NoNetworkView kka;
    private PbLandscapeListView kkb;
    private b kkc;
    private View kkd;
    private View rootView;
    private int kjX = 3;
    private int kjY = 3;
    private View jjm = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.kjZ = pbFragment;
        this.kgs = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.kkb = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cgj();
            this.kkd = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.kka = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.kkc = new b(this.kjZ.getPageContext());
            this.kkb.setNextPage(this.kkc);
        }
    }

    private void cgj() {
        this.ffK = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.jjm = this.ffK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.ffK.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jjm.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.jjm != null && (this.jjm.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jjm.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.jjm.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.jjm.getPaddingTop(), this.jjm.getPaddingRight(), this.jjm.getPaddingBottom());
            this.jjm.setLayoutParams(layoutParams2);
        }
        if (this.ffK.getBackImageView() != null) {
            SvgManager.baR().a(this.ffK.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cLU() && this.rootView.getVisibility() == 0;
    }

    private void cLT() {
        if (!cLU()) {
            this.rootView = this.kgs.inflate();
            init();
            if (this.kjX != this.kjY) {
                BB(this.kjY);
            }
        }
    }

    public boolean cLU() {
        return this.rootView != null;
    }

    public void show() {
        cLT();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sa(boolean z) {
        if (z) {
            this.kkc.bYv();
        } else {
            this.kkc.endLoadData();
        }
    }

    public void hide() {
        if (cLU()) {
            this.rootView.setVisibility(8);
            this.ffK.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x(final Runnable runnable) {
        if (cLU()) {
            this.ffK.setStatusBarVisibility(0);
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
    public void y(Runnable runnable) {
        if (cLU()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void z(Runnable runnable) {
        if (cLU()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.kjZ.getContext())[1]);
            this.kkd.setAlpha(0.0f);
            a(kjW, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cLU()) {
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
            this.kkd.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.kjY = i;
        if (cLU()) {
            BB(i);
        }
    }

    private void BB(int i) {
        this.kjX = i;
        this.kjZ.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.ffK.onChangeSkinType(this.kjZ.getPageContext(), i);
        ao.setBackgroundResource(this.kkd, R.color.cp_bg_line_k_alpha40);
        this.kka.onChangeSkinType(this.kjZ.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.kkb;
    }

    public NavigationBar bAm() {
        return this.ffK;
    }

    public View cLV() {
        return this.jjm;
    }

    public View cLW() {
        return this.kkd;
    }

    public boolean cLX() {
        if (this.kkb == null || this.kkb.getChildCount() <= 0) {
            return true;
        }
        if (this.kkb.getFirstVisiblePosition() <= 0) {
            View childAt = this.kkb.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cLY() {
        return this.kkc;
    }
}
