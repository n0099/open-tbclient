package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class w extends r.a {
    public TextView cPN;
    public TextView esN;
    public HeadImageView fMd;
    public TbImageView fMe;
    public TextView fMf;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fMd = (HeadImageView) view.findViewById(d.g.photo);
        this.fMd.setRadius(com.baidu.adp.lib.util.l.s(view.getContext(), d.e.ds30));
        this.cPN = (TextView) view.findViewById(d.g.user_name);
        this.esN = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.fMe = (TbImageView) view.findViewById(d.g.god_pic);
        this.fMf = (TextView) view.findViewById(d.g.god_btn);
    }
}
