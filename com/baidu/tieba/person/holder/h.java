package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h extends y.a {
    public View aHK;
    public View aSw;
    public int afy;
    public LinearLayout euC;
    public TextView euD;
    public TextView euE;
    public TextView eus;
    public ImageView eut;

    public h(View view) {
        super(view);
        this.afy = 3;
        this.euC = (LinearLayout) view;
        this.aSw = view.findViewById(u.g.top_divider);
        this.euD = (TextView) view.findViewById(u.g.fans_title);
        this.euE = (TextView) view.findViewById(u.g.fans_num);
        this.aHK = view.findViewById(u.g.fan_divider);
        this.eut = (ImageView) view.findViewById(u.g.bar_head_arrow);
        this.eus = (TextView) view.findViewById(u.g.fans_none_msg);
    }
}
