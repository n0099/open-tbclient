package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class u extends j.a {
    public TextView bOy;
    public HeadImageView cJE;
    public TextView dwq;
    public TbImageView eOf;
    public TextView eOg;
    public int mSkinType;
    public TextView text;

    public u(View view) {
        super(view);
        this.mSkinType = 3;
        this.cJE = (HeadImageView) view.findViewById(d.g.photo);
        this.cJE.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds30));
        this.bOy = (TextView) view.findViewById(d.g.user_name);
        this.dwq = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.eOf = (TbImageView) view.findViewById(d.g.god_pic);
        this.eOg = (TextView) view.findViewById(d.g.god_btn);
    }
}
