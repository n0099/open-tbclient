package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
/* loaded from: classes2.dex */
public class w extends q.a {
    public TextView bSQ;
    public TextView elZ;
    public HeadImageView fAq;
    public TbImageView fAr;
    public TextView fAs;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.fAq = (HeadImageView) view.findViewById(f.g.photo);
        this.fAq.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), f.e.ds30));
        this.bSQ = (TextView) view.findViewById(f.g.user_name);
        this.elZ = (TextView) view.findViewById(f.g.time);
        this.text = (TextView) view.findViewById(f.g.text);
        this.fAr = (TbImageView) view.findViewById(f.g.god_pic);
        this.fAs = (TextView) view.findViewById(f.g.god_btn);
    }
}
