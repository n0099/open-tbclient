package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends x.a {
    public View aKi;
    public View aRI;
    public int aik;
    public TextView dyh;
    public ImageView dyi;
    public LinearLayout dys;
    public TextView dyt;
    public TextView dyu;

    public e(View view) {
        super(view);
        this.aik = 3;
        this.dys = (LinearLayout) view;
        this.aRI = view.findViewById(t.g.top_divider);
        this.dyt = (TextView) view.findViewById(t.g.fans_title);
        this.dyu = (TextView) view.findViewById(t.g.fans_num);
        this.aKi = view.findViewById(t.g.fan_divider);
        this.dyi = (ImageView) view.findViewById(t.g.bar_head_arrow);
        this.dyh = (TextView) view.findViewById(t.g.fans_none_msg);
    }
}
