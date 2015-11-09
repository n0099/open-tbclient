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
    private NoNetworkView aRi;
    private BackgroundGroupActivity dgN;
    private View dgT;
    private MemberRecommendView dgU;
    private TextView dgV;
    private TextView dgW;
    private b dgX;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public g(BackgroundGroupActivity backgroundGroupActivity, i iVar) {
        this.topMargin = 0;
        this.dgN = backgroundGroupActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(backgroundGroupActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dgN.getPageContext().getPageActivity()).inflate(i.g.background_group, (ViewGroup) null);
        this.dgN.setContentView(this.mRoot);
        this.dgT = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.personal_background);
        this.dgU = (MemberRecommendView) this.mRoot.findViewById(i.f.view_member_recommend);
        this.dgU.setFromType(4);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.listview_bg_group);
        this.dgV = new TextView(this.dgN.getActivity());
        this.dgV.setHeight(com.baidu.adp.lib.util.k.d(this.dgN.getActivity(), i.d.ds104));
        this.dgW = (TextView) LayoutInflater.from(this.dgN.getPageContext().getPageActivity()).inflate(i.g.look_more_view, (ViewGroup) null);
        this.dgW.setText(i.h.more_backgrounds);
        this.dgW.setOnClickListener(new h(this));
        this.dgX = new b(this.dgN.getPageContext(), iVar);
        this.mListView.addFooterView(this.dgW);
        this.mListView.setAdapter((ListAdapter) this.dgX);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<c> list) {
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

    private List<Object> bE(List<c> list) {
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
        this.dgX.setData(list);
        this.dgX.notifyDataSetChanged();
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
        String string = this.dgN.getPageContext().getResources().getString(i.h.no_data_text);
        this.dgN.setNetRefreshViewTopMargin(this.topMargin);
        this.dgN.showNetRefreshView(this.mRoot, string, false);
    }

    public void KE() {
        an.j(this.mRoot, i.c.cp_bg_line_c);
        this.dgN.hideNetRefreshView(this.mRoot);
        this.dgT.setVisibility(0);
    }

    public void oP() {
        com.baidu.tbadk.h.a.a(this.dgN.getPageContext(), this.mRoot);
        this.dgN.getLayoutMode().k(this.dgW);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgN.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.dgN.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dgX != null) {
            this.dgX.notifyDataSetChanged();
        }
        an.j((View) this.dgV, i.c.cp_bg_line_c);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
