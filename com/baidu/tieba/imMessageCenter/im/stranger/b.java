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
    private NoNetworkView dlX;
    private StrangerListActivity gOc;
    private StrangerListAdapter gOi;
    private BdListView gvs;
    private ImageView mDeleteBtn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gOc = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mDeleteBtn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.gOc);
        al.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.dlX = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.gOc.getLayoutMode().setNightMode(i == 1);
        this.gOc.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gOc.getPageContext(), i);
        this.dlX.onChangeSkinType(this.gOc.getPageContext(), i);
        al.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.gvs = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.gvs.setOnItemClickListener(strangerListActivity);
        this.gvs.setOnItemLongClickListener(strangerListActivity);
        this.gOi = new StrangerListAdapter(strangerListActivity);
        this.gvs.setAdapter((ListAdapter) this.gOi);
    }

    public StrangerListAdapter bEY() {
        return this.gOi;
    }

    public View bEZ() {
        return this.mDeleteBtn;
    }
}
