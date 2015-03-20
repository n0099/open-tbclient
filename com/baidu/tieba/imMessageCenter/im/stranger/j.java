package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.g<StrangerListActivity> {
    private StrangerListActivity btA;
    private StrangerListAdapter btG;
    private View btH;
    private BdListView mBdListView;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public j(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(w.officialbar_msg_activity);
        this.btA = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(y.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.btH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.stranger_delete, this.btA);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(v.root_view);
    }

    public void onChangeSkinType(int i) {
        this.btA.getLayoutMode().X(i == 1);
        this.btA.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.btA.getPageContext(), i);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.mBdListView = (BdListView) strangerListActivity.findViewById(v.msg_list);
        this.mBdListView.setOnItemClickListener(strangerListActivity);
        this.mBdListView.setOnItemLongClickListener(strangerListActivity);
        this.btG = new StrangerListAdapter(strangerListActivity);
        this.mBdListView.setAdapter((ListAdapter) this.btG);
    }

    public StrangerListAdapter VI() {
        return this.btG;
    }

    public View VJ() {
        return this.btH;
    }
}
