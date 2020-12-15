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
/* loaded from: classes22.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView grf;
    private StrangerListAdapter kHB;
    private ImageView kHC;
    private StrangerListActivity kHw;
    private BdListView knq;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kHw = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kHC = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kHw);
        SvgManager.btW().a(this.kHC, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.grf = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kHw.getLayoutMode().setNightMode(i == 1);
        this.kHw.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kHw.getPageContext(), i);
        this.grf.onChangeSkinType(this.kHw.getPageContext(), i);
        this.kHB.notifyDataSetChanged();
        SvgManager.btW().a(this.kHC, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.knq = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.knq.setOnItemClickListener(strangerListActivity);
        this.knq.setOnItemLongClickListener(strangerListActivity);
        this.kHB = new StrangerListAdapter(strangerListActivity);
        this.knq.setAdapter((ListAdapter) this.kHB);
    }

    public StrangerListAdapter dbo() {
        return this.kHB;
    }

    public View dbp() {
        return this.kHC;
    }
}
