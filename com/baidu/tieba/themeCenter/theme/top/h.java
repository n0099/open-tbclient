package com.baidu.tieba.themeCenter.theme.top;

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
    private TextView deQ;
    private TopThemeListActivity dgZ;
    private TextView dgj;
    private c dha;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(TopThemeListActivity topThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dgZ = topThemeListActivity;
        this.topMargin = k.d(topThemeListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dgZ.getPageContext().getPageActivity()).inflate(i.g.top_theme_list_activity_layout, (ViewGroup) null);
        this.dgZ.setContentView(this.mRoot);
        this.deN = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.themes_personal);
        this.dgj = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dgj.setText(i.h.already_downloaded);
        this.dgj.setOnClickListener(new i(this));
        this.aQP = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.top_theme_listview);
        this.deP = new TextView(this.dgZ.getActivity());
        this.deP.setHeight(k.d(this.dgZ.getActivity(), i.d.ds104));
        this.deO = (MemberRecommendView) this.mRoot.findViewById(i.f.top_theme_recommend);
        this.deO.setFromType(3);
        this.deQ = (TextView) LayoutInflater.from(this.dgZ.getPageContext().getPageActivity()).inflate(i.g.look_more_view, (ViewGroup) null);
        this.dha = new c(this.dgZ.getPageContext(), aVar);
        this.mListView.addFooterView(this.deQ);
        this.mListView.setAdapter((ListAdapter) this.dha);
        this.deQ.setOnClickListener(new j(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<a> list) {
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

    private void F(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dha.setData(list);
        this.dha.notifyDataSetChanged();
    }

    public void Kr() {
        this.deN.setVisibility(8);
        String string = this.dgZ.getPageContext().getResources().getString(i.h.no_data_text);
        this.dgZ.setNetRefreshViewTopMargin(this.topMargin);
        this.dgZ.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ks() {
        this.dgZ.hideNetRefreshView(this.mRoot);
        this.deN.setVisibility(0);
    }

    public void oO() {
        this.dgZ.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dgZ.getLayoutMode().k(this.mRoot);
        this.dgZ.getLayoutMode().k(this.deQ);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgZ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.dgZ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dha != null) {
            this.dha.notifyDataSetChanged();
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
