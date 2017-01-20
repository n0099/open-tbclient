package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class df extends y.a {
    public HeadImageView bQc;
    public TextView blu;
    public TextView cOh;
    public TextView cjL;
    public TbImageView ejX;
    public TextView ejY;
    public int mSkinType;

    public df(View view) {
        super(view);
        this.mSkinType = 3;
        this.bQc = (HeadImageView) view.findViewById(r.h.photo);
        this.bQc.setRadius(com.baidu.adp.lib.util.k.e(view.getContext(), r.f.ds30));
        this.blu = (TextView) view.findViewById(r.h.user_name);
        this.cOh = (TextView) view.findViewById(r.h.time);
        this.cjL = (TextView) view.findViewById(r.h.text);
        this.ejX = (TbImageView) view.findViewById(r.h.god_pic);
        this.ejY = (TextView) view.findViewById(r.h.god_btn);
    }
}
