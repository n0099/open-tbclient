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
    private static final int lIK = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private View contentView;
    private NavigationBar glZ;
    private ViewStub lEW;
    private PbFragment lIN;
    private NoNetworkView lIO;
    private PbLandscapeListView lIP;
    private b lIQ;
    private View lIR;
    private View rootView;
    private int lIL = 3;
    private int lIM = 3;
    private View kHT = null;

    public d(PbFragment pbFragment, ViewStub viewStub) {
        this.lIN = pbFragment;
        this.lEW = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.lIP = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            cKY();
            this.lIR = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.lIO = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.lIQ = new b(this.lIN.getPageContext());
            this.lIP.setNextPage(this.lIQ);
        }
    }

    private void cKY() {
        this.glZ = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.kHT = this.glZ.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.glZ.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.kHT.getLayoutParams();
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds30);
            layoutParams.height = dimens;
            layoutParams.width = dimens;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.kHT != null && (this.kHT.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.kHT.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.kHT.setPadding(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds32), this.kHT.getPaddingTop(), this.kHT.getPaddingRight(), this.kHT.getPaddingBottom());
            this.kHT.setLayoutParams(layoutParams2);
        }
        if (this.glZ.getBackImageView() != null) {
            SvgManager.bwr().a(this.glZ.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
    }

    public boolean isVisible() {
        return dob() && this.rootView.getVisibility() == 0;
    }

    private void doa() {
        if (!dob()) {
            this.rootView = this.lEW.inflate();
            init();
            if (this.lIL != this.lIM) {
                GM(this.lIM);
            }
        }
    }

    public boolean dob() {
        return this.rootView != null;
    }

    public void show() {
        doa();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void uD(boolean z) {
        if (z) {
            this.lIQ.cBY();
        } else {
            this.lIQ.endLoadData();
        }
    }

    public void hide() {
        if (dob()) {
            this.rootView.setVisibility(8);
            this.glZ.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(final Runnable runnable) {
        if (dob()) {
            this.glZ.setStatusBarVisibility(0);
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
        if (dob()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v(Runnable runnable) {
        if (dob()) {
            this.contentView.setTranslationY(l.getScreenDimensions(this.lIN.getContext())[1]);
            this.lIR.setAlpha(0.0f);
            a(lIK, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (dob()) {
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
            this.lIR.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.lIM = i;
        if (dob()) {
            GM(i);
        }
    }

    private void GM(int i) {
        this.lIL = i;
        this.lIN.getBaseFragmentActivity().getLayoutMode().onModeChanged(this.rootView);
        this.glZ.onChangeSkinType(this.lIN.getPageContext(), i);
        ao.setBackgroundResource(this.lIR, R.color.cp_bg_line_k_alpha40);
        this.lIO.onChangeSkinType(this.lIN.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.lIP;
    }

    public NavigationBar bYr() {
        return this.glZ;
    }

    public View doc() {
        return this.kHT;
    }

    public View dod() {
        return this.lIR;
    }

    public boolean doe() {
        if (this.lIP == null || this.lIP.getChildCount() <= 0) {
            return true;
        }
        if (this.lIP.getFirstVisiblePosition() <= 0) {
            View childAt = this.lIP.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b dof() {
        return this.lIQ;
    }
}
