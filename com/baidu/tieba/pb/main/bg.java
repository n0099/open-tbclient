package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class bg extends com.baidu.adp.a.f {
    private View a;
    private TextView c;
    private TextView d;
    private View e;
    private TextView f;
    private TextView g;
    private PbActivity h;
    private View.OnClickListener i;

    public bg(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = null;
        this.i = null;
        this.h = pbActivity;
        this.i = onClickListener;
        this.a = this.h.getLayoutInflater().inflate(com.baidu.tieba.a.i.pb_more_view, (ViewGroup) null);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.a.h.pb_more_view_item_mark);
        this.c.setOnClickListener(this.i);
        this.d = (TextView) this.a.findViewById(com.baidu.tieba.a.h.pb_more_view_item_share);
        this.e = this.a.findViewById(com.baidu.tieba.a.h.pb_more_view_item_line_share);
        this.d.setOnClickListener(this.i);
        this.f = (TextView) this.a.findViewById(com.baidu.tieba.a.h.pb_more_view_item_jump);
        this.f.setOnClickListener(this.i);
        this.g = (TextView) this.a.findViewById(com.baidu.tieba.a.h.pb_more_view_item_see);
        this.g.setOnClickListener(this.i);
    }

    public final View a() {
        return this.a;
    }

    public final TextView d() {
        return this.c;
    }

    public final TextView e() {
        return this.d;
    }

    public final View f() {
        return this.e;
    }

    public final TextView g() {
        return this.f;
    }

    public final TextView h() {
        return this.g;
    }
}
