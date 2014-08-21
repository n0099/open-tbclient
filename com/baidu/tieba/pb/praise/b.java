package com.baidu.tieba.pb.praise;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
/* loaded from: classes.dex */
public class b {
    private View a;
    private HeadImageView b;
    private TextView c;
    private TextView d;
    private ImageView e;

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
        this.a = com.baidu.adp.lib.e.b.a().a(context, v.zan_list_item, null);
        this.b = (HeadImageView) this.a.findViewById(u.zan_list_item_head);
        this.c = (TextView) this.a.findViewById(u.zan_list_item_name);
        this.d = (TextView) this.a.findViewById(u.zan_list_item_time);
        this.e = (ImageView) this.a.findViewById(u.zan_list_item_line_bottom);
        this.e.setVisibility(0);
        this.a.setTag(this);
    }

    public View a() {
        return this.a;
    }

    public void a(String str, String str2, long j, boolean z) {
        this.c.setText(str);
        this.b.setImageDrawable(null);
        this.d.setText(ba.a(j));
        this.b.a(str2, 12, false);
    }
}
