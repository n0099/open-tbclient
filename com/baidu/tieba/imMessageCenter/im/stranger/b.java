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
    private ViewGroup aaQ;
    private NoNetworkView bem;
    private BdListView blc;
    private StrangerListActivity dMR;
    private StrangerListAdapter dMX;
    private ImageView dMY;
    private NavigationBar mNavigationBar;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.j.officialbar_msg_activity);
        this.dMR = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(d.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dMY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.stranger_delete, this.dMR);
        aj.a(this.dMY, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
        this.aaQ = (ViewGroup) strangerListActivity.findViewById(d.h.root_view);
        this.bem = (NoNetworkView) this.aaQ.findViewById(d.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dMR.getLayoutMode().ah(i == 1);
        this.dMR.getLayoutMode().t(this.aaQ);
        this.mNavigationBar.onChangeSkinType(this.dMR.getPageContext(), i);
        this.bem.onChangeSkinType(this.dMR.getPageContext(), i);
        aj.a(this.dMY, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.blc = (BdListView) strangerListActivity.findViewById(d.h.msg_list);
        this.blc.setOnItemClickListener(strangerListActivity);
        this.blc.setOnItemLongClickListener(strangerListActivity);
        this.dMX = new StrangerListAdapter(strangerListActivity);
        this.blc.setAdapter((ListAdapter) this.dMX);
    }

    public StrangerListAdapter aBQ() {
        return this.dMX;
    }

    public View aBR() {
        return this.dMY;
    }
}
