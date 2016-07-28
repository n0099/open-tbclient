package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class c extends y.a {
    public View aYb;
    public int afy;
    public ImageView dea;
    public View eug;
    public TextView euh;
    public TextView eui;
    public TextView title;

    public c(View view) {
        super(view);
        this.afy = 3;
        this.aYb = view.findViewById(u.g.top_divider);
        this.eug = (RelativeLayout) view.findViewById(u.g.thread_item);
        this.title = (TextView) view.findViewById(u.g.item_title);
        this.euh = (TextView) view.findViewById(u.g.item_num);
        this.eui = (TextView) view.findViewById(u.g.item_no_thread);
        this.dea = (ImageView) view.findViewById(u.g.item_arrow);
    }
}
