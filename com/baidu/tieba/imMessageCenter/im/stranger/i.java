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
    private NoNetworkView aRN;
    private ViewGroup aat;
    private BdListView cSC;
    private StrangerListActivity dmi;
    private StrangerListAdapter dmo;
    private ImageView dmp;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(w.j.officialbar_msg_activity);
        this.dmi = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(w.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dmp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.stranger_delete, this.dmi);
        aq.b(this.dmp, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
        this.aat = (ViewGroup) strangerListActivity.findViewById(w.h.root_view);
        this.aRN = (NoNetworkView) this.aat.findViewById(w.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dmi.getLayoutMode().aj(i == 1);
        this.dmi.getLayoutMode().t(this.aat);
        this.mNavigationBar.onChangeSkinType(this.dmi.getPageContext(), i);
        this.aRN.onChangeSkinType(this.dmi.getPageContext(), i);
        aq.b(this.dmp, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.cSC = (BdListView) strangerListActivity.findViewById(w.h.msg_list);
        this.cSC.setOnItemClickListener(strangerListActivity);
        this.cSC.setOnItemLongClickListener(strangerListActivity);
        this.dmo = new StrangerListAdapter(strangerListActivity);
        this.cSC.setAdapter((ListAdapter) this.dmo);
    }

    public StrangerListAdapter awc() {
        return this.dmo;
    }

    public View awd() {
        return this.dmp;
    }
}
