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
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView aRa;
    private BackgroundGroupActivity dfh;
    private View dfn;
    private MemberRecommendView dfo;
    private TextView dfp;
    private TextView dfq;
    private b dfr;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public g(BackgroundGroupActivity backgroundGroupActivity, i iVar) {
        this.topMargin = 0;
        this.dfh = backgroundGroupActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundGroupActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dfh.getPageContext().getPageActivity()).inflate(i.g.background_group, (ViewGroup) null);
        this.dfh.setContentView(this.mRoot);
        this.dfn = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background);
        this.dfo = (MemberRecommendView) this.mRoot.findViewById(i.f.view_member_recommend);
        this.dfo.setFromType(4);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.listview_bg_group);
        this.dfp = new TextView(this.dfh.getActivity());
        this.dfp.setHeight(com.baidu.adp.lib.util.k.d(this.dfh.getActivity(), i.d.ds104));
        this.dfq = (TextView) LayoutInflater.from(this.dfh.getPageContext().getPageActivity()).inflate(i.g.look_more_view, (ViewGroup) null);
        this.dfq.setText(i.h.more_backgrounds);
        this.dfq.setOnClickListener(new h(this));
        this.dfr = new b(this.dfh.getPageContext(), iVar);
        this.mListView.addFooterView(this.dfq);
        this.mListView.setAdapter((ListAdapter) this.dfr);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list) {
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

    private List<Object> bA(List<c> list) {
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
        this.dfr.setData(list);
        this.dfr.notifyDataSetChanged();
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
        String string = this.dfh.getPageContext().getResources().getString(i.h.no_data_text);
        this.dfh.setNetRefreshViewTopMargin(this.topMargin);
        this.dfh.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ko() {
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.dfh.hideNetRefreshView(this.mRoot);
        this.dfn.setVisibility(0);
    }

    public void oO() {
        com.baidu.tbadk.h.a.a(this.dfh.getPageContext(), this.mRoot);
        this.dfh.getLayoutMode().k(this.dfq);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dfh.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dfh.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dfr != null) {
            this.dfr.notifyDataSetChanged();
        }
        an.j((View) this.dfp, i.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
