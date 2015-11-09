package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private StrangerListActivity bON;
    private StrangerListAdapter bOT;
    private ImageView bOU;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(i.g.officialbar_msg_activity);
        this.bON = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(i.f.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(i.h.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bOU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, i.g.stranger_delete, this.bON);
        an.a(this.bOU, i.e.icon_tabbar_delete_bg_s, i.e.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(i.f.root_view);
    }

    public void onChangeSkinType(int i) {
        this.bON.getLayoutMode().ad(i == 1);
        this.bON.getLayoutMode().k(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bON.getPageContext(), i);
        an.a(this.bOU, i.e.icon_tabbar_delete_bg_s, i.e.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.mBdListView = (BdListView) strangerListActivity.findViewById(i.f.msg_list);
        this.mBdListView.setOnItemClickListener(strangerListActivity);
        this.mBdListView.setOnItemLongClickListener(strangerListActivity);
        this.bOT = new StrangerListAdapter(strangerListActivity);
        this.mBdListView.setAdapter((ListAdapter) this.bOT);
    }

    public StrangerListAdapter aab() {
        return this.bOT;
    }

    public View aac() {
        return this.bOU;
    }
}
