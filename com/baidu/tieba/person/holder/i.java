package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class i extends y.a {
    public int ahV;
    public TextView bqy;
    public RelativeLayout eEZ;
    public TbImageView eFa;
    public TextView eFb;
    public WholeDisplayGridView eFc;

    public i(View view) {
        super(view);
        this.ahV = 3;
        this.eEZ = (RelativeLayout) view.findViewById(r.g.title_layout);
        this.eFa = (TbImageView) view.findViewById(r.g.title_icon);
        this.bqy = (TextView) view.findViewById(r.g.title_text);
        this.eFb = (TextView) view.findViewById(r.g.title_tip);
        this.eFc = (WholeDisplayGridView) view.findViewById(r.g.wallet_items);
    }
}
