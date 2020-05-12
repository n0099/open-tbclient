package com.baidu.tieba.square;

import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.m;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.square.a.a;
import java.util.List;
/* loaded from: classes9.dex */
public class a {
    private View byT;
    private g eYg;
    private ForumHeaderView gBB;
    private ForumSquareActivity kLg;
    private RelativeLayout kLh;
    private TextView kLi;
    private com.baidu.tieba.square.view.b kLj;
    private RelativeLayout kLk;
    private View.OnClickListener kLl;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;

    public a(ForumSquareActivity forumSquareActivity) {
        this.kLg = forumSquareActivity;
        this.byT = LayoutInflater.from(this.kLg).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        forumSquareActivity.setContentView(this.byT);
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.byT.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kLg.getString(R.string.forum_square));
        this.kLi = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.kLi.setText(this.kLg.getString(R.string.forum_square_create_bar));
        this.kLh = (RelativeLayout) this.byT.findViewById(R.id.forum_header_serch_container);
        this.gBB = (ForumHeaderView) this.byT.findViewById(R.id.forum_header_serch_view);
        this.gBB.setFrom(1);
        this.gBB.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.kLj = new com.baidu.tieba.square.view.b(this.kLg.getPageContext());
        this.kLk = (RelativeLayout) this.kLg.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public Pair<Integer, Integer> cUp() {
        return this.kLj != null ? this.kLj.cUp() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.kLj != null) {
            this.kLj.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0668a interfaceC0668a) {
        if (this.kLj != null) {
            this.kLj.a(interfaceC0668a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.kLj != null) {
            this.kLj.e(eVar);
        }
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        if (this.kLj != null) {
            this.kLj.a(onScrollListener);
        }
    }

    public String cUq() {
        return this.kLj.cUq();
    }

    public void b(String str, List<String> list, boolean z) {
        if (this.kLj != null) {
            this.kLj.b(str, list, z);
        }
    }

    public void er(List<m> list) {
        if (this.kLj != null) {
            this.kLj.er(list);
        }
    }

    public void o(List<m> list, int i) {
        if (this.kLj != null) {
            this.kLj.o(list, i);
        }
    }

    public void cUr() {
        if (this.kLj != null) {
            this.kLj.cUr();
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.kLi != null) {
            this.kLi.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.gBB != null) {
            this.gBB.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.kLg != null) {
            this.mNavigationBar.onChangeSkinType(this.kLg.getPageContext(), i);
        }
        if (this.kLj != null) {
            this.kLj.onChangeSkinType(i);
        }
        if (this.eYg != null) {
            this.eYg.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.kLg != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.kLg.getPageContext(), i);
        }
        am.setViewTextColor(this.kLi, R.color.cp_cont_b, 1);
        am.setBackgroundColor(this.byT, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.kLh, R.color.cp_bg_line_h);
        am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.gBB != null) {
            this.gBB.setSearchHint(str);
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kLl = onClickListener;
    }

    public void lV(boolean z) {
        if (!bJt()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.kLg, this.kLl);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.kLg, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.kLk, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean bJt() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void blr() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kLk);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.eYg != null) {
            this.eYg.dettachView(this.kLk);
            this.eYg = null;
        }
    }

    public boolean bJs() {
        if (this.eYg != null) {
            return this.eYg.isViewAttached();
        }
        return false;
    }

    public void fK(boolean z) {
        if (!bJs()) {
            if (this.eYg == null) {
                this.eYg = new g(this.kLg);
                this.eYg.setTopMargin(l.getDimens(this.kLg, R.dimen.ds250));
            }
            this.eYg.onChangeSkinType();
            this.eYg.attachView(this.kLk, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cUs() {
        hideLoadingView();
        hideNoDataView();
        lV(true);
        if (this.kLj != null) {
            this.kLj.AH(8);
        }
    }

    public void cUt() {
        blr();
        hideNoDataView();
        fK(true);
    }

    public void cUu() {
        hideLoadingView();
        blr();
        hideNoDataView();
        if (this.kLj != null) {
            this.kLj.hideLoadingView();
            this.kLj.AH(0);
        }
    }

    public void cUv() {
        hideLoadingView();
        blr();
        hideNoDataView();
        if (this.kLj != null) {
            this.kLj.fK(true);
            this.kLj.CX(8);
        }
    }

    public void cUw() {
        if (this.kLj != null) {
            this.kLj.cUw();
        }
    }

    public void cUx() {
        if (this.kLj != null) {
            this.kLj.cUx();
        }
    }

    public void cUy() {
        if (this.kLj != null) {
            this.kLj.cUy();
        }
    }

    public void bmo() {
        if (this.kLj != null) {
            this.kLj.bmo();
        }
    }

    public boolean tL(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                cUy();
            } else {
                cUw();
            }
            return true;
        }
        cUx();
        return false;
    }
}
