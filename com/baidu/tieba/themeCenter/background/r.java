package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.p;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private NoNetworkView aRa;
    private BackgroundListActivity dfD;
    private n dfJ;
    private View dfn;
    private MemberRecommendView dfo;
    private TextView dfp;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.r mPullView;
    private View mRoot;
    private int topMargin;

    public r(BackgroundListActivity backgroundListActivity, i iVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.dfD = backgroundListActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dfD.getPageContext().getPageActivity()).inflate(i.g.background_list, (ViewGroup) null);
        this.dfD.setContentView(this.mRoot);
        this.dfn = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background_all);
        this.dfo = (MemberRecommendView) this.mRoot.findViewById(i.f.view_member_recommend);
        this.dfo.setFromType(5);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.dfD.getPageContext());
        this.mListView.setPullRefresh(this.mPullView);
        this.dfp = new TextView(this.dfD.getActivity());
        this.dfp.setHeight(com.baidu.adp.lib.util.k.d(this.dfD.getActivity(), i.d.ds104));
        this.dfJ = new n(this.dfD.getPageContext(), iVar);
        this.mListView.setAdapter((ListAdapter) this.dfJ);
    }

    public void a(BdListView.e eVar, p.a aVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
        this.mPullView.a(aVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        if (list == null || list.size() <= 0) {
            Kn();
            return;
        }
        Ko();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.dfp);
            this.mListView.addHeaderView(this.dfp);
        } else {
            this.mListView.removeHeaderView(this.dfp);
        }
        F(bA(list));
    }

    private List<List<DressItemData>> bA(List<DressItemData> list) {
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
        this.dfJ.setData(list);
        this.dfJ.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.azw())) {
            this.dfo.setVisibility(8);
            return false;
        }
        this.dfo.setVisibility(0);
        this.dfo.a(kVar);
        return true;
    }

    public void Kn() {
        this.dfn.setVisibility(8);
        an.j(this.mRoot, i.c.cp_bg_line_d);
        String string = this.dfD.getPageContext().getResources().getString(i.h.no_data_text);
        this.dfD.setNetRefreshViewTopMargin(this.topMargin);
        this.dfD.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ko() {
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.dfD.hideNetRefreshView(this.mRoot);
        this.dfn.setVisibility(0);
    }

    public void azu() {
        this.mListView.completePullRefresh();
    }

    public void oO() {
        com.baidu.tbadk.h.a.a(this.dfD.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dfD.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dfD.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dfJ != null) {
            this.dfJ.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.cN(TbadkApplication.getInst().getSkinType());
        }
        an.j((View) this.dfp, i.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
