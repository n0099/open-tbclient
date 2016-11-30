package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class db extends y.a {
    public TextView aYg;
    public HeadImageView ceb;
    public TextView cyf;
    public TextView dcb;
    public TbImageView ewK;
    public TextView ewL;
    public int mSkinType;

    public db(View view) {
        super(view);
        this.mSkinType = 3;
        this.ceb = (HeadImageView) view.findViewById(r.g.photo);
        this.ceb.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.e.ds30));
        this.aYg = (TextView) view.findViewById(r.g.user_name);
        this.dcb = (TextView) view.findViewById(r.g.time);
        this.cyf = (TextView) view.findViewById(r.g.text);
        this.ewK = (TbImageView) view.findViewById(r.g.god_pic);
        this.ewL = (TextView) view.findViewById(r.g.god_btn);
    }
}
