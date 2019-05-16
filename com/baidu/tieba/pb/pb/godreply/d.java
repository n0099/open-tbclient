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
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.PbActivity;
import com.baidu.tieba.pb.pb.main.PbLandscapeListView;
/* loaded from: classes4.dex */
public class d {
    private static final int hDq = l.g(TbadkCoreApplication.getInst(), R.dimen.ds160);
    private NavigationBar cXY;
    private View contentView;
    private ViewStub hAl;
    private final PbActivity hCM;
    private NoNetworkView hDt;
    private PbLandscapeListView hDu;
    private b hDv;
    private View hDw;
    private View rootView;
    private int hDr = 3;
    private int hDs = 3;
    private View gIY = null;

    public d(PbActivity pbActivity, ViewStub viewStub) {
        this.hCM = pbActivity;
        this.hAl = viewStub;
    }

    private void init() {
        if (this.rootView != null) {
            this.hDu = (PbLandscapeListView) this.rootView.findViewById(R.id.more_god_reply_list);
            this.contentView = this.rootView.findViewById(R.id.more_god_reply_list_content);
            bob();
            this.hDw = this.rootView.findViewById(R.id.more_god_reply_back_curtain);
            this.hDt = (NoNetworkView) this.rootView.findViewById(R.id.more_god_reply_view_no_network);
            this.hDv = new b(this.hCM.getPageContext());
            this.hDu.setNextPage(this.hDv);
        }
    }

    private void bob() {
        this.cXY = (NavigationBar) this.rootView.findViewById(R.id.more_god_reply_nav_bar);
        this.gIY = this.cXY.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        ImageView backImageView = this.cXY.getBackImageView();
        if (backImageView != null && (backImageView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gIY.getLayoutParams();
            int g = l.g(this.hCM.getPageContext().getPageActivity(), R.dimen.ds30);
            layoutParams.height = g;
            layoutParams.width = g;
            backImageView.setLayoutParams(layoutParams);
        }
        if (this.gIY != null && (this.gIY.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gIY.getLayoutParams();
            layoutParams2.width = -2;
            layoutParams2.height = -1;
            this.gIY.setPadding(l.g(this.hCM.getPageContext().getPageActivity(), R.dimen.ds32), this.gIY.getPaddingTop(), this.gIY.getPaddingRight(), this.gIY.getPaddingBottom());
            this.gIY.setLayoutParams(layoutParams2);
        }
        this.cXY.setmBackImageViewBg(R.drawable.subpb_navigationbar_close, R.drawable.subpb_navigationbar_close);
    }

    public boolean isVisible() {
        return bQS() && this.rootView.getVisibility() == 0;
    }

    private void bQR() {
        if (!bQS()) {
            this.rootView = this.hAl.inflate();
            init();
            if (this.hDr != this.hDs) {
                xe(this.hDs);
            }
        }
    }

    public boolean bQS() {
        return this.rootView != null;
    }

    public void show() {
        bQR();
        if (!isVisible() && this.rootView != null) {
            this.rootView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void nV(boolean z) {
        if (z) {
            this.hDv.bgm();
        } else {
            this.hDv.ajz();
        }
    }

    public void hide() {
        if (bQS()) {
            this.rootView.setVisibility(8);
            this.cXY.setStatusBarVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(final Runnable runnable) {
        if (bQS()) {
            this.cXY.setStatusBarVisibility(0);
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
    public void r(Runnable runnable) {
        if (bQS()) {
            a(this.contentView.getHeight(), 0.0f, runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(Runnable runnable) {
        if (bQS()) {
            this.contentView.setTranslationY(l.aj(this.hCM)[1]);
            this.hDw.setAlpha(0.0f);
            a(hDq, 1.0f, runnable);
        }
    }

    private void a(float f, float f2, final Runnable runnable) {
        if (bQS()) {
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
            this.hDw.animate().alpha(f2).setDuration(300L).start();
        }
    }

    public void onChangeSkinType(int i) {
        this.hDs = i;
        if (bQS()) {
            xe(i);
        }
    }

    private void xe(int i) {
        this.hDr = i;
        this.hCM.getLayoutMode().onModeChanged(this.rootView);
        this.cXY.onChangeSkinType(this.hCM.getPageContext(), i);
        al.k(this.hDw, R.color.cp_bg_line_k_alpha40);
        this.hDt.onChangeSkinType(this.hCM.getPageContext(), i);
    }

    public BdTypeListView getListView() {
        return this.hDu;
    }

    public NavigationBar aJz() {
        return this.cXY;
    }

    public View bQT() {
        return this.gIY;
    }

    public View bQU() {
        return this.hDw;
    }

    public boolean bQV() {
        if (this.hDu == null || this.hDu.getChildCount() <= 0) {
            return true;
        }
        if (this.hDu.getFirstVisiblePosition() <= 0) {
            View childAt = this.hDu.getChildAt(0);
            return childAt != null && childAt.getTop() == 0;
        }
        return false;
    }

    public b bQW() {
        return this.hDv;
    }
}
