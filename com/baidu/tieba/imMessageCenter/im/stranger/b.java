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
    private NoNetworkView cbj;
    private StrangerListActivity eRQ;
    private StrangerListAdapter eRW;
    private ImageView eRX;
    private BdListView eyN;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.eRQ = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eRX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.eRQ);
        aj.a(this.eRX, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.cbj = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eRQ.getLayoutMode().aQ(i == 1);
        this.eRQ.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eRQ.getPageContext(), i);
        this.cbj.onChangeSkinType(this.eRQ.getPageContext(), i);
        aj.a(this.eRX, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.eyN = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.eyN.setOnItemClickListener(strangerListActivity);
        this.eyN.setOnItemLongClickListener(strangerListActivity);
        this.eRW = new StrangerListAdapter(strangerListActivity);
        this.eyN.setAdapter((ListAdapter) this.eRW);
    }

    public StrangerListAdapter aNq() {
        return this.eRW;
    }

    public View aNr() {
        return this.eRX;
    }
}
