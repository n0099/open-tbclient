package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends x.a {
    public int ahU;
    public RelativeLayout ddD;
    public TextView ddE;
    public TextView ddF;
    public TextView ddG;
    public ImageView ddH;

    public c(View view) {
        super(view);
        this.ahU = 3;
        this.ddD = (RelativeLayout) view;
        this.ddE = (TextView) view.findViewById(t.g.attention_title);
        this.ddF = (TextView) view.findViewById(t.g.attention_num);
        this.ddG = (TextView) view.findViewById(t.g.attention_none_msg);
        this.ddH = (ImageView) view.findViewById(t.g.bar_head_arrow);
    }
}
