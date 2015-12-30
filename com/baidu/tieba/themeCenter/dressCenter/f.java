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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private NoNetworkView bam;
    private CoverFlowView<b> bnB;
    private TextView csq;
    private MemberRecommendView dMc;
    private DressupCenterActivity dNC;
    private c dND;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public f(DressupCenterActivity dressupCenterActivity) {
        this.topMargin = 0;
        this.dNC = dressupCenterActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(dressupCenterActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dNC.getPageContext().getPageActivity()).inflate(n.h.dressup_center_activity_layout, (ViewGroup) null);
        this.dNC.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.theme_center);
        this.bam = (NoNetworkView) this.mRoot.findViewById(n.g.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.dress_listview);
        this.bnB = (CoverFlowView) this.mRoot.findViewById(n.g.dressup_center_coverflowview);
        Qq();
        this.dMc = (MemberRecommendView) this.mRoot.findViewById(n.g.dressup_center_recommend);
        this.dMc.setFromType(1);
        this.dND = new c(this.dNC.getPageContext());
        this.csq = new TextView(this.dNC.getActivity());
        this.csq.setHeight(com.baidu.adp.lib.util.k.d(this.dNC.getActivity(), n.e.ds30));
        this.mListView.setAdapter((ListAdapter) this.dND);
        this.mListView.setOnItemClickListener(new g(this));
    }

    public void a(List<b> list, k kVar, List<j> list2, boolean z) {
        if ((list == null || list.size() <= 0) && ((kVar == null || StringUtils.isNull(kVar.aHL())) && (list2 == null || list2.size() <= 0))) {
            Mr();
            return;
        }
        Ms();
        e(list2, bW(list) || b(kVar));
    }

    private boolean bW(List<b> list) {
        if (list == null || list.size() <= 0) {
            this.bnB.setVisibility(8);
            return false;
        }
        this.bnB.setVisibility(0);
        this.bnB.setData(list);
        return true;
    }

    private boolean b(k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aHL())) {
            this.dMc.setVisibility(8);
            return false;
        }
        this.dMc.setVisibility(0);
        this.dMc.a(kVar);
        return true;
    }

    private void e(List<j> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        if (z) {
            this.mListView.removeHeaderView(this.csq);
            this.mListView.addHeaderView(this.csq);
        } else {
            this.mListView.removeHeaderView(this.csq);
        }
        this.mListView.setVisibility(0);
        this.dND.setData(list);
        this.dND.notifyDataSetChanged();
    }

    public void ot() {
        this.dNC.getLayoutMode().ac(TbadkApplication.getInst().getSkinType() == 1);
        this.dNC.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dNC.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dNC.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bnB != null && this.bnB.getVisibility() == 0) {
            this.bnB.tr();
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dND != null) {
            this.dND.notifyDataSetChanged();
        }
        if (this.dMc != null && this.dMc.getVisibility() == 0) {
            this.dMc.vR();
        }
        as.j((View) this.csq, n.d.cp_bg_line_c);
    }

    public void Mr() {
        this.mListView.setVisibility(8);
        this.bnB.setVisibility(8);
        this.dMc.setVisibility(8);
        String string = this.dNC.getPageContext().getResources().getString(n.j.no_data_text);
        this.dNC.setNetRefreshViewTopMargin(this.topMargin);
        this.dNC.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ms() {
        this.dNC.hideNetRefreshView(this.mRoot);
        this.mListView.setVisibility(0);
        this.dMc.setVisibility(0);
        this.bnB.setVisibility(0);
    }

    private void Qq() {
        if (this.bnB != null) {
            this.bnB.setCoverFlowFactory(new h(this));
            this.bnB.setCallback(new i(this));
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
