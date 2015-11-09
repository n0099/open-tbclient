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
    private NoNetworkView aRi;
    private View dgT;
    private MemberRecommendView dgU;
    private TextView dgV;
    private AllThemeListActivity dio;
    private TextView dip;
    private c diq;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(AllThemeListActivity allThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dio = allThemeListActivity;
        this.topMargin = k.d(allThemeListActivity.getPageContext().getPageActivity(), i.d.ds120);
        this.mRoot = LayoutInflater.from(this.dio.getPageContext().getPageActivity()).inflate(i.g.all_theme_list_activity_layout, (ViewGroup) null);
        this.dio.setContentView(this.mRoot);
        this.dgT = this.mRoot.findViewById(i.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.all_themes_personal);
        this.dip = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dip.setText(i.h.already_downloaded);
        this.dip.setOnClickListener(new i(this));
        this.aRi = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.dgU = (MemberRecommendView) this.mRoot.findViewById(i.f.all_theme_recommend);
        this.dgU.setFromType(3);
        this.dgV = new TextView(this.dio.getActivity());
        this.dgV.setHeight(k.d(this.dio.getActivity(), i.d.ds104));
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.all_theme_listview);
        this.diq = new c(this.dio.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.diq);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list) {
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

    private void G(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.diq.setData(list);
        this.diq.notifyDataSetChanged();
    }

    public void KD() {
        this.dgT.setVisibility(8);
        String string = this.dio.getPageContext().getResources().getString(i.h.no_data_text);
        this.dio.setNetRefreshViewTopMargin(this.topMargin);
        this.dio.showNetRefreshView(this.mRoot, string, false);
    }

    public void KE() {
        this.dio.hideNetRefreshView(this.mRoot);
        this.dgT.setVisibility(0);
    }

    public void tc() {
        this.dio.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dio.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dio.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.dio.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.diq != null) {
            this.diq.notifyDataSetChanged();
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
