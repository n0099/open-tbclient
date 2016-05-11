package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class h extends y.a {
    public View aOf;
    public int aej;
    public TextView dBF;
    public TextView dBG;
    public TextView dBH;
    public TextView dBI;
    public TextView dBJ;
    public TextView dBK;
    public TextView dBL;
    public RelativeLayout dBM;
    public View dBN;
    public TextView dBO;
    public LinearLayout dBP;
    public RelativeLayout dBQ;
    public TextView dBR;
    public TextView dBS;
    public LinearLayout dBT;
    public ImageView dBU;
    public ImageView dBq;

    public h(View view) {
        super(view);
        this.aej = 3;
        this.dBF = (TextView) view.findViewById(t.g.bar_item_1);
        this.dBG = (TextView) view.findViewById(t.g.bar_item_2);
        this.dBH = (TextView) view.findViewById(t.g.bar_item_3);
        this.dBI = (TextView) view.findViewById(t.g.bar_item_4);
        this.dBJ = (TextView) view.findViewById(t.g.bar_item_5);
        this.dBK = (TextView) view.findViewById(t.g.bar_item_6);
        this.aOf = view.findViewById(t.g.top_divider);
        this.dBN = view.findViewById(t.g.head_divider);
        this.dBM = (RelativeLayout) view.findViewById(t.g.bar_head);
        this.dBL = (TextView) view.findViewById(t.g.bar_head_title);
        this.dBq = (ImageView) view.findViewById(t.g.bar_head_arrow);
        this.dBO = (TextView) view.findViewById(t.g.bar_head_msg);
        this.dBP = (LinearLayout) view.findViewById(t.g.bar_container);
        this.dBQ = (RelativeLayout) view.findViewById(t.g.bar_none);
        this.dBR = (TextView) view.findViewById(t.g.bar_none_title);
        this.dBS = (TextView) view.findViewById(t.g.bar_none_msg);
        this.dBT = (LinearLayout) view.findViewById(t.g.bar_second_line);
        this.dBU = (ImageView) view.findViewById(t.g.bar_none_lock);
    }
}
