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
    private ViewGroup aan;
    private NoNetworkView bdg;
    private BdListView bjt;
    private StrangerListActivity dCg;
    private StrangerListAdapter dCm;
    private ImageView dCn;
    private NavigationBar mNavigationBar;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(d.j.officialbar_msg_activity);
        this.dCg = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(d.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(d.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dCn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, d.j.stranger_delete, this.dCg);
        ai.b(this.dCn, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
        this.aan = (ViewGroup) strangerListActivity.findViewById(d.h.root_view);
        this.bdg = (NoNetworkView) this.aan.findViewById(d.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dCg.getLayoutMode().ah(i == 1);
        this.dCg.getLayoutMode().t(this.aan);
        this.mNavigationBar.onChangeSkinType(this.dCg.getPageContext(), i);
        this.bdg.onChangeSkinType(this.dCg.getPageContext(), i);
        ai.b(this.dCn, d.g.icon_tabbar_delete_bg_s, d.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.bjt = (BdListView) strangerListActivity.findViewById(d.h.msg_list);
        this.bjt.setOnItemClickListener(strangerListActivity);
        this.bjt.setOnItemLongClickListener(strangerListActivity);
        this.dCm = new StrangerListAdapter(strangerListActivity);
        this.bjt.setAdapter((ListAdapter) this.dCm);
    }

    public StrangerListAdapter azd() {
        return this.dCm;
    }

    public View aze() {
        return this.dCn;
    }
}
