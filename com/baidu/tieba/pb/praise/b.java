package com.baidu.tieba.pb.praise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.editortool.ab;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class b {
    private View a;
    private HeadImageView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ab f;

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
        this.f = null;
        this.a = LayoutInflater.from(context).inflate(w.zan_list_item, (ViewGroup) null);
        this.b = (HeadImageView) this.a.findViewById(v.zan_list_item_head);
        this.c = (TextView) this.a.findViewById(v.zan_list_item_name);
        this.d = (TextView) this.a.findViewById(v.zan_list_item_time);
        this.e = (ImageView) this.a.findViewById(v.zan_list_item_line_bottom);
        this.e.setVisibility(0);
        this.a.setTag(this);
        this.f = new ab(context);
    }

    public View a() {
        return this.a;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.c.setText(str);
        this.b.setImageBitmap(null);
        this.d.setText(bg.a(j));
        com.baidu.adp.widget.a.a c = this.f.c(str2);
        if (c != null) {
            c.a(this.b);
        } else if (!z) {
            this.b.setTag(str2);
            this.f.c(str2, new c(this));
        }
    }
}
