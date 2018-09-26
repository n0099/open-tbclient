package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes2.dex */
public class w extends q.a {
    public TextView bYF;
    public TextView etu;
    public HeadImageView fHZ;
    public TbImageView fIa;
    public TextView fIb;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fHZ = (HeadImageView) view.findViewById(e.g.photo);
        this.fHZ.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0141e.ds30));
        this.bYF = (TextView) view.findViewById(e.g.user_name);
        this.etu = (TextView) view.findViewById(e.g.time);
        this.text = (TextView) view.findViewById(e.g.text);
        this.fIa = (TbImageView) view.findViewById(e.g.god_pic);
        this.fIb = (TextView) view.findViewById(e.g.god_btn);
    }
}
