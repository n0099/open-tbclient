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
    private NoNetworkView blu;
    private BdListView bva;
    private StrangerListActivity dZF;
    private StrangerListAdapter dZL;
    private ImageView dZM;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.dZF = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dZM = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.dZF);
        aj.a(this.dZM, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.blu = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dZF.getLayoutMode().ag(i == 1);
        this.dZF.getLayoutMode().t(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dZF.getPageContext(), i);
        this.blu.onChangeSkinType(this.dZF.getPageContext(), i);
        aj.a(this.dZM, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bva = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.bva.setOnItemClickListener(strangerListActivity);
        this.bva.setOnItemLongClickListener(strangerListActivity);
        this.dZL = new StrangerListAdapter(strangerListActivity);
        this.bva.setAdapter((ListAdapter) this.dZL);
    }

    public StrangerListAdapter aEE() {
        return this.dZL;
    }

    public View aEF() {
        return this.dZM;
    }
}
