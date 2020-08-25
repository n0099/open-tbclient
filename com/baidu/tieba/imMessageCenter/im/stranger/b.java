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
/* loaded from: classes16.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView fDV;
    private StrangerListActivity jDp;
    private StrangerListAdapter jDu;
    private ImageView jDv;
    private BdListView jiX;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jDp = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.jDv = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.jDp);
        SvgManager.bjq().a(this.jDv, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.fDV = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.jDp.getLayoutMode().setNightMode(i == 1);
        this.jDp.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jDp.getPageContext(), i);
        this.fDV.onChangeSkinType(this.jDp.getPageContext(), i);
        this.jDu.notifyDataSetChanged();
        SvgManager.bjq().a(this.jDv, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.jiX = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.jiX.setOnItemClickListener(strangerListActivity);
        this.jiX.setOnItemLongClickListener(strangerListActivity);
        this.jDu = new StrangerListAdapter(strangerListActivity);
        this.jiX.setAdapter((ListAdapter) this.jDu);
    }

    public StrangerListAdapter cJy() {
        return this.jDu;
    }

    public View cJz() {
        return this.jDv;
    }
}
