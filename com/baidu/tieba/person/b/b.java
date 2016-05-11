package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class b extends y.a {
    public ImageView dBe;
    public TextView dBf;
    public TbImageView dBg;
    public TextView dBh;
    public ImageView dBi;

    public b(View view) {
        super(view);
        this.dBe = (ImageView) view.findViewById(t.g.icon_member_center);
        this.dBf = (TextView) view.findViewById(t.g.membership_title);
        this.dBg = (TbImageView) view.findViewById(t.g.icon_member_level);
        this.dBh = (TextView) view.findViewById(t.g.membership_hint);
        this.dBi = (ImageView) view.findViewById(t.g.membership_red_dot);
    }
}
