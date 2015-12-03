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
import com.baidu.tieba.view.MemberBuyEntryButton;
import java.util.List;
/* loaded from: classes.dex */
public class f {
    private NoNetworkView aWm;
    private CoverFlowView<b> bjK;
    private TextView con;
    private MemberRecommendView dEy;
    private DressupCenterActivity dGa;
    private MemberBuyEntryButton dGb;
    private c dGc;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public f(DressupCenterActivity dressupCenterActivity) {
        this.topMargin = 0;
        this.dGa = dressupCenterActivity;
        this.topMargin = com.baidu.adp.lib.util.k.d(dressupCenterActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dGa.getPageContext().getPageActivity()).inflate(n.g.dressup_center_activity_layout, (ViewGroup) null);
        this.dGa.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.theme_center);
        this.dGb = (MemberBuyEntryButton) this.mRoot.findViewById(n.f.dress_buy_member);
        this.aWm = (NoNetworkView) this.mRoot.findViewById(n.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.dress_listview);
        this.bjK = (CoverFlowView) this.mRoot.findViewById(n.f.dressup_center_coverflowview);
        PY();
        this.dEy = (MemberRecommendView) this.mRoot.findViewById(n.f.dressup_center_recommend);
        this.dEy.setFromType(1);
        this.dGc = new c(this.dGa.getPageContext());
        this.con = new TextView(this.dGa.getActivity());
        this.con.setHeight(com.baidu.adp.lib.util.k.d(this.dGa.getActivity(), n.d.ds30));
        this.mListView.setAdapter((ListAdapter) this.dGc);
        this.mListView.setOnItemClickListener(new g(this));
    }

    public void a(List<b> list, k kVar, List<j> list2, boolean z) {
        if ((list == null || list.size() <= 0) && ((kVar == null || StringUtils.isNull(kVar.aFw())) && (list2 == null || list2.size() <= 0))) {
            LY();
            return;
        }
        LZ();
        this.dGb.show(z);
        e(list2, bT(list) || b(kVar));
    }

    private boolean bT(List<b> list) {
        if (list == null || list.size() <= 0) {
            this.bjK.setVisibility(8);
            return false;
        }
        this.bjK.setVisibility(0);
        this.bjK.setData(list);
        return true;
    }

    private boolean b(k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aFw())) {
            this.dEy.setVisibility(8);
            return false;
        }
        this.dEy.setVisibility(0);
        this.dEy.a(kVar);
        return true;
    }

    private void e(List<j> list, boolean z) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        if (z) {
            this.mListView.removeHeaderView(this.con);
            this.mListView.addHeaderView(this.con);
        } else {
            this.mListView.removeHeaderView(this.con);
        }
        this.mListView.setVisibility(0);
        this.dGc.setData(list);
        this.dGc.notifyDataSetChanged();
    }

    public void oV() {
        this.dGa.getLayoutMode().af(TbadkApplication.getInst().getSkinType() == 1);
        this.dGa.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dGa.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dGa.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bjK != null && this.bjK.getVisibility() == 0) {
            this.bjK.tH();
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dGc != null) {
            this.dGc.notifyDataSetChanged();
        }
        if (this.dEy != null && this.dEy.getVisibility() == 0) {
            this.dEy.wh();
        }
        this.dGb.onChangeSkinType(this.dGa.getPageContext(), TbadkApplication.getInst().getSkinType());
        as.j((View) this.con, n.c.cp_bg_line_c);
    }

    public void LY() {
        this.mListView.setVisibility(8);
        this.bjK.setVisibility(8);
        this.dEy.setVisibility(8);
        String string = this.dGa.getPageContext().getResources().getString(n.i.no_data_text);
        this.dGa.setNetRefreshViewTopMargin(this.topMargin);
        this.dGa.showNetRefreshView(this.mRoot, string, false);
    }

    public void LZ() {
        this.dGa.hideNetRefreshView(this.mRoot);
        this.mListView.setVisibility(0);
        this.dEy.setVisibility(0);
        this.bjK.setVisibility(0);
    }

    private void PY() {
        if (this.bjK != null) {
            this.bjK.setCoverFlowFactory(new h(this));
            this.bjK.setCallback(new i(this));
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
