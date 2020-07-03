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
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
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
    private View bLk;
    private g fwo;
    private ForumHeaderView hde;
    private ForumSquareActivity lyD;
    private RelativeLayout lyE;
    private TextView lyF;
    private com.baidu.tieba.square.view.b lyG;
    private RelativeLayout lyH;
    private View.OnClickListener lyI;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;

    public a(ForumSquareActivity forumSquareActivity) {
        this.lyD = forumSquareActivity;
        this.bLk = LayoutInflater.from(this.lyD).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        forumSquareActivity.setContentView(this.bLk);
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bLk.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lyD.getString(R.string.forum_square));
        this.lyF = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.lyF.setText(this.lyD.getString(R.string.forum_square_create_bar));
        this.lyE = (RelativeLayout) this.bLk.findViewById(R.id.forum_header_serch_container);
        this.hde = (ForumHeaderView) this.bLk.findViewById(R.id.forum_header_serch_view);
        this.hde.setFrom(1);
        this.hde.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.lyG = new com.baidu.tieba.square.view.b(this.lyD.getPageContext());
        this.lyH = (RelativeLayout) this.lyD.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public Pair<Integer, Integer> dfX() {
        return this.lyG != null ? this.lyG.dfX() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lyG != null) {
            this.lyG.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0738a interfaceC0738a) {
        if (this.lyG != null) {
            this.lyG.a(interfaceC0738a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.lyG != null) {
            this.lyG.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lyG != null) {
            this.lyG.b(onScrollListener);
        }
    }

    public String dfY() {
        return this.lyG.dfY();
    }

    public void b(String str, List<String> list, boolean z) {
        if (this.lyG != null) {
            this.lyG.b(str, list, z);
        }
    }

    public void eO(List<q> list) {
        if (this.lyG != null) {
            this.lyG.eO(list);
        }
    }

    public void r(List<q> list, int i) {
        if (this.lyG != null) {
            this.lyG.r(list, i);
        }
    }

    public void dfZ() {
        if (this.lyG != null) {
            this.lyG.dfZ();
        }
    }

    public void af(View.OnClickListener onClickListener) {
        if (this.lyF != null) {
            this.lyF.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.hde != null) {
            this.hde.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.lyD != null) {
            this.mNavigationBar.onChangeSkinType(this.lyD.getPageContext(), i);
        }
        if (this.lyG != null) {
            this.lyG.onChangeSkinType(i);
        }
        if (this.fwo != null) {
            this.fwo.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.lyD != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.lyD.getPageContext(), i);
        }
        an.setViewTextColor(this.lyF, R.color.cp_cont_b, 1);
        an.setBackgroundColor(this.bLk, R.color.cp_bg_line_e);
        an.setBackgroundColor(this.lyE, R.color.cp_bg_line_h);
        an.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.hde != null) {
            this.hde.setSearchHint(str);
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        this.lyI = onClickListener;
    }

    public void mB(boolean z) {
        if (!bSR()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.lyD, this.lyI);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.lyD, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.lyH, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean bSR() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void btN() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lyH);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.fwo != null) {
            this.fwo.dettachView(this.lyH);
            this.fwo = null;
        }
    }

    public boolean bSQ() {
        if (this.fwo != null) {
            return this.fwo.isViewAttached();
        }
        return false;
    }

    public void ga(boolean z) {
        if (!bSQ()) {
            if (this.fwo == null) {
                this.fwo = new g(this.lyD);
                this.fwo.setTopMargin(l.getDimens(this.lyD, R.dimen.ds250));
            }
            this.fwo.onChangeSkinType();
            this.fwo.attachView(this.lyH, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void dga() {
        hideLoadingView();
        hideNoDataView();
        mB(true);
        if (this.lyG != null) {
            this.lyG.Cw(8);
        }
    }

    public void dgb() {
        btN();
        hideNoDataView();
        ga(true);
    }

    public void dgc() {
        hideLoadingView();
        btN();
        hideNoDataView();
        if (this.lyG != null) {
            this.lyG.hideLoadingView();
            this.lyG.Cw(0);
        }
    }

    public void dgd() {
        hideLoadingView();
        btN();
        hideNoDataView();
        if (this.lyG != null) {
            this.lyG.ga(true);
            this.lyG.EL(8);
        }
    }

    public void dge() {
        if (this.lyG != null) {
            this.lyG.dge();
        }
    }

    public void dgf() {
        if (this.lyG != null) {
            this.lyG.dgf();
        }
    }

    public void dgg() {
        if (this.lyG != null) {
            this.lyG.dgg();
        }
    }

    public void buK() {
        if (this.lyG != null) {
            this.lyG.buK();
        }
    }

    public boolean uy(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                dgg();
            } else {
                dge();
            }
            return true;
        }
        dgf();
        return false;
    }
}
