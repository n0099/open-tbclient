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
/* loaded from: classes4.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView dvR;
    private BdListView gBx;
    private StrangerListActivity gUi;
    private StrangerListAdapter gUo;
    private ImageView gUp;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gUi = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gUp = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.gUi);
        SvgManager.amL().a(this.gUp, R.drawable.icon_pure_topbar_delete_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.dvR = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.gUi.getLayoutMode().setNightMode(i == 1);
        this.gUi.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gUi.getPageContext(), i);
        this.dvR.onChangeSkinType(this.gUi.getPageContext(), i);
        this.gUo.notifyDataSetChanged();
        SvgManager.amL().a(this.gUp, R.drawable.icon_pure_topbar_delete_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.gBx = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.gBx.setOnItemClickListener(strangerListActivity);
        this.gBx.setOnItemLongClickListener(strangerListActivity);
        this.gUo = new StrangerListAdapter(strangerListActivity);
        this.gBx.setAdapter((ListAdapter) this.gUo);
    }

    public StrangerListAdapter bFq() {
        return this.gUo;
    }

    public View bFr() {
        return this.gUp;
    }
}
