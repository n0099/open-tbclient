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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView bam;
    private View csp;
    private TextView csq;
    private BackgroundGroupActivity dLX;
    private MemberRecommendView dMc;
    private TextView dMd;
    private b dMe;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public g(BackgroundGroupActivity backgroundGroupActivity, i iVar) {
        this.topMargin = 0;
        this.dLX = backgroundGroupActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundGroupActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dLX.getPageContext().getPageActivity()).inflate(n.h.background_group, (ViewGroup) null);
        this.dLX.setContentView(this.mRoot);
        this.csp = this.mRoot.findViewById(n.g.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.personal_background);
        this.dMc = (MemberRecommendView) this.mRoot.findViewById(n.g.view_member_recommend);
        this.dMc.setFromType(4);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.listview_bg_group);
        this.csq = new TextView(this.dLX.getActivity());
        this.csq.setHeight(com.baidu.adp.lib.util.k.d(this.dLX.getActivity(), n.e.ds104));
        this.dMd = (TextView) LayoutInflater.from(this.dLX.getPageContext().getPageActivity()).inflate(n.h.look_more_view, (ViewGroup) null);
        this.dMd.setText(n.j.more_backgrounds);
        this.dMd.setOnClickListener(new h(this));
        this.dMe = new b(this.dLX.getPageContext(), iVar);
        this.mListView.addFooterView(this.dMd);
        this.mListView.setAdapter((ListAdapter) this.dMe);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list, boolean z) {
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

    private List<Object> bV(List<c> list) {
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

    private void H(List<Object> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dMe.setData(list);
        this.dMe.notifyDataSetChanged();
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
        String string = this.dLX.getPageContext().getResources().getString(n.j.no_data_text);
        this.dLX.setNetRefreshViewTopMargin(this.topMargin);
        this.dLX.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ms() {
        as.j(this.mRoot, n.d.cp_bg_line_c);
        this.dLX.hideNetRefreshView(this.mRoot);
        this.csp.setVisibility(0);
    }

    public void aHE() {
        this.csp.setVisibility(8);
    }

    public void aHF() {
        this.csp.setVisibility(0);
    }

    public void ot() {
        com.baidu.tbadk.i.a.a(this.dLX.getPageContext(), this.mRoot);
        this.dLX.getLayoutMode().k(this.dMd);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dLX.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dLX.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dMe != null) {
            this.dMe.notifyDataSetChanged();
        }
        as.j((View) this.csq, n.d.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
