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
/* loaded from: classes6.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView egT;
    private StrangerListActivity hIl;
    private StrangerListAdapter hIq;
    private ImageView hIr;
    private BdListView hpC;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hIl = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hIr = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.hIl);
        SvgManager.aDW().a(this.hIr, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.egT = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.hIl.getLayoutMode().setNightMode(i == 1);
        this.hIl.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hIl.getPageContext(), i);
        this.egT.onChangeSkinType(this.hIl.getPageContext(), i);
        this.hIq.notifyDataSetChanged();
        SvgManager.aDW().a(this.hIr, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.hpC = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.hpC.setOnItemClickListener(strangerListActivity);
        this.hpC.setOnItemLongClickListener(strangerListActivity);
        this.hIq = new StrangerListAdapter(strangerListActivity);
        this.hpC.setAdapter((ListAdapter) this.hIq);
    }

    public StrangerListAdapter bWC() {
        return this.hIq;
    }

    public View bWD() {
        return this.hIr;
    }
}
