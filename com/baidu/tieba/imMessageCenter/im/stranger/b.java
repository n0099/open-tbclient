package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView dnM;
    private BdListView gCx;
    private StrangerListActivity gVg;
    private StrangerListAdapter gVm;
    private ImageView mDeleteBtn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gVg = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mDeleteBtn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.gVg);
        am.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.dnM = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.gVg.getLayoutMode().setNightMode(i == 1);
        this.gVg.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gVg.getPageContext(), i);
        this.dnM.onChangeSkinType(this.gVg.getPageContext(), i);
        am.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.gCx = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.gCx.setOnItemClickListener(strangerListActivity);
        this.gCx.setOnItemLongClickListener(strangerListActivity);
        this.gVm = new StrangerListAdapter(strangerListActivity);
        this.gCx.setAdapter((ListAdapter) this.gVm);
    }

    public StrangerListAdapter bHU() {
        return this.gVm;
    }

    public View bHV() {
        return this.mDeleteBtn;
    }
}
