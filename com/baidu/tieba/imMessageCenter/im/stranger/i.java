package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<StrangerListActivity> {
    private BdListView Gg;
    private NoNetworkView Gt;
    private ViewGroup UR;
    private StrangerListActivity diZ;
    private StrangerListAdapter djf;
    private ImageView djg;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(r.j.officialbar_msg_activity);
        this.diZ = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(r.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(r.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.djg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.j.stranger_delete, this.diZ);
        ap.b(this.djg, r.g.icon_tabbar_delete_bg_s, r.g.icon_tabbar_delete_bg);
        this.UR = (ViewGroup) strangerListActivity.findViewById(r.h.root_view);
        this.Gt = (NoNetworkView) this.UR.findViewById(r.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.diZ.getLayoutMode().ai(i == 1);
        this.diZ.getLayoutMode().v(this.UR);
        this.mNavigationBar.onChangeSkinType(this.diZ.getPageContext(), i);
        this.Gt.onChangeSkinType(this.diZ.getPageContext(), i);
        ap.b(this.djg, r.g.icon_tabbar_delete_bg_s, r.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.Gg = (BdListView) strangerListActivity.findViewById(r.h.msg_list);
        this.Gg.setOnItemClickListener(strangerListActivity);
        this.Gg.setOnItemLongClickListener(strangerListActivity);
        this.djf = new StrangerListAdapter(strangerListActivity);
        this.Gg.setAdapter((ListAdapter) this.djf);
    }

    public StrangerListAdapter avM() {
        return this.djf;
    }

    public View avN() {
        return this.djg;
    }
}
