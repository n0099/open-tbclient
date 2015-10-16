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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.MemberRecommendView;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView aRa;
    private View dfn;
    private MemberRecommendView dfo;
    private TextView dfp;
    private TextView dfq;
    private TextView dgJ;
    private c dhA;
    private TopThemeListActivity dhz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(TopThemeListActivity topThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dhz = topThemeListActivity;
        this.topMargin = k.d(topThemeListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dhz.getPageContext().getPageActivity()).inflate(i.g.top_theme_list_activity_layout, (ViewGroup) null);
        this.dhz.setContentView(this.mRoot);
        this.dfn = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.themes_personal);
        this.dgJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dgJ.setText(i.h.already_downloaded);
        this.dgJ.setOnClickListener(new i(this));
        this.aRa = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.top_theme_listview);
        this.dfp = new TextView(this.dhz.getActivity());
        this.dfp.setHeight(k.d(this.dhz.getActivity(), i.d.ds104));
        this.dfo = (MemberRecommendView) this.mRoot.findViewById(i.f.top_theme_recommend);
        this.dfo.setFromType(3);
        this.dfq = (TextView) LayoutInflater.from(this.dhz.getPageContext().getPageActivity()).inflate(i.g.look_more_view, (ViewGroup) null);
        this.dhA = new c(this.dhz.getPageContext(), aVar);
        this.mListView.addFooterView(this.dfq);
        this.mListView.setAdapter((ListAdapter) this.dhA);
        this.dfq.setOnClickListener(new j(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<a> list) {
        if ((kVar == null || StringUtils.isNull(kVar.azA())) && (list == null || list.size() <= 0)) {
            Kr();
            return;
        }
        Ks();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.dfp);
            this.mListView.addHeaderView(this.dfp);
        } else {
            this.mListView.removeHeaderView(this.dfp);
        }
        F(list);
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.azA())) {
            this.dfo.setVisibility(8);
            return false;
        }
        this.dfo.setVisibility(0);
        this.dfo.a(kVar);
        return true;
    }

    private void F(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dhA.setData(list);
        this.dhA.notifyDataSetChanged();
    }

    public void Kr() {
        this.dfn.setVisibility(8);
        String string = this.dhz.getPageContext().getResources().getString(i.h.no_data_text);
        this.dhz.setNetRefreshViewTopMargin(this.topMargin);
        this.dhz.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ks() {
        this.dhz.hideNetRefreshView(this.mRoot);
        this.dfn.setVisibility(0);
    }

    public void oO() {
        this.dhz.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dhz.getLayoutMode().k(this.mRoot);
        this.dhz.getLayoutMode().k(this.dfq);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dhz.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dhz.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dhA != null) {
            this.dhA.notifyDataSetChanged();
        }
        if (this.dfo != null && this.dfo.getVisibility() == 0) {
            this.dfo.vA();
        }
        an.j((View) this.dfp, i.c.cp_bg_line_c);
        an.b(this.dgJ, i.c.navi_op_text, 1);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
