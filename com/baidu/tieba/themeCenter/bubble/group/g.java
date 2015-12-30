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
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class g {
    private NoNetworkView bam;
    private View csp;
    private TextView csq;
    private MemberRecommendView dMc;
    private TextView dMd;
    private BubbleGroupActivity dNf;
    private b dNi;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public g(BubbleGroupActivity bubbleGroupActivity, com.baidu.tieba.themeCenter.bubble.all.a aVar) {
        this.topMargin = 0;
        this.dNf = bubbleGroupActivity;
        this.topMargin = k.d(bubbleGroupActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dNf.getPageContext().getPageActivity()).inflate(n.h.bubble_group, (ViewGroup) null);
        this.dNf.setContentView(this.mRoot);
        this.csp = this.mRoot.findViewById(n.g.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.bubble);
        this.dMc = (MemberRecommendView) this.mRoot.findViewById(n.g.view_member_recommend);
        this.dMc.setFromType(6);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.listview_group);
        this.csq = new TextView(this.dNf.getActivity());
        this.csq.setHeight(k.d(this.dNf.getActivity(), n.e.ds104));
        this.dMd = (TextView) LayoutInflater.from(this.dNf.getPageContext().getPageActivity()).inflate(n.h.look_more_view, (ViewGroup) null);
        this.dMd.setText(n.j.more_bubble);
        this.dMd.setOnClickListener(new h(this));
        this.dNi = new b(this.dNf.getPageContext(), aVar);
        this.mListView.addFooterView(this.dMd);
        this.mListView.setAdapter((ListAdapter) this.dNi);
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

    private void H(List<Object> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dNi.setData(list);
        this.dNi.notifyDataSetChanged();
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
        String string = this.dNf.getPageContext().getResources().getString(n.j.no_data_text);
        this.dNf.setNetRefreshViewTopMargin(this.topMargin);
        this.dNf.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ms() {
        as.j(this.mRoot, n.d.cp_bg_line_c);
        this.dNf.hideNetRefreshView(this.mRoot);
        this.csp.setVisibility(0);
    }

    public void aHE() {
        this.csp.setVisibility(8);
    }

    public void aHF() {
        this.csp.setVisibility(0);
    }

    public void ot() {
        com.baidu.tbadk.i.a.a(this.dNf.getPageContext(), this.mRoot);
        com.baidu.tbadk.i.a.a(this.dNf.getPageContext(), this.dMd);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dNf.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dNf.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dNi != null) {
            this.dNi.notifyDataSetChanged();
        }
        as.j((View) this.csq, n.d.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
