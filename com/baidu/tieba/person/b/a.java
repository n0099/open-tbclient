package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class a extends y.a {
    public View aXd;
    public int aeK;
    public ImageView dbd;
    public View ejG;
    public TextView ejH;
    public TextView ejI;
    public TextView title;

    public a(View view) {
        super(view);
        this.aeK = 3;
        this.aXd = view.findViewById(u.g.top_divider);
        this.ejG = (RelativeLayout) view.findViewById(u.g.thread_item);
        this.title = (TextView) view.findViewById(u.g.item_title);
        this.ejH = (TextView) view.findViewById(u.g.item_num);
        this.ejI = (TextView) view.findViewById(u.g.item_no_thread);
        this.dbd = (ImageView) view.findViewById(u.g.item_arrow);
    }
}
