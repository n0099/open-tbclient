package com.baidu.tieba.themeCenter.theme.all;

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
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView bam;
    private View csp;
    private TextView csq;
    private MemberRecommendView dMc;
    private AllThemeListActivity dNZ;
    private TextView dOa;
    private c dOb;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(AllThemeListActivity allThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dNZ = allThemeListActivity;
        this.topMargin = k.d(allThemeListActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dNZ.getPageContext().getPageActivity()).inflate(n.h.all_theme_list_activity_layout, (ViewGroup) null);
        this.dNZ.setContentView(this.mRoot);
        this.csp = this.mRoot.findViewById(n.g.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.all_themes_personal);
        this.dOa = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.navigation_right_button_layout, (View.OnClickListener) null).findViewById(n.g.right_textview);
        this.dOa.setText(n.j.already_downloaded);
        this.dOa.setOnClickListener(new i(this));
        this.bam = (NoNetworkView) this.mRoot.findViewById(n.g.view_no_network);
        this.dMc = (MemberRecommendView) this.mRoot.findViewById(n.g.all_theme_recommend);
        this.dMc.setFromType(3);
        this.csq = new TextView(this.dNZ.getActivity());
        this.csq.setHeight(k.d(this.dNZ.getActivity(), n.e.ds104));
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.all_theme_listview);
        this.dOb = new c(this.dNZ.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dOb);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list, boolean z) {
        if ((kVar == null || StringUtils.isNull(kVar.aHL())) && (list == null || list.size() <= 0)) {
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
        H(list);
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

    private void H(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dOb.setData(list);
        this.dOb.notifyDataSetChanged();
    }

    public void Mr() {
        this.csp.setVisibility(8);
        String string = this.dNZ.getPageContext().getResources().getString(n.j.no_data_text);
        this.dNZ.setNetRefreshViewTopMargin(this.topMargin);
        this.dNZ.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ms() {
        this.dNZ.hideNetRefreshView(this.mRoot);
        this.csp.setVisibility(0);
    }

    public void tr() {
        this.dNZ.getLayoutMode().ac(TbadkApplication.getInst().getSkinType() == 1);
        this.dNZ.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dNZ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dNZ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dOb != null) {
            this.dOb.notifyDataSetChanged();
        }
        if (this.dMc != null && this.dMc.getVisibility() == 0) {
            this.dMc.vR();
        }
        as.j((View) this.csq, n.d.cp_bg_line_c);
        as.b(this.dOa, n.d.navi_op_text, 1);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
