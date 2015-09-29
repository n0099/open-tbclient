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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView aQP;
    private View deN;
    private MemberRecommendView deO;
    private TextView deP;
    private AllThemeListActivity dgi;
    private TextView dgj;
    private c dgk;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(AllThemeListActivity allThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dgi = allThemeListActivity;
        this.topMargin = k.d(allThemeListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dgi.getPageContext().getPageActivity()).inflate(i.g.all_theme_list_activity_layout, (ViewGroup) null);
        this.dgi.setContentView(this.mRoot);
        this.deN = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.all_themes_personal);
        this.dgj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dgj.setText(i.h.already_downloaded);
        this.dgj.setOnClickListener(new i(this));
        this.aQP = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.deO = (MemberRecommendView) this.mRoot.findViewById(i.f.all_theme_recommend);
        this.deO.setFromType(3);
        this.deP = new TextView(this.dgi.getActivity());
        this.deP.setHeight(k.d(this.dgi.getActivity(), i.d.ds104));
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.all_theme_listview);
        this.dgk = new c(this.dgi.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dgk);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if ((kVar == null || StringUtils.isNull(kVar.azq())) && (list == null || list.size() <= 0)) {
            Kr();
            return;
        }
        Ks();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.deP);
            this.mListView.addHeaderView(this.deP);
        } else {
            this.mListView.removeHeaderView(this.deP);
        }
        F(list);
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.azq())) {
            this.deO.setVisibility(8);
            return false;
        }
        this.deO.setVisibility(0);
        this.deO.a(kVar);
        return true;
    }

    private void F(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dgk.setData(list);
        this.dgk.notifyDataSetChanged();
    }

    public void Kr() {
        this.deN.setVisibility(8);
        String string = this.dgi.getPageContext().getResources().getString(i.h.no_data_text);
        this.dgi.setNetRefreshViewTopMargin(this.topMargin);
        this.dgi.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ks() {
        this.dgi.hideNetRefreshView(this.mRoot);
        this.deN.setVisibility(0);
    }

    public void tc() {
        this.dgi.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dgi.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgi.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.dgi.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dgk != null) {
            this.dgk.notifyDataSetChanged();
        }
        if (this.deO != null && this.deO.getVisibility() == 0) {
            this.deO.vA();
        }
        am.j((View) this.deP, i.c.cp_bg_line_c);
        am.b(this.dgj, i.c.navi_op_text, 1);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
