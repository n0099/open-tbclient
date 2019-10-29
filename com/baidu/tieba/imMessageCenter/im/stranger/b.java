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
    private NoNetworkView dwI;
    private BdListView gCo;
    private StrangerListActivity gUZ;
    private StrangerListAdapter gVf;
    private ImageView gVg;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gUZ = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.gVg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.gUZ);
        SvgManager.amN().a(this.gVg, R.drawable.icon_pure_topbar_delete_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.dwI = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.gUZ.getLayoutMode().setNightMode(i == 1);
        this.gUZ.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gUZ.getPageContext(), i);
        this.dwI.onChangeSkinType(this.gUZ.getPageContext(), i);
        this.gVf.notifyDataSetChanged();
        SvgManager.amN().a(this.gVg, R.drawable.icon_pure_topbar_delete_n_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.gCo = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.gCo.setOnItemClickListener(strangerListActivity);
        this.gCo.setOnItemLongClickListener(strangerListActivity);
        this.gVf = new StrangerListAdapter(strangerListActivity);
        this.gCo.setAdapter((ListAdapter) this.gVf);
    }

    public StrangerListAdapter bFs() {
        return this.gVf;
    }

    public View bFt() {
        return this.gVg;
    }
}
