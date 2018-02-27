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
    private NoNetworkView caX;
    private StrangerListActivity eRE;
    private StrangerListAdapter eRK;
    private ImageView eRL;
    private BdListView eyB;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.eRE = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eRL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.eRE);
        aj.a(this.eRL, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.caX = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eRE.getLayoutMode().aQ(i == 1);
        this.eRE.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eRE.getPageContext(), i);
        this.caX.onChangeSkinType(this.eRE.getPageContext(), i);
        aj.a(this.eRL, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.eyB = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.eyB.setOnItemClickListener(strangerListActivity);
        this.eyB.setOnItemLongClickListener(strangerListActivity);
        this.eRK = new StrangerListAdapter(strangerListActivity);
        this.eyB.setAdapter((ListAdapter) this.eRK);
    }

    public StrangerListAdapter aNp() {
        return this.eRK;
    }

    public View aNq() {
        return this.eRL;
    }
}
