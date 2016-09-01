package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView GV;
    private NoNetworkView Hi;
    private ViewGroup Vz;
    private StrangerListActivity drQ;
    private StrangerListAdapter drW;
    private ImageView drX;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(t.h.officialbar_msg_activity);
        this.drQ = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(t.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.drX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.stranger_delete, this.drQ);
        av.b(this.drX, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
        this.Vz = (ViewGroup) strangerListActivity.findViewById(t.g.root_view);
        this.Hi = (NoNetworkView) this.Vz.findViewById(t.g.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.drQ.getLayoutMode().ah(i == 1);
        this.drQ.getLayoutMode().x(this.Vz);
        this.mNavigationBar.onChangeSkinType(this.drQ.getPageContext(), i);
        this.Hi.onChangeSkinType(this.drQ.getPageContext(), i);
        av.b(this.drX, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.GV = (BdListView) strangerListActivity.findViewById(t.g.msg_list);
        this.GV.setOnItemClickListener(strangerListActivity);
        this.GV.setOnItemLongClickListener(strangerListActivity);
        this.drW = new StrangerListAdapter(strangerListActivity);
        this.GV.setAdapter((ListAdapter) this.drW);
    }

    public StrangerListAdapter ayP() {
        return this.drW;
    }

    public View ayQ() {
        return this.drX;
    }
}
