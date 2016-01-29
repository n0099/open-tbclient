package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g extends x.a {
    public View aOS;
    public int ahU;
    public ImageView ddH;
    public TextView ddX;
    public TextView ddY;
    public TextView ddZ;
    public TextView dea;
    public TextView deb;
    public TextView dec;
    public TextView ded;
    public RelativeLayout dee;
    public View def;
    public TextView deg;
    public LinearLayout deh;
    public RelativeLayout dei;
    public TextView dej;
    public TextView dek;
    public LinearLayout del;
    public ImageView dem;

    public g(View view) {
        super(view);
        this.ahU = 3;
        this.ddX = (TextView) view.findViewById(t.g.bar_item_1);
        this.ddY = (TextView) view.findViewById(t.g.bar_item_2);
        this.ddZ = (TextView) view.findViewById(t.g.bar_item_3);
        this.dea = (TextView) view.findViewById(t.g.bar_item_4);
        this.deb = (TextView) view.findViewById(t.g.bar_item_5);
        this.dec = (TextView) view.findViewById(t.g.bar_item_6);
        this.aOS = view.findViewById(t.g.top_divider);
        this.def = view.findViewById(t.g.head_divider);
        this.dee = (RelativeLayout) view.findViewById(t.g.bar_head);
        this.ded = (TextView) view.findViewById(t.g.bar_head_title);
        this.ddH = (ImageView) view.findViewById(t.g.bar_head_arrow);
        this.deg = (TextView) view.findViewById(t.g.bar_head_msg);
        this.deh = (LinearLayout) view.findViewById(t.g.bar_container);
        this.dei = (RelativeLayout) view.findViewById(t.g.bar_none);
        this.dej = (TextView) view.findViewById(t.g.bar_none_title);
        this.dek = (TextView) view.findViewById(t.g.bar_none_msg);
        this.del = (LinearLayout) view.findViewById(t.g.bar_second_line);
        this.dem = (ImageView) view.findViewById(t.g.bar_none_lock);
    }
}
