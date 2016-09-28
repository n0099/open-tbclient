package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView GV;
    private NoNetworkView Hi;
    private ViewGroup VJ;
    private StrangerListActivity dtn;
    private StrangerListAdapter dtt;
    private ImageView dtu;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(r.h.officialbar_msg_activity);
        this.dtn = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(r.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(r.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dtu = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.h.stranger_delete, this.dtn);
        av.b(this.dtu, r.f.icon_tabbar_delete_bg_s, r.f.icon_tabbar_delete_bg);
        this.VJ = (ViewGroup) strangerListActivity.findViewById(r.g.root_view);
        this.Hi = (NoNetworkView) this.VJ.findViewById(r.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dtn.getLayoutMode().ah(i == 1);
        this.dtn.getLayoutMode().x(this.VJ);
        this.mNavigationBar.onChangeSkinType(this.dtn.getPageContext(), i);
        this.Hi.onChangeSkinType(this.dtn.getPageContext(), i);
        av.b(this.dtu, r.f.icon_tabbar_delete_bg_s, r.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.GV = (BdListView) strangerListActivity.findViewById(r.g.msg_list);
        this.GV.setOnItemClickListener(strangerListActivity);
        this.GV.setOnItemLongClickListener(strangerListActivity);
        this.dtt = new StrangerListAdapter(strangerListActivity);
        this.GV.setAdapter((ListAdapter) this.dtt);
    }

    public StrangerListAdapter azn() {
        return this.dtt;
    }

    public View azo() {
        return this.dtu;
    }
}
