package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class s extends j.a {
    public TextView bEL;
    public TextView cOa;
    public HeadImageView czX;
    public TextView drj;
    public TbImageView eKU;
    public TextView eKV;
    public int mSkinType;

    public s(View view) {
        super(view);
        this.mSkinType = 3;
        this.czX = (HeadImageView) view.findViewById(d.h.photo);
        this.czX.setRadius(com.baidu.adp.lib.util.k.g(view.getContext(), d.f.ds30));
        this.bEL = (TextView) view.findViewById(d.h.user_name);
        this.drj = (TextView) view.findViewById(d.h.time);
        this.cOa = (TextView) view.findViewById(d.h.text);
        this.eKU = (TbImageView) view.findViewById(d.h.god_pic);
        this.eKV = (TextView) view.findViewById(d.h.god_btn);
    }
}
