package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView bJX;
    private BdListView eCB;
    private StrangerListActivity eVi;
    private StrangerListAdapter eVo;
    private ImageView mDeleteBtn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(e.h.officialbar_msg_activity);
        this.eVi = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(e.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mDeleteBtn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.stranger_delete, this.eVi);
        al.a(this.mDeleteBtn, e.f.icon_tabbar_delete_bg_s, e.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(e.g.root_view);
        this.bJX = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eVi.getLayoutMode().setNightMode(i == 1);
        this.eVi.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eVi.getPageContext(), i);
        this.bJX.onChangeSkinType(this.eVi.getPageContext(), i);
        al.a(this.mDeleteBtn, e.f.icon_tabbar_delete_bg_s, e.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.eCB = (BdListView) strangerListActivity.findViewById(e.g.msg_list);
        this.eCB.setOnItemClickListener(strangerListActivity);
        this.eCB.setOnItemLongClickListener(strangerListActivity);
        this.eVo = new StrangerListAdapter(strangerListActivity);
        this.eCB.setAdapter((ListAdapter) this.eVo);
    }

    public StrangerListAdapter aUk() {
        return this.eVo;
    }

    public View aUl() {
        return this.mDeleteBtn;
    }
}
