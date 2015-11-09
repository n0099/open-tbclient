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
    private NoNetworkView aRi;
    private View dgT;
    private MemberRecommendView dgU;
    private TextView dgV;
    private BackgroundListActivity dhj;
    private n dhp;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.r mPullView;
    private View mRoot;
    private int topMargin;

    public r(BackgroundListActivity backgroundListActivity, i iVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.dhj = backgroundListActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dhj.getPageContext().getPageActivity()).inflate(i.g.background_list, (ViewGroup) null);
        this.dhj.setContentView(this.mRoot);
        this.dgT = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background_all);
        this.dgU = (MemberRecommendView) this.mRoot.findViewById(i.f.view_member_recommend);
        this.dgU.setFromType(5);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.r(this.dhj.getPageContext());
        this.mListView.setPullRefresh(this.mPullView);
        this.dgV = new TextView(this.dhj.getActivity());
        this.dgV.setHeight(com.baidu.adp.lib.util.k.d(this.dhj.getActivity(), i.d.ds104));
        this.dhp = new n(this.dhj.getPageContext(), iVar);
        this.mListView.setAdapter((ListAdapter) this.dhp);
    }

    public void a(BdListView.e eVar, p.a aVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
        this.mPullView.a(aVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list) {
        if (list == null || list.size() <= 0) {
            KD();
            return;
        }
        KE();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.dgV);
            this.mListView.addHeaderView(this.dgV);
        } else {
            this.mListView.removeHeaderView(this.dgV);
        }
        G(bE(list));
    }

    private List<List<DressItemData>> bE(List<DressItemData> list) {
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
        this.dhp.setData(list);
        this.dhp.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aAm())) {
            this.dgU.setVisibility(8);
            return false;
        }
        this.dgU.setVisibility(0);
        this.dgU.a(kVar);
        return true;
    }

    public void KD() {
        this.dgT.setVisibility(8);
        an.j(this.mRoot, i.c.cp_bg_line_d);
        String string = this.dhj.getPageContext().getResources().getString(i.h.no_data_text);
        this.dhj.setNetRefreshViewTopMargin(this.topMargin);
        this.dhj.showNetRefreshView(this.mRoot, string, false);
    }

    public void KE() {
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.dhj.hideNetRefreshView(this.mRoot);
        this.dgT.setVisibility(0);
    }

    public void aAk() {
        this.mListView.completePullRefresh();
    }

    public void oP() {
        com.baidu.tbadk.h.a.a(this.dhj.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dhj.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.dhj.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dhp != null) {
            this.dhp.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.cN(TbadkApplication.getInst().getSkinType());
        }
        an.j((View) this.dgV, i.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
