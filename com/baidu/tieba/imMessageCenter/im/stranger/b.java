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
    private NoNetworkView gAh;
    private BdListView kDw;
    private StrangerListActivity kQd;
    private StrangerListAdapter kQi;
    private ImageView kQj;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kQd = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kQj = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kQd);
        SvgManager.bsR().a(this.kQj, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.gAh = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kQd.getLayoutMode().setNightMode(i == 1);
        this.kQd.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kQd.getPageContext(), i);
        this.gAh.onChangeSkinType(this.kQd.getPageContext(), i);
        this.kQi.notifyDataSetChanged();
        SvgManager.bsR().a(this.kQj, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.kDw = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.kDw.setOnItemClickListener(strangerListActivity);
        this.kDw.setOnItemLongClickListener(strangerListActivity);
        this.kQi = new StrangerListAdapter(strangerListActivity);
        this.kDw.setAdapter((ListAdapter) this.kQi);
    }

    public StrangerListAdapter cYY() {
        return this.kQi;
    }

    public View cYZ() {
        return this.kQj;
    }
}
