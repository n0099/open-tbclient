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
    private NoNetworkView eli;
    private StrangerListActivity hNO;
    private StrangerListAdapter hNT;
    private ImageView hNU;
    private BdListView hvg;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.hNO = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.hNU = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.hNO);
        SvgManager.aGC().a(this.hNU, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.eli = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.hNO.getLayoutMode().setNightMode(i == 1);
        this.hNO.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.hNO.getPageContext(), i);
        this.eli.onChangeSkinType(this.hNO.getPageContext(), i);
        this.hNT.notifyDataSetChanged();
        SvgManager.aGC().a(this.hNU, R.drawable.icon_pure_topbar_delete44_svg, R.color.cp_cont_b, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.hvg = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.hvg.setOnItemClickListener(strangerListActivity);
        this.hvg.setOnItemLongClickListener(strangerListActivity);
        this.hNT = new StrangerListAdapter(strangerListActivity);
        this.hvg.setAdapter((ListAdapter) this.hNT);
    }

    public StrangerListAdapter bZo() {
        return this.hNT;
    }

    public View bZp() {
        return this.hNU;
    }
}
