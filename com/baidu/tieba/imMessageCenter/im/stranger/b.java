package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView blp;
    private BdListView dUy;
    private StrangerListActivity enm;
    private StrangerListAdapter ens;
    private ImageView ent;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.i.officialbar_msg_activity);
        this.enm = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.k.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.ent = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.stranger_delete, this.enm);
        ak.a(this.ent, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.blp = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.enm.getLayoutMode().setNightMode(i == 1);
        this.enm.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.enm.getPageContext(), i);
        this.blp.onChangeSkinType(this.enm.getPageContext(), i);
        ak.a(this.ent, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.dUy = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.dUy.setOnItemClickListener(strangerListActivity);
        this.dUy.setOnItemLongClickListener(strangerListActivity);
        this.ens = new StrangerListAdapter(strangerListActivity);
        this.dUy.setAdapter((ListAdapter) this.ens);
    }

    public StrangerListAdapter aIj() {
        return this.ens;
    }

    public View aIk() {
        return this.ent;
    }
}
