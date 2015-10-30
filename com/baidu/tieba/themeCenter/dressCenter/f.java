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
    private NoNetworkView aRa;
    private CoverFlowView<b> bcA;
    private MemberRecommendView dfo;
    private TextView dfp;
    private DressupCenterActivity dgm;
    private c dgn;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public f(DressupCenterActivity dressupCenterActivity) {
        this.topMargin = 0;
        this.dgm = dressupCenterActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(dressupCenterActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dgm.getPageContext().getPageActivity()).inflate(i.g.dressup_center_activity_layout, (ViewGroup) null);
        this.dgm.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.theme_center);
        this.aRa = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.dress_listview);
        this.bcA = (CoverFlowView) this.mRoot.findViewById(i.f.dressup_center_coverflowview);
        NW();
        this.dfo = (MemberRecommendView) this.mRoot.findViewById(i.f.dressup_center_recommend);
        this.dfo.setFromType(1);
        this.dgn = new c(this.dgm.getPageContext());
        this.dfp = new TextView(this.dgm.getActivity());
        this.dfp.setHeight(com.baidu.adp.lib.util.k.d(this.dgm.getActivity(), i.d.ds30));
        this.mListView.setAdapter((ListAdapter) this.dgn);
        this.mListView.setOnItemClickListener(new g(this));
    }

    public void a(List<b> list, k kVar, List<j> list2) {
        if ((list == null || list.size() <= 0) && ((kVar == null || StringUtils.isNull(kVar.azw())) && (list2 == null || list2.size() <= 0))) {
            Kn();
            return;
        }
        Ko();
        e(list2, bB(list) || b(kVar));
    }

    private boolean bB(List<b> list) {
        if (list == null || list.size() <= 0) {
            this.bcA.setVisibility(8);
            return false;
        }
        this.bcA.setVisibility(0);
        this.bcA.setData(list);
        return true;
    }

    private boolean b(k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.azw())) {
            this.dfo.setVisibility(8);
            return false;
        }
        this.dfo.setVisibility(0);
        this.dfo.a(kVar);
        return true;
    }

    private void e(List<j> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        if (z) {
            this.mListView.removeHeaderView(this.dfp);
            this.mListView.addHeaderView(this.dfp);
        } else {
            this.mListView.removeHeaderView(this.dfp);
        }
        this.mListView.setVisibility(0);
        this.dgn.setData(list);
        this.dgn.notifyDataSetChanged();
    }

    public void oO() {
        this.dgm.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dgm.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgm.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dgm.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bcA != null && this.bcA.getVisibility() == 0) {
            this.bcA.sZ();
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dgn != null) {
            this.dgn.notifyDataSetChanged();
        }
        if (this.dfo != null && this.dfo.getVisibility() == 0) {
            this.dfo.vx();
        }
        an.j((View) this.dfp, i.c.cp_bg_line_c);
    }

    public void Kn() {
        this.mListView.setVisibility(8);
        this.bcA.setVisibility(8);
        this.dfo.setVisibility(8);
        String string = this.dgm.getPageContext().getResources().getString(i.h.no_data_text);
        this.dgm.setNetRefreshViewTopMargin(this.topMargin);
        this.dgm.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ko() {
        this.dgm.hideNetRefreshView(this.mRoot);
        this.mListView.setVisibility(0);
        this.dfo.setVisibility(0);
        this.bcA.setVisibility(0);
    }

    private void NW() {
        if (this.bcA != null) {
            this.bcA.setCoverFlowFactory(new h(this));
            this.bcA.setCallback(new i(this));
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
