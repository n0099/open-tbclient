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
    private NoNetworkView aRL;
    private ViewGroup aas;
    private BdListView cQl;
    private StrangerListActivity djR;
    private StrangerListAdapter djX;
    private ImageView djY;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(w.j.officialbar_msg_activity);
        this.djR = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(w.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.djY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.stranger_delete, this.djR);
        aq.b(this.djY, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
        this.aas = (ViewGroup) strangerListActivity.findViewById(w.h.root_view);
        this.aRL = (NoNetworkView) this.aas.findViewById(w.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.djR.getLayoutMode().aj(i == 1);
        this.djR.getLayoutMode().t(this.aas);
        this.mNavigationBar.onChangeSkinType(this.djR.getPageContext(), i);
        this.aRL.onChangeSkinType(this.djR.getPageContext(), i);
        aq.b(this.djY, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.cQl = (BdListView) strangerListActivity.findViewById(w.h.msg_list);
        this.cQl.setOnItemClickListener(strangerListActivity);
        this.cQl.setOnItemLongClickListener(strangerListActivity);
        this.djX = new StrangerListAdapter(strangerListActivity);
        this.cQl.setAdapter((ListAdapter) this.djX);
    }

    public StrangerListAdapter avb() {
        return this.djX;
    }

    public View avc() {
        return this.djY;
    }
}
