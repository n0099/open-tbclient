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
    private g flb;
    private ForumHeaderView gQv;
    private ForumSquareActivity leG;
    private RelativeLayout leH;
    private TextView leI;
    private com.baidu.tieba.square.view.b leJ;
    private RelativeLayout leK;
    private View.OnClickListener leL;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;

    public a(ForumSquareActivity forumSquareActivity) {
        this.leG = forumSquareActivity;
        this.bGw = LayoutInflater.from(this.leG).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        forumSquareActivity.setContentView(this.bGw);
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bGw.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.leG.getString(R.string.forum_square));
        this.leI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.leI.setText(this.leG.getString(R.string.forum_square_create_bar));
        this.leH = (RelativeLayout) this.bGw.findViewById(R.id.forum_header_serch_container);
        this.gQv = (ForumHeaderView) this.bGw.findViewById(R.id.forum_header_serch_view);
        this.gQv.setFrom(1);
        this.gQv.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.leJ = new com.baidu.tieba.square.view.b(this.leG.getPageContext());
        this.leK = (RelativeLayout) this.leG.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public Pair<Integer, Integer> dbI() {
        return this.leJ != null ? this.leJ.dbI() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.leJ != null) {
            this.leJ.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0722a interfaceC0722a) {
        if (this.leJ != null) {
            this.leJ.a(interfaceC0722a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.leJ != null) {
            this.leJ.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.leJ != null) {
            this.leJ.b(onScrollListener);
        }
    }

    public String dbJ() {
        return this.leJ.dbJ();
    }

    public void b(String str, List<String> list, boolean z) {
        if (this.leJ != null) {
            this.leJ.b(str, list, z);
        }
    }

    public void eA(List<o> list) {
        if (this.leJ != null) {
            this.leJ.eA(list);
        }
    }

    public void q(List<o> list, int i) {
        if (this.leJ != null) {
            this.leJ.q(list, i);
        }
    }

    public void dbK() {
        if (this.leJ != null) {
            this.leJ.dbK();
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.leI != null) {
            this.leI.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.gQv != null) {
            this.gQv.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.leG != null) {
            this.mNavigationBar.onChangeSkinType(this.leG.getPageContext(), i);
        }
        if (this.leJ != null) {
            this.leJ.onChangeSkinType(i);
        }
        if (this.flb != null) {
            this.flb.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.leG != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.leG.getPageContext(), i);
        }
        am.setViewTextColor(this.leI, R.color.cp_cont_b, 1);
        am.setBackgroundColor(this.bGw, R.color.cp_bg_line_e);
        am.setBackgroundColor(this.leH, R.color.cp_bg_line_h);
        am.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.gQv != null) {
            this.gQv.setSearchHint(str);
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        this.leL = onClickListener;
    }

    public void mq(boolean z) {
        if (!bPO()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.leG, this.leL);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.leG, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.leK, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean bPO() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void bqQ() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.leK);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.flb != null) {
            this.flb.dettachView(this.leK);
            this.flb = null;
        }
    }

    public boolean bPN() {
        if (this.flb != null) {
            return this.flb.isViewAttached();
        }
        return false;
    }

    public void fV(boolean z) {
        if (!bPN()) {
            if (this.flb == null) {
                this.flb = new g(this.leG);
                this.flb.setTopMargin(l.getDimens(this.leG, R.dimen.ds250));
            }
            this.flb.onChangeSkinType();
            this.flb.attachView(this.leK, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dbL() {
        hideLoadingView();
        hideNoDataView();
        mq(true);
        if (this.leJ != null) {
            this.leJ.Bu(8);
        }
    }

    public void dbM() {
        bqQ();
        hideNoDataView();
        fV(true);
    }

    public void dbN() {
        hideLoadingView();
        bqQ();
        hideNoDataView();
        if (this.leJ != null) {
            this.leJ.hideLoadingView();
            this.leJ.Bu(0);
        }
    }

    public void dbO() {
        hideLoadingView();
        bqQ();
        hideNoDataView();
        if (this.leJ != null) {
            this.leJ.fV(true);
            this.leJ.DJ(8);
        }
    }

    public void dbP() {
        if (this.leJ != null) {
            this.leJ.dbP();
        }
    }

    public void dbQ() {
        if (this.leJ != null) {
            this.leJ.dbQ();
        }
    }

    public void dbR() {
        if (this.leJ != null) {
            this.leJ.dbR();
        }
    }

    public void brO() {
        if (this.leJ != null) {
            this.leJ.brO();
        }
    }

    public boolean uj(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dbR();
            } else {
                dbP();
            }
            return true;
        }
        dbQ();
        return false;
    }
}
