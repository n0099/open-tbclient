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
    private View f133com;
    private TextView con;
    private TextView dEA;
    private MemberRecommendView dEy;
    private MemberBuyEntryButton dGb;
    private TextView dGz;
    private TopThemeListActivity dHp;
    private c dHq;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(TopThemeListActivity topThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dHp = topThemeListActivity;
        this.topMargin = k.d(topThemeListActivity.getPageContext().getPageActivity(), n.d.ds120);
        this.mRoot = LayoutInflater.from(this.dHp.getPageContext().getPageActivity()).inflate(n.g.top_theme_list_activity_layout, (ViewGroup) null);
        this.dHp.setContentView(this.mRoot);
        this.f133com = this.mRoot.findViewById(n.f.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.themes_personal);
        this.dGz = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(n.f.right_textview);
        this.dGz.setText(n.i.already_downloaded);
        this.dGz.setOnClickListener(new i(this));
        this.aWm = (NoNetworkView) this.mRoot.findViewById(n.f.view_no_network);
        this.dGb = (MemberBuyEntryButton) this.mRoot.findViewById(n.f.top_theme_buy_member);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.top_theme_listview);
        this.con = new TextView(this.dHp.getActivity());
        this.con.setHeight(k.d(this.dHp.getActivity(), n.d.ds104));
        this.dEy = (MemberRecommendView) this.mRoot.findViewById(n.f.top_theme_recommend);
        this.dEy.setFromType(3);
        this.dEA = (TextView) LayoutInflater.from(this.dHp.getPageContext().getPageActivity()).inflate(n.g.look_more_view, (ViewGroup) null);
        this.dHq = new c(this.dHp.getPageContext(), aVar);
        this.mListView.addFooterView(this.dEA);
        this.mListView.setAdapter((ListAdapter) this.dHq);
        this.dEA.setOnClickListener(new j(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<a> list, boolean z) {
        if ((kVar == null || StringUtils.isNull(kVar.aFw())) && (list == null || list.size() <= 0)) {
            LY();
            return;
        }
        LZ();
        this.dGb.show(z);
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

    private void G(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dHq.setData(list);
        this.dHq.notifyDataSetChanged();
    }

    public void LY() {
        this.f133com.setVisibility(8);
        String string = this.dHp.getPageContext().getResources().getString(n.i.no_data_text);
        this.dHp.setNetRefreshViewTopMargin(this.topMargin);
        this.dHp.showNetRefreshView(this.mRoot, string, false);
    }

    public void LZ() {
        this.dHp.hideNetRefreshView(this.mRoot);
        this.f133com.setVisibility(0);
    }

    public void oV() {
        this.dHp.getLayoutMode().af(TbadkApplication.getInst().getSkinType() == 1);
        this.dHp.getLayoutMode().k(this.mRoot);
        this.dHp.getLayoutMode().k(this.dEA);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dHp.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dHp.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dHq != null) {
            this.dHq.notifyDataSetChanged();
        }
        if (this.dEy != null && this.dEy.getVisibility() == 0) {
            this.dEy.wh();
        }
        this.dGb.onChangeSkinType(this.dHp.getPageContext(), TbadkApplication.getInst().getSkinType());
        as.j((View) this.con, n.c.cp_bg_line_c);
        as.b(this.dGz, n.c.navi_op_text, 1);
    }

    public View getRootView() {
        return this.mRoot;
    }
}
