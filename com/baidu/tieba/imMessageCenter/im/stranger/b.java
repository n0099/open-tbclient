package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView dlW;
    private StrangerListActivity gOb;
    private StrangerListAdapter gOh;
    private BdListView gvr;
    private ImageView mDeleteBtn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gOb = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mDeleteBtn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.gOb);
        al.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.dlW = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.gOb.getLayoutMode().setNightMode(i == 1);
        this.gOb.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gOb.getPageContext(), i);
        this.dlW.onChangeSkinType(this.gOb.getPageContext(), i);
        al.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.gvr = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.gvr.setOnItemClickListener(strangerListActivity);
        this.gvr.setOnItemLongClickListener(strangerListActivity);
        this.gOh = new StrangerListAdapter(strangerListActivity);
        this.gvr.setAdapter((ListAdapter) this.gOh);
    }

    public StrangerListAdapter bEV() {
        return this.gOh;
    }

    public View bEW() {
        return this.mDeleteBtn;
    }
}
