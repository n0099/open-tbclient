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
    private NoNetworkView fDZ;
    private StrangerListAdapter jDA;
    private ImageView jDB;
    private StrangerListActivity jDv;
    private BdListView jjd;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jDv = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.jDB = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.jDv);
        SvgManager.bjq().a(this.jDB, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.fDZ = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.jDv.getLayoutMode().setNightMode(i == 1);
        this.jDv.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jDv.getPageContext(), i);
        this.fDZ.onChangeSkinType(this.jDv.getPageContext(), i);
        this.jDA.notifyDataSetChanged();
        SvgManager.bjq().a(this.jDB, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.jjd = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.jjd.setOnItemClickListener(strangerListActivity);
        this.jjd.setOnItemLongClickListener(strangerListActivity);
        this.jDA = new StrangerListAdapter(strangerListActivity);
        this.jjd.setAdapter((ListAdapter) this.jDA);
    }

    public StrangerListAdapter cJz() {
        return this.jDA;
    }

    public View cJA() {
        return this.jDB;
    }
}
