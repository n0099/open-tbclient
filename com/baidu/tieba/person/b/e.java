package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class e extends y.a {
    public int amZ;
    public TextView ceG;
    public RelativeLayout eAj;
    public TbImageView eAk;
    public TextView eAl;
    public WholeDisplayGridView eAm;

    public e(View view) {
        super(view);
        this.amZ = 3;
        this.eAj = (RelativeLayout) view.findViewById(w.h.title_layout);
        this.eAk = (TbImageView) view.findViewById(w.h.title_icon);
        this.ceG = (TextView) view.findViewById(w.h.title_text);
        this.eAl = (TextView) view.findViewById(w.h.title_tip);
        this.eAm = (WholeDisplayGridView) view.findViewById(w.h.wallet_items);
    }
}
