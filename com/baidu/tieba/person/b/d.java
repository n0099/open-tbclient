package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class d extends x.a {
    public View aPe;
    public int ahf;
    public LinearLayout cSD;
    public TextView cSE;
    public TextView cSF;
    public TextView cSw;
    public ImageView cSx;
    public View line;

    public d(View view) {
        super(view);
        this.ahf = 3;
        this.cSD = (LinearLayout) view;
        this.aPe = view.findViewById(n.g.top_divider);
        this.cSE = (TextView) view.findViewById(n.g.fans_title);
        this.cSF = (TextView) view.findViewById(n.g.fans_num);
        this.line = view.findViewById(n.g.fan_divider);
        this.cSx = (ImageView) view.findViewById(n.g.bar_head_arrow);
        this.cSw = (TextView) view.findViewById(n.g.fans_none_msg);
    }
}
