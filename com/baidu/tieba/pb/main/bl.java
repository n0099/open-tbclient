package com.baidu.tieba.pb.main;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
/* loaded from: classes.dex */
public final class bl extends com.baidu.adp.a.f {
    private View a;
    private TextView c;
    private TextView d;
    private ImageView e;
    private PbActivity f;
    private View.OnClickListener g;
    private boolean h;

    public final boolean a() {
        return this.h;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public bl(PbActivity pbActivity, View.OnClickListener onClickListener) {
        super(pbActivity);
        this.a = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.h = true;
        this.f = pbActivity;
        this.g = onClickListener;
        this.a = this.f.getLayoutInflater().inflate(com.baidu.tieba.a.i.pb_reply_view, (ViewGroup) null);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.a.h.pb_reply_view_item_mark);
        this.c.setOnClickListener(this.g);
        this.d = (TextView) this.a.findViewById(com.baidu.tieba.a.h.pb_reply_view_item_reply);
        this.d.setOnClickListener(this.g);
        this.e = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.pb_reply_view_item_manage);
        this.e.setOnClickListener(this.g);
    }

    public final View d() {
        return this.a;
    }

    public final TextView e() {
        return this.c;
    }

    public final TextView f() {
        return this.d;
    }

    public final ImageView g() {
        return this.e;
    }
}
