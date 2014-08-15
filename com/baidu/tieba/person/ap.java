package com.baidu.tieba.person;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Locale;
/* loaded from: classes.dex */
final class ap {
    public final LinearLayout a;
    public final TextView b;
    public final TextView c;
    public final ImageView d;
    public final ImageView e;

    public ap(LinearLayout linearLayout) {
        this.a = linearLayout;
        this.b = (TextView) this.a.findViewById(com.baidu.tieba.u.user_info_center_head_name);
        this.c = (TextView) this.a.findViewById(com.baidu.tieba.u.user_info_center_head_num);
        this.d = (ImageView) this.a.findViewById(com.baidu.tieba.u.user_info_center_head_lock);
        this.e = (ImageView) this.a.findViewById(com.baidu.tieba.u.user_info_center_head_msg_icon);
    }

    public void a(String str) {
        this.b.setText(str);
    }

    public void a(int i) {
        this.c.setText(b(i));
    }

    public void a(int i, boolean z) {
        if (i == 2 && !z) {
            this.c.setVisibility(4);
            com.baidu.tbadk.core.util.ay.c(this.d, com.baidu.tieba.t.icon_seg_grouplock);
            this.d.setVisibility(0);
        } else if (i == 3) {
            this.c.setVisibility(4);
            com.baidu.tbadk.core.util.ay.c(this.d, com.baidu.tieba.t.icon_seg_lock);
            this.d.setVisibility(0);
        } else {
            this.c.setVisibility(0);
            this.d.setVisibility(4);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v0 int)] */
    private String b(int i) {
        if (i > 9999) {
            return String.format(Locale.getDefault(), "%.1fw", Float.valueOf(i / 10000.0f));
        }
        if (i < 0) {
            return "0";
        }
        return new StringBuilder().append(i).toString();
    }
}
