package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class c extends x.a {
    public int aik;
    public RelativeLayout dye;
    public TextView dyf;
    public TextView dyg;
    public TextView dyh;
    public ImageView dyi;

    public c(View view) {
        super(view);
        this.aik = 3;
        this.dye = (RelativeLayout) view;
        this.dyf = (TextView) view.findViewById(t.g.attention_title);
        this.dyg = (TextView) view.findViewById(t.g.attention_num);
        this.dyh = (TextView) view.findViewById(t.g.attention_none_msg);
        this.dyi = (ImageView) view.findViewById(t.g.bar_head_arrow);
    }
}
