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
    private NoNetworkView bKI;
    private BdListView eDU;
    private StrangerListActivity eWA;
    private StrangerListAdapter eWG;
    private ImageView mDeleteBtn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(e.h.officialbar_msg_activity);
        this.eWA = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(e.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mDeleteBtn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, e.h.stranger_delete, this.eWA);
        al.a(this.mDeleteBtn, e.f.icon_tabbar_delete_bg_s, e.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(e.g.root_view);
        this.bKI = (NoNetworkView) this.mRootView.findViewById(e.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eWA.getLayoutMode().setNightMode(i == 1);
        this.eWA.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eWA.getPageContext(), i);
        this.bKI.onChangeSkinType(this.eWA.getPageContext(), i);
        al.a(this.mDeleteBtn, e.f.icon_tabbar_delete_bg_s, e.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.eDU = (BdListView) strangerListActivity.findViewById(e.g.msg_list);
        this.eDU.setOnItemClickListener(strangerListActivity);
        this.eDU.setOnItemLongClickListener(strangerListActivity);
        this.eWG = new StrangerListAdapter(strangerListActivity);
        this.eDU.setAdapter((ListAdapter) this.eWG);
    }

    public StrangerListAdapter aTH() {
        return this.eWG;
    }

    public View aTI() {
        return this.mDeleteBtn;
    }
}
