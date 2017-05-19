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
/* loaded from: classes2.dex */
public class i extends com.baidu.adp.base.e<StrangerListActivity> {
    private ViewGroup ZO;
    private NoNetworkView aSi;
    private BdListView cME;
    private StrangerListActivity dgm;
    private StrangerListAdapter dgs;
    private ImageView dgt;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(w.j.officialbar_msg_activity);
        this.dgm = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(w.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dgt = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.stranger_delete, this.dgm);
        aq.b(this.dgt, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
        this.ZO = (ViewGroup) strangerListActivity.findViewById(w.h.root_view);
        this.aSi = (NoNetworkView) this.ZO.findViewById(w.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dgm.getLayoutMode().ai(i == 1);
        this.dgm.getLayoutMode().t(this.ZO);
        this.mNavigationBar.onChangeSkinType(this.dgm.getPageContext(), i);
        this.aSi.onChangeSkinType(this.dgm.getPageContext(), i);
        aq.b(this.dgt, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.cME = (BdListView) strangerListActivity.findViewById(w.h.msg_list);
        this.cME.setOnItemClickListener(strangerListActivity);
        this.cME.setOnItemLongClickListener(strangerListActivity);
        this.dgs = new StrangerListAdapter(strangerListActivity);
        this.cME.setAdapter((ListAdapter) this.dgs);
    }

    public StrangerListAdapter asX() {
        return this.dgs;
    }

    public View asY() {
        return this.dgt;
    }
}
