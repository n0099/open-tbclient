package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView Ei;
    private NoNetworkView Ev;
    private ViewGroup Sb;
    private StrangerListActivity ddm;
    private StrangerListAdapter dds;
    private ImageView ddt;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(u.h.officialbar_msg_activity);
        this.ddm = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(u.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.ddt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.stranger_delete, this.ddm);
        av.a(this.ddt, u.f.icon_tabbar_delete_bg_s, u.f.icon_tabbar_delete_bg);
        this.Sb = (ViewGroup) strangerListActivity.findViewById(u.g.root_view);
        this.Ev = (NoNetworkView) this.Sb.findViewById(u.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.ddm.getLayoutMode().ad(i == 1);
        this.ddm.getLayoutMode().w(this.Sb);
        this.mNavigationBar.onChangeSkinType(this.ddm.getPageContext(), i);
        this.Ev.onChangeSkinType(this.ddm.getPageContext(), i);
        av.a(this.ddt, u.f.icon_tabbar_delete_bg_s, u.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.Ei = (BdListView) strangerListActivity.findViewById(u.g.msg_list);
        this.Ei.setOnItemClickListener(strangerListActivity);
        this.Ei.setOnItemLongClickListener(strangerListActivity);
        this.dds = new StrangerListAdapter(strangerListActivity);
        this.Ei.setAdapter((ListAdapter) this.dds);
    }

    public StrangerListAdapter atp() {
        return this.dds;
    }

    public View atq() {
        return this.ddt;
    }
}
