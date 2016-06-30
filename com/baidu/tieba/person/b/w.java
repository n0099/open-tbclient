package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.WholeDisplayGridView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class w extends y.a {
    public int aeK;
    public TextView bdG;
    public LinearLayout emJ;
    public TbImageView emK;
    public TextView emL;
    public WholeDisplayGridView emM;

    public w(View view) {
        super(view);
        this.aeK = 3;
        this.emJ = (LinearLayout) view.findViewById(u.g.title_layout);
        this.emK = (TbImageView) view.findViewById(u.g.title_icon);
        this.bdG = (TextView) view.findViewById(u.g.title_text);
        this.emL = (TextView) view.findViewById(u.g.title_tip);
        this.emM = (WholeDisplayGridView) view.findViewById(u.g.wallet_items);
    }
}
