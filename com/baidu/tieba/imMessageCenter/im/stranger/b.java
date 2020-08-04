package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView fsB;
    private BdListView iTZ;
    private StrangerListActivity jor;
    private StrangerListAdapter jow;
    private ImageView jox;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jor = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.jox = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.jor);
        SvgManager.baR().a(this.jox, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.fsB = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.jor.getLayoutMode().setNightMode(i == 1);
        this.jor.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jor.getPageContext(), i);
        this.fsB.onChangeSkinType(this.jor.getPageContext(), i);
        this.jow.notifyDataSetChanged();
        SvgManager.baR().a(this.jox, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.iTZ = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.iTZ.setOnItemClickListener(strangerListActivity);
        this.iTZ.setOnItemLongClickListener(strangerListActivity);
        this.jow = new StrangerListAdapter(strangerListActivity);
        this.iTZ.setAdapter((ListAdapter) this.jow);
    }

    public StrangerListAdapter cyH() {
        return this.jow;
    }

    public View cyI() {
        return this.jox;
    }
}
