package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class e extends x.a {
    public int afY;
    public ImageView cNR;
    public TextView cOa;
    public TextView cOb;
    public TextView cOc;
    public TextView cOd;
    public TextView cOe;
    public TextView cOf;
    public TextView cOg;
    public RelativeLayout cOh;
    public View cOi;
    public View cOj;
    public TextView cOk;
    public LinearLayout cOl;
    public RelativeLayout cOm;
    public TextView cOn;
    public TextView cOo;
    public LinearLayout cOp;
    public ImageView cOq;
    public View cyG;

    public e(View view) {
        super(view);
        this.afY = 3;
        this.cOa = (TextView) view.findViewById(n.f.bar_item_1);
        this.cOb = (TextView) view.findViewById(n.f.bar_item_2);
        this.cOc = (TextView) view.findViewById(n.f.bar_item_3);
        this.cOd = (TextView) view.findViewById(n.f.bar_item_4);
        this.cOe = (TextView) view.findViewById(n.f.bar_item_5);
        this.cOf = (TextView) view.findViewById(n.f.bar_item_6);
        this.cyG = view.findViewById(n.f.top_divider);
        this.cOj = view.findViewById(n.f.head_divider);
        this.cOh = (RelativeLayout) view.findViewById(n.f.bar_head);
        this.cOg = (TextView) view.findViewById(n.f.bar_head_title);
        this.cNR = (ImageView) view.findViewById(n.f.bar_head_arrow);
        this.cOk = (TextView) view.findViewById(n.f.bar_head_msg);
        this.cOl = (LinearLayout) view.findViewById(n.f.bar_container);
        this.cOm = (RelativeLayout) view.findViewById(n.f.bar_none);
        this.cOn = (TextView) view.findViewById(n.f.bar_none_title);
        this.cOo = (TextView) view.findViewById(n.f.bar_none_msg);
        this.cOp = (LinearLayout) view.findViewById(n.f.bar_second_line);
        this.cOq = (ImageView) view.findViewById(n.f.bar_none_lock);
    }
}
