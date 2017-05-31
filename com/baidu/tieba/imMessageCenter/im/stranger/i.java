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
    private ViewGroup ZN;
    private NoNetworkView aZX;
    private BdListView cSc;
    private StrangerListActivity dlI;
    private StrangerListAdapter dlO;
    private ImageView dlP;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(w.j.officialbar_msg_activity);
        this.dlI = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(w.h.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(w.l.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.dlP = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.j.stranger_delete, this.dlI);
        aq.b(this.dlP, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
        this.ZN = (ViewGroup) strangerListActivity.findViewById(w.h.root_view);
        this.aZX = (NoNetworkView) this.ZN.findViewById(w.h.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.dlI.getLayoutMode().ah(i == 1);
        this.dlI.getLayoutMode().t(this.ZN);
        this.mNavigationBar.onChangeSkinType(this.dlI.getPageContext(), i);
        this.aZX.onChangeSkinType(this.dlI.getPageContext(), i);
        aq.b(this.dlP, w.g.icon_tabbar_delete_bg_s, w.g.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.cSc = (BdListView) strangerListActivity.findViewById(w.h.msg_list);
        this.cSc.setOnItemClickListener(strangerListActivity);
        this.cSc.setOnItemLongClickListener(strangerListActivity);
        this.dlO = new StrangerListAdapter(strangerListActivity);
        this.cSc.setAdapter((ListAdapter) this.dlO);
    }

    public StrangerListAdapter atS() {
        return this.dlO;
    }

    public View atT() {
        return this.dlP;
    }
}
