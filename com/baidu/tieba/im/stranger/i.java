package com.baidu.tieba.im.stranger;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
/* loaded from: classes.dex */
public class i extends com.baidu.adp.base.f {
    private BdListView a;
    private f b;
    private NavigationBar c;
    private StrangerListActivity d;
    private ViewGroup e;
    private View f;

    public i(StrangerListActivity strangerListActivity) {
        super(strangerListActivity);
        strangerListActivity.setContentView(v.officialbar_msg_activity);
        this.d = strangerListActivity;
        a(strangerListActivity);
        b(strangerListActivity);
    }

    private void a(StrangerListActivity strangerListActivity) {
        this.c = (NavigationBar) strangerListActivity.findViewById(u.view_navigation_bar);
        this.c.a(strangerListActivity.getString(x.stranger_message_activity_title));
        this.c.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.f = this.c.a(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, v.stranger_delete, this.d);
        this.e = (ViewGroup) strangerListActivity.findViewById(u.root_view);
    }

    public void a(int i) {
        this.d.getLayoutMode().a(i == 1);
        this.d.getLayoutMode().a((View) this.e);
        this.c.c(i);
    }

    private void b(StrangerListActivity strangerListActivity) {
        this.a = (BdListView) strangerListActivity.findViewById(u.msg_list);
        this.a.setOnItemClickListener(strangerListActivity);
        this.a.setOnItemLongClickListener(strangerListActivity);
        this.b = new f(strangerListActivity);
        this.a.setAdapter((ListAdapter) this.b);
    }

    public f a() {
        return this.b;
    }

    public View b() {
        return this.f;
    }
}
