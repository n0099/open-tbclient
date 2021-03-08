package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.d;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends d<StrangerListActivity> {
    private NoNetworkView gCe;
    private BdListView kFM;
    private StrangerListActivity kSt;
    private StrangerListAdapter kSy;
    private ImageView kSz;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kSt = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kSz = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kSt);
        SvgManager.bsU().a(this.kSz, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.gCe = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kSt.getLayoutMode().setNightMode(i == 1);
        this.kSt.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kSt.getPageContext(), i);
        this.gCe.onChangeSkinType(this.kSt.getPageContext(), i);
        this.kSy.notifyDataSetChanged();
        SvgManager.bsU().a(this.kSz, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.kFM = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.kFM.setOnItemClickListener(strangerListActivity);
        this.kFM.setOnItemLongClickListener(strangerListActivity);
        this.kSy = new StrangerListAdapter(strangerListActivity);
        this.kFM.setAdapter((ListAdapter) this.kSy);
    }

    public StrangerListAdapter cZm() {
        return this.kSy;
    }

    public View cZn() {
        return this.kSz;
    }
}
