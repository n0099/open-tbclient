package com.baidu.tieba.pb.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.aa;
/* loaded from: classes.dex */
public final class b {
    private View a;
    private HeadImageView b;
    private TextView c;
    private ImageView d;
    private aa e;

    public static b a(Context context, View view) {
        if (view == null || view.getTag() == null || !(view.getTag() instanceof b)) {
            return new b(context);
        }
        return (b) view.getTag();
    }

    private b(Context context) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.a = LayoutInflater.from(context).inflate(com.baidu.tieba.a.i.zan_list_item, (ViewGroup) null);
        this.b = (HeadImageView) this.a.findViewById(com.baidu.tieba.a.h.zan_list_item_head);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.a.h.zan_list_item_name);
        this.d = (ImageView) this.a.findViewById(com.baidu.tieba.a.h.zan_list_item_line_bottom);
        this.d.setVisibility(0);
        this.a.setTag(this);
        this.e = new aa(context);
    }

    public final View a() {
        return this.a;
    }

    public final void a(String str, String str2) {
        this.c.setText(str);
        aa aaVar = this.e;
        com.baidu.adp.widget.ImageView.b b = com.baidu.tbadk.imageManager.e.a().b(str2);
        if (b != null) {
            this.b.setTag(null);
            b.a(this.b);
            return;
        }
        this.e.c(str2, new c(this, str2));
    }
}
