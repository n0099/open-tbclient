package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView Ed;
    private ViewGroup RI;
    private StrangerListActivity cxR;
    private StrangerListAdapter cxX;
    private ImageView cxY;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(t.h.officialbar_msg_activity);
        this.cxR = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(t.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cxY = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.stranger_delete, this.cxR);
        at.a(this.cxY, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
        this.RI = (ViewGroup) strangerListActivity.findViewById(t.g.root_view);
    }

    public void onChangeSkinType(int i) {
        this.cxR.getLayoutMode().ae(i == 1);
        this.cxR.getLayoutMode().x(this.RI);
        this.mNavigationBar.onChangeSkinType(this.cxR.getPageContext(), i);
        at.a(this.cxY, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.Ed = (BdListView) strangerListActivity.findViewById(t.g.msg_list);
        this.Ed.setOnItemClickListener(strangerListActivity);
        this.Ed.setOnItemLongClickListener(strangerListActivity);
        this.cxX = new StrangerListAdapter(strangerListActivity);
        this.Ed.setAdapter((ListAdapter) this.cxX);
    }

    public StrangerListAdapter ala() {
        return this.cxX;
    }

    public View alb() {
        return this.cxY;
    }
}
