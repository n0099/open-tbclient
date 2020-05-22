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
import com.baidu.adp.widget.ListView.o;
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
    private View bGw;
    private g fkQ;
    private ForumHeaderView gQk;
    private RelativeLayout ldA;
    private View.OnClickListener ldB;
    private ForumSquareActivity ldw;
    private RelativeLayout ldx;
    private TextView ldy;
    private com.baidu.tieba.square.view.b ldz;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;

    public a(ForumSquareActivity forumSquareActivity) {
        this.ldw = forumSquareActivity;
        this.bGw = LayoutInflater.from(this.ldw).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        forumSquareActivity.setContentView(this.bGw);
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bGw.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.ldw.getString(R.string.forum_square));
        this.ldy = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.ldy.setText(this.ldw.getString(R.string.forum_square_create_bar));
        this.ldx = (RelativeLayout) this.bGw.findViewById(R.id.forum_header_serch_container);
        this.gQk = (ForumHeaderView) this.bGw.findViewById(R.id.forum_header_serch_view);
        this.gQk.setFrom(1);
        this.gQk.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.ldz = new com.baidu.tieba.square.view.b(this.ldw.getPageContext());
        this.ldA = (RelativeLayout) this.ldw.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public Pair<Integer, Integer> dbt() {
        return this.ldz != null ? this.ldz.dbt() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.ldz != null) {
            this.ldz.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0721a interfaceC0721a) {
        if (this.ldz != null) {
            this.ldz.a(interfaceC0721a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.ldz != null) {
            this.ldz.e(eVar);
        }
    }

    public void a(RecyclerView.OnScrollListener onScrollListener) {
        if (this.ldz != null) {
            this.ldz.a(onScrollListener);
        }
    }

    public String dbu() {
        return this.ldz.dbu();
    }

    public void b(String str, List<String> list, boolean z) {
        if (this.ldz != null) {
            this.ldz.b(str, list, z);
        }
    }

    public void ey(List<o> list) {
        if (this.ldz != null) {
            this.ldz.ey(list);
        }
    }

    public void q(List<o> list, int i) {
        if (this.ldz != null) {
            this.ldz.q(list, i);
        }
    }

    public void dbv() {
        if (this.ldz != null) {
            this.ldz.dbv();
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.ldy != null) {
            this.ldy.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.gQk != null) {
            this.gQk.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.ldw != null) {
            this.mNavigationBar.onChangeSkinType(this.ldw.getPageContext(), i);
        }
        if (this.ldz != null) {
            this.ldz.onChangeSkinType(i);
        }
        if (this.fkQ != null) {
            this.fkQ.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.ldw != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.ldw.getPageContext(), i);
        }
        am.setViewTextColor(this.ldy, R.color.cp_cont_b, 1);
        am.setBackgroundColor(this.bGw, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.ldx, R.color.cp_bg_line_h);
        am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.gQk != null) {
            this.gQk.setSearchHint(str);
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        this.ldB = onClickListener;
    }

    public void mq(boolean z) {
        if (!bPM()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.ldw, this.ldB);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.ldw, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.ldA, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean bPM() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void bqO() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.ldA);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.fkQ != null) {
            this.fkQ.dettachView(this.ldA);
            this.fkQ = null;
        }
    }

    public boolean bPL() {
        if (this.fkQ != null) {
            return this.fkQ.isViewAttached();
        }
        return false;
    }

    public void fV(boolean z) {
        if (!bPL()) {
            if (this.fkQ == null) {
                this.fkQ = new g(this.ldw);
                this.fkQ.setTopMargin(l.getDimens(this.ldw, R.dimen.ds250));
            }
            this.fkQ.onChangeSkinType();
            this.fkQ.attachView(this.ldA, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dbw() {
        hideLoadingView();
        hideNoDataView();
        mq(true);
        if (this.ldz != null) {
            this.ldz.Bs(8);
        }
    }

    public void dbx() {
        bqO();
        hideNoDataView();
        fV(true);
    }

    public void dby() {
        hideLoadingView();
        bqO();
        hideNoDataView();
        if (this.ldz != null) {
            this.ldz.hideLoadingView();
            this.ldz.Bs(0);
        }
    }

    public void dbz() {
        hideLoadingView();
        bqO();
        hideNoDataView();
        if (this.ldz != null) {
            this.ldz.fV(true);
            this.ldz.DH(8);
        }
    }

    public void dbA() {
        if (this.ldz != null) {
            this.ldz.dbA();
        }
    }

    public void dbB() {
        if (this.ldz != null) {
            this.ldz.dbB();
        }
    }

    public void dbC() {
        if (this.ldz != null) {
            this.ldz.dbC();
        }
    }

    public void brM() {
        if (this.ldz != null) {
            this.ldz.brM();
        }
    }

    public boolean uj(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dbC();
            } else {
                dbA();
            }
            return true;
        }
        dbB();
        return false;
    }
}
