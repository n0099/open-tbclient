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
    public View aRI;
    public int aik;
    public TextView dyA;
    public TextView dyB;
    public TextView dyC;
    public TextView dyD;
    public RelativeLayout dyE;
    public View dyF;
    public TextView dyG;
    public LinearLayout dyH;
    public RelativeLayout dyI;
    public TextView dyJ;
    public TextView dyK;
    public LinearLayout dyL;
    public ImageView dyM;
    public ImageView dyi;
    public TextView dyx;
    public TextView dyy;
    public TextView dyz;

    public g(View view) {
        super(view);
        this.aik = 3;
        this.dyx = (TextView) view.findViewById(t.g.bar_item_1);
        this.dyy = (TextView) view.findViewById(t.g.bar_item_2);
        this.dyz = (TextView) view.findViewById(t.g.bar_item_3);
        this.dyA = (TextView) view.findViewById(t.g.bar_item_4);
        this.dyB = (TextView) view.findViewById(t.g.bar_item_5);
        this.dyC = (TextView) view.findViewById(t.g.bar_item_6);
        this.aRI = view.findViewById(t.g.top_divider);
        this.dyF = view.findViewById(t.g.head_divider);
        this.dyE = (RelativeLayout) view.findViewById(t.g.bar_head);
        this.dyD = (TextView) view.findViewById(t.g.bar_head_title);
        this.dyi = (ImageView) view.findViewById(t.g.bar_head_arrow);
        this.dyG = (TextView) view.findViewById(t.g.bar_head_msg);
        this.dyH = (LinearLayout) view.findViewById(t.g.bar_container);
        this.dyI = (RelativeLayout) view.findViewById(t.g.bar_none);
        this.dyJ = (TextView) view.findViewById(t.g.bar_none_title);
        this.dyK = (TextView) view.findViewById(t.g.bar_none_msg);
        this.dyL = (LinearLayout) view.findViewById(t.g.bar_second_line);
        this.dyM = (ImageView) view.findViewById(t.g.bar_none_lock);
    }
}
