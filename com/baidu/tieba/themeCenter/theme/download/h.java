package com.baidu.tieba.themeCenter.theme.download;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.n;
import com.baidu.tieba.themeCenter.SkinItemView;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private NoNetworkView bam;
    private DownloadedThemeListActivity dOH;
    private TextView dOI;
    private com.baidu.tieba.themeCenter.theme.all.c dOb;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private boolean dOF = true;
    private boolean dOy = false;

    public h(DownloadedThemeListActivity downloadedThemeListActivity, SkinItemView.a aVar) {
        this.dOH = downloadedThemeListActivity;
        this.mRoot = LayoutInflater.from(this.dOH.getPageContext().getPageActivity()).inflate(n.h.downloaded_theme_list_activity_layout, (ViewGroup) null);
        this.dOH.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.j.themes_downloaded);
        this.dOI = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.h.navigation_right_button_layout, (View.OnClickListener) null).findViewById(n.g.right_textview);
        this.dOI.setText(n.j.theme_manager);
        this.bam = (NoNetworkView) this.mRoot.findViewById(n.g.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(n.g.downloaded_theme_listview);
        this.dOb = new com.baidu.tieba.themeCenter.theme.all.c(this.dOH.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dOb);
    }

    public void bX(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            Mr();
            return;
        }
        aHR();
        Ms();
        this.dOb.setData(list);
        this.dOb.notifyDataSetChanged();
    }

    public void Mr() {
        this.mListView.setVisibility(8);
        this.dOH.showNetRefreshView(this.mRoot, this.dOH.getPageContext().getResources().getString(n.j.no_data_text), false);
    }

    public void Ms() {
        this.mListView.setVisibility(0);
        this.dOH.hideNetRefreshView(this.mRoot);
    }

    public void aHR() {
        if (this.dOF) {
            this.dOI.setVisibility(0);
            return;
        }
        this.dOI.setVisibility(8);
        this.dOy = false;
    }

    public void tr() {
        this.dOH.getLayoutMode().ac(TbadkApplication.getInst().getSkinType() == 1);
        this.dOH.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dOH.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.bam != null && this.bam.getVisibility() == 0) {
            this.bam.onChangeSkinType(this.dOH.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dOb != null) {
            this.dOb.notifyDataSetChanged();
        }
        as.b(this.dOI, n.d.navi_op_text, 1);
    }

    public boolean aHS() {
        if (this.dOy) {
            this.dOI.setText(n.j.theme_manager);
            this.dOy = false;
        } else {
            this.dOI.setText(n.j.theme_edit_down);
            this.dOy = true;
            TiebaStatic.log("c10274");
        }
        return this.dOy;
    }

    public boolean isInEditMode() {
        return this.dOy;
    }

    public TextView aHT() {
        return this.dOI;
    }

    public void hF(boolean z) {
        this.dOF = z;
        if (!z) {
            this.dOy = false;
        }
    }
}
