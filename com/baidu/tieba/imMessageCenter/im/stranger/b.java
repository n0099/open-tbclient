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
    private NoNetworkView fHl;
    private StrangerListActivity jLX;
    private StrangerListAdapter jMc;
    private ImageView jMd;
    private BdListView jrH;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.jLX = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.jMd = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.jLX);
        SvgManager.bkl().a(this.jMd, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.fHl = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.jLX.getLayoutMode().setNightMode(i == 1);
        this.jLX.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.jLX.getPageContext(), i);
        this.fHl.onChangeSkinType(this.jLX.getPageContext(), i);
        this.jMc.notifyDataSetChanged();
        SvgManager.bkl().a(this.jMd, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.jrH = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.jrH.setOnItemClickListener(strangerListActivity);
        this.jrH.setOnItemLongClickListener(strangerListActivity);
        this.jMc = new StrangerListAdapter(strangerListActivity);
        this.jrH.setAdapter((ListAdapter) this.jMc);
    }

    public StrangerListAdapter cNf() {
        return this.jMc;
    }

    public View cNg() {
        return this.jMd;
    }
}
