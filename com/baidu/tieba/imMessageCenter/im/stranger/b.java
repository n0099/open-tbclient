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
/* loaded from: classes7.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView ehd;
    private StrangerListActivity hLO;
    private StrangerListAdapter hLT;
    private ImageView hLU;
    private BdListView htf;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hLO = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hLU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.hLO);
        SvgManager.aEp().a(this.hLU, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.ehd = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.hLO.getLayoutMode().setNightMode(i == 1);
        this.hLO.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hLO.getPageContext(), i);
        this.ehd.onChangeSkinType(this.hLO.getPageContext(), i);
        this.hLT.notifyDataSetChanged();
        SvgManager.aEp().a(this.hLU, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.htf = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.htf.setOnItemClickListener(strangerListActivity);
        this.htf.setOnItemLongClickListener(strangerListActivity);
        this.hLT = new StrangerListAdapter(strangerListActivity);
        this.htf.setAdapter((ListAdapter) this.hLT);
    }

    public StrangerListAdapter bXL() {
        return this.hLT;
    }

    public View bXM() {
        return this.hLU;
    }
}
