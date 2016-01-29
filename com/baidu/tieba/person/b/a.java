package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends x.a {
    public View aUc;
    public int ahU;
    public TextView apm;
    public ImageView ckk;
    public View ddv;
    public TextView ddw;
    public TextView ddx;

    public a(View view) {
        super(view);
        this.ahU = 3;
        this.aUc = view.findViewById(t.g.top_divider);
        this.ddv = (RelativeLayout) view.findViewById(t.g.thread_item);
        this.apm = (TextView) view.findViewById(t.g.item_title);
        this.ddw = (TextView) view.findViewById(t.g.item_num);
        this.ddx = (TextView) view.findViewById(t.g.item_no_thread);
        this.ckk = (ImageView) view.findViewById(t.g.item_arrow);
    }
}
