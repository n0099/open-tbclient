package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.base.c;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends c<StrangerListActivity> {
    private NoNetworkView dnF;
    private BdListView gBF;
    private StrangerListActivity gUo;
    private StrangerListAdapter gUu;
    private ImageView mDeleteBtn;
    private NavigationBar mNavigationBar;
    private ViewGroup mRootView;

    public b(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(R.layout.officialbar_msg_activity);
        this.gUo = strangerListActivity;
        l(strangerListActivity);
        m(strangerListActivity);
    }

    private void l(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(strangerListActivity.getPageContext().getString(R.string.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.showBottomLine();
        this.mDeleteBtn = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.stranger_delete, this.gUo);
        am.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
        this.mRootView = (ViewGroup) strangerListActivity.findViewById(R.id.root_view);
        this.dnF = (NoNetworkView) this.mRootView.findViewById(R.id.no_network_view);
    }

    public void onChangeSkinType(int i) {
        this.gUo.getLayoutMode().setNightMode(i == 1);
        this.gUo.getLayoutMode().onModeChanged(this.mRootView);
        this.mNavigationBar.onChangeSkinType(this.gUo.getPageContext(), i);
        this.dnF.onChangeSkinType(this.gUo.getPageContext(), i);
        am.a(this.mDeleteBtn, (int) R.drawable.icon_tabbar_delete_bg_s, (int) R.drawable.icon_tabbar_delete_bg);
    }

    private void m(StrangerListActivity strangerListActivity) {
        this.gBF = (BdListView) strangerListActivity.findViewById(R.id.msg_list);
        this.gBF.setOnItemClickListener(strangerListActivity);
        this.gBF.setOnItemLongClickListener(strangerListActivity);
        this.gUu = new StrangerListAdapter(strangerListActivity);
        this.gBF.setAdapter((ListAdapter) this.gUu);
    }

    public StrangerListAdapter bHG() {
        return this.gUu;
    }

    public View bHH() {
        return this.mDeleteBtn;
    }
}
