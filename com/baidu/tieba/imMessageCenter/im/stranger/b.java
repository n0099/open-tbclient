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
    private NoNetworkView fci;
    private StrangerListActivity iOR;
    private StrangerListAdapter iOW;
    private ImageView iOX;
    private BdListView iwh;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.iOR = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.iOX = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.iOR);
        SvgManager.aUW().a(this.iOX, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.fci = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.iOR.getLayoutMode().setNightMode(i == 1);
        this.iOR.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.iOR.getPageContext(), i);
        this.fci.onChangeSkinType(this.iOR.getPageContext(), i);
        this.iOW.notifyDataSetChanged();
        SvgManager.aUW().a(this.iOX, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.iwh = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.iwh.setOnItemClickListener(strangerListActivity);
        this.iwh.setOnItemLongClickListener(strangerListActivity);
        this.iOW = new StrangerListAdapter(strangerListActivity);
        this.iwh.setAdapter((ListAdapter) this.iOW);
    }

    public StrangerListAdapter cqO() {
        return this.iOW;
    }

    public View cqP() {
        return this.iOX;
    }
}
