package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends y.a {
    public int aeK;
    public RelativeLayout ejP;
    public TextView ejQ;
    public TextView ejR;
    public TextView ejS;
    public ImageView ejT;

    public d(View view) {
        super(view);
        this.aeK = 3;
        this.ejP = (RelativeLayout) view;
        this.ejQ = (TextView) view.findViewById(u.g.attention_title);
        this.ejR = (TextView) view.findViewById(u.g.attention_num);
        this.ejS = (TextView) view.findViewById(u.g.attention_none_msg);
        this.ejT = (ImageView) view.findViewById(u.g.bar_head_arrow);
    }
}
