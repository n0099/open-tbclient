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
    private NoNetworkView aRi;
    private View dgT;
    private MemberRecommendView dgU;
    private TextView dgV;
    private TextView dgW;
    private TextView dip;
    private TopThemeListActivity djf;
    private c djg;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(TopThemeListActivity topThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.djf = topThemeListActivity;
        this.topMargin = k.d(topThemeListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.djf.getPageContext().getPageActivity()).inflate(i.g.top_theme_list_activity_layout, (ViewGroup) null);
        this.djf.setContentView(this.mRoot);
        this.dgT = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.themes_personal);
        this.dip = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dip.setText(i.h.already_downloaded);
        this.dip.setOnClickListener(new i(this));
        this.aRi = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.top_theme_listview);
        this.dgV = new TextView(this.djf.getActivity());
        this.dgV.setHeight(k.d(this.djf.getActivity(), i.d.ds104));
        this.dgU = (MemberRecommendView) this.mRoot.findViewById(i.f.top_theme_recommend);
        this.dgU.setFromType(3);
        this.dgW = (TextView) LayoutInflater.from(this.djf.getPageContext().getPageActivity()).inflate(i.g.look_more_view, (ViewGroup) null);
        this.djg = new c(this.djf.getPageContext(), aVar);
        this.mListView.addFooterView(this.dgW);
        this.mListView.setAdapter((ListAdapter) this.djg);
        this.dgW.setOnClickListener(new j(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<a> list) {
        if ((kVar == null || StringUtils.isNull(kVar.aAm())) && (list == null || list.size() <= 0)) {
            KD();
            return;
        }
        KE();
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.dgV);
            this.mListView.addHeaderView(this.dgV);
        } else {
            this.mListView.removeHeaderView(this.dgV);
        }
        G(list);
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aAm())) {
            this.dgU.setVisibility(8);
            return false;
        }
        this.dgU.setVisibility(0);
        this.dgU.a(kVar);
        return true;
    }

    private void G(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.djg.setData(list);
        this.djg.notifyDataSetChanged();
    }

    public void KD() {
        this.dgT.setVisibility(8);
        String string = this.djf.getPageContext().getResources().getString(i.h.no_data_text);
        this.djf.setNetRefreshViewTopMargin(this.topMargin);
        this.djf.showNetRefreshView(this.mRoot, string, false);
    }

    public void KE() {
        this.djf.hideNetRefreshView(this.mRoot);
        this.dgT.setVisibility(0);
    }

    public void oP() {
        this.djf.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.djf.getLayoutMode().k(this.mRoot);
        this.djf.getLayoutMode().k(this.dgW);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.djf.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.djf.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.djg != null) {
            this.djg.notifyDataSetChanged();
        }
        if (this.dgU != null && this.dgU.getVisibility() == 0) {
            this.dgU.vB();
        }
        an.j((View) this.dgV, i.c.cp_bg_line_c);
        an.b(this.dip, i.c.navi_op_text, 1);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
