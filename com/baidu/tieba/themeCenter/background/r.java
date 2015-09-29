package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private NoNetworkView aQP;
    private View deN;
    private MemberRecommendView deO;
    private TextView deP;
    private BackgroundListActivity dfd;
    private n dfj;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.r mPullView;
    private View mRoot;
    private int topMargin;

    public r(BackgroundListActivity backgroundListActivity, i iVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.dfd = backgroundListActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dfd.getPageContext().getPageActivity()).inflate(i.g.background_list, (ViewGroup) null);
        this.dfd.setContentView(this.mRoot);
        this.deN = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background_all);
        this.deO = (MemberRecommendView) this.mRoot.findViewById(i.f.view_member_recommend);
        this.deO.setFromType(5);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.dfd.getPageContext());
        this.mListView.setPullRefresh(this.mPullView);
        this.deP = new TextView(this.dfd.getActivity());
        this.deP.setHeight(com.baidu.adp.lib.util.k.d(this.dfd.getActivity(), i.d.ds104));
        this.dfj = new n(this.dfd.getPageContext(), iVar);
        this.mListView.setAdapter((ListAdapter) this.dfj);
    }

    public void a(BdListView.e eVar, p.a aVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
        this.mPullView.a(aVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        if (list == null || list.size() <= 0) {
            Kr();
            return;
        }
        Ks();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.deP);
            this.mListView.addHeaderView(this.deP);
        } else {
            this.mListView.removeHeaderView(this.deP);
        }
        F(bz(list));
    }

    private List<List<DressItemData>> bz(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i = i + 2 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 3; i2++) {
                if (i + i2 < size) {
                    arrayList2.add(list.get(i + i2));
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    private void F(List<List<DressItemData>> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dfj.setData(list);
        this.dfj.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.azq())) {
            this.deO.setVisibility(8);
            return false;
        }
        this.deO.setVisibility(0);
        this.deO.a(kVar);
        return true;
    }

    public void Kr() {
        this.deN.setVisibility(8);
        am.j(this.mRoot, i.c.cp_bg_line_d);
        String string = this.dfd.getPageContext().getResources().getString(i.h.no_data_text);
        this.dfd.setNetRefreshViewTopMargin(this.topMargin);
        this.dfd.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ks() {
        am.j(this.mRoot, i.c.cp_bg_line_c);
        this.dfd.hideNetRefreshView(this.mRoot);
        this.deN.setVisibility(0);
    }

    public void azo() {
        this.mListView.completePullRefresh();
    }

    public void oO() {
        com.baidu.tbadk.h.a.a(this.dfd.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dfd.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.dfd.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dfj != null) {
            this.dfj.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.cN(TbadkApplication.getInst().getSkinType());
        }
        am.j((View) this.deP, i.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
