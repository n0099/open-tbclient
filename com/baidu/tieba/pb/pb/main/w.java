package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class w extends q.a {
    public TextView chp;
    public TextView eCD;
    public HeadImageView fRa;
    public TbImageView fRb;
    public TextView fRc;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fRa = (HeadImageView) view.findViewById(e.g.photo);
        this.fRa.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0200e.ds30));
        this.chp = (TextView) view.findViewById(e.g.user_name);
        this.eCD = (TextView) view.findViewById(e.g.time);
        this.text = (TextView) view.findViewById(e.g.text);
        this.fRb = (TbImageView) view.findViewById(e.g.god_pic);
        this.fRc = (TextView) view.findViewById(e.g.god_btn);
    }
}
