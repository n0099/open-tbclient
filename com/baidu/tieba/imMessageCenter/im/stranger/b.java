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
    private NoNetworkView bla;
    private BdListView dTr;
    private StrangerListActivity eme;
    private StrangerListAdapter emk;
    private ImageView eml;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.i.officialbar_msg_activity);
        this.eme = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(d.k.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.eml = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.i.stranger_delete, this.eme);
        ak.a(this.eml, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(d.g.root_view);
        this.bla = (NoNetworkView) this.mRootView.findViewById(d.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.eme.getLayoutMode().setNightMode(i == 1);
        this.eme.getLayoutMode().u(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.eme.getPageContext(), i);
        this.bla.onChangeSkinType(this.eme.getPageContext(), i);
        ak.a(this.eml, d.f.icon_tabbar_delete_bg_s, d.f.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.dTr = (BdListView) strangerListActivity.findViewById(d.g.msg_list);
        this.dTr.setOnItemClickListener(strangerListActivity);
        this.dTr.setOnItemLongClickListener(strangerListActivity);
        this.emk = new StrangerListAdapter(strangerListActivity);
        this.dTr.setAdapter((ListAdapter) this.emk);
    }

    public StrangerListAdapter aIl() {
        return this.emk;
    }

    public View aIm() {
        return this.eml;
    }
}
