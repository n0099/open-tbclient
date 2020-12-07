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
    private NoNetworkView grd;
    private ImageView kHA;
    private StrangerListActivity kHu;
    private StrangerListAdapter kHz;
    private BdListView kno;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kHu = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kHA = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kHu);
        SvgManager.btW().a(this.kHA, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.grd = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kHu.getLayoutMode().setNightMode(i == 1);
        this.kHu.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kHu.getPageContext(), i);
        this.grd.onChangeSkinType(this.kHu.getPageContext(), i);
        this.kHz.notifyDataSetChanged();
        SvgManager.btW().a(this.kHA, R.drawable.icon_pure_topbar_delete44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.kno = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.kno.setOnItemClickListener(strangerListActivity);
        this.kno.setOnItemLongClickListener(strangerListActivity);
        this.kHz = new StrangerListAdapter(strangerListActivity);
        this.kno.setAdapter((ListAdapter) this.kHz);
    }

    public StrangerListAdapter dbn() {
        return this.kHz;
    }

    public View dbo() {
        return this.kHA;
    }
}
