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
    private static final int kjY = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar ffK;
    private ViewStub kgu;
    private PbFragment kkb;
    private NoNetworkView kkc;
    private PbLandscapeListView kkd;
    private b kke;
    private View kkf;
    private View rootView;
    private int kjZ = 3;
    private int kka = 3;
    private View jjo = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.kkb = pbFragment;
        this.kgu = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.kkd = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cgj();
            this.kkf = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.kkc = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.kke = new b(this.kkb.getPageContext());
            this.kkd.setNextPage(this.kke);
        }
    }

    private void cgj() {
        this.ffK = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.jjo = this.ffK.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.ffK.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jjo.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.jjo != null && (this.jjo.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jjo.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.jjo.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.jjo.getPaddingTop(), this.jjo.getPaddingRight(), this.jjo.getPaddingBottom());
            this.jjo.setLayoutParams(layoutParams2);
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
            this.rootView = this.kgu.inflate();
            init();
            if (this.kjZ != this.kka) {
                BB(this.kka);
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
            this.kke.bYv();
        } else {
            this.kke.endLoadData();
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
            this.contentView.setTranslationY(l.getScreenDimensions(this.kkb.getContext())[1]);
            this.kkf.setAlpha(0.0f);
            a(kjY, 1.0f, runnable);
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
            this.kkf.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.kka = i;
        if (cLU()) {
            BB(i);
        }
    }

    private void BB(int i) {
        this.kjZ = i;
        this.kkb.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.ffK.onChangeSkinType(this.kkb.getPageContext(), i);
        ao.setBackgroundResource(this.kkf, R.color.cp_bg_line_k_alpha40);
        this.kkc.onChangeSkinType(this.kkb.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.kkd;
    }

    public NavigationBar bAm() {
        return this.ffK;
    }

    public View cLV() {
        return this.jjo;
    }

    public View cLW() {
        return this.kkf;
    }

    public boolean cLX() {
        if (this.kkd == null || this.kkd.getChildCount() <= 0) {
            return true;
        }
        if (this.kkd.getFirstVisiblePosition() <= 0) {
            View childAt = this.kkd.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cLY() {
        return this.kke;
    }
}
