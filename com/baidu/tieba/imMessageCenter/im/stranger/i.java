package com.baidu.tieba.imMessageCenter.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f<StrangerListActivity> {
    private BdListView NE;
    private ViewGroup Ye;
    private StrangerListActivity cms;
    private StrangerListAdapter cmx;
    private ImageView cmy;
    private NavigationBar mNavigationBar;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity.getPageContext());
        strangerListActivity.setContentView(t.h.officialbar_msg_activity);
        this.cms = strangerListActivity;
        f(strangerListActivity);
        g(strangerListActivity);
    }

    private void f(StrangerListActivity strangerListActivity) {
        this.mNavigationBar = (NavigationBar) strangerListActivity.findViewById(t.g.view_navigation_bar);
        this.mNavigationBar.setTitleText(strangerListActivity.getPageContext().getString(t.j.stranger_list_activity_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.cmy = (ImageView) this.mNavigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, t.h.stranger_delete, this.cms);
        ar.a(this.cmy, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
        this.Ye = (ViewGroup) strangerListActivity.findViewById(t.g.root_view);
    }

    public void onChangeSkinType(int i) {
        this.cms.getLayoutMode().ac(i == 1);
        this.cms.getLayoutMode().x(this.Ye);
        this.mNavigationBar.onChangeSkinType(this.cms.getPageContext(), i);
        ar.a(this.cmy, t.f.icon_tabbar_delete_bg_s, t.f.icon_tabbar_delete_bg);
    }

    private void g(StrangerListActivity strangerListActivity) {
        this.NE = (BdListView) strangerListActivity.findViewById(t.g.msg_list);
        this.NE.setOnItemClickListener(strangerListActivity);
        this.NE.setOnItemLongClickListener(strangerListActivity);
        this.cmx = new StrangerListAdapter(strangerListActivity);
        this.NE.setAdapter((ListAdapter) this.cmx);
    }

    public StrangerListAdapter ahA() {
        return this.cmx;
    }

    public View ahB() {
        return this.cmy;
    }
}
