package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class f extends x.a {
    public View aPe;
    public int ahf;
    public TextView cSJ;
    public TextView cSK;
    public TextView cSL;
    public TextView cSM;
    public TextView cSN;
    public TextView cSO;
    public TextView cSP;
    public RelativeLayout cSQ;
    public View cSR;
    public View cSS;
    public TextView cST;
    public LinearLayout cSU;
    public RelativeLayout cSV;
    public TextView cSW;
    public TextView cSX;
    public LinearLayout cSY;
    public ImageView cSZ;
    public ImageView cSx;

    public f(View view) {
        super(view);
        this.ahf = 3;
        this.cSJ = (TextView) view.findViewById(n.g.bar_item_1);
        this.cSK = (TextView) view.findViewById(n.g.bar_item_2);
        this.cSL = (TextView) view.findViewById(n.g.bar_item_3);
        this.cSM = (TextView) view.findViewById(n.g.bar_item_4);
        this.cSN = (TextView) view.findViewById(n.g.bar_item_5);
        this.cSO = (TextView) view.findViewById(n.g.bar_item_6);
        this.aPe = view.findViewById(n.g.top_divider);
        this.cSS = view.findViewById(n.g.head_divider);
        this.cSQ = (RelativeLayout) view.findViewById(n.g.bar_head);
        this.cSP = (TextView) view.findViewById(n.g.bar_head_title);
        this.cSx = (ImageView) view.findViewById(n.g.bar_head_arrow);
        this.cST = (TextView) view.findViewById(n.g.bar_head_msg);
        this.cSU = (LinearLayout) view.findViewById(n.g.bar_container);
        this.cSV = (RelativeLayout) view.findViewById(n.g.bar_none);
        this.cSW = (TextView) view.findViewById(n.g.bar_none_title);
        this.cSX = (TextView) view.findViewById(n.g.bar_none_msg);
        this.cSY = (LinearLayout) view.findViewById(n.g.bar_second_line);
        this.cSZ = (ImageView) view.findViewById(n.g.bar_none_lock);
    }
}
