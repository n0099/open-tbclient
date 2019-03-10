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
/* loaded from: classes4.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView dbq;
    private BdListView ges;
    private StrangerListActivity gxb;
    private StrangerListAdapter gxh;
    private ImageView mDeleteBtn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.gxb = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mDeleteBtn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.gxb);
        al.a(this.mDeleteBtn, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.dbq = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.gxb.getLayoutMode().setNightMode(i == 1);
        this.gxb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gxb.getPageContext(), i);
        this.dbq.onChangeSkinType(this.gxb.getPageContext(), i);
        al.a(this.mDeleteBtn, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.ges = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.ges.setOnItemClickListener(strangerListActivity);
        this.ges.setOnItemLongClickListener(strangerListActivity);
        this.gxh = new StrangerListAdapter(strangerListActivity);
        this.ges.setAdapter((ListAdapter) this.gxh);
    }

    public StrangerListAdapter bxr() {
        return this.gxh;
    }

    public View bxs() {
        return this.mDeleteBtn;
    }
}
