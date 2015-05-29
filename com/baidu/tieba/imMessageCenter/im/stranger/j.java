package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.q;
import com.baidu.tieba.r;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.g<StrangerListActivity> {
    private StrangerListAdapter bwF;
    private View bwG;
    private StrangerListActivity bwz;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public j(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(r.officialbar_msg_activity);
        this.bwz = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(q.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(t.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bwG = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, r.stranger_delete, this.bwz);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(q.root_view);
    }

    public void onChangeSkinType(int i) {
        this.bwz.getLayoutMode().ab(i == 1);
        this.bwz.getLayoutMode().j(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bwz.getPageContext(), i);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.mBdListView = (BdListView) strangerListActivity.findViewById(q.msg_list);
        this.mBdListView.setOnItemClickListener(strangerListActivity);
        this.mBdListView.setOnItemLongClickListener(strangerListActivity);
        this.bwF = new StrangerListAdapter(strangerListActivity);
        this.mBdListView.setAdapter((ListAdapter) this.bwF);
    }

    public StrangerListAdapter Xn() {
        return this.bwF;
    }

    public View Xo() {
        return this.bwG;
    }
}
