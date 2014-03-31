package com.baidu.tieba.pb.praise;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.a.k;
import java.util.List;
/* loaded from: classes.dex */
public final class i extends com.baidu.adp.a.f {
    private e a;
    private PraiseListActivity c;
    private View d;
    private NavigationBar e;
    private View f;
    private View g;
    private View h;
    private TextView i;
    private ImageView j;
    private BdListView k;
    private View l;
    private TextView m;
    private TextView n;
    private ProgressBar o;

    public i(PraiseListActivity praiseListActivity, String str) {
        super(praiseListActivity);
        this.a = null;
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
        this.o = null;
        this.c = praiseListActivity;
        praiseListActivity.setContentView(com.baidu.tieba.a.i.zan_list_activity);
        this.d = praiseListActivity.findViewById(com.baidu.tieba.a.h.zan_list_page_parent);
        this.e = (NavigationBar) praiseListActivity.findViewById(com.baidu.tieba.a.h.zan_list_page_navigationbar);
        this.f = praiseListActivity.findViewById(com.baidu.tieba.a.h.zan_list_page_has_data_parent);
        this.g = praiseListActivity.findViewById(com.baidu.tieba.a.h.zan_list_page_no_data_parent);
        this.k = (BdListView) praiseListActivity.findViewById(com.baidu.tieba.a.h.zan_list_page_list);
        this.o = (ProgressBar) praiseListActivity.findViewById(com.baidu.tieba.a.h.zan_list_page_progress);
        this.a = new e(praiseListActivity);
        this.k.setAdapter((ListAdapter) this.a);
        this.e.a(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        LayoutInflater from = LayoutInflater.from(praiseListActivity);
        this.h = from.inflate(com.baidu.tieba.a.i.zan_list_head, (ViewGroup) null);
        this.j = (ImageView) this.h.findViewById(com.baidu.tieba.a.h.zan_list_head_right_arrow);
        this.j.setOnClickListener(praiseListActivity);
        this.i = (TextView) this.h.findViewById(com.baidu.tieba.a.h.zan_list_head_text);
        this.i.setText(str);
        this.k.addHeaderView(this.h);
        this.l = from.inflate(com.baidu.tieba.a.i.zan_list_foot, (ViewGroup) null);
        this.m = (TextView) this.l.findViewById(com.baidu.tieba.a.h.zan_list_foot_text_continue);
        this.n = (TextView) this.l.findViewById(com.baidu.tieba.a.h.zan_list_foot_text_more);
        this.m.setOnClickListener(praiseListActivity);
        this.k.addFooterView(this.l);
        this.k.setOnItemClickListener(praiseListActivity);
    }

    public final void a() {
        if (this.a != null) {
            this.a.notifyDataSetChanged();
        }
    }

    public final void d() {
        this.o.setVisibility(0);
    }

    public final void e() {
        this.o.setVisibility(8);
    }

    public final boolean f() {
        return this.o.getVisibility() == 0;
    }

    public final void a(int i, List<a> list, int i2, int i3) {
        this.o.setVisibility(8);
        if (i > 0) {
            this.e.a(String.format(this.c.getString(k.praise_list_title_count), Integer.valueOf(i)));
        } else {
            this.e.a("");
        }
        if (list == null || list.size() <= 0) {
            this.o.setVisibility(8);
            this.f.setVisibility(8);
            this.g.setVisibility(0);
            return;
        }
        this.f.setVisibility(0);
        this.g.setVisibility(8);
        this.a.a(list);
        this.a.notifyDataSetChanged();
        switch (i2) {
            case 1001:
                this.l.setVisibility(0);
                this.m.setVisibility(0);
                this.n.setVisibility(8);
                return;
            case 1002:
                this.l.setVisibility(8);
                return;
            case 1003:
                this.l.setVisibility(0);
                this.l.setBackgroundResource(com.baidu.tieba.a.e.transparent);
                this.m.setVisibility(8);
                this.n.setVisibility(0);
                this.n.setText(String.format(this.c.getString(k.praise_item_more), Integer.valueOf(i3)));
                return;
            default:
                this.l.setVisibility(8);
                return;
        }
    }

    public final void a(com.baidu.tbadk.core.c cVar, int i) {
        cVar.a(i == 1);
        cVar.a(this.d);
        cVar.a(this.h);
        cVar.a(this.l);
        this.e.b(i);
    }

    public final View g() {
        return this.j;
    }

    public final View h() {
        return this.m;
    }
}
