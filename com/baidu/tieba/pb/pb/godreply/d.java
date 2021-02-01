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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes2.dex */
public class d {
    private static final int lMU = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar gjF;
    private ViewStub lJe;
    private PbFragment lMX;
    private NoNetworkView lMY;
    private PbLandscapeListView lMZ;
    private b lNa;
    private View lNb;
    private View rootView;
    private int lMV = 3;
    private int lMW = 3;
    private View kLt = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lMX = pbFragment;
        this.lJe = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lMZ = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cIt();
            this.lNb = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lMY = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lNa = new b(this.lMX.getPageContext());
            this.lMZ.setNextPage(this.lNa);
        }
    }

    private void cIt() {
        this.gjF = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kLt = this.gjF.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.gjF.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kLt.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kLt != null && (this.kLt.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kLt.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kLt.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kLt.getPaddingTop(), this.kLt.getPaddingRight(), this.kLt.getPaddingBottom());
            this.kLt.setLayoutParams(layoutParams2);
        }
        if (this.gjF.getBackImageView() != null) {
            SvgManager.bsR().a(this.gjF.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dmv() && this.rootView.getVisibility() == 0;
    }

    private void dmu() {
        if (!dmv()) {
            this.rootView = this.lJe.inflate();
            init();
            if (this.lMV != this.lMW) {
                Fz(this.lMW);
            }
        }
    }

    public boolean dmv() {
        return this.rootView != null;
    }

    public void show() {
        dmu();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uN(boolean z) {
        if (z) {
            this.lNa.czr();
        } else {
            this.lNa.endLoadData();
        }
    }

    public void hide() {
        if (dmv()) {
            this.rootView.setVisibility(8);
            this.gjF.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void r(final Runnable runnable) {
        if (dmv()) {
            this.gjF.setStatusBarVisibility(0);
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
    public void s(Runnable runnable) {
        if (dmv()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(Runnable runnable) {
        if (dmv()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lMX.getContext())[1]);
            this.lNb.setAlpha(0.0f);
            a(lMU, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dmv()) {
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
            this.lNb.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lMW = i;
        if (dmv()) {
            Fz(i);
        }
    }

    private void Fz(int i) {
        this.lMV = i;
        this.lMX.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.gjF.onChangeSkinType(this.lMX.getPageContext(), i);
        ap.setBackgroundResource(this.lNb, R.color.cp_bg_line_k_alpha40);
        this.lMY.onChangeSkinType(this.lMX.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lMZ;
    }

    public NavigationBar bVd() {
        return this.gjF;
    }

    public View dmw() {
        return this.kLt;
    }

    public View dmx() {
        return this.lNb;
    }

    public boolean dmy() {
        if (this.lMZ == null || this.lMZ.getChildCount() <= 0) {
            return true;
        }
        if (this.lMZ.getFirstVisiblePosition() <= 0) {
            View childAt = this.lMZ.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dmz() {
        return this.lNa;
    }
}
