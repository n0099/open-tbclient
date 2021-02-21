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
    private NoNetworkView gAv;
    private BdListView kDK;
    private StrangerListActivity kQr;
    private StrangerListAdapter kQw;
    private ImageView kQx;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kQr = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kQx = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kQr);
        SvgManager.bsR().a(this.kQx, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.gAv = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kQr.getLayoutMode().setNightMode(i == 1);
        this.kQr.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kQr.getPageContext(), i);
        this.gAv.onChangeSkinType(this.kQr.getPageContext(), i);
        this.kQw.notifyDataSetChanged();
        SvgManager.bsR().a(this.kQx, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.kDK = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.kDK.setOnItemClickListener(strangerListActivity);
        this.kDK.setOnItemLongClickListener(strangerListActivity);
        this.kQw = new StrangerListAdapter(strangerListActivity);
        this.kDK.setAdapter((ListAdapter) this.kQw);
    }

    public StrangerListAdapter cZf() {
        return this.kQw;
    }

    public View cZg() {
        return this.kQx;
    }
}
