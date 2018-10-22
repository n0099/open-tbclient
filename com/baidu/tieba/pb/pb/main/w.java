package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
/* loaded from: classes6.dex */
public class w extends q.a {
    public TextView chf;
    public TextView eBk;
    public HeadImageView fPB;
    public TbImageView fPC;
    public TextView fPD;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fPB = (HeadImageView) view.findViewById(e.g.photo);
        this.fPB.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0175e.ds30));
        this.chf = (TextView) view.findViewById(e.g.user_name);
        this.eBk = (TextView) view.findViewById(e.g.time);
        this.text = (TextView) view.findViewById(e.g.text);
        this.fPC = (TbImageView) view.findViewById(e.g.god_pic);
        this.fPD = (TextView) view.findViewById(e.g.god_btn);
    }
}
