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
/* loaded from: classes2.dex */
public class d {
    private static final int lEf = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar ghr;
    private ViewStub lAr;
    private PbFragment lEi;
    private NoNetworkView lEj;
    private PbLandscapeListView lEk;
    private b lEl;
    private View lEm;
    private View rootView;
    private int lEg = 3;
    private int lEh = 3;
    private View kDo = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lEi = pbFragment;
        this.lAr = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lEk = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cHg();
            this.lEm = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lEj = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lEl = new b(this.lEi.getPageContext());
            this.lEk.setNextPage(this.lEl);
        }
    }

    private void cHg() {
        this.ghr = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kDo = this.ghr.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.ghr.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kDo.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kDo != null && (this.kDo.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kDo.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kDo.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kDo.getPaddingTop(), this.kDo.getPaddingRight(), this.kDo.getPaddingBottom());
            this.kDo.setLayoutParams(layoutParams2);
        }
        if (this.ghr.getBackImageView() != null) {
            SvgManager.bsx().a(this.ghr.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dki() && this.rootView.getVisibility() == 0;
    }

    private void dkh() {
        if (!dki()) {
            this.rootView = this.lAr.inflate();
            init();
            if (this.lEg != this.lEh) {
                Fg(this.lEh);
            }
        }
    }

    public boolean dki() {
        return this.rootView != null;
    }

    public void show() {
        dkh();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uz(boolean z) {
        if (z) {
            this.lEl.cyg();
        } else {
            this.lEl.endLoadData();
        }
    }

    public void hide() {
        if (dki()) {
            this.rootView.setVisibility(8);
            this.ghr.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        if (dki()) {
            this.ghr.setStatusBarVisibility(0);
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
    public void u(Runnable runnable) {
        if (dki()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(Runnable runnable) {
        if (dki()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lEi.getContext())[1]);
            this.lEm.setAlpha(0.0f);
            a(lEf, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dki()) {
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
            this.lEm.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lEh = i;
        if (dki()) {
            Fg(i);
        }
    }

    private void Fg(int i) {
        this.lEg = i;
        this.lEi.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.ghr.onChangeSkinType(this.lEi.getPageContext(), i);
        ao.setBackgroundResource(this.lEm, R.color.cp_bg_line_k_alpha40);
        this.lEj.onChangeSkinType(this.lEi.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lEk;
    }

    public NavigationBar bUz() {
        return this.ghr;
    }

    public View dkj() {
        return this.kDo;
    }

    public View dkk() {
        return this.lEm;
    }

    public boolean dkl() {
        if (this.lEk == null || this.lEk.getChildCount() <= 0) {
            return true;
        }
        if (this.lEk.getFirstVisiblePosition() <= 0) {
            View childAt = this.lEk.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dkm() {
        return this.lEl;
    }
}
