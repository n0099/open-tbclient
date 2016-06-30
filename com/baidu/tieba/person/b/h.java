package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class h extends y.a {
    public View aRC;
    public int aeK;
    public ImageView ejT;
    public TextView eki;
    public TextView ekj;
    public TextView ekk;
    public TextView ekl;
    public TextView ekm;
    public TextView ekn;
    public TextView eko;
    public RelativeLayout ekp;
    public View ekq;
    public TextView ekr;
    public LinearLayout eks;
    public RelativeLayout ekt;
    public TextView eku;
    public TextView ekv;
    public LinearLayout ekw;
    public ImageView ekx;

    public h(View view) {
        super(view);
        this.aeK = 3;
        this.eki = (TextView) view.findViewById(u.g.bar_item_1);
        this.ekj = (TextView) view.findViewById(u.g.bar_item_2);
        this.ekk = (TextView) view.findViewById(u.g.bar_item_3);
        this.ekl = (TextView) view.findViewById(u.g.bar_item_4);
        this.ekm = (TextView) view.findViewById(u.g.bar_item_5);
        this.ekn = (TextView) view.findViewById(u.g.bar_item_6);
        this.aRC = view.findViewById(u.g.top_divider);
        this.ekq = view.findViewById(u.g.head_divider);
        this.ekp = (RelativeLayout) view.findViewById(u.g.bar_head);
        this.eko = (TextView) view.findViewById(u.g.bar_head_title);
        this.ejT = (ImageView) view.findViewById(u.g.bar_head_arrow);
        this.ekr = (TextView) view.findViewById(u.g.bar_head_msg);
        this.eks = (LinearLayout) view.findViewById(u.g.bar_container);
        this.ekt = (RelativeLayout) view.findViewById(u.g.bar_none);
        this.eku = (TextView) view.findViewById(u.g.bar_none_title);
        this.ekv = (TextView) view.findViewById(u.g.bar_none_msg);
        this.ekw = (LinearLayout) view.findViewById(u.g.bar_second_line);
        this.ekx = (ImageView) view.findViewById(u.g.bar_none_lock);
    }
}
