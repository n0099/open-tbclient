package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends x.a {
    public ImageView dxZ;
    public TextView dya;
    public TbImageView dyb;
    public TextView dyc;
    public ImageView dyd;

    public b(View view) {
        super(view);
        this.dxZ = (ImageView) view.findViewById(t.g.icon_member_center);
        this.dya = (TextView) view.findViewById(t.g.membership_title);
        this.dyb = (TbImageView) view.findViewById(t.g.icon_member_level);
        this.dyc = (TextView) view.findViewById(t.g.membership_hint);
        this.dyd = (ImageView) view.findViewById(t.g.membership_red_dot);
    }
}
