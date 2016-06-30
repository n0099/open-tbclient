package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f extends y.a {
    public View aGT;
    public View aRC;
    public int aeK;
    public TextView ejS;
    public ImageView ejT;
    public LinearLayout ekd;
    public TextView eke;
    public TextView ekf;

    public f(View view) {
        super(view);
        this.aeK = 3;
        this.ekd = (LinearLayout) view;
        this.aRC = view.findViewById(u.g.top_divider);
        this.eke = (TextView) view.findViewById(u.g.fans_title);
        this.ekf = (TextView) view.findViewById(u.g.fans_num);
        this.aGT = view.findViewById(u.g.fan_divider);
        this.ejT = (ImageView) view.findViewById(u.g.bar_head_arrow);
        this.ejS = (TextView) view.findViewById(u.g.fans_none_msg);
    }
}
