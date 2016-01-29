package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends x.a {
    public TbImageView ddA;
    public TextView ddB;
    public ImageView ddC;
    public ImageView ddy;
    public TextView ddz;

    public b(View view) {
        super(view);
        this.ddy = (ImageView) view.findViewById(t.g.icon_member_center);
        this.ddz = (TextView) view.findViewById(t.g.membership_title);
        this.ddA = (TbImageView) view.findViewById(t.g.icon_member_level);
        this.ddB = (TextView) view.findViewById(t.g.membership_hint);
        this.ddC = (ImageView) view.findViewById(t.g.membership_red_dot);
    }
}
