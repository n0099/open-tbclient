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
    private NoNetworkView aWm;
    private com.baidu.tieba.themeCenter.theme.all.c dGA;
    private DownloadedThemeListActivity dHg;
    private TextView dHh;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private boolean dHe = true;
    private boolean dGX = false;

    public h(DownloadedThemeListActivity downloadedThemeListActivity, SkinItemView.a aVar) {
        this.dHg = downloadedThemeListActivity;
        this.mRoot = LayoutInflater.from(this.dHg.getPageContext().getPageActivity()).inflate(n.g.downloaded_theme_list_activity_layout, (ViewGroup) null);
        this.dHg.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(n.i.themes_downloaded);
        this.dHh = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(n.f.right_textview);
        this.dHh.setText(n.i.theme_manager);
        this.aWm = (NoNetworkView) this.mRoot.findViewById(n.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(n.f.downloaded_theme_listview);
        this.dGA = new com.baidu.tieba.themeCenter.theme.all.c(this.dHg.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.dGA);
    }

    public void bU(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            LY();
            return;
        }
        aFC();
        LZ();
        this.dGA.setData(list);
        this.dGA.notifyDataSetChanged();
    }

    public void LY() {
        this.mListView.setVisibility(8);
        this.dHg.showNetRefreshView(this.mRoot, this.dHg.getPageContext().getResources().getString(n.i.no_data_text), false);
    }

    public void LZ() {
        this.mListView.setVisibility(0);
        this.dHg.hideNetRefreshView(this.mRoot);
    }

    public void aFC() {
        if (this.dHe) {
            this.dHh.setVisibility(0);
            return;
        }
        this.dHh.setVisibility(8);
        this.dGX = false;
    }

    public void tH() {
        this.dHg.getLayoutMode().af(TbadkApplication.getInst().getSkinType() == 1);
        this.dHg.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dHg.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aWm != null && this.aWm.getVisibility() == 0) {
            this.aWm.onChangeSkinType(this.dHg.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.dGA != null) {
            this.dGA.notifyDataSetChanged();
        }
        as.b(this.dHh, n.c.navi_op_text, 1);
    }

    public boolean aFD() {
        if (this.dGX) {
            this.dHh.setText(n.i.theme_manager);
            this.dGX = false;
        } else {
            this.dHh.setText(n.i.theme_edit_down);
            this.dGX = true;
            TiebaStatic.log("c10274");
        }
        return this.dGX;
    }

    public boolean isInEditMode() {
        return this.dGX;
    }

    public TextView aFE() {
        return this.dHh;
    }

    public void hw(boolean z) {
        this.dHe = z;
        if (!z) {
            this.dGX = false;
        }
    }
}
