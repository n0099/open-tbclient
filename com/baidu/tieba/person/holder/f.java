package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class f extends y.a {
    public int aib;
    public TextView bSn;
    public RelativeLayout eoU;
    public TbImageView eoV;
    public TextView eoW;
    public WholeDisplayGridView eoX;

    public f(View view) {
        super(view);
        this.aib = 3;
        this.eoU = (RelativeLayout) view.findViewById(r.g.title_layout);
        this.eoV = (TbImageView) view.findViewById(r.g.title_icon);
        this.bSn = (TextView) view.findViewById(r.g.title_text);
        this.eoW = (TextView) view.findViewById(r.g.title_tip);
        this.eoX = (WholeDisplayGridView) view.findViewById(r.g.wallet_items);
    }
}
