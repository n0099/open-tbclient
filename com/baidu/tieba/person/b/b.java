package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class b extends y.a {
    public TbImageView ejJ;
    public TextView ejK;
    public TextView ejL;

    public b(View view) {
        super(view);
        this.ejJ = (TbImageView) view.findViewById(u.g.icon_member_center);
        this.ejK = (TextView) view.findViewById(u.g.membership_title);
        this.ejL = (TextView) view.findViewById(u.g.membership_hint);
    }
}
