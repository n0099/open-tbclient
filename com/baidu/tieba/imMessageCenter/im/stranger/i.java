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
    private BdListView EI;
    private NoNetworkView EV;
    private ViewGroup SJ;
    private StrangerListActivity dgj;
    private StrangerListAdapter dgp;
    private ImageView dgq;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(u.h.officialbar_msg_activity);
        this.dgj = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(u.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(u.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgq = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, u.h.stranger_delete, this.dgj);
        av.b(this.dgq, u.f.icon_tabbar_delete_bg_s, u.f.icon_tabbar_delete_bg);
        this.SJ = (ViewGroup) strangerListActivity.findViewById(u.g.root_view);
        this.EV = (NoNetworkView) this.SJ.findViewById(u.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dgj.getLayoutMode().af(i == 1);
        this.dgj.getLayoutMode().w(this.SJ);
        this.mNavigationBar.onChangeSkinType(this.dgj.getPageContext(), i);
        this.EV.onChangeSkinType(this.dgj.getPageContext(), i);
        av.b(this.dgq, u.f.icon_tabbar_delete_bg_s, u.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.EI = (BdListView) strangerListActivity.findViewById(u.g.msg_list);
        this.EI.setOnItemClickListener(strangerListActivity);
        this.EI.setOnItemLongClickListener(strangerListActivity);
        this.dgp = new StrangerListAdapter(strangerListActivity);
        this.EI.setAdapter((ListAdapter) this.dgp);
    }

    public StrangerListAdapter aub() {
        return this.dgp;
    }

    public View auc() {
        return this.dgq;
    }
}
