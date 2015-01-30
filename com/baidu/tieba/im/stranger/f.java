package com.baidu.tieba.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.base.g;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import com.baidu.tieba.z;
/* loaded from: classes.dex */
public class f extends g<StrangerListActivity> {
    private StrangerListActivity bpn;
    private StrangerListAdapter bpt;
    private View bpu;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(x.officialbar_msg_activity);
        this.bpn = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(w.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(z.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.bpu = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, x.stranger_delete, this.bpn);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(w.root_view);
    }

    public void onChangeSkinType(int i) {
        this.bpn.getLayoutMode().ab(i == 1);
        this.bpn.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.bpn.getPageContext(), i);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.mBdListView = (BdListView) strangerListActivity.findViewById(w.msg_list);
        this.mBdListView.setOnItemClickListener(strangerListActivity);
        this.mBdListView.setOnItemLongClickListener(strangerListActivity);
        this.bpt = new StrangerListAdapter(strangerListActivity);
        this.mBdListView.setAdapter((ListAdapter) this.bpt);
    }

    public StrangerListAdapter Tx() {
        return this.bpt;
    }

    public View Ty() {
        return this.bpu;
    }
}
