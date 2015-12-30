package com.baidu.tieba.themeCenter.bubble.list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.r;
import com.baidu.tbadk.core.view.t;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView bam;
    private MemberRecommendView dMc;
    private BubbleListActivity dNo;
    private d dNt;
    private boolean dNu = false;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private t mPullView;
    private View mRoot;
    private int topMargin;

    public h(BubbleListActivity bubbleListActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.dNo = bubbleListActivity;
        this.topMargin = k.d(bubbleListActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dNo.getPageContext().getPageActivity()).inflate(n.h.bubble_list, (ViewGroup) null);
        this.dNo.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.bubble_all);
        this.dMc = (MemberRecommendView) this.mRoot.findViewById(n.g.view_member_recommend);
        this.dMc.setFromType(7);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.listview_bubble);
        this.mPullView = new t(this.dNo.getPageContext());
        this.mListView.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.dNo.getActivity());
        textView.setHeight(k.d(this.dNo.getActivity(), n.e.ds20));
        this.mListView.addFooterView(textView);
        this.dNt = new d(this.dNo.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dNt);
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
        b(kVar);
        H(bV(list));
    }

    private List<List<DressItemData>> bV(List<DressItemData> list) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i = i + 1 + 1) {
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < 2; i2++) {
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
        this.dNt.setData(list);
        this.dNt.notifyDataSetChanged();
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
        this.dMc.setVisibility(8);
        this.mListView.setVisibility(8);
        this.mRoot.setVisibility(8);
        as.j(this.mRoot, n.d.cp_bg_line_d);
        String string = this.dNo.getPageContext().getResources().getString(n.j.no_data_text);
        this.dNo.setNetRefreshViewTopMargin(this.topMargin);
        this.dNo.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ms() {
        as.j(this.mRoot, n.d.cp_bg_line_c);
        this.dNo.hideNetRefreshView(this.mRoot);
        this.dMc.setVisibility(0);
        this.mListView.setVisibility(0);
        this.mRoot.setVisibility(0);
    }

    public void aHJ() {
        this.mListView.completePullRefresh();
    }

    public void ot() {
        com.baidu.tbadk.i.a.a(this.dNo.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dNo.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dNo.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dNt != null) {
            this.dNt.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.cP(TbadkApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
