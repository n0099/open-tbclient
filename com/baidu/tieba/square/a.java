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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.k.g;
import com.baidu.tbadk.k.h;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.view.ForumHeaderView;
import com.baidu.tieba.square.a.a;
import java.util.List;
/* loaded from: classes16.dex */
public class a {
    private View bLG;
    private g fBv;
    private ForumHeaderView hiO;
    private ForumSquareActivity lFT;
    private RelativeLayout lFU;
    private TextView lFV;
    private com.baidu.tieba.square.view.b lFW;
    private RelativeLayout lFX;
    private View.OnClickListener lFY;
    private NavigationBar mNavigationBar;
    private NoDataView mNoDataView;
    private h mRefreshView;

    public a(ForumSquareActivity forumSquareActivity) {
        this.lFT = forumSquareActivity;
        this.bLG = LayoutInflater.from(this.lFT).inflate(R.layout.forum_square_activity, (ViewGroup) null);
        forumSquareActivity.setContentView(this.bLG);
        initUI();
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) this.bLG.findViewById(R.id.navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setCenterTextTitle(this.lFT.getString(R.string.forum_square));
        this.lFV = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.navigation_right_button_layout, (View.OnClickListener) null).findViewById(R.id.right_textview);
        this.lFV.setText(this.lFT.getString(R.string.forum_square_create_bar));
        this.lFU = (RelativeLayout) this.bLG.findViewById(R.id.forum_header_serch_container);
        this.hiO = (ForumHeaderView) this.bLG.findViewById(R.id.forum_header_serch_view);
        this.hiO.setFrom(1);
        this.hiO.setSearchHint(TbSingleton.getInstance().getHotSearch());
        this.lFW = new com.baidu.tieba.square.view.b(this.lFT.getPageContext());
        this.lFX = (RelativeLayout) this.lFT.findViewById(R.id.layout_container);
        changeSkinType(TbadkCoreApplication.getInst().getSkinType());
    }

    public Pair<Integer, Integer> djh() {
        return this.lFW != null ? this.lFW.djh() : new Pair<>(0, 0);
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        if (this.lFW != null) {
            this.lFW.scrollToPositionWithOffset(i, i2);
        }
    }

    public void a(a.InterfaceC0748a interfaceC0748a) {
        if (this.lFW != null) {
            this.lFW.a(interfaceC0748a);
        }
    }

    public void e(BdListView.e eVar) {
        if (this.lFW != null) {
            this.lFW.e(eVar);
        }
    }

    public void b(RecyclerView.OnScrollListener onScrollListener) {
        if (this.lFW != null) {
            this.lFW.b(onScrollListener);
        }
    }

    public String dji() {
        return this.lFW.dji();
    }

    public void b(String str, List<String> list, boolean z) {
        if (this.lFW != null) {
            this.lFW.b(str, list, z);
        }
    }

    public void eU(List<q> list) {
        if (this.lFW != null) {
            this.lFW.eU(list);
        }
    }

    public void p(List<q> list, int i) {
        if (this.lFW != null) {
            this.lFW.p(list, i);
        }
    }

    public void djj() {
        if (this.lFW != null) {
            this.lFW.djj();
        }
    }

    public void ag(View.OnClickListener onClickListener) {
        if (this.lFV != null) {
            this.lFV.setOnClickListener(onClickListener);
        }
    }

    public void changeSkinType(int i) {
        if (this.hiO != null) {
            this.hiO.onChangeSkinType();
        }
        if (this.mNavigationBar != null && this.lFT != null) {
            this.mNavigationBar.onChangeSkinType(this.lFT.getPageContext(), i);
        }
        if (this.lFW != null) {
            this.lFW.onChangeSkinType(i);
        }
        if (this.fBv != null) {
            this.fBv.onChangeSkinType();
        }
        if (this.mRefreshView != null) {
            this.mRefreshView.onChangeSkinType();
        }
        if (this.mNoDataView != null && this.lFT != null) {
            this.mNoDataView.setSubTitleTextColor(R.color.cp_cont_b);
            this.mNoDataView.onChangeSkinType(this.lFT.getPageContext(), i);
        }
        ao.setViewTextColor(this.lFV, R.color.cp_cont_b, 1);
        ao.setBackgroundColor(this.bLG, R.color.cp_bg_line_e);
        ao.setBackgroundColor(this.lFU, R.color.cp_bg_line_h);
        ao.setBackgroundColor(this.mNavigationBar, R.color.cp_bg_line_h, i);
    }

    public void setSearchHint(String str) {
        if (this.hiO != null) {
            this.hiO.setSearchHint(str);
        }
    }

    public void ah(View.OnClickListener onClickListener) {
        this.lFY = onClickListener;
    }

    public void ng(boolean z) {
        if (!bWj()) {
            if (this.mRefreshView == null) {
                this.mRefreshView = new h(this.lFT, this.lFY);
                this.mRefreshView.setLayoutMargin(l.getDimens(this.lFT, R.dimen.ds250));
            }
            this.mRefreshView.attachView(this.lFX, z);
            this.mRefreshView.showRefreshButton();
        }
    }

    private boolean bWj() {
        if (this.mRefreshView != null) {
            return this.mRefreshView.isViewAttached();
        }
        return false;
    }

    public void bwX() {
        if (this.mRefreshView != null) {
            this.mRefreshView.dettachView(this.lFX);
            this.mRefreshView = null;
        }
    }

    public void hideLoadingView() {
        if (this.fBv != null) {
            this.fBv.dettachView(this.lFX);
            this.fBv = null;
        }
    }

    public boolean bWi() {
        if (this.fBv != null) {
            return this.fBv.isViewAttached();
        }
        return false;
    }

    public void gw(boolean z) {
        if (!bWi()) {
            if (this.fBv == null) {
                this.fBv = new g(this.lFT);
                this.fBv.setTopMargin(l.getDimens(this.lFT, R.dimen.ds250));
            }
            this.fBv.onChangeSkinType();
            this.fBv.attachView(this.lFX, z);
        }
    }

    public void hideNoDataView() {
        if (this.mNoDataView != null) {
            this.mNoDataView.setVisibility(8);
        }
    }

    public void djk() {
        hideLoadingView();
        hideNoDataView();
        ng(true);
        if (this.lFW != null) {
            this.lFW.CW(8);
        }
    }

    public void djl() {
        bwX();
        hideNoDataView();
        gw(true);
    }

    public void djm() {
        hideLoadingView();
        bwX();
        hideNoDataView();
        if (this.lFW != null) {
            this.lFW.hideLoadingView();
            this.lFW.CW(0);
        }
    }

    public void djn() {
        hideLoadingView();
        bwX();
        hideNoDataView();
        if (this.lFW != null) {
            this.lFW.gw(true);
            this.lFW.Fh(8);
        }
    }

    public void djo() {
        if (this.lFW != null) {
            this.lFW.djo();
        }
    }

    public void djp() {
        if (this.lFW != null) {
            this.lFW.djp();
        }
    }

    public void djq() {
        if (this.lFW != null) {
            this.lFW.djq();
        }
    }

    public void bxU() {
        if (this.lFW != null) {
            this.lFW.bxU();
        }
    }

    public boolean vc(boolean z) {
        if (z) {
            if (j.isNetWorkAvailable()) {
                djq();
            } else {
                djo();
            }
            return true;
        }
        djp();
        return false;
    }
}
