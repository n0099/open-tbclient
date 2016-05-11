package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends y.a {
    public View aTI;
    public int aej;
    public ImageView cvN;
    public View dBb;
    public TextView dBc;
    public TextView dBd;
    public TextView title;

    public a(View view) {
        super(view);
        this.aej = 3;
        this.aTI = view.findViewById(t.g.top_divider);
        this.dBb = (RelativeLayout) view.findViewById(t.g.thread_item);
        this.title = (TextView) view.findViewById(t.g.item_title);
        this.dBc = (TextView) view.findViewById(t.g.item_num);
        this.dBd = (TextView) view.findViewById(t.g.item_no_thread);
        this.cvN = (ImageView) view.findViewById(t.g.item_arrow);
    }
}
