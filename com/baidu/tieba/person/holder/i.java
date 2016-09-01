package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class i extends y.a {
    public int ait;
    public TextView bqm;
    public RelativeLayout eCW;
    public TbImageView eCX;
    public TextView eCY;
    public WholeDisplayGridView eCZ;

    public i(View view) {
        super(view);
        this.ait = 3;
        this.eCW = (RelativeLayout) view.findViewById(t.g.title_layout);
        this.eCX = (TbImageView) view.findViewById(t.g.title_icon);
        this.bqm = (TextView) view.findViewById(t.g.title_text);
        this.eCY = (TextView) view.findViewById(t.g.title_tip);
        this.eCZ = (WholeDisplayGridView) view.findViewById(t.g.wallet_items);
    }
}
