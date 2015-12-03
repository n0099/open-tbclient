package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class b extends x.a {
    public int afY;
    public RelativeLayout cNN;
    public TextView cNO;
    public TextView cNP;
    public TextView cNQ;
    public ImageView cNR;

    public b(View view) {
        super(view);
        this.afY = 3;
        this.cNN = (RelativeLayout) view;
        this.cNO = (TextView) view.findViewById(n.f.attention_title);
        this.cNP = (TextView) view.findViewById(n.f.attention_num);
        this.cNQ = (TextView) view.findViewById(n.f.attention_none_msg);
        this.cNR = (ImageView) view.findViewById(n.f.bar_head_arrow);
    }
}
