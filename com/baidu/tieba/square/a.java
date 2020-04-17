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
    private View byO;
    private g eYb;
    private ForumHeaderView gBv;
    private ForumSquareActivity kLc;
    private RelativeLayout kLd;
    private TextView kLe;
    private com.baidu.tieba.square.view.b kLf;
    private RelativeLayout kLg;
    private View.OnClickListener kLh;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;

    public a(ForumSquareActivity forumSquareActivity) {
        this.kLc = forumSquareActivity;
        this.byO = LayoutInflater.from(this.kLc).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        forumSquareActivity.setContentView(this.byO);
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.byO.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.kLc.getString(R.string.forum_square));
        this.kLe = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.kLe.setText(this.kLc.getString(R.string.forum_square_create_bar));
        this.kLd = (RelativeLayout) this.byO.findViewById(R.id.forum_header_serch_container);
        this.gBv = (ForumHeaderView) this.byO.findViewById(R.id.forum_header_serch_view);
        this.gBv.setFrom(1);
        this.gBv.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.kLf = new com.baidu.tieba.square.view.b(this.kLc.getPageContext());
        this.kLg = (RelativeLayout) this.kLc.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public Pair<Integer, Integer> cUr() {
        return this.kLf != null ? this.kLf.cUr() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.kLf != null) {
            this.kLf.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0647a interfaceC0647a) {
        if (this.kLf != null) {
            this.kLf.a(interfaceC0647a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.kLf != null) {
            this.kLf.e(eVar);
        }
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        if (this.kLf != null) {
            this.kLf.a(onScrollListener);
        }
    }

    public String cUs() {
        return this.kLf.cUs();
    }

    public void b(String str, List<String> list, boolean z) {
        if (this.kLf != null) {
            this.kLf.b(str, list, z);
        }
    }

    public void er(List<m> list) {
        if (this.kLf != null) {
            this.kLf.er(list);
        }
    }

    public void o(List<m> list, int i) {
        if (this.kLf != null) {
            this.kLf.o(list, i);
        }
    }

    public void cUt() {
        if (this.kLf != null) {
            this.kLf.cUt();
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.kLe != null) {
            this.kLe.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.gBv != null) {
            this.gBv.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.kLc != null) {
            this.mNavigationBar.onChangeSkinType(this.kLc.getPageContext(), i);
        }
        if (this.kLf != null) {
            this.kLf.onChangeSkinType(i);
        }
        if (this.eYb != null) {
            this.eYb.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.kLc != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.kLc.getPageContext(), i);
        }
        am.setViewTextColor(this.kLe, R.color.cp_cont_b, 1);
        am.setBackgroundColor(this.byO, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.kLd, R.color.cp_bg_line_h);
        am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.gBv != null) {
            this.gBv.setSearchHint(str);
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        this.kLh = onClickListener;
    }

    public void lV(boolean z) {
        if (!bJu()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.kLc, this.kLh);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.kLc, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.kLg, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean bJu() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void blt() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.kLg);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.eYb != null) {
            this.eYb.dettachView(this.kLg);
            this.eYb = null;
        }
    }

    public boolean bJt() {
        if (this.eYb != null) {
            return this.eYb.isViewAttached();
        }
        return false;
    }

    public void fK(boolean z) {
        if (!bJt()) {
            if (this.eYb == null) {
                this.eYb = new g(this.kLc);
                this.eYb.setTopMargin(l.getDimens(this.kLc, R.dimen.ds250));
            }
            this.eYb.onChangeSkinType();
            this.eYb.attachView(this.kLg, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void cUu() {
        hideLoadingView();
        hideNoDataView();
        lV(true);
        if (this.kLf != null) {
            this.kLf.AH(8);
        }
    }

    public void cUv() {
        blt();
        hideNoDataView();
        fK(true);
    }

    public void cUw() {
        hideLoadingView();
        blt();
        hideNoDataView();
        if (this.kLf != null) {
            this.kLf.hideLoadingView();
            this.kLf.AH(0);
        }
    }

    public void cUx() {
        hideLoadingView();
        blt();
        hideNoDataView();
        if (this.kLf != null) {
            this.kLf.fK(true);
            this.kLf.CX(8);
        }
    }

    public void cUy() {
        if (this.kLf != null) {
            this.kLf.cUy();
        }
    }

    public void cUz() {
        if (this.kLf != null) {
            this.kLf.cUz();
        }
    }

    public void cUA() {
        if (this.kLf != null) {
            this.kLf.cUA();
        }
    }

    public void bmq() {
        if (this.kLf != null) {
            this.kLf.bmq();
        }
    }

    public boolean tL(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                cUA();
            } else {
                cUy();
            }
            return true;
        }
        cUz();
        return false;
    }
}
