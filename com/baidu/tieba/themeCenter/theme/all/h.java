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
    private AllThemeListActivity dgI;
    private TextView dgJ;
    private c dgK;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(AllThemeListActivity allThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dgI = allThemeListActivity;
        this.topMargin = k.d(allThemeListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dgI.getPageContext().getPageActivity()).inflate(i.g.all_theme_list_activity_layout, (ViewGroup) null);
        this.dgI.setContentView(this.mRoot);
        this.dfn = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.all_themes_personal);
        this.dgJ = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dgJ.setText(i.h.already_downloaded);
        this.dgJ.setOnClickListener(new i(this));
        this.aRa = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.dfo = (MemberRecommendView) this.mRoot.findViewById(i.f.all_theme_recommend);
        this.dfo.setFromType(3);
        this.dfp = new TextView(this.dgI.getActivity());
        this.dfp.setHeight(k.d(this.dgI.getActivity(), i.d.ds104));
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.all_theme_listview);
        this.dgK = new c(this.dgI.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dgK);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if ((kVar == null || StringUtils.isNull(kVar.azw())) && (list == null || list.size() <= 0)) {
            Kn();
            return;
        }
        Ko();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.dfp);
            this.mListView.addHeaderView(this.dfp);
        } else {
            this.mListView.removeHeaderView(this.dfp);
        }
        F(list);
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.azw())) {
            this.dfo.setVisibility(8);
            return false;
        }
        this.dfo.setVisibility(0);
        this.dfo.a(kVar);
        return true;
    }

    private void F(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dgK.setData(list);
        this.dgK.notifyDataSetChanged();
    }

    public void Kn() {
        this.dfn.setVisibility(8);
        String string = this.dgI.getPageContext().getResources().getString(i.h.no_data_text);
        this.dgI.setNetRefreshViewTopMargin(this.topMargin);
        this.dgI.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ko() {
        this.dgI.hideNetRefreshView(this.mRoot);
        this.dfn.setVisibility(0);
    }

    public void sZ() {
        this.dgI.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dgI.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgI.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dgI.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dgK != null) {
            this.dgK.notifyDataSetChanged();
        }
        if (this.dfo != null && this.dfo.getVisibility() == 0) {
            this.dfo.vx();
        }
        an.j((View) this.dfp, i.c.cp_bg_line_c);
        an.b(this.dgJ, i.c.navi_op_text, 1);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
