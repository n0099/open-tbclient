package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class w extends j.a {
    public TextView bWF;
    public HeadImageView cTq;
    public TextView dFn;
    public TbImageView eXN;
    public TextView eXO;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.cTq = (HeadImageView) view.findViewById(d.g.photo);
        this.cTq.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds30));
        this.bWF = (TextView) view.findViewById(d.g.user_name);
        this.dFn = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.eXN = (TbImageView) view.findViewById(d.g.god_pic);
        this.eXO = (TextView) view.findViewById(d.g.god_btn);
    }
}
