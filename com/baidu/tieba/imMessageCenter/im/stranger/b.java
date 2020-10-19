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
    private NoNetworkView fTu;
    private BdListView jGE;
    private StrangerListActivity kaV;
    private StrangerListAdapter kba;
    private ImageView kbb;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.kaV = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.kbb = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.kaV);
        SvgManager.bmU().a(this.kbb, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.fTu = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.kaV.getLayoutMode().setNightMode(i == 1);
        this.kaV.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.kaV.getPageContext(), i);
        this.fTu.onChangeSkinType(this.kaV.getPageContext(), i);
        this.kba.notifyDataSetChanged();
        SvgManager.bmU().a(this.kbb, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.jGE = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.jGE.setOnItemClickListener(strangerListActivity);
        this.jGE.setOnItemLongClickListener(strangerListActivity);
        this.kba = new StrangerListAdapter(strangerListActivity);
        this.jGE.setAdapter((ListAdapter) this.kba);
    }

    public StrangerListAdapter cQN() {
        return this.kba;
    }

    public View cQO() {
        return this.kbb;
    }
}
