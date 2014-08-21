package com.baidu.tieba.pb.main;

import android.view.View;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bo extends com.baidu.adp.base.f {
    private View a;
    private TextView b;
    private TextView c;
    private View d;
    private TextView e;
    private TextView f;
    private PbActivity g;
    private View.OnClickListener h;

    public bo(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.g = pbActivity;
        this.h = onClickListener;
        g();
    }

    public View a() {
        return this.a;
    }

    public TextView b() {
        return this.b;
    }

    public TextView c() {
        return this.c;
    }

    public View d() {
        return this.d;
    }

    public TextView e() {
        return this.e;
    }

    public TextView f() {
        return this.f;
    }

    private void g() {
        this.a = com.baidu.adp.lib.e.b.a().a(this.g, com.baidu.tieba.v.pb_more_view, null);
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.u.pb_more_view_item_mark);
        this.b.setOnClickListener(this.h);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.u.pb_more_view_item_share);
        this.d = this.a.findViewById(com.baidu.tieba.u.pb_more_view_item_line_share);
        this.c.setOnClickListener(this.h);
        this.e = (TextView) this.a.findViewById(com.baidu.tieba.u.pb_more_view_item_jump);
        this.e.setOnClickListener(this.h);
        this.f = (TextView) this.a.findViewById(com.baidu.tieba.u.pb_more_view_item_see);
        this.f.setOnClickListener(this.h);
    }
}
