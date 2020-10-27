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
    private NoNetworkView gdx;
    private BdListView jTd;
    private ImageView knA;
    private StrangerListActivity knu;
    private StrangerListAdapter knz;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.knu = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.knA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.knu);
        SvgManager.boN().a(this.knA, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.gdx = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.knu.getLayoutMode().setNightMode(i == 1);
        this.knu.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.knu.getPageContext(), i);
        this.gdx.onChangeSkinType(this.knu.getPageContext(), i);
        this.knz.notifyDataSetChanged();
        SvgManager.boN().a(this.knA, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.jTd = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.jTd.setOnItemClickListener(strangerListActivity);
        this.jTd.setOnItemLongClickListener(strangerListActivity);
        this.knz = new StrangerListAdapter(strangerListActivity);
        this.jTd.setAdapter((ListAdapter) this.knz);
    }

    public StrangerListAdapter cTU() {
        return this.knz;
    }

    public View cTV() {
        return this.knA;
    }
}
