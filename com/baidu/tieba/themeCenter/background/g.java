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
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView aQP;
    private BackgroundGroupActivity deH;
    private View deN;
    private MemberRecommendView deO;
    private TextView deP;
    private TextView deQ;
    private b deR;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public g(BackgroundGroupActivity backgroundGroupActivity, i iVar) {
        this.topMargin = 0;
        this.deH = backgroundGroupActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundGroupActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.deH.getPageContext().getPageActivity()).inflate(i.g.background_group, (ViewGroup) null);
        this.deH.setContentView(this.mRoot);
        this.deN = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background);
        this.deO = (MemberRecommendView) this.mRoot.findViewById(i.f.view_member_recommend);
        this.deO.setFromType(4);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.listview_bg_group);
        this.deP = new TextView(this.deH.getActivity());
        this.deP.setHeight(com.baidu.adp.lib.util.k.d(this.deH.getActivity(), i.d.ds104));
        this.deQ = (TextView) LayoutInflater.from(this.deH.getPageContext().getPageActivity()).inflate(i.g.look_more_view, (ViewGroup) null);
        this.deQ.setText(i.h.more_backgrounds);
        this.deQ.setOnClickListener(new h(this));
        this.deR = new b(this.deH.getPageContext(), iVar);
        this.mListView.addFooterView(this.deQ);
        this.mListView.setAdapter((ListAdapter) this.deR);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list) {
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

    private List<Object> bz(List<c> list) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : list) {
            arrayList.add(cVar.getGroupName());
            List<DressItemData> backgroundList = cVar.getBackgroundList();
            int size = backgroundList.size();
            int i = size > 3 ? 3 : size;
            for (int i2 = 0; i2 < i; i2 = i2 + 2 + 1) {
                ArrayList arrayList2 = new ArrayList();
                for (int i3 = 0; i3 < 3; i3++) {
                    if (i2 + i3 < i) {
                        arrayList2.add(backgroundList.get(i2 + i3));
                    }
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    private void F(List<Object> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.deR.setData(list);
        this.deR.notifyDataSetChanged();
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
        String string = this.deH.getPageContext().getResources().getString(i.h.no_data_text);
        this.deH.setNetRefreshViewTopMargin(this.topMargin);
        this.deH.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ks() {
        am.j(this.mRoot, i.c.cp_bg_line_c);
        this.deH.hideNetRefreshView(this.mRoot);
        this.deN.setVisibility(0);
    }

    public void oO() {
        com.baidu.tbadk.h.a.a(this.deH.getPageContext(), this.mRoot);
        this.deH.getLayoutMode().k(this.deQ);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.deH.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.deH.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.deR != null) {
            this.deR.notifyDataSetChanged();
        }
        am.j((View) this.deP, i.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
