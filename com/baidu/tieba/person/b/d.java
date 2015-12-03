package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends x.a {
    public int afY;
    public TextView cNQ;
    public ImageView cNR;
    public LinearLayout cNX;
    public TextView cNY;
    public TextView cNZ;
    public View cyG;
    public View line;

    public d(View view) {
        super(view);
        this.afY = 3;
        this.cNX = (LinearLayout) view;
        this.cyG = view.findViewById(n.f.top_divider);
        this.cNY = (TextView) view.findViewById(n.f.fans_title);
        this.cNZ = (TextView) view.findViewById(n.f.fans_num);
        this.line = view.findViewById(n.f.fan_divider);
        this.cNR = (ImageView) view.findViewById(n.f.bar_head_arrow);
        this.cNQ = (TextView) view.findViewById(n.f.fans_none_msg);
    }
}
