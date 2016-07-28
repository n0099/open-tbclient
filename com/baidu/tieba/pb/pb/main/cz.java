package com.baidu.tieba.pb.pb.main;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cz extends y.a {
    public TextView aPR;
    public HeadImageView bPu;
    public TextView cJr;
    public TextView chq;
    public TbImageView ecQ;
    public TextView ecR;
    public int mSkinType;

    public cz(View view) {
        super(view);
        this.mSkinType = 3;
        this.bPu = (HeadImageView) view.findViewById(u.g.photo);
        this.bPu.setRadius(com.baidu.adp.lib.util.k.c(view.getContext(), u.e.ds40));
        this.aPR = (TextView) view.findViewById(u.g.user_name);
        this.cJr = (TextView) view.findViewById(u.g.time);
        this.chq = (TextView) view.findViewById(u.g.text);
        this.ecQ = (TbImageView) view.findViewById(u.g.god_pic);
        this.ecR = (TextView) view.findViewById(u.g.god_btn);
    }
}
