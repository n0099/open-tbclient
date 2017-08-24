package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class b extends c<StrangerListActivity> {
    private ViewGroup abM;
    private NoNetworkView bes;
    private BdListView bkI;
    private StrangerListAdapter dFA;
    private ImageView dFB;
    private StrangerListActivity dFu;
    private NavigationBar mNavigationBar;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.j.officialbar_msg_activity);
        this.dFu = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(d.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dFB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.stranger_delete, this.dFu);
        ai.b(this.dFB, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
        this.abM = (ViewGroup) strangerListActivity.findViewById(d.h.root_view);
        this.bes = (NoNetworkView) this.abM.findViewById(d.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dFu.getLayoutMode().ah(i == 1);
        this.dFu.getLayoutMode().t(this.abM);
        this.mNavigationBar.onChangeSkinType(this.dFu.getPageContext(), i);
        this.bes.onChangeSkinType(this.dFu.getPageContext(), i);
        ai.b(this.dFB, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bkI = (BdListView) strangerListActivity.findViewById(d.h.msg_list);
        this.bkI.setOnItemClickListener(strangerListActivity);
        this.bkI.setOnItemLongClickListener(strangerListActivity);
        this.dFA = new StrangerListAdapter(strangerListActivity);
        this.bkI.setAdapter((ListAdapter) this.dFA);
    }

    public StrangerListAdapter azQ() {
        return this.dFA;
    }

    public View azR() {
        return this.dFB;
    }
}
