package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public TextView bHn;
    public HeadImageView cBI;
    public TextView cPU;
    public TextView dou;
    public TbImageView eFp;
    public TextView eFq;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.cBI = (HeadImageView) view.findViewById(d.h.photo);
        this.cBI.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), d.f.ds30));
        this.bHn = (TextView) view.findViewById(d.h.user_name);
        this.dou = (TextView) view.findViewById(d.h.time);
        this.cPU = (TextView) view.findViewById(d.h.text);
        this.eFp = (TbImageView) view.findViewById(d.h.god_pic);
        this.eFq = (TextView) view.findViewById(d.h.god_btn);
    }
}
