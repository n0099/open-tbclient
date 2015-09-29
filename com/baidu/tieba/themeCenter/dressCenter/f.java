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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private NoNetworkView aQP;
    private CoverFlowView<b> bcp;
    private MemberRecommendView deO;
    private TextView deP;
    private DressupCenterActivity dfM;
    private c dfN;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public f(DressupCenterActivity dressupCenterActivity) {
        this.topMargin = 0;
        this.dfM = dressupCenterActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(dressupCenterActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dfM.getPageContext().getPageActivity()).inflate(i.g.dressup_center_activity_layout, (ViewGroup) null);
        this.dfM.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.theme_center);
        this.aQP = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.dress_listview);
        this.bcp = (CoverFlowView) this.mRoot.findViewById(i.f.dressup_center_coverflowview);
        Oa();
        this.deO = (MemberRecommendView) this.mRoot.findViewById(i.f.dressup_center_recommend);
        this.deO.setFromType(1);
        this.dfN = new c(this.dfM.getPageContext());
        this.deP = new TextView(this.dfM.getActivity());
        this.deP.setHeight(com.baidu.adp.lib.util.k.d(this.dfM.getActivity(), i.d.ds30));
        this.mListView.setAdapter((ListAdapter) this.dfN);
        this.mListView.setOnItemClickListener(new g(this));
    }

    public void a(List<b> list, k kVar, List<j> list2) {
        if ((list == null || list.size() <= 0) && ((kVar == null || StringUtils.isNull(kVar.azq())) && (list2 == null || list2.size() <= 0))) {
            Kr();
            return;
        }
        Ks();
        e(list2, bA(list) || b(kVar));
    }

    private boolean bA(List<b> list) {
        if (list == null || list.size() <= 0) {
            this.bcp.setVisibility(8);
            return false;
        }
        this.bcp.setVisibility(0);
        this.bcp.setData(list);
        return true;
    }

    private boolean b(k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.azq())) {
            this.deO.setVisibility(8);
            return false;
        }
        this.deO.setVisibility(0);
        this.deO.a(kVar);
        return true;
    }

    private void e(List<j> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        if (z) {
            this.mListView.removeHeaderView(this.deP);
            this.mListView.addHeaderView(this.deP);
        } else {
            this.mListView.removeHeaderView(this.deP);
        }
        this.mListView.setVisibility(0);
        this.dfN.setData(list);
        this.dfN.notifyDataSetChanged();
    }

    public void oO() {
        this.dfM.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dfM.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dfM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.dfM.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bcp != null && this.bcp.getVisibility() == 0) {
            this.bcp.tc();
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dfN != null) {
            this.dfN.notifyDataSetChanged();
        }
        if (this.deO != null && this.deO.getVisibility() == 0) {
            this.deO.vA();
        }
        am.j((View) this.deP, i.c.cp_bg_line_c);
    }

    public void Kr() {
        this.mListView.setVisibility(8);
        this.bcp.setVisibility(8);
        this.deO.setVisibility(8);
        String string = this.dfM.getPageContext().getResources().getString(i.h.no_data_text);
        this.dfM.setNetRefreshViewTopMargin(this.topMargin);
        this.dfM.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ks() {
        this.dfM.hideNetRefreshView(this.mRoot);
        this.mListView.setVisibility(0);
        this.deO.setVisibility(0);
        this.bcp.setVisibility(0);
    }

    private void Oa() {
        if (this.bcp != null) {
            this.bcp.setCoverFlowFactory(new h(this));
            this.bcp.setCallback(new i(this));
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
