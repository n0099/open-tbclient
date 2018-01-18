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
    private NoNetworkView bYQ;
    private StrangerListActivity eNm;
    private StrangerListAdapter eNs;
    private ImageView eNt;
    private BdListView eue;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.eNm = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eNt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.eNm);
        aj.a(this.eNt, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.bYQ = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eNm.getLayoutMode().aM(i == 1);
        this.eNm.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eNm.getPageContext(), i);
        this.bYQ.onChangeSkinType(this.eNm.getPageContext(), i);
        aj.a(this.eNt, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.eue = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.eue.setOnItemClickListener(strangerListActivity);
        this.eue.setOnItemLongClickListener(strangerListActivity);
        this.eNs = new StrangerListAdapter(strangerListActivity);
        this.eue.setAdapter((ListAdapter) this.eNs);
    }

    public StrangerListAdapter aLK() {
        return this.eNs;
    }

    public View aLL() {
        return this.eNt;
    }
}
