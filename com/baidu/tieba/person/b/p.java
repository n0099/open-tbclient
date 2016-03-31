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
    public int aik;
    public LinearLayout dAI;
    public TbImageView dAJ;
    public TextView dAK;
    public TextView dAL;
    public WholeDisplayGridView dAM;

    public p(View view) {
        super(view);
        this.aik = 3;
        this.dAI = (LinearLayout) view.findViewById(t.g.title_layout);
        this.dAJ = (TbImageView) view.findViewById(t.g.title_icon);
        this.dAK = (TextView) view.findViewById(t.g.title_text);
        this.dAL = (TextView) view.findViewById(t.g.title_tip);
        this.dAM = (WholeDisplayGridView) view.findViewById(t.g.wallet_items);
    }
}
