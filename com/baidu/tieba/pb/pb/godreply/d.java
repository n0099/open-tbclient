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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes9.dex */
public class d {
    private static final int kbs = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar fbi;
    private ViewStub jXS;
    private PbFragment kbv;
    private NoNetworkView kbw;
    private PbLandscapeListView kbx;
    private b kby;
    private View kbz;
    private View rootView;
    private int kbt = 3;
    private int kbu = 3;
    private View jaS = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.kbv = pbFragment;
        this.jXS = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.kbx = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            ccK();
            this.kbz = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.kbw = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.kby = new b(this.kbv.getPageContext());
            this.kbx.setNextPage(this.kby);
        }
    }

    private void ccK() {
        this.fbi = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.jaS = this.fbi.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.fbi.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jaS.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.jaS != null && (this.jaS.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jaS.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.jaS.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.jaS.getPaddingTop(), this.jaS.getPaddingRight(), this.jaS.getPaddingBottom());
            this.jaS.setLayoutParams(layoutParams2);
        }
        if (this.fbi.getBackImageView() != null) {
            SvgManager.aWQ().a(this.fbi.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.cp_cont_f, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return cIj() && this.rootView.getVisibility() == 0;
    }

    private void cIi() {
        if (!cIj()) {
            this.rootView = this.jXS.inflate();
            init();
            if (this.kbt != this.kbu) {
                Bc(this.kbu);
            }
        }
    }

    public boolean cIj() {
        return this.rootView != null;
    }

    public void show() {
        cIi();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void rv(boolean z) {
        if (z) {
            this.kby.bVb();
        } else {
            this.kby.endLoadData();
        }
    }

    public void hide() {
        if (cIj()) {
            this.rootView.setVisibility(8);
            this.fbi.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(final Runnable runnable) {
        if (cIj()) {
            this.fbi.setStatusBarVisibility(0);
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
    public void z(Runnable runnable) {
        if (cIj()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void A(Runnable runnable) {
        if (cIj()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.kbv.getContext())[1]);
            this.kbz.setAlpha(0.0f);
            a(kbs, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (cIj()) {
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
            this.kbz.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.kbu = i;
        if (cIj()) {
            Bc(i);
        }
    }

    private void Bc(int i) {
        this.kbt = i;
        this.kbv.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.fbi.onChangeSkinType(this.kbv.getPageContext(), i);
        an.setBackgroundResource(this.kbz, R.color.cp_bg_line_k_alpha40);
        this.kbw.onChangeSkinType(this.kbv.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.kbx;
    }

    public NavigationBar bwV() {
        return this.fbi;
    }

    public View cIk() {
        return this.jaS;
    }

    public View cIl() {
        return this.kbz;
    }

    public boolean cIm() {
        if (this.kbx == null || this.kbx.getChildCount() <= 0) {
            return true;
        }
        if (this.kbx.getFirstVisiblePosition() <= 0) {
            View childAt = this.kbx.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b cIn() {
        return this.kby;
    }
}
