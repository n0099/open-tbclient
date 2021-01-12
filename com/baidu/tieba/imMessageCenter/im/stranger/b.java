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
    private NoNetworkView gxx;
    private StrangerListActivity kIa;
    private StrangerListAdapter kIf;
    private ImageView kIg;
    private BdListView kvq;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kIa = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kIg = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kIa);
        SvgManager.bsx().a(this.kIg, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.gxx = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kIa.getLayoutMode().setNightMode(i == 1);
        this.kIa.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kIa.getPageContext(), i);
        this.gxx.onChangeSkinType(this.kIa.getPageContext(), i);
        this.kIf.notifyDataSetChanged();
        SvgManager.bsx().a(this.kIg, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.kvq = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.kvq.setOnItemClickListener(strangerListActivity);
        this.kvq.setOnItemLongClickListener(strangerListActivity);
        this.kIf = new StrangerListAdapter(strangerListActivity);
        this.kvq.setAdapter((ListAdapter) this.kIf);
    }

    public StrangerListAdapter cXa() {
        return this.kIf;
    }

    public View cXb() {
        return this.kIg;
    }
}
