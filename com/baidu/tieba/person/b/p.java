package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class p extends x.a {
    public int ahU;
    public LinearLayout dgj;
    public TbImageView dgk;
    public TextView dgl;
    public TextView dgm;
    public WholeDisplayGridView dgn;

    public p(View view) {
        super(view);
        this.ahU = 3;
        this.dgj = (LinearLayout) view.findViewById(t.g.title_layout);
        this.dgk = (TbImageView) view.findViewById(t.g.title_icon);
        this.dgl = (TextView) view.findViewById(t.g.title_text);
        this.dgm = (TextView) view.findViewById(t.g.title_tip);
        this.dgn = (WholeDisplayGridView) view.findViewById(t.g.wallet_items);
    }
}
