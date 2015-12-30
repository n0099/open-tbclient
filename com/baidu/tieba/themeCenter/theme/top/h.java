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
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView bam;
    private View csp;
    private TextView csq;
    private MemberRecommendView dMc;
    private TextView dMd;
    private TopThemeListActivity dOQ;
    private c dOR;
    private TextView dOa;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private int topMargin;

    public h(TopThemeListActivity topThemeListActivity, SkinItemView.a aVar) {
        this.topMargin = 0;
        this.dOQ = topThemeListActivity;
        this.topMargin = k.d(topThemeListActivity.getPageContext().getPageActivity(), n.e.ds120);
        this.mRoot = LayoutInflater.from(this.dOQ.getPageContext().getPageActivity()).inflate(n.h.top_theme_list_activity_layout, (ViewGroup) null);
        this.dOQ.setContentView(this.mRoot);
        this.csp = this.mRoot.findViewById(n.g.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.themes_personal);
        this.dOa = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.navigation_right_button_layout, (View.OnClickListener) null).findViewById(n.g.right_textview);
        this.dOa.setText(n.j.already_downloaded);
        this.dOa.setOnClickListener(new i(this));
        this.bam = (NoNetworkView) this.mRoot.findViewById(n.g.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.top_theme_listview);
        this.csq = new TextView(this.dOQ.getActivity());
        this.csq.setHeight(k.d(this.dOQ.getActivity(), n.e.ds104));
        this.dMc = (MemberRecommendView) this.mRoot.findViewById(n.g.top_theme_recommend);
        this.dMc.setFromType(3);
        this.dMd = (TextView) LayoutInflater.from(this.dOQ.getPageContext().getPageActivity()).inflate(n.h.look_more_view, (ViewGroup) null);
        this.dOR = new c(this.dOQ.getPageContext(), aVar);
        this.mListView.addFooterView(this.dMd);
        this.mListView.setAdapter((ListAdapter) this.dOR);
        this.dMd.setOnClickListener(new j(this));
    }

    public void a(com.baidu.tieba.themeCenter.dressCenter.k kVar, List<a> list, boolean z) {
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

    private void H(List<a> list) {
        if (list == null || list.size() <= 0) {
            this.mListView.setVisibility(8);
            return;
        }
        this.mListView.setVisibility(0);
        this.dOR.setData(list);
        this.dOR.notifyDataSetChanged();
    }

    public void Mr() {
        this.csp.setVisibility(8);
        String string = this.dOQ.getPageContext().getResources().getString(n.j.no_data_text);
        this.dOQ.setNetRefreshViewTopMargin(this.topMargin);
        this.dOQ.showNetRefreshView(this.mRoot, string, false);
    }

    public void Ms() {
        this.dOQ.hideNetRefreshView(this.mRoot);
        this.csp.setVisibility(0);
    }

    public void ot() {
        this.dOQ.getLayoutMode().ac(TbadkApplication.getInst().getSkinType() == 1);
        this.dOQ.getLayoutMode().k(this.mRoot);
        this.dOQ.getLayoutMode().k(this.dMd);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dOQ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dOQ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dOR != null) {
            this.dOR.notifyDataSetChanged();
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
