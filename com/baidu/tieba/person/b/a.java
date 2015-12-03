package com.baidu.tieba.person.b;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends x.a {
    public ImageView cNI;
    public TextView cNJ;
    public TbImageView cNK;
    public TextView cNL;
    public ImageView cNM;

    public a(View view) {
        super(view);
        this.cNI = (ImageView) view.findViewById(n.f.icon_member_center);
        this.cNJ = (TextView) view.findViewById(n.f.membership_title);
        this.cNK = (TbImageView) view.findViewById(n.f.icon_member_level);
        this.cNL = (TextView) view.findViewById(n.f.membership_hint);
        this.cNM = (ImageView) view.findViewById(n.f.membership_red_dot);
    }
}
