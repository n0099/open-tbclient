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
    public int aiA;
    public TextView btu;
    public TextView eLA;
    public WholeDisplayGridView eLB;
    public RelativeLayout eLy;
    public TbImageView eLz;

    public i(View view) {
        super(view);
        this.aiA = 3;
        this.eLy = (RelativeLayout) view.findViewById(r.g.title_layout);
        this.eLz = (TbImageView) view.findViewById(r.g.title_icon);
        this.btu = (TextView) view.findViewById(r.g.title_text);
        this.eLA = (TextView) view.findViewById(r.g.title_tip);
        this.eLB = (WholeDisplayGridView) view.findViewById(r.g.wallet_items);
    }
}
