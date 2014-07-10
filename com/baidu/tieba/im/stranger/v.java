package com.baidu.tieba.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.w;
import com.baidu.tieba.y;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.base.f {
    private BdListView a;
    private m b;
    private NavigationBar c;
    private StrangerListActivity d;
    private ViewGroup e;
    private View f;

    public v(StrangerListActivity strangerListActivity) {
        super(strangerListActivity);
        strangerListActivity.setContentView(w.officialbar_msg_activity);
        this.d = strangerListActivity;
        a(strangerListActivity);
        b(strangerListActivity);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.c = (NavigationBar) strangerListActivity.findViewById(com.baidu.tieba.v.view_navigation_bar);
        this.c.a(strangerListActivity.getString(y.stranger_message_activity_title));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, w.stranger_delete, this.d);
        this.e = (ViewGroup) strangerListActivity.findViewById(com.baidu.tieba.v.root_view);
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a((View) this.e);
        this.c.c(i);
    }

    private void b(StrangerListActivity strangerListActivity) {
        this.a = (BdListView) strangerListActivity.findViewById(com.baidu.tieba.v.msg_list);
        this.a.setOnItemClickListener(strangerListActivity);
        this.a.setOnItemLongClickListener(strangerListActivity);
        this.b = new m(strangerListActivity);
        this.a.setAdapter((ListAdapter) this.b);
    }

    public m a() {
        return this.b;
    }

    public View b() {
        return this.f;
    }
}
