package com.baidu.tieba.themeCenter.theme.download;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView aQP;
    private DownloadedThemeListActivity dgQ;
    private TextView dgR;
    private com.baidu.tieba.themeCenter.theme.all.c dgk;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private boolean dgO = true;
    private boolean dgG = false;

    public h(DownloadedThemeListActivity downloadedThemeListActivity, SkinItemView.a aVar) {
        this.dgQ = downloadedThemeListActivity;
        this.mRoot = LayoutInflater.from(this.dgQ.getPageContext().getPageActivity()).inflate(i.g.downloaded_theme_list_activity_layout, (ViewGroup) null);
        this.dgQ.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.themes_downloaded);
        this.dgR = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dgR.setText(i.h.theme_manager);
        this.aQP = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.downloaded_theme_listview);
        this.dgk = new com.baidu.tieba.themeCenter.theme.all.c(this.dgQ.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dgk);
    }

    public void bB(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            Kr();
            return;
        }
        azv();
        Ks();
        this.dgk.setData(list);
        this.dgk.notifyDataSetChanged();
    }

    public void Kr() {
        this.mListView.setVisibility(8);
        this.dgQ.showNetRefreshView(this.mRoot, this.dgQ.getPageContext().getResources().getString(i.h.no_data_text), false);
    }

    public void Ks() {
        this.mListView.setVisibility(0);
        this.dgQ.hideNetRefreshView(this.mRoot);
    }

    public void azv() {
        if (this.dgO) {
            this.dgR.setVisibility(0);
            return;
        }
        this.dgR.setVisibility(8);
        this.dgG = false;
    }

    public void tc() {
        this.dgQ.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dgQ.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dgQ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aQP != null && this.aQP.getVisibility() == 0) {
            this.aQP.onChangeSkinType(this.dgQ.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dgk != null) {
            this.dgk.notifyDataSetChanged();
        }
        am.b(this.dgR, i.c.navi_op_text, 1);
    }

    public boolean azw() {
        if (this.dgG) {
            this.dgR.setText(i.h.theme_manager);
            this.dgG = false;
        } else {
            this.dgR.setText(i.h.theme_edit_down);
            this.dgG = true;
            TiebaStatic.log("c10274");
        }
        return this.dgG;
    }

    public boolean isInEditMode() {
        return this.dgG;
    }

    public TextView azx() {
        return this.dgR;
    }

    public void gL(boolean z) {
        this.dgO = z;
        if (!z) {
            this.dgG = false;
        }
    }
}
