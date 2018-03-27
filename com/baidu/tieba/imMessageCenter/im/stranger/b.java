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
    private NoNetworkView cba;
    private StrangerListActivity eRT;
    private StrangerListAdapter eRZ;
    private ImageView eSa;
    private BdListView eyR;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.eRT = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eSa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.eRT);
        aj.a(this.eSa, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.cba = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eRT.getLayoutMode().aQ(i == 1);
        this.eRT.getLayoutMode().aM(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eRT.getPageContext(), i);
        this.cba.onChangeSkinType(this.eRT.getPageContext(), i);
        aj.a(this.eSa, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.eyR = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.eyR.setOnItemClickListener(strangerListActivity);
        this.eyR.setOnItemLongClickListener(strangerListActivity);
        this.eRZ = new StrangerListAdapter(strangerListActivity);
        this.eyR.setAdapter((ListAdapter) this.eRZ);
    }

    public StrangerListAdapter aNq() {
        return this.eRZ;
    }

    public View aNr() {
        return this.eSa;
    }
}
