package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.base.e<StrangerListActivity> {
    private ViewGroup ZO;
    private NoNetworkView bbO;
    private BdListView bgi;
    private StrangerListActivity dtE;
    private StrangerListAdapter dtK;
    private ImageView dtL;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(w.j.officialbar_msg_activity);
        this.dtE = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(w.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dtL = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.stranger_delete, this.dtE);
        as.b(this.dtL, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
        this.ZO = (ViewGroup) strangerListActivity.findViewById(w.h.root_view);
        this.bbO = (NoNetworkView) this.ZO.findViewById(w.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dtE.getLayoutMode().ah(i == 1);
        this.dtE.getLayoutMode().t(this.ZO);
        this.mNavigationBar.onChangeSkinType(this.dtE.getPageContext(), i);
        this.bbO.onChangeSkinType(this.dtE.getPageContext(), i);
        as.b(this.dtL, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bgi = (BdListView) strangerListActivity.findViewById(w.h.msg_list);
        this.bgi.setOnItemClickListener(strangerListActivity);
        this.bgi.setOnItemLongClickListener(strangerListActivity);
        this.dtK = new StrangerListAdapter(strangerListActivity);
        this.bgi.setAdapter((ListAdapter) this.dtK);
    }

    public StrangerListAdapter axA() {
        return this.dtK;
    }

    public View axB() {
        return this.dtL;
    }
}
