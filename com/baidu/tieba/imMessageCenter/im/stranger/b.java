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
/* loaded from: classes9.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView elh;
    private StrangerListActivity hNM;
    private StrangerListAdapter hNR;
    private ImageView hNS;
    private BdListView hve;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hNM = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hNS = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.hNM);
        SvgManager.aGA().a(this.hNS, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.elh = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.hNM.getLayoutMode().setNightMode(i == 1);
        this.hNM.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hNM.getPageContext(), i);
        this.elh.onChangeSkinType(this.hNM.getPageContext(), i);
        this.hNR.notifyDataSetChanged();
        SvgManager.aGA().a(this.hNS, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.hve = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.hve.setOnItemClickListener(strangerListActivity);
        this.hve.setOnItemLongClickListener(strangerListActivity);
        this.hNR = new StrangerListAdapter(strangerListActivity);
        this.hve.setAdapter((ListAdapter) this.hNR);
    }

    public StrangerListAdapter bZm() {
        return this.hNR;
    }

    public View bZn() {
        return this.hNS;
    }
}
