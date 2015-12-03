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
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.view.MemberBuyEntryButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView aWm;

    /* renamed from: com  reason: collision with root package name */
    private View f128com;
    private TextView con;
    private TextView dEA;
    private b dEB;
    private BackgroundGroupActivity dEt;
    private MemberRecommendView dEy;
    private MemberBuyEntryButton dEz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public g(BackgroundGroupActivity backgroundGroupActivity, i iVar) {
        this.topMargin = 0;
        this.dEt = backgroundGroupActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundGroupActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dEt.getPageContext().getPageActivity()).inflate(n.g.background_group, (ViewGroup) null);
        this.dEt.setContentView(this.mRoot);
        this.f128com = this.mRoot.findViewById(n.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.personal_background);
        this.dEy = (MemberRecommendView) this.mRoot.findViewById(n.f.view_member_recommend);
        this.dEy.setFromType(4);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.listview_bg_group);
        this.dEz = (MemberBuyEntryButton) this.mRoot.findViewById(n.f.bg_group_buy_member);
        this.con = new TextView(this.dEt.getActivity());
        this.con.setHeight(com.baidu.adp.lib.util.k.d(this.dEt.getActivity(), n.d.ds104));
        this.dEA = (TextView) LayoutInflater.from(this.dEt.getPageContext().getPageActivity()).inflate(n.g.look_more_view, (ViewGroup) null);
        this.dEA.setText(n.i.more_backgrounds);
        this.dEA.setOnClickListener(new h(this));
        this.dEB = new b(this.dEt.getPageContext(), iVar);
        this.mListView.addFooterView(this.dEA);
        this.mListView.setAdapter((ListAdapter) this.dEB);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list, boolean z) {
        if (list == null || list.size() <= 0) {
            LY();
            return;
        }
        LZ();
        this.dEz.show(z);
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.con);
            this.mListView.addHeaderView(this.con);
        } else {
            this.mListView.removeHeaderView(this.con);
        }
        G(bS(list));
    }

    private List<Object> bS(List<c> list) {
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

    private void G(List<Object> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dEB.setData(list);
        this.dEB.notifyDataSetChanged();
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
        this.f128com.setVisibility(8);
        as.j(this.mRoot, n.c.cp_bg_line_d);
        String string = this.dEt.getPageContext().getResources().getString(n.i.no_data_text);
        this.dEt.setNetRefreshViewTopMargin(this.topMargin);
        this.dEt.showNetRefreshView(this.mRoot, string, false);
    }

    public void LZ() {
        as.j(this.mRoot, n.c.cp_bg_line_c);
        this.dEt.hideNetRefreshView(this.mRoot);
        this.f128com.setVisibility(0);
    }

    public void aFp() {
        this.f128com.setVisibility(8);
    }

    public void aFq() {
        this.f128com.setVisibility(0);
    }

    public void oV() {
        com.baidu.tbadk.i.a.a(this.dEt.getPageContext(), this.mRoot);
        this.dEt.getLayoutMode().k(this.dEA);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dEt.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dEt.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dEB != null) {
            this.dEB.notifyDataSetChanged();
        }
        this.dEz.onChangeSkinType(this.dEt.getPageContext(), TbadkApplication.getInst().getSkinType());
        as.j((View) this.con, n.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
