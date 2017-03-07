package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class f extends y.a {
    public int amL;
    public TextView cgg;
    public RelativeLayout eCo;
    public TbImageView eCp;
    public TextView eCq;
    public WholeDisplayGridView eCr;

    public f(View view) {
        super(view);
        this.amL = 3;
        this.eCo = (RelativeLayout) view.findViewById(w.h.title_layout);
        this.eCp = (TbImageView) view.findViewById(w.h.title_icon);
        this.cgg = (TextView) view.findViewById(w.h.title_text);
        this.eCq = (TextView) view.findViewById(w.h.title_tip);
        this.eCr = (WholeDisplayGridView) view.findViewById(w.h.wallet_items);
    }
}
