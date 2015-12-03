package com.baidu.tieba.themeCenter.bubble.group;

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
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.background.DressItemData;
import com.baidu.tieba.view.MemberBuyEntryButton;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView aWm;

    /* renamed from: com  reason: collision with root package name */
    private View f130com;
    private TextView con;
    private TextView dEA;
    private MemberRecommendView dEy;
    private MemberBuyEntryButton dEz;
    private BubbleGroupActivity dFD;
    private b dFG;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public g(BubbleGroupActivity bubbleGroupActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.topMargin = 0;
        this.dFD = bubbleGroupActivity;
        this.topMargin = k.d(bubbleGroupActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dFD.getPageContext().getPageActivity()).inflate(n.g.bubble_group, (ViewGroup) null);
        this.dFD.setContentView(this.mRoot);
        this.f130com = this.mRoot.findViewById(n.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.bubble);
        this.dEy = (MemberRecommendView) this.mRoot.findViewById(n.f.view_member_recommend);
        this.dEy.setFromType(4);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.listview_group);
        this.dEz = (MemberBuyEntryButton) this.mRoot.findViewById(n.f.bg_group_buy_member);
        this.con = new TextView(this.dFD.getActivity());
        this.con.setHeight(k.d(this.dFD.getActivity(), n.d.ds104));
        this.dEA = (TextView) LayoutInflater.from(this.dFD.getPageContext().getPageActivity()).inflate(n.g.look_more_view, (ViewGroup) null);
        this.dEA.setText(n.i.more_bubble);
        this.dEA.setOnClickListener(new h(this));
        this.dFG = new b(this.dFD.getPageContext(), aVar);
        this.mListView.addFooterView(this.dEA);
        this.mListView.setAdapter((ListAdapter) this.dFG);
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
            List<DressItemData> bubbleList = cVar.getBubbleList();
            int size = bubbleList.size();
            if (size != 0) {
                arrayList.add(cVar.getGroupName());
                if (size > 4) {
                    size = 4;
                }
                for (int i = 0; i < size; i = i + 1 + 1) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < 2; i2++) {
                        if (i + i2 < size) {
                            arrayList2.add(bubbleList.get(i + i2));
                        }
                    }
                    arrayList.add(arrayList2);
                }
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
        this.dFG.setData(list);
        this.dFG.notifyDataSetChanged();
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
        this.f130com.setVisibility(8);
        as.j(this.mRoot, n.c.cp_bg_line_d);
        String string = this.dFD.getPageContext().getResources().getString(n.i.no_data_text);
        this.dFD.setNetRefreshViewTopMargin(this.topMargin);
        this.dFD.showNetRefreshView(this.mRoot, string, false);
    }

    public void LZ() {
        as.j(this.mRoot, n.c.cp_bg_line_c);
        this.dFD.hideNetRefreshView(this.mRoot);
        this.f130com.setVisibility(0);
    }

    public void aFp() {
        this.f130com.setVisibility(8);
    }

    public void aFq() {
        this.f130com.setVisibility(0);
    }

    public void oV() {
        com.baidu.tbadk.i.a.a(this.dFD.getPageContext(), this.mRoot);
        com.baidu.tbadk.i.a.a(this.dFD.getPageContext(), this.dEA);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dFD.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dFD.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dFG != null) {
            this.dFG.notifyDataSetChanged();
        }
        this.dEz.onChangeSkinType(this.dFD.getPageContext(), TbadkApplication.getInst().getSkinType());
        as.j((View) this.con, n.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
