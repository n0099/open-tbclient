package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class w extends v.a {
    public TextView eeA;
    public TextView gcL;
    public HeadImageView hrw;
    public TbImageView hrx;
    public TextView hry;
    public int mSkinType;
    public TextView text;

    public w(View view) {
        super(view);
        this.mSkinType = 3;
        this.hrw = (HeadImageView) view.findViewById(d.g.photo);
        this.hrw.setRadius(com.baidu.adp.lib.util.l.h(view.getContext(), d.e.ds30));
        this.eeA = (TextView) view.findViewById(d.g.user_name);
        this.gcL = (TextView) view.findViewById(d.g.time);
        this.text = (TextView) view.findViewById(d.g.text);
        this.hrx = (TbImageView) view.findViewById(d.g.god_pic);
        this.hry = (TextView) view.findViewById(d.g.god_btn);
    }
}
