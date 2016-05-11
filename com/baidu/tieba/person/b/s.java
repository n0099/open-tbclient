package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class s extends y.a {
    public int aej;
    public TextView bxj;
    public LinearLayout dDQ;
    public TbImageView dDR;
    public TextView dDS;
    public WholeDisplayGridView dDT;

    public s(View view) {
        super(view);
        this.aej = 3;
        this.dDQ = (LinearLayout) view.findViewById(t.g.title_layout);
        this.dDR = (TbImageView) view.findViewById(t.g.title_icon);
        this.bxj = (TextView) view.findViewById(t.g.title_text);
        this.dDS = (TextView) view.findViewById(t.g.title_tip);
        this.dDT = (WholeDisplayGridView) view.findViewById(t.g.wallet_items);
    }
}
