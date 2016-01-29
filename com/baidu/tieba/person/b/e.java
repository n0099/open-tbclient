package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class e extends x.a {
    public View aHm;
    public View aOS;
    public int ahU;
    public TextView ddG;
    public ImageView ddH;
    public LinearLayout ddR;
    public TextView ddS;
    public TextView ddT;

    public e(View view) {
        super(view);
        this.ahU = 3;
        this.ddR = (LinearLayout) view;
        this.aOS = view.findViewById(t.g.top_divider);
        this.ddS = (TextView) view.findViewById(t.g.fans_title);
        this.ddT = (TextView) view.findViewById(t.g.fans_num);
        this.aHm = view.findViewById(t.g.fan_divider);
        this.ddH = (ImageView) view.findViewById(t.g.bar_head_arrow);
        this.ddG = (TextView) view.findViewById(t.g.fans_none_msg);
    }
}
