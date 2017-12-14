package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class w extends j.a {
    public TextView bWB;
    public HeadImageView cTm;
    public TextView dFj;
    public TbImageView eXI;
    public TextView eXJ;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.cTm = (HeadImageView) view.findViewById(d.g.photo);
        this.cTm.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds30));
        this.bWB = (TextView) view.findViewById(d.g.user_name);
        this.dFj = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.eXI = (TbImageView) view.findViewById(d.g.god_pic);
        this.eXJ = (TextView) view.findViewById(d.g.god_btn);
    }
}
