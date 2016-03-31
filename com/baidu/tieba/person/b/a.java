package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class a extends x.a {
    public View aXO;
    public int aik;
    public TextView apE;
    public ImageView cuQ;
    public View dxW;
    public TextView dxX;
    public TextView dxY;

    public a(View view) {
        super(view);
        this.aik = 3;
        this.aXO = view.findViewById(t.g.top_divider);
        this.dxW = (RelativeLayout) view.findViewById(t.g.thread_item);
        this.apE = (TextView) view.findViewById(t.g.item_title);
        this.dxX = (TextView) view.findViewById(t.g.item_num);
        this.dxY = (TextView) view.findViewById(t.g.item_no_thread);
        this.cuQ = (ImageView) view.findViewById(t.g.item_arrow);
    }
}
