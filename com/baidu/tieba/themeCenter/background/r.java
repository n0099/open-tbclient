package com.baidu.tieba.themeCenter.background;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.q;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.view.MemberBuyEntryButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private NoNetworkView aWm;

    /* renamed from: com  reason: collision with root package name */
    private View f129com;
    private TextView con;
    private BackgroundListActivity dEM;
    private MemberBuyEntryButton dEU;
    private n dEV;
    private MemberRecommendView dEy;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.s mPullView;
    private View mRoot;
    private int topMargin;

    public r(BackgroundListActivity backgroundListActivity, i iVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.dEM = backgroundListActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundListActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dEM.getPageContext().getPageActivity()).inflate(n.g.background_list, (ViewGroup) null);
        this.dEM.setContentView(this.mRoot);
        this.f129com = this.mRoot.findViewById(n.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.personal_background_all);
        this.dEy = (MemberRecommendView) this.mRoot.findViewById(n.f.view_member_recommend);
        this.dEy.setFromType(5);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.listview_bg_list);
        this.dEU = (MemberBuyEntryButton) this.mRoot.findViewById(n.f.root_bg_list_buy_member);
        this.mPullView = new com.baidu.tbadk.core.view.s(this.dEM.getPageContext());
        this.mListView.setPullRefresh(this.mPullView);
        this.con = new TextView(this.dEM.getActivity());
        this.con.setHeight(com.baidu.adp.lib.util.k.d(this.dEM.getActivity(), n.d.ds104));
        this.dEV = new n(this.dEM.getPageContext(), iVar);
        this.mListView.setAdapter((ListAdapter) this.dEV);
    }

    public void a(BdListView.e eVar, q.a aVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
        this.mPullView.a(aVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            LY();
            return;
        }
        LZ();
        this.dEU.show(z);
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.con);
            this.mListView.addHeaderView(this.con);
        } else {
            this.mListView.removeHeaderView(this.con);
        }
        G(bS(list));
    }

    private List<List<DressItemData>> bS(List<DressItemData> list) {
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

    private void G(List<List<DressItemData>> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dEV.setData(list);
        this.dEV.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aFw())) {
            this.dEy.setVisibility(8);
            return false;
        }
        this.dEy.setVisibility(0);
        this.dEy.a(kVar);
        return true;
    }

    public void LY() {
        this.f129com.setVisibility(8);
        as.j(this.mRoot, n.c.cp_bg_line_d);
        String string = this.dEM.getPageContext().getResources().getString(n.i.no_data_text);
        this.dEM.setNetRefreshViewTopMargin(this.topMargin);
        this.dEM.showNetRefreshView(this.mRoot, string, false);
    }

    public void LZ() {
        as.j(this.mRoot, n.c.cp_bg_line_c);
        this.dEM.hideNetRefreshView(this.mRoot);
        this.f129com.setVisibility(0);
    }

    public void aFu() {
        this.mListView.completePullRefresh();
    }

    public void oV() {
        com.baidu.tbadk.i.a.a(this.dEM.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dEM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dEM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dEV != null) {
            this.dEV.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.cV(TbadkApplication.getInst().getSkinType());
        }
        this.dEU.onChangeSkinType(this.dEM.getPageContext(), TbadkApplication.getInst().getSkinType());
        as.j((View) this.con, n.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
