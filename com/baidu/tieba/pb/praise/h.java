package com.baidu.tieba.pb.praise;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.t;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.x;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.adp.base.f {
    private d a;
    private PraiseListActivity b;
    private View c;
    private NavigationBar d;
    private View e;
    private View f;
    private View g;
    private TextView h;
    private BdListView i;
    private View j;
    private TextView k;
    private TextView l;
    private ProgressBar m;
    private ProgressBar n;

    public h(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        if (praiseListActivity != null) {
            this.b = praiseListActivity;
            praiseListActivity.setContentView(v.zan_list_activity);
            this.c = praiseListActivity.findViewById(u.zan_list_page_parent);
            this.d = (NavigationBar) praiseListActivity.findViewById(u.zan_list_page_navigationbar);
            this.e = praiseListActivity.findViewById(u.zan_list_page_has_data_parent);
            this.f = praiseListActivity.findViewById(u.zan_list_page_no_data_parent);
            this.i = (BdListView) praiseListActivity.findViewById(u.zan_list_page_list);
            this.m = (ProgressBar) praiseListActivity.findViewById(u.zan_list_page_progress);
            this.a = new d(praiseListActivity);
            this.i.setAdapter((ListAdapter) this.a);
            this.i.setOnScrollListener(this.a);
            this.d.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.d.a("");
            this.g = com.baidu.adp.lib.e.b.a().a(praiseListActivity, v.zan_list_head, null);
            this.g.setOnClickListener(praiseListActivity);
            this.h = (TextView) this.g.findViewById(u.zan_list_head_text);
            this.h.setText(str);
            this.i.addHeaderView(this.g);
            this.j = com.baidu.adp.lib.e.b.a().a(praiseListActivity, v.zan_list_foot, null);
            this.k = (TextView) this.j.findViewById(u.zan_list_foot_text_continue);
            this.l = (TextView) this.j.findViewById(u.zan_list_foot_text_more);
            this.n = (ProgressBar) this.j.findViewById(u.zan_list_foot_progress);
            this.k.setOnClickListener(praiseListActivity);
            this.i.addFooterView(this.j);
            this.i.setOnItemClickListener(praiseListActivity);
        }
    }

    public void a() {
        if (this.a != null) {
            this.a.notifyDataSetChanged();
        }
    }

    public void a(boolean z) {
        if (z) {
            this.n.setVisibility(0);
        } else {
            this.m.setVisibility(0);
        }
    }

    public void b() {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
    }

    public boolean c() {
        return this.m.getVisibility() == 0 || this.n.getVisibility() == 0;
    }

    public void a(int i, List<a> list, int i2, int i3) {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        if (i > 0) {
            this.d.a(String.format(this.b.getString(x.praise_list_title_count), Integer.valueOf(i)));
        } else {
            this.d.a("");
        }
        if (list == null || list.size() < 1) {
            d();
            return;
        }
        this.e.setVisibility(0);
        this.f.setVisibility(8);
        this.a.a(list);
        this.a.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.j.setVisibility(0);
                this.k.setVisibility(0);
                this.l.setVisibility(8);
                return;
            case 1002:
                this.j.setVisibility(8);
                return;
            case 1003:
                this.j.setVisibility(0);
                if (TbadkApplication.m252getInst().getSkinType() == 1) {
                    this.j.setBackgroundResource(t.bg_pack_1);
                } else {
                    this.j.setBackgroundResource(t.bg_pack);
                }
                this.k.setVisibility(8);
                this.l.setVisibility(0);
                this.l.setText(String.format(this.b.getString(x.praise_item_more), Integer.valueOf(i3)));
                return;
            default:
                this.j.setVisibility(8);
                return;
        }
    }

    public void d() {
        this.m.setVisibility(8);
        this.n.setVisibility(8);
        this.e.setVisibility(8);
        this.f.setVisibility(0);
    }

    public void a(com.baidu.tbadk.core.c cVar, int i) {
        if (cVar != null) {
            cVar.a(i == 1);
            cVar.a(this.c);
            cVar.a(this.g);
            cVar.a(this.j);
            this.d.c(i);
            if (i == 1) {
                this.j.setBackgroundResource(t.bg_pack_1);
            } else {
                this.j.setBackgroundResource(t.bg_pack);
            }
        }
    }

    public View e() {
        return this.g;
    }

    public View f() {
        return this.k;
    }
}
