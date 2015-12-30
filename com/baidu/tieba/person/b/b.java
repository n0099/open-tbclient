package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends x.a {
    public int ahf;
    public RelativeLayout cSt;
    public TextView cSu;
    public TextView cSv;
    public TextView cSw;
    public ImageView cSx;

    public b(View view) {
        super(view);
        this.ahf = 3;
        this.cSt = (RelativeLayout) view;
        this.cSu = (TextView) view.findViewById(n.g.attention_title);
        this.cSv = (TextView) view.findViewById(n.g.attention_num);
        this.cSw = (TextView) view.findViewById(n.g.attention_none_msg);
        this.cSx = (ImageView) view.findViewById(n.g.bar_head_arrow);
    }
}
