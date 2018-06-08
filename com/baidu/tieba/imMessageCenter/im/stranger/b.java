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
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView btu;
    private BdListView efL;
    private StrangerListActivity eyE;
    private StrangerListAdapter eyK;
    private ImageView eyL;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.i.officialbar_msg_activity);
        this.eyE = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.k.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eyL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.stranger_delete, this.eyE);
        al.a(this.eyL, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.btu = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eyE.getLayoutMode().setNightMode(i == 1);
        this.eyE.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eyE.getPageContext(), i);
        this.btu.onChangeSkinType(this.eyE.getPageContext(), i);
        al.a(this.eyL, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.efL = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.efL.setOnItemClickListener(strangerListActivity);
        this.efL.setOnItemLongClickListener(strangerListActivity);
        this.eyK = new StrangerListAdapter(strangerListActivity);
        this.efL.setAdapter((ListAdapter) this.eyK);
    }

    public StrangerListAdapter aNe() {
        return this.eyK;
    }

    public View aNf() {
        return this.eyL;
    }
}
