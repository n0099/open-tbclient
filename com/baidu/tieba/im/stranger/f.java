package com.baidu.tieba.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class f extends com.baidu.adp.base.f {
    private BdListView azI;
    private StrangerListActivity biA;
    private StrangerListAdapter biG;
    private View biH;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public f(StrangerListActivity strangerListActivity) {
        super(strangerListActivity);
        strangerListActivity.setContentView(w.officialbar_msg_activity);
        this.biA = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(v.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getString(y.stranger_message_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.biH = this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.stranger_delete, this.biA);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(v.root_view);
    }

    public void onChangeSkinType(int i) {
        this.biA.getLayoutMode().L(i == 1);
        this.biA.getLayoutMode().h(this.mRootView);
        this.mNavigationBar.onChangeSkinType(i);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.azI = (BdListView) strangerListActivity.findViewById(v.msg_list);
        this.azI.setOnItemClickListener(strangerListActivity);
        this.azI.setOnItemLongClickListener(strangerListActivity);
        this.biG = new StrangerListAdapter(strangerListActivity);
        this.azI.setAdapter((ListAdapter) this.biG);
    }

    public StrangerListAdapter RH() {
        return this.biG;
    }

    public View RI() {
        return this.biH;
    }
}
