package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView NL;
    private ViewGroup Wy;
    private StrangerListActivity cwU;
    private StrangerListAdapter cwZ;
    private ImageView cxa;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(t.h.officialbar_msg_activity);
        this.cwU = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(t.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cxa = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.stranger_delete, this.cwU);
        at.a(this.cxa, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
        this.Wy = (ViewGroup) strangerListActivity.findViewById(t.g.root_view);
    }

    public void onChangeSkinType(int i) {
        this.cwU.getLayoutMode().ab(i == 1);
        this.cwU.getLayoutMode().x(this.Wy);
        this.mNavigationBar.onChangeSkinType(this.cwU.getPageContext(), i);
        at.a(this.cxa, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.NL = (BdListView) strangerListActivity.findViewById(t.g.msg_list);
        this.NL.setOnItemClickListener(strangerListActivity);
        this.NL.setOnItemLongClickListener(strangerListActivity);
        this.cwZ = new StrangerListAdapter(strangerListActivity);
        this.NL.setAdapter((ListAdapter) this.cwZ);
    }

    public StrangerListAdapter akU() {
        return this.cwZ;
    }

    public View akV() {
        return this.cxa;
    }
}
