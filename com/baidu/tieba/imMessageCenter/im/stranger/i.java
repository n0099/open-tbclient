package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.e<StrangerListActivity> {
    private NoNetworkView aRv;
    private ViewGroup aac;
    private BdListView cRO;
    private StrangerListActivity dls;
    private StrangerListAdapter dly;
    private ImageView dlz;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(w.j.officialbar_msg_activity);
        this.dls = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(w.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dlz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.stranger_delete, this.dls);
        aq.b(this.dlz, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
        this.aac = (ViewGroup) strangerListActivity.findViewById(w.h.root_view);
        this.aRv = (NoNetworkView) this.aac.findViewById(w.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dls.getLayoutMode().ah(i == 1);
        this.dls.getLayoutMode().t(this.aac);
        this.mNavigationBar.onChangeSkinType(this.dls.getPageContext(), i);
        this.aRv.onChangeSkinType(this.dls.getPageContext(), i);
        aq.b(this.dlz, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.cRO = (BdListView) strangerListActivity.findViewById(w.h.msg_list);
        this.cRO.setOnItemClickListener(strangerListActivity);
        this.cRO.setOnItemLongClickListener(strangerListActivity);
        this.dly = new StrangerListAdapter(strangerListActivity);
        this.cRO.setAdapter((ListAdapter) this.dly);
    }

    public StrangerListAdapter avi() {
        return this.dly;
    }

    public View avj() {
        return this.dlz;
    }
}
