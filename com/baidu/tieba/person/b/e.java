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
    public TextView cgX;
    public TbImageView eCA;
    public TextView eCB;
    public WholeDisplayGridView eCC;
    public RelativeLayout eCz;

    public e(View view) {
        super(view);
        this.amZ = 3;
        this.eCz = (RelativeLayout) view.findViewById(w.h.title_layout);
        this.eCA = (TbImageView) view.findViewById(w.h.title_icon);
        this.cgX = (TextView) view.findViewById(w.h.title_text);
        this.eCB = (TextView) view.findViewById(w.h.title_tip);
        this.eCC = (WholeDisplayGridView) view.findViewById(w.h.wallet_items);
    }
}
