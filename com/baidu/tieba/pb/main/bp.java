package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public class bp extends com.baidu.adp.base.c {
    private View a;
    private TextView b;
    private TextView c;
    private ImageView d;
    private PbActivity e;
    private View.OnClickListener f;
    private boolean g;

    public boolean a() {
        return this.g;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public bp(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = true;
        this.e = pbActivity;
        this.f = onClickListener;
        f();
    }

    public View b() {
        return this.a;
    }

    public TextView c() {
        return this.b;
    }

    public TextView d() {
        return this.c;
    }

    public ImageView e() {
        return this.d;
    }

    private void f() {
        this.a = this.e.getLayoutInflater().inflate(com.baidu.tieba.w.pb_reply_view, (ViewGroup) null);
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.v.pb_reply_view_item_mark);
        this.b.setOnClickListener(this.f);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.v.pb_reply_view_item_reply);
        this.c.setOnClickListener(this.f);
        this.d = (ImageView) this.a.findViewById(com.baidu.tieba.v.pb_reply_view_item_manage);
        this.d.setOnClickListener(this.f);
    }
}
