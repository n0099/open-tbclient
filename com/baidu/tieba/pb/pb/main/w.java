package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class w extends v.a {
    public TextView dBb;
    public TextView gcX;
    public HeadImageView hrP;
    public TbImageView hrQ;
    public TextView hrR;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.hrP = (HeadImageView) view.findViewById(d.g.photo);
        this.hrP.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), d.e.ds30));
        this.dBb = (TextView) view.findViewById(d.g.user_name);
        this.gcX = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.hrQ = (TbImageView) view.findViewById(d.g.god_pic);
        this.hrR = (TextView) view.findViewById(d.g.god_btn);
    }
}
