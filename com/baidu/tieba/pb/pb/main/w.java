package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class w extends q.a {
    public TextView bSR;
    public TextView emd;
    public HeadImageView fAx;
    public TbImageView fAy;
    public TextView fAz;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fAx = (HeadImageView) view.findViewById(d.g.photo);
        this.fAx.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds30));
        this.bSR = (TextView) view.findViewById(d.g.user_name);
        this.emd = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fAy = (TbImageView) view.findViewById(d.g.god_pic);
        this.fAz = (TextView) view.findViewById(d.g.god_btn);
    }
}
