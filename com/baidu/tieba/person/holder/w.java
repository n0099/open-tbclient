package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends y.a {
    public int afy;
    public TextView beS;
    public LinearLayout exi;
    public TbImageView exj;
    public TextView exk;
    public WholeDisplayGridView exl;

    public w(View view) {
        super(view);
        this.afy = 3;
        this.exi = (LinearLayout) view.findViewById(u.g.title_layout);
        this.exj = (TbImageView) view.findViewById(u.g.title_icon);
        this.beS = (TextView) view.findViewById(u.g.title_text);
        this.exk = (TextView) view.findViewById(u.g.title_tip);
        this.exl = (WholeDisplayGridView) view.findViewById(u.g.wallet_items);
    }
}
