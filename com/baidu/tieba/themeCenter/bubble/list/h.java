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
import com.baidu.tbadk.core.view.q;
import com.baidu.tbadk.core.view.s;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.view.MemberBuyEntryButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView aWm;
    private MemberBuyEntryButton dEU;
    private MemberRecommendView dEy;
    private BubbleListActivity dFM;
    private d dFR;
    private boolean dFS = false;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private s mPullView;
    private View mRoot;
    private int topMargin;

    public h(BubbleListActivity bubbleListActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.mPullView = null;
        this.topMargin = 0;
        this.dFM = bubbleListActivity;
        this.topMargin = k.d(bubbleListActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dFM.getPageContext().getPageActivity()).inflate(n.g.bubble_list, (ViewGroup) null);
        this.dFM.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.bubble_all);
        this.dEy = (MemberRecommendView) this.mRoot.findViewById(n.f.view_member_recommend);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.listview_bubble);
        this.dEU = (MemberBuyEntryButton) this.mRoot.findViewById(n.f.root_bg_list_buy_member);
        this.mPullView = new s(this.dFM.getPageContext());
        this.mListView.setPullRefresh(this.mPullView);
        TextView textView = new TextView(this.dFM.getActivity());
        textView.setHeight(k.d(this.dFM.getActivity(), n.d.ds20));
        this.mListView.addFooterView(textView);
        this.dFR = new d(this.dFM.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dFR);
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
        b(kVar);
        G(bS(list));
    }

    private List<List<DressItemData>> bS(List<DressItemData> list) {
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

    private void G(List<List<DressItemData>> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dFR.setData(list);
        this.dFR.notifyDataSetChanged();
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
        this.dEy.setVisibility(8);
        this.mListView.setVisibility(8);
        this.mRoot.setVisibility(8);
        as.j(this.mRoot, n.c.cp_bg_line_d);
        String string = this.dFM.getPageContext().getResources().getString(n.i.no_data_text);
        this.dFM.setNetRefreshViewTopMargin(this.topMargin);
        this.dFM.showNetRefreshView(this.mRoot, string, false);
    }

    public void LZ() {
        as.j(this.mRoot, n.c.cp_bg_line_c);
        this.dFM.hideNetRefreshView(this.mRoot);
        this.dEy.setVisibility(0);
        this.mListView.setVisibility(0);
        this.mRoot.setVisibility(0);
    }

    public void aFu() {
        this.mListView.completePullRefresh();
    }

    public void oV() {
        com.baidu.tbadk.i.a.a(this.dFM.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dFM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dFM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dFR != null) {
            this.dFR.notifyDataSetChanged();
        }
        if (this.mPullView != null) {
            this.mPullView.cV(TbadkApplication.getInst().getSkinType());
        }
        this.dEU.onChangeSkinType(this.dFM.getPageContext(), TbadkApplication.getInst().getSkinType());
    }

    public View getRootView() {
        return this.mRoot;
    }
}
