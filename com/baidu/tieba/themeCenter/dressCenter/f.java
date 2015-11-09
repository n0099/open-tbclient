package com.baidu.tieba.themeCenter.dressCenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private NoNetworkView aRi;
    private CoverFlowView<b> bdf;
    private MemberRecommendView dgU;
    private TextView dgV;
    private DressupCenterActivity dhS;
    private c dhT;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public f(DressupCenterActivity dressupCenterActivity) {
        this.topMargin = 0;
        this.dhS = dressupCenterActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(dressupCenterActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dhS.getPageContext().getPageActivity()).inflate(i.g.dressup_center_activity_layout, (ViewGroup) null);
        this.dhS.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.theme_center);
        this.aRi = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.dress_listview);
        this.bdf = (CoverFlowView) this.mRoot.findViewById(i.f.dressup_center_coverflowview);
        Os();
        this.dgU = (MemberRecommendView) this.mRoot.findViewById(i.f.dressup_center_recommend);
        this.dgU.setFromType(1);
        this.dhT = new c(this.dhS.getPageContext());
        this.dgV = new TextView(this.dhS.getActivity());
        this.dgV.setHeight(com.baidu.adp.lib.util.k.d(this.dhS.getActivity(), i.d.ds30));
        this.mListView.setAdapter((ListAdapter) this.dhT);
        this.mListView.setOnItemClickListener(new g(this));
    }

    public void a(List<b> list, k kVar, List<j> list2) {
        if ((list == null || list.size() <= 0) && ((kVar == null || StringUtils.isNull(kVar.aAm())) && (list2 == null || list2.size() <= 0))) {
            KD();
            return;
        }
        KE();
        e(list2, bF(list) || b(kVar));
    }

    private boolean bF(List<b> list) {
        if (list == null || list.size() <= 0) {
            this.bdf.setVisibility(8);
            return false;
        }
        this.bdf.setVisibility(0);
        this.bdf.setData(list);
        return true;
    }

    private boolean b(k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aAm())) {
            this.dgU.setVisibility(8);
            return false;
        }
        this.dgU.setVisibility(0);
        this.dgU.a(kVar);
        return true;
    }

    private void e(List<j> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        if (z) {
            this.mListView.removeHeaderView(this.dgV);
            this.mListView.addHeaderView(this.dgV);
        } else {
            this.mListView.removeHeaderView(this.dgV);
        }
        this.mListView.setVisibility(0);
        this.dhT.setData(list);
        this.dhT.notifyDataSetChanged();
    }

    public void oP() {
        this.dhS.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dhS.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dhS.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.dhS.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bdf != null && this.bdf.getVisibility() == 0) {
            this.bdf.tc();
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dhT != null) {
            this.dhT.notifyDataSetChanged();
        }
        if (this.dgU != null && this.dgU.getVisibility() == 0) {
            this.dgU.vB();
        }
        an.j((View) this.dgV, i.c.cp_bg_line_c);
    }

    public void KD() {
        this.mListView.setVisibility(8);
        this.bdf.setVisibility(8);
        this.dgU.setVisibility(8);
        String string = this.dhS.getPageContext().getResources().getString(i.h.no_data_text);
        this.dhS.setNetRefreshViewTopMargin(this.topMargin);
        this.dhS.showNetRefreshView(this.mRoot, string, false);
    }

    public void KE() {
        this.dhS.hideNetRefreshView(this.mRoot);
        this.mListView.setVisibility(0);
        this.dgU.setVisibility(0);
        this.bdf.setVisibility(0);
    }

    private void Os() {
        if (this.bdf != null) {
            this.bdf.setCoverFlowFactory(new h(this));
            this.bdf.setCallback(new i(this));
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
