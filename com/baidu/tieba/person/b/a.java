package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends x.a {
    public ImageView cSo;
    public TextView cSp;
    public TbImageView cSq;
    public TextView cSr;
    public ImageView cSs;

    public a(View view) {
        super(view);
        this.cSo = (ImageView) view.findViewById(n.g.icon_member_center);
        this.cSp = (TextView) view.findViewById(n.g.membership_title);
        this.cSq = (TbImageView) view.findViewById(n.g.icon_member_level);
        this.cSr = (TextView) view.findViewById(n.g.membership_hint);
        this.cSs = (ImageView) view.findViewById(n.g.membership_red_dot);
    }
}
