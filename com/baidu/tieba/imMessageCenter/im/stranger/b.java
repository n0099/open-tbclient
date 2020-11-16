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
/* loaded from: classes21.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView giU;
    private BdListView jZJ;
    private StrangerListActivity kua;
    private StrangerListAdapter kuf;
    private ImageView kug;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kua = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kug = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kua);
        SvgManager.bqB().a(this.kug, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.giU = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kua.getLayoutMode().setNightMode(i == 1);
        this.kua.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kua.getPageContext(), i);
        this.giU.onChangeSkinType(this.kua.getPageContext(), i);
        this.kuf.notifyDataSetChanged();
        SvgManager.bqB().a(this.kug, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.jZJ = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.jZJ.setOnItemClickListener(strangerListActivity);
        this.jZJ.setOnItemLongClickListener(strangerListActivity);
        this.kuf = new StrangerListAdapter(strangerListActivity);
        this.jZJ.setAdapter((ListAdapter) this.kuf);
    }

    public StrangerListAdapter cWb() {
        return this.kuf;
    }

    public View cWc() {
        return this.kug;
    }
}
