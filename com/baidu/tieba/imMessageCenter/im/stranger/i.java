package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView GW;
    private NoNetworkView Hj;
    private ViewGroup VB;
    private StrangerListActivity dbN;
    private StrangerListAdapter dbT;
    private ImageView dbU;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(r.h.officialbar_msg_activity);
        this.dbN = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(r.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dbU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.stranger_delete, this.dbN);
        ar.b(this.dbU, r.f.icon_tabbar_delete_bg_s, r.f.icon_tabbar_delete_bg);
        this.VB = (ViewGroup) strangerListActivity.findViewById(r.g.root_view);
        this.Hj = (NoNetworkView) this.VB.findViewById(r.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dbN.getLayoutMode().ai(i == 1);
        this.dbN.getLayoutMode().x(this.VB);
        this.mNavigationBar.onChangeSkinType(this.dbN.getPageContext(), i);
        this.Hj.onChangeSkinType(this.dbN.getPageContext(), i);
        ar.b(this.dbU, r.f.icon_tabbar_delete_bg_s, r.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.GW = (BdListView) strangerListActivity.findViewById(r.g.msg_list);
        this.GW.setOnItemClickListener(strangerListActivity);
        this.GW.setOnItemLongClickListener(strangerListActivity);
        this.dbT = new StrangerListAdapter(strangerListActivity);
        this.GW.setAdapter((ListAdapter) this.dbT);
    }

    public StrangerListAdapter auG() {
        return this.dbT;
    }

    public View auH() {
        return this.dbU;
    }
}
