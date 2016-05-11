package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class d extends y.a {
    public int aej;
    public RelativeLayout dBm;
    public TextView dBn;
    public TextView dBo;
    public TextView dBp;
    public ImageView dBq;

    public d(View view) {
        super(view);
        this.aej = 3;
        this.dBm = (RelativeLayout) view;
        this.dBn = (TextView) view.findViewById(t.g.attention_title);
        this.dBo = (TextView) view.findViewById(t.g.attention_num);
        this.dBp = (TextView) view.findViewById(t.g.attention_none_msg);
        this.dBq = (ImageView) view.findViewById(t.g.bar_head_arrow);
    }
}
