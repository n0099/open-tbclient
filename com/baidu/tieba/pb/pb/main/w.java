package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class w extends q.a {
    public TextView bRW;
    public TextView ein;
    public HeadImageView fAl;
    public TbImageView fAm;
    public TextView fAn;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fAl = (HeadImageView) view.findViewById(d.g.photo);
        this.fAl.setRadius(com.baidu.adp.lib.util.l.e(view.getContext(), d.e.ds30));
        this.bRW = (TextView) view.findViewById(d.g.user_name);
        this.ein = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fAm = (TbImageView) view.findViewById(d.g.god_pic);
        this.fAn = (TextView) view.findViewById(d.g.god_btn);
    }
}
