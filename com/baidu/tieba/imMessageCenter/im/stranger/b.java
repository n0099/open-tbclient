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
    private NoNetworkView bep;
    private BdListView bld;
    private StrangerListActivity dLX;
    private StrangerListAdapter dMd;
    private ImageView dMe;
    private NavigationBar mNavigationBar;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.j.officialbar_msg_activity);
        this.dLX = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(d.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dMe = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.stranger_delete, this.dLX);
        aj.a(this.dMe, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
        this.aaQ = (ViewGroup) strangerListActivity.findViewById(d.h.root_view);
        this.bep = (NoNetworkView) this.aaQ.findViewById(d.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dLX.getLayoutMode().ah(i == 1);
        this.dLX.getLayoutMode().t(this.aaQ);
        this.mNavigationBar.onChangeSkinType(this.dLX.getPageContext(), i);
        this.bep.onChangeSkinType(this.dLX.getPageContext(), i);
        aj.a(this.dMe, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bld = (BdListView) strangerListActivity.findViewById(d.h.msg_list);
        this.bld.setOnItemClickListener(strangerListActivity);
        this.bld.setOnItemLongClickListener(strangerListActivity);
        this.dMd = new StrangerListAdapter(strangerListActivity);
        this.bld.setAdapter((ListAdapter) this.dMd);
    }

    public StrangerListAdapter aBF() {
        return this.dMd;
    }

    public View aBG() {
        return this.dMe;
    }
}
