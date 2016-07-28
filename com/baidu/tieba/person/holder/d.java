package com.baidu.tieba.person.holder;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class d extends y.a {
    public TbImageView euj;
    public TextView euk;
    public TextView eul;

    public d(View view) {
        super(view);
        this.euj = (TbImageView) view.findViewById(u.g.icon_member_center);
        this.euk = (TextView) view.findViewById(u.g.membership_title);
        this.eul = (TextView) view.findViewById(u.g.membership_hint);
    }
}
