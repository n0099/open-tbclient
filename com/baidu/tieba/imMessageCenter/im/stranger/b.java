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
    private NoNetworkView blt;
    private BdListView buZ;
    private StrangerListActivity dYA;
    private StrangerListAdapter dYG;
    private ImageView dYH;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.h.officialbar_msg_activity);
        this.dYA = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.dYH = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.h.stranger_delete, this.dYA);
        aj.a(this.dYH, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.blt = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dYA.getLayoutMode().ag(i == 1);
        this.dYA.getLayoutMode().t(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.dYA.getPageContext(), i);
        this.blt.onChangeSkinType(this.dYA.getPageContext(), i);
        aj.a(this.dYH, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.buZ = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.buZ.setOnItemClickListener(strangerListActivity);
        this.buZ.setOnItemLongClickListener(strangerListActivity);
        this.dYG = new StrangerListAdapter(strangerListActivity);
        this.buZ.setAdapter((ListAdapter) this.dYG);
    }

    public StrangerListAdapter aEv() {
        return this.dYG;
    }

    public View aEw() {
        return this.dYH;
    }
}
