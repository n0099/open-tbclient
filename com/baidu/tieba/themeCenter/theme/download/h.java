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
    private NoNetworkView aRi;
    private DownloadedThemeListActivity diW;
    private TextView diX;
    private com.baidu.tieba.themeCenter.theme.all.c diq;
    private BdListView mListView;
    private NavigationBar mNavigationBar;
    private View mRoot;
    private boolean diU = true;
    private boolean diM = false;

    public h(DownloadedThemeListActivity downloadedThemeListActivity, SkinItemView.a aVar) {
        this.diW = downloadedThemeListActivity;
        this.mRoot = LayoutInflater.from(this.diW.getPageContext().getPageActivity()).inflate(i.g.downloaded_theme_list_activity_layout, (ViewGroup) null);
        this.diW.setContentView(this.mRoot);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(i.h.themes_downloaded);
        this.diX = (TextView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.navigation_right_button_layout, (View.OnClickListener) null).findViewById(i.f.right_textview);
        this.diX.setText(i.h.theme_manager);
        this.aRi = (NoNetworkView) this.mRoot.findViewById(i.f.view_no_network);
        this.mListView = (BdListView) this.mRoot.findViewById(i.f.downloaded_theme_listview);
        this.diq = new com.baidu.tieba.themeCenter.theme.all.c(this.diW.getPageContext(), aVar);
        this.mListView.setAdapter((ListAdapter) this.diq);
    }

    public void bG(List<com.baidu.tieba.themeCenter.theme.top.a> list) {
        if (list == null || list.size() <= 0) {
            KD();
            return;
        }
        aAr();
        KE();
        this.diq.setData(list);
        this.diq.notifyDataSetChanged();
    }

    public void KD() {
        this.mListView.setVisibility(8);
        this.diW.showNetRefreshView(this.mRoot, this.diW.getPageContext().getResources().getString(i.h.no_data_text), false);
    }

    public void KE() {
        this.mListView.setVisibility(0);
        this.diW.hideNetRefreshView(this.mRoot);
    }

    public void aAr() {
        if (this.diU) {
            this.diX.setVisibility(0);
            return;
        }
        this.diX.setVisibility(8);
        this.diM = false;
    }

    public void tc() {
        this.diW.getLayoutMode().ad(TbadkApplication.getInst().getSkinType() == 1);
        this.diW.getLayoutMode().k(this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.diW.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.aRi != null && this.aRi.getVisibility() == 0) {
            this.aRi.onChangeSkinType(this.diW.getPageContext(), TbadkApplication.getInst().getSkinType());
        }
        if (this.mListView != null && this.mListView.getVisibility() == 0 && this.diq != null) {
            this.diq.notifyDataSetChanged();
        }
        an.b(this.diX, i.c.navi_op_text, 1);
    }

    public boolean aAs() {
        if (this.diM) {
            this.diX.setText(i.h.theme_manager);
            this.diM = false;
        } else {
            this.diX.setText(i.h.theme_edit_down);
            this.diM = true;
            TiebaStatic.log("c10274");
        }
        return this.diM;
    }

    public boolean isInEditMode() {
        return this.diM;
    }

    public TextView aAt() {
        return this.diX;
    }

    public void gO(boolean z) {
        this.diU = z;
        if (!z) {
            this.diM = false;
        }
    }
}
