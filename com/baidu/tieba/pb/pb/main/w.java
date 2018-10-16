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
    public TextView eBj;
    public HeadImageView fPA;
    public TbImageView fPB;
    public TextView fPC;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fPA = (HeadImageView) view.findViewById(e.g.photo);
        this.fPA.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), e.C0175e.ds30));
        this.chf = (TextView) view.findViewById(e.g.user_name);
        this.eBj = (TextView) view.findViewById(e.g.time);
        this.text = (TextView) view.findViewById(e.g.text);
        this.fPB = (TbImageView) view.findViewById(e.g.god_pic);
        this.fPC = (TextView) view.findViewById(e.g.god_btn);
    }
}
