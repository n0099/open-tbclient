package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class f extends y.a {
    public int afy;
    public RelativeLayout eup;
    public TextView euq;
    public TextView eur;
    public TextView eus;
    public ImageView eut;

    public f(View view) {
        super(view);
        this.afy = 3;
        this.eup = (RelativeLayout) view;
        this.euq = (TextView) view.findViewById(u.g.attention_title);
        this.eur = (TextView) view.findViewById(u.g.attention_num);
        this.eus = (TextView) view.findViewById(u.g.attention_none_msg);
        this.eut = (ImageView) view.findViewById(u.g.bar_head_arrow);
    }
}
