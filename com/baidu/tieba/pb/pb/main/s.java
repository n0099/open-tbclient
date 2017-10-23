package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public TextView bHb;
    public HeadImageView cBw;
    public TextView cPI;
    public TextView doh;
    public TbImageView eFb;
    public TextView eFc;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.cBw = (HeadImageView) view.findViewById(d.h.photo);
        this.cBw.setRadius(com.baidu.adp.lib.util.l.f(view.getContext(), d.f.ds30));
        this.bHb = (TextView) view.findViewById(d.h.user_name);
        this.doh = (TextView) view.findViewById(d.h.time);
        this.cPI = (TextView) view.findViewById(d.h.text);
        this.eFb = (TbImageView) view.findViewById(d.h.god_pic);
        this.eFc = (TextView) view.findViewById(d.h.god_btn);
    }
}
