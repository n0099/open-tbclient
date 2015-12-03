package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private StrangerListActivity cdQ;
    private StrangerListAdapter cdW;
    private ImageView cdX;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(n.g.officialbar_msg_activity);
        this.cdQ = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(n.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(n.i.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cdX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, n.g.stranger_delete, this.cdQ);
        as.a(this.cdX, n.e.icon_tabbar_delete_bg_s, n.e.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(n.f.root_view);
    }

    public void onChangeSkinType(int i) {
        this.cdQ.getLayoutMode().af(i == 1);
        this.cdQ.getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.cdQ.getPageContext(), i);
        as.a(this.cdX, n.e.icon_tabbar_delete_bg_s, n.e.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.mBdListView = (BdListView) strangerListActivity.findViewById(n.f.msg_list);
        this.mBdListView.setOnItemClickListener(strangerListActivity);
        this.mBdListView.setOnItemLongClickListener(strangerListActivity);
        this.cdW = new StrangerListAdapter(strangerListActivity);
        this.mBdListView.setAdapter((ListAdapter) this.cdW);
    }

    public StrangerListAdapter adh() {
        return this.cdW;
    }

    public View adi() {
        return this.cdX;
    }
}
