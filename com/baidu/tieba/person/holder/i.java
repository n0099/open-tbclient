package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class i extends y.a {
    public View aSw;
    public int afy;
    public TextView euF;
    public TextView euG;
    public TextView euH;
    public TextView euI;
    public TextView euJ;
    public TextView euK;
    public TextView euL;
    public RelativeLayout euM;
    public View euN;
    public TextView euO;
    public LinearLayout euP;
    public RelativeLayout euQ;
    public TextView euR;
    public TextView euS;
    public LinearLayout euT;
    public ImageView euU;
    public ImageView eut;

    public i(View view) {
        super(view);
        this.afy = 3;
        this.euF = (TextView) view.findViewById(u.g.bar_item_1);
        this.euG = (TextView) view.findViewById(u.g.bar_item_2);
        this.euH = (TextView) view.findViewById(u.g.bar_item_3);
        this.euI = (TextView) view.findViewById(u.g.bar_item_4);
        this.euJ = (TextView) view.findViewById(u.g.bar_item_5);
        this.euK = (TextView) view.findViewById(u.g.bar_item_6);
        this.aSw = view.findViewById(u.g.top_divider);
        this.euN = view.findViewById(u.g.head_divider);
        this.euM = (RelativeLayout) view.findViewById(u.g.bar_head);
        this.euL = (TextView) view.findViewById(u.g.bar_head_title);
        this.eut = (ImageView) view.findViewById(u.g.bar_head_arrow);
        this.euO = (TextView) view.findViewById(u.g.bar_head_msg);
        this.euP = (LinearLayout) view.findViewById(u.g.bar_container);
        this.euQ = (RelativeLayout) view.findViewById(u.g.bar_none);
        this.euR = (TextView) view.findViewById(u.g.bar_none_title);
        this.euS = (TextView) view.findViewById(u.g.bar_none_msg);
        this.euT = (LinearLayout) view.findViewById(u.g.bar_second_line);
        this.euU = (ImageView) view.findViewById(u.g.bar_none_lock);
    }
}
