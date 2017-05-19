package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class ds extends y.a {
    public HeadImageView bXq;
    public TextView but;
    public TextView cLo;
    public TextView ciW;
    public TbImageView ejp;
    public TextView ejq;
    public int mSkinType;

    public ds(View view) {
        super(view);
        this.mSkinType = 3;
        this.bXq = (HeadImageView) view.findViewById(w.h.photo);
        this.bXq.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), w.f.ds30));
        this.but = (TextView) view.findViewById(w.h.user_name);
        this.cLo = (TextView) view.findViewById(w.h.time);
        this.ciW = (TextView) view.findViewById(w.h.text);
        this.ejp = (TbImageView) view.findViewById(w.h.god_pic);
        this.ejq = (TextView) view.findViewById(w.h.god_btn);
    }
}
