package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class f extends y.a {
    public View aGr;
    public View aOf;
    public int aej;
    public LinearLayout dBA;
    public TextView dBB;
    public TextView dBC;
    public TextView dBp;
    public ImageView dBq;

    public f(View view) {
        super(view);
        this.aej = 3;
        this.dBA = (LinearLayout) view;
        this.aOf = view.findViewById(t.g.top_divider);
        this.dBB = (TextView) view.findViewById(t.g.fans_title);
        this.dBC = (TextView) view.findViewById(t.g.fans_num);
        this.aGr = view.findViewById(t.g.fan_divider);
        this.dBq = (ImageView) view.findViewById(t.g.bar_head_arrow);
        this.dBp = (TextView) view.findViewById(t.g.fans_none_msg);
    }
}
