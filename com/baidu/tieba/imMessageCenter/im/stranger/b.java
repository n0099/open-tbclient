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
    private ViewGroup aaE;
    private NoNetworkView bfM;
    private BdListView bmz;
    private StrangerListActivity dIT;
    private StrangerListAdapter dIZ;
    private ImageView dJa;
    private NavigationBar mNavigationBar;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.j.officialbar_msg_activity);
        this.dIT = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(d.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dJa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.stranger_delete, this.dIT);
        aj.a(this.dJa, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
        this.aaE = (ViewGroup) strangerListActivity.findViewById(d.h.root_view);
        this.bfM = (NoNetworkView) this.aaE.findViewById(d.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dIT.getLayoutMode().ah(i == 1);
        this.dIT.getLayoutMode().t(this.aaE);
        this.mNavigationBar.onChangeSkinType(this.dIT.getPageContext(), i);
        this.bfM.onChangeSkinType(this.dIT.getPageContext(), i);
        aj.a(this.dJa, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bmz = (BdListView) strangerListActivity.findViewById(d.h.msg_list);
        this.bmz.setOnItemClickListener(strangerListActivity);
        this.bmz.setOnItemLongClickListener(strangerListActivity);
        this.dIZ = new StrangerListAdapter(strangerListActivity);
        this.bmz.setAdapter((ListAdapter) this.dIZ);
    }

    public StrangerListAdapter aAw() {
        return this.dIZ;
    }

    public View aAx() {
        return this.dJa;
    }
}
