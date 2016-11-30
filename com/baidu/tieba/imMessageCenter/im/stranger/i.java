package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView GX;
    private NoNetworkView Hk;
    private ViewGroup Wh;
    private StrangerListActivity dyS;
    private StrangerListAdapter dyY;
    private ImageView dyZ;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(r.h.officialbar_msg_activity);
        this.dyS = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(r.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dyZ = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.stranger_delete, this.dyS);
        at.b(this.dyZ, r.f.icon_tabbar_delete_bg_s, r.f.icon_tabbar_delete_bg);
        this.Wh = (ViewGroup) strangerListActivity.findViewById(r.g.root_view);
        this.Hk = (NoNetworkView) this.Wh.findViewById(r.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dyS.getLayoutMode().ai(i == 1);
        this.dyS.getLayoutMode().x(this.Wh);
        this.mNavigationBar.onChangeSkinType(this.dyS.getPageContext(), i);
        this.Hk.onChangeSkinType(this.dyS.getPageContext(), i);
        at.b(this.dyZ, r.f.icon_tabbar_delete_bg_s, r.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.GX = (BdListView) strangerListActivity.findViewById(r.g.msg_list);
        this.GX.setOnItemClickListener(strangerListActivity);
        this.GX.setOnItemLongClickListener(strangerListActivity);
        this.dyY = new StrangerListAdapter(strangerListActivity);
        this.GX.setAdapter((ListAdapter) this.dyY);
    }

    public StrangerListAdapter aBk() {
        return this.dyY;
    }

    public View aBl() {
        return this.dyZ;
    }
}
