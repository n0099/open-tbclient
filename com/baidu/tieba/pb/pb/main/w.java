package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class w extends j.a {
    public TextView bWx;
    public HeadImageView cTb;
    public TextView dEf;
    public TbImageView eWF;
    public TextView eWG;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.cTb = (HeadImageView) view.findViewById(d.g.photo);
        this.cTb.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), d.e.ds30));
        this.bWx = (TextView) view.findViewById(d.g.user_name);
        this.dEf = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.eWF = (TbImageView) view.findViewById(d.g.god_pic);
        this.eWG = (TextView) view.findViewById(d.g.god_btn);
    }
}
