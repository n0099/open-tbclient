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
import com.baidu.tieba.view.MemberBuyEntryButton;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView aWm;

    /* renamed from: com  reason: collision with root package name */
    private View f131com;
    private TextView con;
    private MemberBuyEntryButton dEU;
    private MemberRecommendView dEy;
    private c dGA;
    private AllThemeListActivity dGy;
    private TextView dGz;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(AllThemeListActivity allThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dGy = allThemeListActivity;
        this.topMargin = k.d(allThemeListActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dGy.getPageContext().getPageActivity()).inflate(n.g.all_theme_list_activity_layout, (ViewGroup) null);
        this.dGy.setContentView(this.mRoot);
        this.f131com = this.mRoot.findViewById(n.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.all_themes_personal);
        this.dGz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(n.f.right_textview);
        this.dGz.setText(n.i.already_downloaded);
        this.dGz.setOnClickListener(new i(this));
        this.aWm = (NoNetworkView) this.mRoot.findViewById(n.f.view_no_network);
        this.dEy = (MemberRecommendView) this.mRoot.findViewById(n.f.all_theme_recommend);
        this.dEy.setFromType(3);
        this.con = new TextView(this.dGy.getActivity());
        this.con.setHeight(k.d(this.dGy.getActivity(), n.d.ds104));
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.all_theme_listview);
        this.dEU = (MemberBuyEntryButton) this.mRoot.findViewById(n.f.all_theme_buy_member);
        this.dGA = new c(this.dGy.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dGA);
    }

    public void setOnSrollToBottomListener(BdListView.e eVar) {
        this.mListView.setOnSrollToBottomListener(eVar);
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<com.baidu.tieba.themeCenter.theme.top.a> list, boolean z) {
        if ((kVar == null || StringUtils.isNull(kVar.aFw())) && (list == null || list.size() <= 0)) {
            LY();
            return;
        }
        LZ();
        this.dEU.show(z);
        if (b(kVar)) {
            this.mListView.removeHeaderView(this.con);
            this.mListView.addHeaderView(this.con);
        } else {
            this.mListView.removeHeaderView(this.con);
        }
        G(list);
    }

    private boolean b(com.baidu.tieba.themeCenter.dressCenter.k kVar) {
        if (kVar == null || StringUtils.isNull(kVar.aFw())) {
            this.dEy.setVisibility(8);
            return false;
        }
        this.dEy.setVisibility(0);
        this.dEy.a(kVar);
        return true;
    }

    private void G(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dGA.setData(list);
        this.dGA.notifyDataSetChanged();
    }

    public void LY() {
        this.f131com.setVisibility(8);
        String string = this.dGy.getPageContext().getResources().getString(n.i.no_data_text);
        this.dGy.setNetRefreshViewTopMargin(this.topMargin);
        this.dGy.showNetRefreshView(this.mRoot, string, false);
    }

    public void LZ() {
        this.dGy.hideNetRefreshView(this.mRoot);
        this.f131com.setVisibility(0);
    }

    public void tH() {
        this.dGy.getLayoutMode().af(TbadkApplication.getInst().getSkinType() == 1);
        this.dGy.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dGy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dGy.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dGA != null) {
            this.dGA.notifyDataSetChanged();
        }
        if (this.dEy != null && this.dEy.getVisibility() == 0) {
            this.dEy.wh();
        }
        this.dEU.onChangeSkinType(this.dGy.getPageContext(), TbadkApplication.getInst().getSkinType());
        as.j((View) this.con, n.c.cp_bg_line_c);
        as.b(this.dGz, n.c.navi_op_text, 1);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
