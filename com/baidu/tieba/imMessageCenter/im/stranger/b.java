package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView bly;
    private BdListView bve;
    private StrangerListActivity dZJ;
    private StrangerListAdapter dZP;
    private ImageView dZQ;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.dZJ = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dZQ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.dZJ);
        aj.a(this.dZQ, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.bly = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dZJ.getLayoutMode().ag(i == 1);
        this.dZJ.getLayoutMode().t(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dZJ.getPageContext(), i);
        this.bly.onChangeSkinType(this.dZJ.getPageContext(), i);
        aj.a(this.dZQ, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bve = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.bve.setOnItemClickListener(strangerListActivity);
        this.bve.setOnItemLongClickListener(strangerListActivity);
        this.dZP = new StrangerListAdapter(strangerListActivity);
        this.bve.setAdapter((ListAdapter) this.dZP);
    }

    public StrangerListAdapter aEE() {
        return this.dZP;
    }

    public View aEF() {
        return this.dZQ;
    }
}
