package com.baidu.tieba.themeCenter.theme.download;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.i;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView aRa;
    private com.baidu.tieba.themeCenter.theme.all.c dgK;
    private DownloadedThemeListActivity dhq;
    private TextView dhr;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private boolean dho = true;
    private boolean dhg = false;

    public h(DownloadedThemeListActivity downloadedThemeListActivity, SkinItemView.a aVar) {
        this.dhq = downloadedThemeListActivity;
        this.mRoot = LayoutInflater.from(this.dhq.getPageContext().getPageActivity()).inflate(i.g.downloaded_theme_list_activity_layout, (ViewGroup) null);
        this.dhq.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.themes_downloaded);
        this.dhr = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.dhr.setText(i.h.theme_manager);
        this.aRa = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.downloaded_theme_listview);
        this.dgK = new com.baidu.tieba.themeCenter.theme.all.c(this.dhq.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dgK);
    }

    public void bC(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            Kr();
            return;
        }
        azF();
        Ks();
        this.dgK.setData(list);
        this.dgK.notifyDataSetChanged();
    }

    public void Kr() {
        this.mListView.setVisibility(8);
        this.dhq.showNetRefreshView(this.mRoot, this.dhq.getPageContext().getResources().getString(i.h.no_data_text), false);
    }

    public void Ks() {
        this.mListView.setVisibility(0);
        this.dhq.hideNetRefreshView(this.mRoot);
    }

    public void azF() {
        if (this.dho) {
            this.dhr.setVisibility(0);
            return;
        }
        this.dhr.setVisibility(8);
        this.dhg = false;
    }

    public void tc() {
        this.dhq.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.dhq.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dhq.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRa != null && this.aRa.getVisibility() == 0) {
            this.aRa.onChangeSkinType(this.dhq.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dgK != null) {
            this.dgK.notifyDataSetChanged();
        }
        an.b(this.dhr, i.c.navi_op_text, 1);
    }

    public boolean azG() {
        if (this.dhg) {
            this.dhr.setText(i.h.theme_manager);
            this.dhg = false;
        } else {
            this.dhr.setText(i.h.theme_edit_down);
            this.dhg = true;
            TiebaStatic.log("c10274");
        }
        return this.dhg;
    }

    public boolean isInEditMode() {
        return this.dhg;
    }

    public TextView azH() {
        return this.dhr;
    }

    public void gL(boolean z) {
        this.dho = z;
        if (!z) {
            this.dhg = false;
        }
    }
}
