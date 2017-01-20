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
    public int ahp;
    public TextView bYK;
    public RelativeLayout eyP;
    public TbImageView eyQ;
    public TextView eyR;
    public WholeDisplayGridView eyS;

    public f(View view) {
        super(view);
        this.ahp = 3;
        this.eyP = (RelativeLayout) view.findViewById(r.h.title_layout);
        this.eyQ = (TbImageView) view.findViewById(r.h.title_icon);
        this.bYK = (TextView) view.findViewById(r.h.title_text);
        this.eyR = (TextView) view.findViewById(r.h.title_tip);
        this.eyS = (WholeDisplayGridView) view.findViewById(r.h.wallet_items);
    }
}
