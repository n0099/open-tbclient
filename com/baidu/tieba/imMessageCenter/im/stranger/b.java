package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView bvz;
    private StrangerListActivity eGn;
    private StrangerListAdapter eGt;
    private ImageView eGu;
    private BdListView enw;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.eGn = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eGu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.eGn);
        am.a(this.eGu, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.bvz = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eGn.getLayoutMode().setNightMode(i == 1);
        this.eGn.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eGn.getPageContext(), i);
        this.bvz.onChangeSkinType(this.eGn.getPageContext(), i);
        am.a(this.eGu, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.enw = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.enw.setOnItemClickListener(strangerListActivity);
        this.enw.setOnItemLongClickListener(strangerListActivity);
        this.eGt = new StrangerListAdapter(strangerListActivity);
        this.enw.setAdapter((ListAdapter) this.eGt);
    }

    public StrangerListAdapter aOK() {
        return this.eGt;
    }

    public View aOL() {
        return this.eGu;
    }
}
