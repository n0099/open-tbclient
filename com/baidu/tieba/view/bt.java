package com.baidu.tieba.view;

import android.content.Context;
import android.widget.TextView;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class bt extends com.baidu.adp.widget.ScrollView.r {
    public bt(Context context) {
        super(context);
    }

    public void a(int i) {
        TextView d = d();
        TextView c = c();
        if (d != null && c != null) {
            if (i == 1) {
                int color = h().getResources().getColor(R.color.adp_pullview_night);
                d.setTextColor(color);
                c.setTextColor(color);
                return;
            }
            int color2 = h().getResources().getColor(R.color.adp_pullview_day);
            d.setTextColor(color2);
            c.setTextColor(color2);
        }
    }
}
