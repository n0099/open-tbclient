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
import com.baidu.tbadk.core.view.r;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r {
    private NoNetworkView bam;
    private View csp;
    private TextView csq;
    private MemberRecommendView dMc;
    private BackgroundListActivity dMp;
    private n dMx;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private com.baidu.tbadk.core.view.t mPullView;
    private View mRoot;
    private int topMargin;

    public r(BackgroundListActivity backgroundListActivity, i iVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.dMp = backgroundListActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundListActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dMp.getPageContext().getPageActivity()).inflate(n.h.background_list, (ViewGroup) null);
        this.dMp.setContentView(this.mRoot);
        this.csp = this.mRoot.findViewById(n.g.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.personal_background_all);
        this.dMc = (MemberRecommendView) this.mRoot.findViewById(n.g.view_member_recommend);
        this.dMc.setFromType(5);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.listview_bg_list);
        this.mPullView = new com.baidu.tbadk.core.view.t(this.dMp.getPageContext());
        this.mListView.setPullRefresh(this.mPullView);
        this.csq = new TextView(this.dMp.getActivity());
        this.csq.setHeight(com.baidu.adp.lib.util.k.d(this.dMp.getActivity(), n.e.ds104));
        this.dMx = new n(this.dMp.getPageContext(), iVar);
        this.mListView.setAdapter((ListAdapter) this.dMx);
    }

    public void a(BdListView.e eVar, r.a aVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
        this.mPullView.a(aVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<DressItemData> list, boolean z) {
        if (list == null || list.size() <= 0) {
            Mr();
            return;
        }
        Ms();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.csq);
            this.mListView.addHeaderView(this.csq);
        } else {
            this.mListView.removeHeaderView(this.csq);
        }
        H(bV(list));
    }

    private List<List<DressItemData>> bV(List<DressItemData> list) {
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

    private void H(List<List<DressItemData>> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dMx.setData(list);
        this.dMx.notifyDataSetChanged();
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aHL())) {
            this.dMc.setVisibility(8);
            return false;
        }
        this.dMc.setVisibility(0);
        this.dMc.a(kVar);
        return true;
    }

    public void Mr() {
        this.csp.setVisibility(8);
        as.j(this.mRoot, n.d.cp_bg_line_d);
        String string = this.dMp.getPageContext().getResources().getString(n.j.no_data_text);
        this.dMp.setNetRefreshViewTopMargin(this.topMargin);
        this.dMp.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ms() {
        as.j(this.mRoot, n.d.cp_bg_line_c);
        this.dMp.hideNetRefreshView(this.mRoot);
        this.csp.setVisibility(0);
    }

    public void aHJ() {
        this.mListView.completePullRefresh();
    }

    public void ot() {
        com.baidu.tbadk.i.a.a(this.dMp.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dMp.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dMp.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dMx != null) {
            this.dMx.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.cP(TbadkApplication.getInst().getSkinType());
        }
        as.j((View) this.csq, n.d.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
