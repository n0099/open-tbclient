package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends c<StrangerListActivity> {
    private ViewGroup abK;
    private NoNetworkView beq;
    private BdListView bkD;
    private StrangerListAdapter dDD;
    private ImageView dDE;
    private StrangerListActivity dDx;
    private NavigationBar mNavigationBar;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.j.officialbar_msg_activity);
        this.dDx = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(d.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dDE = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.stranger_delete, this.dDx);
        ai.b(this.dDE, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
        this.abK = (ViewGroup) strangerListActivity.findViewById(d.h.root_view);
        this.beq = (NoNetworkView) this.abK.findViewById(d.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dDx.getLayoutMode().ah(i == 1);
        this.dDx.getLayoutMode().t(this.abK);
        this.mNavigationBar.onChangeSkinType(this.dDx.getPageContext(), i);
        this.beq.onChangeSkinType(this.dDx.getPageContext(), i);
        ai.b(this.dDE, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bkD = (BdListView) strangerListActivity.findViewById(d.h.msg_list);
        this.bkD.setOnItemClickListener(strangerListActivity);
        this.bkD.setOnItemLongClickListener(strangerListActivity);
        this.dDD = new StrangerListAdapter(strangerListActivity);
        this.bkD.setAdapter((ListAdapter) this.dDD);
    }

    public StrangerListAdapter azo() {
        return this.dDD;
    }

    public View azp() {
        return this.dDE;
    }
}
